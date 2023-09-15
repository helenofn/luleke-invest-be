package br.com.luleke.investbe;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;

@ActiveProfiles(value = "test")
@TestPropertySource(properties = {
        "spring.jpa.hibernate.ddl-auto=validate"
})
@SpringBootTest
public class AbstractLulekeInvestBeTest {

}
