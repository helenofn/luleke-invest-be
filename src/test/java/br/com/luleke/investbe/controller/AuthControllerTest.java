package br.com.luleke.investbe.controller;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.luleke.investbe.request.dto.UserSignUpRequestDTO;
import br.com.luleke.investbe.service.auth.SignUpService;
import br.com.luleke.investbe.test.util.UserTestUtil;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = AuthController.class)
class AuthControllerTest {

	@Autowired
	private WebApplicationContext webApplicationContext;
	@Autowired
	private ObjectMapper objectMapper;
	@MockBean
	private SignUpService signUpService;
	@Autowired
	private MockMvc mockMvc;
	
	private void confSignUpService() {
		when(signUpService.execute(anyString(), anyString(), anyString())).thenReturn(UserTestUtil.buildUserToReturn());
	}
	
	@BeforeEach
	public void setup()
	{
	    //Init MockMvc Object and build
	    mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	    confSignUpService();
	}
	
	@DisplayName("Check status return when valid user signup request")
	@Test
	void whenValidInput_thenReturnIsCreated() throws Exception {
		UserSignUpRequestDTO userRequest = UserSignUpRequestDTO.builder().email("joao.silvasauro@gmail.com")
				.name("João da Silva Sauro").password("H174011f!la").build();

		mockMvc.perform(post("/auth/signUp").contentType("application/json")
				.content(objectMapper.writeValueAsString(userRequest))).andExpect(status().isCreated());
	}
	
	@DisplayName("Check status return when invalid username signup is requested")
	@Test
	void whenInvalidName_thenReturnIsNotAcceptable() throws Exception {
		UserSignUpRequestDTO userRequest = UserSignUpRequestDTO.builder().email("joao.silvasauro@gmail.com")
				.name("H").password("H174011f!la").build();

		mockMvc.perform(post("/auth/signUp").contentType("application/json")
				.content(objectMapper.writeValueAsString(userRequest))).andExpect(status().isNotAcceptable());
	}
	
	@DisplayName("Check status return when invalid user is pass signup is requested")
	@Test
	void whenInvalidPass_thenReturnIsNotAcceptable() throws Exception {
		UserSignUpRequestDTO userRequest = UserSignUpRequestDTO.builder().email("joao.silvasauro@gmail.com")
				.name("João da Silva Sauro").password("H").build();

		mockMvc.perform(post("/auth/signUp").contentType("application/json")
				.content(objectMapper.writeValueAsString(userRequest))).andExpect(status().isNotAcceptable());
	}
	
	@DisplayName("Check status return when invalid user is e-mail signup is requested")
	@Test
	void whenInvalidMail_thenReturnIsNotAcceptable() throws Exception {
		UserSignUpRequestDTO userRequest = UserSignUpRequestDTO.builder().email("joao.silvasauro.gmail.com")
				.name("João da Silva Sauro").password("H").build();

		mockMvc.perform(post("/auth/signUp").contentType("application/json")
				.content(objectMapper.writeValueAsString(userRequest))).andExpect(status().isNotAcceptable());
	}

}
