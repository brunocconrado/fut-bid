package br.com.futbid.domain.deserealize;

import java.io.IOException;

import br.com.futbid.domain.enumeration.Team;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class TeamCustomDeserealize extends JsonDeserializer<Team> {

    @Override
    public Team deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
	return Team.findBy(jp.getText());
    }

}
