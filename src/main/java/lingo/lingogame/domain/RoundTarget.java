package lingo.lingogame.domain;

import java.util.List;

public interface RoundTarget {
	Round createRound(Word word, Game game);

	boolean updateRound(Round round);

	List<Round> getAllGameRounds(int gameid);
}
