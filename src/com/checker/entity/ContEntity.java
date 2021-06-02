package com.checker.entity;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ContEntity {
    private String[] arr;
    private List<String> list;
    private Map<String, String> map;


    public void setArr(String[] arr) {
        this.arr = arr;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    @Override
    public String toString() {
        return "ContEntity{" +
                "arr=" + Arrays.toString(arr) +
                ", list=" + list +
                ", map=" + map +
                '}';
    }
}
