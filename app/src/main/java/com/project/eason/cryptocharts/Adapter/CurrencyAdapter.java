package com.project.eason.cryptocharts.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.project.eason.cryptocharts.R;
import com.project.eason.cryptocharts.db.model.CryptoCurrency;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Adapter for currencies recyclerview
 */

public class CurrencyAdapter extends RecyclerView.Adapter<CurrencyAdapter.ViewHolder>
{
    List<CryptoCurrency> currencies;

    public CurrencyAdapter(List<CryptoCurrency> currencies)
    {
        this.currencies = currencies;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
	View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.currency_recycler_item, parent, false);
	return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(CurrencyAdapter.ViewHolder holder, int position)
    {
        holder.currencyName.setText(currencies.get(position).getCoinName());
    }

    @Override
    public int getItemCount()
    {
	return currencies.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        @BindView(R.id.currency_name)
	TextView currencyName;

	public ViewHolder(View itemView)
	{
	    super(itemView);
	    ButterKnife.bind(this, itemView);
	}
    }
}
