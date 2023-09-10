package br.com.luleke.investbe.service.auth.rule.group;

import org.springframework.stereotype.Component;

import br.com.luleke.investbe.model.User;
import br.com.luleke.investbe.service.auth.rule.UserAlreadyExistsRule;
import br.com.luleke.investbe.service.common.rule.AbstractRuleGroup;

@Component
public class SignupUserRuleGroup extends AbstractRuleGroup<User>{

	private final UserAlreadyExistsRule userAlreadyExistsRule;
	
	public SignupUserRuleGroup(UserAlreadyExistsRule userAlreadyExistsRule) {
		super();
		this.userAlreadyExistsRule = userAlreadyExistsRule;
		this.addRule(this.userAlreadyExistsRule);
	}
}
