/*
package com.quiz.bitmesra;

import com.quiz.bitmesra.model.User;
import com.quiz.bitmesra.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/addUser")
    public void addUser(User user){
        userRepository.save(user);
    }

    @GetMapping("/getAllUser")
    public List<User> findAll(){
        return userRepository.findAll();
    }

    @GetMapping("/getUser")
    public User findUser(@RequestBody Long id){
        return userRepository.findById(id).get();
    }

    @PutMapping("/updateUser")
    public User update(@RequestBody User user){
        User user1 = userRepository.findById(user.getId()).get();

        user1.setName(user.getName());
        user1.setScore(user.getScore());
        user1.setEmailId(user.getEmailId());

        User updatedUser = userRepository.save(user1);

        return updatedUser;
    }
}
*/
