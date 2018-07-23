package pe.startapps.cleanarchitecture.data.modules

import android.content.Context
import android.preference.PreferenceManager
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import pe.startapps.cleanarchitecture.data.BuildConfig
import pe.startapps.cleanarchitecture.data.sources.cloud.PetService
import pe.startapps.cleanarchitecture.data.sources.cloud.UserService
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * Created by kevinsalazar.
 */
@Module
class SourcesModule {

    // SharedPreferences

    @Provides
    @Singleton
    fun providePreferences(context: Context) = PreferenceManager.getDefaultSharedPreferences(context)!!

    // Retrofit

    @Provides
    @Singleton
    fun provideOkHttpClient() = OkHttpClient().newBuilder().apply {
        readTimeout(15, TimeUnit.SECONDS)
        connectTimeout(5, TimeUnit.SECONDS)
        addInterceptor(HttpLoggingInterceptor().apply {
            level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
        })
    }.build()!!

    @Provides
    @Singleton
    fun provideRetrofit(gson: Gson, client: OkHttpClient) = Retrofit.Builder()
            .baseUrl("https://67b6f48d-49b0-4a75-9877-673d217e8bcf.mock.pstmn.io")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(client)
            .build()!!

    @Provides
    @Singleton
    fun provideUserService(retrofit: Retrofit) = retrofit.create(UserService::class.java)!!

    @Provides
    @Singleton
    fun providePetService(retrofit: Retrofit) = retrofit.create(PetService::class.java)!!

}