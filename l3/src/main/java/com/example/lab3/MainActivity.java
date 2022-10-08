package com.example.lab3;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {



    ListView listView;


    List<Post> posts = new ArrayList<Post>();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        listView.findViewById(R.id.listView);
        PostAdapter adapter = new PostAdapter(this, posts);
        listView.setAdapter(adapter);


        Button btnPost = findViewById(R.id.btnPost);
        btnPost.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(MainActivity.this, PostActivity.class);
                launcher.launch(intent);
            }
        });

    }

    final ActivityResultLauncher<Intent> launcher = registerForActivityResult(
           new ActivityResultContracts.StartActivityForResult(),
           new ActivityResultCallback<ActivityResult>() {
               @Override
               public void onActivityResult(ActivityResult result) {
                   if(result.getResultCode() == Activity.RESULT_OK){
                       Intent data = result.getData();
                       Post post = new Post();
                       post.setMessage(data.getCharSequenceExtra("msg").toString());
                       post.setImage((Bitmap) data.getParcelableExtra("bitmap"));
                       posts.add(post);
                       ((PostAdapter) listView.getAdapter()).notifyDataSetChanged();
                   }
               }



           });


}