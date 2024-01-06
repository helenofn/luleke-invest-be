package br.com.luleke.investbe.model.specification;

import org.springframework.data.jpa.domain.Specification;

import br.com.luleke.investbe.model.Wallet;
import br.com.luleke.investbe.model.meta.User_;
import br.com.luleke.investbe.model.meta.Wallet_;
import br.com.luleke.investbe.util.StringUtils;

public class WalletSpecification {

	public static Specification<Wallet> nameLike(String name){
		return (root, query, criteriaBuilder) -> {
			if(StringUtils.isEmpty(name)) {
				return criteriaBuilder.conjunction();
			}
			return criteriaBuilder.like(criteriaBuilder.upper(root.get(Wallet_.NAME)), "%"+name.toUpperCase()+"%");
		};
	}
	
	public static Specification<Wallet> seqIdEquals(Long seqId){
		return (root, query, criteriaBuilder) -> {
			if(null == seqId) {
				return criteriaBuilder.conjunction();
			}
			return criteriaBuilder.equal(root.get(Wallet_.SEQ_ID), seqId);
		};
	}
	
	public static Specification<Wallet> userSeqIdEquals(Long userSeqId){
		return (root, query, criteriaBuilder) -> {
			if(null==userSeqId) {
				return criteriaBuilder.conjunction();
			}
			return criteriaBuilder.equal(root.get(Wallet_.USER).get(User_.SEQ_ID), userSeqId);
		};
	}
}
