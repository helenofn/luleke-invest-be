package br.com.luleke.investbe.service.common.rule;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class AbstractRuleGroup <T>{

	private List<AbstractRule<T>> rules = new ArrayList<>();
	
	public void validateRules(T objToValidate) {
		for (AbstractRule<T> rule : rules) {
			rule.validate(objToValidate);
		}
	}
	
	public void addRule(AbstractRule<T> obj) {
		this.rules.add(obj);
	}
}
