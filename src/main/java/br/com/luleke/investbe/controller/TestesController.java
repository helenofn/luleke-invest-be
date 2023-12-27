package br.com.luleke.investbe.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.luleke.investbe.model.User;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/teste")
@RequiredArgsConstructor
public class TestesController {

	@GetMapping(path = "/teste1")
	public ResponseEntity<Void> teste1(){
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping(path = "/teste2")
	public ResponseEntity<Void> teste2(@AuthenticationPrincipal User user){
		// Spring não está adcionando o user aqui
		System.out.println(user.getEmail());
		return ResponseEntity.noContent().build();
	}
	
	@PreAuthorize("hasRole('COMMON')")
	@GetMapping(path = "/testeRole")
	public ResponseEntity<Void> testeRole(@AuthenticationPrincipal User user){
		System.out.println(user.getEmail());
		return ResponseEntity.noContent().build();
	}
}
