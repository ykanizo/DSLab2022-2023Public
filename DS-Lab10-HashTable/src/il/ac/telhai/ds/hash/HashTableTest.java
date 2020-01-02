package il.ac.telhai.ds.hash;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import il.ac.telhai.ds.misc.Person;
import il.ac.telhai.ds.misc.PersonKey;

public class HashTableTest {

	private Person p1;
	private Person p3;
	private Person p5;
	private Person p7;
	private Person p10;
	private Person p15;
	private HashTable<PersonKey, Person> hashPerson;

	@Before
	public void setUp() throws Exception {
		p10 = new Person("10", "10firstName", "10lastName");
		p5 = new Person("05", "05firstName", "05lastName");
		p1 = new Person("01", "01firstName", "01lastName");
		p3 = new Person("03", "03firstName", "03lastName");
		p7 = new Person("07", "07firstName", "07lastName");
		p15 = new Person("15", "15firstName", "15lastName");
		hashPerson = new HashTable<PersonKey, Person>();
	}
	
	@Test
	public void testGet() {
		hashPerson.put(p5.getKey(), p5);
		assertEquals(p5, hashPerson.get(p5.getKey()));
		hashPerson.put(p1.getKey(), p1);
		assertEquals(p1, hashPerson.get(p1.getKey()));
		hashPerson.put(p3.getKey(), p3);
		hashPerson.put(p7.getKey(), p7);
		hashPerson.put(p15.getKey(), p15);
		assertEquals(p3, hashPerson.get(p3.getKey()));
		assertEquals(p7, hashPerson.get(p7.getKey()));
		assertEquals(p15, hashPerson.get(p15.getKey()));
		assertNotEquals(p15, hashPerson.get(p5.getKey()));
		assertNull(hashPerson.get(p10.getKey()));
	}

	@Test
	public void testRemove() {
		hashPerson.put(p5.getKey(), p5);
		hashPerson.put(p1.getKey(), p1);
		hashPerson.put(p3.getKey(), p3);
		hashPerson.put(p7.getKey(), p7);
		hashPerson.put(p15.getKey(), p15);
		assertEquals(p15, hashPerson.get(p15.getKey()));
		assertNull(hashPerson.remove(p10.getKey()));
		assertEquals(p5, hashPerson.remove(p5.getKey()));
		assertNull(hashPerson.get(p5.getKey()));
		assertNull(hashPerson.remove(p5.getKey()));
	}

	@Test
	public void testClear() {
		hashPerson.put(p5.getKey(), p5);
		hashPerson.put(p1.getKey(), p1);
		hashPerson.put(p3.getKey(), p3);
		hashPerson.put(p7.getKey(), p7);
		hashPerson.put(p15.getKey(), p15);
		assertFalse(hashPerson.isEmpty());
		hashPerson.clear();
		assertTrue(hashPerson.isEmpty());
	}

	@Test
	public void testIsEmpty() {
		assertTrue(hashPerson.isEmpty());
		hashPerson.put(p1.getKey(), p1);
		assertFalse(hashPerson.isEmpty());
	}

}
