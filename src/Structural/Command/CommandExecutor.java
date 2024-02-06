package Structural.Command;

import java.util.ArrayList;
import java.util.List;

public class CommandExecutor {
    private List<Command> commandList = new ArrayList<>();
    public void addCommand(Command command) {
        commandList.add(command);
    }

    public void removeCommand(Command command) {
        commandList.remove(command);
    }

    public void execute(String input) {
        for (Command command: commandList) {
            if (command.matches(input)) {
                command.execute(input);
            }
        }
    }
}
