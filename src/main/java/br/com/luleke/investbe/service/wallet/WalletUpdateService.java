package br.com.luleke.investbe.service.wallet;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.luleke.investbe.exception.WalletNotFoundException;
import br.com.luleke.investbe.model.User;
import br.com.luleke.investbe.model.Wallet;
import br.com.luleke.investbe.model.respository.WalletRepository;
import br.com.luleke.investbe.rule.group.WalletUpdateRuleGroup;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class WalletUpdateService {

	private final WalletRepository walletRepository;
	private Wallet wallet;
	private final WalletUpdateRuleGroup walletUpdateRuleGroup;
	private final WalletSingleRecordService walletSingleRecordService;
	
	private void mount(User user, Long seqId, String name, LocalDateTime lastCalculation) {
		this.wallet = walletSingleRecordService.findByIdFetch(user, seqId);
		if (null == this.wallet) {
			throw new WalletNotFoundException();
		}
		
		final LocalDateTime now = LocalDateTime.now();
		this.wallet.setName(name);
		this.wallet.setDhLastUpdate(now);
		if (null != lastCalculation) {
			this.wallet.setDhLastCalculation(lastCalculation);
		}
	}
	
	private void validate() {
		this.walletUpdateRuleGroup.validateRules(this.wallet);
	}
	
	@Transactional
	public Wallet update(User user, Long seqId, String name, LocalDateTime lastCalculation) {
		mount(user, seqId, name, lastCalculation);
		
		validate();
				
		return walletRepository.save(this.wallet);
	}
}
