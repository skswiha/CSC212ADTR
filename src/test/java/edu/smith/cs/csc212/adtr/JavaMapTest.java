package edu.smith.cs.csc212.adtr;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Test;

import edu.smith.cs.csc212.adtr.real.JavaMap;

public class JavaMapTest {
	
	void assertIntEq(int x, int y) {
		assertEquals(x, y);
	}

	@Test
	public void testEmpty() {
		MapADT<String, Integer> empty = new JavaMap<>();
		assertEquals(empty.size(), 0);
	}
	
	@Test
	public void testPut() {
		MapADT<String, Integer> abc = new JavaMap<>();
		abc.put("a", 1);
		abc.put("b", 2);
		abc.put("c", 3);
		assertEquals(abc.size(), 3);
		abc.put("a",  2);
		assertEquals(abc.size(), 3);	
	}
	
	@Test
	public void testGet() {
		MapADT<String, Integer> abc = new JavaMap<>();
		abc.put("a", 1);
		abc.put("b", 2);
		abc.put("c", 3);
		assertIntEq(abc.get("a"), 1);
		assertEquals(abc.get("d"), null);
	}
	
	@Test
	public void testRemove() {
		MapADT<String, Integer> abc = new JavaMap<>();
		abc.put("a", 1);
		abc.put("b", 2);
		abc.put("c", 3);
		abc.remove("a");
		abc.remove("d");
		assertEquals(abc.size(), 2);
		assertIntEq(abc.remove("b"), 2);
	}
	
	@Test
	public void testGetKeys() {
		MapADT<String, Integer> abc = new JavaMap<>();
		abc.put("a", 1);
		abc.put("b", 2);
		abc.put("c", 3);
		ListADT<String> list = abc.getKeys();
		assertEquals(list.toJava().contains("a"), true);
		assertEquals(list.toJava().contains("b"), true);
		assertEquals(list.toJava().contains("c"), true);
	}
	
	@Test
	public void testGetEntries() {
		MapADT<String, Integer> abc = new JavaMap<>();
		abc.put("a", 1);
		abc.put("b", 2);
		abc.put("c", 3);
		ListADT<Pair<String, Integer>> list = abc.getEntries();
		assertEquals(list.size(), 3);
	}
	public void testToJava() {
		MapADT<String, Integer> abc = new JavaMap<>();
		abc.put("a", 1);
		abc.put("b", 2);
		abc.put("c", 3);
		assertEquals(abc.toJava() instanceof Map, true);
	}
	
}
