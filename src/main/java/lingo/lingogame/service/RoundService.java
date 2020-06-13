package lingo.lingogame.service;

import java.util.List;

import lingo.lingogame.domain.FeedbackWord;
import lingo.lingogame.domain.Game;
import lingo.lingogame.domain.Language;
import lingo.lingogame.domain.Round;
import lingo.lingogame.domain.RoundTarget;
import lingo.lingogame.domain.Word;
import lingo.lingogame.persistence.DbRoundTarget;

public class RoundService {
	private RoundTarget roundTarget = new DbRoundTarget();
	private WordService wordService = new WordService();

	public List<Round> getAllGameRounds(int gameid) {
		return roundTarget.getAllGameRounds(gameid);
	}

	public FeedbackWord createRound(int gameid, int langid, int length) {
		Language language = new Language(langid);
		Word word = wordService.getRandomWord(language, length);
		Game game = new Game(gameid);

		Round round = roundTarget.createRound(word, game);
		String givenWord = wordService.getStartWord(word);
		FeedbackWord feedback = new FeedbackWord(givenWord, round.getRoundid(), gameid);
		return feedback;
	}

	public boolean updateRound(int roundid, int guesses) {
		Round round = new Round(roundid, guesses);

		return roundTarget.updateRound(round);
	}

	public FeedbackWord checkRound(int roundid, String guessedWord, int gameid, int langid, int length) {
		Round round = roundTarget.getRoundWithId(roundid);
		int guesses = round.getGuesses();

		if (round.getGuesses() < 5) {
			guesses += 1;
			updateRound(roundid, guesses);

			FeedbackWord feedback = wordService.checkGuessedWord(round.getWord().getWordid(), guessedWord);

			if (feedback.getCorrect()) {
				createRound(gameid, langid, length);
				feedback.setGameid(gameid);
				feedback.setRoundid(roundid);
			}
			if (feedback.getFeedback().equals("Game Over!")) {
				updateRound(roundid, 0);
			}

			return feedback;
		} else {
			updateRound(roundid, 0);
			
			FeedbackWord feedback = createRound(gameid, langid, length);
			feedback.setFeedback("Game Over!");
			return feedback;
		}
	}
}
