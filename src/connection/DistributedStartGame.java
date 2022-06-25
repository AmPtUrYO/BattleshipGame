package connection;

import GameUnit.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class DistributedStartGame extends StartGame {
    public static final int PORTNUMBER = 7777;

    public static void main(String[] args) {
        Connection connection = new Connection();
        TCPStream tcpStream;

        int player;

        if(args.length > 0) {
            System.out.println("init as TCP client");
            tcpStream = new TCPStream(PORTNUMBER, false, "Client");
            player = 2;
        } else {
            System.out.println("init as TCP server");
            tcpStream = new TCPStream(PORTNUMBER, true, "Server");
            player = 1;
        }

        tcpStream.start();

        System.out.println("Start new game");
        BattleshipGame game = new BattleshipGame(10, 1);

        System.out.println("Player " + player + " place Ships");
        for (int i = 0; i < game.getPlayer(player).getShips().length; i++) {
            while (true) {
                try {
                    int[] coordinates = getUserInput();
                    game.placeShip(game.getPlayer(player).getOwnBoard(), game.getPlayer(player).getShips()[i], coordinates[0], coordinates[1]);
                    break;
                } catch (AlreadyPlacedException| ArrayIndexOutOfBoundsException | OutOfBoardException e ) {
                    e.printStackTrace();
                }
            }
            game.getPlayer(player).getOwnBoard().displayBoard();
            connection.streamCreated(tcpStream);
            connection.sendMessage((byte) Symbol.WATER.getSymbol());
        }

        //send board
        //get board of other player

        System.out.println("all Ships placed");

        int state = 1;
        while (game.getPlayer(1).getOwnBoard().shipsLeft() > 0 && game.getPlayer(2).getOwnBoard().shipsLeft() > 0){
            state = turn(game, state, connection);
        }
        System.out.println("all ships gone");
        int winner = state == 1 ? 2 : 1;
        System.out.println("player " + winner + "wins");



    }

    public static int turn(BattleshipGame game, int player, Connection connection){
        int otherPlayer = player == 1 ? 2 : 1;
        System.out.println("Player " + player + " shoot");

        while (true) {
            try {
                int[] coordinates = getUserInput();
                if (game.shoot(game.getPlayer(player).getOpponentBoard(), game.getPlayer(otherPlayer).getOwnBoard(), coordinates[0], coordinates[1])) {
                    System.out.println("Hit!");
                    connection.sendMessage((byte) Symbol.HIT.getSymbol());
                } else {
                    System.out.println("miss!");
                    connection.sendMessage((byte) Symbol.MISS.getSymbol());
                }



                // send to other player

                break;
            } catch (AlreadyPlacedException | OutOfBoardException e) {
                e.printStackTrace();
                System.out.println("Wrong user input. Please enter a letter between A and " + "J" + "and a number between 1 and " + game.getPlayer(1).getOwnBoard().getBoardSize());
            }
        }

        game.getPlayer(player).getOpponentBoard().displayBoard();
        return otherPlayer;
    }


}
