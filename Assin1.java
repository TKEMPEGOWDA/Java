import java.util.Scanner;
import java.util.ArrayList;


public class Assin1 {

	public static void main(String[] args) {
		 Scanner scanner = new Scanner(System.in);

		    System.out.println("Enter the highest integer of the array");
		    int size = 0;
		    if (scanner.hasNextInt()) {
	            size = scanner.nextInt();
	        }
		    scanner.nextLine();
		   
	        System.out.println("Enter elements of the array separated by spaces: ");
	        String input = scanner.nextLine();
	        
	        String[] inputArray = input.split(" ");

	        
	        ArrayList<Integer> arrayList = new ArrayList<Integer>();

	        
	        for (int i = 0; i < inputArray.length; i++) {
	            try {
	                arrayList.add(Integer.parseInt(inputArray[i]));
	            } catch (NumberFormatException e) {
	                System.err.println("Invalid input. Please enter integers separated by spaces.");
	                return; 
	            }
	        }
	        
	       
	        scanner.close();
	        
	        System.out.println("Array elements:");
	        for (int num : arrayList) {
	            System.out.print(num + " ");
	        }
	        System.out.println("");
	        for(int i =1;i<=size;i++)
	        {
	        	check(arrayList,i);
	        }

	      
	}
	
	  private static void check(ArrayList<Integer> arr, int toCheckValue)
      {
         boolean hasValue = arr.contains(toCheckValue);
         
         if(!hasValue)
         {
        	 System.out.println(toCheckValue
                  + " not present in the array");
         }
      }

}
