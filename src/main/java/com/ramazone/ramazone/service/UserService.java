package com.ramazone.ramazone.service;

import com.ramazone.ramazone.Exceptions.UserNotFoundException;
import com.ramazone.ramazone.UserInterface;
import com.ramazone.ramazone.dto.UserDTO;
import com.ramazone.ramazone.model.user.Role;
import com.ramazone.ramazone.repo.UserRepository;
import com.ramazone.ramazone.model.user.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements UserInterface {

    @Autowired
    private UserRepository repository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public User addUser(UserDTO dto) {
        User user = getUser(dto.getUsername());
        if (user != null) {
            return null;
        }
        user = new User();
        user = mapper.map(dto, User.class);
        user.setPassword(new BCryptPasswordEncoder().encode(dto.getPassword()));
        user.setRoles(Collections.singleton(dto.isAdminRole() ? Role.ADMIN : Role.USER));

        repository.save(user);
        return user;
    }

    @Override
    public User getUser(Integer id) {
        User user = repository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(Thread.currentThread(), "Invalid user Id: " + id));
        return user;
    }

    @Override
    public User getUser(String username) {
        User userFormDb = repository.findByUsername(username);
        try {
            UserDTO dto = mapper.map(userFormDb, UserDTO.class);
        } catch (Exception e) {}
        return userFormDb;
    }

    @Override
    public void updateUser(int id, User newUser) {
    }

    @Override
    public void deleteUser(int id) {
        repository.delete(getUser(id));
    }

    @Override
    public List<UserDTO> getAllUsers() {
        Iterable<User>users = repository.findAll();
        List<User> dtos = (List<User>) users;
        return dtos.stream()
                .map(user -> convertToDto(user))
                .collect(Collectors.toList());
    }

    private UserDTO convertToDto(User user) {
        UserDTO userDto = mapper.map(user, UserDTO.class);
        return userDto;
    }
}
