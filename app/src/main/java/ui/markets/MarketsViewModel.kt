package ui.markets

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import data.model.Stock
import data.repo.StockRepository
import data.source.StockApi
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class MarketsViewModel @Inject constructor(private val repository: StockRepository): ViewModel() {


    private var LiveData = MutableLiveData<List<Stock>?>()
    val stockLiveData: LiveData<List<Stock>?>
        get() = LiveData

    init {
        LiveData = repository.stockLiveData

    }

    fun getStocks() {
        repository.getAllStocks()
    }

}