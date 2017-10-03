package teste.mvp.com.apptestemvp.dagger.module.presentation;

import dagger.Module;
import dagger.Provides;
import teste.mvp.com.apptestemvp.dagger.scope.PerActivity;
import teste.mvp.com.apptestemvp.domain.repositories.MainRepository;
import teste.mvp.com.apptestemvp.presentation.ui.MainContract;
import teste.mvp.com.apptestemvp.presentation.ui.MainPresenter;

/**
 * Created by softvaro on 29/09/17.
 */

@Module
public class PresenterModule {

    @PerActivity
    @Provides
    MainContract.Presenter providesMainPresenter (MainRepository mainRepository) {
        return new MainPresenter(mainRepository);
    }

}
