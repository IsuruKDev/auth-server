package io.microservices.auth.server.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class UserConfiguration extends GlobalAuthenticationConfigurerAdapter {

    PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

    @Override
    public void init(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("stluser")
                .password(encoder.encode("Stl@123456"))
                .roles("ADMIN","USER","MANAGER")
                .authorities("CAN_READ","CAN_WRITE","CAN_DELETE")
        .and()
                .withUser("sghuser")
                .password(encoder.encode("Sgh@123456"))
                .roles("USER")
                .authorities("CAN_READ","CAN_WRITE");
    }
}
