import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

import java.awt.color.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class windowChooser implements ActionListener{
	JFrame frame = new JFrame();
	JPanel title_panel = new JPanel();
	JPanel button_panel = new JPanel();
	JLabel textfield = new JLabel();
	JButton stopwatch = new JButton();
	JButton TicTacToe = new JButton();
	JButton life = new JButton();
	
	windowChooser() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(900,900);
		frame.getContentPane().setBackground(new Color(50,50,50));
		frame.setLayout(new BorderLayout());
		frame.setTitle("Game Chooser");
		frame.setVisible(true);
		
		textfield.setBackground(new Color(25,25,25));
		textfield.setForeground(new Color(25,255,0));
		textfield.setFont(new Font("Ink Free",Font.BOLD, 40));
		textfield.setText("Choose Your Program");
		textfield.setHorizontalAlignment(SwingConstants.CENTER); // Center horizontally
		textfield.setVerticalAlignment(SwingConstants.CENTER); // Center vertically
		textfield.setOpaque(true);
		
		TicTacToe.setBackground(Color.BLUE);
		TicTacToe.setFont(new Font("Ink Free",Font.BOLD,85));
		TicTacToe.setText("Tic Tac Toe");
		
		stopwatch.setBackground(Color.RED);
		stopwatch.setFont(new Font("Ink Free",Font.BOLD,85));
		stopwatch.setText("Stopwatch");
		
		life.setBackground(Color.GREEN);
		life.setFont(new Font("Ink Free",Font.BOLD,65));
		life.setText("Conway's Game of Life");
		
		title_panel.setLayout(new BorderLayout());
		title_panel.setBounds(0,0,800,100);
		
		button_panel.setLayout(new GridLayout(3,3));
		button_panel.setBackground(new Color(150,150,150));
		button_panel.add(TicTacToe);
		button_panel.add(life);
		button_panel.add(stopwatch);
		
		title_panel.add(textfield);
		frame.add(title_panel, BorderLayout.NORTH);
		frame.add(button_panel);
	}
	
	

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == TicTacToe) {
			TicTacToeEpic tictactoe = new TicTacToeEpic();
        } else if (e.getSource() == stopwatch) {
        	Stopwatch stopwatch = new Stopwatch();
        } else if (e.getSource() == life) {
        	Life2 life = new Life2(38);
        }
		
	}
}
