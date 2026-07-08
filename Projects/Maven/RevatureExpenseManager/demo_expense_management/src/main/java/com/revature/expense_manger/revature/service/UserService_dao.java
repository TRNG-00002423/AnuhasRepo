package com.revature.service;

// import com.revature.dao.UserDao;
import com.revature.exception.UserNotFoundException;
import com.revature.exception.UserUnsuccessfullyAddedException;
import com.revature.model.User;

import java.sql.SQLException;
import java.util.List;

public class UserService {

    
    private UserRepository userRepository;
    // private UserDao userDao = new UserDao();
    
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

    // public List<User> getAllUsers() throws SQLException {
    //     return userDao.getAllUsers();
    // }

    // The purpose of the service layer is to provide exception throwing if a user does something wrong, etc.
    public void addUser(User user) throws SQLException {
        // Strip the leading and trailing whitespace from firstName and lastName
        user.setEmail(user.getEmail().strip());
        user.setPassword(user.getPassword().strip());
        user.setRole(user.getRole().strip());

        if (user.getEmail().length() == 0) {
            throw new IllegalArgumentException("Email cannot be blank");
        }

        if (user.getPassword().length() == 0) {
            throw new IllegalArgumentException("Password cannot be blank");
        }

        if (user.getRole().length() == 0) {
            throw new IllegalArgumentException("Role cannot be blank");
        }

        int recordsAdded = userDao.addUser(user); // 1 if a user was added, 0 if no user was added

        if (recordsAdded != 1) { // Throw an exception if a user was not successfully added
            throw new UserUnsuccessfullyAddedException("User could not be added");
        }
    }

    public User getUserById(String id) throws SQLException {
        User user = userDao.getUserById(id); // null if user does not exist

        if (user == null) {
            throw new UserNotFoundException("User with id " + id + " was not found");
        } else {
            return user;
        }
    }

    public User findByEmail(String email) throws SQLException {
        User user = userDao.getUserByEmail(email); // null if user does not exist

        if (user == null) {
            throw new UserNotFoundException("User with id " + id + " was not found");
        } else {
            return user;
        }
    }

}



