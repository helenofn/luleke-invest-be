package br.com.luleke.investbe;

import static org.assertj.core.api.Assertions.assertThat;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;

import jakarta.persistence.EntityManager;

@ActiveProfiles(value = "test")
@TestPropertySource(properties = {
        "spring.jpa.hibernate.ddl-auto=validate"
})
@SpringBootTest
public class LulekeInvestBeApplicationTests {

	@Autowired
	private DataSource dataSource;
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private EntityManager entityManager;
	
	@Test
	void contextLoads() {
		assertThat(dataSource).isNotNull();
        assertThat(jdbcTemplate).isNotNull();
        assertThat(entityManager).isNotNull();
	}

}
