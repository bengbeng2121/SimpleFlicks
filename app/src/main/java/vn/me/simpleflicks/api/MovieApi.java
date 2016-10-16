package vn.me.simpleflicks.api;

import retrofit2.Call;
import retrofit2.http.GET;
import vn.me.simpleflicks.model.NowPlaying;

public interface MovieApi {

    @GET("now_playing")
    Call<NowPlaying> getNowPlaying();

    @GET("popular")
    Call<NowPlaying> getPopular();
}
