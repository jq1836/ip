package duke.chatbot.command;

import static duke.chatbot.common.Message.MESSAGE_DELETED;

import java.util.List;

import duke.chatbot.data.task.Task;
import duke.chatbot.util.MessageBuilder;

/**
 * A command that deletes the targeted task from the list of Task in the application. The targeted task is chosen by
 * an argument string with an integer in the argument list.
 *
 * @author jq1836
 */
public class DeleteCommand extends Command {
    /**
     * The command word to invoke this command
     */
    public static final String COMMAND_WORD = "delete";

    public DeleteCommand(List<String> arguments) {
        this.arguments = arguments;
    }

    /**
     * Returns an instance of {@link CommandResult} with a message that displays the task that was deleted.
     *
     * @return The result after executing the command.
     */
    @Override
    public CommandResult execute() {
        MessageBuilder message = new MessageBuilder();
        int entryNo = Integer.parseInt(arguments.get(0));
        Task task = taskList.remove(entryNo);

        message.addLines(MESSAGE_DELETED, task.toString());
        return new CommandResult(message.toString());
    }
}
