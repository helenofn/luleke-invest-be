package br.com.luleke.investbe.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
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
@Table(name="FINANCIAL_ASSET_EVENT_INPLIT_SPLIT", schema = "LULEKE_INVEST")
public class FinancialAssetEventInplitSplit extends FinancialAssetEvent{
	
	@JoinColumn(name = "proportion_from")
	private Integer proportionFrom;
	
	@JoinColumn(name = "proportion_to")
	private Integer proportionTo;

}
