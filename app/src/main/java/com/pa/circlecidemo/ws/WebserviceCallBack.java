package com.pa.circlecidemo.ws;

/**
 * Created by rohithravindran on 02/01/17.
 */

public interface WebserviceCallBack {

    void onSuccess(Object reponse);
    void onError(String errorCode);
    void onFailed(String response);
}
