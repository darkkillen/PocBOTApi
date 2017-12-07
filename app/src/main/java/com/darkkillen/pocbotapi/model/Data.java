
package com.darkkillen.pocbotapi.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("data_header")
    @Expose
    private DataHeader dataHeader;
    @SerializedName("data_detail")
    @Expose
    private List<DataDetail> dataDetail = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Data() {
    }

    /**
     * 
     * @param dataHeader
     * @param dataDetail
     */
    public Data(DataHeader dataHeader, List<DataDetail> dataDetail) {
        super();
        this.dataHeader = dataHeader;
        this.dataDetail = dataDetail;
    }

    public DataHeader getDataHeader() {
        return dataHeader;
    }

    public void setDataHeader(DataHeader dataHeader) {
        this.dataHeader = dataHeader;
    }

    public List<DataDetail> getDataDetail() {
        return dataDetail;
    }

    public void setDataDetail(List<DataDetail> dataDetail) {
        this.dataDetail = dataDetail;
    }

}
