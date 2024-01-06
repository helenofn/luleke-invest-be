package br.com.luleke.investbe.config;

import static org.springframework.boot.autoconfigure.security.servlet.PathRequest.toH2Console;
import static org.springframework.security.web.util.matcher.AntPathRequestMatcher.antMatcher;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import br.com.luleke.investbe.config.filter.JwtAuthenticationFilter;
import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor
public class WebSecurityConfig {
	
	private final JwtAuthenticationFilter jwtAuthenticationFilter;
	
	@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return 
        		http
        			.headers((headers) -> headers.frameOptions((frameOptions) -> frameOptions.disable()))
			        .cors((cors) -> cors.disable())
			        .csrf((csrf) -> {
			        	csrf.disable();
			        	csrf.ignoringRequestMatchers(toH2Console());
			        })
		            .authorizeHttpRequests((authz) -> authz
		        		.requestMatchers(
		        			antMatcher("/actuator/**"),
		        			antMatcher("/swagger-ui/**"),
		        			antMatcher("/v3/api-docs"),
		        			antMatcher("/v3/api-docs/swagger-config"),
		        			antMatcher("/h2-console/**"),
		        			antMatcher("/v1/auth/**"),
		        			toH2Console()
		        		)
		        		.permitAll()
		        		.anyRequest()
		                .authenticated()
			            )
		            .exceptionHandling((exceptionHandling) -> exceptionHandling.authenticationEntryPoint(authenticationEntryPoint()))
		            .sessionManagement((session) -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
		            .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
		            .build();
    }
	
	@Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }
	
	@Bean
    public AuthenticationEntryPoint authenticationEntryPoint(){
        return new ForbiddenHandlerAuthEntryPointConfig();
    }
	
	/*
	@Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().requestMatchers(
        		new AntPathRequestMatcher("/auth/**"),
        		new AntPathRequestMatcher("/h2-console/**")
        );
    }
    */
	
	
	/*
	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http
        .cors()
        .and()
        .headers()
            .frameOptions()
            .sameOrigin()
            .httpStrictTransportSecurity()
            .includeSubDomains(true)
            .maxAgeInSeconds(31536000)
        .and()
        	.contentSecurityPolicy("script-src 'self' 'unsafe-inline' ");
		
        http.httpBasic().disable()
            .csrf().disable()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
            .authorizeRequests()
            .antMatchers(HttpMethod.OPTIONS).permitAll()
            .antMatchers("/h2-console/**","/auth/**").permitAll()
            .anyRequest().authenticated()
            .and()
            .apply(new JwtConfig(jwtTokenProvider));
    }
    */

}
