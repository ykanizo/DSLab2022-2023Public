package il.ac.telhai.ds.trees;
	
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestAVLTree {

	AVLTree<Integer, String> avlTree;

	@Test
	public void buildAVLTree() {
		AVLTree<Integer, String> avlTree = new AVLTree<Integer, String>(11, "11");
		for (int i = 0; i < 10; i++) {
			int k = 2 * i;
			avlTree = avlTree.add(k, String.valueOf(k));
		}

		String s = inOrder(avlTree);
		assertEquals(s, " 0  2  4  6  8  10  11  12  14  16  18 ");
		checkTreeStructure(avlTree);
	}

	private void checkTreeStructure(AVLTree<Integer, String> avlTree) {
		assertEquals(avlTree.getValue(), "6");

		assertEquals(avlTree.getLeft().getValue(), "2");
		assertEquals(avlTree.getRight().getValue(), "12");

		assertEquals(avlTree.getLeft().getLeft().getValue(), "0");
		assertEquals(avlTree.getLeft().getRight().getValue(), "4");
		assertEquals(avlTree.getRight().getLeft().getValue(), "10");
		assertEquals(avlTree.getRight().getRight().getValue(), "16");

		assertEquals(avlTree.getRight().getLeft().getLeft().getValue(), "8");
		assertEquals(avlTree.getRight().getLeft().getRight().getValue(), "11");
		assertEquals(avlTree.getRight().getRight().getLeft().getValue(), "14");
		assertEquals(avlTree.getRight().getRight().getRight().getValue(), "18");
	}

	private String inOrder(AVLTree<Integer, String> tree) {
		StringBuilder sb = new StringBuilder();

		if (tree.getLeft() != null) {
			sb.append(inOrder(tree.getLeft()));
		}
		sb.append(" ");
		sb.append(tree.getValue());
		sb.append(" ");
		if (tree.getRight() != null) {
			sb.append(inOrder(tree.getRight()));
		}
		return sb.toString();
	}

	@Test
	public void testSingleRotateLeft() {
		AVLTree<Integer, String> tree = new AVLTree<Integer, String>(0, "0");
		tree = tree.add(10, "10");
		tree = tree.add(20, "20");
		testTree(tree);
	}

	@Test
	public void testSingleRotateRight() {
		AVLTree<Integer, String> tree = new AVLTree<Integer, String>(20, "20");
		tree = tree.add(10, "10");
		tree = tree.add(0, "0");
		testTree(tree);
	}

	@Test
	public void testDoubleRotateLeftRight() {
		AVLTree<Integer, String> tree = new AVLTree<Integer, String>(20, "20");
		tree = tree.add(0, "0");
		tree = tree.add(10, "10");
		testTree(tree);
	}

	@Test
	public void testDoubleRotateRightLeft() {
		AVLTree<Integer, String> tree = new AVLTree<Integer, String>(10, "10");
		tree = tree.add(20, "20");
		tree = tree.add(0, "0");
		testTree(tree);
	}

	private void testTree(AVLTree<Integer, String> tree) {
		assertEquals(tree.getValue(), "10");
		assertEquals(tree.getLeft().getValue(), "0");
		assertEquals(tree.getRight().getValue(), "20");
	}
}