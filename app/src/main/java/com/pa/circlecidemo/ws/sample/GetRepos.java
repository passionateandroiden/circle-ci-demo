package com.pa.circlecidemo.ws.sample;

import com.pa.circlecidemo.ws.WebserviceCallBack;
import com.pa.circlecidemo.ws.WebserviceHelper;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;


public class GetRepos extends WebserviceHelper {

    public interface RepoEndPoints {
        @GET("users/{user}/repos")
        Call<List<Repo>> listRepos(@Path("user") String user);
    }

    public void getRepos(String userName, WebserviceCallBack callBack) {
        executeWebservice(createEndpoint(RepoEndPoints.class).listRepos(userName), callBack);
    }
}
