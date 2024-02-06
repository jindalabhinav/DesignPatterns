package Structural.Command;

// Step 2 - Create concrete commands
public class SettleUpCommand implements Command {
    @Override
    public boolean matches(String input) {
        if (getCommand(input).equals(Commands.SETTLE_UP_COMMAND)) {
            return true;
        }
        return false;
    }

    @Override
    public void execute(String input) {

    }
}
