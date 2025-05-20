import java.util.Stack;

class NodeSub {
    char data;
    NodeSub left;
    NodeSub right;

    public NodeSub(char data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class parsePost {
    private String expression;
    private NodeSub root;
    private Stack<NodeSub> stack;

    public parsePost(String expression) {
        this.expression = expression;
        this.root = null;
        this.stack = new Stack<>();
    }

    public NodeSub parse() {
        for (char token : expression.toCharArray()) {
            if (Character.isLetterOrDigit(token)) {
                stack.push(new NodeSub(token));
            } else {
            	NodeSub operand2 = stack.pop();
            	NodeSub operand1 = stack.pop();
            	NodeSub newNode = new NodeSub(token);
                newNode.left = operand1;
                newNode.right = operand2;
                stack.push(newNode);
            }
        }
        root = stack.pop();
        return root;
    }
}

class TreeSub {
    private NodeSub root;

    public TreeSub(NodeSub root) {
        this.root = root;
    }

    public void inOrder(NodeSub current) {
        if (current != null) {
            if (current.left != null || current.right != null) {
                System.out.print("(");
            }
            inOrder(current.left);
            System.out.print(current.data + " ");
            inOrder(current.right);
            if (current.left != null || current.right != null) {
                System.out.print(")");
            }
        }
    }

    public void postfix(NodeSub current) {
        if (current != null) {
            postfix(current.left);
            postfix(current.right);
            System.out.print(current.data + " ");
        }
    }
    
    public void prefix(NodeSub current) {
        if (current != null) {
        	System.out.print(current.data + " ");
        	prefix(current.left);
        	prefix(current.right);
            
        }
    }
}

public class PostfixToTree {
    public static void main(String[] args) {
        String postfixExpression = "345+*612+/-";
        parsePost parser = new parsePost(postfixExpression);
        NodeSub root = parser.parse();
        TreeSub tree = new TreeSub(root);

        System.out.println("Infix Expression:");
        tree.inOrder(root);
        System.out.println();

        System.out.println("Postfix Expression:");
        tree.postfix(root);
        System.out.println();
        
        System.out.println("Prefix Expression:");
        tree.prefix(root);
        System.out.println();
    }
}
