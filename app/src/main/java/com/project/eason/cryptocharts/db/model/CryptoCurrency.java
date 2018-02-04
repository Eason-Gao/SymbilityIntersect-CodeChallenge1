package com.project.eason.cryptocharts.db.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.io.Serializable;

/**
 * Table for cryptocurrencies
 */

@Entity(tableName = "CryptoCurrencies",
    indices = {@Index(value = {"currency_id"},
	unique = true)})

public class CryptoCurrency implements Serializable
{
    @PrimaryKey
    @ColumnInfo(name = "currency_id")
    @NonNull
    private String id;

    @ColumnInfo(name = "currency_price")
    private Double price;

    // from past 24 hours
    @ColumnInfo(name = "currency_volume")
    private Double volume;

    // used for marking favourited currencies
    @ColumnInfo(name = "favourite")
    private Boolean isFavourite;

    @Ignore
    public CryptoCurrency(){}

    public CryptoCurrency(String id, Double price, Double volume) {
        super();

        this.id = id;
        this.price = price;
        this.volume = volume;
        this.isFavourite = false;
    }

    public String getId()
    {
	return id;
    }

    public void setId(String id)
    {
	this.id = id;
    }

    public Double getVolume()
    {
	return volume;
    }

    public void setVolume(Double volume)
    {
	this.volume = volume;
    }

    public Boolean getFavourite()
    {
	return isFavourite;
    }

    public void setFavourite(Boolean favourite)
    {
	isFavourite = favourite;
    }

    public Double getPrice()
    {
        return price;
    }

    public void setPrice(Double price)
    {
        this.price = price;
    }
}
