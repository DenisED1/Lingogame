package lingo.lingogame.domain;

public class Word {
	private int wordid;
	private String word;
	private int length;
	private Language language;
	
	public Word(String word, Language language) {
		this.word = word;
		this.language = language;
	}
	
	public Word(int wordid, String word, int length, Language language) {
		this.wordid = wordid;
		this.word = word;
		this.length = length;
		this.language = language;
	}

	public int getWordid() {
		return wordid;
	}

	public void setWordid(int wordid) {
		this.wordid = wordid;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}
	
	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}
	
	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}
}
