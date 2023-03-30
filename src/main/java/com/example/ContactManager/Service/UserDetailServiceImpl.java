package com.example.ContactManager.Service;

import com.example.ContactManager.Dto.UserSecurity;
import com.example.ContactManager.Enums.UserType;
import com.example.ContactManager.Model.User;
import com.example.ContactManager.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;

    @Autowired
    public UserDetailServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        UserSecurity userSecurity = new UserSecurity();
        if (user == null) {
            throw new UsernameNotFoundException("User not found in database");
        }
        Collection<SimpleGrantedAuthority> authorities = UserType.valueOf(user.getUserType()).getGrantedAuthorities();
        userSecurity.setUsername(user.getUsername());
        userSecurity.setPassword(user.getPassword());
        userSecurity.setAuthorities(authorities);
        System.out.println(userSecurity);
        return userSecurity;
    }
}

