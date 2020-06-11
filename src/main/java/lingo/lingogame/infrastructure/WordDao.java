package lingo.lingogame.infrastructure;

import lingo.lingogame.domain.Language;
import lingo.lingogame.domain.Word;

public interface WordDao {
	Word GetWord(String table, Language language);
}
