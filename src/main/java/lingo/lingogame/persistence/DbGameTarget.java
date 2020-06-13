package lingo.lingogame.persistence;

import java.util.List;

import lingo.lingogame.domain.Game;
import lingo.lingogame.domain.GameTarget;

public class DbGameTarget implements GameTarget {
	private GameDao gameDao = new GamePostgresDaoImpl();

	public List<Game> getTopFifty() {
		return gameDao.getTopFifty();
	}

	public Game createGame() {
		return gameDao.createGame();
	}

	public int setEndGameData(Game game) {
		return gameDao.setEndGameData(game);
	}

}
