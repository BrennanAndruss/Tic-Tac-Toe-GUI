/**
 * Brennan Andruss
 * Tic Tac Toe GUI
 * 5/5/2023
 * Data Structures Carter
 * 
 * Description: Creates a GUI to play Tic Tac Toe with two players
 */

import javax.swing.*;
import java.awt.*;

public class Main 
{
    public static void main(String[] args)
    {
        TicTacToe frame = new TicTacToe();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 380);
        frame.setLocation(50, 50);
        frame.setVisible(true);
    }
}