import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

public class Assin1Quest4 {
	private long[] a;
	
	
 	public Integer getSecondMax(ArrayList<Integer> a){
   		Integer firstMax = null;
   		Integer secondMax = null;
   		for(Integer ele : a) {
   			if(firstMax == null) {
   				firstMax = ele;
   			}
   			else if(firstMax < ele) {
   				secondMax = firstMax;
   				firstMax = ele;
   			}
   			else if(secondMax == null) {
 				secondMax = ele;
 			}
   			else if(secondMax != null && ele > secondMax){
   				secondMax = ele;
   			}
   		}
   		return secondMax;
   	}
   	
 	public Integer getSecondMin(ArrayList<Integer>b)
 	{
 		Integer firstMin = null;
 		Integer secondMin = null;
 		for(Integer ele:b)
 		{
 			if(firstMin == null)
 			{
 				firstMin = ele;
 			}
 			else if(ele < firstMin)
 			{
 				secondMin = firstMin;
 				firstMin = ele;
 			}
 			else if(secondMin == null) {
 				secondMin = ele;
 			}
 			else if(secondMin != null  && ele < secondMin)
 			{
 				secondMin = ele;
 			}
 		}
 		return secondMin;
 	}
 	
 	public long getMin(){
   		return a[1];
   	}
 	
	public static void main(String args[])
   	{
   		Scanner scanner = new Scanner(System.in);
   	    System.out.println("Enter elements of the array separated by spaces: ");
          String input = scanner.nextLine();
          
          String[] inputArray = input.split(" ");
          Assin1Quest4 arr = new Assin1Quest4();
          ArrayList<Integer> al = new ArrayList();
          
          for (int i = 0; i < inputArray.length; i++)
          {
              try {
            	  if(!al.contains(Integer.parseInt(inputArray[i])))
                  al.add(Integer.parseInt(inputArray[i]));
              } catch (NumberFormatException e) {
                  System.err.println("Invalid input. Please enter integers separated by spaces.");
                  return; 
              }
          }
          
          
       System.out.println("Second maximum number : " + arr.getSecondMax(al));
       System.out.print("Second minimum number : " + arr.getSecondMin(al));
   	}
	
}
