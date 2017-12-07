
package com.darkkillen.pocbotapi.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataHeader {

    @SerializedName("report_name_eng")
    @Expose
    private String reportNameEng;
    @SerializedName("report_name_th")
    @Expose
    private String reportNameTh;
    @SerializedName("report_uoq_name_eng")
    @Expose
    private String reportUoqNameEng;
    @SerializedName("report_uoq_name_th")
    @Expose
    private String reportUoqNameTh;
    @SerializedName("report_source_of_data")
    @Expose
    private List<ReportSourceOfDatum> reportSourceOfData = null;
    @SerializedName("report_remark")
    @Expose
    private List<ReportRemark> reportRemark = null;
    @SerializedName("last_updated")
    @Expose
    private String lastUpdated;

    /**
     * No args constructor for use in serialization
     * 
     */
    public DataHeader() {
    }

    /**
     * 
     * @param reportNameTh
     * @param reportRemark
     * @param reportNameEng
     * @param lastUpdated
     * @param reportSourceOfData
     * @param reportUoqNameTh
     * @param reportUoqNameEng
     */
    public DataHeader(String reportNameEng, String reportNameTh, String reportUoqNameEng, String reportUoqNameTh, List<ReportSourceOfDatum> reportSourceOfData, List<ReportRemark> reportRemark, String lastUpdated) {
        super();
        this.reportNameEng = reportNameEng;
        this.reportNameTh = reportNameTh;
        this.reportUoqNameEng = reportUoqNameEng;
        this.reportUoqNameTh = reportUoqNameTh;
        this.reportSourceOfData = reportSourceOfData;
        this.reportRemark = reportRemark;
        this.lastUpdated = lastUpdated;
    }

    public String getReportNameEng() {
        return reportNameEng;
    }

    public void setReportNameEng(String reportNameEng) {
        this.reportNameEng = reportNameEng;
    }

    public String getReportNameTh() {
        return reportNameTh;
    }

    public void setReportNameTh(String reportNameTh) {
        this.reportNameTh = reportNameTh;
    }

    public String getReportUoqNameEng() {
        return reportUoqNameEng;
    }

    public void setReportUoqNameEng(String reportUoqNameEng) {
        this.reportUoqNameEng = reportUoqNameEng;
    }

    public String getReportUoqNameTh() {
        return reportUoqNameTh;
    }

    public void setReportUoqNameTh(String reportUoqNameTh) {
        this.reportUoqNameTh = reportUoqNameTh;
    }

    public List<ReportSourceOfDatum> getReportSourceOfData() {
        return reportSourceOfData;
    }

    public void setReportSourceOfData(List<ReportSourceOfDatum> reportSourceOfData) {
        this.reportSourceOfData = reportSourceOfData;
    }

    public List<ReportRemark> getReportRemark() {
        return reportRemark;
    }

    public void setReportRemark(List<ReportRemark> reportRemark) {
        this.reportRemark = reportRemark;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

}
