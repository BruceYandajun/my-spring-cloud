package com.github.bruce.base.collections.maps;

import java.util.HashMap;
import java.util.Map;

public class MapInitialTest {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<String, Integer>() {{
            put("a", 1);
            put("b", 2);
        }};
        System.out.println(map);
    }
}
