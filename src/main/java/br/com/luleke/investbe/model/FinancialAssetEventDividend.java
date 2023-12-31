package br.com.luleke.investbe.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="FINANCIAL_ASSET_EVENT_DIVIDEND", schema = "LULEKE_INVEST")
public class FinancialAssetEventDividend extends FinancialAssetEvent {
	
	@Column(name = "vl_value_by_quote")
	private BigDecimal vlValueByQuote;
	
	@Column(name = "vl_approved_total_amount")
	private BigDecimal vlApprovedTotalAmount;
	
	@Column(name = "ts_announcement")
	private LocalDateTime tsAnnouncement;
		
	@Column(name = "dt_expected_payment")
	private LocalDate dtExpectedPayment;
}
