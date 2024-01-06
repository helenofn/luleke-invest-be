package br.com.luleke.investbe.service.wallet;

import org.springframework.stereotype.Service;

import br.com.luleke.investbe.model.User;
import br.com.luleke.investbe.model.Wallet;
import br.com.luleke.investbe.model.respository.WalletRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class WalletSingleRecordService {

	private final WalletRepository walletRepository;
	
	public Wallet findByIdFetch(User user, Long seqId) {
		return this.walletRepository.findByIdFetch(user.getSeqId(), seqId).orElse(null);
	}
}
