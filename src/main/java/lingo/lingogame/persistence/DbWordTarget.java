package lingo.lingogame.persistence;

import lingo.lingogame.domain.Language;
import lingo.lingogame.domain.Word;
import lingo.lingogame.domain.WordTarget;

public class DbWordTarget implements WordTarget{
	private WordDao wordDao = new WordPostresDaoImpl();
	
	public Word getRandomWord(Language language, int length) {
		return wordDao.getRandomWord(language, length);
	}

	public Word getWordWithId(int wordid) {
		return wordDao.getWordWithId(wordid);
	}

}
