package lingo.lingogame.persistence;

import java.util.List;

import lingo.lingogame.domain.Language;
import lingo.lingogame.domain.LanguageTarget;

public class DbLanguageTarget implements LanguageTarget{

	public List<Language> getAllLanguages() {
		LanguageDao langDao = new LanguagePostgresDaoImpl();
		return langDao.getAllLanguages();
	}

}
