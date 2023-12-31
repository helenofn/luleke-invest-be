package br.com.luleke.investbe.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// @MappedSuperclass
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="FINANCIAL_ASSET_EVENT", schema = "LULEKE_INVEST")
public class FinancialAssetEvent {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cseq_financial_asset_event", length = 18)
	private Long seqId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cseq_financial_asset")
	private FinancialAsset financialAsset;
	
	@JoinColumn(name = "ts_ocurrence")
	private LocalDateTime tsOcurrence;
	
	@Column(name = "dt_share_position")
	private LocalDate dtSharePosition;
	
}
