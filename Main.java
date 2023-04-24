/**
 * Brennan Andruss
 * Tic Tac Toe GUI
 * 
 * Description:
 */

import javax.swing.*;
import java.awt.*;

public class Main 
{
    public static void main(String[] args)
    {
        TicTacToe frame = new TicTacToe();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 320);
        frame.setVisible(true);
    }
}