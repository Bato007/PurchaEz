package com.example.purchaez.starting_screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import com.example.purchaez.MainViewModel
import com.example.purchaez.R
import com.example.purchaez.databinding.StartingScreenFragmentBinding
import com.example.purchaez.login.LoginFragment

/**
 * A simple [Fragment] subclass.
 */
class StartingScreenFragment : Fragment() {

    private lateinit var binding: StartingScreenFragmentBinding
    private lateinit var mainViewModel: MainViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater,
            R.layout.starting_screen_fragment, container, false)

        mainViewModel = ViewModelProviders.of(activity!!).get(MainViewModel::class.java)

        binding.buyingButton.setOnClickListener { view:View ->
            view.findNavController().navigate(R.id.action_startinScreen_to_toBuyFragment)
        }

        binding.buyingRecordButton.setOnClickListener {view:View ->
            val s = mainViewModel.checkLogged().toString()
            if(mainViewModel.checkLogged() > 0){
                view.findNavController().navigate(R.id.action_startinScreen_to_toBuyFragment)
            }else{
                view.findNavController().navigate(R.id.action_startinScreen_to_loginFragment)
            }

        }

        binding.offerButton.setOnClickListener { view:View ->

        }

        return this.binding.root
    }

}
