package Structural.Command;

import java.util.Arrays;
import java.util.List;

// Step 1 - Create a parewnt command interface
public interface Command {
    boolean matches(String input);
    void execute(String input);
    default String getCommand(String input) {
        // input - register tantia email password
        // Tokenize it - take a string and divide into smaller tokens
        List<String> tokens = Arrays.stream(input.split(" ")).toList();

        // To check if the first token is the same as command name
        return tokens.get(0);
    }
}
