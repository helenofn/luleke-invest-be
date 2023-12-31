package br.com.luleke.investbe.model.enums;

import lombok.Getter;

@Getter
public enum BrokerStatusEnum {

	ATIVO(1,"Ativo"),
	INATIVO(2,"Inativo");
	
	private final Integer code;
	private final String name;
	
	BrokerStatusEnum(Integer code, String name){
		this.code = code;
		this.name = name;
	}
}
