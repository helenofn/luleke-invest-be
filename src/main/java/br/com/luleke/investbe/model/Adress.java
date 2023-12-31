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
 * Adress entity - Maps access to Adress data
 * @author hefreita
 *
 */
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="ADRESS", schema = "LULEKE_INVEST")
public class Adress implements Serializable{
	
	private static final long serialVersionUID = 8370050846081162696L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cseq_adress", length = 18)
	private Long seqId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cseq_city")
	private AdressCity city;
	
	@Column(name = "ds_district", length = 150)
	private String dsDistrict;
	
	@Column(name = "ds_adress", length = 150)
	private String dsAdress;
	
	@Column(name = "ds_number", length = 15)
	private String dsNumber;
	
	@Column(name = "ds_complement", length = 150)
	private String adressComplement;
	
	@Column(name = "cd_zip_code", length = 22)
	private String zipCode;
}
