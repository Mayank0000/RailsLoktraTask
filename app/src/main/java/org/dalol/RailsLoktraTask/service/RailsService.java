package org.dalol.RailsLoktraTask.service;

import org.dalol.RailsLoktraTask.model.Rails;

import java.util.List;

import retrofit2.http.GET;
import rx.Observable;

public interface RailsService {

    @GET("commits")
    Observable<List<Rails>> getRails();
}
