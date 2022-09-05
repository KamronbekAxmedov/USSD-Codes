package uz.by_prince.ussd

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import uz.by_prince.ussd.adapter.Adapter
import uz.by_prince.ussd.adapter.myAdapterCallback
import uz.by_prince.ussd.databinding.FragmentBlank2Binding


class BlankFragment2 : Fragment(), myAdapterCallback {
    lateinit var binding: FragmentBlank2Binding
    lateinit var list: ArrayList<TariffModel>
    lateinit var adapter: Adapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBlank2Binding.inflate(layoutInflater)
        loadData()

        adapter = Adapter(list, this)
        binding.rv.adapter = adapter


        return binding.root
    }

    private fun loadData() {
        list = ArrayList()
        list.add(TariffModel("Hammasi zo'r 1", "Oylik abonent tolovi 20.000", "*2*3#", Malumotlar.zor1))
        list.add(TariffModel("Hammasi zo'r 2", "Oylik abonent tolovi 30.000", "*2*5#", Malumotlar.zor2))
        list.add(TariffModel("Hammasi zo'r 3", "Oylik abonent tolovi 40.000", "*2*8#", Malumotlar.zor3))
        list.add(TariffModel("Hammasi zo'r 4", "Oylik abonent tolovi 60.000", "*2*15#", Malumotlar.zor4))
    }

    override fun onClickTariff(tariff: TariffModel) {
        Malumotlar.tanlanganTariff = tariff
        findNavController().navigate(R.id.blankFragment3)
        Toast.makeText(binding.root.context, tariff.toString(), Toast.LENGTH_SHORT).show()
    }
}