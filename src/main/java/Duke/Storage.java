package Duke;

import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Storage {
    private static String PATH = new File("").getAbsolutePath();
    File filePath = new File(PATH + "/duke.txt");
    private static ArrayList<Task> list = new ArrayList<>();


    public void createTextFile() {
        try {
            this.filePath.createNewFile();
        } catch(IOException e){
            System.out.println("File not found");
        }
    }

    public ArrayList<Task> readTextFile(int noOfTask) {
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

        return list;
    }

    public void updateTextFile() {
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
}
