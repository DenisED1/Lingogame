package lingo.lingogame.domain;

public class Round {
	private int roundid;
	private int guesses;
	private Game game;
	private Word word;

	public Round(int roundid, int guesses, Game game, Word word) {
		this.roundid = roundid;
		this.guesses = guesses;
		this.game = game;
		this.word = word;
	}

	public int getRoundid() {
		return roundid;
	}

	public void setRoundid(int roundid) {
		this.roundid = roundid;
	}

	public int getGuesses() {
		return guesses;
	}

	public void setGuesses(int guesses) {
		this.guesses = guesses;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public Word getWord() {
		return word;
	}

	public void setWord(Word word) {
		this.word = word;
	}
}
