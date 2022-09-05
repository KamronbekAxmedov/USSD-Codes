package uz.by_prince.ussd

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import uz.by_prince.ussd.databinding.FragmentBlankBinding


class BlankFragment : Fragment() {
lateinit var binding: FragmentBlankBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentBlankBinding.inflate(layoutInflater)

        binding.tariflar.setOnClickListener {

            findNavController().navigate(R.id.blankFragment2)

            Toast.makeText(context, "Tariflar", Toast.LENGTH_SHORT).show()

        }


        return binding.root
    }
}