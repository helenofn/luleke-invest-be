package br.com.luleke.investbe.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * AdressCountry entity - Maps access to AdressCountry data
 * @author hefreita
 *
 */
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="ADRESS_COUNTRY", schema = "LULEKE_INVEST")
public class AdressCountry implements Serializable{

	private static final long serialVersionUID = -1205091508653613625L;
	
	@Id
	@Column(name = "cd_country", length = 5)
	private Integer id;
	
	@Column(name = "ds_name", length = 70)
	private String name;
}
