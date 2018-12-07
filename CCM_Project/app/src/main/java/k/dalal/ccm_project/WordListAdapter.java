/*
 * Copyright (C) 2017 Google Inc.
 */

package k.dalal.ccm_project;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.LinkedList;
import java.util.List;


/**
 * Shows how to implement a simple Adapter for a RecyclerView.
 * Demonstrates how to add a click handler for each item in the ViewHolder.
 */
public class WordListAdapter
        extends RecyclerView.Adapter<WordListAdapter.WordViewHolder> {
    String currentPosition = "-1";

    public String[] myProductName =
            {
                    "Mango",
                    "Apple",
                    "Banana"
            };


    //private final LinkedList<String> mWordList;
    //private  final LinkedList<Grocery> mGrocery = new LinkedList<Grocery>();
    public final List<Project> groceries;
    private final LayoutInflater mInflater;

    class WordViewHolder extends RecyclerView.ViewHolder
    {

        public final TextView wordItemView;

        public final TextView productPrice;
        public final TextView productWeight;

        public  final CardView cardView;

        final WordListAdapter mAdapter;



        /**
         * Creates a new custom view holder to hold the view to display
         * in the RecyclerView.
         *
         * @param itemView The view in which to display the data.
         * @param adapter The adapter that manages the the data and
         *                views for the RecyclerView.
         */
        public WordViewHolder(final View itemView, WordListAdapter adapter) {
            super(itemView);
            cardView = (CardView) itemView.findViewById(R.id.card_view);
            cardView.setCardBackgroundColor(Color.parseColor("#a4c639"));
            //cardView.setCardElevation((float)20);
            //cardView.setRadius((float)20);
            // Product Name
            wordItemView = (TextView) itemView.findViewById(R.id.projectName);

            // Product Price
            productPrice = (TextView) itemView.findViewById(R.id.projectDescription);
            // Product Weight
            productWeight = (TextView) itemView.findViewById(R.id.projectSize);




            this.mAdapter = adapter;

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Toast.makeText(itemView.getContext(), myProductName[getAdapterPosition()], Toast.LENGTH_LONG).show();
                }
            });



            //itemView.setOnClickListener(this);
        }




    }


    public WordListAdapter(Context context, List<Project> groceries) {
        mInflater = LayoutInflater.from(context);
        this.groceries = groceries;
    }

    /**
     * Inflates an item view and returns a new view holder that contains it.
     * Called when the RecyclerView needs a new view holder to represent an item.
     *
     * @param parent The view group that holds the item views.
     * @param viewType Used to distinguish views, if more than one
     *                 type of item view is used.
     * @return a view holder.
     */
    @Override
    public WordViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Inflate an item view.
        View itemView = mInflater.inflate(R.layout.view_item, parent, false);
        return new WordViewHolder(itemView, this);
    }

    /**
     * Sets the contents of an item at a given position in the RecyclerView.
     *
     * @param holder The view holder for that position in the RecyclerView.
     * @param position The position of the item in the RecycerView.
     */
    @Override
    public void onBindViewHolder(WordViewHolder holder, int position) {
        // Retrieve the data for that position.
        //String current = mWordList.get(position);
        holder.wordItemView.setText(groceries.get(position).getProjectName());

        holder.productPrice.setText(groceries.get(position).getProjectDescription());
        holder.productWeight.setText(groceries.get(position).getProjectSize());


        // Add the data to the view holder.
        //holder.wordItemView.setText(current);


    }

    /**
     * Returns the size of the container that holds the data.
     *
     * @return Size of the list of data.
     */
    @Override
    public int getItemCount() {
        return groceries.size();
    }
}


