package com.pa.circlecidemo;

import com.pa.circlecidemo.ws.WebserviceCallBack;
import com.pa.circlecidemo.ws.WebserviceHelper;
import com.pa.circlecidemo.ws.sample.GetRepos;
import com.pa.circlecidemo.ws.sample.Repo;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

/**
 * Created by rohithravindran on 02/01/17.
 */

public class RetrofitTest {

    @Test
    public void retrofitTest() {
        GetRepos getRepos = new GetRepos();
        getRepos.getRepos("passionateandroiden", new WebserviceCallBack() {
            @Override
            public void onSuccess(Object reponse) {
                List<Repo> repoList = (List<Repo>) reponse;
                System.out.println(repoList.size());
            }

            @Override
            public void onError(String errorCode) {
                System.out.println(errorCode);

            }

            @Override
            public void onFailed(String response) {
                System.out.println(response);

            }
        });
    }
}
