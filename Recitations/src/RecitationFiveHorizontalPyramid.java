
public class RecitationFiveHorizontalPyramid {

	public static void main(String[] args) {
		System.out.println("Enter the number of rows you want:");
		int r = IO.readInt();
		
		  for(int i=1; i<=r;i++){
              
              for(int j=0; j < i; j++){
                      System.out.print("*");
              }
             
          
              System.out.println("");
		  }
		  for(int i=r; i>0 ;i--){
	             
              for(int j=0; j < i-1; j++){
                      System.out.print("*");
              }
             
              
              System.out.println("");
      }

	}

}
