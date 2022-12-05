package com.if3b.aplikasiaku.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
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
        View varView = LayoutInflater.from(ctx).inflate(R.layout.item_quote, parent, false);
        return new ViewHolderQuotes(varView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderQuotes holder, int position) {
        QuotesModel qm = listQuotes.get(position);
        holder.tvQuotes.setText(qm.getText());
        holder.tvAuthor.setText(qm.getAuthor());

    }

    @Override
    public int getItemCount() {
        return listQuotes.size();
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
