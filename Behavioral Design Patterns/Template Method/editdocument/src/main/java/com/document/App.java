/*
 * This is a simple Java program that demonstrates the use of the Template Method Pattern.
 * The program generates two types of reports: a PDF report and an HTML report.
 *
 * The `ReportGenerator` is an abstract class that defines the template method `generateReport()`.
 * This method outlines the steps to generate a report. The steps are defined as abstract methods.
 *
 * `PDFReportGenerator` and `HTMLReportGenerator` are concrete classes that provide specific implementations
 * for each step in the report generation process.
 *
 * The `main` method in the `App` class creates instances of these concrete classes and calls the `generateReport()`
 * method on each instance. This results in the generation of a PDF report and an HTML report.
 */
package com.document;

public class App 
{
    public static void main( String[] args )
    {
        // ReportGenerator htmlReportGenerator = new HTMLReportGenerator();
        // htmlReportGenerator.generateReport();

        //ReportGenerator pdfReportGenerator = new PDFReportGenerator();
        //pdfReportGenerator.generateReport();

        // ReportGenerator txtReportGenerator = new TXTReportGenerator();
        // txtReportGenerator.generateReport();
    }
}