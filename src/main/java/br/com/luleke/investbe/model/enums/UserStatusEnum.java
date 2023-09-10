package br.com.luleke.investbe.model.enums;

import br.com.luleke.investbe.model.UserStatus;
import lombok.Getter;

@Getter
public enum UserStatusEnum {

	ATIVO(1, "Ativo"),
	AGUARDANDO_CONFIRMACAO_EMAIL(2, "Aguardando confirmação de e-mail"),
	INATIVO(3, "Inativo");
	
	private Integer id;
	private String name;
	
	private UserStatusEnum(Integer id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public UserStatus getModel() {
		return new UserStatus(this.id, this.name);
	}
}
