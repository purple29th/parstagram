package com.example.parstagram;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {

    ImageView ivPostImage;
    TextView tvUsername;
    TextView tvDescription;
    TextView tvTimestamp;

    Post post;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        post = getIntent().getParcelableExtra("post");

        ImageView ivPostImage = findViewById(R.id.ivPostImage);
        TextView tvUsername = findViewById(R.id.tvUsername);
        TextView tvDescription = findViewById(R.id.tvDescription);
        TextView tvTimestamp = findViewById(R.id.tvTimestamp);

        tvUsername.setText(post.getUser().getUsername());
        tvDescription.setText(post.getDescription());
        tvTimestamp.setText(post.getCreatedAt().toString());
        Glide.with(this).load(post.getImage().getUrl()).into(ivPostImage);
    }
}