package com.example.android_example.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.android_example.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.list_fragment.*

@AndroidEntryPoint
class ListFragment : Fragment(), MovieAdapter.Listener {

    private lateinit var viewModel: ListViewModel
    private lateinit var adapter: MovieAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.list_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(ListViewModel::class.java)
        adapter = MovieAdapter(this)
        listRecyclerView.adapter = adapter

        viewModel.movies.observe(viewLifecycleOwner, { movies ->
            adapter.submitList(movies)
        })
        viewModel.getAllMovies()
    }

    override fun onItemSelected(id: Int) {
            findNavController().navigate(
                ListFragmentDirections.actionListFragmentToDetailsFragment(
                    movieId = id
                )
            )
    }

}