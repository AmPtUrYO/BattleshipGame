package GameUnit;

import java.util.Scanner;

public class StartGame {
    public static void main(String[] args) {
        System.out.println("Start new game");
        BattleshipGame game = new BattleshipGame(10, 2);
        System.out.println("Player 1 place Ships");

        for (int i = 0; i < game.player1Ships.length; i++) {
            while (true) {
                try {
                    int[] coordinates = getUserInput();
                    game.placeShip(game.player1Board, game.player1Ships[i], coordinates[0], coordinates[1]);
                    break;
                } catch (AlreadyPlacedException | OutOfBoardException e) {
                    e.printStackTrace();
                }
            }
            game.player1Board.displayBoard();
        }
        System.out.println("all Ships placed");


        System.out.println("Player 2 shoot");
        while (game.player1Board.ships > 0){
            while (true) {
                try {
                    int[] coordinates = getUserInput();
                    if (game.shoot(game.player2Board, game.player1Board, coordinates[0], coordinates[1])) {
                        System.out.println("Hit!");
                    } else {
                        System.out.println("miss!");
                    }
                    break;
                } catch (AlreadyPlacedException | OutOfBoardException e) {
                    e.printStackTrace();
                }
            }
            game.player2Board.displayBoard();
        }
        System.out.println("all ships gone");


    }

    public static int[] getUserInput(){
        int[] coordinates = new int[2];
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        if(input.length() > 3){
            System.out.println("wrong input, try again");
            getUserInput();
        }

        int y = charToInt(input.toUpperCase().charAt(0));
        int x = Integer.parseInt(input.replaceAll("[\\D]", "")) - 1;
        coordinates[0] = x;
        coordinates[1] = y;
        return coordinates;
    }

    public static int charToInt(char y){ // takes capital letter and makes it into int (A = 0)
        return (int) y - 65;
    }

}
