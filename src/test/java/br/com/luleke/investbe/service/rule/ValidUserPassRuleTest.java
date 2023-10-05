package br.com.luleke.investbe.service.rule;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.luleke.investbe.AbstractLulekeInvestBeTest;
import br.com.luleke.investbe.exception.InvalidUserPassException;

class ValidUserPassRuleTest extends AbstractLulekeInvestBeTest{
	
	@Autowired
	private ValidUserPassRule validUserPassRule;

	@DisplayName("Check if invalid pass throws InvalidUserPassException")
	@Test
	void givenInvalidPass_whenValidate_throwsInvalidUserPassException() {
		String pass1 = "1654789";
		String pass2 = "165478912hajuaqwefo0987";
		String pass3 = "H890!f12365412345678123";
		String pass4 = "h123654789!asdfqwe";
		String pass5 = "h123654789asdfqwe";
		assertThrows(InvalidUserPassException.class, () -> this.validUserPassRule.initialize(pass1).validate());
		assertThrows(InvalidUserPassException.class, () -> this.validUserPassRule.initialize(pass2).validate());
		assertThrows(InvalidUserPassException.class, () -> this.validUserPassRule.initialize(pass3).validate());
		assertThrows(InvalidUserPassException.class, () -> this.validUserPassRule.initialize(pass4).validate());
		assertThrows(InvalidUserPassException.class, () -> this.validUserPassRule.initialize(pass5).validate());
	}
	
	@DisplayName("Check if valid pass does not throws a exception")
	@Test
	void givenValidPass_whenValidate_doesNotthrowsException() {
		String pass1 = "P7822f!123654";
		assertDoesNotThrow(() -> this.validUserPassRule.initialize(pass1).validate());
	}

}
