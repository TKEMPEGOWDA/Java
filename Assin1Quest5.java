import java.util.ArrayList;
import java.util.Scanner;

public class Assin1Quest5 {
	public static void main(String args[])
	{
		Scanner scanner = new Scanner(System.in);
	    System.out.println("Enter the String");
	    String str= scanner.nextLine();
	    char[] charArray = str.toCharArray();
	    ArrayList<String> al = new ArrayList();
	    ArrayList<String> al2 = new ArrayList();
	    for(int i=0;i<charArray.length;i++)
	    {
	    	if(!al.contains(String.valueOf(charArray[i])))
	     al.add(String.valueOf(charArray[i]));
	    	else
	    	{
	    		 al2.add(String.valueOf(charArray[i]));
	    	}
	    }
	    al.removeAll(al2);
	    System.out.print("First non repeating character : ");
	    if(al.size() != 0) {
	    System.out.println(al.get(0));
	    }
	    else {
	    	System.out.println("null");
	    }
	    //System.out.print(al2);
	}
	
}
