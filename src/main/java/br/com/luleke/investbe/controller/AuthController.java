package br.com.luleke.investbe.controller;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.luleke.investbe.model.User;
import br.com.luleke.investbe.request.dto.UserSignUpRequestDTO;
import br.com.luleke.investbe.response.dto.UserSignUpResponseDTO;
import br.com.luleke.investbe.service.auth.SignUpService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/auth")
@RequiredArgsConstructor
public class AuthController {

	private final SignUpService signUpService;
	
	@PostMapping(path = "/signUp")
	public ResponseEntity<UserSignUpResponseDTO> insert(@Valid @RequestBody UserSignUpRequestDTO userDto){
		User user = signUpService.execute(userDto.getName(), userDto.getEmail(), userDto.getPassword());
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
		return ResponseEntity.created(uri).body(new UserSignUpResponseDTO(user));
	}
}
