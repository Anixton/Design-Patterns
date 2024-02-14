package com.document;

import java.io.PrintWriter;
import java.util.Scanner;

public class HTMLReportGenerator extends ReportGenerator {
    private boolean isPTagCreated = false;

    @Override
    protected void gatherData() {
        System.out.println("Enter document data for HTML report (type '@END' on a new line to finish):");
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        String line;
        String previousLine="";
        while (!(line = scanner.nextLine()).equals("@END")) {
            if(line.equals("")) {
                if(isPTagCreated){
                    sb.append("</p>\n");
                    isPTagCreated = false;
                } else {
                    sb.append("<br>\n");
                }
            } else {
                if(!isPTagCreated && previousLine.equals("")) {
                    sb.append("<h2>");
                    sb.append(line);
                    sb.append("</h2>\n");
                } else if(!isPTagCreated) {
                    sb.append("<p>");
                    sb.append(line);
                    sb.append("<br>\n");
                    isPTagCreated = true;
                } else {
                    sb.append(line);
                    sb.append("<br>\n");
                }
            }

            previousLine = line;
        }

        // Close the <p> tag if it's still open
        if (isPTagCreated) {
            sb.append("</p>\n");
        }

        data = sb.toString();
    }

    @Override
    protected void formatReport() {
        System.out.println("Formatting data for HTML report...");
        // You can add code here to format your data as needed
    }

    @Override
    protected void saveReport() {
        System.out.println("Saving HTML report...");
        try (PrintWriter out = new PrintWriter("C:\\Users\\hakan\\OneDrive\\Masaüstü\\Design Patterns\\Design-Patterns\\Behavioral Design Patterns\\Template Method\\ReportDocuments\\Report.html")) {
            out.println(data);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
