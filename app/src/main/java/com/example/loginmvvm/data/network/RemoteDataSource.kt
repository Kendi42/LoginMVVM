package com.example.loginmvvm.data.network

import com.example.loginmvvm.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject


class RemoteDataSource {

    companion object{
        private const val BASE_URL= "https://test-api.ekenya.co.ke/moneymart-api/api/"
    }
    fun <Api> buildApi(
        api: Class<Api>,
        authToken: String? = null
    ): Api{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client( // Logging interceptor
                OkHttpClient.Builder()
                    .addInterceptor{chain->
                        chain.proceed(chain.request().newBuilder().also{

                            it.addHeader("Authorization", "Bearer $authToken")
                        }.build())
                    }.also { client ->
                    if(BuildConfig.DEBUG){
                        val logging = HttpLoggingInterceptor()
                        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
                        client.addInterceptor(logging)
                    }
            }.build())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(api)

    }
}