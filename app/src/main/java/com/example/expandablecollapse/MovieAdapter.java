package com.example.expandablecollapse;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.List;

/*public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MyViewHolder> {

    private Context mContext;
    private List<Movie> movieList;


    public MovieAdapter(Context mContext, List<Movie> movieList){
        this.mContext = mContext;
        this.movieList = movieList;
    }

    @Override
    public MovieAdapter.MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i){
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.layout_movie, viewGroup, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MovieAdapter.MyViewHolder viewHolder, final int i){
        Movie movie = movieList.get(i);
        viewHolder.name.setText(movieList.get(i).getName());
        viewHolder.category.setText(movieList.get(i).getCategory());

        //Picasso.get().load(movieList.get(i).getImageurl()).into(viewHolder.thumbnail);


        Glide.with(mContext).load(movieList.get(i).getImageurl()).into(viewHolder.thumbnail);
    }

    @Override
    public int getItemCount(){
        return movieList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView name, category;
        public ImageView thumbnail;

        public MyViewHolder(View view){
            super(view);
            name = (TextView) view.findViewById(R.id.name);
            category = (TextView) view.findViewById(R.id.category);
            thumbnail = (ImageView) view.findViewById(R.id.thumbnail);




        }
    }
}*/
public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    private List<Movie> movieList;
    private Context context;



    public MovieAdapter(List<Movie> movieList, Context context) {
        this.movieList = movieList;
        this.context = context;
    }

    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_movie, parent, false);
        return new MovieViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {

        Movie movie = movieList.get(position);
        //String imageUrl = movie.getImageurl();


        holder.name.setText(movie.getImageurl());
        holder.category.setText(movie.getCategory());

        String imageUrl = movie.getImageurl();
        System.out.println("data::::"+imageUrl);



      String data12= movie.getName();

        String data123= movie.getCategory();;


        String data1 = "http://velmm.com/images/bottom_navigationview/wonder.jpg";



        Glide.with(context).load(data12).into(holder.poster);

    }



    @Override
    public int getItemCount() {
        return movieList.size();
    }

    class MovieViewHolder extends RecyclerView.ViewHolder {
        TextView name, category;
         ImageView poster;

        MovieViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.name);
            category = (TextView) itemView.findViewById(R.id.category);
            poster = (ImageView) itemView.findViewById(R.id.thumbnail);




        }
    }
}
