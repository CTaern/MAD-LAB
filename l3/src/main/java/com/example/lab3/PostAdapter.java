package com.example.lab3;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class PostAdapter extends BaseAdapter{

    List<Post> posts;
    LayoutInflater layoutInflater;


    public PostAdapter(Activity activity, List<Post> posts){ this.posts = posts;
    layoutInflater = activity.getLayoutInflater();}
    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int i,View view, ViewGroup viewgroup){
        View row = layoutInflater.inflate(R.layout.row, null);
        EditText txtMessage = row.findViewById(R.id.txtMessage);
        TextView txtLocation = row.findViewById(R.id.txtLocation);
        ImageView imageView = row.findViewById(R.id.txtLocation);
        Post post = posts.get(i);
        txtMessage.setText(post.getMessage());
        imageView.setImageBitmap(post.getImage());
        if(post.getLocation() !=null){
            txtLocation.setText(post.getLocation().getLatitude() +" "+
                    post.getLocation().getLongitude());

        }

        return row;

    }
}
