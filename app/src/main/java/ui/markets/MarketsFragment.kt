package ui.markets

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.albx.R
import com.example.albx.databinding.FragmentMarketsBinding
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp
import data.repo.StockRepository
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MarketsFragment : Fragment(){


    lateinit var stockRepository: StockRepository
    var adapter: MarketsAdapter?=null
    //private val marketAdapter by lazy { MarketsAdapter(this) }
    private val viewModel by viewModels<MarketsViewModel>()
    private lateinit var binding: FragmentMarketsBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMarketsBinding.inflate(inflater, container, false)

        observeData()
        getStocksResponse()

        return binding.root

    }

 /*   override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeData()
        getStocksResponse()
    }*/

    private fun getStocksResponse() {
        viewModel.viewModelScope.launch {
            viewModel.getStocks()
        }
    }

    /* fun observeData(){
        viewModel.stockLiveData.observe(viewLifecycleOwner)
         { list ->
            if (list != null) {
                adapter.stockList(list)
            } else {

            }
        }

    }*/

    fun observeData(){
        viewModel.stockLiveData.observe(viewLifecycleOwner) { list ->
            list?.let { // list null değilse çalışır
                adapter?.stockList = it // adapter'ın stockList değişkenine atama yapılır
                adapter?.notifyDataSetChanged() // adapter'ı güncellemek için
            }
        }
    }


}


