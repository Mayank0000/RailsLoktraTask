package org.dalol.RailsLoktraTask.service;

import org.dalol.RailsLoktraTask.model.Rails;

import java.util.List;

import rx.Observable;

public interface RailsViewInterface {

    void onCompleted();

    void onError(String message);

    void onRails(List<Rails> rails);

    Observable<List<Rails>> getRails();
}
