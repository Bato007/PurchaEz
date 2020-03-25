package com.example.purchaez.starting_screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.purchaez.R
import com.example.purchaez.databinding.StartingScreenFragmentBinding

/**
 * A simple [Fragment] subclass.
 */
class StartingScreenFragment : Fragment() {

    private lateinit var binding: StartingScreenFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater,
            R.layout.starting_screen_fragment, container, false)

        return this.binding.root
    }

}
