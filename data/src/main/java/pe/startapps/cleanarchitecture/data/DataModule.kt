package pe.startapps.cleanarchitecture.data

import android.content.Context
import android.preference.PreferenceManager
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import pe.startapps.cleanarchitecture.data.modules.RepositoryModule
import pe.startapps.cleanarchitecture.data.sources.ApiService
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * @author Kevin Salazar
 * @link kevicsalazar.com
 */
@Module(includes = [
    RepositoryModule::class
])
class DataModule {

    @Provides
    fun providePreferences(context: Context) = PreferenceManager.getDefaultSharedPreferences(context)!!

    @Provides
    fun provideGson() = GsonBuilder().apply {
        setDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
    }.create()!!

    @Provides
    fun provideOkHttpClient() = OkHttpClient().newBuilder().apply {
        readTimeout(15, TimeUnit.SECONDS)
        connectTimeout(5, TimeUnit.SECONDS)
        addInterceptor(HttpLoggingInterceptor().apply {
            level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
        })
    }.build()!!

    @Provides
    fun provideRetrofit(gson: Gson, client: OkHttpClient) = Retrofit.Builder()
            .baseUrl("https://reqres.in/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(client)
            .build()!!

    @Provides
    fun provideApiService(retrofit: Retrofit) = retrofit.create(ApiService::class.java)!!

}