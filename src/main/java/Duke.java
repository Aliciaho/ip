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
        line = in.nextLine().toLowerCase();

        //If bye was not inputted, ask for input again
        while(!line.equals("bye")) {
            //If user inputted list, return list of items
            if(line.equals("list")) {
                for(int i = 0; i < noOfTask; i ++) {
                    int listNumber = i + 1;
                    System.out.println(listNumber + ".[" + list[i].getStatusIcon() + "] " + list[i].description);
                }
            }
            //If user inputted done, then mark the task as done
            else if(line.contains("done")) {
                int divider = line.indexOf(" ");
                String action = line.substring(0,divider);
                int taskNumber = Integer.parseInt(line.substring(divider+1));
                list[taskNumber-1].doneTask();
                System.out.println("Nice! I've marked this task as done:");
                System.out.println("  [" + list[taskNumber-1].getStatusIcon() + "] " + list[taskNumber-1].description);
            }
            //else print added statement and add the item to list
            else {
                System.out.println("added: " + line);
                list[noOfTask] = new Task(line);
                noOfTask ++;
            }
            line = in.nextLine().toLowerCase();
        }
        System.out.println("Bye. Hope to see you again soon!");
    }
}
