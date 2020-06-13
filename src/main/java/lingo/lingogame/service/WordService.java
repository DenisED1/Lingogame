package lingo.lingogame.service;

import java.util.HashMap;
import java.util.Map;

import lingo.lingogame.domain.FeedbackWord;
import lingo.lingogame.domain.Language;
import lingo.lingogame.domain.Word;
import lingo.lingogame.domain.WordTarget;
import lingo.lingogame.persistence.DbWordTarget;

public class WordService {
	private WordTarget wordTarget = new DbWordTarget();

	public Word getRandomWord(Language language, int length) {
		Word word = wordTarget.getRandomWord(language, length);
		return word;
	}

	public FeedbackWord checkGuessedWord(int wordid, String guessedWord) {
		Word word = wordTarget.getWordWithId(wordid);
		String feedback = "";
		int goodChar = 0;
		Map<Integer, String> feedbackChar = new HashMap<Integer, String>();
		String givenWord = "";

		if (word.getLength() == guessedWord.length()) {
			if (word.getWord().equals(guessedWord)) {
				feedback = "Congratulations!";
				for (int i = 0; i <= guessedWord.length() - 1; i++) {
					givenWord += String.valueOf(word.getWord().charAt(i)) + " ";
				}
			} else {
				for (int i = 0; i <= guessedWord.length() - 1; i++) {
					if (guessedWord.charAt(i) == word.getWord().charAt(i)) {
						feedbackChar.put(i, guessedWord.charAt(i) + " correct");
						givenWord += String.valueOf(word.getWord().charAt(i)) + " ";
						goodChar += 1;
					} else {
						if (word.getWord().contains(String.valueOf(guessedWord.charAt(i)))) {
							feedbackChar.put(i, guessedWord.charAt(i) + " present");
						} else {
							feedbackChar.put(i, guessedWord.charAt(i) + " absent");
						}
						givenWord += "_ ";
					}
				}
				for (String f : feedbackChar.values()) {
					feedback += f + ", ";
				}
			}
		} else {
			feedback = "Game Over!";
			givenWord = getStartWord(word);
		}

		boolean bool = false;
		if (goodChar == word.getLength()) {
			bool = true;
		}
		FeedbackWord feedbackWord = new FeedbackWord(feedback, givenWord, bool);
		return feedbackWord;
	}

	public String getStartWord(Word word) {
		String givenWord = String.valueOf(word.getWord().charAt(0)) + " ";
		for (int i = 1; i <= word.getLength() - 1; i++) {
			givenWord += "_ ";
		}
		return givenWord;
	}
}
