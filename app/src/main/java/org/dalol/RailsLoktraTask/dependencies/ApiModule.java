package org.dalol.RailsLoktraTask.dependencies;

import org.dalol.RailsLoktraTask.service.RailsService;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class ApiModule {

    @Provides
    @CustomScope
    RailsService provideFlowerService(Retrofit retrofit) {
        return retrofit.create(RailsService.class);
    }
}
