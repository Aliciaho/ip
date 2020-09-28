package Duke;

/**
 * To initialise a new event task
 */
public class Event extends Task {

    protected String by;

    /**
     * Read in the description and date of a Event
     *
     * @param description details of the task
     * @param by date the task have to be done by
     */
    public Event(String description, String by) {
        super(description);
        this.by = by;
    }

    /**
     * Convert the task details into the format of
     * [E] [tick/cross] details of task [at: the date the task have to be done by]
     */
    @Override
    public String toString() {
        return "[E]" + "[" + super.getStatusIcon() + "] " +
                super.description + " (at: " + by + ")";
    }
}
