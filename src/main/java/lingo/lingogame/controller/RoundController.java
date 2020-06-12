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

import lingo.lingogame.domain.Round;
import lingo.lingogame.service.RoundService;

@Path("/round")
public class RoundController {
	private RoundService service = new RoundService();

	@POST
	@Path("/create")
	@Consumes("application/json")
	@Produces("application/json")
	public String createRound(String stringJson) {
		JsonArrayBuilder jab = Json.createArrayBuilder();

		JSONObject myJson = new JSONObject(stringJson);
		int gameid = myJson.getInt("gameid");
		int langid = myJson.getInt("langid");
		int length = myJson.getInt("length");

		Round round = service.createRound(gameid, langid, length);

		JsonObjectBuilder job = Json.createObjectBuilder();
		job.add("roundid", round.getRoundid());

		jab.add(job);

		JsonArray array = jab.build();
		return array.toString();
	}

	@POST
	@Path("/update")
	@Consumes("application/json")
	@Produces("application/json")
	public String updateRound(String stringJson) {
		JsonArrayBuilder jab = Json.createArrayBuilder();

		JSONObject myJson = new JSONObject(stringJson);
		int roundid = myJson.getInt("roundid");
		int guesses = myJson.getInt("guesses");

		boolean bool = service.updateRound(roundid, guesses);

		JsonObjectBuilder job = Json.createObjectBuilder();
		job.add("bool", bool);

		jab.add(job);

		JsonArray array = jab.build();
		return array.toString();
	}
}
