package com.github.bruce.base.collections.sets;

import java.util.HashSet;
import java.util.Set;

public class HashSetTest {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        System.out.println(set.add(null));
        System.out.println(set.add(null));
        System.out.println(set.contains(null));
        System.out.println(set);

        Set<User> users = new HashSet<>();
        User user1 = new User(10);
        users.add(user1);

        User user2 = new User(10);
//        users.add(user2);
        System.out.println(users.contains(user2));
    }
    static class User {
        public int age;
        public User(int age) {
            this.age = age;
        }
    }
}
