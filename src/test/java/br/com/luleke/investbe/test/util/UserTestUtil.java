package br.com.luleke.investbe.test.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import br.com.luleke.investbe.model.User;
import br.com.luleke.investbe.model.UserRole;
import br.com.luleke.investbe.model.enums.UserRoleEnum;
import br.com.luleke.investbe.model.enums.UserStatusEnum;

public class UserTestUtil {

	public static User buildUser() {
		List<UserRole> roles = new ArrayList<>();
		roles.add(UserRoleEnum.PUBLIC.getModel());
		User user = User.builder()
				.name("Nome da pessoa")
				.email("a@mail.com")
				.password("H4569f!123")
				.status(UserStatusEnum.AGUARDANDO_CONFIRMACAO_EMAIL.getModel())
				.build();
		user.setRoles(roles);
		return user;
	}
	
	public static User buildUser2() {
		List<UserRole> roles = new ArrayList<>();
		roles.add(UserRoleEnum.PUBLIC.getModel());
		User user = User.builder()
				.name("Nome da pessoa 2")
				.email("a2@mail.com")
				.password("H4569f!123")
				.status(UserStatusEnum.AGUARDANDO_CONFIRMACAO_EMAIL.getModel())
				.build();
		user.setRoles(roles);
		return user;
	}
	
	public static User buildUserToReturn() {
		List<UserRole> roles = new ArrayList<>();
		roles.add(UserRoleEnum.PUBLIC.getModel());
		User user = User.builder()
				.id(1L)
				.name("Nome da pessoa 2")
				.email("a2@mail.com")
				.password("H4569f!123")
				.status(UserStatusEnum.AGUARDANDO_CONFIRMACAO_EMAIL.getModel())
				.build();
		user.setRoles(roles);
		return user;
	}
	
	public static void validateUserDataReturn(User user) {
		assertThat(user).isNotNull();
		assertThat(user.getEmail()).isNotNull();
		assertThat(user.getName()).isNotNull();
		assertThat(user.getPassword()).isNotNull();
		assertThat(user.getStatus()).isNotNull();
		assertThat(user.getStatus().getId()).isNotNull();
		assertThat(user.getStatus().getName()).isNotNull();
		assertThat(user.getRoles()).isNotEmpty();
		assertThat(user.getRoles().get(0)).isNotNull();
		assertThat(user.getRoles().get(0).getCode()).isNotNull();
		assertThat(user.getRoles().get(0).getName()).isNotNull();
	}
}
