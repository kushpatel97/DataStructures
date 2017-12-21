package apps;

import java.io.*;
import java.util.*;
import java.util.regex.*;

import structures.Stack;

public class Expression {

	/**
	 * Expression to be evaluated
	 */
	String expr;                
    
	/**
	 * Scalar symbols in the expression 
	 */
	ArrayList<ScalarSymbol> scalars;   
	
	/**
	 * Array symbols in the expression
	 */
	ArrayList<ArraySymbol> arrays;
    
    /**
     * String containing all delimiters (characters other than variables and constants), 
     * to be used with StringTokenizer
     */
    public static final String delims = " \t*+-/()[]";
    
    /**
     * Initializes this Expression object with an input expression. Sets all other
     * fields to null.
     * 
     * @param expr Expression
     */
    public Expression(String expr) {
        this.expr = expr;
    }

    /**
     * Populates the scalars and arrays lists with symbols for scalar and array
     * variables in the expression. For every variable, a SINGLE symbol is created and stored,
     * even if it appears more than once in the expression.
     * At this time, values for all variables are set to
     * zero - they will be loaded from a file in the loadSymbolValues method.
     */
    public void buildSymbols() {
        arrays = new ArrayList<ArraySymbol>();
        scalars = new ArrayList<ScalarSymbol>();
        String builder = new String();;
        boolean flag = false;
        
        for(int i = 0; i < expr.length(); i++){
        	
        	String temp = String.valueOf(expr.charAt(i));
            if (!Character.isLetter(expr.charAt(i))){
                if(temp.equals("[")){ 
	                for(int ia = 0; ia < arrays.size()-1; ia++) {
	                    if (builder.equals(arrays.get(ia).name)){
	                        flag = true;
	                        break;
	                    }
	                }
                    if (flag == false){
                        arrays.add(new ArraySymbol(builder));
                    }
                    //Reset block
                    flag = false;
                    builder = new String();
                } 
                else if (!builder.isEmpty()){
                    for(int is = 0; is < scalars.size()-1; is++) {
                        if (builder.equals(scalars.get(is).name)){
                            flag = true;
                            break;
                        }
                    }
                    if (flag == false){
                        scalars.add(new ScalarSymbol(builder));
                    }
                    flag = false;
                    builder = new String();
                }     
            } 
            else{
                builder += temp;
            }   
        }
        if (!builder.isEmpty()){
            scalars.add(new ScalarSymbol(builder));
        }
    }
    /**
     * Loads values for symbols in the expression
     * 
     * @param sc Scanner for values input
     * @throws IOException If there is a problem with the input 
     */
    public void loadSymbolValues(Scanner sc) 
    throws IOException {
        while (sc.hasNextLine()) {
            StringTokenizer st = new StringTokenizer(sc.nextLine().trim());
            int numTokens = st.countTokens();
            String sym = st.nextToken();
            ScalarSymbol ssymbol = new ScalarSymbol(sym);
            ArraySymbol asymbol = new ArraySymbol(sym);
            int ssi = scalars.indexOf(ssymbol);
            int asi = arrays.indexOf(asymbol);
            if (ssi == -1 && asi == -1) {
            	continue;
            }
            int num = Integer.parseInt(st.nextToken());
            if (numTokens == 2) { // scalar symbol
                scalars.get(ssi).value = num;
            } else { // array symbol
            	asymbol = arrays.get(asi);
            	asymbol.values = new int[num];
                // following are (index,val) pairs
                while (st.hasMoreTokens()) {
                    String tok = st.nextToken();
                    StringTokenizer stt = new StringTokenizer(tok," (,)");
                    int index = Integer.parseInt(stt.nextToken());
                    int val = Integer.parseInt(stt.nextToken());
                    asymbol.values[index] = val;              
                }
            }
        }
    }
    
    
    /**
     * Evaluates the expression, using RECURSION to evaluate subexpressions and to evaluate array 
     * subscript expressions.
     * 
     * @return Result of evaluation
     */
    public float evaluate() {
    	return evaluate(expr);

    }
    
