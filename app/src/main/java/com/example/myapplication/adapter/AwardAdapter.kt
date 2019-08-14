package com.example.myapplication.adapter

import android.annotation.SuppressLint
import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.model.ModelVoucher
import com.example.myapplication.R
import kotlinx.android.synthetic.main.card_award.view.*

class AwardAdapter(private val arrList: ArrayList<ModelVoucher>) : RecyclerView.Adapter<CustomViewHolder>()
{

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): CustomViewHolder {
        val layoutInflater= LayoutInflater.from(p0?.context)
        val row=layoutInflater.inflate(R.layout.card_award,p0,false)
        return CustomViewHolder(row)
    }

    override fun getItemCount(): Int {
        return arrList.size
    }

    override fun onBindViewHolder(p0: CustomViewHolder, p1: Int) {
        p0.bindItems(arrList[p1])
    }
}

class CustomViewHolder(view: View): RecyclerView.ViewHolder(view)
{
    @SuppressLint("ResourceAsColor")
    fun bindItems(modelVoucher: ModelVoucher)
    {
        try {
            itemView.type_awards.text = " "+modelVoucher.type_voucher
            itemView.value_awards.text = "" + modelVoucher.poin_voucher + " Poin"
            itemView.name_awards.text = " " + modelVoucher.title_voucher

            if (modelVoucher.type_voucher === "Products"){
                itemView.type_awards.setBackgroundResource(R.drawable.shape_product)
            }
            if (modelVoucher.type_voucher === "GiftCard"){
                itemView.type_awards.setBackgroundResource(R.drawable.shape_gift_card)
            }
        }catch (errot:Exception){
            println(errot.message)
        }
    }
}