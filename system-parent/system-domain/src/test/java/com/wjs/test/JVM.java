package com.wjs.test;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;


public class JVM {
	
	private static AtomicInteger it=new AtomicInteger();
    private static ConcurrentHashMap<String, String> map=new ConcurrentHashMap<>();
	
    
    
    public static void main(String[] args) throws Exception {
        int sum = 0;
        int count = 1000000;
        //warm up
        for (int i = 0; i < count ; i++) {
            sum += fn(i);
        }
 
        Thread.sleep(500);
 
        for (int i = 0; i < count ; i++) {
            sum += fn(i);
        }
        System.out.println(sum);
        System.in.read();
        
    }
   
    private static int fn(int age) {
        User user = new User();
        return  user.getAge();
    }
}
