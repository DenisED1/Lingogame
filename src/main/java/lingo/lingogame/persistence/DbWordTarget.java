package lingo.lingogame.persistence;

import lingo.lingogame.domain.Language;
import lingo.lingogame.domain.Word;
import lingo.lingogame.domain.WordTarget;

public class DbWordTarget implements WordTarget{
	private WordDao wordDao = new WordPostresDaoImpl();
	
	public Word getRandomWord(String table, Language language) {
		return wordDao.getRandomWord(table, language);
	}

}
