package bst;

import java.util.ArrayList;
import java.util.Comparator;


public class BinarySearchTree<E> {
	BinaryNode<E> root;  // Används också i BSTVisaulizer
	int size;            // Används också i BSTVisaulizer
	private Comparator<E> comparator;

	/**
	 * Constructs an empty binary search tree.
	 */
	public BinarySearchTree () {
		// tror att detta är rätt?
		root = null;
		comparator = (e1, e2) -> ((Comparable<E>) e1).compareTo(e2);
	}

	/**
	 * Constructs an empty binary search tree, sorted according to the specified comparator.
	 */
	public BinarySearchTree(Comparator<E> comparator) {
		// tror att detta är rätt?
		root = null;
		this.comparator = comparator;
	}

	/**
	 * Inserts the specified element in the tree if no duplicate exists.
	 *
	 * @param x element to be inserted
	 * @return true if the the element was inserted
	 */
	public boolean add(E x) {
		if (root==null) {
			this.root = new BinaryNode<>(x);
			this.size++;
			return true;
		}
		return this.add(this.root, x);
	}

	/**
	 * Recursively search through BST to see if elem x can be added and doing so if possible
	 * @param 	p node
	 * @param 	x element to add
	 * @return 	true if added, false if not
	 */
	private boolean add(BinaryNode<E> p, E x) {
		BinaryNode<E> node = new BinaryNode<>(x);
		if (comparator.compare(x, p.element) == 0) {
			return false;
			// check for right side
		} else if (comparator.compare(x, p.element) < 0) {
			if (p.left==null) {
				p.left=node;
				this.size++;
			} else {
				return this.add(p.left, x);
			}
			// check for left side
		} else {
			if (p.right == null) {
				p.right = node;
				this.size++;
			} else {
				return this.add(p.right, x);
			}
		}
		return true;
	}

		/**
		 * Computes the height of tree.
		 * @return the height of the tree
		 */
		public int height () {
			return this.height(root);
		}

		/**
		 * Recursively calculate the height of the tree
		 * @param  aNode
		 * @return the height of the tree
		 */
		private int height (BinaryNode < E > n) {
			// https://www.youtube.com/watch?v=AWIJwNf0ZQE
			return n == null ? 0 : 1 + Math.max(height(n.left), height(n.right));
		}

		/**
		 * Returns the number of elements in this tree.
		 * @return the number of elements in this tree
		 */
		public int size () {
			return this.size;
		}

		/**
		 * Removes all of the elements from this list.
		 */
		public void clear () {
			this.root = null;
			this.size = 0;
		}

		/**
		 * Print tree contents in inorder.
		 */
		public void printTree () {
			/*
			SEE THIS PIC for some light midget porn
			https://www.techiedelight.com/wp-content/uploads/Inorder-Traversal.png
			 */
			printTree(root);
		}

	/**
	 * Systematically goes through BST inorder and prints out its content
	 * @param n	BinaryNode<E> n
	 */
	private void printTree (BinaryNode<E> n) {
			if (n!=null) {
				// har skrivit denna men fattar inte lol, behöver tänka tsm
				this.printTree(n.left);
				System.out.println(n.element);
				this.printTree(n.right);
			}
		}

	/**
	 * Builds a complete tree from the elements in the tree.
	 */
	public void rebuild () {

	}

	/*
	 * Adds all elements from the tree rooted at n in inorder to the list sorted.
	 */
	private void toArray (BinaryNode < E > n, ArrayList < E > sorted){

	}

	/*
	 * Builds a complete tree from the elements from position first to
	 * last in the list sorted.
	 * Elements in the list a are assumed to be in ascending order.
	 * Returns the root of tree.
	 */
	private BinaryNode<E> buildTree (ArrayList < E > sorted,int first, int last){
		return null;
	}

	static class BinaryNode<E> {
		E element;
		BinaryNode<E> left;
		BinaryNode<E> right;

		private BinaryNode(E element) {
			this.element = element;
		}
	}
}