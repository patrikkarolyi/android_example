package com.example.android_example.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.android_example.R
import kotlinx.android.synthetic.main.list_fragment.*

class ListFragment : Fragment() {

    companion object {
        fun newInstance() = ListFragment()
    }

    private lateinit var viewModel: ListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.list_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(ListViewModel::class.java)

        //val action = ListFragmentDirections.actionListFragmentToDetailsFragment(movieId = 100)
        //findNavController().navigate(action)

        viewModel.sec.observe(viewLifecycleOwner, Observer { newSec ->
            button.text = newSec.toString()
        })

        button.setOnClickListener {
            viewModel.getAllMovies()
        }
    }

}