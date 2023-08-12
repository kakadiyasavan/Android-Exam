package com.example.android_exam.Adapter

import android.app.Dialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.android_exam.DataBase.RoomDB
import com.example.android_exam.MainActivity
import com.example.android_exam.Model.Pro
import com.example.android_exam.R

class ProductAdapter(list: List<RoomDB>) : RecyclerView.Adapter<ProductAdapter.ProductHolder>() {

    lateinit var context: Context
    var list = list

    class ProductHolder(itemView: View) : ViewHolder(itemView) {
        var id = itemView.findViewById<TextView>(R.id.tvid)
        var name = itemView.findViewById<TextView>(R.id.tvname)
        var price = itemView.findViewById<TextView>(R.id.tvprice)
        var number = itemView.findViewById<TextView>(R.id.tvnumber)
        var delete = itemView.findViewById<Button>(R.id.btndelete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductHolder {
        context = parent.context
        return ProductHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.show_products, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ProductHolder, position: Int) {
        var db = Pro.getInstance(context)
        holder.apply {
            id.text = list[position].id.toString()
            name.text = list[position].name.toString()
            price.text = list[position].price.toString()
            number.text = list[position].number.toString()
        }
        holder.delete.setOnClickListener {
            var Dialog = Dialog(context)
            Dialog.setContentView(R.layout.update_item)

            var edtname = Dialog.findViewById<EditText>(R.id.edtName)
            var edtprice = Dialog.findViewById<EditText>(R.id.edtPrice)
            var edtnumber = Dialog.findViewById<EditText>(R.id.edtNumber)
            var update = Dialog.findViewById<Button>(R.id.btnupdate)

            edtname.setText(list.get(position).name)
            edtprice.setText(list.get(position).price)
            edtnumber.setText(list.get(position).number)

            update.setOnClickListener {
                var data = RoomDB(
                    edtname.text.toString(),
                    edtprice.text.toString(),
                    edtnumber.text.toString()
                )
                data.id = list[position].id
                db.pro().updatepro(data)
                Dialog.dismiss()
                MainActivity.update()
            }
        }
        holder.delete.setOnClickListener {
            db.pro().deletepro(list[position])
            MainActivity.update()
        }
    }
}