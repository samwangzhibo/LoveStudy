package com.example.wangzhibo.lovestudy.opensourseproject.retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * 使用说明 https://square.github.io/retrofit/
 *
 * Retrofit retrofit = new Retrofit.Builder()
 * .baseUrl("https://api.github.com/")
 * .build();
 * GitHubService service = retrofit.create(GitHubService.class);
 *
 * Call<List<Repo>> repos = service.listRepos("octocat");
 *
 * Created by samwangzhibo on 2019/3/4.
 */

public interface GitHubService {
    @GET("users/{user}/repos")
    Call<List<String>> listRepos(@Path("user") String a );
}
