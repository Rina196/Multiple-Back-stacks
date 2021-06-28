package com.example.backstackswithextension.feed

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.backstackswithextension.R
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val list = ArrayList<UserData>()
        list.add(UserData().apply {
            title = "John dhow"
            message = "abc@gmail.com"
            mobile = "1234567890"
        })
        list.add(UserData().apply {
            title = "Doll Throne"
            message = "def@gmail.com"
            mobile = "097654321"
        })
        val adapter = UserAdapter(requireContext(), list, ::handleClick)
        rvList.adapter = adapter
        rvList.addItemDecoration(
            DividerItemDecoration(
                context,
                LinearLayoutManager.VERTICAL
            )
        )
    }

    private fun handleClick(userData: UserData) {
        val bundle = Bundle()
        bundle.putSerializable("data", userData)
        findNavController().navigate(R.id.action_mainFragment_to_userDetailsFragment, bundle,null)
    }

}