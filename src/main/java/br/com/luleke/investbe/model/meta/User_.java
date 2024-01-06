package br.com.luleke.investbe.model.meta;

import java.util.List;

import br.com.luleke.investbe.model.User;
import br.com.luleke.investbe.model.UserRole;
import br.com.luleke.investbe.model.UserStatus;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(User.class)
public class User_ {

	public static volatile SingularAttribute<User, Long> seqId;
	public static volatile SingularAttribute<User, String> email;
	public static volatile SingularAttribute<User, String> password;
	public static volatile SingularAttribute<User, String> name;
	public static volatile SingularAttribute<User, UserStatus> status;
	public static volatile SingularAttribute<User, List<UserRole>> roles;
	
	public static final String SEQ_ID = "seqId";
	public static final String EMAIL = "email";
	public static final String PASSWORD = "password";
	public static final String NAME = "name";
	public static final String STATUS = "status";
	public static final String ROLES = "roles";
}
