package com.notebook.cvxt001122.unique;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Calendar;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerAdapter extends RecyclerView.Adapter<CardViewHolder> {
    private ArrayList<Model> bookList;
    private Context context;
    private LayoutInflater inflater;
    private OnMenuClick referenceContext;
    public RecyclerAdapter (Context context, ArrayList<Model> bookList, Activity mreferenceContext){
        this.context=context;
        this.bookList=bookList;
        inflater=LayoutInflater.from(context);
        this.referenceContext= (OnMenuClick) mreferenceContext;
    }
    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=inflater.inflate(R.layout.card_layout,viewGroup,false );
        return new CardViewHolder(view,context,referenceContext);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int i) {
        if(holder instanceof CardViewHolder){
            ((CardViewHolder) holder).bookName.setText(bookList.get(i).getBookName());
            DateHandler  handler=new DateHandler();
            String [] date=bookList.get(i).getIssuedDate().split("/", 3);
           // String returningdate=date[0]+"/"+(Integer.parseInt(date[1])+1)+"/"+date[2];
            ((CardViewHolder) holder).issuedDate.setText(date[0]+" "+handler.getMonthName(Integer.parseInt(date[1]))+", "+date[2]);
            date=bookList.get(i).getReturningDate().split("/", 3);
           //  returningdate=date[0]+"/"+(Integer.parseInt(date[1])+1)+"/"+date[2];
            ((CardViewHolder) holder).returningDate.setText(date[0]+" "+handler.getMonthName(Integer.parseInt(date[1]))+", "+date[2]);
            String bookid=bookList.get(i).getBookId();
            if(bookid==null||bookid.equals(""))
                bookid="NA";
            holder.bookId.setText(bookid);
            String value=bookList.get(i).getInterval();
            if(value==null)
                value="null";
            else if(value.equals("temp"))
            {
                value="Temporary";
            }else value="Permanent";
            ((CardViewHolder) holder).interval.setText(value);
        }
    }

    @Override
    public int getItemCount() {
        return bookList.size();
    }
}

