public class Exception {

    public Exception (String type, String description) {
        if (type.equals("description")) {
            System.out.println("☹ OOPS!!! The description of a "
                    + description + " cannot be empty.");
        } else if (type.equals("date")) {
            System.out.println("☹ OOPS!!! The date of a "
                    + description + " cannot be empty.");
        } else if (type.equals("random")) {
            System.out.println("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
        } else if (type.equals("empty")) {
            System.out.println("☹ OOPS!!! I'm sorry, but there is no tasks in list. :-(");
        }
    }
}
