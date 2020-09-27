package Duke;

public class Exception extends java.lang.Exception {

    public Exception (String type, String description) {
        switch (type) {
            case "description":
                System.out.println("☹ OOPS!!! The description of a "
                        + description + " cannot be empty.");
                break;
            case "date":
                System.out.println("☹ OOPS!!! The date of a "
                        + description + " cannot be empty.");
                break;
            case "random":
                System.out.println("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
                break;
            case "empty":
                System.out.println("☹ OOPS!!! I'm sorry, but there is no tasks in list. :-(");
                break;
        }
    }
}
