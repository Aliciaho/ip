import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        String line;
        Task[] list = new Task[100];
        int noOfTask = 0;
        Scanner in = new Scanner(System.in);
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";

        System.out.println("Hello from\n" + logo);

        //Get input from user
        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?");
        line = in.nextLine();

        //If bye was not inputted, ask for input again
        while (!line.equals("bye")) {
            //If user inputted list, return list of items
            if (line.contains("list")) {
                System.out.println("Here are the tasks in your list:");
                for (int i = 0; i < noOfTask; i++) {
                    int listNumber = i + 1;
                    System.out.println(listNumber + "." + list[i]);
                }
            //If user inputted done, then mark the task as done
            } else if (line.contains("done")) {
                int divider = line.indexOf(" ");
                int taskNumber = Integer.parseInt(line.substring(divider + 1));
                list[taskNumber - 1].setDone();
                System.out.println("Nice! I've marked this task as done:");
                System.out.println("  " + list[taskNumber - 1]);
            //If user inputted deadline, then add the task under deadline cat
            } else if (line.contains("deadline")) {
                int dividerAction = line.indexOf(" ");
                int dividerDate = line.indexOf("/");
                list[noOfTask] = new Deadline(line.substring((dividerAction + 1),
                        (dividerDate - 1)), line.substring(dividerDate + 4));
                noOfTask++;
                System.out.println("Got it. I've added this task:");
                System.out.println("  " + list[noOfTask - 1]);
                if ((noOfTask - 1) == 0) {
                    System.out.println("Now you have " + noOfTask + " task in the list.");
                } else {
                    System.out.println("Now you have " + noOfTask + " tasks in the list.");
                }
            //If user inputted to do, then add the task under to do cat
            } else if (line.contains("todo")) {
                int divider = line.indexOf(" ");
                list[noOfTask] = new Todo(line.substring(divider + 1));
                noOfTask++;
                System.out.println("Got it. I've added this task:");
                System.out.println("  " + list[noOfTask - 1]);
                if ((noOfTask - 1) == 0) {
                    System.out.println("Now you have " + noOfTask + " task in the list.");
                } else {
                    System.out.println("Now you have " + noOfTask + " tasks in the list.");
                }
            //If user inputted event, then add task under event cat
            } else if (line.contains("event")) {
                int dividerAction = line.indexOf(" ");
                int dividerDate = line.indexOf("/");
                list[noOfTask] = new Event(line.substring((dividerAction + 1),
                        (dividerDate - 1)), line.substring(dividerDate + 4));
                noOfTask ++;
                System.out.println("Got it. I've added this task:");
                System.out.println("  " + list[noOfTask - 1]);
                if ((noOfTask - 1) == 0) {
                    System.out.println("Now you have " + noOfTask + " task in the list.");
                } else {
                    System.out.println("Now you have " + noOfTask + " tasks in the list.");
                }
            //else print added statement and add the item to list
            } else {
                System.out.println("added: " + line);
                list[noOfTask] = new Task(line);
                noOfTask ++;
            }
            line = in.nextLine();
        }
        System.out.println("Bye. Hope to see you again soon!");
    }
}
