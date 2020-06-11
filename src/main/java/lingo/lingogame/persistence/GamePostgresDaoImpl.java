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
	public List<Game> getAllGames() {
		List<Game> games = new ArrayList<Game>();

		try (Connection con = super.getConnection()) {
			String query = "SELECT * FROM GAME";
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
			String query = "INSERT INTO game(score) VALUES(0)";
			PreparedStatement pstmt = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			pstmt.execute();
			System.out.println(query);
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

	public boolean setEndGameData(Game game) {
		boolean result = false;

		try (Connection con = super.getConnection()) {
			String query = "UPDATE game SET playername = ?, score = ? WHERE gameid = ?";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, game.getPlayername());
			pstmt.setInt(2, game.getScore());
			pstmt.setInt(3, game.getGameid());
			pstmt.execute();

			result = true;

		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}

		return result;
	}

}
