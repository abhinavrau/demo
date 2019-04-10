package io.pivotal.example.demo;

import org.apache.commons.text.StringEscapeUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public RouterFunction<?> routes() {
		return RouterFunctions.route()
				.GET("/dateformat", request -> {

					JSONArray ja = new JSONArray();
					JSONObject jo = new JSONObject();
					jo.put("date", "01\\/04\\/2019");
					ja.put(jo);
					String body = StringEscapeUtils.unescapeJson(ja.toString());
					return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON_UTF8)
							.syncBody(body);
				})
				.build();
	}


}
