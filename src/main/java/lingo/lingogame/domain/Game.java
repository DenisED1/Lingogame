package lingo.lingogame.domain;

public class Game {
	private int gameid;
	private String playername;
	private int score;

	public Game(int gameid) {
		this.gameid = gameid;
	}
	
	public Game(int gameid, int score) {
		this.gameid = gameid;
		this.score = score;
	}
	
	public Game(int gameid, String playername, int score) {
		this.gameid = gameid;
		this.playername = playername;
		this.score = score;
	}

	public int getGameid() {
		return gameid;
	}

	public void setGameid(int gameid) {
		this.gameid = gameid;
	}

	public String getPlayername() {
		return playername;
	}

	public void setPlayername(String playername) {
		this.playername = playername;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
}
