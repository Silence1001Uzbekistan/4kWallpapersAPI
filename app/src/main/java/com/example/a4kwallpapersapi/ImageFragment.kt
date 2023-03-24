package com.example.a4kwallpapersapi

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.a4kwallpapersapi.databinding.FragmentAllBinding
import com.example.a4kwallpapersapi.databinding.FragmentImageBinding
import com.squareup.picasso.Picasso

class ImageFragment : Fragment() {

    lateinit var binding: FragmentImageBinding
    private val TAG = "ImageFragment"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentImageBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var imageV = arguments?.getSerializable("artikov")

        Log.d(TAG, "onViewCreated: $imageV")

        Picasso.get().load(imageV.toString()).into(binding.imageId)


    }


}