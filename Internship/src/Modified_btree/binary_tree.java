package Modified_btree;

public class binary_tree {

	public class node {
		int val;
		node left;
		node right;

		public node(int val) {
			this.val = val;

		}
	}

	node root; // root node of the binary tree
	node dummy = new node(-1); // dummy node for the referencing when no child is present to a particular node

	public binary_tree() {
		root = dummy;
	}

	// function to calculate the size of binary Tree
	public int size(node root) {
		if (root.equals(dummy)) {
			return 0;
		}
		return 1 + size(root.left) + size(root.right);
	}

	// function to print the preorder traversal of the binary tree
	public void print_preorder_binary_tree() {
		node node = this.root;
		print(node);
	}

	public void print(node node) {
		if (node.equals(dummy))
			return;
		System.out.println(node.val);
		print(node.left);
		print(node.right);
	}

	// function to insert a new node in a binary tree
	public node insert(int val) {
		if (this.root.equals(dummy)) {
			this.root = new node(val);
			root.left = dummy;
			root.right = dummy;
			return root;
		} else {
			node node = this.root;
			return insertUtil(node, val);
		}

	}

	public node insertUtil(node node, int val) {
		if (node.equals(dummy)) {
			node = new node(val);
			node.left = dummy;
			node.right = dummy;
			return node;
		} else {
			if(node.val<val) {
				node.left=insertUtil(node.left, val);
			}
			else {
				node.right=insertUtil(node.right, val);
			}

			return node;
		}
	}
}
