package client;

import commands.CommandData;
import commands.Command;
import exceptions.ExceptionTypes;
import exceptions.WrongInputException;
import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * CommandManager use HashMap of commands to operate with commands.
 * CommandManager can register and validate commandData and send it to the executor.
 */
public class CommandManager {

    private static LinkedHashMap<String, Command> commandMap = new LinkedHashMap<>();
    public static void register(Command command) {
        commandMap.put(command.getName(), command);
    }
    public static ResultData sendCommandToExecutor(CommandData commandData){
        if (commandData.command.isClientCommand()){
            return commandData.client.execute(commandData);
        }
        return commandData.labCollection.execute(commandData);
    }
    public static Command getCommand(String commandName) throws WrongInputException {
        Command command = commandMap.get(commandName);
        if (command == null) {
            throw new WrongInputException(ExceptionTypes.WRONG_COMMAND, commandName);
        }
        return command;
    }
    public static void validateCommand(CommandData commandData) throws WrongInputException, NumberFormatException{
        if (commandData == null){
            return;
        }
        Command command = commandData.command;
        if (command.hasIntDigit() && commandData.intDigit == null) {
            throw new WrongInputException(ExceptionTypes.NO_INTEGER, command.getName());
        }
        if (command.hasString() && commandData.string == null) {
            throw new WrongInputException(ExceptionTypes.NO_STRING, command.getName());
        }
        if (command.hasElement()) {
            if (commandData.client.scriptReading) {
                commandData.element = InputHandler.readElementFromScript(commandData.scriptScanner);
            } else {
                commandData.element = InputHandler.readInputElement();
            }
        }
    }
    public static HashMap<String, Command> getCommandMap(){
        return commandMap;
    }
}
