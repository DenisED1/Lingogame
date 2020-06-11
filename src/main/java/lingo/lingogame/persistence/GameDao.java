package lingo.lingogame.persistence;

import java.util.List;

import lingo.lingogame.domain.Game;

public interface GameDao {

	List<Game> getAllGames();

	Game createGame();

	boolean setEndGameData(Game game);
}
