package io.microservices.auth.server.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;

@Configuration
public class AuthServiceConfiguration extends WebSecurityConfigurerAdapter {

    static final Logger LOGGER = LoggerFactory.getLogger(AuthServiceConfiguration.class);

    @Autowired
    UserDetailsService userDetailsService;

    @Bean
    public AuthenticationManager authManager()throws Exception{
        return super.authenticationManager();
    }

    @Bean
    public PasswordEncoder encoder(){
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.
                userDetailsService(userDetailsService)
                .passwordEncoder(encoder());
    }

    @Bean
    public TokenStore tokenStore() {
        LOGGER.info("Return jwt token store");

        return new JwtTokenStore(jwtTokenEnhancer());
    }

    @Bean
    protected JwtAccessTokenConverter jwtTokenEnhancer() {

        LOGGER.info("Get value to enhance jwt token");
	    KeyStoreKeyFactory keyStoreKeyFactory = new KeyStoreKeyFactory(new ClassPathResource("jwt.jks"), "babyio".toCharArray());
	    JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
	    converter.setKeyPair(keyStoreKeyFactory.getKeyPair("jwt"));
        //-- for the simple demo purpose, used the secret for signing.
        //-- for production, it is recommended to use public/private key pair
//        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
//        converter.setSigningKey("Demo-Key-1");

        return converter;
    }
}
