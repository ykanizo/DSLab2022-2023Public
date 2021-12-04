package il.ac.telhai.ds.misc;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class PersonTest {
	private Person p;
	@Before
	public void setUp() {
		p = new Person("12960449", "Mordo", "Shalom");
	}

	@Test
	public void testPerson() {
		assertEquals("12960449", p.getId());
		assertEquals("Mordo", p.getFirstName());
		assertEquals("Shalom", p.getLastName());
	}

	@Test
	public void testSetFirstName() {
		p.setFirstName("Maya");
		assertEquals("12960449", p.getId());
		assertEquals("Maya", p.getFirstName());
		assertEquals("Shalom", p.getLastName());
	}

	@Test
	public void testSetLastName() {
		p.setLastName("Berkel");
		assertEquals("12960449", p.getId());
		assertEquals("Mordo", p.getFirstName());
		assertEquals("Berkel", p.getLastName());
	}

	@Test
	public void testGetKey() {
		assertEquals(new PersonKey("12960449", "Shalom"), p.getKey());
	}

}
