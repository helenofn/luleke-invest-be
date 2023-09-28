package br.com.luleke.investbe.service.common.rule;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class AbstractRule<T> {

	protected T valueObject;
	
	public AbstractRule<T> initialize(T value) {
		this.valueObject = value;
		return this;
	}
	
	public abstract void validate();
}
