package teste.mvp.com.apptestemvp.domain.repositories;

import java.util.List;

import io.reactivex.Observable;
import teste.mvp.com.apptestemvp.domain.entities.Marca;

/**
 * Created by softvaro on 29/09/17.
 */

public interface MainRepository {

    Observable<List<Marca>> getMarcas();
}
