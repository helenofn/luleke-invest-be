package br.com.luleke.investbe.rule;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.luleke.investbe.AbstractLulekeInvestBeTest;
import br.com.luleke.investbe.exception.InvalidEmailException;

class ValidEmailRuleTest extends AbstractLulekeInvestBeTest{

	@Autowired
	private ValidEmailRule validEmailRule;
	
	@DisplayName("Check if a invalid mail throws InvalidEmailException")
	@Test
	void givenInvalidMail_whenValidate_thenThrowsInvalidEmailException() {
		String mailInv1 = "";
		String mailInv2 = null;
		String mailInv3 = "asasa@";
		String mailInv4 = ".com";
		String mailInv5 = "sasa@sasa.";
		assertThrows(InvalidEmailException.class, () -> this.validEmailRule.initialize(mailInv1).validate());
		assertThrows(InvalidEmailException.class, () -> this.validEmailRule.initialize(mailInv2).validate());
		assertThrows(InvalidEmailException.class, () -> this.validEmailRule.initialize(mailInv3).validate());
		assertThrows(InvalidEmailException.class, () -> this.validEmailRule.initialize(mailInv4).validate());
		assertThrows(InvalidEmailException.class, () -> this.validEmailRule.initialize(mailInv5).validate());
	}
	
	@DisplayName("Check if a valid e-mail does not throws exception")
	@Test
	void givenValidEmail_whenValidate_thenDoesNotThrowsException() {
		String mailInv1 = "asasa@sasa.com.br";
		String mailInv2 = "asasa@sasa.com";
		String mailInv3 = "asa_sa@sasa.com";
		String mailInv4 = "asa.sa@sasa.com";
		assertDoesNotThrow(() -> this.validEmailRule.initialize(mailInv1).validate());
		assertDoesNotThrow(() -> this.validEmailRule.initialize(mailInv2).validate());
		assertDoesNotThrow(() -> this.validEmailRule.initialize(mailInv3).validate());
		assertDoesNotThrow(() -> this.validEmailRule.initialize(mailInv4).validate());
	}
	
	@DisplayName("Check the maximun email size")
	@Test
	void givenMailWithGraterThenMaximun_whenValidate_thenThrowsInvalidEmailException() {
		String mailInv1 = "asaasasasaasaasasasaasaasasasaasaasasasaasaasasasaasaasasasasasasasasasasaasasasasasasasasasadsasasasasadfdfdsfsdfdsasasaddfdfdsfsdfdsfdsfsffs@sdaasdsdsa.com";
		assertThrows(InvalidEmailException.class, () -> this.validEmailRule.initialize(mailInv1).validate());
	}
	
	@DisplayName("Check the minimun email size")
	@Test
	void givenMailWithLessThenMinimun_whenValidate_thenThrowsInvalidEmailException() {
		String mailInv1 = "a@s.com";
		assertThrows(InvalidEmailException.class, () -> this.validEmailRule.initialize(mailInv1).validate());
	}

}
