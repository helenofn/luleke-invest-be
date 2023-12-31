package br.com.luleke.investbe.model;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Financial asset category entity - Maps access to financial asset category data
 * @author hefreita
 *
 */

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="FINANCIAL_ASSET_CATEGORY", schema = "LULEKE_INVEST")
public class FinancialAssetCategory {

	@Id
	@Column(name = "cd_financial_asset_category", length = 4)
	private Integer id;
	@NotEmpty(message="Preenchimento Obrigatório")
	@Length(min=4, max=100, message="O tamanho do nome deve ser entre 4 e 100 caracteres")
	@Column(name = "ds_name", length = 100)
	private String name;
}
