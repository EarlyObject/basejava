package ru.javawebinar.basejava;

import java.io.File;
import java.util.Objects;

public class MainRecursion {
    public static void main(String[] args) {
        File file = new File("/Users/ardaksydyknazar/Projects/basejava");
        File[] rootFolder = file.listFiles();
        recursivePrint(Objects.requireNonNull(rootFolder), "");
    }

    public static void recursivePrint(File[] rootFolder, String tab) {
        for (File file : rootFolder) {
            if (file.isFile()) {
                System.out.println(tab + file.getName());
            } else if (file.isDirectory()) {
                System.out.println(tab + "[" + file.getName() + "]");
                recursivePrint(Objects.requireNonNull(file.listFiles()), tab + " ");
            }
        }
    }
}