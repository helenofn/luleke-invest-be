package br.com.luleke.investbe.service.common.rule;

public abstract class AbstractRule<T> {

	public abstract void validate(T t);
}
