package com.jalon.basic.io;

import java.io.*;

/**
 * <p>
 *  文本IO：基于文本字符串的读写
 * </p>
 *
 * @author: jalon2015
 * @date: 2021/3/29 14:54
 */
public class TextIoDemo {
    public static void main(String[] args) throws IOException {
        String filename = "string.txt";
        writeString(filename, "hello world");
        String res = readString(filename);
        System.out.println(res);
    }

    public static void writeString(String filename, String content) throws IOException {
        FileWriter fileWriter = new FileWriter(filename);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(content);

        bufferedWriter.close();
    }

    public static String readString(String filename) throws IOException {
        FileReader fileReader = new FileReader(filename);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line = "";
        StringBuilder stringBuilder = new StringBuilder();
        while ((line=bufferedReader.readLine())!=null){
            stringBuilder.append(line);
        }
        bufferedReader.close();
        return stringBuilder.toString();
    }
}
