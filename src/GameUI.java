public interface GameUI {
    // Spielfeld: Größe wird vorher festgelegt/variabel?
/*Symbole:
      ~ water
      O miss
      X hit
      # ship
      */

// Status Spielfeld: eigenes Spielfeld visible / gegnerisches Spielfeld hidden
// Spielfeld hidden: display every '#' as '~'

// Aktionen:
// Schiffe platzieren (Größe und Anzahl festlegen)
// schießen: out of bounds exception, bereits getroffen exception

// Status: Player A, Player B
// exception: not your turn
/* state
    turn: player A
    turn: player B
    game over
    error
*/
    /**
     * @return true if ship was placed correctly
     * @throws OutOfBoardException,
     * @throws AlreadyPlacedException,
     */
    boolean placeShip(Board board, Ship ship)
            throws OutOfBoardException, AlreadyPlacedException;
    /**
     * @return true if hit, false if miss
     * @throws OutOfBoardException,
     * @throws AlreadyPlacedException,
     */
    boolean shoot(Board board)
            throws OutOfBoardException, AlreadyPlacedException;
}
