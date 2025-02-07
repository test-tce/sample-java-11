package org.practices;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

public class UpgradeTool {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: java -jar upgrade-cli.jar <project-path>");
            return;
        }

        String projectPath = args[0];
        Path path = Paths.get(projectPath);
        if (!Files.exists(path)) {
            System.out.println("Error: Provided path does not exist.");
            return;
        }

        System.out.println("Checking project for JDK 11 compatibility...");
        checkForDeprecatedFeatures(path);
    }

    private static void checkForDeprecatedFeatures(Path projectPath) {
        // Example of JDK 11 feature: Optional.isEmpty(), superseded in JDK 17 by pattern matching for switch
        Optional<String> optionalValue = Optional.of("JDK 11 Example");
        if (optionalValue.isEmpty()) {
            System.out.println("Optional is empty");
        } else {
            System.out.println("Optional contains: " + optionalValue.get());
        }

        System.out.println("Scanning source files...");
        // Logic for detecting outdated APIs will go here
        System.out.println("Upgrade suggestions:");
        System.out.println("- Replace 'java.util.Optional.isEmpty()' check with pattern matching for switch in JDK 17.");
        System.out.println("- Replace 'java.util.Stream.collect(toList())' with 'toList()'.");
        System.out.println("- Use 'java.nio.file.Files.mismatch()' for file comparison.");
    }
}
