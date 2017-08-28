package com.jys.practice.chain;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Comparator;

import org.junit.Before;
import org.junit.Test;

public class StringLongestChainTest {

	StringLongestChain stringLongestChain;

	@Before
	public void setup() {
		stringLongestChain = new StringLongestChain();
	}

	@Test
	public void deleteCharacterTest() {
		String testString = "HelloWorld";
		String result = stringLongestChain.deleteCharacter(testString, 2);
		assertEquals("HeloWorld", result);
	}

	@Test
	public void sorterTest() {
		String[] library = new String[] { "abcd", "abcde", "ab", "abcd", "a", "abc" };

		// copying over the same logic
		Arrays.sort(library, new Comparator<String>() {
			public int compare(String str1, String str2) {
				return str1.length() - str2.length();
			}
		});
		assertEquals(library[0], "a");
		assertEquals(library[1], "ab");
		assertEquals(library[5], "abcde");

	}

	@Test
	public void randomOrderTest() {
		String[] library = new String[] { "abcd", "abcde", "ab", "abcd", "a", "abc" };
		int result = stringLongestChain.getLongestChain(library);

		assertEquals(result, 5);
	}

	@Test
	public void skipLengthTest() {
		// Taking one character away from abcd, none exists even though removing one
		// additional character exists
		String[] library = new String[] { "a", "b", "ab", "abcd" };
		int result = stringLongestChain.getLongestChain(library);

		assertEquals(result, 2);
	}

	@Test
	public void emptyLibraryTest() {
		String[] libraryI = new String[] { " " };
		String[] libraryII = new String[] { "" };
		String[] libraryIII = new String[] { "", " ", "  " };
		String[] libraryIV = null;
		String[] libraryV = new String[] {};
		int resultI = stringLongestChain.getLongestChain(libraryI);
		int resultII = stringLongestChain.getLongestChain(libraryII);
		int resultIII = stringLongestChain.getLongestChain(libraryIII);
		int resultIV = stringLongestChain.getLongestChain(libraryIV);
		int resultV = stringLongestChain.getLongestChain(libraryV);

		assert (resultI == 1 && resultII == 1 && resultIII == 3);
		assert (resultIV == 0 && resultV == 0);
	}

}
