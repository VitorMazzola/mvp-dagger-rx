package teste.mvp.com.apptestemvp.dagger;

import dagger.Subcomponent;
import teste.mvp.com.apptestemvp.dagger.module.presentation.PresenterModule;
import teste.mvp.com.apptestemvp.dagger.scope.PerActivity;
import teste.mvp.com.apptestemvp.presentation.ui.MainActivity;

/**
 * Created by softvaro on 29/09/17.
 */

@PerActivity
@Subcomponent(modules = {PresenterModule.class})
public interface UiComponent {
    void inject(MainActivity activity);
}
