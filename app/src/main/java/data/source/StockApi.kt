package data.source

import data.model.Stock
import data.model.StockResponse
import retrofit2.Call
import retrofit2.http.GET
import util.constants.Constants

interface StockApi{

    @GET(Constants.BASE_URL)
    fun getAllStocks(): Call<List<StockResponse>>
}