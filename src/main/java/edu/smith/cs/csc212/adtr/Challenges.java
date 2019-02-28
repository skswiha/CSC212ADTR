package edu.smith.cs.csc212.adtr;

import edu.smith.cs.csc212.adtr.real.JavaMap;
import edu.smith.cs.csc212.adtr.real.JavaSet;

public class Challenges {

	// The union of two sets is the set of elements that either contains.
	public static SetADT<Integer> union(SetADT<Integer> left, SetADT<Integer> right) {
		SetADT<Integer> output = new JavaSet<>();
		for (Integer i : left.toList()) {
			output.insert(i);
		}
		for (Integer i : right.toList()) {
			output.insert(i);
		}
		return output;
	}
	
	// The intersection of two sets is the set of elements that both contain.
	public static SetADT<Integer> intersection(SetADT<Integer> left, SetADT<Integer> right) {
		SetADT<Integer> output = new JavaSet<>();
		for (Integer i : left.toList()) {
			if (right.contains(i)) {
				output.insert(i);
			}
		}
		return output;
	}
	
	// Count the words in the input list and put them in the map.
	public static MapADT<String, Integer> wordCount(ListADT<String> words) {
		MapADT<String, Integer> output = new JavaMap<>();
		int count;
		for (String word : words.toJava()) {
			count = 0;
			for (String word2 : words.toJava()) {
				if (word == word2) {
					count ++;
				}
			}
			output.put(word, count);
		}
		return output;
	}
}
