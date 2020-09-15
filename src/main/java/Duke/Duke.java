package Duke;

import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;

public class Duke {
    private static ArrayList<Task> list = new ArrayList<>();
    private static String PATH = new File("").getAbsolutePath();
    static File filePath = new File(PATH + "/duke.txt");
    public static void main(String[] args) {
        try {
            filePath.createNewFile();
        } catch (IOException e) {
            System.out.println("File not found");
        }
        String userInput;
        int noOfTask = 0;
        Scanner in = new Scanner(System.in);
        readTextFile(noOfTask);
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";

        System.out.println("Hello from\n" + logo);

        //Get input from user
        System.out.println("Hello! I'm Duke.Duke");
        System.out.println("What can I do for you?");
        userInput = in.nextLine();

        //If bye was not inputted, ask for input again
        while (!userInput.equals("bye")) {
            int divider = userInput.indexOf(" ");

            //If user inputted list, return list of items
            if (userInput.contains("list")) {
                listTask(noOfTask);

            //If user inputted done, then mark the task as done
            } else if (userInput.contains("done")) {
                doneTask(userInput, divider);

            //If user inputted deadline, then add the task under deadline cat
            } else if (userInput.contains("deadline")) {
                noOfTask = Deadline(userInput, noOfTask, divider);

            //If user inputted to do, then add the task under to do cat
            } else if (userInput.contains("todo")) {
                noOfTask = Todo(userInput, noOfTask, divider);

            //If user inputted event, then add task under event cat
            } else if (userInput.contains("event")) {
                noOfTask = Event(userInput, noOfTask, divider);

            //If user inputted delete, then delete the item
            } else if (userInput.contains("delete")) {
                noOfTask = deleteTask(userInput, noOfTask, divider);

            //Else, throw a random word exception
            } else {
                new Exception("random", null);
            }
            updateTextFile();
            userInput = in.nextLine();
        }
        System.out.println("Bye. Hope to see you again soon!");
    }

