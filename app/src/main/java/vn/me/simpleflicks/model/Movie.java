package vn.me.simpleflicks.model;

import com.google.gson.annotations.SerializedName;

import vn.me.simpleflicks.utils.Constants;

public class Movie {

    @SerializedName("title")
    private String title;

    @SerializedName("overview")
    private String overview;

    @SerializedName("poster_path")
    private String posterPath;

    @SerializedName("backdrop_path")
    private String backdropPath;

    public String getTitle() {
        return title;
    }

    public String getOverview() {
        return overview;
    }

    public String getPosterPath() {
        return Constants.IMAGE_URL + posterPath;
    }

    public String getBackdropPath() {
        return Constants.IMAGE_URL + backdropPath;
    }
}
