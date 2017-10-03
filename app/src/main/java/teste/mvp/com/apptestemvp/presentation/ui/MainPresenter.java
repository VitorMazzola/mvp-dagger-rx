package teste.mvp.com.apptestemvp.presentation.ui;


import teste.mvp.com.apptestemvp.domain.repositories.MainRepository;

/**
 * Created by softvaro on 28/08/17.
 */

public class MainPresenter implements MainContract.Presenter {

    private MainContract.View mView;
    private MainRepository mMainRepository;

    public MainPresenter(MainRepository mainRepository) {
        mMainRepository = mainRepository;
    }

    @Override
    public void setView(MainContract.View view) {
        mView = view;
    }

    @Override
    public void callGetMarcas() {
        //mView.showProgress();
        mMainRepository.getMarcas()
                .subscribe( entities -> {
                    mView.updateMarcas(entities);
                    mView.stopRefresh();
                    //mView.hideProgress();
                }, error -> {
                    //mView.hideProgress();
                    mView.makeToast(error.getMessage());
                    mView.stopRefresh();
                });

    }
}
