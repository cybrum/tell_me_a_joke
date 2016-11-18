/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package com.udacity.nanodegree.backend;

import com.example.JokesLibrary;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

import javax.inject.Named;

/** An endpoint class we are exposing */
@Api(
  name = "myApi",
  version = "v1",
  namespace = @ApiNamespace(
    ownerDomain = "backend.nanodegree.udacity.com",
    ownerName = "backend.nanodegree.udacity.com",
    packagePath=""
  )
)
public class MyEndpoint {

    /** A simple endpoint method that takes a joke from javalib */
    @ApiMethod(name = "getJokeFromLib")
    public MyBean getJokeFromLib() {
        JokesLibrary joke = new JokesLibrary();
        MyBean response = new MyBean();
        response.setData(joke.getJoke());

        return response;
    }
}
