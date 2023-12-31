package br.com.luleke.investbe.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * AdressState entity - Maps access to AdressState data
 * @author hefreita
 *
 */
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="ADRESS_STATE", schema = "LULEKE_INVEST")
public class AdressState implements Serializable{
	
	private static final long serialVersionUID = -1957993012806516725L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cseq_state", length = 18)
	private Long seqId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cd_country")
	private AdressCountry country;
	
	@Column(name = "ds_sigla", length = 10)
	private String sigla;
	
	@Column(name = "ds_name", length = 70)
	private String name;
}
