import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Life2 extends JFrame{
	Square2[][] board;
	JPanel bd= new JPanel();
	JPanel controlPanel= new JPanel();
	JButton move = new JButton("MOVE");
	JButton clear= new JButton("Clear");
	JButton run = new JButton("Run");
	
	public Life2(int size) {
		int r,c;
		setTitle("Game of Life");
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setSize(size*25,size*25);
		board = new Square2[size][size];
		setLayout(new BorderLayout());
		bd.setLayout(new GridLayout(size,size));
		for (r=0; r<size; r++)
			for (c=0; c<size; c++) {
				board[r][c] = new Square2(r,c);
				bd.add(board[r][c]);
			}
		add(BorderLayout.CENTER, bd);
		
		
		controlPanel.add(clear);
		controlPanel.add(move);
		controlPanel.add(run);
		add(BorderLayout.SOUTH,controlPanel);
		
		move.addActionListener(new MakeMove());
		clear.addActionListener(new ClearBoard());
		run.addActionListener(new RunGame());
		setVisible(true);
	}
	
	class RunGame implements ActionListener {
		Timer t;
		boolean running=false;
		public RunGame() {
			t = new Timer(250, new MakeMove());
		}
		public void actionPerformed(ActionEvent e) {
			if (running) {
				t.stop();
				running = false;
				run.setText("Run");
			}
			else {
				t.start();
				running = true;
				run.setText("Pause");
			}
		}
		
	}
	
	class MakeMove implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			int r,c,lifeCount;
			int i,j;
			for (r=0; r<board.length; r++) {
				for (c=0; c<board.length; c++) {
					lifeCount=0;
					for (i=-1; i<=1; i++)
						for (j=-1; j<=1; j++) {
							if (r+i>=0 && c+j>=0
									&& r+i<board.length && c+j<board.length &&
									board[r+i][c+j].alive)
								lifeCount++;
						}
					if (board[r][c].alive) {
						lifeCount--;
						if (lifeCount<2 || lifeCount>3) {
							board[r][c].death=true;
						}
					} else {
						if (lifeCount==3) {
							board[r][c].birth=true;
						}
					}
				}
			}
			
			for (r=0; r<board.length; r++) {
				for (c=0; c<board.length; c++) {
					if (board[r][c].birth) {
						board[r][c].alive=true;
						board[r][c].birth=false;
						board[r][c].setBackground(Color.green);
					}
					if (board[r][c].death) {
						board[r][c].alive=false;
						board[r][c].death=false;
						board[r][c].setBackground(null);
					}
				}
			}
			
		}
		
	}
	
	public static void main(String[] args) {
		

	}
	
	class ClearBoard implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int r,c;
			for (r=0; r<board.length; r++) {
				for(c=0; c<board[0].length; c++) {
					board[r][c].alive = false;
					board[r][c].birth = false;
					board[r][c].death = false;
					board[r][c].setBackground(null);
				}
			}
			
		}
		
	}
}
