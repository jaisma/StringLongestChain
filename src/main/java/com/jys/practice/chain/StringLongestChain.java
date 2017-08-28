package com.jys.practice.chain;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Description: 
 * Given a library with n words (w[0], w[1], ... w[n -1]), choose a
 * word from it and in each step, remove one letter from this word only if doing
 * so yields another word in the library. Word itself is a chain, and the
 * resulting new word from successful character removal is +1 to the chain. Find
 * the longest possible chain of these removal steps.
 * 
 * Constraints: 
 * * 1 <= n <= 50000 
 * * 1 <= the length of each string in w <= 50 
 * * Each string composed of lower ASCII letter only.
 * 
 * Input format: 
 * String[]
 * 
 * Output format: 
 * integer
 * 
 * Sample input: 
 * String[] library = new String[]{"6", "a", "b", "ba", "bca", "bda", "bdca"};
 * 
 * Sample output: 
 * 4 - because "bdca" -> "bca" -> "ba" -> "a"
 *
 */
public class StringLongestChain {
	private static final Logger log = LoggerFactory.getLogger(StringLongestChain.class);

	public int getLongestChain(String[] library) {

		// empty strings are valid input
		if (library == null || library.length == 0) {
			log.warn("Input was empty");
			return 0;
		}

		int longestChain = 0;

		// change default sort to compare length of the string instead
		Arrays.sort(library, new Comparator<String>() {
			public int compare(String str1, String str2) {
				return str1.length() - str2.length();
			}
		});

		Map<String, Integer> map = new HashMap<>();
		for (String word : library) {
			if (map.containsKey(word)) {
				log.debug("Word: " + word + " is a duplicate");
				continue; // skip duplicates
			}
			map.put(word, 1); // start with 1, because word itself is a chain
			for (int i = 0; i < word.length(); ++i) {
				// String temp = word.substring(0, i) + word.substring(i + 1);
				// string builder is a better solution
				log.debug("Current word: " + word);

				if (map.containsKey(deleteCharacter(word, i))
						&& map.get(deleteCharacter(word, i)) + 1 > map.get(word)) {
					map.put(word, map.get(deleteCharacter(word, i)) + 1);
				}
			}
			if (map.get(word) > longestChain)
				longestChain = map.get(word);
		}
		return longestChain;
	}

	protected String deleteCharacter(String word, int index) {
		StringBuilder sb = new StringBuilder(word);
		log.debug("Deleting " + index + " index of " + word);
		return sb.deleteCharAt(index).toString();
	}

}
