package Duke;

/**
 * To initialise a new to do task
 */
public class Todo extends Task {

    /**
     * Read in the description and date of a deadline
     *
     * @param description details of the task
     */
    public Todo(String description) {
        super(description);
    }

    /**
     * Convert the task details into the format of
     * [T] [tick/cross] details of task
     */
    @Override
    public String toString() {
        return "[T]" + "[" + super.getStatusIcon() + "] " +
                super.description;
    }
}
