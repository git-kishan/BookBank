package com.notebook.cvxt001122.unique;

import android.content.Context;
import android.text.Html;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class CardViewHolder extends RecyclerView.ViewHolder {
    TextView bookName,issuedDate,returningDate,interval,menuOption,bookId;
    CardView cardView;
    public CardViewHolder(@NonNull View itemView, final Context context, final OnMenuClick referenceContext) {
        super(itemView);
        bookName=itemView.findViewById(R.id.book_name);
        issuedDate=itemView.findViewById(R.id.issued_date);
        returningDate=itemView.findViewById(R.id.returning_date);
        interval=itemView.findViewById(R.id.interval);
        bookId=itemView.findViewById(R.id.book_id);

        menuOption=itemView.findViewById(R.id.menu_option);
        menuOption.setText(Html.fromHtml("&#8942;"));

        menuOption.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                final PopupMenu popupMenu=new PopupMenu(context,menuOption );
                popupMenu.getMenuInflater().inflate(R.menu.pop_up_menu,popupMenu.getMenu() );
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        if(menuItem.getItemId()==R.id.delete){
                            referenceContext.menuClicked(getAdapterPosition());
                        }
                        else if(menuItem.getItemId()==R.id.edit){
                            referenceContext.editClicked(getAdapterPosition());
                        }
                        return true;
                    }
                });
                popupMenu.show();
            }
        });
    }
}
interface OnMenuClick{
    void menuClicked(int position);
    void editClicked(int position);
}

