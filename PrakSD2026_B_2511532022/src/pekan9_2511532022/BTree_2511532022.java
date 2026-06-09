package pekan9_2511532022;

public class BTree_2511532022 {
	private Node_2511532022 root_2022;
	private Node_2511532022 currentNode_2022;
	public BTree_2511532022() {
		root_2022 = null;
	}
	public boolean search(int data) {
		return search(root_2022, data);
	}
	private boolean search(Node_2511532022 node, int data) {
        
		if (node.getData() == data)
			return true;
		if (node.getLeft() != null)
            if (search(node.getLeft(), data))
				return true;
		if (node.getRight() != null)
					if (search (node.getRight(), data))
						return true;
			return false;
	}
	public void printInorder() {
		root_2022.printInorder(root_2022);
	}
	public void printPreOrder() {
		root_2022.printPreorder(root_2022);
	}
	public void printPostOrder() {
		root_2022.printPostorder(root_2022);
	}
	
	public Node_2511532022 getRoot() {
		return root_2022;
	}
	
	public boolean isEmpty() {
		return root_2022 == null;
	}
	
	public int countNodes() {
		return countNodes(root_2022);
	}
	
	private int countNodes(Node_2511532022 node) {
		int count = 1;
		if (node == null) {
			return 0;
		}	else {
			count += countNodes (node.getLeft());
			count += countNodes (node.getRight());
			return count;
		}
	}
	
	public void print() {
		root_2022.print();
	}
	public Node_2511532022 getCurrent() {
		return currentNode_2022;
	}
	
	public void setCurrent(Node_2511532022 node) {
		this.currentNode_2022 = node;
	}
	
	public void setRoot(Node_2511532022 root) {
		this.root_2022 = root;
	}
}