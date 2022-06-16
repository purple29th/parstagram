package com.example.parstagram;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

// Create the basic adapter extending from RecyclerView.Adapter
// Note that we specify the custom ViewHolder which gives us access to our views
public class PostsAdapter extends
        RecyclerView.Adapter<PostsAdapter.ViewHolder> {

    // Store a member variable for the contacts
    public List<Post> mPosts = new ArrayList<>();

    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    public class ViewHolder extends RecyclerView.ViewHolder {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        public TextView tvUsername;
        public TextView tvTime;
        public TextView tvDescription;
        public ImageView ivPhoto;

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);

            tvUsername = (TextView) itemView.findViewById(R.id.tvUsername);
            tvDescription = (TextView) itemView.findViewById(R.id.tvDescription);
            tvTime = (TextView) itemView.findViewById(R.id.tvTime);
            ivPhoto = (ImageView) itemView.findViewById(R.id.ivPhoto);
        }
    }


    // Usually involves inflating a layout from XML and returning the holder
    @Override
    public PostsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.item_post, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    // Involves populating data into the item through holder
    @Override
    public void onBindViewHolder(PostsAdapter.ViewHolder holder, int position) {
        // Get the data model based on position
        Post post = mPosts.get(position);

        // Set item views based on your views and data model
        holder.tvUsername.setText(post.getUser().getUsername());
        holder.tvTime.setText(post.getCreatedAt().toString());
        holder.tvDescription.setText(post.getDescription());
    }

    // Returns the total count of items in the list
    @Override
    public int getItemCount() {
        return mPosts.size();
    }
}
