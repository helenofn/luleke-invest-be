package br.com.luleke.investbe.response.dto;

import java.util.ArrayList;
import java.util.List;

import br.com.luleke.investbe.config.enums.MessagesEnum;
import br.com.luleke.investbe.exception.resource.FieldMessage;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ReturnDTO {

	private Integer status;
	private String code;
	private String msg;
	private Long timeStamp;
	private List<FieldMessage> errors = new ArrayList<>();
	
	public ReturnDTO(MessagesEnum message) {
		this.status = message.getHttpStatus().value();
		this.code = message.getCodeMessage();
		this.msg = message.getMessage();
		this.timeStamp = System.currentTimeMillis();		
	}
	
	public ReturnDTO() {
		this.status = MessagesEnum.SUCCESS_OK.getHttpStatus().value();
		this.code = MessagesEnum.SUCCESS_OK.getCodeMessage();
		this.msg = MessagesEnum.SUCCESS_OK.getMessage();
		this.timeStamp = System.currentTimeMillis();
	}
	
	
	public void addError(String fieldName, String msgErro) {
		if(this.errors == null) {
			this.errors = new ArrayList<>();
		}
		this.errors.add(new FieldMessage(fieldName, msgErro));
	}
}
