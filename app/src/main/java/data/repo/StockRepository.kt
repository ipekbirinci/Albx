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
    private val api: StockApi
) {
    val stockLiveData = MutableLiveData<List<Stock>?>()

    fun getAllStocks() {
        api.getAllStocks().enqueue(object : Callback<List<StockResponse>> {
            override fun onResponse(call: Call<List<StockResponse>>, response: Response<List<StockResponse>>) {
                val result = response.body()?.flatMap { it.stocks }

                if (result.isNullOrEmpty()) {
                    stockLiveData.value = null
                } else {
                    stockLiveData.value = result
                }
            }

            override fun onFailure(call: Call<List<StockResponse>>, t: Throwable) {
                Log.e("Failure", t.message.orEmpty())
            }
        })
    }
}



