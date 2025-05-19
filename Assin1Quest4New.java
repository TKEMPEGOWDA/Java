import java.util.Scanner;

public class Assin1Quest4New {
	
	private long[] a; 
	private int nElems;
   
    public Assin1Quest4New(int max)
   	{
   	a = new long[max]; 
   	nElems = 0;
   	}

	public void SecondMinMaxFinder(int size) {
		
	        int n = size;
	        long secondMin = -1;
	        long secondMax = -1;

	        if (a[0] == a[n - 1]) {
	            System.out.println("Second Maximum: NULL");
	            System.out.println("Second Minimum: NULL");
	        } else {
	            
	            for (int i = 1; i < n; i++) {
	                if (a[i] > a[i - 1]) {
	                    secondMin = a[i];
	                    break;
	                }
	            }
	            
	            for (int i = n - 2; i >= 0; i--) {
	                if (a[i] < a[i + 1]) {
	                    secondMax = a[i];
	                    break;
	                }
	            }
	            
	            System.out.println("Second Maximum of the array is: " + secondMax);
	            System.out.println("Second Minimum of the array is: " + secondMin);
	        }
	    
	}
	
	public void insert(long value)
   	{
   	int j;
   	for(j=0; j<nElems; j++)
   	if(a[j] > value)
   	break;
   	for(int k=nElems; k>j; k--)
   	a[k] = a[k-1];
   	a[j] = value;
   	nElems++;
   	}
	
	public static void main(String args[])
   	{
   		Scanner scanner = new Scanner(System.in);
   	    System.out.println("Enter elements of the array separated by spaces: ");
          String input = scanner.nextLine();
          
          String[] inputArray = input.split(" ");
          int size = inputArray.length;
          
          Assin1Quest4New arr = new Assin1Quest4New(size);
          
          for (int i = 0; i < inputArray.length; i++) {
              try {
                  arr.insert(Integer.parseInt(inputArray[i]));
              } catch (NumberFormatException e) {
                  System.err.println("Invalid input. Please enter integers separated by spaces.");
                  return; 
              }
          }
          
        arr.SecondMinMaxFinder(size);  
   	}
	
}
