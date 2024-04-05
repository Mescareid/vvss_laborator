package tasks.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class ArrayTaskListTest {
    public ArrayTaskList taskList;
    public Task task;
    private Date start, end;
    private SimpleDateFormat sdf;

    @BeforeEach
    void setUp() {
        taskList = new ArrayTaskList();
        sdf= Task.getDateFormat();
        try {
            start=sdf.parse("2023-02-27 12:00");
            end=sdf.parse("2023-02-27 10:00");
        } catch (ParseException e) {
            fail(e.getMessage());
        }

        try {
            task=new Task("pasionatii", Task.getDateFormat().parse("2024-04-01 10:10"));

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    void TC01_EC() throws ParseException {
        task.setTitle("Homework");
        task.setTime(Task.getDateFormat().parse("2024-03-12 10:10"), Task.getDateFormat().parse("2024-03-13 10:10"), 1);
        task.setActive(true);

        taskList.add(task);

        Task testTask = taskList.getTask(0);

        assert testTask.getTitle() == "Homework";
        assert testTask.getRepeatInterval() == 1;
        assert testTask.isActive();
        //assert testTask.getEndTime() == ;
        assert taskList.size() == 1;
    }

    @Test
    void TC03_EC() throws ParseException {
        task.setTitle("");
        task.setTime(Task.getDateFormat().parse("2024-03-12 10:10"), Task.getDateFormat().parse("2024-03-13 10:10"), 1);
        task.setActive(true);

        taskList.add(task);

        Task testTask = taskList.getTask(0);

        assert testTask.getTitle() == "";
        assert testTask.getRepeatInterval() == 1;
        assert testTask.isActive();
        //assert testTask.getEndTime() == ;
        assert taskList.size() == 1;
    }

    @Test
    void TC04_EC(){
        task.setTitle("Homework");
        try{
            task.setTime(Task.getDateFormat().parse("201q"), Task.getDateFormat().parse("2024-03-13 10:10"), 1);
            task.setActive(true);
            assert false;
        } catch (ParseException ex){
            assert true;
        }
    }

    @Test
    void TC05_EC() throws ParseException {
        task.setTitle("Homework");
        try{
            task.setTime(Task.getDateFormat().parse("2024-03-12 10:10"), Task.getDateFormat().parse("201q"), 1);
            task.setActive(true);
            assert false;
        } catch (ParseException ex){
            assert true;
        }
    }

    @Test
    void TC06_EC() throws ParseException {
        task.setTitle("Homework");
        try{
            task.setTime(Task.getDateFormat().parse("2024-03-12 10:10"), Task.getDateFormat().parse("2024-03-13 10:10"), 1);
            assert true;
        } catch (ParseException ex){
            assert false;
        }
        taskList.add(task);

        Task testTask = taskList.getTask(0);

        assert testTask.isActive() ==  task.isActive();
    }

    @Test
    void TC07_EC() throws ParseException {
        task.setTitle("Homework");
        try{
            task.setTime(Task.getDateFormat().parse("2024-03-12 10:10"), Task.getDateFormat().parse("2024-03-13 10:10"), 28);
            assert true;
        } catch (ParseException ex){
            assert false;
        }
        task.setActive(true);

        taskList.add(task);

        Task testTask = taskList.getTask(0);

        assert testTask.isActive() ==  task.isActive();
    }
}