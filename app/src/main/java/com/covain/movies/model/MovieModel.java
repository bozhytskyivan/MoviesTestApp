package com.covain.movies.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class MovieModel implements Parcelable {

    @SerializedName("title")
    private String title;
    @SerializedName("poster_path")
    private String posterUrl;
    @SerializedName("popularity")
    private String rating;
    @SerializedName("overview")
    private String overview;
    @SerializedName("vote_count")
    private String votesCount;
    @SerializedName("vote_average")
    private String votes_Average;

    protected MovieModel(Parcel in) {
        title = in.readString();
        posterUrl = in.readString();
        rating = in.readString();
        overview = in.readString();
        votesCount = in.readString();
        votes_Average = in.readString();
    }

    public static final Creator<MovieModel> CREATOR = new Creator<MovieModel>() {
        @Override
        public MovieModel createFromParcel(Parcel in) {
            return new MovieModel(in);
        }

        @Override
        public MovieModel[] newArray(int size) {
            return new MovieModel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(posterUrl);
        dest.writeString(rating);
        dest.writeString(overview);
        dest.writeString(votesCount);
        dest.writeString(votes_Average);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPosterUrl() {
        return posterUrl;
    }

    public void setPosterUrl(String posterUrl) {
        this.posterUrl = posterUrl;
    }

    public String getRating() {
        return "Rating: " + rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getVotesCount() {
        return "Votes: " + votesCount;
    }

    public void setVotesCount(String votesCount) {
        this.votesCount = votesCount;
    }

    public String getVotes_Average() {
        return "Votes average: " + votes_Average;
    }

    public void setVotes_Average(String votes_Average) {
        this.votes_Average = votes_Average;
    }
}
