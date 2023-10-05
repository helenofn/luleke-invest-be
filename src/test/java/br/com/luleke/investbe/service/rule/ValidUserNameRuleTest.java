package br.com.luleke.investbe.service.rule;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.luleke.investbe.AbstractLulekeInvestBeTest;
import br.com.luleke.investbe.exception.InvalidUserNameException;

class ValidUserNameRuleTest extends AbstractLulekeInvestBeTest{

	@Autowired
	private ValidUserNameRule validUserNameRule;
	
	@DisplayName("Check if invalid user is name throws InvalidUserNameException")
	@Test
	void givenInvalidUserName_whenValidate_thenThrowsInvalidUserNameException() {
		String name1 = "aaaa";
		String name2 = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
		assertThrows(InvalidUserNameException.class, () -> this.validUserNameRule.initialize(name1).validate());
		assertThrows(InvalidUserNameException.class, () -> this.validUserNameRule.initialize(name2).validate());
	}
	
	@DisplayName("Check if valid user is name does not throws a exception")
	@Test
	void givenValidUserName_whenValidate_thenDoesNotThrowsException() {
		String name1 = "joão da Silva";
		assertDoesNotThrow(() -> this.validUserNameRule.initialize(name1).validate());
	}

}
