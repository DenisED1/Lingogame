package lingo.lingogame.domain;

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
		Assertions.assertEquals(wordid, word.getWordid());
	}

	@Test
	@DisplayName("gives the wordstring")
	public void getWord() {
		Assertions.assertEquals(wordstr, word.getWord());
	}

	@Test
	@DisplayName("gives word length")
	public void getLength() {
		Assertions.assertEquals(length, word.getLength());
	}
	
	@Test
	@DisplayName("gives word language langid")
	public void getLangid() {
		Assertions.assertEquals(langid, word.getLanguage().getLangid());
	}
	
	@Test
	@DisplayName("gives word language")
	public void getLanguage() {
		Assertions.assertEquals(langid, word.getLanguage().getLanguage());
	}
}
