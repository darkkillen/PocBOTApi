
package com.darkkillen.pocbotapi.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ReportSourceOfDatum {

    @SerializedName("source_of_data_eng")
    @Expose
    private String sourceOfDataEng;
    @SerializedName("source_of_data_th")
    @Expose
    private String sourceOfDataTh;

    /**
     * No args constructor for use in serialization
     * 
     */
    public ReportSourceOfDatum() {
    }

    /**
     * 
     * @param sourceOfDataEng
     * @param sourceOfDataTh
     */
    public ReportSourceOfDatum(String sourceOfDataEng, String sourceOfDataTh) {
        super();
        this.sourceOfDataEng = sourceOfDataEng;
        this.sourceOfDataTh = sourceOfDataTh;
    }

    public String getSourceOfDataEng() {
        return sourceOfDataEng;
    }

    public void setSourceOfDataEng(String sourceOfDataEng) {
        this.sourceOfDataEng = sourceOfDataEng;
    }

    public String getSourceOfDataTh() {
        return sourceOfDataTh;
    }

    public void setSourceOfDataTh(String sourceOfDataTh) {
        this.sourceOfDataTh = sourceOfDataTh;
    }

}
