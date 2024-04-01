package tasks.controller;

import javafx.collections.ObservableList;
import javafx.embed.swing.JFXPanel;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tasks.model.ArrayTaskList;
import tasks.model.Task;
import tasks.services.DateService;
import tasks.services.TasksService;

import java.text.ParseException;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class NewEditControllerTest {
    private ArrayTaskList tasks;
    private ObservableList<Task> tasksList;
    private DatePicker datePickerStart, datePickerEnd;
    private TextField txtFieldTimeStart, txtFieldTimeEnd;
    private TextField fieldInterval;
    private CheckBox checkBoxRepeated;
    private TasksService service;
    private DateService dateService;

    @BeforeEach
    void setUp() {
        tasks = new ArrayTaskList();
        try {
            Task dummy = new Task("dummy task", Task.getDateFormat().parse("2024-04-01 10:10"));
            tasks.add(dummy);
        }
        catch (ParseException e){
            e.printStackTrace();
        }
        service = new TasksService(tasks);
        dateService = new DateService(service);

        tasksList = service.getObservableList();

        /*txtFieldTimeStart = new TextField("dateStart");
        txtFieldTimeStart = new TextField("dateEnd");
        txtFieldTimeStart = new TextField("interval");

        LocalDate dateStart = LocalDate.of(2024, 4, 1);
        LocalDate dateEnd = LocalDate.of(2024, 4, 10);
        datePickerStart = new DatePicker(dateStart);
        datePickerEnd = new DatePicker(dateEnd);

        checkBoxRepeated = new CheckBox();
        checkBoxRepeated.setSelected(true);*/
    }

    @Test
    void makeTask() {
    }
}