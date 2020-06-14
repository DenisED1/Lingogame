package lingo.lingogame.domain;

import org.junit.jupiter.api.*;

public class FeedbackWordTest {
	private final String feedback = "Gefeliciteerd!";
	private final String givenWord = "h a _ _ _";
	private final boolean correct = true;
	private final int newRoundid = 2;
	private final int gameid = 1;
	private FeedbackWord feedbackWord;

	@BeforeEach
	public void setUp() {
		feedbackWord = new FeedbackWord(feedback, givenWord, correct);
		feedbackWord.setRoundid(newRoundid);
		feedbackWord.setGameid(gameid);
	}

	@Test
	@DisplayName("gives the feedback")
	public void getFeedback() {
		Assertions.assertEquals(feedback, feedbackWord.getFeedback());
	}
	
	@Test
	@DisplayName("gives the givenWord")
	public void getGivenWord() {
		Assertions.assertEquals(givenWord, feedbackWord.getGivenWord());
	}
	
	@Test
	@DisplayName("gives the gameid")
	public void getCorrect() {
		Assertions.assertEquals(correct, feedbackWord.getCorrect());
	}
	
	@Test
	@DisplayName("gives the new Roundid")
	public void getNewRoundid() {
		Assertions.assertEquals(newRoundid, feedbackWord.getRoundid());
	}
	
	@Test
	@DisplayName("gives the gameid")
	public void getGameid() {
		Assertions.assertEquals(gameid, feedbackWord.getGameid());
	}
}
