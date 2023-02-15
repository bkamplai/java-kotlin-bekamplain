package com.example.capco;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.io.IOException;

@JsonDeserialize(using = Cap.JsonDeserializer.class)
public class Cap {
    public static class JsonDeserializer extends com.fasterxml.jackson.databind.JsonDeserializer<Cap> {
    //{"size":"MEDIUM","label":"Ok"}
        @Override
        public Cap deserialize(JsonParser jp, DeserializationContext context) throws IOException {

            JsonNode node = jp.getCodec().readTree(jp);
            return new Cap(node);
        }
    }

    // Size Cap.size = Size.MEDIUM;
    public static final Size DEFAULT_SIZE = Size.MEDIUM;
    private static Size size = DEFAULT_SIZE;
    private String label = DEFAULT_LABEL;
    public static final String DEFAULT_LABEL = "";

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        if (size == null) {
            throw new IllegalArgumentException("size cannot be null");
        }
        this.size = size;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        if (label == null) {
            throw new IllegalArgumentException("label cannot be null");
        }
        if (Utils.codepoints(label) > 20) {
            throw new IllegalArgumentException("label is too long");
        }
        this.label = label;
    }

    public Cap(JsonNode node) {
        this.size =  Size.valueOf(node.get("size").asText());
        this.label = node.get("label").asText();
    }

    public Cap(String label, Size size) {
        this.label = label;
        this.size = size;
    }

    public Cap() {
        this(DEFAULT_LABEL, DEFAULT_SIZE);
    }
}