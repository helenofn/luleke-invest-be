package br.com.luleke.investbe.model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
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
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "USER_DATA", schema = "LULEKE_INVEST")
public class User{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cseq_user", length = 22)
	private Long seqId;
	
	@NotEmpty(message="Preenchimento Obrigatório")
	@Email(message="E-mail inválido")
	@Length(min=10, max=150, message="O tamanho do e-mail deve ser entre 10 e 150 caracteres")
	@Column(name="ds_email", unique=true, length = 150)
	private String email;
	
	@NotEmpty(message="Preenchimento Obrigatório")
	@Length(min=8, max=60, message="O tamanho da senha deve ser entre 8 e 60 caracteres")
	@Column(name="ds_cript_pass", length = 60)
	private String password;
	
	@NotEmpty(message="Preenchimento Obrigatório")
	@Length(min=5, max=100, message="O tamanho do nome deve ser entre 5 e 100 caracteres")
	@Column(name="ds_name", length = 100)
	private String name;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cd_user_status")
	private UserStatus status;
	
	@Builder.Default
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(	name = "USER_DATA_ROLE", schema = "LULEKE_INVEST", 
				joinColumns = {@JoinColumn(name = "cseq_user")}, 
				inverseJoinColumns = {@JoinColumn(name = "cd_role")})
	private List<UserRole> roles = new ArrayList<>();
}
