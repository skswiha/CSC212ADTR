package edu.smith.cs.csc212.adtr;

import static org.junit.Assert.assertEquals;

import java.util.Set;

import org.junit.Test;

import edu.smith.cs.csc212.adtr.real.JavaSet;

public class JavaSetTest {
	
	@Test
	public void testEmpty() {
		SetADT<String> empty = new JavaSet<>();
		assertEquals(empty.size(), 0);
	}
	
	@Test
	public void testInsert() {
		SetADT<String> abc = new JavaSet<>();
		abc.insert("a");
		abc.insert("b");
		abc.insert("c");
		assertEquals(abc.size(), 3);
	}
	
	@Test
	public void testInsertRepeated() {
		SetADT<String> abc = new JavaSet<>();
		abc.insert("a");
		abc.insert("a");
		abc.insert("a");
		assertEquals(abc.size(), 1);

	}
	
	@Test
	public void testContains() {
		SetADT<String> abc = new JavaSet<>();
		abc.insert("a");
		abc.insert("b");
		abc.insert("c");
		assertEquals(abc.contains("a"), true);
		assertEquals(abc.contains("d"), false);
		}
	
	@Test
	public void testRemove() {
		SetADT<String> abc = new JavaSet<>();
		abc.insert("a");
		abc.insert("b");
		abc.insert("c");
		abc.remove("a");
		abc.remove("d");
		assertEquals(abc.contains("a"), false);
	}
	
	@Test
	public void testToList() {
		SetADT<String> abc = new JavaSet<>();
		assertEquals(abc.toList().size(), 0);
		abc.insert("a");
		assertEquals(abc.toList().size(), 1);
		abc.insert("b");
		abc.insert("c");
		assertEquals(abc.toList().size(), 3);
		assertEquals(abc.toList() instanceof ListADT, true);
	}
	
	@Test
	public void testToJava() {
		SetADT<String> abc = new JavaSet<>();
		assertEquals(abc.toJava().size(), 0);
		abc.insert("a");
		assertEquals(abc.toJava().size(), 1);
		abc.insert("b");
		abc.insert("c");
		assertEquals(abc.toJava().size(), 3);
		assertEquals(abc.toJava() instanceof Set, true);
	}
}
