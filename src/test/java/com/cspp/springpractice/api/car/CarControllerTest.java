package com.cspp.springpractice.api.car;

import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.cspp.springpractice.api.car.model.Car;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CarControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	CarManager carManager;

	@Test
	public void shouldReturnRequestedCarById() throws Exception {
		Car car = new Car(1234, "abc", "abc");

		when(carManager.getCarById(anyLong())).thenReturn(car);

		mockMvc.perform(get("/v1/car/1234"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().string("{\"id\":1234,\"type\":\"abc\",\"brand\":\"abc\"}"));
	}

	@Test
	public void shouldCreateCar() throws Exception {
		String validCar = "{\n"
				+ "    \"id\": 1234,\n"
				+ "    \"type\": \"combi\",\n"
				+ "    \"brand\": \"BMW\"\n"
				+ "}";

		mockMvc.perform(post("/v1/car/create").content(validCar).contentType(APPLICATION_JSON).accept(APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isAccepted());
	}

	@Test
	public void shouldReturnWithBadRequestWhenCreatingWithInvalidId() throws Exception {
		String invalidCar = "{\n"
				+ "    \"id\": 1,\n"
				+ "    \"type\": \"combi\",\n"
				+ "    \"brand\": \"BMW\"\n"
				+ "}";

		mockMvc.perform(post("/v1/car/create").content(invalidCar).contentType(APPLICATION_JSON).accept(APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isBadRequest())
				.andExpect(content().string("{\"code\":\"400\",\"details\":\"Invalid parameter(s)\"}"));
	}

}