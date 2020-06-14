package lingo.lingogame.domain;

import org.junit.jupiter.api.*;

@DisplayName("Game")
public class GameTest {
	private static int gameid = 1;
	private static String playername = "player1";
	private static int score = 70;
	private Game game;
	
	@BeforeEach
	public void setUp() {
		game = new Game(gameid, playername, score);
	}
	
	@Test
	@DisplayName("gives the gameid")
	public void getGameid() {
		Assertions.assertEquals(gameid, game.getGameid());
	}
	
	@Test
	@DisplayName("gives the playername")
	public void getGamePlayername() {
		Assertions.assertEquals(playername, game.getPlayername());
	}
	
	@Test
	@DisplayName("gives the score")
	public void getGameScore() {
		Assertions.assertEquals(score, game.getScore());
	}
}
