package br.com.luleke.investbe.exception.resource;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FieldMessage{

	private String fieldName;
	private String message;

}
