package com.example.newstrending.di.module

import android.content.Context
import androidx.room.Room
import androidx.viewbinding.BuildConfig
import com.example.newstrending.data.api.AuthTokenInterceptor
import com.example.newstrending.data.api.NetworkService
import com.example.newstrending.data.database.service.NewsDatabase
import com.example.newstrending.data.database.service.TopHeadline.TopHeadlineDbService
import com.example.newstrending.data.database.service.TopHeadline.TopHeadlineDbServiceImpl
import com.example.newstrending.di.BaseUrl
import com.example.newstrending.di.DbName
import com.example.newstrending.util.AppConstant
import com.example.newstrending.util.NetworkHelper
import com.example.newstrending.util.NetworkHelperImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApplicationModule {

    @BaseUrl
    @Provides
    fun provideBaseUrl(): String = "https://newsapi.org/v2/"

    @Provides
    @Singleton
    fun provideGsonConverterFactory(): GsonConverterFactory = GsonConverterFactory.create()

    @Provides
    @Singleton
    fun provideNetworkHelper(@ApplicationContext context: Context): NetworkHelper {
        return NetworkHelperImp(context)
    }


    @Provides
    @Singleton
    fun provideHttpClient(
        httpLoggingInterceptor: HttpLoggingInterceptor, authTokenInterceptor: AuthTokenInterceptor
    ): OkHttpClient {
        val builder = OkHttpClient().newBuilder().addInterceptor(httpLoggingInterceptor)
            .addInterceptor(authTokenInterceptor)
        return builder.build()
    }

    @Provides
    @Singleton
    fun provideAuthTokenInterceptor(): AuthTokenInterceptor = AuthTokenInterceptor()

    @Provides
    @Singleton
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        if (BuildConfig.DEBUG) {
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        } else {
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.NONE
        }
        return httpLoggingInterceptor
    }

    @Singleton
    @Provides
    fun provideNetworkService(
        @BaseUrl baseUrl: String, okHttp: OkHttpClient, gson: GsonConverterFactory
    ): NetworkService {
        return Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(gson).client(okHttp).build()
            .create(NetworkService::class.java)
    }


    @Provides
    @Singleton
    fun provideNewsDatabase(
        @ApplicationContext context: Context, @DbName dbName: String
    ): NewsDatabase {
        return Room.databaseBuilder(
            context, NewsDatabase::class.java, dbName
        ).build()
    }

    @DbName
    @Provides
    fun provideDbName(): String = AppConstant.DB_NAME

    @Provides
    @Singleton
    fun provideTopHeadlineDbService(newsDatabase: NewsDatabase): TopHeadlineDbService {
        return TopHeadlineDbServiceImpl(newsDatabase)
    }

}