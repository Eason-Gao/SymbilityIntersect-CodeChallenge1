package com.project.eason.cryptocharts.db.model;

/**
 * Watchlist Pojo
 */

public class DefaultWatchList
{
    private String CoinIs;

    private String Sponsored;

    public String getCoinIs()
    {
	return CoinIs;
    }

    public void setCoinIs(String CoinIs)
    {
	this.CoinIs = CoinIs;
    }

    public String getSponsored()
    {
	return Sponsored;
    }

    public void setSponsored(String Sponsored)
    {
	this.Sponsored = Sponsored;
    }

    @Override
    public String toString()
    {
	return "ClassPojo [CoinIs = " + CoinIs + ", Sponsored = " + Sponsored + "]";
    }
}