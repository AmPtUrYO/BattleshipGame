package GameUnit;

import java.util.Scanner;

public class StartGame {
    public static void main(String[] args) {
        System.out.println("Start new game");
        BattleshipGame game = new BattleshipGame(10, 1);

        System.out.println("Player 1 place Ships");
        for (int i = 0; i < game.getPlayer(1).getShips().length; i++) {
            while (true) {
                try {
                    int[] coordinates = getUserInput();
                    game.placeShip(game.getPlayer(1).getOwnBoard(), game.getPlayer(1).getShips()[i], coordinates[0], coordinates[1]);
                    break;
                } catch (AlreadyPlacedException | OutOfBoardException e) {
                    e.printStackTrace();
                }
            }
            game.getPlayer(1).getOwnBoard().displayBoard();
        }

        System.out.println("Player 2 place Ships");
        for (int i = 0; i < game.getPlayer(2).getShips().length; i++) {
            while (true) {
                try {
                    int[] coordinates = getUserInput();
                    game.placeShip(game.getPlayer(2).getOwnBoard(), game.getPlayer(2).getShips()[i], coordinates[0], coordinates[1]);
                    break;
                } catch (AlreadyPlacedException | OutOfBoardException e) {
                    e.printStackTrace();
                }
            }
            game.getPlayer(2).getOwnBoard().displayBoard();
        }
        System.out.println("all Ships placed");

        int state = 1;
        while (game.getPlayer(1).getOwnBoard().shipsLeft() > 0 && game.getPlayer(2).getOwnBoard().shipsLeft() > 0){
            state = turn(game, state);
        }
        System.out.println("all ships gone");
        int winner = state == 1 ? 2 : 1;
        System.out.println("player " + winner + "wins");


    }

    public static int[] getUserInput(){
        int[] coordinates = new int[2];
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int y;
        int x;

        String letter = input.toUpperCase().replaceAll("[^a-zA-Z]", "");
        if(letter.length() == 1){
            y = charToInt(letter.charAt(0));
        }else{
            y = -1;
        }
        String number = input.replaceAll("[\\D]", "");
        if(number.length() > 0){
            x = Integer.parseInt(number) - 1;
        }else{
            x = -1;
        }
        coordinates[0] = x;
        coordinates[1] = y;
        return coordinates;
    }

    public static int charToInt(char y){ // takes capital letter and makes it into int (A = 0)
        return (int) y - 65;
    }

    public static int turn(BattleshipGame game, int player){
        int otherPlayer = player == 1 ? 2 : 1;
        System.out.println("Player " + player + " shoot");

        while (true) {
            try {
                int[] coordinates = getUserInput();
                if (game.shoot(game.getPlayer(player).getOpponentBoard(), game.getPlayer(otherPlayer).getOwnBoard(), coordinates[0], coordinates[1])) {
                    System.out.println("Hit!");
                } else {
                    System.out.println("miss!");
                }
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
