package lingo.lingogame.persistence;

import java.util.List;

import lingo.lingogame.domain.Language;
import lingo.lingogame.domain.LanguageTarget;

public class DbLanguageTarget implements LanguageTarget{
	private LanguageDao langDao = new LanguagePostgresDaoImpl();

	public List<Language> getAllLanguages() {
		return langDao.getAllLanguages();
	}

	public Language getLanguageWithId(int langid) {
		return langDao.getLanguageWithId(langid);
	}

}
