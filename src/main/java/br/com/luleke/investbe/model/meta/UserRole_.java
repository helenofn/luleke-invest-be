package br.com.luleke.investbe.model.meta;

import br.com.luleke.investbe.model.UserRole;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(UserRole.class)
public class UserRole_ {

	public static volatile SingularAttribute<UserRole, Long> id;
	public static volatile SingularAttribute<UserRole, String> name;
	
	public static final String ID = "id";
	public static final String NAME = "name";
}
