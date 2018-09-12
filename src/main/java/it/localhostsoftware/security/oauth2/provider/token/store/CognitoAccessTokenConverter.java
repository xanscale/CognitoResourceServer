package it.localhostsoftware.security.oauth2.provider.token.store;

import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class CognitoAccessTokenConverter extends JwtAccessTokenConverter {
	@Override
	public OAuth2Authentication extractAuthentication(Map<String, ?> claims) {
	/*	ArrayList<String> groupList = ((ArrayList<String>) claims.get("cognito:groups"));
		if (groupList == null)
			groupList = new ArrayList<>();
		String[] groups = groupList.toArray(new String[0]);
		OAuth2Authentication authentication = super.extractAuthentication(claims);
		OAuth2Request old = authentication.getOAuth2Request();
		OAuth2Request newRequest = new OAuth2Request(old.getRequestParameters(), old.getClientId(), AuthorityUtils.createAuthorityList(groups),
				true, old.getScope(), old.getResourceIds(), null, null, null);
		return new OAuth2Authentication(newRequest, authentication.getUserAuthentication());*/
		((Map<String, Object>) claims).put("authorities", claims.get("cognito:groups"));
		((Map<String, Object>) claims).put("user_name", claims.get("username"));
		return super.extractAuthentication(claims);
	}
}
