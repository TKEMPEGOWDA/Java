import java.util.ArrayList;
import java.util.Scanner;

public class AssinQuest1Diff {
	
	private long[] a; // ref to array a
	private int nElems;
	
	public AssinQuest1Diff(int max) // constructor
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
	
	public void display() // displays array contents
	{
	for(int j=0; j<nElems; j++) // for each element,
	System.out.print(a[j] + " "); // display it
	System.out.println("");
	}
	
	public static void main(String[] args) {  
		Scanner scanner = new Scanner(System.in);
		 System.out.println("Enter the highest integer of the array");
		    int maxSize = 0;
		    if (scanner.hasNextInt()) {
		    	maxSize = scanner.nextInt();
	        }
		    scanner.nextLine();
		
		//int maxSize = 100; // array size
		AssinQuest1Diff arr;
		arr = new AssinQuest1Diff(maxSize);
		
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
	        
	        System.out.println("Array elements:");
	      arr.display();
	      for(int j = 1; j<=maxSize;j++)
	      {
	    	  int searchKey = j; // search for item
	    	  if( arr.find(searchKey) != arr.size() )
	    	 ;
	    	  else
	    	  System.out.println("Can't find " + searchKey);
	      }
	}
	
	public int size()
	{ return nElems; }
	
	public int find(long searchKey)
	{
	int lowerBound = 0;
	int upperBound = nElems-1;
	int curIn;
	while(true)
	{
	curIn = (lowerBound + upperBound ) / 2;
	if(a[curIn]==searchKey)
	return curIn; // found it
	else if(lowerBound > upperBound)
	return nElems; // can’t find it
	else // divide range
	{
	if(a[curIn] < searchKey)
	lowerBound = curIn + 1; // it’s in upper half
	else
	upperBound = curIn - 1; // it’s in lower half
	} // end else divide range
	} // end while
	} 

}

