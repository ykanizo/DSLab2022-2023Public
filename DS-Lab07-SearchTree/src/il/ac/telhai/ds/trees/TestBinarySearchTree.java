package il.ac.telhai.ds.trees;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import il.ac.telhai.ds.misc.Person;
import il.ac.telhai.ds.misc.PersonKey;

public class TestBinarySearchTree {

	private Person p1;
	private Person p3;
	private Person p5;
	private Person p7;
	private Person p10;
	private Person p15;
	private BinarySearchTree<PersonKey, Person> treePerson;

	@Before
	public void setUp() throws Exception {
		p10 = new Person("10", "10firstName", "10lastName");
		p5 = new Person("05", "05firstName", "05lastName");
		p1 = new Person("01", "01firstName", "01lastName");
		p3 = new Person("03", "03firstName", "03lastName");
		p7 = new Person("07", "07firstName", "07lastName");
		p15 = new Person("15", "15firstName", "15lastName");
		treePerson = new BinarySearchTree<PersonKey, Person>(p10.getKey(), p10);
		treePerson.add(p5.getKey(), p5);
		treePerson.add(p1.getKey(), p1);
		treePerson.add(p3.getKey(), p3);
		treePerson.add(p7.getKey(), p7);
		treePerson.add(p15.getKey(), p15);
	}

	@Test
	public void testSet() {
		try {
			treePerson.setValue(p1);
			fail("Shouldn't work");
		}
		catch (Exception e) {
		}
		
		try {
			treePerson.setLeft(new BinaryTree<Person>(p1));
			fail("Shouldn't work");
		}
		catch (Exception e) {
		}
		
		try {
			treePerson.setRight(new BinaryTree<Person>(p15));
			fail("Shouldn't work");
		}
		catch (Exception e) {
		}
		
		try {
			treePerson.setLeft( new BinarySearchTree<PersonKey, Person>(p15.getKey(), p15));
			fail("Shouldn't work");
		}
		catch (Exception e) {
		}
		
		try {
			treePerson.setRight( new BinarySearchTree<PersonKey, Person>(p1.getKey(), p1));
			fail("Shouldn't work");
		}
		catch (Exception e) {
		}
		
		treePerson.setLeft(null);
		treePerson.setRight(null);
	}
	
	@Test
	public void testAdd1() {
		BinaryTreeI<String> n3 = new BinaryTree<String>("03");
		BinaryTreeI<String> n1 = new BinaryTree<String>("01", null, n3);
		BinaryTreeI<String> n7 = new BinaryTree<String>("07");
		BinaryTreeI<String> n5 = new BinaryTree<String>("05", n1, n7);
		BinaryTreeI<String> n15 = new BinaryTree<String>("15");
		BinaryTreeI<String> n10 = new BinaryTree<String>("10", n5, n15);
		assertEquals(n10.getValue(), treePerson.getValue().getId());
		TestAllTreeVals(n10, treePerson);

	}

	private void TestAllTreeVals(BinaryTreeI<String> binaryTree, BinarySearchTree<PersonKey, Person> searchTree) {
		if (binaryTree == null) {
			assertFalse(searchTree != null);
			return;
		}
		if (searchTree == null) {
			assertFalse(binaryTree != null);
			return;
		}
		assertEquals(binaryTree.getValue(), searchTree.getValue().getId());
		TestAllTreeVals(binaryTree.getLeft(), (BinarySearchTree<PersonKey, Person>) searchTree.getLeft());
		TestAllTreeVals(binaryTree.getRight(), (BinarySearchTree<PersonKey, Person>) searchTree.getRight());
	}

	@Test
	public void testEmptyTree() {
		treePerson.clear();
		assertEquals(1, treePerson.size());
		assertEquals(0, treePerson.height());
	}

	@Test
	public void testAdd2() {
		assertEquals(6, treePerson.size());
		try {
			treePerson.add(p5.getKey(), p10);
			fail("shouldn't work");
		} catch (Exception e) {
		}
		assertEquals(6, treePerson.size());
		try {
			treePerson.add(new PersonKey("05", "05lastName"), p10);
		} catch (Exception e) {
		}

		assertEquals(6, treePerson.size());
		Person p = new Person("02", "02firstName", "02lastName");
		treePerson.add(p.getKey(), p);
		assertEquals(7, treePerson.size());
	}

