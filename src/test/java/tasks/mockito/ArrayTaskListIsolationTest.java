package tasks.mockito;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import tasks.model.ArrayTaskList;
import tasks.model.Task;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class ArrayTaskListIsolationTest {

    private Task mockTask;
    private ArrayTaskList atl;

    @BeforeEach
    public void setUp() {
        mockTask = mock(Task.class);
        mockTask.setTitle("Title");
        atl = new ArrayTaskList();
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
        preAddLength = atl.size();
        atl.add(mockTask);
        postAddLength = atl.size();
        insertedTask = atl.getTask(postAddLength - 1);

        // assert
        assertEquals(0, preAddLength);
        assertEquals(1, postAddLength);
        assertEquals(mockTask, insertedTask);
    }

    @Test
    public void testRemove() {
        // arrange
        atl.add(mockTask);
        int preRemoveLength, postRemoveLength;
        boolean result;

        // act
        preRemoveLength = atl.size();
        result = atl.remove(mockTask);
        postRemoveLength = atl.size();

        // assert
        assertEquals(1, preRemoveLength);
        assertEquals(0, postRemoveLength);
        assertTrue(result);
    }

}