package com.revature.service;

// import com.revature.dao.UserDao;
import com.revature.exception.UserNotFoundException;
import com.revature.exception.UserUnsuccessfullyAddedException;
import com.revature.model.User;

import java.sql.SQLException;
import java.util.List;

public class UserService {

    
    private UserRepository userRepository;
    
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User persistUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUsers() throws SQLException {
        return userRepository.findAll();
    }

    public User getExistingUserById(String id) throws SQLException {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            return optionalUser.get();
        } else {
            return null;
        }
    }
    public User getExistingUserByEmail(User user) throws SQLException {
        String email = user.getEmail();
        User optionalUser = userRepository.findByEmail(email);
        if (optionalUser != null) {
            return optionalUser;
        } else {
            return null;
        }
    }    
    public User isValidEmail(User user) throws SQLException {
        String email = user.getEmail();
        String passwrodBeingChecked = user.getPassword();
        try {
            User optionalUser = userRepository.findByEmail(email);
            if (optionalUser != null) {
                    String currentPassword = optionalUser.getPassword();
                    if (currentPassword.equals(passwrodBeingChecked)) {
                        return optionalUser;
            }
        } else {
                return null;
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }      
    public Boolean isValidUserById(String userId) {
        try {
            Optional<User> optionalUser = userRepository.findById(userId);
            if (optionalUser.isPresent()) {
                        return true;
            } else {
                return false;
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }


}



