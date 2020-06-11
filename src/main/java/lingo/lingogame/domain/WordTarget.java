package lingo.lingogame.domain;

public interface WordTarget {
	Word getRandomWord(Language language, int length);

	Word getWordWithId(int i);
}
