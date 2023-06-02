package org.example;

import org.example.utils.FileExtractor;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        FileExtractor fileExtractor = new FileExtractor();
        fileExtractor.extractSingleFileFromArchive();
    }
}