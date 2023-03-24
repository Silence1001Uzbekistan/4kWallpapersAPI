package com.example.a4kwallpapersapi

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.a4kwallpapersapi.Adapters.RvAdapters
import com.example.a4kwallpapersapi.databinding.FragmentNatureBinding
import com.example.a4kwallpapersapi.models.UrlsX
import com.example.a4kwallpapersapi.models.Wallpapers
import com.example.introductionretrofit.retrofit.Common
import com.example.introductionretrofit.retrofit.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NatureFragment : Fragment() {

    lateinit var binding: FragmentNatureBinding


    lateinit var rvAdapters: RvAdapters
    lateinit var basicList: ArrayList<UrlsX>

    lateinit var retrofitService: RetrofitService

    private val TAG = "AllFragment"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNatureBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        basicList = ArrayList()


        retrofitService = Common.retrofitService

        retrofitService.getMovie("nature", "PHP2e0dRV5BWShWG6ML_nKv8CigifWTD_4WlXXZCNIg")
            .enqueue(object : Callback<Wallpapers> {
                @SuppressLint("NotifyDataSetChanged")
                override fun onResponse(
                    call: Call<Wallpapers>,
                    response: Response<Wallpapers>
                ) {

                    Log.d(TAG, "onResponse: {${response.isSuccessful}}")

                    if (response.isSuccessful && response.body() != null) {

                        val list = response.body()!!.results
                        list?.forEach {

                            Log.d(TAG, "OnDon:$it")

                        }
                        for (wallpaper in response.body()!!.results) {
                            basicList.add(wallpaper.urls)
                        }

                        rvAdapters.notifyDataSetChanged()

                    }

                }

                override fun onFailure(call: Call<Wallpapers>, t: Throwable) {


                    Log.d(TAG, "onFailure: ${t.message}")

                }

            })

        rvAdapters = RvAdapters(basicList, object : RvAdapters.OnMyItemClickListener {
            override fun onItemClick(urls: UrlsX, position: Int) {
                val bundle = Bundle()

                bundle.putSerializable("artikov", urls.small)

                findNavController().navigate(R.id.imageFragment,bundle)

            }


        })

        binding.rv.layoutManager = GridLayoutManager(requireContext(), 2)

        binding.rv.adapter = rvAdapters

    }


}