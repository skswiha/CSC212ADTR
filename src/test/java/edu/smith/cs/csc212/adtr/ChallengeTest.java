package edu.smith.cs.csc212.adtr;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import edu.smith.cs.csc212.adtr.real.JavaSet;
import edu.smith.cs.csc212.adtr.real.JavaList;
import edu.smith.cs.csc212.adtr.real.JavaMap;

public class ChallengeTest {
	
	@Test
	public void testUnion() {
		SetADT<Integer> a= new JavaSet<>();
		SetADT<Integer> b = new JavaSet<>();
		assertEquals(Challenges.union(a, b).size(), 0);
		a.insert(1);
		a.insert(2);
		a.insert(3);
		assertEquals(Challenges.union(a, b).size(), 3);
		b.insert(3);
		b.insert(4);
		b.insert(5);
		assertEquals(Challenges.union(a, b).size(), 5);
		b.remove(3);
		b.insert(6);
		assertEquals(Challenges.union(a, b).size(), 6);
		for (Integer i : a.toJava()) {
			assertEquals(Challenges.union(a, b).contains(i), true);	
		}
		for (Integer i : b.toJava()) {
			assertEquals(Challenges.union(a, b).contains(i), true);	
		}
	}
	
	@Test
	public void testIntersection() {
		SetADT<Integer> a= new JavaSet<>();
		SetADT<Integer> b = new JavaSet<>();
		a.insert(1);
		a.insert(2);
		a.insert(3);
		b.insert(3);
		b.insert(4);
		b.insert(5);
		assertEquals(Challenges.intersection(a, b).size(), 1);
		assertEquals(Challenges.intersection(a, b).contains(3), true);
		b.remove(3);
		assertEquals(Challenges.intersection(a, b).size(), 0);
		b.insert(3);
		b.insert(2);
		assertEquals(Challenges.intersection(a, b).size(), 2);
	}
	
	@Test
	public void testWordCount() {
		ListADT<String> words = new JavaList<>();
		words.addBack("a");
		words.addBack("b");
		words.addBack("b");
		words.addBack("c");
		words.addBack("c");
		words.addBack("c");
		MapADT<String, Integer> expected = new JavaMap<>();
		expected.put("a", 1);
		expected.put("b", 2);
		expected.put("c", 3);
		MapADT<String, Integer> result = Challenges.wordCount(words);
		for(int i = 0; i < result.size(); i++) {
			assertEquals(result.getKeys().getIndex(i), expected.getKeys().getIndex(i));
			assertEquals(result.get(result.getKeys().getIndex(i)), expected.get(expected.getKeys().getIndex(i)));
		}
	}
}
