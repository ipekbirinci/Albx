package ui.markets

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.albx.R
import com.example.albx.databinding.CardViewBinding
import data.model.Stock

class MarketsAdapter(
  var stockList: List<Stock>,
) : RecyclerView.Adapter<MarketsAdapter.ViewHolder>(){

   private var stockFilterList = stockList.toMutableList()

    class ViewHolder(val binding: CardViewBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: CardViewBinding =
            DataBindingUtil.inflate(inflater, R.layout.card_view, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentNote = stockFilterList[position]

        holder.binding.price.text=currentNote.price.toString()
        holder.binding.rate.text=currentNote.rate.toString()
        holder.binding.shareCode.text=currentNote.code
        holder.binding.shareName.text=currentNote.name

        //Glide kütüphanesi ile görüntü alma
        Glide.with(holder.itemView.context)
            .load(currentNote.icon)
            .into(holder.binding.shareIcon)




    }


    override fun getItemCount(): Int = stockFilterList.size




    }

