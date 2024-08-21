package com.example.btaptonghop.Controller;

import com.example.btaptonghop.Model.MyEntity;
import com.example.btaptonghop.Model.MyMongoEntity;
import com.example.btaptonghop.Repository.MyEntityRepository;
import com.example.btaptonghop.Repository.MyMongoRepository;
import com.example.btaptonghop.Service.RabbitMQService;
import com.example.btaptonghop.Service.RedisService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class MyController {
    private final MyEntityRepository myEntityRepository;
    private final MyMongoRepository myMongoRepository;
    private final RedisService redisService;
    private final RabbitMQService rabbitMQService;

    public MyController(MyEntityRepository myEntityRepository, MyMongoRepository myMongoRepository, RedisService redisService, RabbitMQService rabbitMQService) {
        this.myEntityRepository = myEntityRepository;
        this.myMongoRepository = myMongoRepository;
        this.redisService = redisService;
        this.rabbitMQService = rabbitMQService;
    }
    @PostMapping("/save/mysql")
    public MyEntity saveToMySQL(@RequestBody MyEntity myEntity) {
        return myEntityRepository.save(myEntity);
    }

    @PostMapping("/save/mongo")
    public MyMongoEntity saveToMongo(@RequestBody MyMongoEntity myMongoEntity) {
        return myMongoRepository.save(myMongoEntity);
    }

    @PostMapping("/cache")
    public void saveToCache(@RequestParam String key, @RequestParam String value) {
        redisService.saveToCache(key, value);
    }

    @PostMapping("/message")
    public void sendMessage(@RequestParam String message) {
        rabbitMQService.sendMessage(message);
    }
}
