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
@Table(name = "USER_STATUS", schema = "LULEKE_INVEST")
public class UserStatus {
	
	@Id
	@Column(name="cd_user_status", length = 2)
	private Integer id;
	
	@Column(name="ds_name", length = 50)
	private String name;
}
