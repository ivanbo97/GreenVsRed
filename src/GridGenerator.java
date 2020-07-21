import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class GridGenerator {

    private Grid grid;
    private Scanner scan = new Scanner(System.in);
    private int numberOfGenerations;
    private ArrayList <SingleCell> cellsForConversion;
    private int timesHasBeenGreen;
    private int timesHasBeenRed;
    private int greenNeighbours ;


    public GridGenerator(Grid grid) {
        this.grid = grid;
        cellsForConversion = new ArrayList<>();
        timesHasBeenGreen = 0;
        timesHasBeenRed = 0;
    }

    public void generationZero ()
    {
        boolean isInputCorrect ;
        int enteredNumber;

        //User should enter only zeroes and ones. The interval is [0,2)
        CorrectNumberChecker checker = new CorrectNumberChecker(0,2);

        int gridHeight = grid.getHeight();
        int gridWidth = grid.getWidth();
        char [][] gridArray = grid.getGridContent();
        for(int i=0;i<gridHeight;i++)
        {
            for (int j=0;j<gridWidth;j++)
            {
                do {
                    System.out.println("grid[" + i + "][" + j + "] = ");
                    try {
                        enteredNumber = (char) scan.nextInt();
                        isInputCorrect = checker.check(enteredNumber);
                        if(!isInputCorrect)
                            System.out.println("The entered number is out of the specified range! Please try again!");
                        else
                        {
                            if(enteredNumber == 1)
                                gridArray[i][j] = '1';
                            else
                                gridArray[i][j] = '0';
                        }
                        //Reading enter key press from buffer
                        scan.nextLine();

                    } catch (NoSuchElementException e) {
                        //Reading enter key press from buffer
                        scan.nextLine();
                        System.out.println("Invalid input! Please try again!");
                        isInputCorrect = false;
                    }
                }while (!isInputCorrect);
            }
        }
    }

    public void setNumberOfGenerations() {

        boolean isInputValid;
        do {
            System.out.println("Enter number of generations:");
            try {
                isInputValid = true;
                this.numberOfGenerations = scan.nextInt();
                scan.nextLine();
            } catch (NoSuchElementException e) {
                scan.nextLine();
                isInputValid = false;
                System.out.println("Invalid Input!!! Please try again.");
            }
        }while (!isInputValid);

    }

    public void startGenerations ()
    {
        char [][] gridContent = grid.getGridContent();
        int xCoordinateOfSearchCell = grid.getxCoordinateInput();
        int yCoordinateOfSearchCell = grid.getyCoordinateInput();
        int gridHeight = grid.getHeight();
        int gridWidth = grid.getWidth();
        char checkedCellVal;
        char currentCellVal;


        boolean hasLeftNeighbour ;
        boolean hasRightNeighbour ;

        for (int i=0 ; i<=numberOfGenerations ; i++)
        {
           if( gridContent[yCoordinateOfSearchCell][xCoordinateOfSearchCell] == '0')
               timesHasBeenRed++;
           else
               timesHasBeenGreen++;

            for (int rowIdx = 0; rowIdx < gridHeight; rowIdx++)
            {
                for (int colIdx = 0; colIdx < gridWidth; colIdx++)
                {
                    greenNeighbours = 0;
                    hasLeftNeighbour = false;
                    hasRightNeighbour = false;
                    checkedCellVal = gridContent[rowIdx][colIdx];
                    //Checking the neighbouring cells

                    //checking if there is a neighbour to the right
                    if (colIdx+1 <= gridWidth-1)
                    {
                        hasRightNeighbour =true;
                        currentCellVal = gridContent[rowIdx][colIdx+1];
                        checkForGreenNeighbours(currentCellVal);

                    }
                    //checking if there is a neighbour to the left
                    if (colIdx-1>=0)
                    {
                        hasLeftNeighbour = true;
                        currentCellVal = gridContent[rowIdx][colIdx-1];
                        checkForGreenNeighbours(currentCellVal);
                    }

                    //Checking if there are upper neighbours

                    if(rowIdx-1 >= 0)
                    {
                        //Upper neighbouring cell
                        currentCellVal= gridContent[rowIdx-1][colIdx];
                        checkForGreenNeighbours(currentCellVal);

                        /*If there was a neighbour to the right,
                        there will be also a neighbour to the upper right diagonal*/

                        if (hasRightNeighbour)
                        {
                            //Upper right diagonal
                            currentCellVal = gridContent[rowIdx-1][colIdx+1];
                            checkForGreenNeighbours(currentCellVal);
                        }
                         /*If there was a neighbour to the left,
                        there will be also a neighbour to the upper left diagonal*/
                        if(hasLeftNeighbour)
                        {
                            //Upper left diagonal
                            currentCellVal = gridContent[rowIdx-1][colIdx-1];
                            checkForGreenNeighbours(currentCellVal);
                        }
                    }

                    //Checking if there are lower neighbours
                    if(rowIdx+1 <= gridHeight -1)
                    {
                        //Lower neighbouring cell
                        currentCellVal = gridContent[rowIdx+1][colIdx];
                        if(currentCellVal == '1')
                            greenNeighbours++;
                        if (hasRightNeighbour)
                        {
                            //Lower right diagonal
                            currentCellVal = gridContent[rowIdx+1][colIdx+1];
                            checkForGreenNeighbours(currentCellVal);
                        }
                        if(hasLeftNeighbour)
                        {
                            //Lower left diagonal
                            currentCellVal = gridContent [rowIdx+1][colIdx-1];
                            checkForGreenNeighbours(currentCellVal);

                        }
                    }

                    if(checkedCellVal == '0')
                    {
                        //Save cells which values should be inverted
                        if (greenNeighbours == 3 || greenNeighbours == 6)
                            cellsForConversion.add (new SingleCell(rowIdx,colIdx,'1'));

                    }
                    else
                    {
                        if (greenNeighbours!=2 && greenNeighbours!=3 && greenNeighbours!=6)
                            cellsForConversion.add(new SingleCell(rowIdx,colIdx,'0'));
                    }
                }
            }
            /*Prepare the grid for next generation by updating the values and
              clearing the content of the array list*/
            updateGrid();
            cellsForConversion.clear();

        }

        displayResult();
    }

    public void updateGrid ()
    {
        char [][] gridContent = grid.getGridContent();
        int rowIdx , colIdx;
        //Loop through the cells which should be inverted
        for (SingleCell cell : cellsForConversion)
        {
             rowIdx = cell.getyCoordinate();
             colIdx = cell.getxCoordinate();
             gridContent[rowIdx][colIdx] = cell.getColor();
        }
    }

    public void displayResult ()
    {
        int xCoordinate = grid.getxCoordinateInput();
        int yCoordiante = grid.getyCoordinateInput();
        System.out.println("grid["+yCoordiante+"]["+ xCoordinate +"] times has been green: " + timesHasBeenGreen + " ; times has been red: " + timesHasBeenRed + " .");
    }

    public void checkForGreenNeighbours (char cellValue)
    {
        if(cellValue == '1')
            greenNeighbours++;
    }

}
