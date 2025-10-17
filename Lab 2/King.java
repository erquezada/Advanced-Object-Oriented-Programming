class King extends Queen {
    // Empty constructor
    public King(String color, char column, int row) {
        super(color, column, row);
        this.pieceName = "King"; // polymorphism
    }

    @Override
    public boolean verifyMove(char newX, int newY) {
        return Math.abs(this.column - newX) <= 1 && Math.abs(this.row - newY) <= 1;
    }
}
