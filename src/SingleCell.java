public class SingleCell {

    private int xCoordinate;
    private int yCoordinate;
    private char color;

    public SingleCell(int yCoordinate, int xCoordinate, char color) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.color = color;
    }

    public int getxCoordinate() {
        return xCoordinate;
    }

    public int getyCoordinate() {
        return yCoordinate;
    }

    public char getColor() {
        return color;
    }
}
