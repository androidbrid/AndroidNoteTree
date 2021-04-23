package com.jackshi.androidx_kotlin.ui.member

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import com.jackshi.androidx_kotlin.R

class MemberFragment : Fragment() {

    private lateinit var memberViewModel: MemberViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        memberViewModel =
            ViewModelProviders.of(this).get(MemberViewModel::class.java)
        val root = inflater.inflate(R.layout.member_fragment, container, false)
        val textView: TextView = root.findViewById(R.id.text_member)
        memberViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}