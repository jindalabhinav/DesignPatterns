package Structural.Command;

// Step 2 - Create concrete commands
public class CreateUserCommand implements Command {
    @Override
    public boolean matches(String input) {
        if (getCommand(input).equals(Commands.REGISTER_USER_COMMAND)) {
            return true;
        }
        return false;
    }

    @Override
    public void execute(String input) {
        // Call UserController POST API
        // We could use Service classes directly, but using Controller methods, allows us to change this to am API application easily
    }
}
