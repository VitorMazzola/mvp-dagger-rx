package teste.mvp.com.apptestemvp.presentation.ui;

import java.util.List;

import teste.mvp.com.apptestemvp.domain.entities.Marca;

/**
 * Created by softvaro on 29/09/17.
 */

public interface MainContract {

    interface View {
        void showProgress();

        void hideProgress();

        void makeToast(String message);

        void updateMarcas(List<Marca> marcas);

        void refreshList();

        void stopRefresh();
    }

    interface Presenter {
        void setView(MainContract.View view);

        void callGetMarcas();
    }
}
