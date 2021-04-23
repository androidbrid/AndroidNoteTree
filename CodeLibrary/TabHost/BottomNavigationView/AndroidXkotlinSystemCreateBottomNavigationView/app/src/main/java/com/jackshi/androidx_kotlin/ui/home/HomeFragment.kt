package com.jackshi.androidx_kotlin.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.CheckBox
import android.widget.CompoundButton
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.jackshi.androidx_kotlin.MessageEvent
import com.jackshi.androidx_kotlin.R
import org.greenrobot.eventbus.EventBus

class HomeFragment : Fragment(), CompoundButton.OnCheckedChangeListener,
    AdapterView.OnItemSelectedListener {

    private lateinit var homeViewModel: HomeViewModel
    private lateinit var check1: CheckBox
    private lateinit var check2: CheckBox
    private lateinit var check3: CheckBox
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val textView: TextView = root.findViewById(R.id.text_home)
        check1 = root.findViewById(R.id.fragment_home_check1)
        check2 = root.findViewById(R.id.fragment_home_check2)
        check3 = root.findViewById(R.id.fragment_home_check3)
        homeViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.d("bqt","1111")
    }
    override fun onCheckedChanged(buttonView: CompoundButton, isChecked: Boolean) {
        when (buttonView.id) {
            R.id.fragment_home_check1 -> if (isChecked) {
                EventBus.getDefault().post(MessageEvent(0, true))
                check1.isEnabled = false
            }
            R.id.fragment_home_check2 -> if (isChecked) {
                EventBus.getDefault().post(MessageEvent(1, true))
            } else {
                EventBus.getDefault().post(MessageEvent(1, false))
            }
            R.id.fragment_home_check3 -> if (isChecked) {
                EventBus.getDefault().post(MessageEvent(3, true))
            } else {
                EventBus.getDefault().post(MessageEvent(3, false))
            }
            else -> {
            }
        }
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        EventBus.getDefault().post(MessageEvent(2, position))
        when (position) {
            0 -> {
                check2.isEnabled = false
                check3.isEnabled = true
            }
            1 -> {
                check2.isEnabled = false
                check3.isEnabled = true
            }
            2 -> {
                //文字和图标同时都显示时,移除缩放效果才有意义
                check2.isEnabled = true
                check3.isEnabled = false
            }
            else -> {
                check2.isEnabled = false
                check3.isEnabled = false
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("bqt","onDestroy")
    }
}