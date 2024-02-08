package ui.markets

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.albx.R
import com.example.albx.databinding.CardViewBinding
import data.model.Stock

class MarketsAdapter(

) : RecyclerView.Adapter<MarketsAdapter.ViewHolder>(){

    var stockList= ArrayList<Stock> ()


    class ViewHolder(val binding: CardViewBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: CardViewBinding =
            DataBindingUtil.inflate(inflater, R.layout.card_view, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentNote = stockList[position]

        Log.d("eeeeedas",stockList.toString())

        holder.binding.price.text=currentNote.price.toString()
        holder.binding.rate.text=currentNote.rate.toString()
        holder.binding.shareCode.text=currentNote.code
        holder.binding.shareName.text=currentNote.name


        //Glide kütüphanesi ile görüntü alma
        Glide.with(holder.itemView)
            .load("https://png.pngtree.com/png-clipart/20220528/ourmid/pngtree-turkey-flag-with-pole-png-image_4744936.png")
            .override(80,80)
            .into(holder.binding.shareIcon)



    }


    override fun getItemCount(): Int = stockList.size




    }

