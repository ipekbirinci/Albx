package ui.calender

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.albx.R
import com.example.albx.databinding.FragmentMarketsBinding
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp
import data.repo.StockRepository
import ui.markets.MarketsAdapter
import ui.markets.MarketsViewModel
import javax.inject.Inject

@AndroidEntryPoint
class CalenderFragment : Fragment() {


    @Inject
    lateinit var stockRepository: StockRepository
    var adapter: MarketsAdapter?=null
    private val viewModel by viewModels<MarketsViewModel>()
    private lateinit var binding: FragmentMarketsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_calender, container, false)
    }



}