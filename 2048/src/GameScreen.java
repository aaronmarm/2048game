import java.awt.*;
import java.awt.event.*;

import javax.swing.*;



public class GameScreen extends JFrame{
	
	JPanel header 	= new JPanel();
	JPanel grid		= new JPanel(new GridLayout(4,4));
	Tile[][] tiles;
	Matrix vals;
	
	public GameScreen() 
    {
    	setTitle("2048");
	    setBounds(200,200,400,400);
	    setDefaultCloseOperation(EXIT_ON_CLOSE); 
	    setFocusable(true);
	    
	    getContentPane().setLayout( new BorderLayout() );
	//starting board   
		vals = new Matrix();
		tiles = new Tile[4][4];
		
		for(int r=0; r<4; r++)
			for(int c=0; c<4; c++) {
				Tile t = new Tile(r,c,vals.get(r, c));
				grid.add(t);
			}
		
		
	    getContentPane().add( grid, BorderLayout.WEST );
	    
	    	this.addKeyListener(new KeyListener() {
	    		
				@Override
				public void keyTyped(KeyEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void keyPressed(KeyEvent e) {
					switch(e.getKeyCode()) {
						case KeyEvent.VK_RIGHT:
							for(int i=0; i<4; i++)
								vals.mergeRow(i,"right");
							break;
						case KeyEvent.VK_LEFT:
							for(int i=0; i<4; i++)
								vals.mergeRow(i,"left");
							break;
						case KeyEvent.VK_UP:
							for(int i=0; i<4; i++)
								vals.mergeCol(i,"up");
							break;
						case KeyEvent.VK_DOWN:
							for(int i=0; i<4; i++)
								vals.mergeCol(i,"down");
							break;
					}
					vals.addNew();
					update(vals);
					
					if(vals.hasWon()) {JOptionPane.showMessageDialog(new JFrame(),"You Won!");}
					if(vals.hasLost()) {JOptionPane.showMessageDialog(new JFrame(),"You Lost.");}
					
				}

				@Override
				public void keyReleased(KeyEvent e) {
					// TODO Auto-generated method stub
					
				}
		    	
		    });
		   
	    }
    
	
	public void update(Matrix nums) {
		grid.removeAll();
		grid.revalidate();
		for(int i=0;i<4;i++)
			for(int j=0;j<4;j++){
				Tile t = new Tile(i,j,vals.get(i, j));
				grid.add(t);
			}
	}

}


