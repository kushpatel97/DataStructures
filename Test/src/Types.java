
public class Types {

	public static void main (String[] args){
	
		double e;
		e = 65;
		System.out.println(e);
		
		float c = (float)e;
		
		int x = 50;
		int y = 15;
		
		float z = x /y; //Integer divided by integer, yields integer
		
		z = (x * 1.0f)/ y;
		
		System.out.println("Value of z: " + z);
		
		int quotient = x / y;
		int remainder = x % y;
		System.out.println(x + "/" + y + " =" + quotient + " remainder: " + remainder);
		
		char ch1 = 'a'; // characters must be in single quotation marks
		char ch2 = 'b';
		System.out.println("ch1: " + ch1 + " ch2: " + ch2);
		
		// boolean bool = "true"; Won't work because "true" is a String and not a boolean
		boolean bool = true;
		boolean bool2 = false;
		System.out.print("bool=" + bool + " bool2=" + bool2);
		
		String s = "I'm getting a cold"; //Not a primitive type in Java
		System.out.println(s);
		
		byte a = 100;
		byte b = 100;
		byte g = (byte)(a + b);
		System.out.println(g);
		
		//floating point roundoff error
		double t = 0.7;
		double r = 0.9;
		double w = t + 0.1;
		double q = r - 0.1;
		System.out.println(w == q);
		System.out.println(Math.abs(w - q) < 0.0001);
		
		
		
		
	}
	
}