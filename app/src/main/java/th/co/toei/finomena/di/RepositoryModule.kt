package th.co.toei.finomena.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import th.co.toei.finomena.repository.FundRepository
import th.co.toei.finomena.repository.FundRepositoryImpl
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun provideFundRepository(fundRepositoryImpl: FundRepositoryImpl): FundRepository
}