
import java.util.Scanner;


public class Grid {
    private int width;
    private int height;
    private char[][] gridContent;
    private int maxSize;
    Scanner scan;
    private GridGenerator gridGenerator;

    private int xCoordinateInput;
    private int yCoordinateInput;
    public Grid(int maxSize) {
        this.maxSize = maxSize;
        scan = new Scanner(System.in);
        gridGenerator = new GridGenerator(this);
    }

    public void setWidth ()
    {
        System.out.println("Enter grid's width (valid input - [1, "+ height + "] ) :");
        CorrectNumberChecker checker = new CorrectNumberChecker(1,height+1 );
        width = checker.detailedChecks();
        System.out.println("The value you have entered is accepted!");
        gridContent = new char[height][width];
    }

    public void setHeight ()
    {

        CorrectNumberChecker checker = new CorrectNumberChecker(1,maxSize);
        System.out.println("Enter grid's height (valid input - [1,1000) ) : ");
        height = checker.detailedChecks();
        System.out.println("The value you have entered is accepted!");

    }
    public void printGridContent()
    {
        System.out.println("Grid Content:");
        for(int i=0;i<height;i++)
        {
            for (int j=0;j<width;j++)
            {
                System.out.print(gridContent[i][j] +" ");
            }
            System.out.println();
        }

    }

    public void cellForSearching ()
    {

        CorrectNumberChecker checker = new CorrectNumberChecker();
        //check for correctness of row input
        checker.setLowerLimit(0);
        checker.setUpperLimit(height);
        System.out.println("Enter x coordinate value of a cell (range is [0," + height + ") )");
        xCoordinateInput = checker.detailedChecks();

        //check for correctness of column input

        checker.setLowerLimit(0);
        checker.setUpperLimit(width);
        System.out.println("Enter y coordinate value (range is [0," + width + ") )");
        yCoordinateInput = checker.detailedChecks();


    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public char[][] getGridContent() {
        return gridContent;
    }

    public GridGenerator getGridGenerator() {
        return gridGenerator;
    }

    public int getxCoordinateInput() {
        return xCoordinateInput;
    }

    public int getyCoordinateInput() {
        return yCoordinateInput;
    }

    public char getCellValue(int xCoodinate, int yCoordinate){
        return gridContent[yCoordinate][xCoodinate];
    }
}
