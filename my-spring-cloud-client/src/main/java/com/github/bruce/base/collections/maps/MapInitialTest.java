package com.github.bruce.base.collections.maps;

import java.util.HashMap;
import java.util.Map;

public class MapInitialTest {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<Integer, String>() {{
            put(1, "abc");
            put(2, "def");
        }};
        System.out.println(map);
    }
}
