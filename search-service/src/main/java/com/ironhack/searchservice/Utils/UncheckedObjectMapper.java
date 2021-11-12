package com.ironhack.searchservice.Utils;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.CompletionException;

public class UncheckedObjectMapper extends ObjectMapper {
    /**
     * Parses the given JSON string into a Map.
     */
    public Map<String, String> readValue(String content) {
        try {
            return this.readValue(content, new TypeReference<>() {
            });
        } catch (IOException ioe) {
            throw new CompletionException(ioe);
        }
    }
}

