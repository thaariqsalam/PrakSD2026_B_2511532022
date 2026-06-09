package pekan9_2511532022;

public class Node_2511532022 {
    int data_2022;
    Node_2511532022 left_2022;
    Node_2511532022 right_2022;

    public Node_2511532022(int data) {
        this.data_2022 = data;
        left_2022 = null;
        right_2022 = null;
    }
// SET
    public void setLeft(Node_2511532022 node) {
        if (left_2022 == null)
            left_2022 = node;
    }

    public void setRight(Node_2511532022 node) {
        if (right_2022 == null)
            right_2022 = node;
    }
    
// GET
    public Node_2511532022 getLeft() {
        return left_2022;
    }

    public Node_2511532022 getRight() {
        return right_2022;
    }

    public int getData() {
        return data_2022;
    }
    public void setData(int data) {
        this.data_2022 = data;
    }

    
    //===============================================
    // Traversal Methods
    void printPreorder(Node_2511532022 node) {
        if (node == null) 
        	return;
        System.out.print(node.data_2022 + " ");
        printPreorder(node.left_2022);
        printPreorder(node.right_2022);
    }

    void printPostorder(Node_2511532022 node) {
        if (node == null) 
        	return;
        printPostorder(node.left_2022);
        printPostorder(node.right_2022);
        System.out.print(node.data_2022 + " ");
    }

    void printInorder(Node_2511532022 node) {
        if (node == null) 
        	return;
        printInorder(node.left_2022);
        System.out.print(node.data_2022 + " ");
        printInorder(node.right_2022);
    }

   
    public String print() {
        return this.print("", true, "");
    }
    public String print(String prefix, boolean isTail, String sb) {
        if (right_2022 != null) {
        	right_2022.print(prefix + (isTail ? "|   ": "	"), false, sb);
        }
        
        System.out.println(prefix + (isTail ? "\\-- " : "/--") + data_2022);
        
        if (left_2022 != null) {
        	left_2022.print(prefix + (isTail ? "    ": "|	"), true, sb);
        }
        return sb;
    }
}