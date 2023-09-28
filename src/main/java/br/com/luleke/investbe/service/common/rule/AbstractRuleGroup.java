package br.com.luleke.investbe.service.common.rule;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;
@Component
@Getter
@Setter
public abstract class AbstractRuleGroup <T>{

	protected T valueObject;
	protected List<AbstractRule<?>> rules; 
	
	protected void addRule(AbstractRule<?> rule) {
		if(null==this.rules)
			this.rules = new ArrayList<>();
		this.rules.add(rule);
	}
	
	public abstract AbstractRuleGroup<T> createRules();
	
	private void initialize(T value) {
		this.valueObject = value;
		createRules();
	}
	
	public void validateRules(T value) {
		initialize(value);
		for (AbstractRule<?> abstractRule : rules) {
			abstractRule.validate();
		}
	}
}
