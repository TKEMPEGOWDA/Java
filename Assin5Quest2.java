
public class Assin5Quest2 {

	   public static void main(String[] args) {
		   int[] values = { 3, 4, 5, 6 };
		   int[] weights = { 2, 3, 4, 5 };
	        
	        int capacity = 5;

	        int maxProfit = knapsack(capacity, weights, values, weights.length - 1);
	        System.out.println("Maximum profit = " + maxProfit);
	    }
	
	 public static int knapsack(int capacity, int[] weights, int[] values, int index) {
	       
	        if (capacity == 0 || index < 0) {
	            return 0;
	        }

	        
	        if (weights[index] > capacity) {
	            return knapsack(capacity, weights, values, index - 1);
	        }

	        
	        int includeVal = values[index] + knapsack(capacity - weights[index], weights, values, index - 1);
	        int excludeVal = knapsack(capacity, weights, values, index - 1);

	        
	        return Math.max(includeVal, excludeVal);
	    }
	
}
