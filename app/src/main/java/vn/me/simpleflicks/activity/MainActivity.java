package vn.me.simpleflicks.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import vn.me.simpleflicks.R;
import vn.me.simpleflicks.adapter.MovieAdapter;
import vn.me.simpleflicks.api.MovieApi;
import vn.me.simpleflicks.model.NowPlaying;
import vn.me.simpleflicks.utils.RetrofitUtil;

public class MainActivity extends AppCompatActivity {

    private ProgressBar pbLoading;
    private ListView lvMovies;
    private MovieApi movieApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pbLoading = (ProgressBar) findViewById(R.id.pbLoading);
        lvMovies = (ListView) findViewById(R.id.lvMovies);

        movieApi = RetrofitUtil.get(getString(R.string.api_key)).create(MovieApi.class);
        fetchMovies();
    }

    private void fetchMovies() {
        movieApi.getNowPlaying().enqueue(new Callback<NowPlaying>() {
            @Override
            public void onResponse(Call<NowPlaying> call, Response<NowPlaying> response) {
                // TODO use notifyDataSetChanged();
                handleResponse(response);
            }

            @Override
            public void onFailure(Call<NowPlaying> call, Throwable t) {
                Log.e("Api", t.getMessage());
            }
        });
    }

    private void handleResponse(Response<NowPlaying> response) {
        lvMovies.setAdapter(new MovieAdapter(this, response.body().getMovies()));
        pbLoading.setVisibility(View.GONE);
    }
}
