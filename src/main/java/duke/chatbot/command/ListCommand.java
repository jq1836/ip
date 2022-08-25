package duke.chatbot.command;

import duke.chatbot.data.task.Task;

import java.util.ArrayList;
import java.util.List;

import static duke.chatbot.common.Message.MESSAGE_EMPTY_LIST;
import static duke.chatbot.common.Message.MESSAGE_LIST;

/**
 * A command that prints the list of tasks in the application. Prints
 * an empty list message if the list is empty.
 */
public class ListCommand extends Command {
    /**
     * Returns an instance of CommandResult with a message that displays
     * the list of all tasks stored in the application.
     * @return The result after executing the command.
     */
    @Override
    public CommandResult execute() {
        List<String> message = new ArrayList<>();
        if (taskList.isEmpty()) {
            message.add(MESSAGE_EMPTY_LIST);
        } else {
            message.add(MESSAGE_LIST);
            for (int entry = 1; entry <= taskList.size(); entry++) {
                Task task = taskList.get(entry);
                message.add(entry + ". " + task.toString());
            }
        }
        return new CommandResult(message);
    }
}
