# 1. class Main


   In the main method we initialize the grid with maximum size 1000 and set its width and height with values provided
by the user. The generation zero values are then accepted together with the coordinates of the observed cell and 
the total number of generations. The rules for the next generation of the grid are implemented in method:
void startGenerations () from class GridGenerator.
    
# 2. class Grid

   This class implements the idea of a 2D grid by having a two-dimensional array of characters .
The grid's width and height is provided by the console input and its correctness is secured
by the methods from class CorrectNumerChecker. By method: void cellForSearching (), the user
can provide coordinates of the cell which content is going to be examined during the generations.
There is also a method for printing out the grid - void printGridContent().

# 3. class GridGenerator

   This class encapsulates functionality related to the primary generation of the grid. The main algorithm is
  implemented in void generationZero () method. The initial content is provided by the console input. The number
  of subsequent generations is also specified by the user. Each generation begins with checking whether the chosen
  cell is red or green. Then we should iterate through each grid's cell and check its neighbouring cells.
  The current value of the cell is stored in the variable - checkedCellVal.
  
   First we check if we have a neighbour to the right or left, increase the green counter and raise a flag accordingly.
 After that we can check whether there is a neighbouring cell above the current cell and in case it is green we increase 
 the counter. Being in the upper row we have two potential neighbours - to the upper left  and right diagonals.
 Here the raised flags will help us decide if we should check right, left or both diagonals. Then we can can move
 to the lower row and also use these approach. 
 
   After going through all the neighbouring cells, we have the information about how many of them are green. If the
 current cell was red and had 3 or 6 green neighbours, in the next generation its color should becomegreen (value should be 1).
 On the other hand, if the current cell was green and had 0,1,4,5,7 or 8 green neighbours, in the next generation
 its color should become red. So we have to save current cell's coordinates and future color by creating an instance
 of class SingleCell and add its reference to an ArrayList of cells (cellsForConversion) which are going to have their
 colored changed in the next generation.
 
   After iterating through each cell of the grid we can update the content of the grid by calling method: void updateGrid ().
 Final result is displayed by calling  method:void displayResult ().

# 4. class SingleCell

  Objects of this class represent a single cell from the grid with corresponding x, y coordiantes and color.
     
# 5. class CorrectNumberChecker

   We should gurantee that the input of the user is correct and our game will not crash. Method:
  boolean check (int inputNumber) assures that the provided number is in the specified range.
  Method: int detailedChecks (), catches exceptions caused by wrong input from the user related
  to entering letters or words where integer numbers are expected.
    

