package com.eastspider.socketio.utils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class RedissonUtils {

	public static void main(String[] args) {
		Map<String, Set<String>> map = new HashMap<>();
		Set<String> set = map.get("a");
		if(set ==  null){
			set = new HashSet<>();
			map.put("a", set);
		}
		set.add("abc");
		
		System.out.println(map.get("a"));
	}

}
