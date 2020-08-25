import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        String line;
        String[] list = new String[100];
        int count = 0;
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
            //If user inputted list, list out the items user has inputted before
            if(line.equals("list")) {
                for(int i = 0; i < count; i ++) {
                    int listNumber = i + 1;
                    System.out.println(listNumber + ". " + list[i]);
                }
            }
            //else print added statement and add the item to list
            else {
                System.out.println("added: " + line);
                list[count] = line;
                count++;
            }
            line = in.nextLine().toLowerCase();
        }
        System.out.println("Bye. Hope to see you again soon!");
    }
}
