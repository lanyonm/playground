package org.lanyonm.playground.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader=AnnotationConfigContextLoader.class, classes={ExceptionServiceImpl.class})
public class ExceptionServiceTest {

	@Autowired
	private ExceptionService exceptionService;

	@Test
	public void testWillLogIfInterrupted() {
		exceptionService.stopThrowingExceptions();
		exceptionService.startThrowingExceptions();
		exceptionService.startThrowingExceptions();
		exceptionService.stopThrowingExceptions();
	}
}
