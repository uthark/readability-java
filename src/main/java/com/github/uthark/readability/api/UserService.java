package com.github.uthark.readability.api;

import com.github.uthark.readability.model.User;

import java.io.IOException;

/**
 * @author Oleg Atamanenko
 * @since 1/23/13
 */
public interface UserService {

    User getCurrentUser() throws IOException;
}
