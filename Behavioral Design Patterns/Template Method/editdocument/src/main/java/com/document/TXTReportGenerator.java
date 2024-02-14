package com.document;

import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class TXTReportGenerator extends ReportGenerator {

    @Override
    protected void gatherData() {
        System.out.println("Enter document data for TXT report (type '@END' on a new line to finish):");
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
        System.out.println("Formatting data for Txt report...");
        // You can add code here to format your data as needed
    }

    @Override
    protected void saveReport() {
        System.out.println("Saving TXT report...");
        try (PrintWriter out = new PrintWriter("C:\\Users\\hakan\\OneDrive\\Masaüstü\\Design Patterns\\Design-Patterns\\Behavioral Design Patterns\\Template Method\\ReportDocuments\\Report.txt")) {
            out.println(data);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}