    private float evaluate(String string) {

      	ArrayList<String> expressionList = new ArrayList<String>();			//Create array list to store "tokens"
    	String temp = "";
    	
    	for (int i = 0; i < string.length(); i++) {							//Iterate through args to see if the string has a delim
    		String ptr = String.valueOf(string.charAt(i));
    		if (this.delims.contains(ptr)) {
    			if (!temp.isEmpty()) {
    				expressionList.add(temp);
    				temp = new String();
    			}
    			expressionList.add(ptr);
    		}
    		else {
    			temp = temp + ptr;
    		}
    	}
    	if (!temp.isEmpty()) {
    		expressionList.add(temp);
    	}
    	
    	if (expressionList.size() == 1) {
    		String value = expressionList.get(0);
    		if (value.charAt(0) == '?') {
    			return Float.parseFloat(value.replace("?", "-"));
    		}
    		else if (Character.isDigit(value.charAt(0))){
    			return Float.parseFloat(value);
    		}
    		else {
    			return (float)scalars.get(scalars.indexOf(new ScalarSymbol(value))).value;

    		}
    		
    	}
    	Stack<String> inputs = new Stack<String>();
    	Stack<String> operations = new Stack<String>();
    	String addition 		= "+";
    	String subtraction 		= "-";
    	String multiplication 	= "*";
    	String division 		= "/";
    	String oSquareBracket	= "[";
    	String cSquareBracket	= "]";
    	String oParentheses 	= "(";
    	String cParentheses 	= ")";
    	    	
    	
    	for (String item : expressionList) {
			 	
			if(item.equals(addition) || item.equals(subtraction)) {	
				if (operations.isEmpty()) {
					operations.push(item);
				}
				else if (!((operations.peek().equals(oParentheses)) || (operations.peek().equals(oSquareBracket)))){
					String second = inputs.pop();
					String first = inputs.pop();
					
					String recurExpression = first + operations.pop() + second;
					float value = evaluate(recurExpression);
					String parsed = String.valueOf(value);
					if (value < 0) {
						parsed = parsed.replace("-","?");
					}
					inputs.push(parsed);
					operations.push(item);
				}
				else {
					operations.push(item);
				}
			}
			else if(item.equals(multiplication) || item.equals(division)) {
				if (operations.isEmpty()) {
					operations.push(item);
				} 
				else if (operations.peek().equals(multiplication) || operations.peek().equals(division)) {
					String first = inputs.pop();
					String second = inputs.pop();
					
					String recurExpression = first + operations.pop() + second;
					float value = evaluate(recurExpression);
					String parsed = String.valueOf(value);
					if (value < 0) {
						parsed = parsed.replace("-","?");
					}
					inputs.push(parsed);
					operations.push(item);
				}
				else {
					operations.push(item);
				}
			}	
			else if(item.equals(oSquareBracket) || item.equals(oParentheses)){
				operations.push(item);
			}
			else if(item.equals(cParentheses)){
				while (!operations.peek().equals(oParentheses)){
					String second = inputs.pop();
					String first = inputs.pop();
					
					String recurExpression = first + operations.pop() + second;
					float value = evaluate(recurExpression);
					String parsed = String.valueOf(value);
					if (value < 0) {
						parsed = parsed.replace("-","?");
					}
					inputs.push(parsed);
				}
				operations.pop();
			}
			else if(item.equals(cSquareBracket)){
				while (!operations.peek().equals(oSquareBracket)){
					String second = inputs.pop();
					String first = inputs.pop();
					
					String recurExpression = first + operations.pop() + second;
					float value = evaluate(recurExpression);
					String parsed = String.valueOf(value);
					if (value < 0) {
						parsed = parsed.replace("-","?");
					}
					inputs.push(parsed);
				}
				operations.pop();
				String array = inputs.pop();
				String poppedInput = inputs.pop();
				int pos = arrays.indexOf(new ArraySymbol(poppedInput));
				float index = Float.parseFloat(array);
				int typeIndex = (int)index;
				inputs.push(String.valueOf(arrays.get(pos).values[typeIndex]));
			}
			else {
				inputs.push(item);
			}
		}
 
    	while (!operations.isEmpty()) {
    		float second = evaluate(inputs.pop());
    		float first = evaluate(inputs.pop());
    		String operator = operations.pop();
    		float value;
    		String result;
    		if(operator.equals(addition)) {
    			value = first + second;
    			result = String.valueOf(value);
    		}
    		else if(operator.equals(subtraction)){
    			value = first - second;
    			result = String.valueOf(value);
    		}
    		else if(operator.equals(multiplication)){
    			value = first * second;
    			result = String.valueOf(value);
    		}
    		else if(operator.equals(division)){
    			value = first / second;
    			result = String.valueOf(value);
    		}
    		else {
    			value = 0.0f;
    			result = String.valueOf(value);
    		}
			inputs.push(result);
    	}
    	
    	return Float.valueOf(evaluate(inputs.pop()));
    }
        

    /**
     * Utility method, prints the symbols in the scalars list
     */
    public void printScalars() {
        for (ScalarSymbol ss: scalars) {
            System.out.println(ss);
        }
    }
    
    /**
     * Utility method, prints the symbols in the arrays list
     */
    public void printArrays() {
    		for (ArraySymbol as: arrays) {
    			System.out.println(as);
    		}
    }

}