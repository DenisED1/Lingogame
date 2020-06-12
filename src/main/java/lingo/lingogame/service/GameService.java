package lingo.lingogame.service;

import java.util.List;

import lingo.lingogame.domain.Game;
import lingo.lingogame.domain.GameTarget;
import lingo.lingogame.domain.Round;
import lingo.lingogame.persistence.DbGameTarget;

public class GameService {
	private GameTarget gameTarget = new DbGameTarget();
	private RoundService roundService = new RoundService();

	public List<Game> getAllGames() {
		return gameTarget.getAllGames();
	}

	public Game createGame() {
		return gameTarget.createGame();
	}

	public boolean setEndGameData(int gameid, String playername) {
		int score = 0;
		List<Round> rounds = roundService.getAllGameRounds(gameid);

		for (Round round : rounds) {
			if (round.getGuesses() != 0) {
				switch (round.getGuesses()) {
				case 1:
					score += 50;
				case 2:
					score += 40;
				case 3:
					score += 30;
				case 4:
					score += 20;
				case 5:
					score += 10;
				}
			}
		}

		Game game = new Game(gameid, playername, score);
		return gameTarget.setEndGameData(game);
	}
}
