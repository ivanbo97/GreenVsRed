public class SingleCell {

    private int rowIdx;
    private int colIdx;
    private char color;

    public SingleCell(int rowIdx, int colIdx, char color) {
        this.rowIdx = rowIdx;
        this.colIdx = colIdx;
        this.color = color;
    }

    public int getRowIdx() {
        return rowIdx;
    }

    public int getColIdx() {
        return colIdx;
    }

    public char getColor() {
        return color;
    }
}
