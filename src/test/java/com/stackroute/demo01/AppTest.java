package com.stackroute.demo01;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.BDDMockito.*;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
 
import com.stackroute.demo01.DatabaseDAO;
import com.stackroute.demo01.NetworkDAO;
import com.stackroute.demo01.RecordService;
 
@RunWith(MockitoJUnitRunner.class)
public class AppTest 
{

    @Mock
    DatabaseDAO databaseMock;
     
    @Mock
    NetworkDAO networkMock;
    
    @Mock
    DemoDAO demoDAOMock;
    
	@InjectMocks
    RecordService recordService; 

    @Test
    public void saveTest()
    {
        boolean saved = recordService.save("temp.txt");
        assertEquals(true, saved);
         
        verify(databaseMock, times(1)).save("temp.txt");
        verify(networkMock, times(1)).save("temp.txt");
    }
    
    @Test
    public void checkTestSuccess()
    {
		//when(demoDAOMock.demo()).thenReturn(true);
		assertTrue(recordService.save("abc.txt"));
        
    }

    @Test
    public void checkTestFailure()
    {
		//when(demoDAOMock.demo()).thenReturn(false);
		//   given(demoDAOMock.demo()).willReturn(false);
		assertTrue(recordService.save("abc.txt"));

        

    }

    @Test(expected = RuntimeException.class)
    public void checkExceptionTest()
    {
    	when(recordService.exceptioncheck()).thenThrow(new RuntimeException());
    	
		//doThrow(new RuntimeException("Service class test1 method not imlplemented"))
		//.when(recordService).exceptioncheck();

		
    }
    
    
}