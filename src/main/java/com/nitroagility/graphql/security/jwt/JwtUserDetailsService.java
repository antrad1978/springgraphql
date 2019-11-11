package com.nitroagility.graphql.security.jwt;


import com.nitroagility.graphql.dao.repository.UserRepository;
import com.nitroagility.graphql.dao.security.User;
import com.nitroagility.graphql.dao.security.UserFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class JwtUserDetailsService implements UserDetailsService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        logger.info("load user...");
        //Optional<User> user = userRepository.findByUsername(username);

        return getJwtUser(UserFactory.createUserDatailsSample());
        /*if (user.isPresent()) {
            logger.info("user:: {}", user.get().getUsername());
            return getJwtUser(user.get());
        } else {
            logger.info("user not found");
            //throw new UsernameNotFoundException(String.format("User not found with username '%s'.", username));
            return null;
        }*/
    }


    public JwtUser getJwtUser(User user) {
        return new JwtUser(
                user.getUsername(),
                user.getEmail(),
                user.getPassword(),
                List.of(new SimpleGrantedAuthority("USER")),
                true,
                null
        );
    }
}
