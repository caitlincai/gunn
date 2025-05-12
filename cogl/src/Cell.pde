/*
 * There are two places to write code in the Cell tab:
 *   updateAlive()
 *   calculateNeighbors()
 */

class Cell {
  // instance fields
  public int col;
  public int row;
  
  private boolean amAlive = false;  // cell starts dead by default
  private int neighbors = 0;        // neighbors yet to be counted
  private final color DEAD_COLOR = color(#E8E8E8);
  private final color ALIVE_COLOR = color(#FF6600);
  
  // constructor
  public Cell(int row, int col) {
    this.col = col;
    this.row = row;
  }
  
  // methods
  public void toggleAlive() { amAlive = !amAlive; }
  public void setAlive(boolean alive) { amAlive = alive; }
  public boolean isAlive() { return amAlive; }
  
  public void display(int xoffset, int yoffset, int w, int h) {
    xoffset += (w+1) * col;
    yoffset += (h+1) * row;
    color fillColor = amAlive ? ALIVE_COLOR : DEAD_COLOR;
    fill(fillColor);
    rect(xoffset, yoffset, w, h);
  }
    
  // Set this cell to alive or dead based on current state
  // of amAlive and the number of live neighbors
  public void updateAlive() {
    // Try to figure out an expression using Boolean operator(s) such
    // as && and || along with neighbor count and current alive/dead state
    // to solve this without using if/else
    if ((isAlive() && (neighbors == 2 || neighbors == 3)) || (isAlive() == false && neighbors == 3)) {
        setAlive(true);
    }
    else if ((isAlive() && neighbors < 2) || (isAlive() && neighbors > 3))  {
        setAlive(false);
    }
    setAlive(isAlive()); 
  }
  
  // Compute the number of live neighbors for this cell 
  // and return that number
  public int calcNeighbors() {
      this.neighbors = 0;
    //YOUR CODE HERE

    for(int r = row - 1; r <= row + 1 ; r++){

        for(int c = col -1; c <= col + 1; c++){

            int correctRow = (r + ROWS) % ROWS;
            int correctCol = (c + COLS) % COLS;

                if(r != row || c != col){

                    if(cell[correctRow][correctCol].amAlive == true) this.neighbors++;
                }

        }
    }

     return this.neighbors;
    }
}
