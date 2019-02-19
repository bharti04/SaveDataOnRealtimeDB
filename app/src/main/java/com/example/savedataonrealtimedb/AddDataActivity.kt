package com.example.savedataonrealtimedb

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.add_team_layout.*
import kotlinx.android.synthetic.main.add_team_playername_layout.*
import kotlinx.android.synthetic.main.batsman_select_layout.*

class AddDataActivity:AppCompatActivity() {
    lateinit var database:FirebaseDatabase
    lateinit var myRef:DatabaseReference
    var keypath:String?=null
    var childpath:String?=null
    lateinit var dialog: ProgressDialog
    var createMatch=false
    val mHandler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_team_layout)
        //for add child object
         database = FirebaseDatabase.getInstance()
         myRef = database.getReference("matches")

        dialog = ProgressDialog(this@AddDataActivity)
        dialog.setMessage("Please wait...")

        submit_bt.setOnClickListener {
            if(!createMatch) {
                pleasewait_tv.visibility=View.VISIBLE
               // dialog.show()

                keypath = myRef.push().key
                myRef.child(this!!.keypath!!).child("remainingBalls").setValue("0")
                myRef.child(this!!.keypath!!).child("batsmanStrike").setValue("")
                myRef.child(this!!.keypath!!).child("bowlerStrike").setValue("")
                myRef.child(this!!.keypath!!).child("chooseBattingTeam").setValue("")
                myRef.child(this!!.keypath!!).child("inning").setValue("")
                myRef.child(this!!.keypath!!).child("tossWiningTeam").setValue("")
                myRef.child(this!!.keypath!!).child("matchType").setValue("")
                myRef.child(this!!.keypath!!).child("status").setValue("")
                myRef.child(this!!.keypath!!).child("batsman1").setValue("")
                myRef.child(this!!.keypath!!).child("batsman2").setValue("")
                myRef.child(this!!.keypath!!).child("bowler1").setValue("")
                myRef.child(this!!.keypath!!).child("bowler2").setValue("")
                myRef.child(this!!.keypath!!).child("bowler1CountBalls").setValue("0")
                myRef.child(this!!.keypath!!).child("bowler2CountBalls").setValue("0")





                myRef.child(this!!.keypath!!).child("team1").child("run").setValue("0")
                myRef.child(this!!.keypath!!).child("team1").child("over").setValue("0")
                myRef.child(this!!.keypath!!).child("team1").child("wicket").setValue("0")

                myRef.child(this!!.keypath!!).child("team2").child("run").setValue("0")
                myRef.child(this!!.keypath!!).child("team2").child("over").setValue("0")
                myRef.child(this!!.keypath!!).child("team2").child("wicket").setValue("0")

                myRef.child(this!!.keypath!!).child("team1").child("name").setValue(team1_et.text.toString())
               // myRef.child(this!!.keypath!!).child("team1").child("flag").setValue(team1flagurl_et.text.toString())
                myRef.child(this!!.keypath!!).child("team2").child("name").setValue(team2_et.text.toString())
               // myRef.child(this!!.keypath!!).child("team2").child("flag").setValue(team2flagurl_et.text.toString())

                if (t20_radio_bt.isChecked) {
                    myRef.child(this!!.keypath!!).child("matchType").setValue("T20")
                    //myRef.child(this!!.keypath!!).child("remainingBalls").setValue("120")


                } else if (odi_radio_bt.isChecked) {
                    myRef.child(this!!.keypath!!).child("matchType").setValue("ODI")
                    // myRef.child(this!!.keypath!!).child("remainingBalls").setValue("300")


                }
                addchild("0", "team1", "")
                addchild("1", "team1", "")
                addchild("2", "team1", "")
                addchild("3", "team1", "")
                addchild("4", "team1", "")
                addchild("5", "team1", "")
                addchild("6", "team1", "")
                addchild("7", "team1", "")
                addchild("8", "team1", "")
                addchild("9", "team1", "")
                addchild("10", "team1", "")
                addchild("11", "team1", "")

                addchild("0", "team2", "")
                addchild("1", "team2", "")
                addchild("2", "team2", "")
                addchild("3", "team2", "")
                addchild("4", "team2", "")
                addchild("5", "team2", "")
                addchild("6", "team2", "")
                addchild("7", "team2", "")
                addchild("8", "team2", "")
                addchild("9", "team2", "")
                addchild("10", "team2", "")
                addchild("11", "team2", "")
                createMatch=true
            }
            mHandler.postDelayed(object : Runnable {
                override fun run() {
                    if(createMatch) {
                        pleasewait_tv.visibility=View.INVISIBLE
                       // dialog.dismiss()
                        val intent = Intent(this@AddDataActivity, AddTeamActivity::class.java)
                        intent.putExtra("KEY", keypath)
                        startActivity(intent)
                    }
                }
            }, 5000) // 4 seconds

        }
    }
    fun addchild(id:String,teamid:String,playername:String){

        myRef.child(this!!.keypath!!).child(teamid).child("players").child(id).child("name").setValue(playername)
        myRef.child(this!!.keypath!!).child(teamid).child("players").child(id).child("batting").child("R").setValue("0")
        myRef.child(this!!.keypath!!).child(teamid).child("players").child(id).child("batting").child("B").setValue("0")
        myRef.child(this!!.keypath!!).child(teamid).child("players").child(id).child("batting").child("4s").setValue("0")
        myRef.child(this!!.keypath!!).child(teamid).child("players").child(id).child("batting").child("6s").setValue("0")
        myRef.child(this!!.keypath!!).child(teamid).child("players").child(id).child("bowling").child("O").setValue("0")
        myRef.child(this!!.keypath!!).child(teamid).child("players").child(id).child("bowling").child("M").setValue("0")
        myRef.child(this!!.keypath!!).child(teamid).child("players").child(id).child("bowling").child("R").setValue("0")
        myRef.child(this!!.keypath!!).child(teamid).child("players").child(id).child("bowling").child("W").setValue("0")

    }

}