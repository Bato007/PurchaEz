@file:Suppress("DEPRECATION")

package com.example.purchaez.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import com.example.purchaez.MainViewModel
import com.example.purchaez.R
import com.example.purchaez.databinding.CreateAccountFragmentBinding

/**
 * A simple [Fragment] subclass.
 */
class CreateAccountFragment : Fragment() {

    private lateinit var binding: CreateAccountFragmentBinding
    private lateinit var mainViewModel: MainViewModel


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        (activity as AppCompatActivity).supportActionBar?.title = "PurchaEz"
        binding = DataBindingUtil.inflate(inflater,
            R.layout.create_account_fragment, container, false)

        mainViewModel = ViewModelProviders.of(activity!!).get(MainViewModel::class.java)

        // Conseguiendo los valores del input del usuario
        binding.singUpButton.setOnClickListener {view: View ->
            val userInput = ArrayList<String>()
            userInput.add(binding.usernameInput.text.toString())
            userInput.add(binding.passwordInput.text.toString())
            userInput.add(binding.confirmPasswordInput.text.toString())
            userInput.add(binding.emailInput.text.toString())

            if(mainViewModel.createUser(userInput, activity!!)){
                Toast.makeText(this.activity, "Se ha creado la cuenta", Toast.LENGTH_LONG).show()
                view.findNavController().navigate(R.id.action_createAccountFragment_to_startinScreen)
            }else{
                Toast.makeText(this.activity, "No se pudo crear la cuenta, verifique sus datos", Toast.LENGTH_LONG).show()
            }
            userInput.clear()
        }

        return binding.root
    }

}
