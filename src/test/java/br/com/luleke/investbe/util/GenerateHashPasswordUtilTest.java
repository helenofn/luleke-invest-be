package br.com.luleke.investbe.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GenerateHashPasswordUtilTest {

	@DisplayName("Test to encrypt a String")
	@Test
	void givenString_whenCrypt_thenReturnEncryptedString() {
		String strToEncrypt = "StrASerIncryptada";
		String strHas = GenerateHashPasswordUtil.getHashFromPassword(strToEncrypt);
        assertThat(strToEncrypt).isNotEqualTo(strHas);
	}
	
	@DisplayName("Test to check if a String matches the same String, but encrypted")
	@Test
	void givenString_whenCrypt_thenReturnDecryptedString() {
		String strToEncrypt = "StrASerIncryptada";
		String strHas = GenerateHashPasswordUtil.getHashFromPassword(strToEncrypt);
		boolean isMatches = GenerateHashPasswordUtil.isPasswordMatch(strToEncrypt, strHas);
        assertThat(isMatches).isTrue();
	}

}
