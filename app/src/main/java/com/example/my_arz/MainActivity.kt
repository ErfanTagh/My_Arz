 package com.example.my_arz


import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.log


class MainActivity : AppCompatActivity() {



    private lateinit var viewModel: MainViewModel

    private lateinit var adapter: ArzesAdapter

    private var arzeslist: ArrayList<Arz> = ArrayList()
    private lateinit var mRunnable:Runnable

    private lateinit var mHandler: Handler



    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mHandler = Handler()







        val repository = Repository()
        val viewModelFactory =MainViewModelFactory(repository)



        viewModel =  ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        viewModel.getArz()

        recycler_main.layoutManager = LinearLayoutManager(this)
        viewModel.myResponse.observe(this, Observer {

                response ->

            arzeslist = response as ArrayList<Arz>

            adapter = ArzesAdapter(arzeslist)
            recycler_main.adapter= adapter

            Log.e("Adapter size" , adapter.itemCount.toString())





        })

        swipe.setColorSchemeColors(android.R.color.white)
        swipe.setOnRefreshListener {

            swipe.isRefreshing = true
            viewModel.getArz()

            viewModel.myResponse.observe(this, Observer {

                    response ->

                arzeslist = response as ArrayList<Arz>


                adapter.setList(arzeslist)
                adapter.notifyDataSetChanged()
                Log.e("Adapter size" , adapter.itemCount.toString())


                swipe.isRefreshing=false


            })




        }


        // call api to reload the screen


        //** Set the colors of the Pull To Refresh View

    }




}