	@Test
	public void testRemoveExistingLeaf() {
		assertEquals(treePerson.remove(new PersonKey("03", "03lastName")).getKey(),
				new Person("03", "03firstName", "03lastName").getKey());
		assertEquals(5, treePerson.size());
		assertNull(treePerson.remove(p3.getKey()));
		assertNull(treePerson.find(p3.getKey()));
	}

	@Test
	public void testRemoveExistingMiddleItemWithEmptyLeftChild() {

		Person p8 = new Person("08", "08firstName", "08lastName");
		treePerson.add(p8.getKey(), p8);
		assertEquals(treePerson.getLeft().getRight().getRight().getValue(), p8);
		assertEquals(treePerson.remove(p7.getKey()), p7);
		assertEquals(treePerson.getLeft().getRight().getValue(), p8);
	}

	@Test
	public void testRemoveExistingMiddleItemWithEmptyRightChild() {
		Person p6 = new Person("06", "06firstName", "06lastName");
		treePerson.add(p6.getKey(), p6);
		assertEquals(treePerson.getLeft().getRight().getLeft().getValue(), p6);
		assertEquals(treePerson.remove(p7.getKey()), p7);
		assertEquals(treePerson.getLeft().getRight().getValue(), p6);
	}

	@Test
	public void testRemoveExistingMiddleItemWithTwoChildren1() {
		Person p8 = new Person("08", "08firstName", "08lastName");
		Person p6 = new Person("06", "06firstName", "06lastName");
		Person p2 = new Person("02", "02firstName", "02lastName");
		
		treePerson.add(p8.getKey(), p8);
		treePerson.add(p6.getKey(), p6);
		treePerson.add(p2.getKey(), p2);
		isSearchTree(treePerson);
		assertEquals(treePerson.size(),9);
	
		assertEquals(treePerson.getLeft().getRight().getRight().getValue(), p8);
		assertEquals(treePerson.getLeft().getRight().getLeft().getValue(), p6);
		assertEquals(treePerson.getLeft().getRight().getLeft().getValue(), p6);
		
		assertEquals(treePerson.remove(p7.getKey()), p7);
		assertEquals(treePerson.size(),8);
		isSearchTree(treePerson);
		
		treePerson.add(p7.getKey(), p7);
		assertEquals(treePerson.size(),9);
		treePerson.remove(p5.getKey());
		assertEquals(treePerson.size(),8);
		isSearchTree(treePerson);
		
		
	}

	private <K extends Comparable<K>, T> boolean isSearchTree(BinarySearchTree<K, T> searchTree) {
		if (searchTree == null)
			return false;
		if (searchTree.getLeft() != null) {
			int comparingLeft = searchTree.getKey().compareTo(searchTree.getLeft().getKey());
			if (comparingLeft > 0)
				return false;
			if (isSearchTree(searchTree.getLeft()) == false)
				return false;
		}
		if (searchTree.getRight() != null) {
			int comparingRight = searchTree.getKey().compareTo(searchTree.getRight().getKey());
			if (comparingRight < 0)
				return false;
			if (isSearchTree(searchTree.getRight()) == false)
				return false;
		}
		return true;

	}


	@Test
	public void testOtherType() {
		BinarySearchTree<Integer, String> tree = new BinarySearchTree<Integer, String>(5, "E");
		tree.add(4, "D");
		tree.add(2, "B");
		tree.add(3, "C");
		tree.add(6, "F");
		tree.add(1, "A");

		assertEquals(6, tree.size());
		assertEquals(tree.find(3), "C");
		tree.remove(3);
		assertNull(tree.find(3));

		assertEquals(tree.findLE(3), "B");
		assertEquals(tree.findGE(0), "A");
		assertNull(tree.findLE(0));
		assertNull(tree.findGE(7));
	}


}
