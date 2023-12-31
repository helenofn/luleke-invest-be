package br.com.luleke.investbe.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
@Table(name="FINANCIAL_TRANSACTION_TYPE", schema = "LULEKE_INVEST")
public class FinancialTransactionType implements Serializable{

	private static final long serialVersionUID = -2419484924100545486L;
	
	@Id
	@Column(name = "cd_financial_transaction_type", length = 4)
	private Integer id;
	@Column(name = "ds_name", length = 100)
	private String name;
}
