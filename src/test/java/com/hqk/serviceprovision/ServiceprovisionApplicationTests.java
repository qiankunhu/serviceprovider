package com.hqk.serviceprovision;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;
import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceprovisionApplicationTests {

	/*@Autowired
	StringRedisTemplate stringRedisTemplate;

	@Autowired
	RedisTemplate redisTemplate;*/


	@Test
	public void contextLoads() throws Exception {
      //------------map 测试-------------
		/*Map<String,String> map=new HashMap<>();
		map.put("key1","value1");
		map.put("key2","value2");
		map.put("key3","value3");
		map.put("key4","value4");
		map.put("key5","value5");
		redisTemplate.opsForHash().putAll("map1",map);*/

		//获取整个 map
		/*Map<String,String> resultMap=redisTemplate.opsForHash().entries("map1");*/
        //获取map 里面的单个 key  的值
		/*String value=(String)redisTemplate.opsForHash().get("map1","key1");*/
        //获取 map 里面的 所有的 值   keys("map1") 获取所有的 key
		/*List<String> reslutMapList=redisTemplate.opsForHash().values("map1");

		Set<String> set=redisTemplate.opsForHash().keys("map1");

		System.out.println("map:"+resultMap);*/

		//------------list  测试-------------
		/*List<String> list1=new ArrayList<String>();
		list1.add("a1");
		list1.add("a2");
		list1.add("a3");
		redisTemplate.opsForList().leftPush("system",list1);
		//获取 list 的 值
		List<String> list2= (List<String>) redisTemplate.opsForList().leftPop("system");

		System.out.println("=="+list2);

		//判断 key 是否过期，过期返回 -2
		System.out.println("============"+redisTemplate.getExpire("hqk"));

		System.out.println(redisTemplate.opsForValue().get("name"));*/

	}



}
