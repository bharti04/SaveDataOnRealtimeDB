package com.example.savedataonrealtimedb.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.savedataonrealtimedb.R
import com.example.savedataonrealtimedb.UpdateBattingTeamActivity
import com.example.savedataonrealtimedb.dto.DataModal
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.single_match_layout.view.*

class MatchAdapter(val items : ArrayList<DataModal>, val context: Context): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var needrun=""

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val contentItemView = LayoutInflater.from(parent.context).inflate(
                R.layout.single_match_layout, parent, false)
        return ViewHolder(contentItemView)    }

    override fun getItemCount(): Int {
        return items.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val itemsData = items!![position]
        val viewHolder =holder  as ViewHolder
        val database = FirebaseDatabase.getInstance()
        val myRef = database.getReference("matches")

        viewHolder.teamname.text = itemsData.t1name+" "+"v/s"+" "+itemsData.t2name
         viewHolder.delete.setOnClickListener {
             myRef.child(itemsData.key).removeValue()

         }
        viewHolder.linear_layout.setOnClickListener {
             val intent= Intent(context, UpdateBattingTeamActivity::class.java)
               intent.putExtra("KEY",itemsData.key)
               context.startActivity(intent)
        }
       /* Picasso.with(context).load(itemsData.t1flag).into(viewHolder.flagt1mage);
        Picasso.with(context).load(itemsData.t2flag).into(viewHolder.flagt2mage);
*/
    }

    class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
        // Holds the TextView that will add each animal to

        val teamname = view.teamName_tv
        var delete=view.delete_bt
        var  linear_layout=view.linear_layout

        // val itemimage = view.item_image

    }

}