import java.util.Scanner;

public class Assign2Quest1 {

	private long[] a;
    private int nElems;
    
    public Assign2Quest1(int max)
    {
    	a = new long[max];
    	nElems = 0;
    }
	
    public void insert(long value) 
    {
        a[nElems] = value; 
        nElems++; 
    }
    
    public void InsertSort()
    {
    	int in, out;
    	for(out=1; out<nElems; out++) 
    	{
    	    long temp = a[out]; 
    	    in = out; 
    	    
    	while(in>0 && a[in-1] >= temp) 
    	{
    	    a[in] = a[in-1]; 
    	    --in; 
    	}
    	
    	a[in] = temp; 
    	} 
    }
    
    public void removeDups()
    {
    	  if (nElems <= 1) {
              return; 
          }

          int cI = 0;

          for (int nI = 1; nI < nElems; nI++) {
              if (a[cI] != a[nI]) {
                  cI++;
                  a[cI] = a[nI];
              }
          }

          nElems = cI + 1;
      
    }
    
    public void display() 
    {
    for(int j=0; j<nElems; j++) 
    System.out.print(a[j] + " "); 
    System.out.println("");
    }
    
    public static void main(String[] args)
    {
    	Scanner scanner = new Scanner(System.in);
   	    System.out.println("Enter elements of the array separated by spaces: ");
          String input = scanner.nextLine();
          
          String[] inputArray = input.split(" ");
          int size = inputArray.length;
          Assign2Quest1 arr = new Assign2Quest1(size);
          
          for (int i = 0; i < inputArray.length; i++) {
              try {
                  arr.insert(Integer.parseInt(inputArray[i]));
              } catch (NumberFormatException e) {
                  System.err.println("Invalid input. Please enter integers separated by spaces.");
                  return; 
              }
          }
          
          arr.InsertSort();
          System.out.println("Sorted Array : ");
          arr.display();
          arr.removeDups();
          System.out.println("Sorted Array after removing duplicates : ");
          arr.display();
          
    }
}
