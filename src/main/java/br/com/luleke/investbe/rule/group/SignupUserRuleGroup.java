package br.com.luleke.investbe.rule.group;

import org.springframework.stereotype.Component;

import br.com.luleke.investbe.model.User;
import br.com.luleke.investbe.rule.AccountEmailAlreadyExistsRule;
import br.com.luleke.investbe.rule.ValidEmailRule;
import br.com.luleke.investbe.rule.ValidUserNameRule;
import br.com.luleke.investbe.rule.ValidUserPassRule;
import br.com.luleke.investbe.rule.config.AbstractRuleGroup;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class SignupUserRuleGroup extends AbstractRuleGroup<User>{

	private final AccountEmailAlreadyExistsRule accountEmailAlreadyExistsRule;
	private final ValidEmailRule validEmailRule;
	private final ValidUserNameRule validUserNameRule;
	private final ValidUserPassRule userPassRule;
	
	@Override
	public SignupUserRuleGroup createRules() {
		this.addRule(this.accountEmailAlreadyExistsRule.initialize(this.getValueObject().getEmail()));
		this.addRule(this.validEmailRule.initialize(this.getValueObject().getEmail()));
		this.addRule(this.validUserNameRule.initialize(this.getValueObject().getName()));
		this.addRule(this.userPassRule.initialize(this.getValueObject().getPassword()));
		return this;
	}
}
