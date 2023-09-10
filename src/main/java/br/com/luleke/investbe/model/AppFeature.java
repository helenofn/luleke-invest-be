package br.com.luleke.investbe.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "APP_FEATURE", schema = "LULEKE_INVEST")
public class AppFeature {

	@Id
	@Column(name="cd_feature", length = 6)
	private Integer id;
	
	@Column(name="ds_name", length = 22)
	private String name;
}
