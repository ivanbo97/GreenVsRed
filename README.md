# 1. class Grid

  This class implements the idea of a 2D grid by having a two-dimensional array of characters . The grid's width and height is provided by the console input and its 
  correctness is secured by the methods from class CorrectNumerChecker. By method: void cellForSearching (), the user can provide coordinates of the cell which content
  is going to be examined during the generations. There is also a method for printing out the grid - void printGridContent().

# 2. class GridGenerator

  This class encapsulates functionality related to the primary generation of the grid. The main algorithm is implemented in void generationZero () method. The initial content is
provided by the console input. The number of subsequent generations is also specified by the user. Each generation begins with checking whether the chosen cell is red or
green. Then we should iterate through each grid's cell and check its neighbouring cells. The current value of the cell is stored in the variable - checkedCellVal.
    First we check if we have a neighbour to the right or left, increase the green counter and raise a flag accordingly. After that we can check whether there is a
neighbouring cell above the current cell and in case it is green we increase the counter. Being in the upper row we have two potential neighbours - to the upper left and
right diagonals. Here the raised flags will help us decide if we should check right, left or both diagonals. Then we can can move to the lower row and also use these 
approach. 
    After going through all the neighbouring cells, we have the information about how many of them are green. If the current cell was red and had 3 or 6 green 
neighbours, in the next generation its color should become green (value should be 1). On the other hand, if the current cell was green and had 0,1,4,5,7 or 8 green
neighbours, in the next generation its color should become red. So we have to save current cell's coordinates and future color by creating an instance
of class SingleCell and add its reference to an ArrayList of cells (cellsForConversion) which are going to have their colored changed in the next generation.
After iterating through each cell of the grid we can update the content of the grid by calling method: void updateGrid (). Final result is displayed by calling method:
void displayResult ().
