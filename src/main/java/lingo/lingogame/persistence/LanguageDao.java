package lingo.lingogame.persistence;

import java.util.List;

import lingo.lingogame.domain.Language;

public interface LanguageDao {
	List<Language> getAllLanguages();
}