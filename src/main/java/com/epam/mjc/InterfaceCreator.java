package com.epam.mjc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {
        return x -> {
            for(String x0 : x) {
                if(x0.matches("^[^A-Z]+")) return false;
            }

            return true;
        };
    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        return x -> {
            List<Integer> even = new ArrayList<>();
            for(int i : x) {
                if(i % 2==0) even.add(i);
            }
            x.addAll(even);
        };
    }

    public Supplier<List<String>> filterCollection(List<String> values) {
        return () -> {
            List<String> filtered = new ArrayList<>();
            for(String s: values) {
                if(s.matches("^[A-Z].*") && s.endsWith(".") && s.split(" ").length>3) {
                    filtered.add(s);
                }
            }
            return filtered;
        };
    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        return x -> {
            Map<String, Integer> mp = new HashMap<>();
            for(String s: x) {
                mp.put(s, s.length());
            }
            return mp;
        };
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        return (list1, list2) -> {
            ArrayList<Integer> concat = new ArrayList<>(list1);
            concat.addAll(list2);
            return concat;
        };
    }
}
