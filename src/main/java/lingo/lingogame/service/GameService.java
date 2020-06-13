package lingo.lingogame.service;

import java.util.List;

import lingo.lingogame.domain.FeedbackWord;
import lingo.lingogame.domain.Game;
import lingo.lingogame.domain.GameTarget;
import lingo.lingogame.domain.Round;
import lingo.lingogame.persistence.DbGameTarget;

public class GameService {
	private GameTarget gameTarget = new DbGameTarget();
	private RoundService roundService = new RoundService();

	public List<Game> getTopFifty() {
		return gameTarget.getTopFifty();
	}

	public FeedbackWord createGame(int langid, int length) {
		Game game = gameTarget.createGame();
		FeedbackWord feedback = roundService.createRound(game.getGameid(), langid, length);
		return feedback;
	}

	public int setEndGameData(int gameid, String playername) {
		int score = 0;
		List<Round> rounds = roundService.getAllGameRounds(gameid);
		
		for (Round round : rounds) {
			if (round.getGuesses() != 0) {
				switch (round.getGuesses()) {
				case 1:
					score += 50;
					break;
				case 2:
					score += 40;
					break;
				case 3:
					score += 30;
					break;
				case 4:
					score += 20;
					break;
				case 5:
					score += 10;
					break;
				}
			}
		}

		Game game = new Game(gameid, playername, score);
		return gameTarget.setEndGameData(game);
	}
}
