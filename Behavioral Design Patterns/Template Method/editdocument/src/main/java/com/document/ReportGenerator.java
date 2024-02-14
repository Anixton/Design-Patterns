package com.document;

public abstract class ReportGenerator {
    protected String data;

    // Template method
    public final void generateReport() {
        gatherData();
        formatReport();
        saveReport();
    }

    protected abstract void gatherData();
    protected abstract void formatReport();
    protected abstract void saveReport();
}
