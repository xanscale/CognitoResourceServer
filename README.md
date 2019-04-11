# CognitoResourceServer

This library just extends `spring-security-oauth2-autoconfigure` to covert Cognito custom claims into standard Spring claims. Refer to https://docs.spring.io/spring-security-oauth2-boot/docs/current-SNAPSHOT/reference/htmlsingle/#boot-features-security-oauth2-resource-server and just use `CognitoResourceServerConfigurerAdapter` instead of `ResourceServerConfigurerAdapter`

# pom.xml

```xml
<repositories>
	<repository>
	    <id>jitpack.io</id>
	    <url>https://jitpack.io</url>
	</repository>
</repositories>
<dependency>
    <groupId>com.github.xanscale</groupId>
    <artifactId>CognitoResourceServer</artifactId>
    <version>-SNAPSHOT</version>
</dependency>
```
# application.properties

> security.oauth2.resource.jwk.key-set-uri = https://cognito-idp.{REGION}.amazonaws.com/{POOL_ID}/.well-known/jwks.json

# CognitoResourceServerConfigurerAdapter

```java
@SpringBootApplication
@EnableResourceServer
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ExampleCognitoResourceServerConfigurerAdapter extends CognitoResourceServerConfigurerAdapter {
	protected ExampleCognitoResourceServerConfigurerAdapter(ResourceServerProperties resource) {
		super(resource);
	}

	public static void main(String[] args) {
		SpringApplication.run(ExampleCognitoResourceServerConfigurerAdapter.class, args);
	}
}
```
