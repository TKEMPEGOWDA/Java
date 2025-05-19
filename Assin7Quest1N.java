
class ArrayPar
{
	private long[] theArray; // ref to array theArray
	private int nElems; // number of data items

	public ArrayPar(int max) 
		{
			theArray = new long[max]; // create the array
			nElems = 0; // no items yet
		}

	public void insert(long value) // put element into array
		{
			theArray[nElems] = value; // insert it
			nElems++; // increment size
		}

	public int size() // return number of items
		{ return nElems; }

	public void display() // displays array contents
		{
			System.out.print("A=");
			for(int j=0; j<nElems; j++) // for each element,
			System.out.print(theArray[j] + " "); // display it
			System.out.println("");
		}

	public int partitionIt(int left, int right, long pivot)
		{
			int leftPtr = left - 1; // right of first elem
			int rightPtr = right + 1; // left of pivot
			while(true)
			{
				while(leftPtr < right && // find bigger item
				theArray[++leftPtr] < pivot)
				; // (nop)
				while(rightPtr > left && // find smaller item
				theArray[--rightPtr] > pivot)
				; // (nop)
			if(leftPtr >= rightPtr) // if pointers cross,
			break; // partition done
			else // not crossed, so
			swap(leftPtr, rightPtr); // swap elements
			} // end while(true)
			return leftPtr; // return partition
		} // end partitionIt()

	
	public long findMedian() {
		long[] arr = theArray;
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array is empty or null.");
        }
        int val = (int) (Math.ceil(nElems / 2) );
        return quickSelect(arr, 0, nElems - 1, val);
    }

    private long quickSelect(long[] arr, int left, int right, int k) {
        if (left == right) {
            return arr[left];
        }
        long piv = theArray[right];
        int pivotIndex = partitionIt(left, right,piv);
        
        if (k == pivotIndex) {
            return arr[k];
        } else if (k < pivotIndex) {
            return quickSelect(arr, left, pivotIndex - 1, k);
        } else {
            return quickSelect(arr, pivotIndex + 1, right, k);
        }
    }
	
	public void swap(int dex1, int dex2) 
		{
			long temp;
			temp = theArray[dex1]; 
			theArray[dex1] = theArray[dex2]; 
			theArray[dex2] = temp; 
		} 

} 


public class Assin7Quest1N {

    public static void main(String[] args) {
    	int maxSize = 9; // array size
    	ArrayPar arr; // reference to array
    	arr = new ArrayPar(maxSize); // create the array
    	for(int j=0; j<maxSize; j++) 
    	{ 
    	long n = (int)(java.lang.Math.random()*199);
    	arr.insert(n);
    	}
    	arr.display(); 
    	
    	long median = arr.findMedian();
       
        System.out.println("Median: " + median);
    }
}
