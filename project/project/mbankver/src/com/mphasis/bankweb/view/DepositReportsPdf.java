package com.mphasis.bankweb.view;

import java.awt.Color;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.mphasis.bankweb.entity.DepositCustomer;

/**
 * 
 * @author Ashwini.Sharma08
 *
 */
@Component("DepositReportsPdf")
public class DepositReportsPdf extends AbstractPdfView {


	@Override
	protected void buildPdfDocument(Map model, Document doc, PdfWriter writer, HttpServletRequest req,
			HttpServletResponse resp) throws Exception {

		List<DepositCustomer> dep= (List<DepositCustomer>) model.get("customers");
		
		doc.addTitle("Deposit Customer reports");
		PdfPTable table = new PdfPTable(6);
		Paragraph paragraph1 = new Paragraph("\tCUSTOMER DETAILS\n\n\n");

		doc.add(new Paragraph(paragraph1));

		table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
		table.getDefaultCell().setVerticalAlignment(Element.ALIGN_MIDDLE);
		table.getDefaultCell().setBackgroundColor(Color.CYAN);
		
		table.addCell("Customer id:");
		table.addCell("Account id");
		table.addCell("Name");
		table.addCell("Pan");
		table.addCell("Balance");
		table.addCell("Status");
		
		for(DepositCustomer customer :dep){
			table.addCell(customer.getCustId());
			table.addCell(customer.getAcnt().getAcntId());
			table.addCell(customer.getCustName());
			table.addCell(customer.getPan());
			table.addCell(customer.getAcnt().getBalance()+"");
			table.addCell(customer.getStatus());

		}
		
		doc.add(table);
	}
	
}


