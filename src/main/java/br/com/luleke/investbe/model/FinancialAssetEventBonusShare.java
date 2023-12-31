package br.com.luleke.investbe.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name="FINANCIAL_ASSET_EVENT_BONUS_SHARE", schema = "LULEKE_INVEST")
public class FinancialAssetEventBonusShare extends FinancialAssetEvent {
	
	@Column(name = "VL_UNIT_COST", length = 20, precision = 2)
	private BigDecimal vlUnitCost;
	
	@Column(name = "QTD_ASSET_BONUS", length = 4)
	private Integer qtdStockBonus;
	
	@Column(name = "QTD_ASSET_EACH", length = 4)
	private Integer qtdStockEach;
}
