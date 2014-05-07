package br.com.futbid.domain.deserealize;

import java.io.IOException;

import br.com.futbid.domain.enumeration.League;
import br.com.futbid.domain.enumeration.Position;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class PositionCustomDeserealize extends JsonDeserializer<Position> {

    @Override
    public Position deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
	return Position.findBy(jp.getText());
    }

}
