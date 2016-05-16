import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;


public class ImageHelper {
	
	private List<BufferedImage> images=new ArrayList<>();
	private static ImageHelper imageHelper=null;
	
	private ImageHelper(){
		for(int i=1;i<=4;i++){
			try {
				images.add(ImageIO.read(getClass().getResource(i+".png")));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static ImageHelper getInstance(){
		if(imageHelper==null){
			imageHelper=new ImageHelper();
		}
		return imageHelper;
	}
	
	public BufferedImage getImage(int index){
		return images.get(index);
	}
}
