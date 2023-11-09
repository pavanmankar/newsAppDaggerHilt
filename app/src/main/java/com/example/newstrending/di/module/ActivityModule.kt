package com.example.newstrending.di.module

import com.example.newstrending.ui.country.view.CountryListAdapter
import com.example.newstrending.ui.language.view.LanguageListAdapter
import com.example.newstrending.ui.newsource.view.NewsourceAdapter
import com.example.newstrending.ui.newsource.view.SourceHeadlineAdapter
import com.example.newstrending.ui.topheadline.view.PagingTopHeadlineAdapter
import com.example.newstrending.ui.topheadline.view.TopHeadlineAdapter
import dagger.Module
import dagger.Provides

import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped

@Module
@InstallIn(ActivityComponent::class)
class ActivityModule {

    @ActivityScoped
    @Provides
    fun provideTopHeadlineAdapter() = TopHeadlineAdapter(ArrayList())

    @Provides
    fun providePagingTopHeadlineAdapter() = PagingTopHeadlineAdapter(ArrayList())

    @Provides
    fun provideNewSourceAdapter() = NewsourceAdapter(ArrayList())

    @Provides
    fun provideSourceHeadlineAdapter() = SourceHeadlineAdapter(ArrayList())

    @Provides
    fun provideCountryListAdapter() = CountryListAdapter(ArrayList())

    @Provides
    fun provideLanguageListAdapter() = LanguageListAdapter(ArrayList())


}