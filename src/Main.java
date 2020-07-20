public class Main {

    public static void main(String[] args) {
        Grid grid = new Grid(1000);
        grid.setHeight();
        grid.setWidth();
        grid.getGridGenerator().generationZero();
        grid.printGridContent();
        grid.cellForSearching();
        grid.getGridGenerator().setNumberOfGenerations();
        grid.getGridGenerator().startGenerations();
    }
}
