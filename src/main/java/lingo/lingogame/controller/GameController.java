package lingo.lingogame.controller;

import java.util.List;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.json.JSONObject;

import lingo.lingogame.domain.FeedbackWord;
import lingo.lingogame.domain.Game;
import lingo.lingogame.service.GameService;

@Path("/game")
public class GameController {
	private GameService service = new GameService();

	@GET
	@Path("/getTopFifty")
	@Produces("application/json")
	public String getTopFifty() {
		JsonArrayBuilder jab = Json.createArrayBuilder();
		List<Game> games = service.getTopFifty();

		for (Game game : games) {
			JsonObjectBuilder job = Json.createObjectBuilder();
			job.add("gameid", game.getGameid());
			job.add("playername", game.getPlayername());
			job.add("score", game.getScore());

			jab.add(job);
		}

		JsonArray array = jab.build();
		return array.toString();
	}

	@POST
	@Path("/create")
	@Produces("application/json")
	public String createGame(String stringJson) {
		JsonArrayBuilder jab = Json.createArrayBuilder();

		JSONObject myJson = new JSONObject(stringJson);
		int langid = myJson.getInt("langid");
		int length = myJson.getInt("length");

		FeedbackWord feedback = service.createGame(langid, length);

		JsonObjectBuilder job = Json.createObjectBuilder();
		job.add("gameid", feedback.getGameid());
		job.add("roundid", feedback.getRoundid());
		job.add("givenWord", feedback.getGivenWord());

		jab.add(job);

		JsonArray array = jab.build();
		return array.toString();
	}

	@POST
	@Path("/endGame")
	@Consumes("application/json")
	@Produces("application/json")
	public String setEndGameData(String stringJson) {
		JsonArrayBuilder jab = Json.createArrayBuilder();

		JSONObject myJson = new JSONObject(stringJson);
		int gameid = myJson.getInt("gameid");
		String playername = myJson.getString("playername");

		int score = service.setEndGameData(gameid, playername);

		JsonObjectBuilder job = Json.createObjectBuilder();
		job.add("score", score);

		jab.add(job);

		JsonArray array = jab.build();
		return array.toString();
	}
}
