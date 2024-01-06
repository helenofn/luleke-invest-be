package br.com.luleke.investbe.rule.group;

import org.springframework.stereotype.Component;

import br.com.luleke.investbe.model.Wallet;
import br.com.luleke.investbe.rule.ValidWalletNameRule;
import br.com.luleke.investbe.rule.config.AbstractRuleGroup;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class WalletUpdateRuleGroup extends AbstractRuleGroup<Wallet>{
	
	private final ValidWalletNameRule validWalletNameRule;
	
	@Override
	public AbstractRuleGroup<Wallet> createRules() {
		this.addRule(this.validWalletNameRule.initialize(this.getValueObject().getName()));
		return this;
	}

}
