package com.drool.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import com.drool.pojo.User;
@EnableWebMvc
@Configuration
@Component("excel")
public class ExcelViewGenerator extends AbstractXlsView {

	public ExcelViewGenerator() {
		System.out.println("***ExcelViewGenerator***");
	}
	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		@SuppressWarnings("unchecked")
		List<User> users=(List<User>) model.get("users");
		String []headers= {"userName","Email","Mobile"};
		int rc=0;
		
		Sheet sheet=workbook.createSheet("users");
		Row row=sheet.createRow(rc);
		for(int i=0;i<headers.length;i++) {
			row.createCell(i).setCellValue(headers[i]);
		}
		
		for(User user:users) {
			row=sheet.createRow(++rc);
			row.createCell(0).setCellValue(user.getUserName());
			row.createCell(1).setCellValue(user.getEmail());
			row.createCell(2).setCellValue(user.getMobile());
		}
		
	}

}
