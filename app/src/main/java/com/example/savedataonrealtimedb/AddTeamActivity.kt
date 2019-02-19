package com.example.savedataonrealtimedb

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.add_team_layout.*
import kotlinx.android.synthetic.main.add_team_playername_layout.*

class AddTeamActivity:AppCompatActivity() {
     var matchid:String=""
    var keyid:String=""
    var team1name:String=""

    var team2name:String=""
    lateinit var database:FirebaseDatabase
    lateinit var myRef: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_team_playername_layout)
        val intent = intent
        matchid = intent.getStringExtra("KEY")

         database = FirebaseDatabase.getInstance()
         myRef = database.getReference("matches")

        myRef.addValueEventListener(object:ValueEventListener{
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

                    }
                    team1_tv.setText("Team"+" "+team1name+" "+"Player")
                    team2_tv.setText("Team"+" "+team2name+" "+"Player")

                }
            }

        })
        submitplayer_bt.setOnClickListener {
            addchild("0","team1",t1player1_et.text.toString())
            addchild("1","team1",t1player2_et.text.toString())
            addchild("2","team1",t1player3_et.text.toString())
            addchild("3","team1",t1player4_et.text.toString())
            addchild("4","team1",t1player5_et.text.toString())
            addchild("5","team1",t1player6_et.text.toString())
            addchild("6","team1",t1player7_et.text.toString())
            addchild("7","team1",t1player8_et.text.toString())
            addchild("8","team1",t1player9_et.text.toString())
            addchild("9","team1",t1player10_et.text.toString())
            addchild("10","team1",t1player11_et.text.toString())
            addchild("11","team1",t1extraplayer_et.text.toString())

            addchild("0","team2",t2player1_et.text.toString())
            addchild("1","team2",t2player2_et.text.toString())
            addchild("2","team2",t2player3_et.text.toString())
            addchild("3","team2",t2player4_et.text.toString())
            addchild("4","team2",t2player5_et.text.toString())
            addchild("5","team2",t2player6_et.text.toString())
            addchild("6","team2",t2player7_et.text.toString())
            addchild("7","team2",t2player8_et.text.toString())
            addchild("8","team2",t2player9_et.text.toString())
            addchild("9","team2",t2player10_et.text.toString())
            addchild("10","team2",t2player11_et.text.toString())
            addchild("11","team2",t2extraplayer_et.text.toString())
            Toast.makeText(this,"Successfully Player Add",Toast.LENGTH_LONG).show()
            val intent= Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

    }
    fun addchild(id:String,teamid:String,playername:String){
        myRef.child(matchid).child(teamid).child("players").child(id).child("name").setValue(playername)
        myRef.child(matchid).child(teamid).child("players").child(id).child("batting").child("R").setValue("0")
        myRef.child(matchid).child(teamid).child("players").child(id).child("batting").child("B").setValue("0")
        myRef.child(matchid).child(teamid).child("players").child(id).child("batting").child("4s").setValue("0")
        myRef.child(matchid).child(teamid).child("players").child(id).child("batting").child("6s").setValue("0")
        myRef.child(matchid).child(teamid).child("players").child(id).child("bowling").child("O").setValue("0")
        myRef.child(matchid).child(teamid).child("players").child(id).child("bowling").child("M").setValue("0")
        myRef.child(matchid).child(teamid).child("players").child(id).child("bowling").child("R").setValue("0")
        myRef.child(matchid).child(teamid).child("players").child(id).child("bowling").child("W").setValue("0")

    }

}