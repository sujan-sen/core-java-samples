package org.example.utils;

import com.fasterxml.jackson.databind.JsonNode;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.*;

public class FileExtractor {

    public void extractSingleFileFromArchive(){
      URL resource = this.getClass().getResource("/project.zip");
        try {
            Path zipFilePath = Path.of(resource.toURI());
            String fileName = "project.yaml";
            File file = new File("/Users/sujan/Downloads/test_file");
            Path destinationPath = file.toPath();
            extractFile(zipFilePath,fileName,destinationPath);
            System.out.println("Extraction complete");
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    private static void extractFile(Path zipFile, String fileName, Path outputFile) throws IOException {
        // Wrap the file system in a try-with-resources statement
        // to auto-close it when finished and prevent a memory leak
        try (FileSystem fileSystem = FileSystems.newFileSystem(zipFile, null)) {
            Path fileToExtract = fileSystem.getPath("/project/"+fileName);
            Files.copy(fileToExtract, outputFile);
        }
    }

}
