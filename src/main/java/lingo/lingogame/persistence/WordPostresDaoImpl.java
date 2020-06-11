package lingo.lingogame.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import lingo.lingogame.domain.Language;
import lingo.lingogame.domain.Word;

public class WordPostresDaoImpl extends PostgresBaseDao implements WordDao {
	public Word getRandomWord(Language language, int length) {
		Word word = null;

		try (Connection con = super.getConnection()) {
			String query = String
					.format("SELECT * FROM Word WHERE langid = %d AND length = %d OFFSET floor(random() * "
							+ "(SELECT COUNT(*) FROM Word)) LIMIT 1", language.getLangid(), length);
			PreparedStatement pstmt = con.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();

			rs.next();
			int wordid = rs.getInt("wordid");
			String wordstr = rs.getString("word");

			word = new Word(wordid, wordstr, length, language);

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
			
			LanguageDao langDao = new LanguagePostgresDaoImpl();
			Language language = langDao.getLanguageWithId(langid);

			word = new Word(wordid, wordstr, length, language);

		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return word;
	}
}