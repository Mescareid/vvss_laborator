package tasks.mockito;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import tasks.model.ArrayTaskList;
import tasks.model.Task;
import tasks.utils.TasksUtils;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

class TasksUtilsIsolationTest {
    private TasksUtils taskUtils;
    private ArrayTaskList mockArrayTaskList;
    private Task mockTask;

    @BeforeEach
    public void setUp() {
        mockArrayTaskList = mock(ArrayTaskList.class);
        mockTask = mock(Task.class);
        taskUtils = new TasksUtils(mockArrayTaskList);
    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    public void test_addTask_callsRepo() {
        // arrange
        Mockito.doNothing().when(mockArrayTaskList).add(mockTask);

        // act
        taskUtils.addTask(mockTask);

        // assert
        Mockito.verify(mockArrayTaskList, times(1)).add(mockTask);
        Mockito.verify(mockArrayTaskList, never()).getAll();
    }

    @Test
    public void test_removeTask_callsRepo() {
        // arrange
        Mockito.when(mockArrayTaskList.remove(mockTask)).thenReturn(true);

        // act
        boolean result = taskUtils.removeTask(mockTask);

        // assert
        assertTrue(result);
        Mockito.verify(mockArrayTaskList, times(1)).remove(mockTask);
        Mockito.verify(mockArrayTaskList, never()).getAll();
    }
}