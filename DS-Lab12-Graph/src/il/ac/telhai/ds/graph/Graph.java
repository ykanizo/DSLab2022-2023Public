package il.ac.telhai.ds.graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class Graph<V, E> {

	/**
	 * Add a new vertex if none with equal item exists.
	 * Otherwise retain the existing vertex and replace the item with the given one.
	 * Note that though they are equal, they are not necessarily same.
	 */
	public V put(V item) {
	}

	public V remove(V item) {
	}

	/**
	 * Add a new edge if none exists between the two vertices
	 * Otherwise retain the existing edge and replace the item with the given one.
	 */
	public E put(V item1, V item2, E itemEdge) {
	}

	/**
	 * @return The edge between the two vertices. Null if the edge does not exist
	 * Throws an exception of one of the vertices does not exist.
	 */
	public E get(V item1, V item2) {
	}

	public double getWeight(V item1, V item2) {
	}

	public boolean isAdjacent(V item1, V item2) {
	}
	
	/**
	 * @return The edge between the two vertices. Null if the edge does not exist
	 * Throws an exception of one of the vertices does not exist.
	 */
	public E remove(V item1, V item2) {
	}

	/**
	 * @return The concatenation of the vertices separated by commas.
	 */
	public String toString() {
	}

	/**
	 * @returns The concatenation of the vertices separated by newlines
	 * Every vertex is printed with a comma separated list of its incident edges.
	 * The list is separated from the vertex with a colon.
	 */
	public String toStringExtended() {
	}

}