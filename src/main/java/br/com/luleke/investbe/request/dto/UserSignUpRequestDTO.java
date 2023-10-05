package br.com.luleke.investbe.request.dto;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserSignUpRequestDTO {

	@NotEmpty(message="Preenchimento Obrigatório")
	@Length(min=5, max=100, message="O tamanho do nome deve ser entre 5 e 80 caracteres")
	private String name;
	@NotEmpty(message="Preenchimento Obrigatório")
	@Email(message="E-mail inválido")
	@Length(min=10, max=150, message="O tamanho do e-mail deve ser entre 10 e 150 caracteres")
	private String email;
	@NotEmpty(message="Preenchimento Obrigatório")
	@Length(min=8, max=20, message="O tamanho da senha deve ser entre 8 e 12 caracteres")
	private String password;
}
