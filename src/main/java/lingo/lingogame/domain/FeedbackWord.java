package lingo.lingogame.domain;

public class FeedbackWord {
	private String feedback;
	private String givenWord;
	private boolean correct;
	private int newRoundid;
	private int gameid;

	public FeedbackWord(String givenWord, int newRoundid, int gameid) {
		this.givenWord = givenWord;
		this.newRoundid = newRoundid;
		this.gameid = gameid;
	}
	
	public FeedbackWord(String feedback, String givenWord, boolean correct) {
		this.feedback = feedback;
		this.givenWord = givenWord;
		this.correct = correct;
	}
	
	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public String getGivenWord() {
		return givenWord;
	}

	public void setGivenWord(String givenWord) {
		this.givenWord = givenWord;
	}

	public boolean getCorrect() {
		return correct;
	}

	public void setCorrect(boolean correct) {
		this.correct = correct;
	}
	
	public int getRoundid() {
		return newRoundid;
	}
	
	public void setRoundid(int roundid) {
		this.newRoundid = roundid;
	}
	
	public int getGameid() {
		return gameid;
	}
	
	public void setGameid(int gameid) {
		this.gameid = gameid;
	}
}
