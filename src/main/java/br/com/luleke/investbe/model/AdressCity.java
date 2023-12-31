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
 * AdressCity entity - Maps access to AdressCity data
 * @author hefreita
 *
 */
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="ADRESS_CITY", schema = "LULEKE_INVEST")
public class AdressCity implements Serializable{

	private static final long serialVersionUID = -752742295565061841L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cseq_city", length = 18)
	private Long seqId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cseq_state")
	private AdressState state;
	
	@Column(name = "ds_name", length = 70)
	private String name;
}
