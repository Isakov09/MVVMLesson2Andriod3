package com.example.mvvmlesson2andriod3.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.mvvmlesson2andriod3.R
import com.example.mvvmlesson2andriod3.databinding.FragmentHomeBinding
import com.example.mvvmlesson2andriod3.models.Photo
import com.example.mvvmlesson2andriod3.ui.adapters.PhotosAdapter
import com.example.mvvmlesson2andriod3.ui.viewModels.HomeViewModel

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val viewModel by viewModels<HomeViewModel>()
    private var photosAdapter: PhotosAdapter? = PhotosAdapter(this::click)

    private fun click(photo: Photo) {
        val bundle = Bundle().apply {
            putParcelable("selectedPhoto", photo)
        }
        findNavController().navigate(R.id.action_homeFragment_to_detailFragment,bundle)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //это проверяет работает или нет
        // Toast.makeText(requireContext(), viewModel.getPhotos().photos.photo.toString(), Toast.LENGTH_LONG).show()

        setupRecyclerView()
        showPhotos()
    }

    private fun setupRecyclerView() {
        photosAdapter?.let {
            binding.rvPhotos.adapter = it
        }
    }

    private fun showPhotos() {
        photosAdapter?.let {
            val photos = viewModel.getPhotos().photos.photo
            it.submitList(photos)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        photosAdapter = null
    }
}