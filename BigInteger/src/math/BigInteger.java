package math;

/**
 * This class encapsulates a BigInteger, i.e. a positive or negative integer with 
 * any number of digits, which overcomes the computer storage length limitation of 
 * an integer.
 * 
 */
public class BigInteger {

	/**
	 * True if this is a negative integer
	 */
	boolean negative;
	
	/**
	 * Number of digits in this integer
	 */
	int numDigits;
	
	/**
	 * Reference to the first node of this integer's linked list representation
	 * NOTE: The linked list stores the Least Significant Digit in the FIRST node.
	 * For instance, the integer 235 would be stored as:
	 *    5 --> 3  --> 2
	 */
	DigitNode front;
	
	/**
	 * Initializes this integer to a positive number with zero digits, in other
	 * words this is the 0 (zero) valued integer.
	 */
	public BigInteger() {
		negative = false;
		numDigits = 0;
		front = null;
	}
	
	/**
	 * Parses an input integer string into a corresponding BigInteger instance.
	 * A correctly formatted integer would have an optional sign as the first 
	 * character (no sign means positive), and at least one digit character
	 * (including zero). 
	 * Examples of correct format, with corresponding values
	 *      Format     Value
	 *       +0            0
	 *       -0            0
	 *       +123        123
	 *       1023       1023
	 *       0012         12  
	 *       0             0
	 *       -123       -123
	 *       -001         -1
	 *       +000          0
	 *       
	 * 
	 * @param integer Integer string that is to be parsed
	 * @return BigInteger instance that stores the input integer
	 * @throws IllegalArgumentException If input is incorrectly formatted
	 */
	public static BigInteger parse(String integer) 
	throws IllegalArgumentException {
		BigInteger bigint = new BigInteger();
		String val = integer;
		val = val.trim();
		
		String negzero = "-0";
		bigint.front = null;
		
		if(val.equals(negzero)) {
			val = "0";
		}
		if(val.isEmpty()) {
			throw new IllegalArgumentException();
		}
		if (Character.isDigit(val.charAt(0)) == false) {
			
			val = val.substring(1);

			while(val.length()>0 && val.charAt(0)=='0'){	
				val = val.substring(1);
				if(val.length() == 1) {
					break;
				}			   
			}
			
			for(int i = 0; i <= val.length()-1; i++) {
				if(Character.isLetter(val.charAt(i)) || Character.isSpace(val.charAt(i))) {
					throw new IllegalArgumentException();
				}
				bigint.numDigits++;
				bigint.front = new DigitNode(Character.getNumericValue(val.charAt(i)), bigint.front);
			}
			bigint.negative = true;

		}
		else {

			while(val.length()>0 && val.charAt(0)=='0'){
				if(val.length() == 1) {
					break;
				}
				val = val.substring(1); 
			}
			for(int i = 0; i <= val.length()-1; i++) {
				bigint.numDigits++;
				if(Character.isLetter(val.charAt(i)) || Character.isSpace(val.charAt(i))) {
					throw new IllegalArgumentException();
				}
				bigint.front = new DigitNode(Character.getNumericValue(val.charAt(i)), bigint.front);
			}

		}

		return bigint;
	}
	
