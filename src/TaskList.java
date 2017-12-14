import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class TaskList {
  private List<Task> myTaskList;
  private Path filePath = Paths.get("tasks.txt");

  public TaskList() {
    myTaskList = new ArrayList<>();
  }

  public List<Task> getMyTaskList() {
    return myTaskList;
  }

  public void makeList () {
    try {
      List<String> lines = Files.readAllLines(filePath);
      if (lines.size() > 0) {
        for (int i = 0; i < lines.size(); i++) {
          boolean isIt = isItDone(lines.get(i));
          String parts[] = lines.get(i).split("-");
          Task myTask = new Task(parts[0], isIt);
          myTask.setDone(isIt);
          myTaskList.add(myTask);
        }
      }
    }
      catch(Exception e){
        System.out.println("Unable to read file");
      }
    }

  public void readFromList() {
    if(myTaskList.size() >= 0) {
      for (int i = 0; i < this.getMyTaskList().size(); i++) {
        System.out.println((i + 1) + " " + this.getMyTaskList().get(i).getTaskName());
      }
    } else {
      System.out.println("There are no tasks.");
    }
  }

  public boolean isItDone(String input) {
    String parts[] = input.split("-");
    boolean isIt = false;
    if (parts.length == 1) {
      isIt = false;
    } else {isIt = true;}
    return isIt;
  }

  public void addToList(List<String> myInput) {
      try {
        Files.write(filePath, myInput, StandardOpenOption.APPEND);
      } catch (Exception e) {
        System.out.println("Unable to write file: my-file.txt");
      }
  }

  public void removeFromList(int whichList) {
    getMyTaskList().remove(whichList-1);
    try {
      List<String> listToRewriteFile = new ArrayList<>();
      for (int i = 0; i < myTaskList.size(); i++) {
        String myTask=myTaskList.get(i).getTaskName();
        if (myTaskList.get(i).isDone()) {
          listToRewriteFile.add(myTask + "- x");
        } else {
          listToRewriteFile.add(myTask);
        }
      }
      Files.write(filePath, listToRewriteFile);
    } catch (Exception e) { }
    if(this.getMyTaskList().size() < whichList)  {
      System.out.println("Too high number");
    }
  }
}
