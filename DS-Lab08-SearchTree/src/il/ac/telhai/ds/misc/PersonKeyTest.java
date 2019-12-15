package il.ac.telhai.ds.misc;
import static org.junit.Assert.*;

import org.junit.Test;


public class PersonKeyTest {

	@Test
	public void testCompareTo() {
		PersonKey k1 = new PersonKey("12960449", "Shalom");
		PersonKey k2 = new PersonKey("312396120", "Shalom");
		PersonKey k3 = new PersonKey("12313122", "Berkel");
		PersonKey k4 = new PersonKey("12960449", "Shalom");
		assertTrue(k1.compareTo(k1)==0);
		assertTrue(k1.compareTo(k2)<0);
		assertTrue(k1.compareTo(k3)>0);
		assertTrue(k1.compareTo(k4)==0);
		assertTrue(k2.compareTo(k1)>0);
		assertTrue(k2.compareTo(k2)==0);
		assertTrue(k2.compareTo(k3)>0);
		assertTrue(k2.compareTo(k4)>0);
		assertTrue(k3.compareTo(k1)<0);
		assertTrue(k3.compareTo(k2)<0);
		assertTrue(k3.compareTo(k3)==0);
		assertTrue(k3.compareTo(k4)<0);
		assertTrue(k4.compareTo(k1)==0);
		assertTrue(k4.compareTo(k2)<0);
		assertTrue(k4.compareTo(k3)>0);
		assertTrue(k4.compareTo(k4)==0);
	}

}
