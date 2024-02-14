package com.document;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import java.util.Scanner;

public class PDFReportGenerator extends ReportGenerator{

    @Override
    protected void gatherData() {
        System.out.println("Enter document data for PDF report (type '@END' on a new line to finish):");
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        String line;
        while (!(line = scanner.nextLine()).equals("@END")) {
            sb.append(line);
            sb.append(System.lineSeparator());
        }
        data = sb.toString();
    }

    @Override
    protected void formatReport() {
        System.out.println("Formatting data for PDF report...");
    }

    @Override
    protected void saveReport() {
        System.out.println("Saving PDF report...");
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\hakan\\OneDrive\\Masaüstü\\Design Patterns\\Design-Patterns\\Behavioral Design Patterns\\Template Method\\ReportDocuments\\Report.pdf"));
            document.open();
            document.add(new Paragraph(data));
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
