package lingo.lingogame.service;

import lingo.lingogame.domain.Language;
import lingo.lingogame.domain.Word;
import lingo.lingogame.domain.WordTarget;
import lingo.lingogame.persistence.DbWordTarget;

public class WordService {
	private WordTarget wordTarget = new DbWordTarget();

	public Word getRandomWord(Language language, int length) {
		return wordTarget.getRandomWord(language, length);
	}
}
