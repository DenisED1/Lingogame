package lingo.lingogame.domain;

public class Word {
	private int wordid;
	private String word;
	private Language language;
	
	public Word(int wordid, String word, Language language) {
		this.wordid = wordid;
		this.word = word;
		this.language = language;
	}

	public int getWordid() {
		return wordid;
	}

	public void setWordid(int wordid) {
		this.wordid = wordid;
	}

	public Word(String word, Language language) {
		this.word = word;
		this.language = language;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}
}
