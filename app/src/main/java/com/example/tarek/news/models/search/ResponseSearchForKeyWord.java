/*
 * Copyright 2019 tarekmabdallah91@gmail.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.tarek.news.models.search;

import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

public class ResponseSearchForKeyWord {

    @SerializedName("response")
    private Response response;

    public void setResponse(Response response) {
        this.response = response;
    }

    public Response getResponse() {
        return response;
    }

    @NonNull
    @Override
    public String toString() {
        return
                "ResponseSearchForKeyWord{" +
                        "response = '" + response + '\'' +
                        "}";
    }
}