package com.project.eason.cryptocharts.activity;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.project.eason.cryptocharts.Adapter.CurrencyAdapter;
import com.project.eason.cryptocharts.CryptoCharts;
import com.project.eason.cryptocharts.R;
import com.project.eason.cryptocharts.asynctask.CurrencyAsyncTask;
import com.project.eason.cryptocharts.db.model.CryptoCurrency;
import com.project.eason.cryptocharts.viewmodel.CryptoCurrencyViewModel;
import com.project.eason.cryptocharts.viewmodel.CurrencyViewModelFactory;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Inject
    CurrencyViewModelFactory currencyViewModelFactory;

    @BindView(R.id.currencies_recycler)
    RecyclerView recyclerView;

    private CurrencyAdapter adapter;

    private List<CryptoCurrency> currencies = new ArrayList<>();

    private CryptoCurrencyViewModel cryptoCurrencyViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ((CryptoCharts) getApplication()).getAppComponent().inject(this);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        setupViewModel();
        SetupCurrencyRecycler();
    }

    private void setupViewModel()
    {
        cryptoCurrencyViewModel = ViewModelProviders.of(this, currencyViewModelFactory).get(CryptoCurrencyViewModel.class);
    }

    private void SetupCurrencyRecycler()
    {
        currencies = cryptoCurrencyViewModel.getCurrencyListFromDb().getValue();

        adapter = new CurrencyAdapter(currencies);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}
