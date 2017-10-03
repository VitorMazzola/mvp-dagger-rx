package teste.mvp.com.apptestemvp.dagger;

import javax.inject.Singleton;

import dagger.Component;
import teste.mvp.com.apptestemvp.dagger.module.ApplicationModule;
import teste.mvp.com.apptestemvp.dagger.module.insfraestructure.ManagerModule;
import teste.mvp.com.apptestemvp.dagger.module.insfraestructure.NetworkModule;
import teste.mvp.com.apptestemvp.dagger.module.insfraestructure.ServiceModule;

/**
 * Created by softvaro on 29/09/17.
 */

@Singleton
@Component(modules = {
        ApplicationModule.class,
        NetworkModule.class,
        ServiceModule.class,
        ManagerModule.class
})
public interface DiComponent {
    UiComponent uiComponent();
}
