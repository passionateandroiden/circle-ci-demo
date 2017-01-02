package com.pa.circlecidemo.ws;

//import android.util.Log;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class WebserviceHelper {

    private Retrofit retrofit;

    public WebserviceHelper () {
        retrofit = RetrofitHelper.getInstance();
    }

    protected <T> T createEndpoint(Class<T> endpoint) {
        return retrofit.create(endpoint);
    }

    public <T> void executeWebservice(Call<T> retroCall, final WebserviceCallBack callBack) {
        try {
            retroCall.enqueue(new Callback<T>() {
                @Override
                public void onResponse(Call<T> call, Response<T> response) {
                    callBack.onSuccess(response.body());
                }

                @Override
                public void onFailure(Call<T> call, Throwable t) {
                    callBack.onFailed(t.getMessage());
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
            callBack.onError(e.getMessage());
        }
    }


}
