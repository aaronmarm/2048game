import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

class Tile extends JButton {
	private int row;
	private int col;
	private int val;
	private Color color;
	
	Tile(int r, int c, int val)
	{
		super("");
		row = r;
		col = c;
		this.val=val;
		if(val!=0) {
			this.setText(Integer.toString(val));
			this.setFont(new Font("Arial",Font.PLAIN,40));
		}
		this.setColor(val);
		Border border = new LineBorder(Color.GRAY, 5);
		setBorder(border);
		setPreferredSize(new Dimension(100, 100));
        setOpaque(true);
        setBackground(color);
	}
	
	int getCol(){	return col;}
	int getRow(){	return row;}
	
	public String toString()
	{
		return Integer.toString(val);
	}

	public void setColor(int val) {
		this.val=val;
		if(this.val==0) {
			color = Color.WHITE;
		}
		if(this.val==2)
			color = new Color(237,228,219);
		if(this.val==4)
			color=new Color(235,223,201);
		if(this.val==8)
			color=new Color(233,178,128);
		if(this.val==16)
			color=new Color(232,153,108);
		if(this.val==32)
			color=new Color(230,132,106);
		if(this.val==64)
			color=new Color(228,107,76);
		if(this.val==128)
			color=new Color(234,204,122);
		if(this.val==256)
			color=new Color(233,201,107);
		if(this.val==512)
			color=new Color(233,197,91);
		if(this.val==1024)
			color=new Color(232,194,78);
		if(this.val==2048)
			color=new Color(232,191,65);
	}
	
	public int getVal() {
		return val;
	}
	public void setVal(int val) {
		this.val=val;
	}
}
