
public class Assin7Quest2N {
	   private long[] theArray;
	    private int nElems;

	    public Assin7Quest2N(int max) {
	        theArray = new long[max];
	        nElems = 0;
	    }

	    public void insert(long value) {
	        theArray[nElems] = value;
	        nElems++;
	    }

	    public void display() {
	        System.out.print("A=");
	        for (int j = 0; j < nElems; j++)
	            System.out.print(theArray[j] + " ");
	        System.out.println("");
	    }

	  

		  public long findKthSmallest(int k) {
				 
		        if (theArray == null || theArray.length == 0 || k < 1 || k > theArray.length) {
		            throw new IllegalArgumentException("Invalid input.");
		        }
		        return quickSelect(0, theArray.length - 1, k); 
		    }

	    
	    public long quickSelect(int left, int right, int term) {
	    
	    	int size = right-left+1;
	    	if(size <= 3) 
	    	{
	    	manualSort(left, right);
	    	return theArray[term-1];
	    	}
	    	else 
	    	{
	            long median = medianOf3(left, right);
	            int partition = partitionIt(left, right, median);
	            if (partition == term) {
	                return theArray[term];
	            } else if (partition > term) {
	                return quickSelect(left, partition - 1, term);
	            } else {
	                return quickSelect(partition + 1, right, term);
	            }
	    	}
	        
	    }

	    public long medianOf3(int left, int right) {
	        int center = (left + right) / 2;

	        if (theArray[left] > theArray[center])
	            swap(left, center);

	        if (theArray[left] > theArray[right])
	            swap(left, right);

	        if (theArray[center] > theArray[right])
	            swap(center, right);

	        swap(center, right - 1);
	        return theArray[right - 1];
	    }

	    public void swap(int dex1, int dex2) {
	        long temp = theArray[dex1];
	        theArray[dex1] = theArray[dex2];
	        theArray[dex2] = temp;
	    }

	    public int partitionIt(int left, int right, long pivot) {
	        int leftPtr = left;
	        int rightPtr = right - 1;

	        while (true) {
	            while (theArray[++leftPtr] < pivot);

	            while (theArray[--rightPtr] > pivot);

	            if (leftPtr >= rightPtr)
	                break;
	            else
	                swap(leftPtr, rightPtr);
	        }
	        swap(leftPtr, right - 1);
	        return leftPtr;
	    }

	    public void manualSort(int left, int right) {
	        int size = right - left + 1;

	        if (size <= 1)
	            return;

	        if (size == 2) {

	            if (theArray[left] > theArray[right])
	                swap(left, right);
	            return;
	        } else {

	            if (theArray[left] > theArray[right - 1])
	                swap(left, right - 1);
	            if (theArray[left] > theArray[right])
	                swap(left, right);
	            if (theArray[right - 1] > theArray[right])
	                swap(right - 1, right);
	        }
	    }

	    public static void main(String[] args) {
	        int maxSize = 10;
	        int term = 5; 
	      
	        Assin7Quest2N arr;
	        arr = new Assin7Quest2N(maxSize);

	        for (int j = 0; j < maxSize; j++) {
	            long n = (int)(java.lang.Math.random() * 99);
	            arr.insert(n);
	        }
	        arr.display();
	        
	        long kthSmallest = arr.findKthSmallest(term);
	        System.out.println("The " + term + "th smallest element is: " + kthSmallest);
	        
	        arr.display();
	    }
}
