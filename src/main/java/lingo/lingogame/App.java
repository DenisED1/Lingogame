package lingo.lingogame;

import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import lingo.lingogame.domain.Game;
import lingo.lingogame.domain.GameTarget;
import lingo.lingogame.domain.Language;
import lingo.lingogame.domain.LanguageTarget;
import lingo.lingogame.domain.Round;
import lingo.lingogame.domain.RoundTarget;
import lingo.lingogame.domain.Word;
import lingo.lingogame.domain.WordTarget;
import lingo.lingogame.persistence.DbGameTarget;
import lingo.lingogame.persistence.DbLanguageTarget;
import lingo.lingogame.persistence.DbRoundTarget;
import lingo.lingogame.persistence.DbWordTarget;

/**
 * Hello world!
 *
 */
@WebListener
public class App implements ServletContextListener {
	private GameTarget gameTarget = new DbGameTarget();
	private WordTarget wordTarget = new DbWordTarget();
	private LanguageTarget langTarget = new DbLanguageTarget();
	private RoundTarget roundTarget = new DbRoundTarget();
	
	private Language language = new Language(1, "Netherlands");
	private Game game1 = new Game(1, "DenisED1", 110);
	private Word word1 = new Word(1, "aagje", 5, language);

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		//getRandomWord();
		//getWordWithId();
		//createGame();
		//getAllGames();
		//setEndGameData();
		//getAllLanguages();
		//getLanguageWithId();
		//createRound();
		//getAllRounds();
		updateRound();
	}
	
	public void getRandomWord() {		
		Word word = wordTarget.getRandomWord(language, 5);
		System.out.println(word.getWord());
	}
	
	public void getWordWithId() {
		Word word = wordTarget.getWordWithId(1);
		System.out.println(word.getWord());
		System.out.println(word.getLanguage().getLanguage());
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
		boolean bool = gameTarget.setEndGameData(game1);
		System.out.println(bool);
	}
	
	public void getAllLanguages() {
		List<Language> languages = langTarget.getAllLanguages();
		for(Language language : languages) {
			System.out.println("Langid: " + language.getLangid());
			System.out.println("Language: " + language.getLanguage());
		}
	}
	
	public void getLanguageWithId() {
		Language language = langTarget.getLanguageWithId(1);
		System.out.println(language.getLanguage());
	}
	
	public void createRound() {
		Round round = roundTarget.createRound(word1, game1);
		System.out.println("RoundID: " + round.getRoundid());
	}
	
	public void getAllRounds() {
		List<Round> rounds = roundTarget.getAllGameRounds(game1);
		for(Round round : rounds) {
			System.out.println("RoundID: " + round.getRoundid());
			System.out.println("Guesses: " + round.getGuesses());
			System.out.println("Word: " + round.getWord().getWord());
		}
	}
	
	public void updateRound() {
		Round round = new Round(2, 3, game1, word1);
		boolean bool = roundTarget.updateRound(round);
		System.out.println(bool);
	}
}
