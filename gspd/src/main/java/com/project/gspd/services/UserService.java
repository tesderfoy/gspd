package com.project.gspd.services;

import com.project.gspd.models.User;
import com.project.gspd.models.enums.Role;
import com.project.gspd.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    private  final PasswordEncoder passwordEncoder;

    public  boolean  createTeacher(User user ){
        String login = user.getLogin();
        if (userRepository.findByLogin(login)!= null) return false;
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.getRoles().add(Role.ROLE_TEACHER);
        log.info("Create teacher with login: {}", login);
        return true;
    }

    public  boolean  createStudent(User user ){
        String login = user.getLogin();
        if (userRepository.findByLogin(login)!= null) return false;
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.getRoles().add(Role.ROLE_STUDENT);
        log.info("Create student with login: {}", login);
        return true;
    }

}