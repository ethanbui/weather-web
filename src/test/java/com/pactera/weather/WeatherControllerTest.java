package com.pactera.weather;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class WeatherControllerTest {
	@Autowired
    private MockMvc mockMvc;
	
	@Test
    public void verifyHomePage() throws Exception {
        this.mockMvc.perform(get("/")).andExpect(status().isOk()).andExpect(view().name("index"));
    }
	
	@Test
    public void shouldReturnCityList() throws Exception {
        this.mockMvc.perform(get("/retrieveCityList.json")).andDo(print()).andExpect(status().isOk());
    }
	
	@Test
    public void canRetrieveSydneyWeatherInfo() throws Exception {
		this.mockMvc.perform(post("/retrieveCityWeather.json").param("id", "1"))					
					.andDo(print())
					.andExpect(status().isOk())
					.andExpect(content().contentType("application/json;charset=UTF-8"))
					.andExpect(jsonPath("$.city").value("Sydney"));
    }
	
	@Test
	public void cannotRetrieveWeatherInfoUnknownCity() throws Exception {
		this.mockMvc.perform(post("/retrieveCityWeather.json").param("id", "4"))
				.andDo(print())
				.andExpect(status().isInternalServerError());
	}
}
