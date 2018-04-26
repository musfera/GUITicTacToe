/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guitictactoe;

/**
 *
 * @author musfera khan mak870
 */

import java.util.Random;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Color;

public class GUITicTacToe extends JFrame implements ActionListener{

    /**
     * @param args the command line arguments
     */
    
    private static final int numOfButtons = 9; 
    private static final int numRows = 3;
    private static final int numColumns = 3;
    static int gameCount = 0;
    static String turn;
    
    private JButton[] buttonsArr;
    
    //X and O classes 
    //input- action 
    //set text
    //check winner  cases
    //
    
    public static class PlayerOne{
        String X = "X";
    }
    
    public static class PlayerTwo{
        String O = "O";
    }
    
    static PlayerOne player1 = new PlayerOne();
    static PlayerTwo player2 = new PlayerTwo();
    
   
private void createWindow(JPanel frame){
   
    this.buttonsArr = new JButton[numOfButtons];
    
    
    frame.setLayout(new GridLayout(numRows, numColumns));
   
    this.setTitle("Tic Tac Toe");     
    for (int j = 0; j < numOfButtons; j++){
        
        this.buttonsArr[j] = new JButton();

        buttonsArr[j] = new JButton();
        buttonsArr[j].setText("");
        buttonsArr[j].setFont(new Font("Arial", Font.PLAIN, 50));

        this.buttonsArr[j].addActionListener(this);

        frame.add(this.buttonsArr[j]);
    
    }
    
    add(frame);    
       
    setLocationRelativeTo(null);
    pack();
    
    
    setVisible(true);
    setSize(500,500);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        


}
     @Override         
public void actionPerformed (ActionEvent e){       
    
    for (int i = 0; i < buttonsArr.length; i++) {                 //Checks for the clicked button
        if (buttonsArr[i] == e.getSource()) {
            if (turn == player1.X) {
                buttonsArr[i].setText(player1.X);
                //turn = player2.O;
            } 
            else {
                buttonsArr[i].setText(player2.O);
                //turn = player1.X;
            }
            gameCount++;                                      //Counts how many clicks played 
            buttonsArr[i].setEnabled(false);                      //disable the clicked Button to prevent future clicks
        }
    } 
        if(check_win() == true){//if there is a winner, game will end and ask to replay
           // end_window();
            setVisible(false);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
            JPanel GameEnded = new JPanel();
            JLabel label1 = new JLabel();
            label1.setText("Player" + turn + " wins!");
            GameEnded.add(label1);

            add(GameEnded);  
            setLocationRelativeTo(null);
            //GameEnded.pack();
            GameEnded.setVisible(true);
            GameEnded.setSize(500, 500);
            JOptionPane.showMessageDialog(GameEnded, "Player " + turn + " wins");
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
           
            
            int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog(GameEnded, "Would you like to play again?", "Game Over", dialogButton);
            if(dialogResult == 0) {
                GUITicTacToe displayButtons = new GUITicTacToe();
                JPanel frame = new JPanel();
                displayButtons.createWindow(frame); 
                gameCount = 0;
               
            } else {
                setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                System.exit(0);
                
            }
        }
        if (gameCount == 9){//draw
            //end_window();
            
            setVisible(false);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           
            JPanel GameEnded = new JPanel();
            JLabel label1 = new JLabel();
            label1.setText("Its a draw! ");
            GameEnded.add(label1);

            add(GameEnded);  
            setLocationRelativeTo(null);
            //GameEnded.pack();
            GameEnded.setVisible(true);
            GameEnded.setSize(500, 500);
            JOptionPane.showMessageDialog(GameEnded, "Its a draw! ");
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
           
            
            int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog(GameEnded, "Would you like to play again?", "Game Over", dialogButton);
            if(dialogResult == 0) {
                GUITicTacToe displayButtons = new GUITicTacToe();
                JPanel frame = new JPanel();
                displayButtons.createWindow(frame); 
                gameCount = 0;
            } else {
                setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                System.exit(0);
                
            }
            
        }
        
        if (turn == player1.X) {
               
                turn = player2.O;
            } 
            else {
                
                turn = player1.X;
            }
        
    }
    
        




public boolean check_win(){//checking if there is a winner, or a draw, or neither 
    boolean is_Winner = false;
    
    if( ((buttonsArr[0].getText()).equals(buttonsArr[1].getText())) && ((buttonsArr[1].getText()).equals(buttonsArr[2].getText())) && ((buttonsArr[0].getText()).equals(buttonsArr[2].getText()))&&((buttonsArr[0].getText().equals("X")) || (buttonsArr[0].getText().equals("O"))))
                is_Winner = true;
        else if( (buttonsArr[3].getText() == buttonsArr[4].getText()) && (buttonsArr[4].getText() == buttonsArr[5].getText()) && (buttonsArr[3].getText() == buttonsArr[5].getText())&&(buttonsArr[3].getText()=="X" || buttonsArr[3].getText()=="O"))
                    is_Winner = true;
        else if( (buttonsArr[6].getText() == buttonsArr[7].getText()) && (buttonsArr[7].getText() == buttonsArr[8].getText()) && (buttonsArr[6].getText() == buttonsArr[8].getText())&&(buttonsArr[6].getText()=="X" || buttonsArr[6].getText()=="O"))
                   is_Winner = true;
        else if( (buttonsArr[0].getText() == buttonsArr[3].getText()) && (buttonsArr[3].getText() == buttonsArr[6].getText()) && (buttonsArr[0].getText() == buttonsArr[6].getText())&&(buttonsArr[0].getText()=="X" || buttonsArr[0].getText()=="O"))
                    is_Winner = true;
        else if( (buttonsArr[1].getText() == buttonsArr[4].getText()) && (buttonsArr[4].getText() == buttonsArr[7].getText()) && (buttonsArr[1].getText() == buttonsArr[7].getText())&&(buttonsArr[1].getText()=="X" || buttonsArr[1].getText()=="O"))
                    is_Winner = true;
        else if( (buttonsArr[2].getText() == buttonsArr[5].getText()) && (buttonsArr[5].getText() == buttonsArr[8].getText()) && (buttonsArr[2].getText() == buttonsArr[8].getText())&&(buttonsArr[2].getText()=="X" || buttonsArr[2].getText()=="O"))
                    is_Winner = true;
        else if( (buttonsArr[0].getText() == buttonsArr[4].getText()) && (buttonsArr[4].getText() == buttonsArr[8].getText()) && (buttonsArr[0].getText() == buttonsArr[8].getText())&&(buttonsArr[0].getText()=="X" || buttonsArr[0].getText()=="O"))
                    is_Winner = true;
        else if( (buttonsArr[2].getText() == buttonsArr[4].getText()) && (buttonsArr[4].getText() == buttonsArr[6].getText()) && (buttonsArr[2].getText() == buttonsArr[6].getText())&&(buttonsArr[2].getText()=="X" || buttonsArr[2].getText()=="O"))
                    is_Winner = true;
    
    return is_Winner;
}


 
    public static void main(String[] args) {
        // TODO code application logic here
        PlayerOne player1 = new PlayerOne();
        PlayerTwo player2 = new PlayerTwo();
        turn = player1.X;
        GUITicTacToe displayButtons = new GUITicTacToe();
       JPanel frame = new JPanel();
       displayButtons.createWindow(frame); 
    }
    
}
