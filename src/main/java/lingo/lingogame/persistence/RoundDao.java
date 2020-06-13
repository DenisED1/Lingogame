package lingo.lingogame.persistence;

import java.util.List;

import lingo.lingogame.domain.Game;
import lingo.lingogame.domain.Round;
import lingo.lingogame.domain.Word;

public interface RoundDao {
	Round createRound(Word word, Game game);

	boolean updateRound(Round round);

	List<Round> getAllGameRounds(int gameid);

	Round getRoundWithId(int roundid);
}
