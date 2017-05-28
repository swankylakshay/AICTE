package com.knock.ashu.aicteandroid.models;

/**
 * Created by Ashu on 1/3/2017.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by cerebro on 28/10/16.
 */

public class Error {
    public static final int ERROR_CODE_NETWORK_ERROR = -9;
    public static final int ERROR_CODE_UNIDENTIFIED = -10;


    @SerializedName("errors")
    @Expose
    HashMap<String, String[]> error = null;

    @SerializedName("message")
    @Expose
    private String message;

    private String errorMessage;

    public Error() {
        this("Some error occured", ERROR_CODE_UNIDENTIFIED);
    }

    public Error(String message) {
        this(message, ERROR_CODE_UNIDENTIFIED);
    }

    public Error(String message, Integer code) {
        this.message = message;
    }

    public String getMessage() {
        if (errorMessage == null) {
            errorMessage = "";
            if (error != null) {
                for (Map.Entry<String, String[]> entry : error.entrySet()) {
                    for (String errorValue : entry.getValue()) {
                        errorMessage = errorMessage + "\n" + errorValue;
                    }
                }
            } else {
                errorMessage = message;
            }
        }
        return errorMessage;
    }

    public HashMap<String, String[]> getError() {
        return error;
    }
}