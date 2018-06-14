package org.dalol.RailsLoktraTask.base;

import org.dalol.RailsLoktraTask.model.Rails;
import org.dalol.RailsLoktraTask.service.RailsViewInterface;

import java.util.List;

import rx.Observer;

public class RailsPresenter extends BasePresenter implements Observer<List<Rails>> {

    private RailsViewInterface mViewInterface;

    public RailsPresenter(RailsViewInterface viewInterface) {
        mViewInterface = viewInterface;
    }

    @Override
    public void onCompleted() {
        mViewInterface.onCompleted();
    }

    @Override
    public void onError(Throwable e) {
        mViewInterface.onError(e.getMessage());
    }

    @Override
    public void onNext(List<Rails> rails) {
        mViewInterface.onRails(rails);

    }


    public void fetchRails() {
        unSubscribeAll();
        subscribe(mViewInterface.getRails(), RailsPresenter.this);
    }
}
