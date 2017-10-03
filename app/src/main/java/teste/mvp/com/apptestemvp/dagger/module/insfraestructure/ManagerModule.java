package teste.mvp.com.apptestemvp.dagger.module.insfraestructure;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import teste.mvp.com.apptestemvp.infraestructure.manager.MainManager;
import teste.mvp.com.apptestemvp.infraestructure.service.FipeService;
import teste.mvp.com.apptestemvp.domain.repositories.MainRepository;

/**
 * Created by softvaro on 29/09/17.
 */

@Module
public class ManagerModule {

    @Singleton
    @Provides
    MainRepository providesMainRepository(FipeService fipeService) {
        return new MainManager(fipeService);
    }
}
