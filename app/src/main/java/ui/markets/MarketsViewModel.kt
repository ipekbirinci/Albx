package ui.markets

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import data.model.Stock
import data.model.StockResponse
import data.repo.StockRepository
import data.source.StockApi
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class MarketsViewModel @Inject constructor(private val repository: StockRepository): ViewModel() {

    @Inject
    lateinit var apiRepository: StockRepository

    private var _stockLiveData = MutableLiveData<List<Stock>?>()
    val stockLiveData: LiveData<List<Stock>?>
        get() = _stockLiveData


    fun getStocks() {
        apiRepository.getAllStocks()
    }

}