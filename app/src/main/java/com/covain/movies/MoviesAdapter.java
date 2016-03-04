package com.covain.movies;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.covain.movies.activity.MainActivity;
import com.covain.movies.fragment.DetailsFragment;
import com.covain.movies.model.MovieModel;
import com.covain.movies.movies.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MovieViewHolder> {

    private List<MovieModel> mMovies;
    private Context mContext;

    public MoviesAdapter(Context context) {
        mContext = context;
    }

    public void setData(List<MovieModel> movies) {
        mMovies = movies;
        notifyDataSetChanged();
    }

    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MovieViewHolder(LayoutInflater
                .from(mContext)
                .inflate(R.layout.view_movie_preview, parent, false));
    }

    @Override
    public void onBindViewHolder(MovieViewHolder holder, int position) {
        holder.setData(mMovies.get(position));
    }

    @Override
    public int getItemCount() {
        return mMovies == null ? 0 : mMovies.size();
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder {

        ImageView moviePoster;
        MovieModel movieModel;

        public MovieViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(onMovieSelected);
            moviePoster = (ImageView) itemView.findViewById(R.id.movie_image_view);
        }

        public void setData(MovieModel movie) {
            movieModel = movie;
            Picasso.with(mContext)
                    .load(Constants.IMAGE_BASE_PATH + movie.getPosterUrl())
                    .into(moviePoster);
        }

        View.OnClickListener onMovieSelected = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DetailsFragment detailsFragment = new DetailsFragment();
                Bundle bundle = new Bundle();
                bundle.putParcelable(Constants.MOVIE_MODEL, movieModel);
                detailsFragment.setArguments(bundle);
                ((MainActivity) mContext).switchFragment(detailsFragment);
            }
        };

    }
}
