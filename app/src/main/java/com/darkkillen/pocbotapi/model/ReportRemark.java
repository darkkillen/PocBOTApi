
package com.darkkillen.pocbotapi.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ReportRemark {

    @SerializedName("report_remark_eng")
    @Expose
    private String reportRemarkEng;
    @SerializedName("report_remark_th")
    @Expose
    private String reportRemarkTh;

    /**
     * No args constructor for use in serialization
     * 
     */
    public ReportRemark() {
    }

    /**
     * 
     * @param reportRemarkEng
     * @param reportRemarkTh
     */
    public ReportRemark(String reportRemarkEng, String reportRemarkTh) {
        super();
        this.reportRemarkEng = reportRemarkEng;
        this.reportRemarkTh = reportRemarkTh;
    }

    public String getReportRemarkEng() {
        return reportRemarkEng;
    }

    public void setReportRemarkEng(String reportRemarkEng) {
        this.reportRemarkEng = reportRemarkEng;
    }

    public String getReportRemarkTh() {
        return reportRemarkTh;
    }

    public void setReportRemarkTh(String reportRemarkTh) {
        this.reportRemarkTh = reportRemarkTh;
    }

}
