package com.aoc2022.fsh;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Uppgift1a {
    public static int sum_numbers(List<String> lines) {
        int[] sums = new int[lines.size()];
        int index = 0;
        for (String line : lines) {
            if (line.equals("") || line.equals("\n")) {
                index += 1;
            } else {
                sums[index] += Integer.parseInt(line);
            }
        }
        return Arrays.stream(sums).sum();
    }

    public static List<Integer> solve(List<String> data) {
        List<Integer> calories = new ArrayList<>();
        List<String> tmp = new ArrayList<>();
        for (String str: data) {
            if (str.equals("") || str.equals("\n")) {
                // System.out.println(tmp + " " + sum_numbers(tmp));
                calories.add(sum_numbers(tmp));
                tmp.clear();
            } else {
                tmp.add(str);
            }
        }
        return calories;
    }

    public static void main(String[] args) {

        List<String> testdata = new ArrayList<>();
        testdata.add("1000");
        testdata.add("2000");
        testdata.add("3000");
        testdata.add("");
        testdata.add("4000");
        testdata.add("");
        testdata.add("5000");
        testdata.add("6000");
        testdata.add("");
        testdata.add("7000");
        testdata.add("8000");
        testdata.add("9000");
        testdata.add("");
        testdata.add("10000");

        String filename = "src/main/resources/input-1.txt";

        try (Stream<String> lines = Files.lines(Paths.get(filename))) {

            List<String> data = lines.collect(Collectors.toList());

            List<Integer> calories = solve(data);
            System.out.println(calories.stream().max(Integer::compare).orElse(0));

            List<Integer> calories2 = solve(testdata);
            System.out.println(calories2.stream().max(Integer::compare).orElse(0));

            /*
            // Stupid solution that joins all items into one large String
            // System.out.println(data.stream().collect(Collectors.joining("\n")).split("\n{2}"));

            Arrays.stream(data.stream().collect(Collectors.joining("\n")).split("\n{2}"))
                    .map(s -> Arrays.stream(s.split("\n")).collect(Collectors.toList()))
                    .collect(Collectors.toList())
                    .forEach(System.out::println);

            data.stream().forEach(System.out::println);
*/

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}