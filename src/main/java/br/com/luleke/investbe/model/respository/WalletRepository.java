package br.com.luleke.investbe.model.respository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import br.com.luleke.investbe.model.Wallet;

public interface WalletRepository extends JpaRepository<Wallet, Long>, JpaSpecificationExecutor<Wallet>{

	@Query("select w "
			+ "from Wallet w "
			+ "join fetch w.user u "
			+ "where w.seqId = :seqId "
			+ "and u.seqId = :userSeqId ")
	public Optional<Wallet> findByIdFetch(Long userSeqId, Long seqId);
}
