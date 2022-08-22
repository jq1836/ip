package task;

import java.util.ArrayList;

public class TaskList extends ArrayList<Task> {
    @Override
    public Task get(int entry) {
        if (this.isInRange(entry)) {
            return super.get(entry - 1);
        }
        return null;
    }

    @Override
    public Task remove(int entry) {
        if (this.isInRange(entry)) {
            return super.remove(entry - 1);
        }
        return null;
    }

    public boolean isInRange(int entry) {
        return entry > 0 && entry <= this.size();
    }

    public void markTask(int entry) {
        if (this.isInRange(entry)) {
            this.get(entry).mark();
        }
    }

    public void unmarkTask(int entry) {
        if (this.isInRange(entry)) {
            this.get(entry).unmark();
        }
    }

    @Override
    public String toString() {
        String result = "";

        for (int entry = 1; entry < this.size() + 1; entry++) {
            result += "\t" + entry + "." + this.get(entry).toString() + "\n";
        }

        return result;
    }

    public String encodeAll() {
        String result = "";

        for (int entry = 1; entry < this.size() + 1; entry++) {
            result += this.get(entry).encode() + "\n";
        }

        return result;
    }
}
