package lingo.lingogame.persistence;

import java.util.List;

import lingo.lingogame.domain.Game;
import lingo.lingogame.domain.GameTarget;

public class DbGameTarget implements GameTarget {
	private GameDao gameDao = new GamePostgresDaoImpl();

	public List<Game> getAllGames() {
		return gameDao.getAllGames();
	}

	public Game createGame() {
		return gameDao.createGame();
	}

	public boolean setEndGameData(Game game) {
		return gameDao.setEndGameData(game);
	}

}
