package com.example.mvvmlesson2andriod3.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.mvvmlesson2andriod3.R
import com.example.mvvmlesson2andriod3.databinding.FragmentDeteilBinding
import com.example.mvvmlesson2andriod3.models.Photo
import com.example.mvvmlesson2andriod3.utils.loadImage

class DetailFragment : Fragment() {

    private var _binding: FragmentDeteilBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDeteilBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val photo = arguments?.getParcelable<Photo>("selectedPhoto")
        photo?.let {
            binding.tvNameDetail.text = it.title
            binding.ivImageDetail.contentDescription =  binding.root.context.getString(R.string.photo, photo.title)
            val imageUrl = "https://farm66.staticflickr.com/${photo.server}/${photo.id}_${photo.secret}.jpg"
            binding.ivImageDetail.loadImage(imageUrl)
        }
        arroeBack()
    }

    private fun arroeBack() {
        binding.ivArrowDetail.setOnClickListener {
            findNavController().navigate(R.id.homeFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}