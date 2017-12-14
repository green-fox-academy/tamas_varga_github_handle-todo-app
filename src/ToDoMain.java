import java.util.ArrayList;
import java.util.List;

public class ToDoMain {
  public static void main(String[] args) {
    TaskList myTasks=new TaskList();

    myTasks.makeList();

    if(args.length == 0) {
      System.out.println("Command Line Todo application");
      System.out.println("=============================");
      System.out.println("Command line arguments:");
      System.out.println("-l   Lists all the tasks");
      System.out.println("-a   Adds a new task");
      System.out.println("-r   Removes a task");
      System.out.println("-c   Completes a task");
    }

    else if( args.length > 0 && args[0].equals("-l") == false  && args[0].equals("-a") == false
            && args[0].equals("-r") == false  && args[0].equals("-c") == false) {
      System.out.println("Unsupported argument");
    }

    else if(args[0].equals("-l")){
      myTasks.readFromList();
    }
    else if(args[0].equals("-a") && args.length == 1) {
      System.out.println("Unable to add: no task provided");
    }

    else if(args[0].equals("-a") && args.length > 1) {
      List<String> inputList = new ArrayList<>();
      for(int i=1; i < args.length; i++) {
        inputList.add(args[i]);
      }
      myTasks.addToList(inputList);
    }

    else if(args[0].equals("-r") && args.length == 1) {
      System.out.println("Unable to remove: no task provided");
    }

    else if(args[0].equals("-r") && args.length > 1) {
      for(int i=1; i < args.length; i++) {
        try {
          int whichToRemove = Integer.parseInt(args[i]);
          System.out.println(whichToRemove);
          if (whichToRemove <= myTasks.getMyTaskList().size()) {
            myTasks.removeFromList(whichToRemove);
          } else {
            System.out.println("Unable to remove: index is out of bound");
          }
        } catch (Exception e) {
          System.out.println("Unable to remove: index is not a number");
        }
      }
    }
  }
}
