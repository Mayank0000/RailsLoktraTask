package org.dalol.RailsLoktraTask.application;

import android.app.Application;

import org.dalol.RailsLoktraTask.dependencies.ApiComponent;
import org.dalol.RailsLoktraTask.dependencies.DaggerApiComponent;
import org.dalol.RailsLoktraTask.dependencies.DaggerNetworkComponent;
import org.dalol.RailsLoktraTask.dependencies.NetworkComponent;
import org.dalol.RailsLoktraTask.dependencies.NetworkModule;
import org.dalol.RailsLoktraTask.model.Constant;

public class RailsApplication extends Application {

    private ApiComponent mApiComponent;

    @Override
    public void onCreate() {
        resolveDependency();
        super.onCreate();
    }

    private void resolveDependency() {
        mApiComponent = DaggerApiComponent.builder()
                .networkComponent(getNetworkComponent())
                .build();
    }

    public NetworkComponent getNetworkComponent() {
        return DaggerNetworkComponent.builder()
                .networkModule(new NetworkModule(Constant.BASE_URL))
                .build();
    }

    public ApiComponent getApiComponent() {
        return mApiComponent;
    }
}
