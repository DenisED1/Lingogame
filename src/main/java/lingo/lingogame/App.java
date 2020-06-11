package lingo.lingogame;

import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import lingo.lingogame.domain.Game;
import lingo.lingogame.domain.GameTarget;
import lingo.lingogame.domain.Language;
import lingo.lingogame.domain.Word;
import lingo.lingogame.domain.WordTarget;
import lingo.lingogame.persistence.DbGameTarget;
import lingo.lingogame.persistence.DbWordTarget;

/**
 * Hello world!
 *
 */
@WebListener
public class App implements ServletContextListener {
	private GameTarget gameTarget = new DbGameTarget();
	/*public static void main(String[] args) {
		System.out.println("Hello World!");

		Language language = new Language(1, "Netherlands");

		WordTarget wordTarget = new DbWordTarget();
		Word word = wordTarget.getRandomWord("five_letter_words", language);
		System.out.println(word.getWord());
	}*/

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		//getRandomWord();
		//createGame();
		//getAllGames();
		//setEndGameData();
	}
	
	public void getRandomWord() {
		Language language = new Language(1, "Netherlands");

		WordTarget wordTarget = new DbWordTarget();
		Word word = wordTarget.getRandomWord("five_letter_words", language);
		System.out.println(word.getWord());
	}
	
	public void createGame() {
		Game game = gameTarget.createGame();
		System.out.println("GameID: " + game.getGameid());
		System.out.println("Score: " + game.getScore());
	}
	
	public void getAllGames() {
		List<Game> games = gameTarget.getAllGames();
		for(Game game : games) {
			System.out.println("GameID: " + game.getGameid());
			System.out.println("Playername: " + game.getPlayername());
			System.out.println("Score: " + game.getScore());
		}
	}
	
	public void setEndGameData() {
		Game game = new Game(1, "DenisED1", 110);
		boolean bool = gameTarget.setEndGameData(game);
		System.out.println(bool);
	}
}
