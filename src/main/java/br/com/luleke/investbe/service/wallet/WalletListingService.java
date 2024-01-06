package br.com.luleke.investbe.service.wallet;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import br.com.luleke.investbe.model.User;
import br.com.luleke.investbe.model.Wallet;
import br.com.luleke.investbe.model.respository.WalletRepository;
import br.com.luleke.investbe.model.specification.WalletSpecification;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class WalletListingService extends WalletSpecification{

	private final WalletRepository walletRepository;
	
	public Page<Wallet> listPage(
			User user,
			Integer page, 
			Integer linesPerPage, 
			String direction, 
			String orderBy, 
			Long seqId,
			String name){
		
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		Specification<Wallet> specification = 
				Specification
					.where(userSeqIdEquals(user.getSeqId()))
					.and(nameLike(name))
					.and(seqIdEquals(seqId));
		return walletRepository.findAll(specification,pageRequest);
	}
}
