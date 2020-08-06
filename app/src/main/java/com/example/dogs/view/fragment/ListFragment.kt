package com.example.dogs.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dogs.R
import com.example.dogs.view.adapter.DogBreedAdapter
import com.example.dogs.viewmodel.DogListViewModel
import kotlinx.android.synthetic.main.fragment_list.*

class ListFragment : Fragment() {

    private lateinit var viewModel: DogListViewModel
    private val dogBreedAdapter = DogBreedAdapter(arrayListOf())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        btn_details.setOnClickListener {
//            val action = ListFragmentDirections.listFragmentToDetailsFragment()
//            action.dogUuid = 5
//            Navigation.findNavController(it).navigate(action)
//        }
        viewModel = ViewModelProviders.of(this).get(DogListViewModel::class.java)
        viewModel.loadData()

        rcDogBreed.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = dogBreedAdapter
        }

        observeData()
    }

    private fun observeData() {
        viewModel.dogBreedList.observe(this, Observer { dogs ->
            dogs?.let {
                rcDogBreed.visibility = View.VISIBLE
                dogBreedAdapter.updateDogList(dogs)
            }
        })

        viewModel.dogLoadError.observe(this, Observer { isError ->
            isError?.let {
                emptyList.visibility = if(isError) View.VISIBLE else View.GONE
            }
        })

        viewModel.loading.observe(this, Observer { isLoading ->
            isLoading?.let {
                progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
                if (it) {
                    rcDogBreed.visibility = View.GONE
                    emptyList.visibility = View.GONE
                }
            }
        })
    }
}