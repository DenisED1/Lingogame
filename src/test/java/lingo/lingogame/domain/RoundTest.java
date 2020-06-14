package lingo.lingogame.domain;

import org.junit.jupiter.api.*;

@DisplayName("Round")
public class RoundTest {
	private final int roundid = 1;
	private final int guesses = 3;
	private Round round;

	private final int wordid = 1;
	private Word word;

	private final int gameid = 1;
	private Game game;

	@BeforeEach
	public void setUp() {
		word = new Word(wordid);
		game = new Game(gameid);

		round = new Round(roundid, guesses, game, word);
	}

	@Test
	@DisplayName("gives the roundid")
	public void getRoundid() {
		Assertions.assertEquals(roundid, round.getRoundid());
	}

	@Test
	@DisplayName("gives the guesses")
	public void getRoundGuesses() {
		Assertions.assertEquals(guesses, round.getGuesses());
	}

	@Test
	@DisplayName("gives the round gameid")
	public void getRoundGameid() {
		Assertions.assertEquals(gameid, round.getGame().getGameid());
	}

	@Test
	@DisplayName("gives the round wordid")
	public void getRoundWordid() {
		Assertions.assertEquals(wordid, round.getWord().getWordid());
	}
}
