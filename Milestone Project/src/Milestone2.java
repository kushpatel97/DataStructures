
public class Milestone2 {

	public static void main(String[] args) {
		Picture p = new Picture("C:\\Users\\Kush Patel\\Desktop\\switch.bmp");
		//System.out.println(countRedPixels(p));
		switchRedBlue(p);
		//flipHorizontal(p);
		//flipVertical(p);
		//flipDiagonal(p);
	}
	
	public static int countRedPixels(Picture v){
		int count = 0;
		int height = v.getHeight();
		int width = v.getWidth();
		for(int i = 0; i < width; i++){
			for(int j = 0; j < height; j++){
				Pixel pix = v.getPixel(i, j);
				if(pix.getRed() == 255 && pix.getBlue() == 0 && pix.getGreen() == 0){
					count = count + 1;
				}
			}
		}
		return count;
	}
		
	public static void switchRedBlue(Picture v){
		int height = v.getHeight();
		int width = v.getWidth();
		for(int i = 0; i < width; i++){
			for(int j = 0; j < height; j++){
				Pixel pix = v.getPixel(i, j);
				if(pix.getRed() == 255 && pix.getBlue() == 0 && pix.getGreen() == 0){
					pix.updatePicture(0, 0, 0, 255);
				}
				else if(pix.getRed() == 0 && pix.getBlue() == 255 && pix.getGreen() == 0){
					pix.updatePicture(0, 255, 0, 0);
				}
			}
		}
		v.show();
	}
	
	public static void flipHorizontal(Picture v){
		int height = v.getHeight();
		int width = v.getWidth();
	
		for(int i = 0; i < width/2; i++){
			for(int j = 0; j < height; j++){
					Pixel left = v.getPixel(i, j);
					Pixel right = v.getPixel(width - i - 1, j);
					right.setColor(left.getColor());				
			}
		}
	}
	
	public static void flipVertical(Picture v){
		int height = v.getHeight();
		int width = v.getWidth();
	
		for(int i = 0; i < width; i++){
			for(int j = 0; j < height/2; j++){
				Pixel top = v.getPixel(i, j);
				Pixel bottom = v.getPixel(i, height - j - 1);
				bottom.setColor(top.getColor());
			}
		}
	}
	
	public static void flipDiagonal(Picture v){
		int height = v.getHeight();
		int width = v.getWidth();

		for(int i = 0; i < width; i++){
			for(int j = 0; j < height; j++){
				Pixel topLeft = v.getPixel(i, j);
				Pixel bottomRight = v.getPixel(width - j - 1 ,height - i - 1);
				bottomRight.setColor(topLeft.getColor());
			}
		}
	}
		
}

