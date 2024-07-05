package org.illumioTask.reader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class FilesReader {

    public List<String> readFile(String filePath) throws IOException {
        return Files.lines(Paths.get(filePath))
                .flatMap(line -> List.of(line.toLowerCase().split("\\W+")).stream())
                .collect(Collectors.toList());
    }

}
