
public class Milestone3 {

	public static void main(String[] args) {
		Picture p = new Picture("C:\\Users\\Kush Patel\\Desktop\\bridge.jpg");
		toGrayscale(p);
		p.write("C:\\Users\\Kush Patel\\Desktop\\bridge_2.jpg");
	}
	
	public static void toGrayscale(Picture v){
		//getHeight and getWidth gets the height and width of image. 
		//The reason we need to find the height and width of an object is so that we know the boundaries of the image.
		int height = v.getHeight();
		int width = v.getWidth();

		//We can create double for loop with the boundaries of the columns ranging from 0 to the width of the 
		//image and boundaries of the rows ranging from 0 to the height of the pictures
		for(int i = 0; i < width; i++){
			for(int j = 0; j < height; j++){
				//Using the getPixel method gets the value of the pixel at points i and j which are incremented.
				//Therefore a value of a pixel is received everytime  i and j is incremented
				Pixel pix = v.getPixel(i, j);
				
				//Here we use the getRed, getGreen, getBlue and getAlpha methods at each pixels location in order to manipulate these pixels later on
				int	red = pix.getRed();
				int	green = pix.getGreen();
				int	blue = pix.getBlue();	
				int alpha = pix.getAlpha();	
				
				//To grayscale an image, the average of all three a rbg values must be taken. That is why i took the sum of red, green, blue and divided the sum by 3.
				int grayscaled = (red + green + blue)/3;
				
				//Using the method updatePicture(), you can set each pixel to a rgb value of one's choice. 
				//Using the calculated grayscaled value, one can input these values into the update picture method.
				pix.updatePicture(alpha, grayscaled, grayscaled, grayscaled);		
			}
		}
	}

}
