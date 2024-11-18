package com.karan.redis.demo.Controller;

import com.karan.redis.demo.Dao.UserDao;
import com.karan.redis.demo.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserDao userDao;
    @PostMapping
    public User createUser(@RequestBody User user){
        user.setUserId(UUID.randomUUID().toString());
        return userDao.save(user);

    }
    @GetMapping("/{userId}")
    public User getUser(@PathVariable ("userId") String userId){
        return userDao.get(userId);
    }
    // find all users
    @GetMapping
    public Map<Object,Object>findAll(){
        return userDao.findAll();
    }
    @DeleteMapping
    public void deleteById(@PathVariable String userId){
        userDao.delete(userId);
    }
    @PutMapping("/{userId}")
   public User update(@PathVariable String userId, @RequestBody User updatedUser){
        return userDao.update(userId,updatedUser);
    }
}
