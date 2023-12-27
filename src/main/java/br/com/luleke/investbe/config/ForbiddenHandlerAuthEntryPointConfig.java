package br.com.luleke.investbe.config;

import java.io.IOException;
import java.time.LocalDateTime;

import org.json.JSONObject;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import br.com.luleke.investbe.config.enums.MessagesEnum;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ForbiddenHandlerAuthEntryPointConfig implements AuthenticationEntryPoint{

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
		
		
		response.setContentType("application/json;charset=UTF-8");
		response.setStatus(403);
		response.getWriter().write(new JSONObject()
                .put("timestamp", LocalDateTime.now())
                .put("status", 403)
                .put("code", MessagesEnum.USER_UNAUTHORIZED.getCodeMessage())
                .put("msg", MessagesEnum.USER_UNAUTHORIZED.getMessage())
                .toString());
		
	}

}
