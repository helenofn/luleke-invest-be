package br.com.luleke.investbe.service.wallet;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.luleke.investbe.model.User;
import br.com.luleke.investbe.model.Wallet;
import br.com.luleke.investbe.model.respository.WalletRepository;
import br.com.luleke.investbe.rule.group.WalletCreateRuleGroup;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class WalletCreateService {

	private final WalletRepository walletRepository;
	private Wallet wallet;
	private final WalletCreateRuleGroup walletCreateRuleGroup;
		
	private void mount(User user, String name) {
		final LocalDateTime now = LocalDateTime.now();
		this.wallet = new Wallet();
		this.wallet.setName(name);
		this.wallet.setUser(user);
		this.wallet.setDhCreated(now);
		this.wallet.setDhLastUpdate(now);
		this.wallet.setDhLastCalculation(null);
	}
	
	private void validate() {
		walletCreateRuleGroup.validateRules(this.wallet);
	}
	
	@Transactional
	public Wallet create(User user, String name) {
		mount(user, name);
		validate();
				
		this.wallet = walletRepository.save(this.wallet);
		return this.wallet;
	}
}
