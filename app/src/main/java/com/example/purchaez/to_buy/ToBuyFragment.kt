@file:Suppress("DEPRECATION")

package com.example.purchaez.to_buy

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.purchaez.MainViewModel
import com.example.purchaez.R
import com.example.purchaez.databinding.ToBuyFragmentBinding
import com.example.purchaez.recycleView.PurchaEzAdapter
import com.example.purchaez.recycleView.TopSpacingItemDecoration

/**
 * A simple [Fragment] subclass.
 */
class ToBuyFragment : Fragment() {

    private lateinit var binding: ToBuyFragmentBinding
    private lateinit var purchaEzA: PurchaEzAdapter
    private lateinit var mainViewModel: MainViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        (activity as AppCompatActivity).supportActionBar?.title = "PurchaEz"
        binding = DataBindingUtil.inflate(inflater,
            R.layout.to_buy_fragment, container, false)

        val recycler = binding.recyclerView
        mainViewModel = ViewModelProviders.of(activity!!).get(MainViewModel::class.java)

        binding.mainViewModel = mainViewModel

        binding.lifecycleOwner = viewLifecycleOwner

        recycler.apply {
            layoutManager = LinearLayoutManager(this.context!!)
            val topSpacingDecorator = TopSpacingItemDecoration(30)
            addItemDecoration(topSpacingDecorator)
            purchaEzA = PurchaEzAdapter()
            adapter =purchaEzA
            purchaEzA.submitList(mainViewModel.getList())
        }

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
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "text/plain"
        var sharedBody = "Lista de compras:\n"

        // Consiguiendo el txt
        for(i in purchaEzA.getItem()){
            sharedBody += "-" + i.name
            sharedBody += " Q" + i.cost.toString()
            sharedBody += " Cantidad: " + i.number.toString() + "\n"
        }
        sharedBody += "Total a consumir Q" + mainViewModel.getTotalValue()
        intent.putExtra(Intent.EXTRA_TEXT, sharedBody)
        startActivity(Intent.createChooser(intent, "Share Using"))
        return super.onOptionsItemSelected(item)
    }



}
