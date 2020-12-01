package com.ragabaat.ardc.ebook;

public class EbookData {

    private String pdfUrl,pdfName;

    public EbookData() {
    }

    public EbookData(String pdfUrl, String pdfName) {
        this.pdfUrl = pdfUrl;
        this.pdfName = pdfName;
    }

    public String getPdfUrl() {
        return pdfUrl;
    }

    public void setPdfUrl(String pdfUrl) {
        this.pdfUrl = pdfUrl;
    }

    public String getPdfName() {
        return pdfName;
    }

    public void setPdfName(String pdfName) {
        this.pdfName = pdfName;
    }
}

