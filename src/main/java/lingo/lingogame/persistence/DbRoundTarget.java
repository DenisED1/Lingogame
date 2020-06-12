package lingo.lingogame.persistence;

import java.util.List;

import lingo.lingogame.domain.Game;
import lingo.lingogame.domain.Round;
import lingo.lingogame.domain.RoundTarget;
import lingo.lingogame.domain.Word;

public class DbRoundTarget implements RoundTarget {
	private RoundDao roundDao = new RoundPostgresDaoImpl();

	public Round createRound(Word word, Game game) {
		return roundDao.createRound(word, game);
	}

	public boolean updateRound(Round round) {
		return roundDao.updateRound(round);
	}

	public List<Round> getAllGameRounds(int gameid) {
		return roundDao.getAllGameRounds(gameid);
	}
}