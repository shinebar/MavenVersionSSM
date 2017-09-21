package com.wjs.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application-service-test.xml")
public class TestCase {
	@Autowired
	private TestInjection ti;

	@Test
	public void testService() {
		ti.print();
	}
}
