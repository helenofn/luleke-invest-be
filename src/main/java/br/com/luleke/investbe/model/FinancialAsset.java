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

/**
 * Financial asset entity - Maps access to financial asset data - may be a stock, ação, fii, etc.. - assets traded on the stock exchange
 * @author hefreita
 *
 */
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="FINANCIAL_ASSET", schema = "LULEKE_INVEST")
public class FinancialAsset implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cseq_financial_asset", length = 18)
	private Long seqId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cseq_stock_exchange")
	private Company stockExchange;
	
	@Column(name = "ds_ticker", length = 50)
	private String ticker;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cseq_company")
	private Company company;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cseq_bookkeeper")
	private Company bookkeeper;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cseq_financial_asset_category")
	private FinancialAssetCategory financialAssetCategory;
	
	@Column(name = "dh_last_update")
	private LocalDateTime lastUpadate;
}
