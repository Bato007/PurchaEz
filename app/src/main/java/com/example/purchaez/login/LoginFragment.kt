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
import com.example.purchaez.databinding.LoginFragmentBinding

/**
 * A simple [Fragment] subclass.
 */
class LoginFragment : Fragment() {

    private lateinit var binding: LoginFragmentBinding
    private lateinit var mainViewModel: MainViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        (activity as AppCompatActivity).supportActionBar?.title = "PurchaEz"
        binding = DataBindingUtil.inflate(inflater,
            R.layout.login_fragment, container, false)

        mainViewModel = ViewModelProviders.of(activity!!).get(MainViewModel::class.java)

        binding.singUpButton.setOnClickListener { view:View ->
            view.findNavController().navigate(R.id.action_loginFragment_to_createAccountFragment)
        }

        binding.singInButton.setOnClickListener { view:View ->
                val user = binding.usernameInput.text.toString()
                val password = binding.passwordInput.text.toString()
                if(this.mainViewModel.login(user, password, activity!!)){
                        view.findNavController().navigate(R.id.action_loginFragment_to_toBuyFragment)
                    }
                else{
                    binding.text="No existe el usuario ingresado"
                }
        }

        return binding.root
    }

}
