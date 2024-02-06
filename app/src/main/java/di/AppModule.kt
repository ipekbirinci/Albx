package di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import data.source.StockApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import util.constants.Constants
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideRetrofitInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideApi(retrofit:Retrofit):StockApi{
        return retrofit.create(StockApi::class.java)
    }
}