import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public abstract class ListTest<T> {

	private DListFactory<T> dListFactory = new DListFactory<T>();
	private List<T> dList;

	private T newInstance1;
	private T newInstance2;
	private T newInstance3;

	/**
	 * @return a new instance of parameter T. Two instances which are created by
	 *         this method should be different according to "equals" method. For
	 *         example for T=Object, the implementation can be "return new
	 *         Object();".
	 */

	public abstract T getParameterInstance();

	@Before
	public void setUp() throws Exception {
		dList = dListFactory.getDList();

		newInstance1 = getParameterInstance();
		newInstance2 = getParameterInstance();
		newInstance3 = getParameterInstance();
	}

	@Test
	public void testGetParameterInstance() {
		if ((newInstance1.equals(newInstance2)) || (newInstance1.equals(newInstance3))
				|| (newInstance3.equals(newInstance2))) {
			fail("new instances should be different");
		}
	}

	@Test
	public void testInsert() {
		try {
			dList.insert(null);
			fail("Should not work");
		} catch (Exception e) {
		}
		dList.insert(newInstance1);
		assertEquals(newInstance1, dList.getCursor());
	}

	@Test
	public void testReplace() {
		try {
			dList.replace(newInstance1);
			fail("Should not work");
		} catch (Exception e) {
		}

		dList.insert(newInstance1);
		try {
			dList.replace(null);
			fail("Should not work");
		} catch (Exception e) {
		}
		dList.insert(newInstance2);
		dList.insert(newInstance1);

		assertEquals(dList.getCursor(), newInstance1);
		dList.replace(newInstance3);
		assertEquals(dList.getCursor(), newInstance3);

		dList.goToBeginning();
		assertEquals(dList.getCursor(), newInstance1);
		dList.replace(newInstance3);
		assertEquals(dList.getCursor(), newInstance3);

	}

	@Test
	public void testReplaceNextAndPrev() {

		dList.insert(newInstance1);
		dList.insert(newInstance1);
		dList.insert(newInstance3);

		dList.getPrev();
		dList.replace(newInstance2);
		assertEquals(dList.getCursor(), newInstance2);
		assertEquals(dList.getPrev(), newInstance1);
		assertEquals(dList.getNext(), newInstance2);
		assertEquals(dList.getNext(), newInstance3);
		assertEquals(dList.getPrev(), newInstance2);
	}

	@Test
	public void testGoToBeginning() {
		dList.insert(newInstance1);
		dList.insert(newInstance2);
		dList.insert(newInstance3);

		assertEquals(dList.getCursor(), newInstance3);
		assertEquals(dList.goToBeginning(), true);
		assertEquals(dList.getCursor(), newInstance1);
	}

	@Test
	public void testGoToEnd() {
		assertEquals(dList.goToBeginning(), false);
		assertEquals(dList.goToEnd(), false);

		dList.insert(newInstance1);
		dList.insert(newInstance2);
		dList.insert(newInstance3);

		assertEquals(dList.getCursor(), newInstance3);
		assertEquals(dList.goToBeginning(), true);
		assertEquals(dList.getCursor(), newInstance1);
		assertEquals(dList.goToEnd(), true);
		assertEquals(dList.getCursor(), newInstance3);
	}

	@Test
	public void testPrevAndNext() {

		assertFalse(dList.hasNext());
		assertFalse(dList.hasPrev());
		assertNull(dList.getNext());
		assertNull(dList.getPrev());

		dList.insert(newInstance1);
		assertFalse(dList.hasNext());
		assertFalse(dList.hasPrev());
		assertNull(dList.getNext());
		assertNull(dList.getPrev());

		dList.insert(newInstance2);
		assertFalse(dList.hasNext());
		assertTrue(dList.hasPrev());
		assertNull(dList.getNext());
		assertEquals(dList.getPrev(), newInstance1);
		assertEquals(dList.getCursor(), newInstance1);
		assertNull(dList.getPrev());
		assertEquals(dList.getCursor(), newInstance1);
		assertEquals(dList.getNext(), newInstance2);
		assertEquals(dList.getCursor(), newInstance2);

		dList.insert(newInstance3);

	}

	@Test
	public void testRemove() {
		// TODO Implement this test
	}

	@Test
	public void testIsEmpty() {
		// TODO Implement this test
	}

	@Test
	public void testClear() {
		// TODO Implement this test
	}

}
