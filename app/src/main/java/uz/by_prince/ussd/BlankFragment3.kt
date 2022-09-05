package uz.by_prince.ussd

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import uz.by_prince.ussd.databinding.FragmentBlank3Binding


class BlankFragment3 : Fragment() {
    lateinit var binding: FragmentBlank3Binding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBlank3Binding.inflate(layoutInflater)
        val tanlanganTarif = Malumotlar.tanlanganTariff!!

        binding.apply {
            tv1.text = tanlanganTarif.tarif
            tv2.text = tanlanganTarif.malumot
            tv3.text = tanlanganTarif.code

            tv3.setOnClickListener {
                startActivity(Intent(Intent.ACTION_DIAL, Uri.parse("tel: ${tanlanganTarif.code}")))
            }
        }

        return binding.root
    }
}