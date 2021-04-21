package com.jackshi.androidxkotlinbottomnavigationview.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.CompoundButton
import androidx.fragment.app.Fragment
import com.jackshi.androidxkotlinbottomnavigationview.R
import com.jackshi.androidxkotlinbottomnavigationview.utils.MessageEvent
import kotlinx.android.synthetic.main.fragment_home.*
import org.greenrobot.eventbus.EventBus

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class HomeFragment : Fragment(), CompoundButton.OnCheckedChangeListener,
    AdapterView.OnItemSelectedListener {
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        fragment_home_tv.text = param1
        fragment_home_check1.setOnCheckedChangeListener(this)
        fragment_home_check2.setOnCheckedChangeListener(this)
        fragment_home_check3.setOnCheckedChangeListener(this)
        fragment_home_spinner.onItemSelectedListener = this
    }

    override fun onCheckedChanged(buttonView: CompoundButton, isChecked: Boolean) {
        when (buttonView.id) {
            R.id.fragment_home_check1 -> if (isChecked) {
                EventBus.getDefault().post(MessageEvent(0, true))
                fragment_home_check1.isEnabled = false
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
                fragment_home_check2.isEnabled = false
                fragment_home_check3.isEnabled = true
            }
            1 -> {
                fragment_home_check2.isEnabled = false
                fragment_home_check3.isEnabled = true
            }
            2 -> {
                //文字和图标同时都显示时,移除缩放效果才有意义
                fragment_home_check2.isEnabled = true
                fragment_home_check3.isEnabled = false
            }
            else -> {
                fragment_home_check2.isEnabled = false
                fragment_home_check3.isEnabled = false
            }
        }
    }
}