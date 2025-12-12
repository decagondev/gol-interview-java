# Conway's Game of Life - Java Coding Challenge

## Overview
Implement Conway's Game of Life, a cellular automaton simulation where cells live, die, or multiply based on simple rules. This challenge tests your ability to work with 2D arrays, implement algorithms, and handle GUI programming with Java Swing.

## The Rules
Conway's Game of Life follows these rules for each generation:

1. **Survival**: A live cell with 2 or 3 live neighbors survives to the next generation
2. **Death by Isolation**: A live cell with fewer than 2 live neighbors dies
3. **Death by Overcrowding**: A live cell with more than 3 live neighbors dies
4. **Birth**: A dead cell with exactly 3 live neighbors becomes alive

Neighbors are the 8 cells surrounding a given cell (horizontally, vertically, and diagonally).

## Requirements

### Grid
- Create a 30×40 grid of cells
- Each cell can be either alive (filled) or dead (empty)
- Users should be able to click cells to toggle them on/off when the simulation is stopped

### Controls
Implement the following buttons:
- **Start**: Begin the simulation (advance generations automatically)
- **Stop**: Pause the simulation
- **Clear**: Reset the grid to all dead cells
- **Random**: Fill the grid with a random pattern

### Additional Features
- **Speed Control**: A slider to adjust simulation speed (50ms to 1000ms between generations)
- **Generation Counter**: Display the current generation number
- **Button States**: Disable/enable buttons appropriately (e.g., can't clear while running)

## Technical Specifications

### Grid Dimensions
- Rows: 30
- Columns: 40
- Cell size: 15px × 15px

### Data Structure
- Use a 2D boolean array to represent the grid state
- `true` = alive cell, `false` = dead cell

### Algorithm
- For each generation, calculate the next state based on the current state
- Count neighbors for each cell (check all 8 surrounding cells)
- Apply the rules to determine which cells live or die
- Update the entire grid simultaneously (don't update cells one at a time)

## Setup

### Prerequisites
- Java Development Kit (JDK) 8 or higher
- Any Java IDE (IntelliJ IDEA, Eclipse, VS Code, etc.) or command line compiler

### Compilation and Execution
```bash
# Compile the Java file
javac GameOfLife.java

# Run the application
java GameOfLife
```

Or use your IDE's run/debug functionality.

## Files Provided

### `GameOfLife.java`
Starter code with:
- Complete Swing GUI setup and window initialization
- Button and UI element definitions
- Drawing functions for grid, buttons, and info
- Event handling structure
- Method stubs for you to implement

## What You Need to Implement

Complete the following methods in the `GameOfLife` class:

1. **`initGrid()`** - Initialize the grid array with all dead cells
2. **`countNeighbors(row, col)`** - Count live neighbors for a given cell
3. **`nextGeneration()`** - Apply Game of Life rules and update the grid
4. **`toggleCell(row, col)`** - Toggle a cell's state when clicked
5. **`start()`** - Begin the simulation
6. **`stop()`** - Pause the simulation
7. **`clear()`** - Reset the grid
8. **`randomize()`** - Generate a random pattern
9. **`updateSpeed(value)`** - Handle speed slider changes

## Tips

- Remember to create a **new grid** for the next generation rather than modifying the current one in place
- Don't forget to check array bounds when counting neighbors
- Use `javax.swing.Timer` for automatic generation advancement (already set up)
- Make sure to call `gridPanel.repaint()` after updating the grid to refresh the display
- The grid is accessed as `grid[row][col]` where `row` is 0-29 and `col` is 0-39
- Use `new boolean[ROWS][COLS]` to create a 2D boolean array
- Call `updateGeneration()` after changing the generation count
- Use `timer.start()` and `timer.stop()` to control the simulation
- Use `timer.setDelay(milliseconds)` to update the speed

## Evaluation Criteria

Your solution will be evaluated on:
- **Correctness**: Does it follow the Game of Life rules accurately?
- **Code Quality**: Is the code clean, readable, and well-organized?
- **Edge Cases**: Does it handle boundary conditions properly?
- **User Experience**: Do the controls work smoothly?
- **Efficiency**: Is the algorithm reasonably performant?
- **Java Best Practices**: Proper use of Java conventions, access modifiers, and Swing patterns

## Time Limit
You have **20-30 minutes** to complete this challenge.

## Testing Your Solution

Try these patterns to verify your implementation:
- **Blinker**: 3 horizontal cells that oscillate between horizontal and vertical
- **Glider**: A 5-cell pattern that moves across the grid diagonally
- **Block**: A 2×2 square that remains stable

To test patterns manually:
1. Stop the simulation
2. Click cells to create the pattern
3. Start the simulation and observe the behavior

## Example Patterns

### Blinker (Oscillator)
```
[ ][ ][ ]
[#][#][#]
[ ][ ][ ]
```

### Glider
```
[ ][#][ ]
[ ][ ][#]
[#][#][#]
```

### Block (Still Life)
```
[#][#]
[#][#]
```

## Swing-Specific Notes

- The `Timer` class is already initialized and configured
- Use `gridPanel.repaint()` to refresh the grid display
- Button states are managed through `setEnabled(boolean)`
- Mouse clicks are handled in the `MouseAdapter` - you just need to implement `toggleCell()`
- The `drawGrid()` method is already implemented - it reads from the `grid` array
- All UI components are already set up - focus on implementing the game logic

Good luck!

