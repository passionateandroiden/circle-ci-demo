package com.pa.circlecidemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.pa.circlecidemo.ws.WebserviceCallBack;
import com.pa.circlecidemo.ws.sample.GetRepos;
import com.pa.circlecidemo.ws.sample.Repo;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ListView reposLV = (ListView) findViewById(R.id.listGitRepos);

        new GetRepos().getRepos("passionateandroiden", new WebserviceCallBack() {
            @Override
            public void onSuccess(Object reponse) {
                List<Repo> repoList = (List<Repo>) reponse;
                reposLV.setAdapter(new ArrayAdapter<Repo>(getApplicationContext(),
                        android.R.layout.simple_list_item_1, repoList));
            }

            @Override
            public void onError(String errorCode) {

            }

            @Override
            public void onFailed(String response) {

            }
        });
    }
}
