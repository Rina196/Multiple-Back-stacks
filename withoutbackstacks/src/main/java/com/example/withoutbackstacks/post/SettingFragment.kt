package com.example.withoutbackstacks.post

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.withoutbackstacks.R
import kotlinx.android.synthetic.main.fragment_setting.*


class SettingFragment : Fragment(), View.OnClickListener {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_setting, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        cvContactUs.setOnClickListener(this)
        cvPrivacyPolicy.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.cvContactUs -> {
                findNavController().navigate(SettingFragmentDirections.actionSettingFragmentToCmsFragment("Contact Us"))
            }
            R.id.cvPrivacyPolicy -> {
                findNavController().navigate(SettingFragmentDirections.actionSettingFragmentToCmsFragment("Policy"))
            }
        }
    }
}