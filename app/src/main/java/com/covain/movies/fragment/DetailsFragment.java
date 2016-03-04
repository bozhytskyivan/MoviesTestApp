package com.covain.movies.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.covain.movies.Constants;
import com.covain.movies.model.MovieModel;
import com.covain.movies.movies.R;
import com.squareup.picasso.Picasso;

import butterknife.Bind;
import butterknife.ButterKnife;

public class DetailsFragment extends BaseFragment {

    @Bind(R.id.poster_image_view)
    ImageView mBackdropImageView;
    @Bind(R.id.title_text_view)
    TextView mTitleTextView;
    @Bind(R.id.rating_text_view)
    TextView mRatingTextView;
    @Bind(R.id.votes_count_text_view)
    TextView mVotesCountTextView;
    @Bind(R.id.votes_average_text_view)
    TextView mVotesAverageTextView;
    @Bind(R.id.overview_text_view)
    TextView mOverviewTextVeiw;

    private MovieModel mModel;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_details, container, false);
        ButterKnife.bind(this, view);
        if (mMainActivity.getSupportActionBar() != null) {
            mMainActivity.getSupportActionBar().setTitle(getResources().getString(R.string.details));
        }
        mModel = getArguments().getParcelable(Constants.MOVIE_MODEL);
        initViews();
        return view;
    }

    private void initViews() {
        Picasso.with(mMainActivity)
                .load(Constants.IMAGE_BASE_PATH + mModel.getPosterUrl())
                .into(mBackdropImageView);
        mTitleTextView.setText(mModel.getTitle());
        mRatingTextView.setText(mModel.getRating());
        mVotesCountTextView.setText(mModel.getVotesCount());
        mVotesAverageTextView.setText(mModel.getVotes_Average());
        mOverviewTextVeiw.setText(mModel.getOverview());
    }
}
