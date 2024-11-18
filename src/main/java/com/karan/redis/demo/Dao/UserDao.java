package com.karan.redis.demo.Dao;


import com.karan.redis.demo.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class UserDao {
    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    private static final String KEY= "USER";

    // save user
    public User save(User user){
        redisTemplate.opsForHash().put(KEY,user.getUserId(),user);
        return user;

    }
    // get user value by userId method
    public User get(String userId){
        return (User)redisTemplate.opsForHash().get(KEY,userId);
    }
    // get all users
    public Map<Object,Object>findAll() {
        return redisTemplate.opsForHash().entries(KEY);
    }
    // delete
    public void delete(String userId){
        redisTemplate.opsForHash().delete(KEY,userId);
    }
    // update
    public User update(String userId, User updatedUser){
       User existingUser= (User)redisTemplate.opsForHash().get(KEY,userId);
       if(existingUser!=null){
           existingUser.setName(updatedUser.getName());
           existingUser.setEmail(updatedUser.getEmail());
           existingUser.setPhone(updatedUser.getPhone());
           existingUser.setUserId(updatedUser.getUserId());
            redisTemplate.opsForHash().put(KEY,userId,existingUser);
            return existingUser;
       } else{
           throw new IllegalArgumentException("USER with ID"+userId + " does not exist");

       }
    }

}
