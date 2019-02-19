package com.example.savedataonrealtimedb

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.add_team_layout.*
import kotlinx.android.synthetic.main.batsman_select_layout.*
import kotlinx.android.synthetic.main.team_player_update_layout.*

class UpdateteamPlayerActivity:AppCompatActivity() {
var matchid:String=""

    var t1name:String=""
    var t1run:String=""
    var t1over:String=""
    var t1viket:String=""
    var t2name:String=""
    var t2run:String=""
    var t2over:String=""
    var t2viket:String=""
    var t1flag:String=""
    var t2flag:String=""
    var status:String=""
    var matchType:String=""
    var inning:String=""




    var keyid:String=""



    var needrun=""
    var remainingballs:String=""


    var bowler1run:String=""
    var bowler2run:String=""
    var bowler1over:String=""
    var bowler2over:String=""
    var bowler1name:String=""
    var bowler2name:String=""

    var t1b1name:String=""
    var t1b2name:String=""
    var t1b3name:String=""
    var t1b4name:String=""
    var t1b5name:String=""
    var t1b6name:String=""
    var t1b7name:String=""
    var t1b8name:String=""
    var t1b9name:String=""
    var t1b10name:String=""
    var t1b11name:String=""
    var t1b12name:String=""




    var t1brun:String=""
    var t1bball:String=""
    var t1b4s:String=""
    var t1b6s:String=""
    var t1bowlerW:String=""
    var t1bowlerRun:String=""
    var t1bowlerOver:String=""
    var t1bowlerM:String=""

    var t2b1name:String=""
    var t2b2name:String=""
    var t2b3name:String=""
    var t2b4name:String=""
    var t2b5name:String=""
    var t2b6name:String=""
    var t2b7name:String=""
    var t2b8name:String=""
    var t2b9name:String=""
    var t2b10name:String=""
    var t2b11name:String=""
    var t2b12name:String=""






    var t2brun:String=""
    var t2bball:String=""
    var t2b4s:String=""
    var t2b6s:String=""
    var t2bowlerW:String=""
    var t2bowlerRun:String=""
    var t2bowlerOver:String=""
    var t2bowlerM:String=""

    var b2name:String=""
    var b1run:String=""
    var b2run:String=""
    var b1ball:String=""
    var b2ball:String=""
    var b14s:String=""
    var b24s:String=""
    var b16s:String=""
    var b26s:String=""

