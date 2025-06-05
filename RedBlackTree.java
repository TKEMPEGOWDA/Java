import java.util.Stack;

enum Color {
    RED, BLACK
}

class RBNode {
    int data;
    RBNode parent;
    RBNode left;
    RBNode right;
    Color color;

    public RBNode(int data) {
        this.data = data;
        this.color = Color.RED;
    }
    
    public void displayNode() {
        
        System.out.print(data);
        if(color == Color.RED)
        {
        	System.out.print("R"+" ");
        }
        else
        {
        	System.out.print("B"+" ");
        }
      }
}

public class RedBlackTree {
    private RBNode root;

    private void RBrotateLeft(RBNode x) {
        RBNode y = x.right;
        x.right = y.left;
        if (y.left != null) {
            y.left.parent = x;
        }
        y.parent = x.parent;
        if (x.parent == null) {
            root = y;
        } else if (x == x.parent.left) {
            x.parent.left = y;
        } else {
            x.parent.right = y;
        }
        y.left = x;
        x.parent = y;
    }

    private void RBrotateRight(RBNode y) {
        RBNode x = y.left;
        y.left = x.right;
        if (x.right != null) {
            x.right.parent = y;
        }
        x.parent = y.parent;
        if (y.parent == null) {
            root = x;
        } else if (y == y.parent.right) {
            y.parent.right = x;
        } else {
            y.parent.left = x;
        }
        x.right = y;
        y.parent = x;
    }

    private void adjustAfterInsertion(RBNode nod) {
        while (nod != null && nod != root && nod.parent.color == Color.RED) {
            if (nod.parent == nod.parent.parent.left) {
                RBNode y = nod.parent.parent.right;
                if (y != null && y.color == Color.RED) {
                    nod.parent.color = Color.BLACK;
                    y.color = Color.BLACK;
                    nod.parent.parent.color = Color.RED;
                    nod = nod.parent.parent;
                } else {
                    if (nod == nod.parent.right) {
                        nod = nod.parent;
                        RBrotateLeft(nod);
                    }
                    nod.parent.color = Color.BLACK;
                    nod.parent.parent.color = Color.RED;
                    RBrotateRight(nod.parent.parent);
                }
            } else {
                RBNode y = nod.parent.parent.left;
                if (y != null && y.color == Color.RED) {
                    nod.parent.color = Color.BLACK;
                    y.color = Color.BLACK;
                    nod.parent.parent.color = Color.RED;
                    nod = nod.parent.parent;
                } else {
                    if (nod == nod.parent.left) {
                        nod = nod.parent;
                        RBrotateRight(nod);
                    }
                    nod.parent.color = Color.BLACK;
                    nod.parent.parent.color = Color.RED;
                    RBrotateLeft(nod.parent.parent);
                }
            }
        }
        root.color = Color.BLACK;
    }


    public static void displayTree(RBNode root) { 
        Stack<RBNode> globalStack = new Stack<RBNode>();
        globalStack.push(root);
        int nBlanks = 32;
        boolean isRowEmpty = false;
        System.out.println("................................................................");
        while (isRowEmpty == false) {
          Stack<RBNode> localStack = new Stack<RBNode>();
          isRowEmpty = true;

          for (int i = 0; i < nBlanks; i++) {
            System.out.print(" ");
          }

          while (globalStack.isEmpty() == false) {
        	  RBNode tempNode = globalStack.pop();
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
    
    
    public void insert(int data) {
        RBNode RBNode = new RBNode(data);
        if (root == null) {
            root = RBNode;
            root.color = Color.BLACK;
        } else {
            RBNode current = root;
            RBNode parent = null;
            while (current != null) {
                parent = current;
                if (RBNode.data < current.data) {
                    current = current.left;
                } else {
                    current = current.right;
                }
            }
            RBNode.parent = parent;
            if (parent != null) {
                if (RBNode.data < parent.data) {
                    parent.left = RBNode;
                } else {
                    parent.right = RBNode;
                }
            }
            adjustAfterInsertion(RBNode);
        }
    }

    public void display() {
    	displayTree(root);
    }

    public static void main(String[] args) {
        RedBlackTree rbTree = new RedBlackTree();
        rbTree.insert(50);
        rbTree.insert(25);
        rbTree.insert(75);
        rbTree.insert(12);
        rbTree.insert(37);
        rbTree.insert(6);
        rbTree.insert(18);
        rbTree.insert(3);
        
        rbTree.display();

    }
}
