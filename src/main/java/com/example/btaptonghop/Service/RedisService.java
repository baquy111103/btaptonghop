package com.example.btaptonghop.Service;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisService {
    private final RedisTemplate<String, Object> redisTemplate;

    public RedisService(RedisTemplate<String,Object> redisTemplate){
        this.redisTemplate = redisTemplate;
    }

    public void saveToCache(String key , Object value){
        redisTemplate.opsForValue().set(key , value);
    }

    public Object getFromCache(String key){
        return redisTemplate.opsForValue().get(key);
    }
}
