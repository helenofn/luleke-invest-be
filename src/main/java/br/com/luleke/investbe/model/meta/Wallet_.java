package br.com.luleke.investbe.model.meta;

import java.time.LocalDateTime;

import br.com.luleke.investbe.model.User;
import br.com.luleke.investbe.model.Wallet;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Wallet.class)
public class Wallet_ {

	public static volatile SingularAttribute<Wallet, Long> seqId;
	public static volatile SingularAttribute<Wallet, User> user;
	public static volatile SingularAttribute<Wallet, String> name;
	public static volatile SingularAttribute<Wallet, LocalDateTime> dhCreated;
	public static volatile SingularAttribute<Wallet, LocalDateTime> dhLastCalculation;
	
	public static final String SEQ_ID = "seqId";
	public static final String USER = "user";
	public static final String NAME = "name";
	public static final String DH_CREATED = "dhCreated";
	public static final String DH_LAST_CALCULATION = "dhLastCalculation";
}
