package com.jalon.java8.stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * <p>
 *  flatmap等中间操作
 * </p>
 *
 * @author: JavaLover
 * @time: 2021/4/18
 */
public class FlatMapDemo {
    public static void main(String[] args) throws IOException {
        Stream<String> stream = Files.lines(Paths.get("test.txt"));
        List<String> list = stream.flatMap(str->Stream.of(str.split(" "))).collect(Collectors.toList());
        System.out.println(list);

        // map
        List<String> list2 = Arrays.asList(new People(new Cat2("dangdang")), new People(new Cat2("tangyuan")))
        .stream()
        .map(p->p.getCat())
        .map(c->c.getName())
        .collect(Collectors.toList());
        System.out.println(list2);

        // optional
        Optional<People> optional = Optional.of(new People(new Cat2("milu")));
        String str = optional.map(People::getCat).map(Cat2::getName).orElseGet(()->"no name");
        System.out.println(str);
        optional.flatMap(People::getCat2);
    }
}
class People{
    private Cat2 cat;

    @Override
    public String toString() {
        return "People{" +
                "cat=" + cat +
                '}';
    }

    public People(Cat2 cat) {
        this.cat = cat;
    }

    public Cat2 getCat() {
        return cat;
    }
    public Optional<Cat2> getCat2(){
        return Optional.of(getCat());
    }

    public void setCat(Cat2 cat) {
        this.cat = cat;
    }
}
class Cat2{
    private String name;

    @Override
    public String toString() {
        return "Cat2{" +
                "name='" + name + '\'' +
                '}';
    }

    public Cat2(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
