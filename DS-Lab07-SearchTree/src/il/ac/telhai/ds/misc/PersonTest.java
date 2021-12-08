package il.ac.telhai.ds.misc;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class PersonTest {
	private Person p;
	@Before
	public void setUp() {
		p = new Person("123456789", "Michal", "Horovitz");
	}

	@Test
	public void testPerson() {
		assertEquals("123456789", p.getId());
		assertEquals("Michal", p.getFirstName());
		assertEquals("Horovitz", p.getLastName());
	}

	@Test
	public void testSetFirstName() {
		p.setFirstName("Moshe");
		assertEquals("123456789", p.getId());
		assertEquals("Moshe", p.getFirstName());
		assertEquals("Horovitz", p.getLastName());
	}

	@Test
	public void testSetLastName() {
		p.setLastName("Efrat");
		assertEquals("123456789", p.getId());
		assertEquals("Michal", p.getFirstName());
		assertEquals("Efrat", p.getLastName());
	}

	@Test
	public void testGetKey() {
		assertEquals(new PersonKey("123456789", "Horovitz"), p.getKey());
	}

}
