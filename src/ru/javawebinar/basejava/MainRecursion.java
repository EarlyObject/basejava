package ru.javawebinar.basejava;

import java.io.File;
import java.io.IOException;

public class MainRecursion {
    public static void main(String[] args) throws IOException {
        File file = new File("/Users/ardaksydyknazar/Projects/basejava");
        File[] rootFolder = file.listFiles();
        recursivePrint(rootFolder, 0);
    }

    public static void recursivePrint(File[] rootFolder, int level) {
        for (File file : rootFolder) {
            for (int i = 0; i < level; i++)
                System.out.print("\t");
            if (file.isFile()) {
                System.out.println(file.getName());

            } else if (file.isDirectory()) {
                System.out.println("[" + file.getName() + "]");
                recursivePrint(file.listFiles(), level + 1);
            }
        }
    }
}