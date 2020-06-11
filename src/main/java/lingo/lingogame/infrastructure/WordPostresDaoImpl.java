package lingo.lingogame.infrastructure;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import lingo.lingogame.domain.Language;
import lingo.lingogame.domain.Word;

public class WordPostresDaoImpl extends PostgresBaseDao implements WordDao {
	public Word GetWord(String table, Language language) {
		Word word = null;
		
		try(Connection con = super.getConnection()){
			String query = String.format("SELECT * FROM %s WHERE langid = ?", table);
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, language.getLangid());
			ResultSet rs = pstmt.executeQuery();
			
			rs.next();
			int wordid = rs.getInt("id");
			String wordstr = rs.getString("word");
			
			word = new Word(wordid, wordstr, language);
			
		}catch(SQLException sqle) {
			sqle.printStackTrace();
		}
		
		return word;
	}

}
