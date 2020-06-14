package lingo.lingogame.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.*;

@DisplayName("Word")
public class WordTest {
	private final int wordid = 1;
	private final String wordstr = "koekje";
	private final int length = 6;
	private Word word;

	private final int langid = 1;
	private final String langstr = "Netherlands";
	private Language language;

	@BeforeEach
	public void setUp() {
		language = new Language(langid, langstr);
		word = new Word(wordid, wordstr, length, language);
	}

	@Test
	@DisplayName("gives the wordid")
	public void getWordid() {
		assertEquals(wordid, word.getWordid());
	}

	@Test
	@DisplayName("gives the word")
	public void getWord() {
		assertEquals(word, word.getWord());
	}

	@Test
	@DisplayName("gives word length")
	public void getLength() {
		assertEquals(length, word.getLength());
	}
}
