
public class Assin5Quest1 {
	 public static void main(String[] args) {
	        int lineWidth = 32; // change line width here
	        int row_length = (int)(Math.log(lineWidth) / Math.log(2)) + 1;
	        char[][] treeArray = new char[row_length][lineWidth];
	        for (int i = 0; i < row_length; i++) {
	            for (int j = 0; j < lineWidth; j++) {
	                treeArray[i][j] = '-';
	            }
	        }
	        
	        makeBranches(treeArray, 0, lineWidth - 1, 0);

	        display(treeArray);
}
	 
	  public static void makeBranches(char[][] tree, int left, int right, int level) {
	        if (level >= tree.length) {
	            return; 
	        }

	        int mid = left + (right - left) / 2;
	        tree[level][mid] = 'X'; 

	        
	        makeBranches(tree, left, mid - 1, level + 1);
	        makeBranches(tree, mid + 1, right, level + 1);
	    }
	  
	  public static void display(char[][] tree) {
	        for (int i = 0; i < tree.length; i++) {
	            for (int j = 0; j < tree[i].length; j++) {
	                System.out.print(tree[i][j]);
	            }
	            System.out.println(); 
	        }
	    }
}
