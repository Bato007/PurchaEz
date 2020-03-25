package com.example.purchaez.to_buy

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.purchaez.R
import com.example.purchaez.databinding.ToBuyFragmentBinding

/**
 * A simple [Fragment] subclass.
 */
class ToBuyFragment : Fragment() {

    private lateinit var binding: ToBuyFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater,
            R.layout.to_buy_fragment, container, false)

        return binding.root
    }

}
