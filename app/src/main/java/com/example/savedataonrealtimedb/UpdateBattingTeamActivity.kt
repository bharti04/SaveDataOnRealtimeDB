package com.example.savedataonrealtimedb

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.add_team_layout.*
import kotlinx.android.synthetic.main.add_team_playername_layout.*
import kotlinx.android.synthetic.main.update_teamforbatting_layout.*

class UpdateBattingTeamActivity:AppCompatActivity() {
    var matchid:String=""
    var keyid:String=""
    var team1name:String=""
    var team2name:String=""
    var chooseBattingteam:String=""
    var status:String=""
    var inning:String=""
    var matchType:String=""

    lateinit var database:FirebaseDatabase
    lateinit var myRef: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.update_teamforbatting_layout)
        val intent = intent
        matchid = intent.getStringExtra("KEY")

         database = FirebaseDatabase.getInstance()
         myRef = database.getReference("matches")



         myRef.addValueEventListener(object: ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {
            }

            override fun onDataChange(p0: DataSnapshot) {
                for (taskNo in p0.children) {
                    // now you in (9223450)
                    keyid = taskNo.key!!
                    val firebaseObj = taskNo.value //class with params set/get methods
                    //   Object replayObj = taskNo.getValue(); //class with params set/get methods
                    if (keyid == matchid) {
                        team1name = taskNo.child("team1").child("name").value!!.toString()
                        team2name = taskNo.child("team2").child("name").value!!.toString()
                        status = taskNo.child("status").value.toString()
                        chooseBattingteam = taskNo.child("chooseBattingTeam").value!!.toString()
                        matchType = taskNo.child("matchType").value!!.toString()
                        inning = taskNo.child("inning").value!!.toString()

                    }
                    team1_radio_bt.setText(team1name)
                    team2_radio_bt.setText(team2name)

                    if(live_radio_bt.text.toString().equals(status))
                    {
                        live_radio_bt.isChecked=true
                    }
                    if(upcoming_radio_bt.text.toString().equals(status))
                    {
                        upcoming_radio_bt.isChecked=true
                    }
                    if(finished_radio_bt.text.toString().equals(status))
                    {
                        finished_radio_bt.isChecked=true
                    }
                    if(team1_radio_bt.text.toString().equals(chooseBattingteam))
                    {
                        team1_radio_bt.isChecked=true
                    }
                    if(team2_radio_bt.text.toString().equals(chooseBattingteam))
                    {
                        team2_radio_bt.isChecked=true
                    }
                    if((chooseBattingteam.equals("")))
                    {
                        team1_radio_bt.isChecked=false
                        team2_radio_bt.isChecked=false        }

                    if(inning1_radio_bt.text.toString().equals(inning))
                    {
                        inning1_radio_bt.isChecked=true
                    }
                    if(inning2_radio_bt.text.toString().equals(inning))
                    {
                        inning2_radio_bt.isChecked=true
                    }

                }
            }

        })
        updatematchstatus_bt.setOnClickListener {
            myRef.child(matchid).child("tossWiningTeam").setValue(tosswin_et.text.toString())

            if(team1_radio_bt.isChecked){
                myRef.child(matchid).child("chooseBattingTeam").setValue(team1_radio_bt.text.toString())

            }else if(team2_radio_bt.isChecked){
                myRef.child(matchid).child("chooseBattingTeam").setValue(team2_radio_bt.text.toString())

            }
            if(inning1_radio_bt.isChecked){
                myRef.child(matchid).child("inning").setValue(inning1_radio_bt.text.toString())
                myRef.child(matchid).child("bowler1CountBalls").setValue("0")
                myRef.child(matchid).child("bowler2CountBalls").setValue("0")

                if(matchType.equals("T20")){
                    myRef.child(matchid).child("remainingBalls").setValue("120")

                }
                else if(matchType.equals("ODI")){
                    myRef.child(matchid).child("remainingBalls").setValue("300")

                }

            }else if(inning2_radio_bt.isChecked){
                myRef.child(matchid).child("inning").setValue(inning2_radio_bt.text.toString())
                myRef.child(matchid).child("bowler1CountBalls").setValue("0")
                myRef.child(matchid).child("bowler2CountBalls").setValue("0")
                if(matchType.equals("T20")){
                    myRef.child(matchid).child("remainingBalls").setValue("120")

                }
                else if(matchType.equals("ODI")){
                    myRef.child(matchid).child("remainingBalls").setValue("300")

                }
            }
            if(live_radio_bt.isChecked){
                myRef.child(matchid).child("status").setValue("Live")

            }else if(upcoming_radio_bt.isChecked){
                myRef.child(matchid).child("status").setValue("Upcoming")

            }
            else if(finished_radio_bt.isChecked){
                myRef.child(matchid).child("status").setValue("Finished")

            }
            val intent= Intent(this,UpdateteamPlayerActivity::class.java)
            intent.putExtra("KEY",matchid)
            startActivity(intent)
        }

    }
}