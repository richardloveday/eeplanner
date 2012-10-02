package com.eeplanner.service;

import org.apache.commons.io.FileUtils;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.File;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:datasources.xml")
public class DatabaseDumpToolTest {

	@Test
	@Ignore
	public void testDump() throws Exception {
		String databaseDump = DatabaseDumpTool.dump();
		FileUtils.writeByteArrayToFile(new File("./test.dmp"), databaseDump.getBytes());
		System.out.println(databaseDump);
	}

}
