package lingo.lingogame.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import lingo.lingogame.domain.Game;
import lingo.lingogame.domain.Round;
import lingo.lingogame.domain.Word;

public class RoundPostgresDaoImpl extends PostgresBaseDao implements RoundDao{
	public Round createRound(Word word, Game game) {
		Round round = null;

		try (Connection con = super.getConnection()) {
			String query = "INSERT INTO Round(guesses, gameid, wordid) VALUES(0, ?, ?)";
			PreparedStatement pstmt = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			pstmt.setInt(1, game.getGameid());
			pstmt.setInt(2, word.getWordid());
			pstmt.execute();
			ResultSet rs = pstmt.getGeneratedKeys();

			rs.next();
			int roundid = rs.getInt("roundid");
			int guesses = rs.getInt("guesses");

			round = new Round(roundid, guesses, game, word);

		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}

		return round;
	}

	public boolean updateRound(Round round) {
		boolean result = false;

		try (Connection con = super.getConnection()) {
			String query = "UPDATE Round SET guesses = ? WHERE roundid = ?";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, round.getGuesses());
			pstmt.setInt(2, round.getRoundid());
			pstmt.execute();

			result = true;

		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}

		return result;
	}

	public List<Round> getAllGameRounds(int gameid) {
		List<Round> rounds = new ArrayList<Round>();

		try (Connection con = super.getConnection()) {
			String query = "SELECT * FROM Round where gameid = ?";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, gameid);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				int roundid = rs.getInt("roundid");
				int guesses = rs.getInt("guesses");
				int wordid = rs.getInt("wordid");
				
				WordDao wordDao = new WordPostresDaoImpl();
				Word word = wordDao.getWordWithId(wordid);

				Game game = new Game(gameid);
				rounds.add(new Round(roundid, guesses, game, word));
			}

		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}

		return rounds;
	}

}
