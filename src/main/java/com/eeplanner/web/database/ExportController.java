package com.eeplanner.web.database;

import com.eeplanner.service.DatabaseDumpTool;
import org.apache.commons.io.FileUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

@Controller
public class ExportController {

	@RequestMapping(value = "export.htm", method = RequestMethod.GET)
	public void export(final HttpServletResponse response) throws IOException, SQLException {

		DatabaseDumpTool.dump();

		File backup = new ClassPathResource("/backup/eeplanner.bak.sql").getFile();

		response.setContentType("text/plain");
		response.getOutputStream().write(FileUtils.readFileToByteArray(backup));
		response.getOutputStream().flush();

	}

}
