//Copyright 2019 Denelle Britton Linebarger
//    All Rights Reserved.

package edu.cnm.deepdive.gallery_match.service;

import edu.cnm.deepdive.gallery_match.BuildConfig;
import edu.cnm.deepdive.gallery_match.model.entity.Card;
import edu.cnm.deepdive.gallery_match.model.pojo.Result;
import io.reactivex.Single;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.logging.HttpLoggingInterceptor.Level;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;


/**
 *provides access to Metropolitan Museum of Art Collection API service
 */
public interface MetWebService {

  /**
   * allows initialization-on demand for this service
   * @return instance of this service
   */
  static MetWebService getInstance() {
    return InstanceHolder.INSTANCE;
  }


  /**
   * endpoint queries Metropolitan Museum of Art Collection API based on user provided search term
   * @param keyword search term provided by user for theme
   * @return objects matching search term
   */
  @GET("search")
  Single<Result> search(@Query("q") String keyword);


  /**
   * endpoint retrieves object from Metropolitan Museum of Art Collection API using object id
   * @param objectId id of object returned by Metropolitan Museum of Art Collection API
   * @return object requested
   */
  @GET("objects/{objectId}")
  Single<Card> get(@Path("objectId") int objectId);

  /**
   * returns instance of this service
   */
  class InstanceHolder {

    private static final MetWebService INSTANCE;

    /**
     * sends out network requests to Metropolitan Museum of Art Collection API and
     * deserializes response using Gson library
     */
    static {
      // Following five lines should be removed/commented out for production release.
      HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
      interceptor.setLevel(Level.BODY);
      OkHttpClient client = new OkHttpClient.Builder()
          .addInterceptor(interceptor)
          .build();
      Retrofit retrofit = new Retrofit.Builder()
          .baseUrl(BuildConfig.BASE_URL)
          .client(client)
          .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
          .addConverterFactory(GsonConverterFactory.create())
          .build();
      INSTANCE = retrofit.create(MetWebService.class);
    }

  }

}
