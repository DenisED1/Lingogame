package lingo.lingogame.domain;

import java.util.List;

public interface GameTarget {
	List<Game> getAllGames();

	Game createGame();

	boolean setEndGameData(Game game);
}
