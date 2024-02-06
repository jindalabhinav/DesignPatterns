# Command Design Pattern

This is a pattern using which we create CLI applications.

Let's say we have 3 commands for a Splitwise like application:

- CREATE USER
- SETTLE
- ADD EXPENSE

## Steps

1. Create a Parent `Command` class
   1. The ideal way how this class would work is that we give it a String, and it tells us which Command to execute.
   2. `String --> Command`
2. Create an interface for the Command class

    ```java
      interface Command {
        boolean matches(String command); // this will check whether the incoming command matches with the implementing class` command
        void execute(input); // if the command matches, then this method implementation is called to do the work
      }
    ```

    We'll have multiple Command classes implementing this interface, like `CreateUserCommand` and `SettleUpCommand`.

3. Now we'll have a `CommandExecutor`. It will:
   1. Run `match()` on all commands
   2. Run `execute()` on the matched command
   3. Register commands
   4. Deregister commands

   The above 2 can be implemented using the Registry Pattern.

  ```java
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
  ```

4. Now to execute our CLI, we'll call using the `main()` method.

  ```java
    // add commands to the commands registry in CommandExecutor
    main() {
      while(true) {
        sout("Enter input: ");
        String input = scanner.nextLine();
        commandExecutor.execute(input);
      }
    }
  ```

  Now since this is about the structure of a codebase, hence it is a *Structural Design Pattern*.
