package searchEngine;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.EnumSet;
import java.util.Scanner;
import static java.nio.file.FileVisitOption.*;
public class SearchFile {
    public static void main(String[] args) throws IOException {
        while (true) {
            System.out.println("Enter THe File Name: ");
            final String input = (new Scanner(System.in)).nextLine();
            Path file = Paths.get("/JAVA_DSA/firstidea");
            try {
                SimpleFileVisitor<Path> pathVisitor = new SimpleFileVisitor<Path>() {

                    @Override
                    public FileVisitResult visitFile(Path file, BasicFileAttributes attr) {
                        if (file.getFileName().toString().contains(input)) {
                            System.out.println("File You Have Searched: " + file);
                            return FileVisitResult.CONTINUE;
                        } else {
                            return FileVisitResult.CONTINUE;
                        }
                    }

                    @Override
                    public FileVisitResult visitFileFailed(Path p, IOException e) {
                        System.err.println("Error: " + e + p);
                        return FileVisitResult.CONTINUE;
                    }
                };

                EnumSet<FileVisitOption> option = EnumSet.of(FOLLOW_LINKS);
                Files.walkFileTree(file, option, 50, pathVisitor);
            } catch (Exception e) {

            }
        }
    }
}
