import java.util.Scanner;

public class Assign2Quest3 {
	private long[] a;
    private int nElems;
    
    public Assign2Quest3(int max)
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
    	int in,out;
    	
    	for(out =1;out<nElems;out++)
    	{
    		long key = a[out];
    		in = out;
    		while(in>0 && a[in-1]>= key)
    		{
    			if(a[in-1] == key)
    			{
    				key = -1;
    			}
    			a[in] = a[in-1];
    			--in;
    		}
    		a[in] = key;
    	}
    	
    	System.out.println("Array with -1s : ");
    	display();
    	
    	int nI=0;
    	for(int oI =0;oI<nElems;oI++)
    	{
    		if(a[oI]!=-1)
    		{
    			a[nI]=a[oI];
    			nI++;
    		}
    	}
    	nElems =nI;
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
          Assign2Quest3 arr = new Assign2Quest3(size);
          
          for (int i = 0; i < inputArray.length; i++) {
              try {
                  arr.insert(Integer.parseInt(inputArray[i]));
              } catch (NumberFormatException e) {
                  System.err.println("Invalid input. Please enter integers separated by spaces.");
                  return; 
              }
          }
          
          arr.InsertSort();
          System.out.println("Array after removing -1s : ");
          arr.display();
         
          
    }
    
}
