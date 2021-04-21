package com.jackshi.androidjavatabhostfordesign.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.TextView;

import com.jackshi.androidjavatabhostfordesign.R;
import com.jackshi.androidjavatabhostfordesign.utils.MessageEvent;

import org.greenrobot.eventbus.EventBus;

public class HomeFragment extends Fragment implements CompoundButton.OnCheckedChangeListener, AdapterView.OnItemSelectedListener {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;
    CheckBox mCheckBox1, mCheckBox2, mCheckBox3;
    Spinner mSpinner;

    public HomeFragment() {
    }

    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        TextView tv = getView().findViewById(R.id.fragment_home_tv);
        tv.setText(mParam1);

        mCheckBox1 = getView().findViewById(R.id.fragment_home_check1);
        mCheckBox2 = getView().findViewById(R.id.fragment_home_check2);
        mCheckBox3 = getView().findViewById(R.id.fragment_home_check3);
        mSpinner = getView().findViewById(R.id.fragment_home_spinner);
        mSpinner.setOnItemSelectedListener(this);
        mCheckBox1.setOnCheckedChangeListener(this);
        mCheckBox2.setOnCheckedChangeListener(this);
        mCheckBox3.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        switch (buttonView.getId()) {
            case R.id.fragment_home_check1:
                if (isChecked) {
                    EventBus.getDefault().post(new MessageEvent(0, true));
                    mCheckBox1.setEnabled(false);
                }
                break;
            case R.id.fragment_home_check2:
                if (isChecked) {
                    EventBus.getDefault().post(new MessageEvent(1, true));
                } else {
                    EventBus.getDefault().post(new MessageEvent(1, false));
                }
                break;
            case R.id.fragment_home_check3:
                if (isChecked) {
                    EventBus.getDefault().post(new MessageEvent(3, true));
                } else {
                    EventBus.getDefault().post(new MessageEvent(3, false));
                }
                break;
            default:
                break;
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        EventBus.getDefault().post(new MessageEvent(2, position));
        if (position == 0) {
            mCheckBox2.setEnabled(false);
            mCheckBox3.setEnabled(true);
        } else if (position == 1) {
            mCheckBox2.setEnabled(false);
            mCheckBox3.setEnabled(true);
        } else if (position == 2) {
            //文字和图标同时都显示时,移除缩放效果才有意义
            mCheckBox2.setEnabled(true);
            mCheckBox3.setEnabled(false);
        } else {
            mCheckBox2.setEnabled(false);
            mCheckBox3.setEnabled(false);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }
}