package br.com.luleke.investbe.service.rule;

import org.springframework.stereotype.Component;

import br.com.luleke.investbe.exception.AccountEmailAlreadyExistsException;
import br.com.luleke.investbe.model.respository.UserRepository;
import br.com.luleke.investbe.service.common.rule.AbstractRule;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class AccountEmailAlreadyExistsRule extends AbstractRule<String>{

	private final UserRepository userRepository;

	@Override
	public void validate() {
		if (this.userRepository.findByEmail(this.valueObject).isPresent())
		  throw new AccountEmailAlreadyExistsException();
	}
}
