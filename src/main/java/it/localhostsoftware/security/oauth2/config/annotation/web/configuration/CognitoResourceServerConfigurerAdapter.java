package it.localhostsoftware.security.oauth2.config.annotation.web.configuration;

import org.springframework.boot.autoconfigure.security.oauth2.resource.ResourceServerProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.jwk.JwkTokenStore;

import java.util.Collections;

import it.localhostsoftware.security.oauth2.provider.token.store.CognitoAccessTokenConverter;

public class CognitoResourceServerConfigurerAdapter extends ResourceServerConfigurerAdapter {
	private final ResourceServerProperties resource;

	public CognitoResourceServerConfigurerAdapter(ResourceServerProperties resource) {
		this.resource = resource;
	}

	@Bean
	public TokenStore jwkTokenStore() {
		return new JwkTokenStore(Collections.singletonList(resource.getJwk().getKeySetUri()), new CognitoAccessTokenConverter(), null);
	}
}
