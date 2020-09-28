package Duke;

/**
 * To initialise the Task superclass
 */
public class Task {
    protected String description;
    protected boolean isDone;

    /**
     * Read in the users' description from their input
     * and make the task as not done by default
     */
    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    /**
     * Return the status icon of the task
     * If the task is done, a tick is returned
     * If the task is not done, a cross is returned
     */
    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
    }

    /**
     * To mark the staus of the icon as done, if the user has finished it
     */
    public void setDone() {
        this.isDone = true;
    }

    public String getDescription() {
        return description;
    }

}