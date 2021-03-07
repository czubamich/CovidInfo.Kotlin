package com.mczuba.covidwpolsce.vm

import android.app.Application
import androidx.lifecycle.*
import com.mczuba.covidwpolsce.api.CovidDataProvider
import com.mczuba.covidwpolsce.data.Country
import com.mczuba.covidwpolsce.data.CountryHistory
import com.mczuba.covidwpolsce.data.CountryNews
import kotlinx.coroutines.launch
import java.util.*

class NewsViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = CovidDataProvider
    val country = repository.country
    val regions = repository.regions

    private var _entry = MutableLiveData<List<CountryNews>>()
    val entry: LiveData<List<CountryNews>> = _entry

    init {
        viewModelScope.launch {
            country.value?.let {
                val pages = repository.getNewsPageCount()
                val a = mutableListOf<CountryNews>()
                for (i in 1..pages)
                {
                    a.addAll(repository.getNewsPage(i))
                }
                _entry.postValue(a)
            }
        }
    }
}