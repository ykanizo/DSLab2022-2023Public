package il.ac.telhai.ds.trees;

public class BinarySearchTree<T extends Comparable<T>> {

	BstNode root;

	// Binary Search Tree Node
	class BstNode {
		T val;
		BstNode left, right;

		public BstNode(T val) {
			this.val = val;
			left = null;
			right = null;
		}
	}

	public enum Direction {
		LEFT, RIGHT
	}

	// Returns the val given a path from the root.
	// Used for testing. DO NOT DELETE.
	public T getValInPath(Direction... direction) {
		BstNode node = root;
		for (Direction d : direction) {
			if (d.equals(Direction.LEFT) && node.left != null)
				node = node.left;
			else if (d.equals(Direction.RIGHT) && node.right != null)
				node = node.right;
			else
				return null;
		}
		return node.val;
	}

	/**
	 * Constructs an empty BinarySearchTree.
	 */
	public BinarySearchTree() {
		// Complete this code.
	}

	/**
	 * returns the number of elements in the tree
	 * 
	 * @param val
	 */
	public int size() {
		// Complete this code.
	}

	/**
	 * Adds the object value to the tree as a leaf according to the parameter.
	 * 
	 * @param val
	 * @return True, if the element was added. Otherwise false.
	 */
	public boolean add(T val) {
		// Complete this code.
	}

	/**
	 * Removes the object in the tree which is equal to the parameter. If the object
	 * was found but the tree contains only one element, it want be removed and a
	 * run-time exception will be thrown. Nothing is done if not found
	 * 
	 * @param val: the object to be looked for in the tree
	 * @return True, if the element was removed. Otherwise false.
	 */
	public boolean remove(T val) {
		// Complete this code.
	}

	/**
	 * Looks for an object which is equal to the parameter.
	 * 
	 * @param val: the object to be looked for in the tree
	 * @return true if the tree contains this object. Otherwise, return false.
	 */
	public boolean contains(T val) {
		// Complete this code.
	}

	/**
	 * Looks for the minimal object in the tree, which is greater than or equal to
	 * the parameter.
	 * 
	 * @param val: the object to be looked for in the tree
	 * @return a reference to the found object.
	 */
	public T findGe(T val) {
		// Complete this code.
	}

}
