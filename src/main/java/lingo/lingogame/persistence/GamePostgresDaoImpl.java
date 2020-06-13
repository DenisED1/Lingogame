package lingo.lingogame.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import lingo.lingogame.domain.Game;

public class GamePostgresDaoImpl extends PostgresBaseDao implements GameDao {
	public List<Game> getTopFifty() {
		List<Game> games = new ArrayList<Game>();

		try (Connection con = super.getConnection()) {
			String query = "SELECT * FROM game WHERE playername IS NOT Null ORDER BY score DESC LIMIT 50";
			PreparedStatement pstmt = con.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				int gameid = rs.getInt("gameid");
				String playername = rs.getString("playername");
				int score = rs.getInt("score");

				games.add(new Game(gameid, playername, score));
			}

		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}

		return games;
	}

	public Game createGame() {
		Game game = null;

		try (Connection con = super.getConnection()) {
			String query = "INSERT INTO Game(score) VALUES(0)";
			PreparedStatement pstmt = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			pstmt.execute();
			ResultSet rs = pstmt.getGeneratedKeys();

			rs.next();
			int gameid = rs.getInt("gameid");
			int score = rs.getInt("score");

			game = new Game(gameid, score);

		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}

		return game;
	}

	public int setEndGameData(Game game) {
		int score = 0;

		try (Connection con = super.getConnection()) {
			String query = "UPDATE Game SET playername = ?, score = ? WHERE gameid = ?";
			PreparedStatement pstmt = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, game.getPlayername());
			pstmt.setInt(2, game.getScore());
			pstmt.setInt(3, game.getGameid());
			pstmt.execute();
			ResultSet rs = pstmt.getGeneratedKeys();

			if(rs.next()) {
				score = rs.getInt("score");
			}

		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}

		return score;
	}

}
