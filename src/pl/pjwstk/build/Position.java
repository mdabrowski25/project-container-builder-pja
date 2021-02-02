package pl.pjwstk.build;

public class Position {
    private int row;
    private int column;
    private int level;

    public Position(int row, int column, int level) {
        this.column = column;
        this.level = level;
        this.row = row;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public int getLevel() {
        return level;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "row: " + row +
                "  column: " + column +
                "  level: " + level;
    }
}
