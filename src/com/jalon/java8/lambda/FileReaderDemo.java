package com.jalon.java8.lambda;

import java.io.*;
import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * <p>
 *  文件读写：自定义个函数式接口，实现行为参数化
 * </p>
 *
 * @author: JavaLover
 * @date: 2021/4/14 15:43
 */
public class FileReaderDemo {
    public static void main(String[] args) throws IOException {
        FileReadInterface fileReadInterface = reader -> reader.readLine();
        FileReadInterface fileReadInterface2 = reader -> reader.readLine() + reader.readLine();

        System.out.println(processFile());
        System.out.println(processFile(BufferedReader::readLine));
    }
    public static String processFile(FileReadInterface fileReadInterface) throws IOException {
        try( BufferedReader bufferedReader =
                 new BufferedReader(new FileReader("D:\\CompanyProject\\JavaProject\\JavaBasicDemo\\test.txt"))){
            return fileReadInterface.process(bufferedReader);
        }
    }
    public static String processFile() throws IOException {
        // Java7新增的语法，try(){}，可自动关闭资源，减少了代码的臃肿
        try( BufferedReader bufferedReader =
                new BufferedReader(new  FileReader("D:\\JavaProject\\JavaBasicDemo\\test.txt"))){
            return bufferedReader.readLine();
        }
    }
}
@FunctionalInterface
interface FileReadInterface{
    String process(BufferedReader reader) throws IOException;
}

