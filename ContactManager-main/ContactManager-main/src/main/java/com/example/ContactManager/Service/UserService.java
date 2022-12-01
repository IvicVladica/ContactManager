package com.example.ContactManager.Service;

import com.example.ContactManager.Dto.UserDto;
import com.example.ContactManager.Model.User;
import com.example.ContactManager.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.UUID;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService (UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void insertUser (UserDto userDto) {
        User user = this.UserDtoToUser(userDto);
        user.setCreatedAt(LocalDate.now());
        userRepository.save(user);
    }

    public void updateUser (UserDto userDto, UUID id) {
        User myUser = userRepository.findByUserId(id);
        this.inputParametersToUserDto(userDto, myUser);
        userRepository.save(myUser);
    }

    public void inputParametersToUserDto (UserDto userDto, User myUser) {
        myUser.setUsername(userDto.getUsername());
        myUser.setPassword(userDto.getPassword());
        myUser.setEmail(userDto.getEmail());
        myUser.setUserType(userDto.getUserType());
    }

    public User UserDtoToUser (UserDto userDto) {
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setEmail(userDto.getEmail());
        user.setUserType(userDto.getUserType());
        return user;
    }
}
