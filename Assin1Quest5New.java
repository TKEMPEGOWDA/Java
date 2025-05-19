import java.util.Scanner;

public class Assin1Quest5New {
	
	public static char nonRepeating(String s) {
	    int[] Count = new int[26]; 
	    for (char car : s.toCharArray()) {
	        Count[car - 'a']++;
	    }
	    
            for (char car : s.toCharArray()) {
	        if (Count[car - 'a'] == 1) {
	            return car; 
	        }
	    }
	 
	    return 'N';
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
	    System.out.println("Enter the String");
	    String inputString =  scanner.nextLine();
	    char result = nonRepeating(inputString);
	    
	    if (result == 'N') {
	        System.out.println("NULL");
	    } else {
	        System.out.println(result);
	    }
	}

}
