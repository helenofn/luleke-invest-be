package br.com.luleke.investbe.service.auth.rule;

import org.springframework.stereotype.Component;

import br.com.luleke.investbe.model.User;
import br.com.luleke.investbe.model.respository.UserRepository;
import br.com.luleke.investbe.service.auth.rule.exception.UserAlreadyExistsException;
import br.com.luleke.investbe.service.common.rule.AbstractRule;

@Component
public class UserAlreadyExistsRule extends AbstractRule<User>{

	private final UserRepository userRepository;
	
	public UserAlreadyExistsRule(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public void validate(User user) {
		User userExistente = this.userRepository.findByEmail(user.getEmail()).orElse(null);
		if (userExistente != null) {
			throw new UserAlreadyExistsException();
		}
	}
}
