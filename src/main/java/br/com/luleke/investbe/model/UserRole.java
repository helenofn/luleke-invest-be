package br.com.luleke.investbe.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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
@Table(name="USER_ROLE", schema = "LULEKE_INVEST")
public class UserRole {

	@Id
	@Column(name="cd_role", length = 3)
	private Integer code;
	
	@Column(name="ds_name", unique=true, length = 50)
	private String name;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(	name = "ROLE_APP_FEATURE", schema = "LULEKE_INVEST", 
				joinColumns = {@JoinColumn(name = "cd_role")}, 
				inverseJoinColumns = {@JoinColumn(name = "cd_feature")})
	private List<AppFeature> features = new ArrayList<>();
}
