package tasks.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {

    private Task task;
    private Date start, end;
    private SimpleDateFormat sdf;


    @BeforeEach
    void setUp() {
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
    void testTaskCreation() throws ParseException {
       assert task.getTitle() == "pasionatii";
        System.out.println(task.getFormattedDateStart());
        System.out.println(task.getDateFormat().format(Task.getDateFormat().parse("2024-04-01 10:10")));
       assert task.getFormattedDateStart().equals(task.getDateFormat().format(Task.getDateFormat().parse("2024-04-01 10:10")));
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getDateFormat() {
    }

    @Test
    void getTitle() {
    }

    @Test
    void setTitle() {
    }

    @Test
    void isActive() {
    }

    @Test
    void setActive() {
    }

    @Test
    void getTime() {
    }

    @Test
    void setTime() {
    }

    @Test
    void getStartTime() {
    }

    @Test
    void getEndTime() {
    }

    @Test
    void getRepeatInterval() {
    }

    @Test
    void testSetTime() {
    }

    @Test
    void isRepeated() {
    }

    @Test
    void nextTimeAfter() {
    }

    @Test
    void getFormattedDateStart() {
    }

    @Test
    void getFormattedDateEnd() {
    }

    @Test
    void getFormattedRepeated() {
    }
}