package com.ramazone.ramazone;

import com.ramazone.ramazone.dto.UserDTO;
import com.ramazone.ramazone.model.user.User;

import java.util.List;

public interface UserInterface {

    User addUser(UserDTO user);

    User getUser(Integer id);

    User getUser(String username);

    void updateUser(int id, User newUser);

    void deleteUser(int id);

    List<UserDTO> getAllUsers();
}
