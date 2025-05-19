import java.util.Scanner;

public class Assign1Quest2 {
	private long[] a; // ref to array a
	private int nElems;
   
       public Assign1Quest2(int max) // constructor
   	{
   	a = new long[max]; // create array
   	nElems = 0;
   	}
   	
   	public void insert(long value) // put element into array
   	{
   	int j;
   	for(j=0; j<nElems; j++) // find where it goes
   	if(a[j] > value) // (linear search)
   	break;
   	for(int k=nElems; k>j; k--) // move bigger ones up
   	a[k] = a[k-1];
   	a[j] = value; // insert it
   	nElems++; // increment size
   	}
   	
   	public Integer getMax(){
   		Integer maximum = null;
   		for(long ele : a)
   		{
   			if(maximum == null)
   			{
   				maximum = (int) ele;
   			}
   			else if((int)ele > maximum)
   			{
   				maximum = (int) ele;
   			}
   		}
   		return maximum;
   	}
   	
 	public Integer getMin(){
 		Integer minimum = null;
 		for(long ele : a)
   		{
 			if(minimum == null)
 			{
 				minimum = (int) ele;
 			}
 			else if((int) ele < minimum)
 			{
 				minimum = (int)ele;
 			}
   		}
   		return minimum;
   	}
   	
   	public static void main(String args[])
   	{
   		Scanner scanner = new Scanner(System.in);
   	    System.out.println("Enter the size of the array");
   	    int maxSize = 0;
   	    if (scanner.hasNextInt()) {
   	    	maxSize = scanner.nextInt();
          }
   	    scanner.nextLine();
   	
   	//int maxSize = 100; // array size
   	    Assign1Quest2 arr;
   	arr = new Assign1Quest2(maxSize);
   	
   	 System.out.println("Enter elements of the array separated by spaces: ");
          String input = scanner.nextLine();
          
          String[] inputArray = input.split(" ");
          
          for (int i = 0; i < inputArray.length; i++) {
              try {
                  arr.insert(Integer.parseInt(inputArray[i]));
              } catch (NumberFormatException e) {
                  System.err.println("Invalid input. Please enter integers separated by spaces.");
                  return; 
              }
          }
          int amin = (int) arr.getMin();
          int amax = (int) arr.getMax();
          int range = amax - amin;
          
          System.out.print("Range is "+ range);
   	}
}
	

