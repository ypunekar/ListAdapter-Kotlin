package com.example.mylistadapterapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private val mRecyclerView by lazy { findViewById<RecyclerView>(R.id.recycler_view) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val user = ArrayList<User>()

        user.add(User(name = "Yogita Punekar"))
        user.add(User(name = "PQR ZWQ"))
        user.add(User(name = "Abc Xyz"))

       val userAdapter = UserAdapter(::onClick)

        mRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            addItemDecoration(DividerItemDecoration(this@MainActivity, DividerItemDecoration.VERTICAL))
            itemAnimator = DefaultItemAnimator()
            adapter = userAdapter
        }

        // Post data using submitList method
        userAdapter.submitList(user)
    }
    private fun onClick(user: User) {
        Toast.makeText(this, "${user.name} clicked", Toast.LENGTH_SHORT).show()
    }

}