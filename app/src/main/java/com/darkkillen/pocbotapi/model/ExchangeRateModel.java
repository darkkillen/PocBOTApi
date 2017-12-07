
package com.darkkillen.pocbotapi.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ExchangeRateModel {

    @SerializedName("result")
    @Expose
    private Result result;

    /**
     * No args constructor for use in serialization
     * 
     */
    public ExchangeRateModel() {
    }

    /**
     * 
     * @param result
     */
    public ExchangeRateModel(Result result) {
        super();
        this.result = result;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

}
