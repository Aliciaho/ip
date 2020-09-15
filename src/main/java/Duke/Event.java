package Duke;

public class Event extends Task {

    protected String by;

    public Event(String description, String by) {
        super(description);
        this.by = by;
    }

    @Override
    public String toString() {
        return "[E]" + "[" + super.getStatusIcon() + "] " +
                super.description + " (at: " + by + ")";
    }
}