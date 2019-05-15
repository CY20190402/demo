package com.cy.demo.util.redis;

import redis.clients.jedis.Jedis;

public class RedisTest {
    public static void main(String[] args) {
        // 连接本地的 Redis 服务
        Jedis jedis = new Jedis("203.195.174.113",6379); // 默认端口
        jedis.auth("123456"); // 指定密码
        // 设置 redis 字符串数据
//        jedis.set("redis", "Redis 1");
        // 获取存储的数据并输出
        System.out.println("redis : " + jedis.get("redis"));
    }
}
