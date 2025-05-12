/*
 * Created by JP (c. ????)
 * Edited by MB, JH, TK
 * Updated 04/29/21 by TK
 * Adapted 05/01/23 to Coding Rooms by TK
 * Edits:
 *   05/09/23 - Added instructions atop the CGoL and Cell tabs
 */

 /*
  * There is one place to write code in the CGoL tab:
  *   draw() [four parts]
  *
  * The "final test" is located in the setUpCells() method at
  * the bottom of this tab.
  */

// Here are some useful "constants"
final int ROWS = 40;
final int COLS = 60;
final int CELL_WIDTH = 15;
final int CELL_HEIGHT = 15;
final int LEFT_OFFSET = 12;  // From left of window to left side of grid
final int TOP_OFFSET = 12;   // From top of window to top of grid
// From top of window to bottom of grid
final int BOTTOM_GRID_OFFSET = TOP_OFFSET + (CELL_HEIGHT+1)*ROWS;
// From top of window to top of buttons
final int BUTTON_Y_OFFSET = BOTTOM_GRID_OFFSET + 12;
final int BUTTON_WIDTH = 100;
final int BUTTON_HEIGHT = 40;

// 2D Array of Cells
Cell[][] cell = new Cell[ROWS][COLS];

// state:
//   STOPPED  -> No animation
//   STEPPING -> Step one iteration
//   RUNNING  -> Play continuous iterations
enum STATE { STOPPED, STEPPING, RUNNING };
STATE state = STATE.STOPPED;

void setup() {
  // It turns out that numeric literals have to be entered 
  // into the first two arguments of the size() procedure.
  // The size cannot be determined by defined constants.
  size(1024, 768);
  
  // Initialize grid of cells
  initGrid();
  
  // Creates an initial state of the grid
  setUpCells();
  
  // Initialize font for drawing buttons
  initFont();
}

// draw() is effectively inside an infinite loop.
void draw() {
  background(#FFFFFF);
  stroke(#000000);
  
  // 1: step, 2: start
  if (state == STATE.STEPPING || state == STATE.RUNNING) {
    // Each cell determines how many neighbors it has (THERE IS A METHOD.)
       // YOUR_CODE_HERE
       for (Cell[] cellArray: cell) {
           for (Cell c: cellArray) {
                c.calcNeighbors();
           }
       }

    // Each cell updates its alive/dead status (THERE IS A METHOD.)
       // YOUR_CODE_HERE
       for (Cell[] cellArray: cell) {
           for (Cell c: cellArray) {
               c.updateAlive();
           }
       }

    // 50ms delay between animation updates (GOOGLE "delay processing")
    if (state == STATE.RUNNING) {
      // YOUR_CODE_HERE 
      delay(50);
    }
    
    // if done with single step, return to original state (STATE.STOPPED)
    if (state == STATE.STEPPING) {
      // YOUR_CODE_HERE  
      state = STATE.STOPPED;
    }
  }
 
  // All cells draw themselves as alive/dead on the grid
  displayCells();  
  
  // Draw buttons
  // Start, Stop, Clear rectangles in gray
  drawButtons();
}

// Calculates number of alive neighbors for ALL cells
void calcNeighbors() {
  for (int r = 0; r <= ROWS; r++) {
    for (int c = 0; c <= COLS; c++) {
      cell[r][c].calcNeighbors();
    }
  }
}

// Updates alive status for ALL cells
void updateAlive() {
  for (int r = 0; r < ROWS; r++) {
    for (int c = 0; c < COLS; c++) {
      cell[r][c].updateAlive();
    }
  }
}

// Displays ALL cells
void displayCells() {
  for (int r = 0; r < ROWS; r++) {
    for (int c = 0; c < COLS; c++) {
      cell[r][c].display(LEFT_OFFSET, TOP_OFFSET, CELL_WIDTH, CELL_HEIGHT);
    }
  }
}

// Draws the "gameplay" buttons on window
void drawButtons() {
  // Start, Stop, Clear rectangles in gray
  fill(#DDDDDD);
  for (int i = 0; i < 3; i++) {
    rect(LEFT_OFFSET+i*(BUTTON_WIDTH+12), BUTTON_Y_OFFSET, BUTTON_WIDTH, BUTTON_HEIGHT);
  }
  
  // Set text color on the buttons to blue
  fill(#0000FF);
  // Draw Start/Stop, Step, Clear text onto the gray buttons
  text((state == STATE.RUNNING) ? "Stop" : "Start", LEFT_OFFSET+50, BUTTON_Y_OFFSET+12); 
  text("Step", LEFT_OFFSET+50+BUTTON_WIDTH+12, BUTTON_Y_OFFSET+12); 
  text("Clear", LEFT_OFFSET+50+2*(BUTTON_WIDTH+12), BUTTON_Y_OFFSET+12); 
}

// Populates 2D array with Cell objects
void initGrid() {
  for (int r = 0; r < ROWS; r++) {
    for (int c = 0; c < COLS; c++) {
      cell[r][c] = new Cell(r, c);
    }
  }
}

// Creates initial state for the simulation
void setUpCells() {
  // Checkpoint #1 (blinker oscillator)
  cell[ROWS - 3][1].setAlive(true);
  cell[ROWS - 3][2].setAlive(true);
  cell[ROWS - 3][3].setAlive(true);
  
   //Final Test (glider spaceship located at the corners)
  cell[ROWS-1][COLS-1].setAlive(true);
  cell[ROWS-1][0].setAlive(true);
  cell[ROWS-1][1].setAlive(true);
  cell[0][1].setAlive(true);
  cell[1][0].setAlive(true);
}

// Initializes the default font
void initFont() {
  textSize(32);
  PFont font = createFont("ComicSansMS-Bold", 32);
  textFont(font);
  textAlign(CENTER, CENTER);
}
