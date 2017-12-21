
public class Resistors {

	public static void main(String[] args) {
		
		int colorOne = 0;
		int colorTwo = 0;
		int multiplier = 0;
		
		System.out.println("Enter a color for band 1"); 
		String bandOne = IO.readString();
		
		if (bandOne.equals("black")){
			System.out.println("Error: cannot start band with black");
			return;
		}
		else if (bandOne.equalsIgnoreCase("brown")){
			colorOne = 1;
		}
		else if (bandOne.equals("red")){
			colorOne = 2;
		}
		else if (bandOne.equals("orange")){
			colorOne = 3;
		}
		else if (bandOne.equals("yellow")){
			colorOne = 4;
		}
		else if (bandOne.equals("green")){
			colorOne = 5;
		}
		
		System.out.println("Enter a color for band 2"); 
		String bandTwo = IO.readString();
			
		if (bandTwo.equals("black")){
			colorTwo = 0;
		}
		else if (bandTwo.equals("brown")){
			colorTwo = 10;
		}
		else if (bandTwo.equals("red")){
			colorTwo = 20;
		}
		else if (bandTwo.equals("orange")){
			colorTwo = 30;
		}
		else if (bandTwo.equals("yellow")){
			colorTwo = 40;
		}
		else if (bandTwo.equals("green")){
			colorTwo = 50;
		}
		
		System.out.println("Enter a color for band 3"); 
		String bandThree = IO.readString();
		
		if (bandThree.equals("black")){
			multiplier = 1;
		}
		else if (bandThree.equals("brown")){
			multiplier = 10;
		}
		else if (bandThree.equals("red")){
			multiplier = 100;
		}
		else if (bandThree.equals("orange")){
			multiplier = 1000;
		}
		else if (bandThree.equals("yellow")){
			multiplier = 10000;
		}
		else if (bandThree.equals("green")){
			multiplier = 100000;
		}
		
		
	
		System.out.println((colorTwo + colorOne)*multiplier + " Ohms");
	}
}
