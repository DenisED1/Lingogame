package lingo.lingogame.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import lingo.lingogame.domain.Language;

public class LanguagePostgresDaoImpl extends PostgresBaseDao implements LanguageDao {
	public List<Language> getAllLanguages() {
		List<Language> languages = new ArrayList<Language>();

		try (Connection con = super.getConnection()) {
			String query = "SELECT * FROM Languages";
			PreparedStatement pstmt = con.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				int langid = rs.getInt("langid");
				String language = rs.getString("language");

				languages.add(new Language(langid, language));
			}

		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}

		return languages;
	}
}