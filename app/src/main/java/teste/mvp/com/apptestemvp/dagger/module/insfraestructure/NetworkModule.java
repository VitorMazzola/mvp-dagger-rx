package teste.mvp.com.apptestemvp.dagger.module.insfraestructure;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import teste.mvp.com.apptestemvp.infraestructure.service.FipeService;

/**
 * Created by softvaro on 29/09/17.
 */

@Module
public class NetworkModule {

    static final String RETROFIT_FIPE = "Fipe_Api";

    @Provides
    @Singleton
    Gson providesGson(){
        return new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
                .create();
    }

    @Provides
    @Singleton
    GsonConverterFactory providesGsonConverterFactory(Gson gson) {
        return GsonConverterFactory.create(gson);
    }

    @Provides
    @Singleton
    RxJava2CallAdapterFactory providesRxJava2CallAdapterFactory() {
        return RxJava2CallAdapterFactory.create();
    }

    @Provides
    @Singleton
    @Named(RETROFIT_FIPE)
    Retrofit providesRetrofitFipeMarcas(GsonConverterFactory gsonFactory,
                                        RxJava2CallAdapterFactory rxFactory) {
        return buildRetrofit(gsonFactory, rxFactory, FipeService.BASE_URL);
    }

    private Retrofit buildRetrofit(GsonConverterFactory converterFactory,
                                   RxJava2CallAdapterFactory callAdapterFactory,
                                   String baseUrl) {

        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(converterFactory)
                .addCallAdapterFactory(callAdapterFactory)
                .build();
    }

}
