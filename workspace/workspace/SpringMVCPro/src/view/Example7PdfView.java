package view;


import java.awt.Color;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.Rectangle;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import entity.Flight;

public class Example7PdfView extends AbstractPdfView {

	protected void buildPdfDocument(Map model, Document doc, PdfWriter writer, HttpServletRequest req,
			HttpServletResponse resp) throws Exception {

		List<Flight> flights = (List<Flight>) model.get("flights");

		 Font font1 = FontFactory.getFont(FontFactory.HELVETICA, 16, Font.BOLD);

		doc.add(new Phrase("Flights Information", font1));
		PdfPTable table = new PdfPTable(4);
		table.setWidthPercentage(100);
		PdfPCell cell = new PdfPCell();
		cell.setPadding(5f);
		cell.setUseBorderPadding(true);
		
		 Font font = FontFactory.getFont(FontFactory.HELVETICA, 12, Font.BOLD);
		 cell = new PdfPCell(new Phrase("Flight No", font));
         cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
         cell.setHorizontalAlignment(Element.ALIGN_CENTER);
         table.addCell(cell);
         
         cell = new PdfPCell(new Phrase("Carrier", font));
         cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
         cell.setHorizontalAlignment(Element.ALIGN_CENTER);
         table.addCell(cell);
         
         cell = new PdfPCell(new Phrase("From", font));
         cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
         cell.setHorizontalAlignment(Element.ALIGN_CENTER);
         table.addCell(cell);
         
         cell = new PdfPCell(new Phrase("To", font));
         cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
         cell.setHorizontalAlignment(Element.ALIGN_CENTER);
         table.addCell(cell);
         
        
		for (Flight flight : flights) {
			table.addCell(flight.getFlightNo());
			table.addCell(flight.getCarrier());
			table.addCell(flight.getFrom());
			table.addCell(flight.getTo());
			
			
		}
		doc.add(table);
	}

}
