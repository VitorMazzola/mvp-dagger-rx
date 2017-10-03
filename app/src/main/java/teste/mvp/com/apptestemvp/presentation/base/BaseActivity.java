package teste.mvp.com.apptestemvp.presentation.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import teste.mvp.com.apptestemvp.MyApplication;
import teste.mvp.com.apptestemvp.dagger.UiComponent;

/**
 * Created by softvaro on 28/08/17.
 */

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    protected MyApplication getMyApplication() {
        return (MyApplication) getApplication();
    }

    protected UiComponent getDaggerUiComponent() {
        return this.getMyApplication().getDaggerUiComponent();
    }
}
