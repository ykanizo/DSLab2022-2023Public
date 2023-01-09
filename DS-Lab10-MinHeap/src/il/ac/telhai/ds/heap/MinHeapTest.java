package il.ac.telhai.ds.heap;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import il.ac.telhai.ds.misc.Person;

public class MinHeapTest {

	Integer[] arr = {10,9,8,7,6,5,4,3,2,1};
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testHeapInt() {
		MinHeap<Integer> heap = new MinHeap<Integer>(5);
		assertEquals("[]", heap.toString());
	}

	@Test
	public void testHeapPerson() {
		Person p1 = new Person("123456789", "One", "One");
		Person p2 = new Person("234567891", "One", "One");
		MinHeap<Person> heap = new MinHeap<Person>(5);
		heap.insert(p1);
		heap.insert(p2);
		assertSame(p1, heap.deleteMin());
	}
	
	@Test
	public void testHeapTArray() {
		MinHeap<Integer> heap = new MinHeap<Integer>(arr);
		assertEquals("[1,2,4,3,6,5,8,10,7,9]", heap.toString());
	}

	@Test
	public void testIsFull() {
		MinHeap<Integer> heap = new MinHeap<Integer>(2);
		assertFalse(heap.isFull());
		heap.insert(7);
		assertFalse(heap.isFull());
		heap.insert(7);
		assertTrue(heap.isFull());
		heap.deleteMin();
		assertFalse(heap.isFull());
	}

	@Test
	public void testIsEmpty() {
		MinHeap<Integer> heap = new MinHeap<Integer>(5);
		assertTrue(heap.isEmpty());
		heap.insert(7);
		assertFalse(heap.isEmpty());
	}

	@Test
	public void testInsertSingle() {
		MinHeap<Integer> heap = new MinHeap<Integer>(5);
		heap.insert(10);
		assertEquals("[10]", heap.toString());
	}

	@Test
	public void testInsertTwoNoFlip() {
		MinHeap<Integer> heap = new MinHeap<Integer>(5);
		heap.insert(10);
		heap.insert(15);
		assertEquals("[10,15]", heap.toString());
	}

	@Test
	public void testInsertTwoWithFlip() {
		MinHeap<Integer> heap = new MinHeap<Integer>(5);
		heap.insert(15);
		heap.insert(10);
		assertEquals("[10,15]", heap.toString());
	}

	@Test
	public void testInsertThree() {
		MinHeap<Integer> heap = new MinHeap<Integer>(5);
		heap.insert(10);
		heap.insert(15);
		heap.insert(5);
		assertEquals("[5,15,10]", heap.toString());
	}

	@Test
	public void testInsertTooMuch() {
		MinHeap<Integer> heap = new MinHeap<Integer>(2);
		heap.insert(1);
		heap.insert(2);
		try {
		    heap.insert(3);
		    fail("Should throw exception");
		} catch (Exception e) {
			// This is OK
		}
	}

	@Test
	public void testInsertTen() {
		MinHeap<Integer> heap = new MinHeap<Integer>(arr.length);
		for (Integer i : arr) {
			heap.insert(i);		
		}
		assertEquals("[1,2,5,4,3,9,6,10,7,8]", heap.toString());
	}

	
	@Test
	public void testGetMin() {
		MinHeap<Integer> heap = new MinHeap<Integer>(5);
		try {
			heap.getMin();
		    fail("Should throw exception");
		} catch (Exception e) {
			
		}
		heap.insert(10);
		assertEquals(10, (int) heap.getMin());
		heap.insert(15);
		assertEquals(10, (int) heap.getMin());
		heap.insert(5);
		assertEquals(5, (int) heap.getMin());
	}

	@Test
	public void testDeleteMinSimple() {
		MinHeap<Integer> heap = new MinHeap<Integer>(5);
		heap.insert(10);
		heap.insert(15);
		heap.insert(5);
		assertEquals("[5,15,10]", heap.toString());
		assertEquals(5, (int) heap.deleteMin());
		assertEquals("[10,15]", heap.toString());
		assertEquals(10, (int) heap.deleteMin());
		assertEquals("[15]", heap.toString());
		assertEquals(15, (int) heap.deleteMin());
		assertEquals("[]", heap.toString());
        assertNull(heap.deleteMin());
	}

	@Test
	public void testDeleteMinComplex() {
		MinHeap<Integer> heap = new MinHeap<Integer>(arr);
		assertEquals("[1,2,4,3,6,5,8,10,7,9]", heap.toString());
		assertEquals(1, (int) heap.deleteMin());
		assertEquals("[2,3,4,7,6,5,8,10,9]", heap.toString());
		assertEquals(2, (int) heap.deleteMin());
		assertEquals("[3,6,4,7,9,5,8,10]", heap.toString());
		assertEquals(3, (int) heap.deleteMin());
		assertEquals("[4,6,5,7,9,10,8]", heap.toString());
		assertEquals(4, (int) heap.deleteMin());
		assertEquals("[5,6,8,7,9,10]", heap.toString());
		assertEquals(5, (int) heap.deleteMin());
		assertEquals("[6,7,8,10,9]", heap.toString());
		assertEquals(6, (int) heap.deleteMin());
		assertEquals("[7,9,8,10]", heap.toString());
		assertEquals(7, (int) heap.deleteMin());
		assertEquals("[8,9,10]", heap.toString());
		assertEquals(8, (int) heap.deleteMin());
		assertEquals("[9,10]", heap.toString());
		assertEquals(9, (int) heap.deleteMin());
		assertEquals("[10]", heap.toString());
		assertEquals(10, (int) heap.deleteMin());
		assertEquals("[]", heap.toString());
        assertNull(heap.deleteMin());
	}

}
