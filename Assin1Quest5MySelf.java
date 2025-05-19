import java.util.Scanner;

public class Assin1Quest5MySelf {

	public static void main(String []args)
	{
		Scanner scanner = new Scanner(System.in);
	    System.out.println("Enter the String");
	    String inputString =  scanner.nextLine();
	  
	   nonRepeating(inputString);
	}
	
	public static void nonRepeating(String s)
	{
		  char[] charArray = s.toCharArray();
		  int n = charArray.length;
		    
		 for(char i :charArray){
		        if ( s.indexOf(i) == s.lastIndexOf(i)) {
		            System.out.println("First non-repeating character is: "+i);
		            break;
		            
		        }
		        else
		        	System.out.println("Null");
		        }
	}
}
