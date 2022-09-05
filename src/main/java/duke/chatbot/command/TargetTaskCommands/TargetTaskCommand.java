package duke.chatbot.command.TargetTaskCommands;

import static duke.chatbot.common.Message.MESSAGE_INVALID_ARGUMENT;
import static duke.chatbot.common.Message.MESSAGE_OUT_OF_LIST_RANGE;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import duke.chatbot.command.Command;
import duke.chatbot.command.CommandResult;
import duke.chatbot.data.exception.InvalidInputException;
import duke.chatbot.data.task.Task;

/**
 * Encapsulates a command whose execution is based on a task in the application task list.
 *
 * @author jq1836
 */
public abstract class TargetTaskCommand extends Command {
    /**
     * The pattern for single integer arguments.
     */
    protected static final Pattern SINGLE_INTEGER_ARGUMENT_FORMAT = Pattern.compile(
            "\\d+"
    );

    /**
     * The index of the task within the application task list.
     */
    protected int taskIndex;

    protected Task targetTask;

    private int supplyTaskIndex() throws InvalidInputException {
        Matcher matcher = SINGLE_INTEGER_ARGUMENT_FORMAT.matcher(arguments);
        if (!matcher.matches()) {
            throw new InvalidInputException(MESSAGE_INVALID_ARGUMENT);
        }
        return Integer.parseInt(matcher.group());
    }

    private Task retrieveTargetTask() throws InvalidInputException {
        if (!taskList.isInRange(taskIndex)) {
            throw new InvalidInputException(MESSAGE_OUT_OF_LIST_RANGE);
        }
        return taskList.get(taskIndex);
    }

    /**
     * Executes some actions on the target task.
     */
    protected abstract void executeOnTask();

    @Override
    public CommandResult execute() throws InvalidInputException {
        taskIndex = supplyTaskIndex();
        targetTask = retrieveTargetTask();
        executeOnTask();
        return super.execute();
    }
}
