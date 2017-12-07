
package com.darkkillen.pocbotapi.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataDetail {

    @SerializedName("period")
    @Expose
    private String period;
    @SerializedName("currency_id")
    @Expose
    private String currencyId;
    @SerializedName("currency_name_th")
    @Expose
    private String currencyNameTh;
    @SerializedName("currency_name_eng")
    @Expose
    private String currencyNameEng;
    @SerializedName("buying_sight")
    @Expose
    private String buyingSight;
    @SerializedName("buying_transfer")
    @Expose
    private String buyingTransfer;
    @SerializedName("selling")
    @Expose
    private String selling;
    @SerializedName("mid_rate")
    @Expose
    private String midRate;

    /**
     * No args constructor for use in serialization
     * 
     */
    public DataDetail() {
    }

    /**
     * 
     * @param currencyNameTh
     * @param selling
     * @param buyingSight
     * @param currencyId
     * @param midRate
     * @param buyingTransfer
     * @param period
     * @param currencyNameEng
     */
    public DataDetail(String period, String currencyId, String currencyNameTh, String currencyNameEng, String buyingSight, String buyingTransfer, String selling, String midRate) {
        super();
        this.period = period;
        this.currencyId = currencyId;
        this.currencyNameTh = currencyNameTh;
        this.currencyNameEng = currencyNameEng;
        this.buyingSight = buyingSight;
        this.buyingTransfer = buyingTransfer;
        this.selling = selling;
        this.midRate = midRate;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(String currencyId) {
        this.currencyId = currencyId;
    }

    public String getCurrencyNameTh() {
        return currencyNameTh;
    }

    public void setCurrencyNameTh(String currencyNameTh) {
        this.currencyNameTh = currencyNameTh;
    }

    public String getCurrencyNameEng() {
        return currencyNameEng;
    }

    public void setCurrencyNameEng(String currencyNameEng) {
        this.currencyNameEng = currencyNameEng;
    }

    public String getBuyingSight() {
        return buyingSight;
    }

    public void setBuyingSight(String buyingSight) {
        this.buyingSight = buyingSight;
    }

    public String getBuyingTransfer() {
        return buyingTransfer;
    }

    public void setBuyingTransfer(String buyingTransfer) {
        this.buyingTransfer = buyingTransfer;
    }

    public String getSelling() {
        return selling;
    }

    public void setSelling(String selling) {
        this.selling = selling;
    }

    public String getMidRate() {
        return midRate;
    }

    public void setMidRate(String midRate) {
        this.midRate = midRate;
    }

}
