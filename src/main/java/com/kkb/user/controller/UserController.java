package com.kkb.user.controller;


import cn.hutool.bloomfilter.BitMapBloomFilter;
import cn.hutool.db.nosql.redis.RedisDS;
import com.kkb.user.entity.User;
import com.kkb.user.mapper.UserMapper;
import com.kkb.utils.FastJsonUtils;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 郁晓超
 * @since 2020-07-30
 */
@RestController
@RequestMapping("/login")
@AllArgsConstructor
public class UserController {

    private final UserMapper userMapper;

    @RequestMapping("/account")
    public String findListByUserId() {
        Integer list = userMapper.selectCount(null);
        return list+"";
    }

    @RequestMapping("/list")
    public String list() {
        List<User> list = userMapper.selectList(null);
        return FastJsonUtils.getBeanToJson(list);
    }

    @RequestMapping("/currentUser")
    public String currentUser() {
//        List<User> list = userMapper.selectList(null);
//        return FastJsonUtils.getBeanToJson(list);
        Map<String, Object> map = new HashMap<>();
        map.put("status", "ok");
        return FastJsonUtils.getBeanToJson(map);
    }

    @RequestMapping("/redis")
    public String redis() {
        Jedis jedis = RedisDS.create().getJedis();
        jedis.set("123", "123");
        return jedis.get("123");
    }

    public static void main(String[] args) {
        // 初始化
        BitMapBloomFilter filter = new BitMapBloomFilter(10);
        filter.add("123");
        filter.add("abc");
        filter.add("ddd");
    }
}



