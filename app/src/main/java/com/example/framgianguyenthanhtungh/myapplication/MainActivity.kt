package com.example.framgianguyenthanhtungh.myapplication

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.example.framgianguyenthanhtungh.myapplication.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.viewModel = viewModel
        val list: ArrayList<Item> = ArrayList()
        list.add(Item("Halo"))
        list.add(Item("Halo1"))
        list.add(Item("Halo2"))
        list.add(Item("Halo3"))
        list.add(Item("Halo4"))
        val adapter1 = Adapter(
            list,
            onItemClick = {
                click(it)
            }
        )
        val layoutManager = LinearLayoutManager(applicationContext)
        binding.recycler.layoutManager = layoutManager
        binding.recycler.adapter = adapter1
    }

    private fun click(it: Item) {
        Toast.makeText(this, it.string, Toast.LENGTH_LONG).show()
    }
}
