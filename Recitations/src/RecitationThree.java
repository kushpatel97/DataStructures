
public class RecitationThree {

	public static void main(String[] args) {
		/*
		String smile = "smile";
		
		System.out.println("Print Frown or Smile: ");
		String ansMood = IO.readString();
		
		if (ansMood == smile){*/
			//Center Circle
			Picasso.moveDown(7);
			Picasso.moveRight(7);
			Picasso.drawCircle(8);
			
			//Move to Right Eye and draw
			Picasso.moveRight(2);
			Picasso.moveUp(2);
			Picasso.drawCircle(2);
			
			//Move to Left Eye and draw
			Picasso.moveLeft(4);
			Picasso.drawCircle(2);
			
			//Move to left side of smile and draw
			Picasso.moveDown(3);
			Picasso.drawLineDown(1);
			Picasso.moveDown(1);
			
			//Move and draw line to the right
			Picasso.drawLineRight(4);
			Picasso.moveRight(4);
			
			//Draw right line
			Picasso.moveUp(1);
			Picasso.drawLineDown(1);
			
		
		
		
		
		

	}

}
