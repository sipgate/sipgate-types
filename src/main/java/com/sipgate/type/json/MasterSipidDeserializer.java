package com.sipgate.type.json;

import static org.apache.commons.lang3.StringUtils.defaultString;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.sipgate.type.user.MasterSipid;
import java.io.IOException;
import java.util.Optional;

public class MasterSipidDeserializer extends JsonDeserializer<MasterSipid> {
	@Override public MasterSipid deserialize(JsonParser parser, DeserializationContext context)
			throws IOException, JsonProcessingException {
		final Optional<MasterSipid> masterSipid = MasterSipid.parse(defaultString(parser.getText()));

		if (masterSipid.isPresent()) {
			return masterSipid.get();
		}

		return null;
	}
}
