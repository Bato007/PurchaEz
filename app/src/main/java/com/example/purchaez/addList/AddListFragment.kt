@file:Suppress("DEPRECATION")

package com.example.purchaez.addList

import android.database.DatabaseUtils
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.purchaez.MainViewModel
import com.example.purchaez.R
import com.example.purchaez.databinding.AddListFragmentBinding
import com.example.purchaez.recycleView.Items

/**
 * A simple [Fragment] subclass.
 */
class AddListFragment : Fragment() {

    private lateinit var binding: AddListFragmentBinding
    private lateinit var mainViewModel: MainViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        (activity as AppCompatActivity).supportActionBar?.title = "PurchaEz"
        binding = DataBindingUtil.inflate(inflater,
            R.layout.add_list_fragment, container, false)
        mainViewModel = ViewModelProviders.of(activity!!).get(MainViewModel::class.java)

        binding.addButton.setOnClickListener{
            if(binding.costItem.text != null && binding.inputList.text != null && binding.productNumber.text != null){
                val items = Items(binding.inputList.text.toString(), binding.costItem.text.toString().toFloat(), binding.productNumber.text.toString().toInt())
                mainViewModel.sendItem(items)
                binding.costItem.text = null
                binding.inputList.text = null
                binding.productNumber.text = null
            }else{
                Toast.makeText(this.activity, "Llene todos lso valores", Toast.LENGTH_SHORT).show()
            }
        }

        return binding.root
    }

}
