package com.jackshi.androidx_kotlin.ui.me

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import com.jackshi.androidx_kotlin.R

class MeFragment : Fragment() {

    private lateinit var meViewModel: MeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        meViewModel = ViewModelProviders.of(this).get(MeViewModel::class.java)
        val root = inflater.inflate(R.layout.me_fragment, container, false)
        val textView: TextView = root.findViewById(R.id.text_me)
        meViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}