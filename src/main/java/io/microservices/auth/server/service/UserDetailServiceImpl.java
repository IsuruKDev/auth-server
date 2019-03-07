package io.microservices.auth.server.service;

import io.microservices.auth.server.model.AuthUserDetail;
import io.microservices.auth.server.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("userDetailsService")
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails userDetails = new AuthUserDetail(userRepository.findByUsername(username).orElseThrow(
                ()-> new UsernameNotFoundException("username not found in the database")));

        new AccountStatusUserDetailsChecker().check(userDetails);
        return userDetails;
    }
}
