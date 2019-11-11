package com.nitroagility.graphql.dao.security;

public class UserFactory {
    public static User createUserDatailsSample()
    {
        User sample = new User();
        sample.setUsername("user");
        sample.setPassword("pass");
        sample.setEmail("aaa@lll.org");
        return sample;
    }
}
