import java.util.Stack;

class TreeNodeBT {
    char value;
    TreeNodeBT left;
    TreeNodeBT right;

    public TreeNodeBT(char value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
    
    public void displayNode() {
        System.out.print(value + " "); 
      }
}

public class BinaryTreeBuilder {
	
	  public static TreeNodeBT balancedBinaryTreeBuilder(String input) {
		  TreeNodeBT[] forestArray = new TreeNodeBT[input.length()];

	        for (int i = 0; i < input.length(); i++) {
	            forestArray[i] = new TreeNodeBT(input.charAt(i));
	        }

	        int forestArraySize = forestArray.length;
	        int counter = 0;

	        // Loop to create a balanced binary tree
	        while (forestArraySize > 1) {
	        	TreeNodeBT[] newforestArray = new TreeNodeBT[(int) Math.ceil(forestArraySize / 2.0)];
	            for (int i = 0; i < forestArraySize; i += 2) {
	            	TreeNodeBT newNode = new TreeNodeBT('+');
	                newNode.left = forestArray[i];
	                if (i + 1 < forestArraySize) {
	                    newNode.right = forestArray[i + 1];
	                }
	                newforestArray[counter++] = newNode;
	            }
	            forestArray = newforestArray;
	            forestArraySize = counter;
	            counter = 0;
	        }

	        return forestArray[0];
	    }
	
	

    public static void displayTree(TreeNodeBT root) { 
        Stack<TreeNodeBT> globalStack = new Stack<TreeNodeBT>();
        globalStack.push(root);
        int nBlanks = 32;
        boolean isRowEmpty = false;
        System.out.println("................................................................");
        while (isRowEmpty == false) {
          Stack<TreeNodeBT> localStack = new Stack<TreeNodeBT>();
          isRowEmpty = true;

          for (int i = 0; i < nBlanks; i++) {
            System.out.print(" ");
          }

          while (globalStack.isEmpty() == false) {
        	  TreeNodeBT tempNode = globalStack.pop();
            if (tempNode != null) {
              tempNode.displayNode();
              localStack.push(tempNode.left);
              localStack.push(tempNode.right);

              if (tempNode.left != null || tempNode.right != null) {
                isRowEmpty = false;
              }
            } else {
              System.out.print("- "); 
              localStack.push(null);
              localStack.push(null);
            }
            for (int i = 0; i < nBlanks * 2 - 2; i++) {
              System.out.print(" ");
            }
          }
          System.out.println();
          nBlanks /= 2;
          while (localStack.isEmpty() == false) {
            globalStack.push(localStack.pop());
          }
        }
        System.out.println("................................................................");
      }
    
    
    public static void main(String[] args) {
       
        String userInput = "ABCDEFGH";
        TreeNodeBT root2 = balancedBinaryTreeBuilder(userInput);
        displayTree(root2);
        
    }
}
