class Queen extends Rook { 
    // Empty constructor
    public Queen(String color, char column, int row) {
        super(color, column, row);
        this.pieceName = "Queen"; // polymorphism
    }

    @Override
    public boolean verifyMove(char newX, int newY) {
        return super.verifyMove(newX, newY) || Math.abs(this.column - newX) == Math.abs(this.row - newY);
    }
}
