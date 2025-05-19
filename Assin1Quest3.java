import java.util.Scanner;
import java.util.ArrayList;

public class Assin1Quest3 {
	private long[] a; 
	private int nElems;
   
    public Assin1Quest3(int max)
   	{
   	a = new long[max]; 
   	nElems = 0;
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
 	
	public int missingNumber(int n) {
        int sum1 = (n * (n + 1)) / 2;
        int sum2 = 0;
        for (long num : a) {
            sum2 += num;
        }
        return sum1 - sum2;
    }
 	
 	public static void main(String args[])
   	{
   		Scanner scanner = new Scanner(System.in);
   	    System.out.println("Enter elements of the array separated by spaces: ");
          String input = scanner.nextLine();
          
          String[] inputArray = input.split(" ");
          int size = inputArray.length;
          
          Assin1Quest3 arr = new Assin1Quest3(size);
          
          for (int i = 0; i < inputArray.length; i++) {
              try {
                  arr.insert(Integer.parseInt(inputArray[i]));
              } catch (NumberFormatException e) {
                  System.err.println("Invalid input. Please enter integers separated by spaces.");
                  return; 
              }
          }
        System.out.print("Missing number is : " + arr.missingNumber(Integer.parseInt(inputArray[size-1])));
   	}
}
