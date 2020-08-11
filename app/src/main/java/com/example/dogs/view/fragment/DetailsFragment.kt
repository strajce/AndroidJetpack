package com.example.dogs.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.dogs.R
import com.example.dogs.viewmodel.DogDetailsViewModel
import kotlinx.android.synthetic.main.fragment_details.*

class DetailsFragment : Fragment() {

    private lateinit var viewModel: DogDetailsViewModel

    private var dogUuid = 0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            dogUuid = DetailsFragmentArgs.fromBundle(it).dogUuid
        }

        viewModel = ViewModelProviders.of(this).get(DogDetailsViewModel::class.java)
//        viewModel.showDogBreedDetails(dog1)

        observeDetailas()

//        btn_list.setOnClickListener {
//            Navigation.findNavController(it).navigate(DetailsFragmentDirections.detailsFragmentToListFragment())
//        }
    }

    fun observeDetailas() {
        viewModel.dogBreedDetails.observe(this, Observer { dog ->
            dog?.let {
                dogBreadDetails.text = dog.dogBreedDescription
            }
        })
    }
}