package Duke;

/**
 * To initialise a new deadline task
 */
public class Deadline extends Task {

    protected String by;

    /**
     * Read in the description and date of a deadline
     *
     * @param description details of the task
     * @param by date the task have to be done by
     */
    public Deadline(String description, String by) {
        super(description);
        this.by = by;
    }

    /**
     * Convert the task details into the format of
     * [D] [tick/cross] details of task [by: the date the task have to be done by]
     */
    @Override
    public String toString() {
        return "[D]" + "[" + super.getStatusIcon() + "] " +
                super.description + " (by: " + by + ")";
    }
}