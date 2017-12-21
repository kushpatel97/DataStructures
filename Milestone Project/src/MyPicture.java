
public class MyPicture{
	
	private String filename; 
	private String description;
	private Picture p;
	
	public static void main(String[] args){
		MyPicture a = new MyPicture("C:\\Users\\Kush Patel\\Desktop\\bridge.jpg","bridge");
		MyPicture b = new MyPicture("C:\\Users\\Kush Patel\\Desktop\\bird.jpg","bird");
		//a.equals(b);
		//a.negative();
		//System.out.println(a.toString());
		//System.out.println(b.toString());
		//System.out.println(a.redness());
		//a.flipVertical();
		//a.flipHorizontal();
				
	}

	public MyPicture(String filename, String description){
		this.filename = filename;
		this.description = description;
		this.p = new Picture(filename);
	}
		
	public String toString(){
			
		int height = p.getHeight();
		int width = p.getWidth();
		
		String object = filename + " " + width + " x " + height + " " + description;
		return object;
	}
	
	public boolean equals(MyPicture p){
		String file1 = this.filename;
		String file2 = p.filename;
		
		String des1 = this.description;
		String des2 = p.description;
		if(file1 == file2 && des1 == des2){
			return true;
		}
		else{
			return false;
		}
	}
	
	public Picture negative(){
		Picture neg = new Picture(filename);
		int width = neg.getWidth();
		int height = neg.getHeight();
		
		for(int i = 0; i < width; i++){
			for(int j = 0; j < height; j++){
				Pixel pix = neg.getPixel(i, j);
				
				int red = pix.getRed();
				int green = pix.getGreen();
				int blue = pix.getBlue();
				
				
				int negRed = 255 - red;
				int negGreen = 255 - green;
				int negBlue = 255 - blue;
				
				pix.setRed(negRed);
				pix.setGreen(negGreen);
				pix.setBlue(negBlue);
								
			}
		}
		return neg;	
	}
	
	public double redness(){
		double redness = 0;
			
		double width = p.getWidth();
		double height = p.getHeight();
		double area = height*width;
		
		for(int i = 0; i < width; i++){
			for(int j = 0; j < height; j++){
				Pixel pix = p.getPixel(i,j);			
				if(pix.getRed() > pix.getBlue() &&  pix.getRed() > pix.getBlue()){
					redness++;
				}
			}
		}		
		return redness/area;
	}
	
	public void flipVertical(){
		
		int height = p.getHeight();
		int width = p.getWidth();
	
		for(int i = 0; i < width; i++){
			for(int j = 0; j < height/2; j++){
				Pixel top = p.getPixel(i, j);
				Pixel bottom = p.getPixel(i, height - j - 1);
				bottom.setColor(top.getColor());
			}
		}
	}
	
	public void flipHorizontal(){
		int height = p.getHeight();
		int width = p.getWidth();
	
		for(int i = 0; i < width/2; i++){
			for(int j = 0; j < height; j++){
					Pixel left = p.getPixel(i, j);
					Pixel right = p.getPixel(width - i - 1, j);
					right.setColor(left.getColor());				
			}
		}
	}

}
