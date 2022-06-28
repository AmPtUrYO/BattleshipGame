package connection;

import GameUnit.*;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

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
        BattleshipGame game = new DistributedBattleshipGame(10, 1);

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


        }


        System.out.println("all Ships placed");
        connection.streamCreated(tcpStream);
        connection.sendMessage("other Player ready");
        //waiting loop
        while (true){
            String message = connection.getLastMessage();
            if(message != null){
                break;
            }
            System.out.println("waiting");
            //timer
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        int state = 1;
        while (game.getPlayer(player).getOwnBoard().shipsLeft() > 0){
            state = turn(game, state, connection, player);
        }
        System.out.println("all ships gone");
        connection.sendMessage("you win");
        System.out.println("you lose");



    }

    public static int turn(BattleshipGame game, int playerOnTurn, Connection connection, int player){
        int otherPlayer = playerOnTurn == 1 ? 2 : 1;
        System.out.println("Player " + playerOnTurn + " shoot");
        connection.sendMessage("Player " + playerOnTurn + " shoot");
        String message;
        int[] coordinates;

        if(playerOnTurn == player){ // player shoots
            System.out.println("your turn");

            while (true){
                coordinates = getUserInput();
                connection.sendMessage(intToString(coordinates));
                message = connection.getLastMessage();
                if(message.equals("Hit!") || message.equals("miss!")){
                    break;
                }
                }
            if(message.equals("Hit!")){
                game.getPlayer(player).getOpponentBoard().hit(coordinates);
            }else {
                game.getPlayer(player).getOpponentBoard().miss(coordinates);
            }

            System.out.println("opponent board");
            game.getPlayer(playerOnTurn).getOpponentBoard().displayBoard();
        }else{ //other player shoots
            System.out.println("wait for opponents turn");
            while (true){
                try {
                    coordinates = stringToInt(connection.getLastMessage());
                    if(game.shoot(game.getPlayer(player).getOwnBoard(), game.getPlayer(player).getOpponentBoard(), coordinates[0], coordinates[1])){
                        System.out.println("Hit!");
                        connection.sendMessage("Hit!");
                    }else{
                        System.out.println("miss!");
                        connection.sendMessage("miss!");
                    }
                    break;
                } catch (NumberFormatException | OutOfBoardException e) {
                    connection.sendMessage("please enter coordinates that are on the field");
                } catch (AlreadyPlacedException e) {
                    connection.sendMessage("already shot");
                }
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

    }
        System.out.println("own Board");
        game.getPlayer(player).getOwnBoard().displayBoard();
        System.out.println("opponent Board");
        game.getPlayer(player).getOpponentBoard().displayBoard();
        return otherPlayer;
    }

    public static String intToString(int[] array){
        return Arrays.toString(array);
    }

    public static int[] stringToInt(String string) throws NumberFormatException{
        String[] strings = string.replace("[", "").replace("]", "").split(", ");
        int[] result = new int[strings.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = Integer.parseInt(strings[i]);
        }
        return result;
    }


}
