package Util;

import java.util.ArrayList;

public class Utility {
	public static final boolean containsDigit(String s) {
		boolean containsDigit = false;

		if (s != null && !s.isEmpty()) {
			for (char c : s.toCharArray()) {
				if (containsDigit = Character.isDigit(c)) {
					break;
				}
			}
		}

		return containsDigit;
	}

	public static ArrayList<String> splitReviewtoWords(String review) {
		ArrayList<String> words = new ArrayList<String>();
		// String[] wordsInReview = review.split("[^.a-zA-Z\\d]");
		// for(String w : wordsInReview){
		// if(!w.isEmpty() && w.length() > 2 && !containsDigit(w))
		// words.add(w.toLowerCase());
		// }
		ArrayList<Integer> special = new ArrayList<Integer>();
		for (int i = 0; i < review.length(); i++)
			if (!((review.charAt(i) >= 65 && review.charAt(i) <= 90)
					|| (review.charAt(i) >= 97 && review.charAt(i) <= 122))) {
				special.add(i);
			}
		int temp = 0;
		String word;
		for (int i : special) {
			word = review.substring(temp, i);
			temp = i + 1;
			if (word.length() > 2)
				words.add(word.toLowerCase());
		}
		return words;

	}
}
