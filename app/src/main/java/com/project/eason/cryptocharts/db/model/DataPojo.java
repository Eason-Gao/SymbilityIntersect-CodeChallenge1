package com.project.eason.cryptocharts.db.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Eason on 2018-02-04.
 */

public class DataPojo
{
    @SerializedName("Response")
    @Expose
    private ArrayList<CurrencyAPIPojo> currencyAPIPojo;

    public ArrayList<CurrencyAPIPojo> getCurrencyAPIPojo()
    {
	return currencyAPIPojo;
    }

    public void setCurrencyAPIPojo(ArrayList<CurrencyAPIPojo> currencyAPIPojo)
    {
	this.currencyAPIPojo = currencyAPIPojo;
    }
}
