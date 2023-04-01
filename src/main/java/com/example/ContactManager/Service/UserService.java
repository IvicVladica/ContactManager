package com.example.ContactManager.Service;

import com.example.ContactManager.Dto.UserDto;
import com.example.ContactManager.Exceptions.EmailValidationException;
import com.example.ContactManager.Exceptions.NoSuchIdExistsException;
import com.example.ContactManager.Exceptions.UserAlreadyExistsException;
import com.example.ContactManager.Model.User;
import com.example.ContactManager.Repository.UserRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.UUID;
import java.util.regex.Pattern;

import static com.example.ContactManager.Security.SecurityConstants.SECRET;

@Service
public class UserService  {

    private UserRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserService (UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public User findUser (String username) {
        return userRepository.findByUsername(username);
    }

    public void insertUser (UserDto userDto) {
        User user = this.UserDtoToUser(userDto);
        String regex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        if(userRepository.findByEmail(user.getEmail())!= null) {
            throw new UserAlreadyExistsException();
        }
        if(!Pattern.matches(regex, user.getEmail())) {
            throw new EmailValidationException();
        }
        else {
            user.setCreatedAt(LocalDate.now());
            userRepository.save(user);
        }
    }

    public void updateUser (UserDto userDto, UUID id) {
        if (userRepository.findByUserId(id) == null) {
            throw new NoSuchIdExistsException();
        }String regex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
//        if(userRepository.findByEmail(userDto.getEmail())!= null) {
//            throw new UserAlreadyExistsException();
//        }
        if(!Pattern.matches(regex, userDto.getEmail())) {
            throw new EmailValidationException();
        }
        User myUser = userRepository.findByUserId(id);
        this.inputParametersToUserDto(userDto, myUser);
        userRepository.save(myUser);
    }

    public void inputParametersToUserDto (UserDto userDto, User myUser) {
        myUser.setUsername(userDto.getUsername());
        myUser.setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
        myUser.setEmail(userDto.getEmail());
        myUser.setUserType(userDto.getUserType());
    }

    public User UserDtoToUser (UserDto userDto) {
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
        user.setEmail(userDto.getEmail());
        user.setUserType(userDto.getUserType());
        return user;
    }

    public UUID getUserIdFromToken (String header) {
        String token = header.replace("Bearer ", "");
        Jws<Claims> claimsJws = Jwts.parser()
                .setSigningKey(Keys.hmacShaKeyFor(SECRET.getBytes()))
                .parseClaimsJws(token);

        Claims body = claimsJws.getBody();
        User user = userRepository.findByUsername(body.getSubject());
        UUID id = user.getUserId();
        return id;
    }

}
