package lingo.lingogame.service;

import java.util.List;

import lingo.lingogame.domain.Language;
import lingo.lingogame.domain.LanguageTarget;
import lingo.lingogame.persistence.DbLanguageTarget;

public class LanguageService {
	private LanguageTarget langTarget = new DbLanguageTarget();

	public List<Language> getAllLanguages() {
		return langTarget.getAllLanguages();
	}
}
