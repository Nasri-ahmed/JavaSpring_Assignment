package com.demo.book.services;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.demo.book.models.LoginUser;
import com.demo.book.models.User;
import com.demo.book.repositories.UserRepository;



@Service
public class UserService {
    private final UserRepository userRepo;
    public UserService(UserRepository userRepo){ this.userRepo = userRepo; }

    // Register
    public User register(User newUser, BindingResult result){
        // unique email
        if(userRepo.findByEmail(newUser.getEmail()).isPresent()){
            result.rejectValue("email","Unique","This email is already registered");
        }
        // confirm password
        if(!newUser.getPassword().equals(newUser.getConfirmPassword())){
            result.rejectValue("confirmPassword","Match","Passwords must match");
        }
        if(result.hasErrors()) return null;

        // hash & save
        String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
        newUser.setPassword(hashed);
        return userRepo.save(newUser);
    }

    // Login
    public User login(LoginUser loginUser, BindingResult result){
        Optional<User> potential = userRepo.findByEmail(loginUser.getEmail());
        if(potential.isEmpty()){
            result.rejectValue("email","NotFound","Invalid credentials");
            return null;
        }
        User user = potential.get();
        if(!BCrypt.checkpw(loginUser.getPassword(), user.getPassword())){
            result.rejectValue("password","Invalid","Invalid credentials");
            return null;
        }
        return user;
    }

    public User findById(Long id){
        return userRepo.findById(id).orElse(null);
    }
}