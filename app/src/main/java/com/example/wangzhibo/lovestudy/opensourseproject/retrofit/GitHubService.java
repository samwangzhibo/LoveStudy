package com.example.wangzhibo.lovestudy.opensourseproject.retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Path;

/**
 * Created by samwangzhibo on 2019/3/4.
 */

public interface GitHubService {
    Call<List<String>> listRepos(@Path("user") String a );
}
