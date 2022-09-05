package uz.by_prince.ussd.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.by_prince.ussd.TariffModel
import uz.by_prince.ussd.databinding.ItemListBinding

interface myAdapterCallback {
    fun onClickTariff(tariff: TariffModel)
}

class Adapter(val list: List<TariffModel>, val callback: myAdapterCallback) :
    RecyclerView.Adapter<Adapter.Vh>() {

    inner class Vh(var itemList: ItemListBinding) : RecyclerView.ViewHolder(itemList.root) {
        fun onBind(tariff: TariffModel) {
            itemList.root.setOnClickListener {
                callback.onClickTariff(tariff)
            }
            itemList.tv1.text = tariff.tarif
            itemList.tv2.text = tariff.info
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size
}