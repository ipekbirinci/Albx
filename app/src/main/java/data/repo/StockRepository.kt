package data.repo

import android.util.Log
import androidx.lifecycle.MutableLiveData
import data.model.Stock
import data.model.StockResponse
import data.source.StockApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class StockRepository @Inject constructor(
    private val api : StockApi
) {
    val stockLiveData = MutableLiveData<List<Stock>?>()

    fun getAllStocks(){
        api.getAllStocks().enqueue(object : Callback<StockResponse> {
            override fun onResponse(call: Call<StockResponse>, response: Response<StockResponse>) {

                val result = response.body()?.stocks

                if (result.isNullOrEmpty().not()) {
                    stockLiveData.value = result
                } else {
                    stockLiveData.value = null
                }

            }

            override fun onFailure(call: Call<StockResponse>, t: Throwable) {
                Log.e("Failure", t.message.orEmpty())
            }
        })
    }

}