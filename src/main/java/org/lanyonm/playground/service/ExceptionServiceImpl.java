package org.lanyonm.playground.service;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service("exceptionService")
public class ExceptionServiceImpl implements ExceptionService {

	private Thread exceptionThread = null;
	private volatile boolean running = true;
	private static final Logger log = LoggerFactory.getLogger(ExceptionServiceImpl.class);

	public void startThrowingExceptions() {
		running = true;
		if (exceptionThread == null) {
			exceptionThread = new Thread() {
				public void run() {
					while (running) {
						try {
							sleep(1000);
							throw new Exception("exception thrown at " + new Date());
						} catch(Exception e) {
							log.error("exception thrown!", e);
						}
					}
				}
			};
			exceptionThread.start();
		}
	}

	public void stopThrowingExceptions() {
		if (exceptionThread != null) {
			try {
				running = false;
				exceptionThread.join();
				exceptionThread = null;
			} catch (InterruptedException e) {
				log.error("error joining thread after terminating it", e);
			}
		}
	}

}
