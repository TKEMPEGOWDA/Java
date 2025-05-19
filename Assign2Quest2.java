import java.util.Scanner;

public class Assign2Quest2 {
	
	private long[] a;
    private int nElems;
    
    public Assign2Quest2(int max)
    {
    	a = new long[max];
    	nElems = 0;
    }
	
    public void insert(long value) 
    {
        a[nElems] = value; 
        nElems++; 
    }
    
    public void display() 
    {
    for(int j=0; j<nElems; j++) 
    System.out.print(a[j] + " "); 
    System.out.println("");
    }
    
    public void sortNumbers()
    {
    	boolean sort = false;
    	int numPass = 0;
    	
    	while(!sort)
    	{
    		sort = true;
    		numPass++;
    	for(int i = 1; i< nElems-1 ;i+=2)
    	{
    		if(a[i]>a[i+1])
    		{
    			swapNumbers(i,i+1);
    			sort = false;
    		}
    	}
    	
    	for(int j = 0;j<nElems-1; j+=2)
    	{
    		if(a[j]>a[j+1])
    		{
    			swapNumbers(j,j+1);
    			sort = false;
    		}
    	}
    	
    	}
    	
    	System.out.println("Number of passes: " + numPass);
    }
    
    private void swapNumbers(int c, int d) {
        long temp = a[c];
        a[c] = a[d];
        a[d] = temp;
    }
    
    public static void main(String[] args)
    {
    	Scanner scanner = new Scanner(System.in);
   	    System.out.println("Enter elements of the array separated by spaces: ");
          String input = scanner.nextLine();
          
          String[] inputArray = input.split(" ");
          int size = inputArray.length;
          Assign2Quest2 arr = new Assign2Quest2(size);
          
          for (int i = 0; i < inputArray.length; i++) {
              try {
                  arr.insert(Integer.parseInt(inputArray[i]));
              } catch (NumberFormatException e) {
                  System.err.println("Invalid input. Please enter integers separated by spaces.");
                  return; 
              }
          }
          
       
       arr.sortNumbers();
       System.out.println("Sorted Array : ");
       arr.display();
          
    }
}
