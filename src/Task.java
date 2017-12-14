public class Task {
  private String taskName;
  private boolean isDone;

  public Task(String taskName, boolean done) {
    this.taskName = taskName;
    this.isDone = done;
  }

  public String getTaskName() {
    return taskName;
  }

  public boolean isDone() {
    return isDone;
  }

  public void setTaskName(String taskName) {
    this.taskName = taskName;
  }

  public void setDone(boolean done) {
    isDone = done;
  }
}
