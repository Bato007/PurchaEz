package com.example.purchaez.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.purchaez.R
import com.example.purchaez.databinding.LoginFragmentBinding

/**
 * A simple [Fragment] subclass.
 */
class LoginFragment : Fragment() {

    private lateinit var binding: LoginFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater,
            R.layout.login_fragment, container, false)

        binding.singUpButton.setOnClickListener { view:View ->
            view.findNavController().navigate(R.id.action_loginFragment_to_createAccountFragment)
        }

        binding.singInButton.setOnClickListener { view:View ->
            view.findNavController().navigate(R.id.action_loginFragment_to_startinScreen)
        }

        return binding.root
    }

}
