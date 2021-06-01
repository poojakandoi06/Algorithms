
public class AVLtree {
		public class Node{
			int data;
			Node left;
			Node right;
			int height;
			public Node(int val) {
				this.data=val;
				this.left=null;
				this.right=null;
				this.height=1;
			}
		}
		
			Node root;
			
			int height(Node root) {
				if(root==null)
					return 0;
				return root.height;
				
			}
			int getbalance(Node root) {
				if(root==null)
					return 0;
				return height(root.left)-height(root.right);
			}
			Node rightrotate(Node y) {
				Node x=y.left;
				Node xrchild=x.right;
				
				x.right=y;
				y.left=xrchild;
				
				y.height=Math.max(height(y.left), height(y.right))+1;
				x.height=Math.max(height(x.left), height(x.right))+1;
				
				return x;
			}
			Node leftrotate(Node x) {
				Node y=x.right;
				Node ylchild=y.left;
				
				y.left=x;
				x.right=ylchild;
				x.height=Math.max(height(x.left), height(x.right))+1;
				y.height=Math.max(height(y.left), height(y.right))+1;
				
				return y;
			}
			public Node insert(Node root,int key) {
				if(root==null) {
					root=new Node(key);
					return root;
				}
				if(key<root.data) 
					root.left=insert(root.left,key);
				
				else if(key>root.data) 
					root.right=insert(root.right,key);
				
				else
					return root;
				
				root.height=1+Math.max(height(root.left),height(root.right));
				int balance=getbalance(root);
				
				if(balance>1 && key<root.left.data) {  //LL case
					root=rightrotate(root);
				}
				else if(balance<-1 && key>root.right.data) {
					root=leftrotate(root);
				}
				else if(balance>1 && key>root.left.data) {
					root.left=leftrotate(root.left);
					root=rightrotate(root);
				}
				else if(balance<-1 && key<root.right.data) {
					root.right=rightrotate(root.right);
					root=leftrotate(root);
				}
				
				return root;
			}
			Node minValueNode(Node node)  
		    {  
		        Node current = node;  
		  
		        while (current.left != null)  
		        current = current.left;  
		  
		        return current;  
		    }  
			public Node delete(Node root, int key) {
				if(root==null) {
					return null;
				}
				if(key<root.data) {
					root.left=delete(root.left, key);
				}
				else if(key>root.data) {
					root.right=delete(root.right,key);
				}
				else {
					if((root.left==null) ||( root.right==null)) {
						Node temp=null;
						if(temp==root.left)
							temp=root.right;
						else
							temp=root.left;
						
						if(temp==null) {
							temp=root;
							root=null;
						}
							
						else {
							root=temp;
						}
							
					}
					else {
						Node temp=minValueNode(root.right);
						root.data=temp.data;
						root.right=delete(root.right,temp.data);
					}
				}
				
				if(root==null)
					return root;
				
				//System.out.println(root.data);
				root.height=1+Math.max(height(root.left),height(root.right));
				
				int balance=getbalance(root);
				//System.out.println(balance);
				if(balance>1 && getbalance(root.left)>=0) {
					root= rightrotate(root);
					//System.out.println(root.data);
					return root;
				}
				else if(balance<-1 && getbalance(root.right)<=0) {
					return leftrotate(root);
				}
					
				else if(balance>1 && getbalance(root.left)<0) {
					root.left=leftrotate(root.left);
					return rightrotate(root);
				}
				else if(balance<-1 && getbalance(root.right)>0) {
					root.right=rightrotate(root.right);
					return leftrotate(root);
				}
				return root;
			}
		
		public static void main(String[] args) {
			AVLtree tree=new AVLtree();
			tree.root = tree.insert(tree.root, 9);  
	        tree.root = tree.insert(tree.root, 5);  
	        tree.root = tree.insert(tree.root, 10);  
	        tree.root = tree.insert(tree.root, 0);  
	        tree.root = tree.insert(tree.root, 6);  
	        tree.root = tree.insert(tree.root, 11);  
	        tree.root = tree.insert(tree.root, -1);  
	        tree.root = tree.insert(tree.root, 1);  
	        tree.root = tree.insert(tree.root, 2); 
	        //System.out.println(tree.root.data);
			preorder(tree.root);
			System.out.println();
			tree.root = tree.delete(tree.root, 10);  
			preorder(tree.root);
			System.out.println();
	       // System.out.println(tree.root.data);


		}
		
		public static void preorder(Node root) {
			if(root==null)
				return;
			System.out.print(root.data+" ");
			preorder(root.left);
			//System.out.print(root.data+" ");

			preorder(root.right);
		}

	}



