package org.dalol.RailsLoktraTask.dependencies;

import org.dalol.RailsLoktraTask.ui.MainActivity;

import dagger.Component;

@CustomScope
@Component(modules = ApiModule.class, dependencies = NetworkComponent.class)
public interface ApiComponent {

    void inject(MainActivity activity);
}
