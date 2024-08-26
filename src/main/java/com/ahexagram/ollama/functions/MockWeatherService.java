package com.ahexagram.ollama.functions;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.Function;


public class MockWeatherService implements Function<MockWeatherService.Request, MockWeatherService.Response> {

	public enum Unit { C, F }
	public record Request(String location, Unit unit) {}
	public record Response(double temp, Unit unit) {}
    private static final Logger log = LoggerFactory.getLogger(MockWeatherService.class);

    public MockWeatherService(){
        log.info("Mock Weather API constructed");
    }

	public Response apply(Request request) {
        log.info("Mock Weather API is used 30.0");
		return new Response(30.0, Unit.C);
	}
}