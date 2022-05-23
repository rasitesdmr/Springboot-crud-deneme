package com.example.springbootcruddeneme.service;

import com.example.springbootcruddeneme.exception.UserNotFoundException;
import com.example.springbootcruddeneme.exception.UserNotNullException;
import com.example.springbootcruddeneme.model.User;
import com.example.springbootcruddeneme.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class UserService {


    @Autowired
    UserRepository userRepository;

    public List<User> findAllUser(String firstName) {
        if (firstName == null){
            return userRepository.findAll();
        }else {
            return userRepository.findByFirstName(firstName);
        }

    }

    public User getUserById(Long userId) {
        return userRepository.findById(userId).
                orElseThrow(()-> new UserNotFoundException("id bulunamadı " + userId));
    }


    public User saveUser(User user) {

        if (user.getFirstName().isBlank() || user.getFirstName().isEmpty()){
            throw new UserNotNullException("FirstName Boş Bırakılamaz");
        }
        if (user.getLastName().isBlank() || user.getLastName().isEmpty()){
            throw new UserNotNullException("LastName Boş Bırakılmaz ");
        }
        if (user.getEmail().isBlank() || user.getEmail().isEmpty()){
            throw new UserNotNullException("Email Boş Bırakılamaz");
        }
        return userRepository.save(user);
    }

    public void updateUser(Long id , User newUser) {
        User oldUser = getUserById(id);
        oldUser.setLastName(newUser.getLastName());
        oldUser.setFirstName(newUser.getFirstName());
        oldUser.setEmail(newUser.getEmail());
        userRepository.save(oldUser);
    }

    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }


}
