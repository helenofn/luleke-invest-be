package br.com.luleke.investbe.service.auth;

import org.springframework.stereotype.Service;

import br.com.luleke.investbe.model.User;
import br.com.luleke.investbe.model.enums.UserRoleEnum;
import br.com.luleke.investbe.model.enums.UserStatusEnum;
import br.com.luleke.investbe.model.respository.UserRepository;
import br.com.luleke.investbe.service.rule.group.SignupUserRuleGroup;
import br.com.luleke.investbe.util.GenerateHashPasswordUtil;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Service
@RequiredArgsConstructor
public class SignUpService {
	
	private final UserRepository userRepository;
	private final SignupUserRuleGroup signupUserRuleGroup;
	private User user;
	
	private void mount(String name, String email, String pass) {
		this.user = new User();
		this.user.setName(name);
		this.user.setEmail(email);
		this.user.setPassword(pass);
	}
	
	private void validate() {
		signupUserRuleGroup.validateRules(this.user);
	}
	
	public User execute(String name, String email, String pass) {
		mount(name, email, pass);
		validate();
		this.user.setPassword(GenerateHashPasswordUtil.getHashFromPassword(pass));
		this.user.setStatus(UserStatusEnum.AGUARDANDO_CONFIRMACAO_EMAIL.getModel());
		this.user.getRoles().add(UserRoleEnum.COMMON.getModel());
		
		this.user = userRepository.save(this.user);
		return this.user;
	}
	
	
}
