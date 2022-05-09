public class Ship {
    private final int length;

    public Ship(int length) {
        this.length = length;
    }

    public void placeShip(Board board, int x, int y)
            throws AlreadyPlacedException, OutOfBoardException {
        if (y + length >= board.getBoard().length) {
            throw new OutOfBoardException();
        }
        // horizontal/vertikal?
        for (int i = 0; i < length; i++) {
            board.getBoard()[x - 1][y - 1 + i] = '#';
        }
    }

    public int getLength() {
        return this.length;
    }
}
