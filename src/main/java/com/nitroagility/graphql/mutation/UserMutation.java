package com.nitroagility.graphql.mutation;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.nitroagility.graphql.dao.security.InvalidCredentialsException;
import com.nitroagility.graphql.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserMutation implements GraphQLMutationResolver {

    @Autowired
    private UserService userService;

    public String getSignin(final String username, final String password) throws InvalidCredentialsException {
        return this.userService.getSignin(username, password);
    }
}
