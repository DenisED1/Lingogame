package lingo.lingogame.controller;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.json.JSONObject;

import lingo.lingogame.domain.FeedbackWord;
import lingo.lingogame.service.RoundService;

@Path("/round")
public class RoundController {
	private RoundService service = new RoundService();

	@POST
	@Path("/next")
	@Consumes("application/json")
	@Produces("application/json")
	public String createRound(String stringJson) {
		JsonArrayBuilder jab = Json.createArrayBuilder();

		JSONObject myJson = new JSONObject(stringJson);
		int gameid = myJson.getInt("gameid");
		int langid = myJson.getInt("langid");
		int length = myJson.getInt("length");

		FeedbackWord feedback = service.createRound(gameid, langid, length);

		JsonObjectBuilder job = Json.createObjectBuilder();
		job.add("roundid", feedback.getRoundid());
		job.add("givenWord", feedback.getGivenWord());

		jab.add(job);

		JsonArray array = jab.build();
		return array.toString();
	}

	@POST
	@Path("/check")
	@Consumes("application/json")
	@Produces("application/json")
	public String checkRound(String stringJson) {
		JsonArrayBuilder jab = Json.createArrayBuilder();

		JSONObject myJson = new JSONObject(stringJson);
		int roundid = myJson.getInt("roundid");
		String guessedWord = myJson.getString("guessedWord");
		int gameid = myJson.getInt("gameid");
		int langid = myJson.getInt("langid");
		int length = myJson.getInt("length");

		FeedbackWord feedback = service.checkRound(roundid, guessedWord, gameid, langid, length);

		JsonObjectBuilder job = Json.createObjectBuilder();
		job.add("feedback", feedback.getFeedback());
		job.add("givenWord", feedback.getGivenWord());
		job.add("correct", feedback.getCorrect());
		job.add("newRoundid", feedback.getRoundid());

		jab.add(job);

		JsonArray array = jab.build();
		return array.toString();
	}
}
