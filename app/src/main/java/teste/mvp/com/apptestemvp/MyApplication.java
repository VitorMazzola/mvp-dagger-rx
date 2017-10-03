package teste.mvp.com.apptestemvp;

import android.app.Application;

import teste.mvp.com.apptestemvp.dagger.DaggerDiComponent;
import teste.mvp.com.apptestemvp.dagger.DiComponent;
import teste.mvp.com.apptestemvp.dagger.UiComponent;
import teste.mvp.com.apptestemvp.dagger.module.ApplicationModule;

/**
 * Created by softvaro on 29/09/17.
 */

public class MyApplication extends Application {

    private DiComponent mDiComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mDiComponent = DaggerDiComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public UiComponent getDaggerUiComponent() {
        return mDiComponent.uiComponent();
    }
}
