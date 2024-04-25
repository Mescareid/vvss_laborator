package tasks.mockito;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tasks.model.ArrayTaskList;
import tasks.model.Task;
import tasks.utils.TasksUtils;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

public class TasksUtilsIntegrateArrayTaskList {

    private Task mockTask;
    private ArrayTaskList atl;
    private TasksUtils tasksUtils;
    //private Date date;

    @BeforeEach
    public void setUp() {
        mockTask = mock(Task.class);
        atl = new ArrayTaskList();
        tasksUtils = new TasksUtils(atl);
    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testAdd() {
        // arrange
        int preAddLength, postAddLength;
        Task insertedTask;

        // act
        preAddLength = tasksUtils.getAllTasks().size();
        tasksUtils.addTask(mockTask);
        postAddLength = tasksUtils.getAllTasks().size();
        insertedTask = tasksUtils.getAllTasks().get(postAddLength - 1);

        // assert
        assertEquals(0, preAddLength);
        assertEquals(1, postAddLength);
        assertEquals(mockTask, insertedTask);
    }

    @Test
    public void testRemove() {
        // arrange
        tasksUtils.addTask(mockTask);
        int preRemoveLength, postRemoveLength;
        boolean result;

        // act
        preRemoveLength = tasksUtils.getAllTasks().size();
        result = tasksUtils.removeTask(mockTask);
        postRemoveLength = tasksUtils.getAllTasks().size();

        // assert
        assertEquals(1, preRemoveLength);
        assertEquals(0, postRemoveLength);
        assertTrue(result);
    }

}