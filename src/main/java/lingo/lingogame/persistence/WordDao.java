package lingo.lingogame.persistence;

import lingo.lingogame.domain.Language;
import lingo.lingogame.domain.Word;

public interface WordDao {
	Word getRandomWord(Language language, int length);

	Word getWordWithId(int wordid);
}
