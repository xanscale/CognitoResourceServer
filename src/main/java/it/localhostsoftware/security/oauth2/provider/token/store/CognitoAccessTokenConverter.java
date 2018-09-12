package it.localhostsoftware.security.oauth2.provider.token.store;

import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class CognitoAccessTokenConverter extends JwtAccessTokenConverter {
	private static final String COGNITO_GROUPS = "cognito:groups";
	private static final String AUTHORITIES = "authorities";
	private static final String USERNAME = "username";
	private static final String USER_NAME = "user_name";

	@Override
	public OAuth2Authentication extractAuthentication(Map<String, ?> claims) {
		if (claims.containsKey(COGNITO_GROUPS))
			((Map<String, Object>) claims).put(AUTHORITIES, claims.get(COGNITO_GROUPS));
		if (claims.containsKey(USERNAME))
			((Map<String, Object>) claims).put(USER_NAME, claims.get(USERNAME));
		return super.extractAuthentication(claims);
	}
}