    var wicket:String=""
    var choosebattingteam:String=""
    var child1:String=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.batsman_select_layout)
        val intent = intent
        matchid = intent.getStringExtra("KEY")

        val database = FirebaseDatabase.getInstance()
        val myRef = database.getReference("matches")

          next_bt.setOnClickListener {
              if(p1check.isChecked){
                  myRef.child(matchid).child("batsman1").setValue(p1check.text.toString())

              }else if(p2check.isChecked){
                  myRef.child(matchid).child("batsman1").setValue(p2check.text.toString())

              }
              else if(p3check.isChecked){
                  myRef.child(matchid).child("batsman1").setValue(p3check.text.toString())

              }else if(p4check.isChecked){
                  myRef.child(matchid).child("batsman1").setValue(p4check.text.toString())

              }else if(p5check.isChecked){
                  myRef.child(matchid).child("batsman1").setValue(p5check.text.toString())

              }else if(p6check.isChecked){
                  myRef.child(matchid).child("batsman1").setValue(p6check.text.toString())

              }else if(p7check.isChecked){
                  myRef.child(matchid).child("batsman1").setValue(p7check.text.toString())

              }else if(p8check.isChecked){
                  myRef.child(matchid).child("batsman1").setValue(p8check.text.toString())

              }else if(p9check.isChecked){
                  myRef.child(matchid).child("batsman1").setValue(p9check.text.toString())

              }else if(p10check.isChecked){
                  myRef.child(matchid).child("batsman1").setValue(p10check.text.toString())

              }else if(p11check.isChecked){
                  myRef.child(matchid).child("batsman1").setValue(p11check.text.toString())

              }else if(extrapcheck.isChecked){
                  myRef.child(matchid).child("batsman1").setValue(extrapcheck.text.toString())

              }

              if(player1check.isChecked){
                  myRef.child(matchid).child("batsman2").setValue(player1check.text.toString())

              }else if(player2check.isChecked){
                  myRef.child(matchid).child("batsman2").setValue(player2check.text.toString())

              }
              else if(player3check.isChecked){
                  myRef.child(matchid).child("batsman2").setValue(player3check.text.toString())

              }else if(player4check.isChecked){
                  myRef.child(matchid).child("batsman2").setValue(player4check.text.toString())

              }else if(player5check.isChecked){
                  myRef.child(matchid).child("batsman2").setValue(player5check.text.toString())

              }else if(player6check.isChecked){
                  myRef.child(matchid).child("batsman2").setValue(player6check.text.toString())

              }else if(player7check.isChecked){
                  myRef.child(matchid).child("batsman2").setValue(player7check.text.toString())

              }else if(player8check.isChecked){
                  myRef.child(matchid).child("batsman2").setValue(player8check.text.toString())

              }else if(player9check.isChecked){
                  myRef.child(matchid).child("batsman2").setValue(player9check.text.toString())

              }else if(player10check.isChecked){
                  myRef.child(matchid).child("batsman2").setValue(player10check.text.toString())

              }else if(player11check.isChecked){
                  myRef.child(matchid).child("batsman2").setValue(player11check.text.toString())

              }else if(extraplayercheck.isChecked){
                  myRef.child(matchid).child("batsman2").setValue(extraplayercheck.text.toString())

              }

              if(b1check.isChecked){
                  myRef.child(matchid).child("bowler1").setValue(b1check.text.toString())

              }else if(b2check.isChecked){
                  myRef.child(matchid).child("bowler1").setValue(b2check.text.toString())

              }
              else if(b3check.isChecked){
                  myRef.child(matchid).child("bowler1").setValue(b3check.text.toString())

              }else if(b4check.isChecked){
                  myRef.child(matchid).child("bowler1").setValue(b4check.text.toString())

              }else if(b5check.isChecked){
                  myRef.child(matchid).child("bowler1").setValue(b5check.text.toString())

              }else if(b6check.isChecked){
                  myRef.child(matchid).child("bowler1").setValue(b6check.text.toString())

              }else if(b7check.isChecked){
                  myRef.child(matchid).child("bowler1").setValue(b7check.text.toString())

              }else if(b8check.isChecked){
                  myRef.child(matchid).child("bowler1").setValue(b8check.text.toString())

              }else if(b9check.isChecked){
                  myRef.child(matchid).child("bowler1").setValue(b9check.text.toString())

              }else if(b10check.isChecked){
                  myRef.child(matchid).child("bowler1").setValue(b10check.text.toString())

              }else if(b11check.isChecked){
                  myRef.child(matchid).child("bowler1").setValue(b11check.text.toString())

              }else if(extrabcheck.isChecked){
                  myRef.child(matchid).child("bowler1").setValue(extrabcheck.text.toString())

              }

              if(bowler1check.isChecked){
                  myRef.child(matchid).child("bowler2").setValue(bowler1check.text.toString())

              }else if(bowler2check.isChecked){
                  myRef.child(matchid).child("bowler2").setValue(bowler2check.text.toString())

              }
              else if(bowler3check.isChecked){
                  myRef.child(matchid).child("bowler2").setValue(bowler3check.text.toString())

              }else if(bowler4check.isChecked){
                  myRef.child(matchid).child("bowler2").setValue(bowler4check.text.toString())

              }else if(bowler5check.isChecked){
                  myRef.child(matchid).child("bowler2").setValue(bowler5check.text.toString())

              }else if(bowler6check.isChecked){
                  myRef.child(matchid).child("bowler2").setValue(bowler6check.text.toString())

              }else if(bowler7check.isChecked){
                  myRef.child(matchid).child("bowler2").setValue(bowler7check.text.toString())

              }else if(bowler8check.isChecked){
                  myRef.child(matchid).child("bowler2").setValue(bowler8check.text.toString())

              }else if(bowler9check.isChecked){
                  myRef.child(matchid).child("bowler2").setValue(bowler9check.text.toString())

              }else if(bowler10check.isChecked){
                  myRef.child(matchid).child("bowler2").setValue(bowler10check.text.toString())

              }else if(bowler11check.isChecked){
                  myRef.child(matchid).child("bowler2").setValue(bowler11check.text.toString())

              }else if(extrabowlercheck.isChecked){
                  myRef.child(matchid).child("bowler2").setValue(extrabowlercheck.text.toString())

              }
              val intent= Intent(this,UpdateMatchActivity::class.java)
              intent.putExtra("KEY",matchid)
              startActivity(intent)

          }

        myRef.addValueEventListener(object : ValueEventListener {
            @SuppressLint("SetTextI18n")
            override fun onDataChange(dataSnapshot: DataSnapshot) {
               /* if (arrayList.size > 0) {
                    arrayList.clear()
                }*/
                for (taskNo in dataSnapshot.children) {
                    // now you in (9223450)
                    keyid = taskNo.key!!
                    val firebaseObj = taskNo.value //class with params set/get methods
                    //   Object replayObj = taskNo.getValue(); //class with params set/get methods
                    if (keyid == matchid) {

                        choosebattingteam = taskNo.child("chooseBattingTeam").value!!.toString()

                        inning = taskNo.child("inning").value!!.toString()

                         child1= taskNo.children.toString()

                        for (child in taskNo.children) {
                            if (child.key == "team1") {
                                t1name = child.child("name").value!!.toString()
                                t1b1name = child.child("players").child("0").child("name").value!!.toString()
                                t1b2name = child.child("players").child("1").child("name").value!!.toString()
                                t1b3name = child.child("players").child("2").child("name").value!!.toString()
                                t1b4name = child.child("players").child("3").child("name").value!!.toString()
                                t1b5name = child.child("players").child("4").child("name").value!!.toString()
                                t1b6name = child.child("players").child("5").child("name").value!!.toString()
                                t1b7name = child.child("players").child("6").child("name").value!!.toString()
                                t1b8name = child.child("players").child("7").child("name").value!!.toString()
                                t1b9name = child.child("players").child("8").child("name").value!!.toString()
                                t1b10name = child.child("players").child("9").child("name").value!!.toString()
                                t1b11name = child.child("players").child("10").child("name").value!!.toString()
                                t1b12name = child.child("players").child("11").child("name").value!!.toString()

                               /* getPlayerst1(child,"0")
                               getPlayerst1(child,"1")
                               getPlayerst1(child,"2")
                               getPlayerst1(child,"3")
                               getPlayerst1(child,"4")
                               getPlayerst1(child,"5")
                               getPlayerst1(child,"6")
                               getPlayerst1(child,"7")
                               getPlayerst1(child,"8")
                               getPlayerst1(child,"9")
                               getPlayerst1(child,"10")
                               getPlayerst1(child,"11")*/




                            } else if (child.key == "team2") {
                                t2name = child.child("name").value!!.toString()
                                t2b1name = child.child("players").child("0").child("name").value!!.toString()
                                t2b2name = child.child("players").child("1").child("name").value!!.toString()
                                t2b3name = child.child("players").child("2").child("name").value!!.toString()
                                t2b4name = child.child("players").child("3").child("name").value!!.toString()
                                t2b5name = child.child("players").child("4").child("name").value!!.toString()
                                t2b6name = child.child("players").child("5").child("name").value!!.toString()
                                t2b7name = child.child("players").child("6").child("name").value!!.toString()
                                t2b8name = child.child("players").child("7").child("name").value!!.toString()
                                t2b9name = child.child("players").child("8").child("name").value!!.toString()
                                t2b10name = child.child("players").child("9").child("name").value!!.toString()
                                t2b11name = child.child("players").child("10").child("name").value!!.toString()
                                t2b12name = child.child("players").child("11").child("name").value!!.toString()

                                /*getPlayerst2(child,"0")
                                getPlayerst2(child,"1")
                                getPlayerst2(child,"2")
                                getPlayerst2(child,"3")
                                getPlayerst2(child,"4")
                                getPlayerst2(child,"5")
                                getPlayerst2(child,"6")
                                getPlayerst2(child,"7")
                                getPlayerst2(child,"8")
                                getPlayerst2(child,"9")
                                getPlayerst2(child,"10")
                                getPlayerst2(child,"11")*/
                            }



                        }
                    }

                     if(choosebattingteam.equals(t1name)){
                         p1check.setText(t1b1name)
                         p2check.setText(t1b2name)
                         p3check.setText(t1b3name)
                         p4check.setText(t1b4name)
                         p5check.setText(t1b5name)
                         p6check.setText(t1b6name)
                         p7check.setText(t1b7name)
                         p8check.setText(t1b8name)
                         p9check.setText(t1b9name)
                         p10check.setText(t1b10name)
                         p11check.setText(t1b11name)
                         extrapcheck.setText(t1b12name)

                         player1check.setText(t1b1name)
                         player2check.setText(t1b2name)
                         player3check.setText(t1b3name)
                         player4check.setText(t1b4name)
                         player5check.setText(t1b5name)
                         player6check.setText(t1b6name)
                         player7check.setText(t1b7name)
                         player8check.setText(t1b8name)
                         player9check.setText(t1b9name)
                         player10check.setText(t1b10name)
                         player11check.setText(t1b11name)
                         extraplayercheck.setText(t1b12name)
                     }else{
                         b1check.setText(t1b1name)
                         b2check.setText(t1b2name)
                         b3check.setText(t1b3name)
                         b4check.setText(t1b4name)
                         b5check.setText(t1b5name)
                         b6check.setText(t1b6name)
                         b7check.setText(t1b7name)
                         b8check.setText(t1b8name)
                         b9check.setText(t1b9name)
                         b10check.setText(t1b10name)
                         b11check.setText(t1b11name)
                         extrabcheck.setText(t1b12name)

                         bowler1check.setText(t1b1name)
                         bowler2check.setText(t1b2name)
                         bowler3check.setText(t1b3name)
                         bowler4check.setText(t1b4name)
                         bowler5check.setText(t1b5name)
                         bowler6check.setText(t1b6name)
                         bowler7check.setText(t1b7name)
                         bowler8check.setText(t1b8name)
                         bowler9check.setText(t1b9name)
                         bowler10check.setText(t1b10name)
                         bowler11check.setText(t1b11name)
                         extrabowlercheck.setText(t1b12name)
                     }
                     if(choosebattingteam.equals(t2name)){
                        p1check.setText(t2b1name)
                        p2check.setText(t2b2name)
                        p3check.setText(t2b3name)
                        p4check.setText(t2b4name)
                        p5check.setText(t2b5name)
                        p6check.setText(t2b6name)
                        p7check.setText(t2b7name)
                        p8check.setText(t2b8name)
                        p9check.setText(t2b9name)
                        p10check.setText(t2b10name)
                        p11check.setText(t2b11name)
                        extrapcheck.setText(t2b12name)

                         player1check.setText(t2b1name)
                         player2check.setText(t2b2name)
                         player3check.setText(t2b3name)
                         player4check.setText(t2b4name)
                         player5check.setText(t2b5name)
                         player6check.setText(t2b6name)
                         player7check.setText(t2b7name)
                         player8check.setText(t2b8name)
                         player9check.setText(t2b9name)
                         player10check.setText(t2b10name)
                         player11check.setText(t2b11name)
                         extraplayercheck.setText(t2b12name)

                    }else{
                        b1check.setText(t2b1name)
                        b2check.setText(t2b2name)
                        b3check.setText(t2b3name)
                        b4check.setText(t2b4name)
                        b5check.setText(t2b5name)
                        b6check.setText(t2b6name)
                        b7check.setText(t2b7name)
                        b8check.setText(t2b8name)
                        b9check.setText(t2b9name)
                        b10check.setText(t2b10name)
                        b11check.setText(t2b11name)
                        extrabcheck.setText(t2b12name)

                         bowler1check.setText(t2b1name)
                         bowler2check.setText(t2b2name)
                         bowler3check.setText(t2b3name)
                         bowler4check.setText(t2b4name)
                         bowler5check.setText(t2b5name)
                         bowler6check.setText(t2b6name)
                         bowler7check.setText(t2b7name)
                         bowler8check.setText(t2b8name)
                         bowler9check.setText(t2b9name)
                         bowler10check.setText(t2b10name)
                         bowler11check.setText(t2b11name)
                         extrabowlercheck.setText(t2b12name)
                    }


                }



                //Log.d("bharti", "Value is: " + value.tosswinteam);
            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                Log.w("bharti", "Failed to read value.", error.toException())
            }
        })




    }
    /*fun getPlayerst1(child: DataSnapshot, key:String){
        t1bname = child.child("players").child(key).child("name").value!!.toString()
        t1brun = child.child("players").child(key).child("batting").child("R").value!!.toString()
        t1bball = child.child("players").child(key).child("batting").child("B").value!!.toString()
        t1b4s = child.child("players").child(key).child("batting").child("4s").value!!.toString()
        t1b6s = child.child("players").child(key).child("batting").child("6s").value!!.toString()
        t1bowlerM = child.child("players").child(key).child("bowling").child("M").value!!.toString()
        t1bowlerOver = child.child("players").child(key).child("bowling").child("O").value!!.toString()
        t1bowlerRun = child.child("players").child(key).child("bowling").child("R").value!!.toString()
        t1bowlerW = child.child("players").child(key).child("bowling").child("W").value!!.toString()

    }
    fun getPlayerst2(child: DataSnapshot, key:String){
        t2bname = child.child("players").child(key).child("name").value!!.toString()
        t2brun = child.child("players").child(key).child("batting").child("R").value!!.toString()
        t2bball = child.child("players").child(key).child("batting").child("B").value!!.toString()
        t2b4s = child.child("players").child(key).child("batting").child("4s").value!!.toString()
        t2b6s = child.child("players").child(key).child("batting").child("6s").value!!.toString()
        t2bowlerM = child.child("players").child(key).child("bowling").child("M").value!!.toString()
        t2bowlerOver = child.child("players").child(key).child("bowling").child("O").value!!.toString()
        t2bowlerRun = child.child("players").child(key).child("bowling").child("R").value!!.toString()
        t2bowlerW = child.child("players").child(key).child("bowling").child("W").value!!.toString()

    }*/
}