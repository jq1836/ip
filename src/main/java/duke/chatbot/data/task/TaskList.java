package duke.chatbot.data.task;

import java.util.ArrayList;

import duke.chatbot.util.MessageBuilder;

/**
 * A list of tasks.
 *
 * @author jq1836
 */
public class TaskList extends ArrayList<Task> {
    /**
     * Returns an instance of {@link Task} that corresponds to the entry number given.
     *
     * @param entry The index of the element to return, with index 1 corresponding to the first element.
     * @return A task that corresponds to the entry number given.
     */
    @Override
    public Task get(int entry) {
        if (!this.isInRange(entry)) {
            return null;
        }
        return super.get(entry - 1);
    }

    /**
     * Returns an instance of {@link Task} that corresponds to the entry number given. Removes the task from the list
     * in the process.
     *
     * @param entry The index of the element to be removed, with index 1 corresponding to the first element.
     * @return A task that corresponds to the entry number given.
     */
    @Override
    public Task remove(int entry) {
        if (this.isInRange(entry)) {
            return super.remove(entry - 1);
        }
        return null;
    }

    /**
     * Returns true if the entry number corresponds to an entry in the list.
     *
     * @param entry The index to be compared with the last index.
     * @return A boolean describing whether the entry number is in range.
     */
    public boolean isInRange(int entry) {
        return entry > 0 && entry <= this.size();
    }

    @Override
    public String toString() {
        MessageBuilder messageBuilder = new MessageBuilder();
        for (Integer entry = 1; entry < this.size() + 1; entry++) {
            messageBuilder.buildLine("\t", entry.toString(), ".", this.get(entry).toString());
        }
        return messageBuilder.toString();
    }

    /**
     * Returns an instance of {@link TaskList} that contains the tasks that corresponds to the date argument string.
     *
     * @param date The date to compare the tasks in the list with.
     * @return A TaskList that contains the tasks that corresponds to the date argument string.
     */
    public TaskList filterTaskListByDate(String date) {
        TaskList result = new TaskList();
        for (Task task : this) {
            if (task instanceof TimedTask) {
                TimedTask timedTask = (TimedTask) task;
                if (timedTask.hasMatchingDate(date)) {
                    result.add(timedTask);
                }
            }
        }
        return result;
    }

    /**
     * Returns a TaskList that contains the tasks have descriptions containing a substring that is the same as the
     * argument string.
     *
     * @param substring The substring to look for in the task description.
     * @return A TaskList that contains the tasks with substrings that are the same as the argument string.
     */
    public TaskList filterTaskListBySubstring(String substring) {
        TaskList result = new TaskList();
        for (Task task : this) {
            if (task.hasSubstring(substring)) {
                result.add(task);
            }
        }
        return result;
    }

    /**
     * Returns a string that encodes all the tasks.
     *
     * @return A string that encodes all the tasks.
     */
    public String encodeAll() {
        String result = "";

        for (int entry = 1; entry < this.size() + 1; entry++) {
            result += this.get(entry).encode() + "\n";
        }
        return result;
    }
}
