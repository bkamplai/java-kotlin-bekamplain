package com.example.makeandtestclass;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

@JsonDeserialize(using = Ball.Deserializer.class)
@JsonSerialize(using = Ball.Serializer.class)
public class Ball implements AutoCloseable {
    public static class Deserializer extends JsonDeserializer<Ball> {
        @Override
        public Ball deserialize(JsonParser jp, DeserializationContext context) throws IOException {
            JsonNode node = jp.getCodec().readTree(jp);
            return new Ball(node);
        }
    }

    // https://www.baeldung.com/jackson-object-mapper-tutorial
    public static class Serializer extends StdSerializer<Ball> {
        public Serializer() {
            this(null);
        }

        public Serializer(Class<Ball> t) {
            super(t);
        }
        @Override
        public void serialize(Ball ball, JsonGenerator jsonGenerator, SerializerProvider serializer) throws IOException {
            ball.toJson(jsonGenerator);
        }
    }

    private boolean popped;
    private String color;
    private float bounceHeightInFeet;
    private double weightInGrams;

    public Ball(JsonNode node) {
        this.color = node.get("color").asText();
        this.weightInGrams = node.get("weight").asDouble();
        this.bounceHeightInFeet = node.get("height").asInt();
        this.popped = node.get("popped").asBoolean();
    }

    public void toJson(JsonGenerator out) throws IOException {
        out.writeStartObject();
        out.writeStringField("color", getColor());
        out.writeNumberField("weight", getWeightInGrams());
        out.writeNumberField("height", getBounceHeightInFeet());
        out.writeBooleanField("popped", isPopped());
        out.writeEndObject();
    }

    public String toJson() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    Ball(String color, double weightInGrams, float bounceHeightInFeet, boolean popped) {
        this.color = color;
        this.weightInGrams = weightInGrams;
        this.bounceHeightInFeet = bounceHeightInFeet;
        this.popped = popped;
    }

    Ball(double weightInGrams) {
        this("black", weightInGrams, 2.5f, false);
    }

    Ball(float bounceHeightInFeet) {
        this("black", 150.00d, bounceHeightInFeet, false);
    }

    Ball(String color) {
        this(color, 150.00d, 2.5f, false);
    }

    Ball() {
        this("black", 150.0d, 2.5f, false);
    }

    public void close() {
        System.out.println("closing ball " + this + " color " + color);
    }

    public boolean isPopped() {
        return popped;
    }

    public void setPopped(boolean popped) {
        this.popped = popped;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public float getBounceHeightInFeet() {
        return bounceHeightInFeet;
    }

    public void setBounceHeightInFeet(float bounceHeightInFeet) {
        this.bounceHeightInFeet = bounceHeightInFeet;
    }

    public double getWeightInGrams() {
        return weightInGrams;
    }

    public void setWeightInGrams(double weightInGrams) {
        if (weightInGrams > 0) {
            this.weightInGrams = weightInGrams;
        } else {
            throw new IllegalArgumentException("weight must be positive");
        }
    }
}
