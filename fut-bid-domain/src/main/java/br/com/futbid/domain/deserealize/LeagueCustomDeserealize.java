package br.com.futbid.domain.deserealize;

import java.io.IOException;

import br.com.futbid.domain.enumeration.League;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class LeagueCustomDeserealize extends JsonDeserializer<League> {

    @Override
    public League deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
	return League.findBy(jp.getIntValue());
    }

}
