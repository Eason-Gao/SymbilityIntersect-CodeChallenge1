package com.project.eason.cryptocharts.db.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Eason on 2018-02-04.
 */

public class MainPojo
{
    @SerializedName("Response")
    @Expose
    private String response;

    @SerializedName("Message")
    @Expose
    private String message;

    @SerializedName("BaseImageUrl")
    @Expose
    private String baseImageUrl;

    @SerializedName("BaseLinkUrl")
    @Expose
    private String baseLinkUrl;

    @SerializedName("DefaultWatchlist")
    @Expose
    private DefaultWatchList defaultWatchlist;

    @SerializedName("Data")
    @Expose
    private DataPojo data;

    public String getResponse()
    {
	return response;
    }

    public void setResponse(String response)
    {
	this.response = response;
    }

    public String getMessage()
    {
	return message;
    }

    public void setMessage(String message)
    {
	this.message = message;
    }

    public String getBaseImageUrl()
    {
	return baseImageUrl;
    }

    public void setBaseImageUrl(String baseImageUrl)
    {
	this.baseImageUrl = baseImageUrl;
    }

    public String getBaseLinkUrl()
    {
	return baseLinkUrl;
    }

    public void setBaseLinkUrl(String baseLinkUrl)
    {
	this.baseLinkUrl = baseLinkUrl;
    }

    public DefaultWatchList getDefaultWatchlist()
    {
	return defaultWatchlist;
    }

    public void setDefaultWatchlist(DefaultWatchList defaultWatchlist)
    {
	this.defaultWatchlist = defaultWatchlist;
    }

    public DataPojo getData()
    {
	return data;
    }

    public void setData(DataPojo data)
    {
	this.data = data;
    }
}