package io.pivotal.example.demo;

import org.apache.commons.text.StringEscapeUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureWebTestClient
public class DemoApplicationTests {




	@Autowired
	WebTestClient client;

	@Test
	public void contextLoads() {


	}

	@Test
	public void testJsonDataFormat() {


		JSONArray ja = new JSONArray();
		JSONObject jo = new JSONObject();
		jo.put("date", "01\\/04\\/2019");
		ja.put(jo);

		String expected = StringEscapeUtils.unescapeJson(ja.toString());

		this.client.get().uri("/dateformat").accept(MediaType.APPLICATION_JSON_UTF8)
				.exchange()
				.expectStatus().isOk()
				.expectHeader().contentType(MediaType.APPLICATION_JSON_UTF8).expectBody().json(expected);
	}

}