	/**
	 * Adds an integer to this integer, and returns the result in a NEW BigInteger object. 
	 * DOES NOT MODIFY this integer.
	 * NOTE that either or both of the integers involved could be negative.
	 * (Which means this method can effectively subtract as well.)
	 * 
	 * @param other Other integer to be added to this integer
	 * @return Result integer
	 */
	public BigInteger add(BigInteger other) {
		BigInteger bigint = new BigInteger();

		DigitNode first = this.front;
		DigitNode second = other.front;
		DigitNode temp = null;
		DigitNode prev = null;
		int val1 = 0;
		int val2 = 0;
		int sum = 0;
		int carry = 0;


		if ((this.negative == true && other.negative == true) || (this.negative == false && other.negative == false)) {

			while (first != null || second != null) {
				if (first != null) {
					val1 = first.digit;
				}
				else {
					val1 = 0;
				}
				if (second != null) {
					val2 = second.digit;
				}
				else {
					val2 = 0;
				}
				
				sum = val1 + val2 + carry;
				if (sum >= 10) {
					sum = sum % 10;
					carry = 1;
				} else {
					carry = 0;
				}

				temp = new DigitNode(sum, null);
				if(bigint.front == null) {
					bigint.front = temp;
				}
				else {
					prev.next = temp;
				}
				
				prev = temp;
				bigint.numDigits++;

				if (first != null)
					first = first.next;
				if (second != null)
					second = second.next;
			}
			if (carry > 0) {
				temp.next = new DigitNode(carry, null);
				bigint.numDigits++;
			}
		}

		if ((this.negative == true && other.negative == false) || (this.negative == false && other.negative == true)) { // Case 2: Opposite signs, perform subtraction
			int marker = 0;
			while (first != null || second != null) {
				if(first != null) {
					val1 = first.digit;
				}
				else {
					val1 = 0;
				}
				if(second != null) {
					val2 = second.digit;
				}
				else {
					val2 = 0;
				}
				
				if (marker == 1) {
					val1--;
				}
				if(val1 < val2) {
					sum = (val1 + 10) - val2;
					marker = 1;
				}
				else {
					sum = val1 - val2;
					marker = 0;
				}
				temp = new DigitNode(sum, null);
				if(bigint.front == null) {
					bigint.front = temp;
				}
				else {
					prev.next = temp;
				}
				
				prev = temp;
				bigint.numDigits++;

				if (first != null) {
					first = first.next;
				}
				if (second != null) {
					second = second.next;
				}
			}
			bigint.negative = true;
		}
		temp = bigint.front;
		prev = bigint.front;
		while (temp != null) {
			if (temp.digit != 0) {
				prev = temp;
			}
			temp = temp.next;
		}
		if (prev != null)
			prev.next = null;
		if (bigint.front.digit == 0 && bigint.front.next == null)
			bigint.front = null;

		for(DigitNode ptr = this.front; ptr != null; ptr = ptr.next) {
			bigint.numDigits++;
		}
		
		return bigint;
	}

	
	/**
	 * Returns the BigInteger obtained by multiplying the given BigInteger
	 * with this BigInteger - DOES NOT MODIFY this BigInteger
	 * 
	 * @param other BigInteger to be multiplied
	 * @return A new BigInteger which is the product of this BigInteger and other.
	 */
	public BigInteger multiply(BigInteger other) {
		BigInteger bigint = new BigInteger();
		BigInteger biginttemp = new BigInteger();
		DigitNode temp = null;
		DigitNode prev = null;
		int carry = 0;
		int sum = 0;
		int placeholder = 0;		
	
		for (DigitNode i = this.front; i != null; i = i.next) {
			for (DigitNode j = other.front; j != null; j = j.next) {
				sum = (i.digit * j.digit) + carry;
				if (sum >= 10) {
					carry = sum / 10;
					sum = sum % 10;
				} else {
					carry = 0;
				}
				temp = new DigitNode(sum, null);
				if(biginttemp.front == null) {
					biginttemp.front = temp;
				}
				else {
					prev.next = temp;
				}
				
				prev = temp;
			}
			if (carry > 0) {
				temp.next = new DigitNode(carry, null);
			}
		
			for (int k = 0; k < placeholder; k++) {
				biginttemp.front = new DigitNode(0, biginttemp.front);
			}
			
		
			placeholder++;
			bigint = bigint.add(biginttemp);
			biginttemp.front = null;
			carry = 0;
		}

		//Different cases if BigIntegers are negative:
		//If both are negative
		if (this.negative == true && other.negative == true) {
			bigint.negative = false;
		}
		//If one is negative and the other is not
		else if(this.negative == true && other.negative == false){

			bigint.negative = true;
		}
		else if(other.negative == true && this.negative == false) {
			bigint.negative = true;
		}

		return bigint;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		if (front == null) {
			return "0";
		}
		
		String retval = front.digit + "";
		for (DigitNode curr = front.next; curr != null; curr = curr.next) {
				retval = curr.digit + retval;
		}
		
		if (negative) {
			retval = '-' + retval;
		}
		
		return retval;
	}
	
}