package com.example.a4kwallpapersapi

import android.annotation.SuppressLint
import android.app.DownloadManager.Query
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.a4kwallpapersapi.Adapters.RvAdapters
import com.example.a4kwallpapersapi.Adapters.SpinnerAdapter
import com.example.a4kwallpapersapi.databinding.FragmentAllBinding
import com.example.a4kwallpapersapi.models.Urls
import com.example.a4kwallpapersapi.models.WallpapersItem
import com.example.a4kwallpapersapi.modelsThree.UsersItem
import com.example.a4kwallpapersapi.modelsTwo.Movie
import com.example.introductionretrofit.retrofit.Common
import com.example.introductionretrofit.retrofit.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AllFragment : Fragment() {

    lateinit var binding: FragmentAllBinding


    lateinit var rvAdapters: RvAdapters
    lateinit var basicList: ArrayList<Urls>

    lateinit var retrofitService: RetrofitService

    private val TAG = "AllFragment"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentAllBinding.inflate(inflater, container, false)

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        basicList = ArrayList()


        retrofitService = Common.retrofitService

        retrofitService.getMovie("travel", "PHP2e0dRV5BWShWG6ML_nKv8CigifWTD_4WlXXZCNIg")
            .enqueue(object : Callback<List<WallpapersItem>> {
                @SuppressLint("NotifyDataSetChanged")
                override fun onResponse(
                    call: Call<List<WallpapersItem>>,
                    response: Response<List<WallpapersItem>>
                ) {

                    Log.d(TAG, "onResponse: {${response.isSuccessful}}")

                    if (response.isSuccessful && response.body() != null) {

                        val list = response.body()
                        list?.forEach {

                            Log.d(TAG, "OnDon:$it")

                        }
                        for (wallpaper in response.body()!!) {
                            basicList.add(wallpaper.urls)
                        }

                        rvAdapters.notifyDataSetChanged()

                    }

                }

                override fun onFailure(call: Call<List<WallpapersItem>>, t: Throwable) {


                    Log.d(TAG, "onFailure: ${t.message}")

                }

            })

        rvAdapters = RvAdapters(basicList, object : RvAdapters.OnMyItemClickListener {
            override fun onItemClick(urls: Urls, position: Int) {


            }


        })

        binding.rv.layoutManager = GridLayoutManager(requireContext(), 2)

        binding.rv.adapter = rvAdapters

    }


}