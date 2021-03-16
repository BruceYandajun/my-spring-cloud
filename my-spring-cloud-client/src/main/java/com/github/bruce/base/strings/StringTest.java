package com.github.bruce.base.strings;

public class StringTest {
    public static void main(String[] args) {
        String a = "abc";
        String b = "abc";
        String c = new String("abc");
        String d = "a" + "b" + "c";
        System.out.println(a == b);
        System.out.println(a == c);
        System.out.println(a.hashCode());
        System.out.println(a.hashCode() == c.hashCode());
        System.out.println(a == d);
    }
}