    private static void readTextFile(int noOfTask) {
        try {
            // create a Scanner using the File as the source
            Scanner s = new Scanner(filePath);
            while (s.hasNext()) {
                final String[] textFile= s.nextLine().trim().split("\\|");
                if (textFile[0].equals("T")) {
                    list.add(noOfTask, new Todo(textFile[2]));
                    if (textFile[1].equals("true")) {
                        list.get(noOfTask).setDone();
                    }
                    noOfTask ++;
                } else if (textFile[0].equals("D")) {
                    list.add(noOfTask, new Deadline(textFile[2],textFile[3]));
                    if (textFile[1].equals("true")) {
                        list.get(noOfTask).setDone();
                    }
                    noOfTask ++;
                } else if (textFile[0].equals("E")) {
                    list.add(noOfTask, new Event(textFile[2],textFile[3]));
                    if (textFile[1].equals("true")) {
                        list.get(noOfTask).setDone();
                    }
                    noOfTask ++;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }

    private static void updateTextFile() {
        FileWriter fw;
        try {
            fw = new FileWriter(filePath);
            String textAdd="";
            for (int i = 0; i < list.size(); i ++) {
                if (list.get(i) instanceof Todo) {
                    textAdd = textAdd.concat("T|" + list.get(i).isDone
                            + "|" + list.get(i).description + "\n");
                } else if (list.get(i) instanceof Deadline) {
                    textAdd = textAdd.concat("D|" + list.get(i).isDone
                            + "|" + list.get(i).description + "|" + ((Deadline) list.get(i)).by + "\n");
                } else if (list.get(i) instanceof Event) {
                    textAdd = textAdd.concat("E|" + list.get(i).isDone
                            + "|" + list.get(i).description + "|" + ((Event) list.get(i)).by + "\n");
                }
            }
            fw.write(textAdd);
            fw.close();
        } catch (IOException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
    }

    private static int Event(String line, int noOfTask, int divider) {
        int dividerDate = line.indexOf("/");

        //Run description error
        if (line.equals("event") || line.equals("event ")) {
            new Exception("description", "event");

        //Run date error
        } else if (line.endsWith("/") || line.endsWith("/ ")) {
            new Exception("date", "event");

        //If no error, run code to store event
        } else {
            list.add(noOfTask, new Event(line.substring((divider + 1),
                    (dividerDate - 1)), line.substring(dividerDate + 4)));
            noOfTask++;
            System.out.println("Got it. I've added this task:");
            System.out.println("  " + list.get(noOfTask-1));
            if ((noOfTask - 1) == 0) {
                System.out.println("Now you have " + noOfTask + " task in the list.");
            } else {
                System.out.println("Now you have " + noOfTask + " tasks in the list.");
            }
        }
        return noOfTask;
    }

    private static int Todo(String line, int noOfTask, int divider) {

        //Run description error
        if (line.equals("todo") || line.equals("todo ")) {
            new Exception("description", "todo");

        //If no error, run code to store to do
        } else {
            list.add(noOfTask, new Todo(line.substring(divider + 1)));
            noOfTask++;
            System.out.println("Got it. I've added this task:");
            System.out.println("  " + list.get(noOfTask-1));
            if ((noOfTask - 1) == 0) {
                System.out.println("Now you have " + noOfTask + " task in the list.");
            } else {
                System.out.println("Now you have " + noOfTask + " tasks in the list.");
            }
        }
        return noOfTask;
    }

    private static int Deadline(String line, int noOfTask, int divider) {
        int dividerDate = line.indexOf("/");

        //Run description error
        if (line.equals("deadline") || line.equals("deadline ")) {
            new Exception("description", "deadline");

        //Run date error
        } else if (line.endsWith("/") || line.endsWith("/ ")) {
            new Exception("date", "deadline");

        //If no error, run code to store deadline
        } else {
            list.add(noOfTask, new Deadline(line.substring((divider + 1),
                    (dividerDate - 1)), line.substring(dividerDate + 4)));
            noOfTask++;
            System.out.println("Got it. I've added this task:");
            System.out.println("  " + list.get(noOfTask-1));
            if ((noOfTask - 1) <= 0) {
                System.out.println("Now you have " + noOfTask + " task in the list.");
            } else {
                System.out.println("Now you have " + noOfTask + " tasks in the list.");
            }
        }
        return noOfTask;
    }

    private static void doneTask(String line, int divider) {

        //Run description error
        if (line.equals("done") || line.equals("done ")) {
            new Exception("description", "done");

        //If no description error, run code to tick done
        } else {
            try {
                int taskNumber = Integer.parseInt(line.substring(divider + 1));
                list.get(taskNumber-1).setDone();
                System.out.println("Nice! I've marked this task as done:");
                System.out.println("  " + list.get(taskNumber-1));

                //If no number is input, throw error
            } catch (NumberFormatException e) {
                System.out.println("Please input the task number!");
            }
        }
    }

    private static int deleteTask(String line, int noOfTask, int divider) {

        //Run description error
        if (line.equals("delete") || line.equals("delete ")) {
            new Exception("description", "delete");

        //If no description error, run code to delete task
        } else {
            try {
                int taskNumber = Integer.parseInt(line.substring(divider + 1));
                System.out.println("Noted. I've removed this task:");
                System.out.println("  " + list.get(taskNumber-1));
                list.remove(taskNumber-1);
                noOfTask --;
                if ((noOfTask - 1) <= 0) {
                    System.out.println("Now you have " + noOfTask + " task in the list.");
                } else {
                    System.out.println("Now you have " + noOfTask + " tasks in the list.");
                }

                //If no number is input, throw error
            } catch (NumberFormatException e) {
                System.out.println("Please input the task number!");
            }
        }
        return noOfTask;
    }

    private static void listTask(int noOfTask) {

        //Run empty error
        if (noOfTask == 0) {
            new Exception("empty", null);

            //If no error, run code to list task
        } else {
            System.out.println("Here are the tasks in your list:");
            for (int i = 0; i < noOfTask; i++) {
                int listNumber = i + 1;
                System.out.println(listNumber + "." + list.get(listNumber-1));
            }
        }
    }
}
