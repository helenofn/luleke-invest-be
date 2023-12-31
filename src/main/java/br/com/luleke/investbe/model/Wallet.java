package br.com.luleke.investbe.model;

import java.io.Serializable;
import java.time.LocalDateTime;

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

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="WALLET", schema = "LULEKE_INVEST")
public class Wallet implements Serializable{

	private static final long serialVersionUID = 658367273839864773L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cseq_wallet", length = 9)
	private Integer seqId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cseq_user")
	private User user;

	@Column(name = "dh_created")
	private LocalDateTime dhCreated;
	
	@Column(name = "dh_last_calculation")
	private LocalDateTime dhLastCalculation;
}
