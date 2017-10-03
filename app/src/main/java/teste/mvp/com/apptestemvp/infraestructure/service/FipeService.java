package teste.mvp.com.apptestemvp.infraestructure.service;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

import teste.mvp.com.apptestemvp.domain.entities.Marca;

/**
 * Created by softvaro on 28/08/17.
 */

public interface FipeService {

    //String BASE_URL = "http://fipeapi.appspot.com/api/1/";
    String BASE_URL = "http://demo6654265.mockable.io/";

    @GET("carros/marcas.json")
    Observable<List<Marca>> getMarcas();
}
