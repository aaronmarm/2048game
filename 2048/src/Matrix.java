import java.util.Random;

public class Matrix {
	private int[][] gameVals = new int[4][4];
	private Random rand = new Random();
	public Matrix() {
		addNew();
		addNew();
		
	} 
	public int get(int r, int c) {
		return gameVals[r][c];
	}
	
	public boolean hasWon() {
		for(int r=0; r<gameVals.length; r++) {
			for(int c=0; c<gameVals[0].length; c++) {
				if(gameVals[r][c]==2048)
					return true;
			}}
		return false;
	}
	
	public boolean hasLost() {
		if(this.isFull()==false)
			return false;
		for(int r=0; r<gameVals.length; r++) 
			for(int c=0; c<3; c++) 
				if(gameVals[r][c]==gameVals[r][c+1])
					return false;
		for(int c=0; c<gameVals.length; c++) 
			for(int r=0; r<3; r++) 
				if(gameVals[r][c]==gameVals[r+1][c])
					return false;	
		return true;
		
	}

	
	public boolean addNew() {
		if(this.isFull())
			return false;
		while(1==1) {
			int r = rand.nextInt(4);
			int c = rand.nextInt(4);
			
			if(gameVals[r][c]==0) {
				gameVals[r][c]=2*(rand.nextInt(2)+1);
				return true;
			}
		}
	}
	
	public boolean isFull() {
		for(int r=0; r<gameVals.length; r++) {
			for(int c=0; c<gameVals[0].length; c++) {
				if(gameVals[r][c]==0)
					return false;
			}}
		
		return true;
	}
	
	public void mergeRow(int row, String dir) {
		
		if(dir.equals("left")) {
			for(int j=0; j<3; j++) {
				for(int i=0; i<3; i++) {
					if(gameVals[row][i]==gameVals[row][i+1]) {
						gameVals[row][i]*=2;
						gameVals[row][i+1]=0;
					}
					else if(gameVals[row][i]==0) {
						gameVals[row][i]=gameVals[row][i+1];
						gameVals[row][i+1]=0;
					}
				}}
			
			}
		
		if(dir.equals("right")) {
			for(int j=0; j<3; j++) {
				for(int i=3; i>0; i--) {
					if(gameVals[row][i]==gameVals[row][i-1]) {
						gameVals[row][i]*=2;
						gameVals[row][i-1]=0;
					}
					else if(gameVals[row][i]==0) {
						gameVals[row][i]=gameVals[row][i-1];
						gameVals[row][i-1]=0;
					}
				}}
		}
		
		
	}
	
	
	public void mergeCol(int col, String dir) {
		if(dir.equals("up")) {
			for(int j=0; j<3; j++) {
				for(int i=0; i<3; i++) {
					if(gameVals[i][col]==gameVals[i+1][col]) {
						gameVals[i][col]*=2;
						gameVals[i+1][col]=0;
					}
					else if(gameVals[i][col]==0) {
						gameVals[i][col]=gameVals[i+1][col];
						gameVals[i+1][col]=0;
					}
				}}
			}
		
		if(dir.equals("down")) {
			for(int j=0; j<3; j++) {
				for(int i=3; i>0; i--) {
					if(gameVals[i][col]==gameVals[i-1][col]) {
						gameVals[i][col]*=2;
						gameVals[i-1][col]=0;
					}
					else if(gameVals[i][col]==0) {
						gameVals[i][col]=gameVals[i-1][col];
						gameVals[i-1][col]=0;
					}
				}}
		}		
	}
}
