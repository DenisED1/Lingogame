package lingo.lingogame.controller;

import java.util.List;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import lingo.lingogame.domain.Language;
import lingo.lingogame.service.LanguageService;

@Path("/language")
public class LanguageController {
	private LanguageService service = new LanguageService();

	@GET
	@Path("/getAll")
	@Produces("application/json")
	public String getAllAreas() {
		JsonArrayBuilder jab = Json.createArrayBuilder();
		List<Language> languages = service.getAllLanguages();

		for (Language lang : languages) {
			JsonObjectBuilder job = Json.createObjectBuilder();
			job.add("langid", lang.getLangid());
			job.add("language", lang.getLanguage());

			jab.add(job);
		}

		JsonArray array = jab.build();
		return array.toString();
	}
}
