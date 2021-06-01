package Modified_btree;

public class test {

	public static void main(String[] args) {
		binary_tree btree=new binary_tree();
		btree.root=btree.insert(2);
		btree.root=btree.insert(4);
		btree.root=btree.insert(5);
		btree.root=btree.insert(3);
		btree.root=btree.insert(6);
		btree.root=btree.insert(7);
		btree.root=btree.insert(8);
		System.out.println("Preorder Traversal of Binary Tree");
		btree.print_preorder_binary_tree();

	}

}
