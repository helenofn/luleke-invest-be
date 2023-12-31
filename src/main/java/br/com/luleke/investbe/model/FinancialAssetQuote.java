package br.com.luleke.investbe.model;

import java.io.Serializable;

import br.com.luleke.investbe.model.pk.FinancialAssetQuotePK;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Financial asset quote entity - Maps access to financial asset quote data
 * @author hefreita
 *
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name = "FINANCIAL_ASSET_QUOTE", schema = "LULEKE_INVEST")
public class FinancialAssetQuote implements Serializable{
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private FinancialAssetQuotePK id = new FinancialAssetQuotePK();
	
	@Column(name = "VL_OPEN_PRICE", length = 20, precision = 2)
	private Double openPrice;
	@Column(name = "VL_MAX_PRICE", length = 20, precision = 2)
	private Double maxPrice;
	@Column(name = "VL_MIN_PRICE", length = 20, precision = 2)
	private Double minPrice;
	@Column(name = "VL_PRICE", length = 20, precision = 2)
	private Double price;
	@Column(name = "QT_VOLUME", length = 20)
	private Long volume;
}
