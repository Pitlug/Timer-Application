import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Square2 extends JButton{
	boolean alive=false;
	boolean birth=false;
	boolean death=false;
	int row,col;
	
	public Square2(int r, int c) {
		addActionListener(new SquareListener());
		row=r;
		col=c;
	}
	
	
	class SquareListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			//System.out.println("row: "+row+" col: "+col);
			alive = !alive;
			if (alive) {
				setBackground(Color.black);
			}
			else {
				setBackground(null);
			}
			
		}
		
	}
}
