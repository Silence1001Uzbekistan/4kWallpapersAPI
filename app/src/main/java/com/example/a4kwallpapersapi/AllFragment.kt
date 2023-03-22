package com.example.a4kwallpapersapi

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.a4kwallpapersapi.Adapters.RvAdapters
import com.example.a4kwallpapersapi.Adapters.SpinnerAdapter
import com.example.a4kwallpapersapi.databinding.FragmentAllBinding
import com.example.a4kwallpapersapi.models.Urls
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
    lateinit var basicList: ArrayList<Movie>

    lateinit var retrofitService: RetrofitService

    private  val TAG = "AllFragment"

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

        retrofitService.getMovie().enqueue(object : Callback<List<Movie>> {
            @SuppressLint("NotifyDataSetChanged")
            override fun onResponse(call: Call<List<Movie>>, response: Response<List<Movie>>) {

                if (response.isSuccessful && response.body() != null) {

                    val list = response.body()
                    list?.forEach {

                        Log.d(TAG, "OnDon:$it")

                    }

                    basicList.addAll(response.body()!!)
                    rvAdapters.notifyDataSetChanged()

                }

            }
            override fun onFailure(call: Call<List<Movie>>, t: Throwable) {


            }

        })

        rvAdapters = RvAdapters(basicList, object : RvAdapters.OnMyItemClickListener {
            override fun onItemClick(urls: Movie, position: Int) {


            }

        })



        binding.rv.adapter = rvAdapters

    }


}