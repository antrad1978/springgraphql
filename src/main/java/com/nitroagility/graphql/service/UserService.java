package com.nitroagility.graphql.service;


//import com.nitroagility.graphql.dao.repository.UserRepository;
import com.nitroagility.graphql.dao.security.InvalidCredentialsException;
import com.nitroagility.graphql.dao.security.User;
import com.nitroagility.graphql.dao.security.UserFactory;
import com.nitroagility.graphql.security.jwt.JwtTokenUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    //private UserRepository userRepository;

    //public UserService(UserRepository userRepository) {
    //    this.userRepository = userRepository;
    //}

    public String getSignin(String username,
                          String password) throws InvalidCredentialsException {
        //Optional<User> user = userRepository.findByUsername(username);
        User userInstance = new User();
        userInstance.setPassword(password);
        userInstance.setUsername(username);
        User testUser = UserFactory.createUserDatailsSample();
        Optional<User> user = Optional.of(userInstance);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        if(user.isPresent()) {
            if (user.get().getPassword().contentEquals(testUser.getPassword())) {
                logger.info("success...");
                return jwtTokenUtil.generateToken(user.get().getUsername());
            } else {
                logger.info("Invalid Credentials1");
                throw new InvalidCredentialsException("Invalid Credentials!");
            }
        }else{
            logger.info("Invalid Credentials2");
            throw new InvalidCredentialsException("Invalid Credentials!");
        }
    }

}
