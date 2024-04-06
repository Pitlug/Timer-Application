import java.awt.*;
import java.awt.BorderLayout;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

import java.awt.color.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToeEpic implements ActionListener{
	int countX, countO = 0;
	Random random = new Random();
	JFrame frame = new JFrame();
	JPanel title_panel = new JPanel();
	JPanel button_panel = new JPanel();
	static JPanel control_panel = new JPanel();
	static JLabel textfield = new JLabel();
	JLabel scoreCount = new JLabel();
	static JButton newGame = new JButton();
	static JButton[] buttons = new JButton[9];
	boolean player1_turn;
	
	TicTacToeEpic(){
		
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.setSize(900,900);
		frame.getContentPane().setBackground(new Color(50,50,50));
		frame.setLayout(new BorderLayout());
		frame.setTitle("Tic Tac Toe");
		frame.setVisible(true);
		
		textfield.setBackground(new Color(25,25,25));
		textfield.setForeground(new Color(25,255,0));
		textfield.setFont(new Font("Ink Free",Font.BOLD, 40));
		textfield.setText("Tic-Tac-Toe");
		textfield.setHorizontalAlignment(SwingConstants.CENTER); // Center horizontally
		textfield.setVerticalAlignment(SwingConstants.CENTER); // Center vertically
		textfield.setOpaque(true);
		
		title_panel.setLayout(new BorderLayout());
		title_panel.setBounds(0,0,800,100);
		
		button_panel.setLayout(new GridLayout(3,3));
		button_panel.setBackground(new Color(150,150,150));
		
		control_panel.setLayout(new BorderLayout());
		control_panel.setBounds(0, 0, 800, 100);
		
		newGame.addActionListener(new clearBoard());
		
		for (int i=0; i<9; i++) {
			buttons[i] = new JButton();
			button_panel.add(buttons[i]);
			buttons[i].setFont(new Font("MV Boli",Font.BOLD,120));
			buttons[i].addActionListener(this);
		}
		
		title_panel.add(textfield);
		frame.add(title_panel, BorderLayout.NORTH);
		frame.add(button_panel);
		
		control_panel.add(newGame);
		newGame.setFont(new Font("MV Boli",Font.BOLD,50));
		newGame.setText("NEW GAME");
		frame.add(control_panel, BorderLayout.SOUTH);
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		firstTurn();
	}
	
	

	
	public void actionPerformed(ActionEvent e) {
		
		for (int i=0; i<9; i++) {
			if(e.getSource()==buttons[i]) {
				if(player1_turn) {
					if(buttons[i].getText()=="") {
						buttons[i].setForeground(Color.BLACK);
						buttons[i].setText("X");
						player1_turn=false;
						textfield.setText("O turn");
						check();
					}
				}
				else {
					if(buttons[i].getText()=="") {
						buttons[i].setForeground(new Color(0,0,255));
						buttons[i].setText("O");
						player1_turn=true;
						textfield.setText("X turn");
						check();
					}
				}
			}
		}
	}
	
	public void firstTurn() {
		
		if(random.nextInt(2)==0) {
			player1_turn=true;
			textfield.setText("- X turn - "+"|X Wins: "+countX+" - O Wins: "+countO+" |");
		}
		else {
			player1_turn=false;
			textfield.setText("- O turn - "+"|X Wins: "+countX+" - O Wins: "+countO+" |");
		}
			
	}
	
	public void check() {
		int num = 0;
		//check X win conditions
		if(
				(buttons[0].getText()=="X") &&
				(buttons[1].getText()=="X") &&
				(buttons[2].getText()=="X") 
				) {
			xWins(0,1,2);
			num+=1;
		}
		if(
				(buttons[3].getText()=="X") &&
				(buttons[4].getText()=="X") &&
				(buttons[5].getText()=="X")
				) {
			xWins(3,4,5);
			num+=1;
		}
		if(
				(buttons[6].getText()=="X") &&
				(buttons[7].getText()=="X") &&
				(buttons[8].getText()=="X")
				) {
			xWins(6,7,8);
			num+=1;
		}
		if(
				(buttons[0].getText()=="X") &&
				(buttons[3].getText()=="X") &&
				(buttons[6].getText()=="X")
				) {
			xWins(0,3,6);
			num+=1;
		}
		if(
				(buttons[1].getText()=="X") &&
				(buttons[4].getText()=="X") &&
				(buttons[7].getText()=="X")
				) {
			xWins(1,4,7);
			num+=1;
		}
		if(
				(buttons[2].getText()=="X") &&
				(buttons[5].getText()=="X") &&
				(buttons[8].getText()=="X")
				) {
			xWins(2,5,8);
			num+=1;
		}
		if(
				(buttons[0].getText()=="X") &&
				(buttons[4].getText()=="X") &&
				(buttons[8].getText()=="X")
				) {
			xWins(0,4,8);
			num+=1;
		}
		if(
				(buttons[2].getText()=="X") &&
				(buttons[4].getText()=="X") &&
				(buttons[6].getText()=="X")
				) {
			xWins(2,4,6);
			num+=1;
		}
		//check O win conditions
		if(
				(buttons[0].getText()=="O") &&
				(buttons[1].getText()=="O") &&
				(buttons[2].getText()=="O") 
				) {
			oWins(0,1,2);
			num+=1;
		}
		if(
				(buttons[3].getText()=="O") &&
				(buttons[4].getText()=="O") &&
				(buttons[5].getText()=="O")
				) {
			oWins(3,4,5);
			num+=1;
		}
		if(
				(buttons[6].getText()=="O") &&
				(buttons[7].getText()=="O") &&
				(buttons[8].getText()=="O")
				) {
			oWins(6,7,8);
			num+=1;
		}
		if(
				(buttons[0].getText()=="O") &&
				(buttons[3].getText()=="O") &&
				(buttons[6].getText()=="O")
				) {
			oWins(0,3,6);
			num+=1;
		}
		if(
				(buttons[1].getText()=="O") &&
				(buttons[4].getText()=="O") &&
				(buttons[7].getText()=="O")
				) {
			oWins(1,4,7);
			num+=1;
		}
		if(
				(buttons[2].getText()=="O") &&
				(buttons[5].getText()=="O") &&
				(buttons[8].getText()=="O")
				) {
			oWins(2,5,8);
			num+=1;
		}
		if(
				(buttons[0].getText()=="O") &&
				(buttons[4].getText()=="O") &&
				(buttons[8].getText()=="O")
				) {
			oWins(0,4,8);
			num+=1;
		}
		if(
				(buttons[2].getText()=="O") &&
				(buttons[4].getText()=="O") &&
				(buttons[6].getText()=="O")
				) {
			oWins(2,4,6);
			num+=1;
		}
		//Check for Tie Game
		if( 
				(num == 0) &&
				(buttons[0].getText()!="") &&
				(buttons[1].getText()!="") &&
				(buttons[2].getText()!="") &&
				(buttons[3].getText()!="") &&
				(buttons[4].getText()!="") &&
				(buttons[5].getText()!="") &&
				(buttons[6].getText()!="") &&
				(buttons[7].getText()!="") &&
				(buttons[8].getText()!="")
				) {
			tieGame();
		}
	}
	
	public void xWins(int a, int b, int c) {
		countX += 1;
		buttons[a].setBackground(Color.GREEN);
		buttons[b].setBackground(Color.GREEN);
		buttons[c].setBackground(Color.GREEN);
		
		for(int i=0;i<9;i++) {
			buttons[i].setEnabled(false);
		}
		textfield.setText("Game Over - X wins - "+"|X Wins: "+countX+" - O Wins: "+countO+" |");
	}
	
	public void oWins(int a, int b, int c) {
		countO += 1;
		buttons[a].setBackground(Color.GREEN);
		buttons[b].setBackground(Color.GREEN);
		buttons[c].setBackground(Color.GREEN);
		
		for(int i=0;i<9;i++) {
			buttons[i].setEnabled(false);
		}
		textfield.setText("Game Over - O wins - "+"|X Wins: "+countX+" - O Wins: "+countO+" |");
	}
	public void tieGame() {
		buttons[0].setBackground(Color.RED);
		buttons[1].setBackground(Color.RED);
		buttons[2].setBackground(Color.RED);
		buttons[3].setBackground(Color.RED);
		buttons[4].setBackground(Color.RED);
		buttons[5].setBackground(Color.RED);
		buttons[6].setBackground(Color.RED);
		buttons[7].setBackground(Color.RED);
		buttons[8].setBackground(Color.RED);
		textfield.setText("Game Over - Tie Game");
		
	}
	
	class clearBoard implements ActionListener {
	    public void actionPerformed(ActionEvent e) {
	    	// 1. Reset all buttons
	        for (int i = 0; i < 9; i++) {
	            buttons[i].setText("");
	            buttons[i].setBackground(Color.white);
	            buttons[i].setEnabled(true); 
	        }
	        // 3. Start a new game (randomly decide who goes first)
	        firstTurn(); 
	    }
	}
}
