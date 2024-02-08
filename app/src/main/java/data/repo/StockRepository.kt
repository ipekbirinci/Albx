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
        api.getAllStocks().enqueue(object : Callback<List<Stock>> {
            override fun onResponse(call: Call<List<Stock>>, response: Response<List<Stock>>) {


                if(response.isSuccessful)
                {
                    Log.d("asssd",response.body().toString())
                    val result = response.body()
                    if (result.isNullOrEmpty()) {
                        stockLiveData.value = null
                        Log.d("respo",stockLiveData.toString())
                    } else {
                        stockLiveData.value = result
                    }
                }else{

                    Log.d("sdfsdf",response.message())
                }

            }

            override fun onFailure(call: Call<List<Stock>>, t: Throwable) {
                Log.e("Failure", t.message.orEmpty())
            }
        })
    }
}



