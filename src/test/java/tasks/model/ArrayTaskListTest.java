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
    void add() {
        assert task.getTitle() == "pasionatii";
        taskList.add(task);
        assert taskList.size() == 1;
    }
}