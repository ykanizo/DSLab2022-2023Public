package il.ac.telhai.ds.heap;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import il.ac.telhai.ds.misc.Person;

public class HeapTest {

	Integer[] arr = {10,9,8,7,6,5,4,3,2,1};
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testHeapInt() {
		Heap<Integer> heap = new Heap<Integer>(5);
		assertEquals("[]", heap.toString());
	}

	@Test
	public void testHeapPerson() {
		Person p1 = new Person("123456789", "One", "One");
		Person p2 = new Person("234567891", "One", "One");
		Heap<Person> heap = new Heap<Person>(5);
		heap.insert(p1);
		heap.insert(p2);
		assertSame(p1, heap.deleteMin());
	}
	
	@Test
	public void testHeapTArray() {
		Heap<Integer> heap = new Heap<Integer>(arr);
		assertEquals("[1,2,4,3,6,5,8,10,7,9]", heap.toString());
	}

	@Test
	public void testIsFull() {
		Heap<Integer> heap = new Heap<Integer>(2);
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
		Heap<Integer> heap = new Heap<Integer>(5);
		assertTrue(heap.isEmpty());
		heap.insert(7);
		assertFalse(heap.isEmpty());
	}

	@Test
	public void testInsertSingle() {
		Heap<Integer> heap = new Heap<Integer>(5);
		heap.insert(10);
		assertEquals("[10]", heap.toString());
	}

	@Test
	public void testInsertTwoNoFlip() {
		Heap<Integer> heap = new Heap<Integer>(5);
		heap.insert(10);
		heap.insert(15);
		assertEquals("[10,15]", heap.toString());
	}

	@Test
	public void testInsertTwoWithFlip() {
		Heap<Integer> heap = new Heap<Integer>(5);
		heap.insert(15);
		heap.insert(10);
		assertEquals("[10,15]", heap.toString());
	}

	@Test
	public void testInsertThree() {
		Heap<Integer> heap = new Heap<Integer>(5);
		heap.insert(10);
		heap.insert(15);
		heap.insert(5);
		assertEquals("[5,15,10]", heap.toString());
	}

	@Test
	public void testInsertTooMuch() {
		Heap<Integer> heap = new Heap<Integer>(2);
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
		Heap<Integer> heap = new Heap<Integer>(arr.length);
		for (Integer i : arr) {
			heap.insert(i);		
		}
		assertEquals("[1,2,5,4,3,9,6,10,7,8]", heap.toString());
	}

	
	@Test
	public void testGetMin() {
		Heap<Integer> heap = new Heap<Integer>(5);
		try {
			heap.getMin();
		    fail("Should throw exception");
		} catch (Exception e) {
			
		}
		heap.insert(10);
		assertEquals(new Integer(10), heap.getMin());
		heap.insert(15);
		assertEquals(new Integer(10), heap.getMin());
		heap.insert(5);
		assertEquals(new Integer(5), heap.getMin());
	}

	@Test
	public void testDeleteMinSimple() {
		Heap<Integer> heap = new Heap<Integer>(5);
		heap.insert(10);
		heap.insert(15);
		heap.insert(5);
		assertEquals("[5,15,10]", heap.toString());
		assertEquals(new Integer(5), heap.deleteMin());
		assertEquals("[10,15]", heap.toString());
		assertEquals(new Integer(10), heap.deleteMin());
		assertEquals("[15]", heap.toString());
		assertEquals(new Integer(15), heap.deleteMin());
		assertEquals("[]", heap.toString());
        assertNull(heap.deleteMin());
	}

	@Test
	public void testDeleteMinComplex() {
		Heap<Integer> heap = new Heap<Integer>(arr);
		assertEquals("[1,2,4,3,6,5,8,10,7,9]", heap.toString());
		assertEquals(new Integer(1), heap.deleteMin());
		assertEquals("[2,3,4,7,6,5,8,10,9]", heap.toString());
		assertEquals(new Integer(2), heap.deleteMin());
		assertEquals("[3,6,4,7,9,5,8,10]", heap.toString());
		assertEquals(new Integer(3), heap.deleteMin());
		assertEquals("[4,6,5,7,9,10,8]", heap.toString());
		assertEquals(new Integer(4), heap.deleteMin());
		assertEquals("[5,6,8,7,9,10]", heap.toString());
		assertEquals(new Integer(5), heap.deleteMin());
		assertEquals("[6,7,8,10,9]", heap.toString());
		assertEquals(new Integer(6), heap.deleteMin());
		assertEquals("[7,9,8,10]", heap.toString());
		assertEquals(new Integer(7), heap.deleteMin());
		assertEquals("[8,9,10]", heap.toString());
		assertEquals(new Integer(8), heap.deleteMin());
		assertEquals("[9,10]", heap.toString());
		assertEquals(new Integer(9), heap.deleteMin());
		assertEquals("[10]", heap.toString());
		assertEquals(new Integer(10), heap.deleteMin());
		assertEquals("[]", heap.toString());
        assertNull(heap.deleteMin());
	}

}
