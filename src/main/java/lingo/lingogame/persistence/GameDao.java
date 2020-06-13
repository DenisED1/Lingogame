package lingo.lingogame.persistence;

import java.util.List;

import lingo.lingogame.domain.Game;

public interface GameDao {

	List<Game> getTopFifty();

	Game createGame();

	int setEndGameData(Game game);
}
