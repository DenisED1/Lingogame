package lingo.lingogame.service;

import java.util.List;

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

	public Round createRound(int gameid, int langid, int length) {
		Language language = new Language(langid);
		Word word = wordService.getRandomWord(language, length);
		Game game = new Game(gameid);

		return roundTarget.createRound(word, game);
	}

	public boolean updateRound(int roundid, int guesses) {
		Round round = new Round(roundid, guesses);

		return roundTarget.updateRound(round);
	}
}
