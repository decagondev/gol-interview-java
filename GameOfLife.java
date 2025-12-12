import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

/**
 * Conway's Game of Life - Coding Challenge
 * 
 * A cellular automaton simulation where cells live, die, or multiply
 * based on simple rules applied to each generation.
 */
public class GameOfLife extends JFrame {
    // Constants
    private static final int ROWS = 30;
    private static final int COLS = 40;
    private static final int CELL_SIZE = 15;
    private static final int GRID_WIDTH = COLS * CELL_SIZE;
    private static final int GRID_HEIGHT = ROWS * CELL_SIZE;
    
    // Colors
    private static final Color INDIGO = new Color(102, 126, 234);
    private static final Color GRID_BG = new Color(221, 221, 221);
    private static final Color TEXT_COLOR = new Color(85, 85, 85);
    
    // Game state
    private boolean[][] grid;
    private boolean running = false;
    private int generation = 0;
    private int speed = 200; // milliseconds
    
    // UI Components
    private JPanel gridPanel;
    private JButton startButton;
    private JButton stopButton;
    private JButton clearButton;
    private JButton randomButton;
    private JSlider speedSlider;
    private JLabel speedLabel;
    private JLabel generationLabel;
    private Timer timer;
    
    /**
     * Constructor - Initialize the game
     */
    public GameOfLife() {
        setTitle("Conway's Game of Life");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        
        initializeComponents();
        layoutComponents();
        setupEventHandlers();
        
        // TODO: Initialize the grid with all dead cells (false)
        // Create a 2D array of size ROWS x COLS
        initGrid();
        
        pack();
        setLocationRelativeTo(null);
    }
    
    /**
     * Initialize UI components
     */
    private void initializeComponents() {
        gridPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                drawGrid(g);
            }
        };
        gridPanel.setPreferredSize(new Dimension(GRID_WIDTH, GRID_HEIGHT));
        gridPanel.setBackground(GRID_BG);
        gridPanel.setBorder(BorderFactory.createLineBorder(GRID_BG, 1));
        
        startButton = new JButton("Start");
        stopButton = new JButton("Stop");
        clearButton = new JButton("Clear");
        randomButton = new JButton("Random");
        
        stopButton.setEnabled(false);
        
        speedSlider = new JSlider(50, 1000, 200);
        speedSlider.setMajorTickSpacing(200);
        speedSlider.setPaintTicks(true);
        speedSlider.setPaintLabels(false);
        
        speedLabel = new JLabel("200ms");
        speedLabel.setForeground(INDIGO);
        speedLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 12));
        
        generationLabel = new JLabel("Generation: 0");
        generationLabel.setForeground(TEXT_COLOR);
        
        timer = new Timer(speed, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nextGeneration();
            }
        });
    }
    
    /**
     * Layout UI components
     */
    private void layoutComponents() {
        setLayout(new BorderLayout());
        
        // Control panel
        JPanel controlPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        controlPanel.add(startButton);
        controlPanel.add(stopButton);
        controlPanel.add(clearButton);
        controlPanel.add(randomButton);
        
        JPanel speedPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 0));
        speedPanel.add(new JLabel("Speed:"));
        speedPanel.add(speedSlider);
        speedPanel.add(speedLabel);
        controlPanel.add(speedPanel);
        
        // Info panel
        JPanel infoPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
        infoPanel.add(generationLabel);
        infoPanel.add(new JLabel("Click cells to toggle them on/off"));
        
        // Main panel
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        mainPanel.add(gridPanel, BorderLayout.CENTER);
        mainPanel.add(controlPanel, BorderLayout.NORTH);
        mainPanel.add(infoPanel, BorderLayout.SOUTH);
        
        add(mainPanel);
    }
    
    /**
     * Setup event handlers
     */
    private void setupEventHandlers() {
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                start();
            }
        });
        
        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stop();
            }
        });
        
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clear();
            }
        });
        
        randomButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                randomize();
            }
        });
        
        speedSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                updateSpeed(speedSlider.getValue());
            }
        });
        
        gridPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (!running) {
                    int col = e.getX() / CELL_SIZE;
                    int row = e.getY() / CELL_SIZE;
                    if (row >= 0 && row < ROWS && col >= 0 && col < COLS) {
                        toggleCell(row, col);
                    }
                }
            }
        });
    }
    
    /**
     * TODO: Initialize the grid array with all dead cells
     * Create a 2D array of size ROWS x COLS filled with false
     */
    private void initGrid() {
        // Your code here
    }
    
    /**
     * TODO: Count the number of live neighbors for a cell at (row, col)
     * Check all 8 surrounding cells (including diagonals)
     * Make sure to check array bounds
     * 
     * @param row Row index of the cell
     * @param col Column index of the cell
     * @return Number of live neighbors
     */
    private int countNeighbors(int row, int col) {
        // Your code here
        return 0;
    }
    
    /**
     * TODO: Calculate and render the next generation
     * Rules:
     * - Live cell with 2-3 neighbors: survives
     * - Dead cell with exactly 3 neighbors: becomes alive
     * - All other cells: die or stay dead
     * 
     * Important: Create a new grid, don't modify the current one directly
     */
    private void nextGeneration() {
        // Your code here
    }
    
    /**
     * TODO: Toggle a cell's state when clicked (only when not running)
     * 
     * @param row Row index of the cell
     * @param col Column index of the cell
     */
    private void toggleCell(int row, int col) {
        // Your code here
    }
    
    /**
     * TODO: Start the simulation
     * Set running to true, disable/enable appropriate buttons
     * Start the timer to call nextGeneration at the current speed
     */
    private void start() {
        // Your code here
    }
    
    /**
     * TODO: Stop the simulation
     * Set running to false, enable/disable appropriate buttons
     * Stop the timer
     */
    private void stop() {
        // Your code here
    }
    
    /**
     * TODO: Clear the grid (only when not running)
     * Reset all cells to dead and generation to 0
     */
    private void clear() {
        // Your code here
    }
    
    /**
     * TODO: Generate a random pattern (only when not running)
     * Set each cell to alive with ~30% probability
     * Reset generation to 0
     */
    private void randomize() {
        // Your code here
    }
    
    /**
     * TODO: Update the speed and restart timer if running
     * 
     * @param value New speed value in milliseconds
     */
    private void updateSpeed(int value) {
        // Your code here
    }
    
    /**
     * Update the generation counter display
     */
    private void updateGeneration() {
        generationLabel.setText("Generation: " + generation);
    }
    
    /**
     * Draw the grid on the panel
     * 
     * @param g Graphics object
     */
    private void drawGrid(Graphics g) {
        if (grid == null) {
            return;
        }
        
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                int x = j * CELL_SIZE;
                int y = i * CELL_SIZE;
                
                if (grid[i][j]) {
                    g.setColor(INDIGO);
                } else {
                    g.setColor(Color.WHITE);
                }
                
                g.fillRect(x, y, CELL_SIZE - 1, CELL_SIZE - 1);
            }
        }
    }
    
    /**
     * Main method to run the application
     * 
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                
                new GameOfLife().setVisible(true);
            }
        });
    }
}

