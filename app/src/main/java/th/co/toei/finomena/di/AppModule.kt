package th.co.toei.finomena.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import th.co.toei.finomena.network.ApiService
import th.co.toei.finomena.network.EndpointServiceInterface
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {
    @Provides
    @Singleton
    fun provideApiService(): EndpointServiceInterface =
        ApiService().getEndpointInterface(EndpointServiceInterface::class.java)
}