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
@Table(name="FINANCIAL_TRANSACTION", schema = "LULEKE_INVEST")
public class FinancialTransaction implements Serializable{
	
	private static final long serialVersionUID = 3913037614522720180L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cseq_financial_transaction", length = 18)
	private Long seqId;
	
	@JoinColumn(name = "dh_ocurrence")
	private LocalDateTime dhOcurrence;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cseq_wallet")
	private Wallet wallet;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cseq_financial_asset")
	private FinancialAsset financialAsset;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cd_financial_transaction_type")
	private FinancialTransactionType type;
	
	@Column(name = "qtd_asset")
	private Integer qtd;
	
	@Column(name = "unitary_value")
	private Double unitaryValue;
	
	@Column(name = "fee_value")
	private Double feeValue;
	
}
