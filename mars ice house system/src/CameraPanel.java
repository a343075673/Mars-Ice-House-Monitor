import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;


public class CameraPanel extends JPanel {

	public static final int WIDTH=240;
	public static final int HEIGHT=240;
	private BufferedImage image;
	private double scale;
	private int imageWidth;
	private int imageHeight;
	private int x;
	private int y;
	
	public CameraPanel(int index){
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		image=ImageHelper.getInstance().getImage(index);
		imageWidth=image.getWidth();
		imageHeight=image.getHeight();
		if(imageWidth<imageHeight){
			scale=WIDTH*1.0/imageWidth;			
		}else{
			scale=HEIGHT*1.0/imageHeight;						
		}
		while(getScaleWidth()<WIDTH*2||getScaleHeight()<HEIGHT/2){
			scale*=2;
		}
		x=(WIDTH-getScaleWidth())/2;
		y=(HEIGHT-getScaleHeight())/2;				
	}
	
	private int getScaleWidth(){
		return (int) (imageWidth*scale);
	}

	private int getScaleHeight(){
		return (int) (imageHeight*scale);
	}

	public void zoomOut(){
		int swidth=getScaleWidth();
		int sheight=getScaleHeight();
		scale-=0.1;
		if(getScaleWidth()<WIDTH||getScaleHeight()<HEIGHT){
			scale+=0.1;
		}else{
			x+=(swidth-getScaleWidth())/2;
			y+=(sheight-getScaleHeight())/2;
			adjuestPosition();
		}
	}
	
	public void zoomIn(){
		if(scale<=5){
			int swidth=getScaleWidth();
			int sheight=getScaleHeight();
			scale+=0.1;
			x-=(getScaleWidth()-swidth)/2;
			y-=(getScaleHeight()-sheight)/2;
			adjuestPosition();
		}
	}
	
	public void moveUp(){
		y-=10;
		adjuestPosition();
	}
	
	public void moveDown(){
		y+=10;
		adjuestPosition();
	}
	
	public void moveLeft(){
		x-=10;
		adjuestPosition();
	}
	
	public void moveRight(){
		x+=10;
		adjuestPosition();
	}
	
	private void adjuestPosition(){
		if(x>0){
			x=0;
		}
		if(x<=WIDTH-getScaleWidth()){
			x=WIDTH-getScaleWidth();
		}
		if(y>=0){
			y=0;
		}
		if(y<=HEIGHT-getScaleHeight()){
			y=HEIGHT-getScaleHeight();
		}
		repaint();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, x,y,getScaleWidth(),getScaleHeight(),null);
	}
	
}
