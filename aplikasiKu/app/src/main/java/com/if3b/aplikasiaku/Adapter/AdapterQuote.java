package com.if3b.aplikasiaku.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.if3b.aplikasiaku.Model.QuotesModel;
import com.if3b.aplikasiaku.R;

import java.util.ArrayList;
import java.util.List;

public class AdapterQuote extends RecyclerView.Adapter<AdapterQuote.ViewHolderQuotes>  {
    private List<QuotesModel>listQuotes = new ArrayList<>();
    private Context ctx;

    public AdapterQuote(List<QuotesModel> listQuotes, Context ctx) {
        this.listQuotes = listQuotes;
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public ViewHolderQuotes onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderQuotes holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolderQuotes extends RecyclerView.ViewHolder{
    TextView tvQuotes,tvAuthor;

        public ViewHolderQuotes(@NonNull View itemView) {
            super(itemView);
            tvQuotes = itemView.findViewById(R.id.tv_quotes);
            tvAuthor = itemView.findViewById(R.id.tv_authors);
        }
    }
}
