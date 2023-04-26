package com.example.bachatgat.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.example.bachatgat.entities.User;

public class ExcelImport {

	public List<User> ExcelImport() throws FileNotFoundException {

		List<User> wor = new ArrayList<>();
		int id = 0;
		String name = "";
		double monthly=0.0d;
		double penalty=0.0d;
		double principal=0.0d;
		double loan=0.0d;
		String loanDate=""; 

		String filepath = "C:\\Users\\dell\\Downloads\\Employee (1).xlsx";
		long start = System.currentTimeMillis();
		try {
		FileInputStream fileinput;
		
			fileinput = new FileInputStream(filepath);

			Workbook workbook = new XSSFWorkbook(fileinput);
			Sheet sheet = workbook.getSheetAt(0);
			Iterator<Row> rowIterator = sheet.iterator();
			rowIterator.next();
			while (rowIterator.hasNext()) {
				Row nextRow = rowIterator.next();
				Iterator<Cell> cellIterator = nextRow.cellIterator();
				while (cellIterator.hasNext()) {
					Cell nextCell = cellIterator.next();
					int columnIndex = nextCell.getColumnIndex();
					switch (columnIndex) {

					case 0:
						id = (int) nextCell.getNumericCellValue();
						System.out.println(id);
						break;

					case 1:
						name = nextCell.getStringCellValue();
						System.out.println(name);
						break;

					case 2:
						monthly = nextCell.getNumericCellValue();
						System.out.println(monthly);
						break;

					case 3:
						penalty = nextCell.getNumericCellValue();
						System.out.println(penalty);
						break;
					
					case 4:
						loan = nextCell.getNumericCellValue();
						System.out.println(loan);
						break;
					case 5:
						principal = nextCell.getNumericCellValue();
						System.out.println(principal);
						break;
						
					case 6:
						loanDate = nextCell.getStringCellValue();
						System.out.println(loanDate);
						break;
					}
					wor.add(new User(id, name, monthly,penalty,principal,loan,loanDate));
				}

			}
			workbook.close();
			long end = System.currentTimeMillis();
			System.out.println((end - start));
		} catch (IOException e) {
			e.printStackTrace();
		}

		return wor;

	}
}
