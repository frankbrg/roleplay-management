package com.example.roleplaymanagement.recycler;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.roleplaymanagement.R;
import com.example.roleplaymanagement.entity.Character;

import java.util.ArrayList;
import java.util.List;

public class CardCharacterViewAdapter extends RecyclerView.Adapter<CardCharacterViewAdapter.ViewHolder> {
    private ItemClickListener mClickListener;
    private ArrayList<Character> localDataSet;

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final TextView textView;
        private final TextView inventory;
        private final ImageButton editButton;
        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View

            textView = (TextView) view.findViewById(R.id.name);
            inventory = (TextView) view.findViewById(R.id.inventory);
            editButton=(ImageButton) view.findViewById(R.id.imageButton);
            editButton.setOnClickListener(this);
        }
        public TextView getTextView() {
            return textView;
        }
        public TextView getInventory() {
            return inventory;
        }

        @Override
        public void onClick(View v) {
            if(mClickListener != null) mClickListener.onItemClick(v, getAdapterPosition());
        }
    }

    /**
     * Initialize the dataset of the Adapter.
     *
     * @param dataSet String[] containing the data to populate views to be used
     * by RecyclerView.
     */
    public CardCharacterViewAdapter(ArrayList<Character> dataSet) {
        localDataSet = dataSet;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.recycler_view_item, viewGroup, false);

        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.getTextView().setText(localDataSet.get(position).getName());
        viewHolder.getInventory().setText(localDataSet.get(position).getInventoryUsedSize()+" / "+ localDataSet.get(position).getInventorySize());

    }

    // convenience method for getting data at click position
    public Character getItem(int id) {
        return localDataSet.get(id);
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return localDataSet.size();
    }

    public void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    public interface ItemClickListener{
        void onItemClick(View view, int position);
    }

}

