package teste.mvp.com.apptestemvp.infraestructure.manager;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import teste.mvp.com.apptestemvp.infraestructure.service.FipeService;
import teste.mvp.com.apptestemvp.domain.entities.Marca;
import teste.mvp.com.apptestemvp.domain.repositories.MainRepository;

/**
 * Created by softvaro on 29/09/17.
 */

public class MainManager implements MainRepository {

    private final FipeService mFipeService;

    @Inject
    public MainManager(FipeService mFipeService) {
        this.mFipeService = mFipeService;
    }

    @Override
    public Observable<List<Marca>> getMarcas() {
        return mFipeService.getMarcas()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
