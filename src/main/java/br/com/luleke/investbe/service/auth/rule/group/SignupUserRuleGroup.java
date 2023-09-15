package br.com.luleke.investbe.service.auth.rule.group;

import org.springframework.stereotype.Component;

import br.com.luleke.investbe.model.User;
import br.com.luleke.investbe.service.auth.rule.AccountEmailAlreadyExistsRule;
import br.com.luleke.investbe.service.common.rule.AbstractRuleGroup;

@Component
public class SignupUserRuleGroup extends AbstractRuleGroup<User>{

	private final AccountEmailAlreadyExistsRule accountEmailAlreadyExistsRule;
	
	public SignupUserRuleGroup(AccountEmailAlreadyExistsRule accountEmailAlreadyExistsRule) {
		super();
		this.accountEmailAlreadyExistsRule = accountEmailAlreadyExistsRule;
		this.addRule(this.accountEmailAlreadyExistsRule);
	}
}
