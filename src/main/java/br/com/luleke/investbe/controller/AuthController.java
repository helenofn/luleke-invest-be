package br.com.luleke.investbe.controller;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.luleke.investbe.config.provider.JwtTokenProvider;
import br.com.luleke.investbe.dto.UserAuthDTO;
import br.com.luleke.investbe.model.User;
import br.com.luleke.investbe.request.dto.AuthenticationRequestDTO;
import br.com.luleke.investbe.request.dto.UserSignUpRequestDTO;
import br.com.luleke.investbe.response.dto.UserLoginResponseDTO;
import br.com.luleke.investbe.response.dto.UserSignUpResponseDTO;
import br.com.luleke.investbe.service.auth.AuthenticationService;
import br.com.luleke.investbe.service.auth.SignUpService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@CrossOrigin
@RestController
@RequestMapping(value = "/auth")
@RequiredArgsConstructor
public class AuthController {

	private final SignUpService signUpService;
	private final AuthenticationService authenticationService;
	private final JwtTokenProvider jwtTokenProvider;
	
	@PostMapping(path = "/signUp")
	public ResponseEntity<UserSignUpResponseDTO> signUp(@Valid @RequestBody UserSignUpRequestDTO userDto){
		User user = signUpService.execute(userDto.getName(), userDto.getEmail(), userDto.getPassword());
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
		return ResponseEntity.created(uri).body(new UserSignUpResponseDTO(user));
	}
	
	@PostMapping(path = "/login")
	public ResponseEntity<Map<Object, Object>> login(@Valid @RequestBody AuthenticationRequestDTO authenticationRequest){
		
		UserAuthDTO auth = authenticationService.authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
		String token = jwtTokenProvider.createToken(authenticationRequest.getUsername(), auth.getAuthorities());
		
		User user = (User) auth.getPrincipal();
		
		Map<Object, Object> model = new HashMap<>();
		model.put("user", new UserLoginResponseDTO(user));
		model.put("roles", auth.getAuthorities());
		model.put("token", token);
		return ResponseEntity.ok(model);
	}
}
