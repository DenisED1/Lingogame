package lingo.lingogame.domain;

import java.util.List;

public interface GameTarget {
	List<Game> getTopFifty();

	Game createGame();

	int setEndGameData(Game game);
}
