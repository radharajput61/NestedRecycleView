package com.example.nestedrecycleview;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class ChildItemAdapter
        extends RecyclerView
        .Adapter<ChildItemAdapter.ChildViewHolder> {

    private List<ChildItem> ChildItemList;
Context context;
    // Constructor
    ChildItemAdapter(List<ChildItem> childItemList, Context context)
    {
        this.ChildItemList = childItemList;
        this.context = context;
    }

    @NonNull
    @Override
    public ChildViewHolder onCreateViewHolder(
            @NonNull ViewGroup viewGroup,
            int i)
    {

        // Here we inflate the corresponding
        // layout of the child item
        View view = LayoutInflater
                .from(viewGroup.getContext())
                .inflate(
                        R.layout.child_item,
                        viewGroup, false);

        return new ChildViewHolder(view);
    }

    @Override
    public void onBindViewHolder(
            @NonNull ChildViewHolder childViewHolder,
            int position)
    {

        // Create an instance of the ChildItem
        // class for the given position
        ChildItem childItem
                = ChildItemList.get(position);

        // For the created instance, set title.
        // No need to set the image for
        // the ImageViews because we have
        // provided the source for the images
        // in the layout file itself
        childViewHolder
                .ChildItemTitle
                .setText(childItem.getChildItemTitle());
        Glide.with(context)
                .load(childItem.getImage()).placeholder(R.drawable.ic_launcher_foreground)
                .into(childViewHolder.image);
        Log.e("url",childItem.getImage());
    }

    @Override
    public int getItemCount()
    {

        // This method returns the number
        // of items we have added
        // in the ChildItemList
        // i.e. the number of instances
        // of the ChildItemList
        // that have been created
        return ChildItemList.size();
    }

    // This class is to initialize
    // the Views present
    // in the child RecyclerView
    class ChildViewHolder
            extends RecyclerView.ViewHolder {

        TextView ChildItemTitle;
        ImageView image;

        ChildViewHolder(View itemView)
        {
            super(itemView);
            ChildItemTitle = itemView.findViewById(R.id.child_item_title);
            image = itemView.findViewById(R.id.img_child_item);
        }
    }
}

