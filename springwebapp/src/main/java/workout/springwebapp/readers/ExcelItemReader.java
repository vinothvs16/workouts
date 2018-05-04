package workout.springwebapp.readers;

import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.poi.ss.usermodel.Header;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemStream;
import org.springframework.batch.item.ItemStreamException;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

public class ExcelItemReader implements ItemReader<String[]>,ItemStream{

	private String fileLocation;
	private final String ROWNUM="rownum";
	private int currRow;
	
	public String getFileLocation() {
		return fileLocation;
	}

	public void setFileLocation(String fileLocation) {
		this.fileLocation = fileLocation;
	}

	public void close() throws ItemStreamException {
		// TODO Auto-generated method stub
		
	}

	public void open(ExecutionContext ctxt) throws ItemStreamException {
		// TODO Auto-generated method stub
		currRow = ctxt.getInt(ROWNUM,0);
		
	}

	public void update(ExecutionContext ctxt) throws ItemStreamException {
		// TODO Auto-generated method stub
		ctxt.putInt(ROWNUM, currRow);
		
	}

	public String[] read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		// TODO Auto-generated method stub
		InputStream is = new FileInputStream(fileLocation);
		Workbook wb = WorkbookFactory.create(is);
        Sheet sheet = wb.getSheetAt(0);
        Header header = sheet.getHeader();
       

        int rowsCount = sheet.getLastRowNum();
        System.out.println("Total Number of Rows: " + (rowsCount + 1));
        while(currRow <= rowsCount)  {
        	Row row =sheet.getRow(currRow);
        	String [] rowArr= new String[row.getLastCellNum()];
        	for(int i=0;i<row.getLastCellNum();i++) {
        		rowArr[i]=row.getCell(i).toString();
        	}
        	currRow++;
        	return rowArr;
        }
		return null;
	}

	
}
