import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TicTacToe extends JFrame 
{

    // Declare GUI elements and game variables
    private JLabel[] gameScores;
    private JButton[][] gameGrid;
    private JLabel gameStatus;
    private String player, computer, currentPlayer;
    private int playerScore, computerScore;

    // Constructor to set up the GUI elements
    public TicTacToe() 
    {
        super("Tic Tac Toe");
        setResizable(false);

        // Initializing game vairables
        player = currentPlayer = "X";
        computer = "O";
        playerScore = computerScore = 0;

        // Creating panels
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(0, 1));
        JPanel scores = new JPanel();
        scores.setLayout(new GridLayout(1, 2));
        JPanel grid = new JPanel();
        grid.setLayout(new GridLayout(3, 3));
        JPanel status = new JPanel();
        status.setLayout(new GridLayout(0, 1));

        // Setting up the scores panel and array
        gameScores = new JLabel[2];
        gameScores[0] = new JLabel(player + ": " + playerScore, JLabel.CENTER);
        gameScores[1] = new JLabel(computer + ": " + computerScore, JLabel.CENTER);
        scores.add(gameScores[0]);
        scores.add(gameScores[1]);

        // Setting up the grid panel and array
        grid.setPreferredSize(new Dimension(100, 100));
        gameGrid = new JButton[3][3];
        for (int i = 0; i < 3; i++) 
        {
            for (int j = 0; j < 3; j++) 
            {
                // Create and set up buttons for each grid space
                JButton btn = new JButton(" ");
                btn.addActionListener(new ActionListener() 
                {
                    public void actionPerformed(ActionEvent e) 
                    {
                        updateGrid(btn);
                    }
                });

                btn.setFont(new Font("Arial", Font.BOLD, 50));
                gameGrid[i][j] = btn;
                grid.add(gameGrid[i][j]);
            }
        }

        // Setting up the status panel
        gameStatus = new JLabel(currentPlayer + "'s turn", JLabel.CENTER);
        status.add(gameStatus);


        // Setting up the frame
        this.add(scores, BorderLayout.NORTH);
        this.add(grid, BorderLayout.CENTER);
        this.add(status, BorderLayout.SOUTH);
    }

    // Function to manage game state and logic
    public void updateGrid(JButton btn) 
    {
        // Check for valid selection
        if (btn.getText().equals(" ")) 
        {
            // Update the grid space
            btn.setText(currentPlayer);

            // Check grid for three in a row
            for (int i = 0; i < 3; i++) 
            {

                // Horizontal checks
                if (gameGrid[i][0].getText() != " " && gameGrid[i][0].getText() == gameGrid[i][1].getText()
                    && gameGrid[i][0].getText() == gameGrid[i][2].getText()) {
                    endGame();
                    return;
                }
                // Vertical checks
                else if (gameGrid[0][i].getText() != " " && gameGrid[0][i].getText() == gameGrid[1][i].getText()
                    && gameGrid[0][i].getText() == gameGrid[2][i].getText()) {
                    endGame();
                    return;
                }
            }
            // Diagonal checks
            if (gameGrid[0][0].getText() != " " && gameGrid[0][0].getText() == gameGrid[1][1].getText()
                && gameGrid[0][0].getText() == gameGrid[2][2].getText()) {
                endGame();
                return;
            } 
            else if (gameGrid[0][2].getText() != " " && gameGrid[0][2].getText() == gameGrid[1][1].getText()
                && gameGrid[0][2].getText() == gameGrid[2][0].getText()) {
                endGame();
                return;
            }

            // Change current player
            if (currentPlayer == player) 
            {
                currentPlayer = computer;
            } 
            else 
            {
                currentPlayer = player;
            }

            // Update the status label
            gameStatus.setText(currentPlayer + "'s turn");

            // time delay??
        }
    }

    public void endGame() 
    {
        // Update the status label
        gameStatus.setText(currentPlayer + " wins!");

        // Increment score for winning player
        if (currentPlayer == player)
        {
            playerScore++;
            gameScores[0].setText(player + ": " + playerScore);
        }
        else 
        {
            computerScore++;
            gameScores[1].setText(computer + ": " + computerScore);
        }

        // Enable reset button
    }
}