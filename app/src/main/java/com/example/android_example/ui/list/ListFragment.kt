package com.example.android_example.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.android_example.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.list_fragment.*

@AndroidEntryPoint
class ListFragment : Fragment(), MovieAdapter.Listener {

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

        viewModel.movies.observe(viewLifecycleOwner, { movies ->
            listRecyclerView.adapter = MovieAdapter(movies, this)
        })
        viewModel.getAllMovies()

    }

    override fun onItemSelected(id: Int) {
        Toast.makeText(context, id.toString(), Toast.LENGTH_SHORT).show()
    }

}