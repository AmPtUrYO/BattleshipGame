package GameUnit;

public interface GameUI {
    // game board: size fixed or adjustable?
/*Symbole:
      ~ water
      o miss
      X hit
      # ship
      */

// two game boards: own visible / opponent board hidden
// hidden: display every '#' as '~'

// actions:
// place ships (define size and number)
// shoot: out of board exception, bereits getroffen exception

// Status: Player A, Player B
// exception: not your turn
/* state
    turn: player A
    turn: player B
    game over
    error
*/
    /**
     * //@return true if ship was placed correctly
     * @throws OutOfBoardException when ship is placed outside of board,
     * @throws AlreadyPlacedException when ship is placed on top of other ship,
     */
    void placeShip(Board board, Ship ship, int x, int y)
            throws OutOfBoardException, AlreadyPlacedException;
    /**
     * @return true if hit, false if miss
     * @throws OutOfBoardException when coordinates are out of board,
     * @throws AlreadyPlacedException when already hit or miss,
     */
    boolean shoot(Board ownBoard, Board opponentBoard, int x, int y)
            throws OutOfBoardException, AlreadyPlacedException;
}
