package com.saneen.avesassignmentapp.retrofit

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import com.saneen.avesassignmentapp.models.Result
import retrofit2.Response

class RetrofitClient {

    private val BASE_URL  : String = "https://api.unsplash.com/"
    private val CLIENT_ID : String = "8634366274bd23efb9b023fb9b2c6502e67f7dd5d6a7962b3b49fbee170940f8"

    private fun getInterceptor() : Interceptor {
        val requestInterceptor = Interceptor{

            val url = it.request()
                .url
                .newBuilder()
                .addQueryParameter("client_id" , CLIENT_ID)
                .build()

            val request = it.request()
                .newBuilder()
                .url(url)
                .build()

            return@Interceptor it.proceed(request)
        }
        return requestInterceptor
    }

    private fun getGsonConverterFactory() : GsonConverterFactory {
        return GsonConverterFactory.create()
    }

    private fun getOkHttpClient() : OkHttpClient {

        /***
         * Only use the logging interceptor to log , Do not use it in production.
         * This can cause a serious security issue and google play might reject it.
         */
//        var httLog : HttpLoggingInterceptor = HttpLoggingInterceptor()
//        httLog.setLevel(HttpLoggingInterceptor.Level.BODY)

        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(getInterceptor())
//            .addInterceptor(httLog)
            .connectTimeout(60 , TimeUnit.SECONDS)
            .build()

        return okHttpClient
    }

    private fun getResultApiService() : ApiService{
        var retrofit : Retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(getOkHttpClient())
            .addConverterFactory(getGsonConverterFactory())
            .build()

        return  retrofit.create(ApiService::class.java)
    }

    suspend fun getResults() : Response<List<Result>>{
        return getResultApiService().getData()
    }
}