package lingo.lingogame.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import lingo.lingogame.domain.Language;
import lingo.lingogame.domain.Word;

public class WordPostresDaoImpl extends PostgresBaseDao implements WordDao {
	public Word getRandomWord(Language language, int length) {
		Word word = null;

		try (Connection con = super.getConnection()) {
			String query = "SELECT * FROM Word WHERE langid = ? AND length = ? ORDER BY random() LIMIT 1";
			PreparedStatement pstmt = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			pstmt.setInt(1, language.getLangid());
			pstmt.setInt(2, length);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				int wordid = rs.getInt("wordid");
				String wordstr = rs.getString("word");
				
				word = new Word(wordid, wordstr, length, language);
			}

		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}

		return word;
	}

	public Word getWordWithId(int wordid) {
		Word word = null;

		try (Connection con = super.getConnection()) {
			PreparedStatement pstmt = con.prepareStatement("SELECT * FROM Word WHERE wordid = ?");
			pstmt.setInt(1, wordid);
			ResultSet rs = pstmt.executeQuery();

			rs.next();
			String wordstr = rs.getString("word");
			int length = rs.getInt("length");
			int langid = rs.getInt("langid");

			Language language = new Language(langid);

			word = new Word(wordid, wordstr, length, language);

		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return word;
	}
}