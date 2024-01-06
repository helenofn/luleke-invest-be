package br.com.luleke.investbe.model.meta;

import br.com.luleke.investbe.model.UserStatus;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(UserStatus.class)
public class UserStatus_ {
	public static volatile SingularAttribute<UserStatus, Integer> id;
	public static volatile SingularAttribute<UserStatus, String> name;
	
	public static final String ID = "id";
	public static final String NAME = "name";
}
