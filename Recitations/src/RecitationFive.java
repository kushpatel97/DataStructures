
public class RecitationFive {

	public static void main(String[] args) {
		System.out.println("Enter the number of rows you want:");
		int r = IO.readInt();
				
	     for(int i=0;i<r;i++) {
	        for(int j=0;j<r-i;j++) {
	             System.out.print(" ");
	        }
	        for(int k=0;k<2*i-1;k++) {
	            System.out.print("*");
	        }
	        System.out.println();  
	    }
		 
	}

}
