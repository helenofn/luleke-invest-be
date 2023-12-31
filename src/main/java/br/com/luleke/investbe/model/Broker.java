package br.com.luleke.investbe.model;

import java.io.Serializable;

import org.hibernate.validator.constraints.Length;

import br.com.luleke.investbe.model.enums.BrokerStatusEnum;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Broker entity - Maps access to Broker data - 
 * Entity responsible for carrying out brokerage services for financial assets
 * @author hefreita
 *
 */
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="BROKER", schema = "LULEKE_INVEST")
public class Broker implements Serializable{

	private static final long serialVersionUID = 6507010296243050159L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cseq_broker", length = 9)
	private Integer seqId;
	
	@Column(name = "cd_status", length = 1)
	private BrokerStatusEnum status;
	
	@NotEmpty(message="O campo nome tem preenchimento Obrigatório")
	@Length(min=5, max=150, message="O tamanho do nome deve ser entre 5 e 150 caracteres")
	@Column(name = "ds_name", length = 150)
	private String name;
	
	@NotEmpty(message="O campo cnpj tem preenchimento obrigatório")
	@Length(min=5, max=20, message="O tamanho código da pessoa jurídica dever entre 5 e 20 caracteres")
	@Column(name = "ds_ein", length = 20)
	private String ein;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "cseq_adress")
	private Adress mainAdress;
}
