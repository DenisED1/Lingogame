package lingo.lingogame.infrastructure;

import lingo.lingogame.domain.Language;
import lingo.lingogame.domain.Word;
import lingo.lingogame.domain.WordTarget;

public class DbWordTarget implements WordTarget{
	private WordDao wordDao = new WordPostresDaoImpl();
	
	public Word GetWord(String table, Language language) {
		return wordDao.GetWord(table, language);
	}

}
