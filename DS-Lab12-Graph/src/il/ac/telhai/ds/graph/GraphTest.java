package il.ac.telhai.ds.graph;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import il.ac.telhai.ds.misc.Friendship;
import il.ac.telhai.ds.misc.Person;
import il.ac.telhai.ds.misc.WeightedFriendship;

public class GraphTest {

	Graph<String, Double> g;

	@Before
	public void setUp() throws Exception {
		g = new Graph<String, Double>();
	}

	@Test
	public void testGraph() {
		assertEquals("", g.toString());
	}

	@Test
	public void testPutV() {
		g.put("A");
		assertEquals("A", g.toString());
		g.put("B");
		assertEquals("A,B", g.toString());
	}

	@Test
	public void testRemoveNoEdges() {
		g.put("A");
		g.put("B");
		g.put("C");
		g.put("D");
		g.remove("C");
		assertEquals("A,B,D", g.toString());
	}

	@Test
	public void testPutVVE() {
		g.put("A");
		g.put("B");
		g.put("C");
		g.put("D");
		g.put("A", "B", 2.5);
		assertEquals("A,B,C,D", g.toString());
		assertEquals("A:{A,B}(2.5)\nB:{A,B}(2.5)\nC:\nD:", g.toStringExtended());
		g.put("B", "C", 3.0);
		g.put("C", "D", 4.5);
		assertEquals("A:{A,B}(2.5)\nB:{A,B}(2.5),{B,C}(3.0)\nC:{B,C}(3.0),{C,D}(4.5)\nD:{C,D}(4.5)", g.toStringExtended());
	}

	private Graph<String, Double> createP4() {
		Graph<String, Double> p4 = new Graph<String, Double>();
		p4.put("A");
		p4.put("B");
		p4.put("C");
		p4.put("D");
		p4.put("A", "B", 2.5);
		p4.put("B", "C", 3.0);
		p4.put("C", "D", 4.5);
		return p4;
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testFriendship() {
		Graph<Person, Friendship> fr = new Graph<Person, Friendship>();
		Person m = new Person("012960449", "M", "S"); 
		Person a = new Person("317919249", "A", "S"); 
		fr.put(m);
		fr.put(a);
		fr.put(a, m, new Friendship(new Date(1995, 3, 15)));
		assertEquals("Person [M S],Person [A S]", fr.toString());
		assertEquals(
				"Person [M S]:{Person [A S],Person [M S]}\nPerson [A S]:{Person [A S],Person [M S]}", 
				fr.toStringExtended());
		try {
			fr.getWeight(m, a);
			fail("Should throw exception");
		} catch (Exception e) {
			
		}
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testWeightedFriendship() {
		Graph<Person, WeightedFriendship> fr = new Graph<Person, WeightedFriendship>();
		Person m = new Person("012960449", "M", "S"); 
		Person a = new Person("317919249", "A", "S"); 
		fr.put(m);
		fr.put(a);
		fr.put(a, m, new WeightedFriendship(new Date(1995, 3, 15), 33));
		assertEquals(33.0, fr.getWeight(m, a),0);
	}

	@Test
	public void testGet() {
		Graph<String, Double> p4 = createP4();
		assertEquals(2.5, p4.get("A", "B"), 0);
		assertNull(p4.get("A", "C"));
	}

	@Test
	public void testGetWeightSimple() {
		Graph<String, Double> p4 = createP4();
		assertEquals(2.5, p4.getWeight("A", "B"), 0);
		assertEquals(0, p4.getWeight("A", "C"), 0);
	}

	@Test
	public void testIsAdjacent() {
		Graph<String, Double> p4 = createP4();
		assertTrue(p4.isAdjacent("A", "B"));
		assertTrue(p4.isAdjacent("B", "C"));
		assertTrue(p4.isAdjacent("C", "D"));
		assertTrue(p4.isAdjacent("D", "C"));
		assertFalse(p4.isAdjacent("A", "C"));
	}

	@Test
	public void testRemoveEdge() {
		Graph<String, Double> p4 = createP4();
		p4.remove("B", "C");
		assertEquals("A:{A,B}(2.5)\nB:{A,B}(2.5)\nC:{C,D}(4.5)\nD:{C,D}(4.5)", p4.toStringExtended());
	}

}