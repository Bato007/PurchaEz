package com.example.purchaez.to_buy

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.purchaez.R
import com.example.purchaez.databinding.ToBuyFragmentBinding

/**
 * A simple [Fragment] subclass.
 */
class ToBuyFragment : Fragment() {

    private lateinit var binding: ToBuyFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        (activity as AppCompatActivity).supportActionBar?.title = "PurchaEz"
        binding = DataBindingUtil.inflate(inflater,
            R.layout.to_buy_fragment, container, false)

        binding.addItem.setOnClickListener{view: View ->
            view.findNavController().navigate(R.id.action_toBuyFragment_to_addListFragment)
        }

        setHasOptionsMenu(true)
        return binding.root
    }

    // Inicializando el menu para poder guardar las cosas
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.buy_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        Log.i("HOLLALA", "HOLSKDJFKLASDF")

        return super.onOptionsItemSelected(item)
    }



}
