package teste.mvp.com.apptestemvp.dagger.module.insfraestructure;

import javax.inject.Named;
import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import teste.mvp.com.apptestemvp.infraestructure.service.FipeService;

import static teste.mvp.com.apptestemvp.dagger.module.insfraestructure.NetworkModule.RETROFIT_FIPE;

/**
 * Created by softvaro on 29/09/17.
 */

@Module
public class ServiceModule {

    @Singleton
    @Provides
    FipeService providesFipeMarcas(@Named(RETROFIT_FIPE) Retrofit retrofit) {
        return retrofit.create(FipeService.class);
    }
}
