package com.example.roleplaymanagement.recycler;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.roleplaymanagement.R;
import com.example.roleplaymanagement.entity.Item;

import java.util.ArrayList;

public class CardItemViewAdapter extends RecyclerView.Adapter<CardItemViewAdapter.ViewHolder> {

    private ArrayList<Item> localDataSet;
    private int position;

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textView;
        private final TextView weight;


        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View

            textView = (TextView) view.findViewById(R.id.name);
            weight = (TextView) view.findViewById(R.id.weight);
        }
        public TextView getTextView() {
            return textView;
        }
        public TextView getWeight() {
            return weight;
        }

    }

    /**
     * Initialize the dataset of the Adapter.
     *
     * @param dataSet String[] containing the data to populate views to be used
     * by RecyclerView.
     */
    public CardItemViewAdapter(ArrayList<Item> dataSet) {
        localDataSet = dataSet;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.recycler_view_item_object, viewGroup, false);

        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        this.position = position;
        viewHolder.getTextView().setText(localDataSet.get(position).getName());
        viewHolder.getWeight().setText(String.valueOf(localDataSet.get(position).getWeight()));

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return localDataSet.size();
    }


    public int getPosition() {
        return position;
    }

    public ArrayList<Item> getItem() {
        return localDataSet;
    }


}

