package com.project.gspd.repositories;

import com.project.gspd.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByLogin(String login);
}
