package com.example.android_exam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android_exam.Adapter.ProductAdapter
import com.example.android_exam.DataBase.RoomDB
import com.example.android_exam.Model.Pro
import com.example.android_exam.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)

        var db = Pro.getInstance(this)

        binding.btnadd.setOnClickListener {
            var Emp = RoomDB(
                binding.edtName.text.toString(),
                binding.edtPrice.text.toString(),
                binding.edtNumber.text.toString()
            )
        }

        binding.btnadd.setOnClickListener {
            db = Pro.getInstance(this)
            var list = db.pro().getpro()
            adapter = ProductAdapter(list)
            binding.rcvproduct.layoutManager = LinearLayoutManager(this)
            binding.rcvproduct.adapter = adapter
        }
    }

    companion object {
        lateinit var  adapter : ProductAdapter
        lateinit var binding: ActivityMainBinding
        lateinit var db : Pro

        fun update() {
            var list = db.pro().getpro()
            adapter = ProductAdapter(list)
            binding.rcvproduct.adapter = adapter
        }
    }
}