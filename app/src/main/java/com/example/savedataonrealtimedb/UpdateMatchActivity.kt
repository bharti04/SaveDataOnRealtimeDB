package com.example.savedataonrealtimedb

import android.annotation.SuppressLint
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.support.v4.view.ViewPager
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.savedataonrealtimedb.adapter.MatchAdapter
import com.example.savedataonrealtimedb.dto.DataModal
import com.example.savedataonrealtimedb.util.RecyclerItemClickListener
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.add_data_layout.*
import kotlinx.android.synthetic.main.batsman_select_layout.*
import kotlinx.android.synthetic.main.update_score_layout.*
import java.util.ArrayList
import android.widget.RadioGroup
import android.widget.RadioButton





class UpdateMatchActivity : AppCompatActivity() {

    lateinit var arrayList: ArrayList<DataModal>
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

    var b1run:String=""
    var b2run:String=""
    var bowler1run:String=""
    var bowler2run:String=""

    var keyid:String=""

    var balls:String=""
    private lateinit var recyclerView: RecyclerView
    lateinit var adapter: MatchAdapter
    lateinit var viewPager: ViewPager
    var currentPage=0
    var needrun=""
    var run:Int=0
    var remainingballs:String=""
    var matchid:String=""
    var prun:String=""
    var pball:String=""
    var bowler1over:String=""
    var bowler2over:String=""

    var bowlerrun:String=""
    var batsman4runcount:String=""
    var batsman6runcount:String=""

    var brun:String=""
    var bwideBall:String=""


    var b1name:String=""
    var b2name:String=""

   var bowler1name:String=""
    var bowler2name:String=""

   var b1ball:String=""
    var b2ball:String=""
    var b14s:String=""
    var b24s:String=""
    var b16s:String=""
    var b26s:String=""

    var team1run:String=""
    var team2run:String=""

    var ballsremaining:String=""

    var countball:Int=0
    var minuscountballs:Int=0

    var countover:Double= 0.0
    var bcountover:Double= 0.0


    var choosebattingteam:String=""
    var batsmanStrike:String=""
    var bowlerStrike:String=""

    var batsman1:String=""
    var batsman2:String=""
    var bowler1:String=""
    var bowler2:String=""
    var bowler1CountBalls:String=""
    var bowler2CountBalls:String=""


    var t1p1name:String=""
    var t1p1run:String=""
    var t1p1balls:String=""
    var t1p14s:String=""
    var t1p16s:String=""
    var t1b1run:String=""
    var t1b1over:String=""
    var t1b1M:String=""
    var t1b1W:String=""

    var t1p2name:String=""
    var t1p2run:String=""
    var t1p2balls:String=""
    var t1p24s:String=""
    var t1p26s:String=""
    var t1b2run:String=""
    var t1b2over:String=""
    var t1b2M:String=""
    var t1b2W:String=""

    var t1p3name:String=""
    var t1p3run:String=""
    var t1p3balls:String=""
    var t1p34s:String=""
    var t1p36s:String=""
    var t1b3run:String=""
    var t1b3over:String=""
    var t1b3M:String=""
    var t1b3W:String=""

    var t1p4name:String=""
    var t1p4run:String=""
    var t1p4balls:String=""
    var t1p44s:String=""
    var t1p46s:String=""
    var t1b4run:String=""
    var t1b4over:String=""
    var t1b4M:String=""
    var t1b4W:String=""

    var t1p5name:String=""
    var t1p5run:String=""
    var t1p5balls:String=""
    var t1p54s:String=""
    var t1p56s:String=""
    var t1b5run:String=""
    var t1b5over:String=""
    var t1b5M:String=""
    var t1b5W:String=""

    var t1p6name:String=""
    var t1p6run:String=""
    var t1p6balls:String=""
    var t1p64s:String=""
    var t1p66s:String=""
    var t1b6run:String=""
    var t1b6over:String=""
    var t1b6M:String=""
    var t1b6W:String=""

    var t1p7name:String=""
    var t1p7run:String=""
    var t1p7balls:String=""
    var t1p74s:String=""
    var t1p76s:String=""
    var t1b7run:String=""
    var t1b7over:String=""
    var t1b7M:String=""
    var t1b7W:String=""

    var t1p8name:String=""
    var t1p8run:String=""
    var t1p8balls:String=""
    var t1p84s:String=""
    var t1p86s:String=""
    var t1b8run:String=""
    var t1b8over:String=""
    var t1b8M:String=""
    var t1b8W:String=""

    var t1p9name:String=""
    var t1p9run:String=""
    var t1p9balls:String=""
    var t1p94s:String=""
    var t1p96s:String=""
    var t1b9run:String=""
    var t1b9over:String=""
    var t1b9M:String=""
    var t1b9W:String=""

    var t1p10name:String=""
    var t1p10run:String=""
    var t1p10balls:String=""
    var t1p104s:String=""
    var t1p106s:String=""
    var t1b10run:String=""
    var t1b10over:String=""
    var t1b10M:String=""
    var t1b10W:String=""

    var t1p11name:String=""
    var t1p11run:String=""
    var t1p11balls:String=""
    var t1p114s:String=""
    var t1p116s:String=""
    var t1b11run:String=""
    var t1b11over:String=""
    var t1b11M:String=""
    var t1b11W:String=""

    var t1p12name:String=""
    var t1p12run:String=""
    var t1p12balls:String=""
    var t1p124s:String=""
    var t1p126s:String=""
    var t1b12run:String=""
    var t1b12over:String=""
    var t1b12M:String=""
    var t1b12W:String=""



    var t2p1name:String=""
    var t2p1run:String=""
    var t2p1balls:String=""
    var t2p14s:String=""
    var t2p16s:String=""
    var t2b1run:String=""
    var t2b1over:String=""
    var t2b1M:String=""
    var t2b1W:String=""

    var t2p2name:String=""
    var t2p2run:String=""
    var t2p2balls:String=""
    var t2p24s:String=""
    var t2p26s:String=""
    var t2b2run:String=""
    var t2b2over:String=""
    var t2b2M:String=""
    var t2b2W:String=""

    var t2p3name:String=""
    var t2p3run:String=""
    var t2p3balls:String=""
    var t2p34s:String=""
    var t2p36s:String=""
    var t2b3run:String=""
    var t2b3over:String=""
    var t2b3M:String=""
    var t2b3W:String=""

    var t2p4name:String=""
    var t2p4run:String=""
    var t2p4balls:String=""
    var t2p44s:String=""
    var t2p46s:String=""
    var t2b4run:String=""
    var t2b4over:String=""
    var t2b4M:String=""
    var t2b4W:String=""

    var t2p5name:String=""
    var t2p5run:String=""
    var t2p5balls:String=""
    var t2p54s:String=""
    var t2p56s:String=""
    var t2b5run:String=""
    var t2b5over:String=""
    var t2b5M:String=""
    var t2b5W:String=""

    var t2p6name:String=""
    var t2p6run:String=""
    var t2p6balls:String=""
    var t2p64s:String=""
    var t2p66s:String=""
    var t2b6run:String=""
    var t2b6over:String=""
    var t2b6M:String=""
    var t2b6W:String=""

    var t2p7name:String=""
    var t2p7run:String=""
    var t2p7balls:String=""
    var t2p74s:String=""
    var t2p76s:String=""
    var t2b7run:String=""
    var t2b7over:String=""
    var t2b7M:String=""
    var t2b7W:String=""

    var t2p8name:String=""
    var t2p8run:String=""
    var t2p8balls:String=""
    var t2p84s:String=""
    var t2p86s:String=""
    var t2b8run:String=""
    var t2b8over:String=""
    var t2b8M:String=""
    var t2b8W:String=""

    var t2p9name:String=""
    var t2p9run:String=""
    var t2p9balls:String=""
    var t2p94s:String=""
    var t2p96s:String=""
    var t2b9run:String=""
    var t2b9over:String=""
    var t2b9M:String=""
    var t2b9W:String=""

    var t2p10name:String=""
    var t2p10run:String=""
    var t2p10balls:String=""
    var t2p104s:String=""
    var t2p106s:String=""
    var t2b10run:String=""
    var t2b10over:String=""
    var t2b10M:String=""
    var t2b10W:String=""

    var t2p11name:String=""
    var t2p11run:String=""
    var t2p11balls:String=""
    var t2p114s:String=""
    var t2p116s:String=""
    var t2b11run:String=""
    var t2b11over:String=""
    var t2b11M:String=""
    var t2b11W:String=""

    var t2p12name:String=""
    var t2p12run:String=""
    var t2p12balls:String=""
    var t2p124s:String=""
    var t2p126s:String=""
    var t2b12run:String=""
    var t2b12over:String=""
    var t2b12M:String=""
    var t2b12W:String=""


    lateinit var database:FirebaseDatabase
    lateinit var myRef: DatabaseReference
   lateinit var array:Array<String>
    var playername:String=""
    var pname:String=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.update_score_layout)
        val intent = intent
         matchid = intent.getStringExtra("KEY")

         database = FirebaseDatabase.getInstance()
         myRef = database.getReference("matches")
         arrayList= ArrayList<DataModal>()
       /* if(AppConstants.checkInternetConnection(Main2Activity.this)){
            adView.setVisibility(View.VISIBLE);
        }else{
            adView.setVisibility(View.GONE);
        }*/
      /*update_bt.setOnClickListener {
          val valuetoSend = t1name_et.getText().toString()
          myRef.child(matchid).child("team1").child("name").setValue(valuetoSend)
          Log.d("bharti111", "Updated Value is: $valuetoSend ")

      }*/

       /* radiogroup_batsman.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener { arg0, id ->
            when (id) {
                -1 -> Log.v(this.TAG, "Choices cleared!")
                R.id.player1_check -> Log.v(FragmentActivity.TAG, "Chose Chicken")
                R.id.player2_check -> Log.v(FragmentActivity.TAG, "Chose Fish")

                else -> Log.v(this.TAG, "Huh?")
            }
        })*/
      /*  player1_check.setOnClickListener {
            player1_check.isChecked = true
            if(player1_check.isChecked) {
               // player1_check.isChecrcked=true
               // player2_check.isChecked = false
                var pstrike = "Player1"
                myRef.child(matchid).child("batsmanStrike").setValue(pstrike)
                Toast.makeText(this, "Player1", Toast.LENGTH_SHORT).show()

            }*//*else{
                myRef.child(matchid).child("batsmanStrike").setValue("")

            }*//*
        }*/
       /* if(player1_check.isChecked) {
            var pstrike = "Player1"
            myRef.child(matchid).child("batsmanStrike").setValue(pstrike)
            Toast.makeText(this, "Player1", Toast.LENGTH_SHORT).show()

        }*/
        out_batsman1_bt.setOnClickListener {
            if(choosebattingteam.equals(t1name)) {
                array = arrayOf(
                    t1p1name,
                    t1p2name,
                    t1p3name,
                    t1p4name,
                    t1p5name,
                    t1p6name,
                    t1p7name,
                    t1p8name,
                    t1p9name,
                    t1p10name,
                    t1p11name,
                    t1p12name
                )
            }else{
                array = arrayOf(
                    t2p1name,
                    t2p2name,
                    t2p3name,
                    t2p4name,
                    t2p5name,
                    t2p6name,
                    t2p7name,
                    t2p8name,
                    t2p9name,
                    t2p10name,
                    t2p11name,
                    t2p12name
                )
            }
            batsmanalertDialog(0,array,"batsman1")

        }
       /* player2_check.setOnClickListener {
            player2_check.isChecked = true
            if(player2_check.isChecked) {
             //  player2_check.isChecked = true
                var pstrike = "Player2"
                myRef.child(matchid).child("batsmanStrike").setValue(pstrike)
                Toast.makeText(this, "Player2", Toast.LENGTH_SHORT).show()

            }
            *//*else{
                myRef.child(matchid).child("batsmanStrike").setValue("")

            }*//*
        }*/
       /*  if(player2_check.isChecked) {
      //  player2_check.isChecked = true
        var pstrike = "Player2"
        myRef.child(matchid).child("batsmanStrike").setValue(pstrike)
        Toast.makeText(this, "Player2", Toast.LENGTH_SHORT).show()
         }*/
        out_batsman2_bt.setOnClickListener {
            if(choosebattingteam.equals(t1name)) {
                array = arrayOf(
                    t1p1name,
                    t1p2name,
                    t1p3name,
                    t1p4name,
                    t1p5name,
                    t1p6name,
                    t1p7name,
                    t1p8name,
                    t1p9name,
                    t1p10name,
                    t1p11name,
                    t1p12name
                )
            }else{
                array = arrayOf(
                    t2p1name,
                    t2p2name,
                    t2p3name,
                    t2p4name,
                    t2p5name,
                    t2p6name,
                    t2p7name,
                    t2p8name,
                    t2p9name,
                    t2p10name,
                    t2p11name,
                    t2p12name
                )
            }
            batsmanalertDialog(0,array,"batsman2")

        }

        bowler1_check.setOnClickListener {
            bowler1_check.isChecked = true
            if(bowler1_check.isChecked) {
                //bowler1_check.isChecked = true
                var pstrike = "Bowler1"
                myRef.child(matchid).child("bowlerStrike").setValue(pstrike)
                Toast.makeText(this, "Bowler1", Toast.LENGTH_SHORT).show()

            }
           /* else{
                myRef.child(matchid).child("bowlerStrike").setValue("")

            }*/
        }
       /* if(bowler1_check.isChecked) {
        // bowler2_check.isChecked = false
        var pstrike = "Bowler1"
        myRef.child(matchid).child("bowlerStrike").setValue(pstrike)
        Toast.makeText(this, "Bowler1", Toast.LENGTH_SHORT).show()

          }*/
        out_bowler1_bt.setOnClickListener {
            if(choosebattingteam.equals(t1name)) {
                array = arrayOf(
                    t2p1name,
                    t2p2name,
                    t2p3name,
                    t2p4name,
                    t2p5name,
                    t2p6name,
                    t2p7name,
                    t2p8name,
                    t2p9name,
                    t2p10name,
                    t2p11name,
                    t2p12name
                )

            }else if(choosebattingteam.equals(t2name)){
                array = arrayOf(
                    t1p1name,
                    t1p2name,
                    t1p3name,
                    t1p4name,
                    t1p5name,
                    t1p6name,
                    t1p7name,
                    t1p8name,
                    t1p9name,
                    t1p10name,
                    t1p11name,
                    t1p12name
                )

            }
            bowleralertDialog(0,array,"bowler1")

        }
       /* if(bowler2_check.isChecked) {
        //bowler1_check.isChecked=false

        var pstrike = "Bowler2"
        myRef.child(matchid).child("bowlerStrike").setValue(pstrike)
        Toast.makeText(this, "Bowler2", Toast.LENGTH_SHORT).show()

        }*/
        bowler2_check.setOnClickListener {
            bowler2_check.isChecked=true
           if(bowler2_check.isChecked) {
               //bowler2_check.isChecked=true

                var pstrike = "Bowler2"
                myRef.child(matchid).child("bowlerStrike").setValue(pstrike)
                Toast.makeText(this, "Bowler2", Toast.LENGTH_SHORT).show()

            }/*else{
                myRef.child(matchid).child("bowlerStrike").setValue("")

            }*/
        }
        out_bowler2_bt.setOnClickListener {
            if(choosebattingteam.equals(t1name)) {
                array = arrayOf(
                    t2p1name,
                    t2p2name,
                    t2p3name,
                    t2p4name,
                    t2p5name,
                    t2p6name,
                    t2p7name,
                    t2p8name,
                    t2p9name,
                    t2p10name,
                    t2p11name,
                    t2p12name
                )

            }else if(choosebattingteam.equals(t2name)){
                array = arrayOf(
                    t1p1name,
                    t1p2name,
                    t1p3name,
                    t1p4name,
                    t1p5name,
                    t1p6name,
                    t1p7name,
                    t1p8name,
                    t1p9name,
                    t1p10name,
                    t1p11name,
                    t1p12name
                )

            }
            bowleralertDialog(0,array,"bowler2")

        }
        run0_check.setOnClickListener {
            countRun(0,1,0)
        }

        run1_check.setOnClickListener {
            countRun(1,1,1)
           /* ballsremaining=(remainingballs.toInt()-1).toString()

            countballs= Integer.parseInt(ballsremaining)
            if(matchType.equals("T20")){
                minuscountballs=120-countballs
            }
            else if(matchType.equals("ODI")){
                minuscountballs=300-countballs
            }

            countover=overCalculate(minuscountballs)
            *//*countover=
                    java.lang.Double.valueOf(Math.round(java.lang.Double.valueOf(java.lang.Double.parseDouble(t1run) / (balls as Double / 6.0)).toDouble() * 100.0).toDouble() / 100.0)
                        .toFloat()*//*


            if(player1_check.isChecked && bowler1_check.isChecked ){
               *//* prun= (b1run.toInt()+1).toString()
                pball= (b1ball.toInt()+1).toString()*//*
               *//* bowlerover= (bowler1over.toInt()+1).toString()
                bowlerrun= (bowler1run.toInt()+1).toString()*//*
                team1run=(t1run.toInt()+1).toString()
                team2run=(t2run.toInt()+1).toString()
                if(player1_check.text.toString().equals(t1p1name)){
                    prun= (t1p1run.toInt()+1).toString()
                    pball= (t1p1balls.toInt()+1).toString()

                    myRef.child(matchid).child("team1").child("players").child("0").child("batting").child("R").setValue(prun)
                    myRef.child(matchid).child("team1").child("players").child("0").child("batting").child("B").setValue(pball)
                }
               else if(player1_check.text.toString().equals(t1p2name)){
                    prun= (t1p2run.toInt()+1).toString()
                    pball= (t1p2balls.toInt()+1).toString()

                    myRef.child(matchid).child("team1").child("players").child("1").child("batting").child("R").setValue(prun)
                    myRef.child(matchid).child("team1").child("players").child("1").child("batting").child("B").setValue(pball)
                }
                else if(player1_check.text.toString().equals(t1p3name)){
                    prun= (t1p3run.toInt()+1).toString()
                    pball= (t1p3balls.toInt()+1).toString()

                    myRef.child(matchid).child("team1").child("players").child("2").child("batting").child("R").setValue(prun)
                    myRef.child(matchid).child("team1").child("players").child("2").child("batting").child("B").setValue(pball)
                }
                else if(player1_check.text.toString().equals(t1p4name)){
                    prun= (t1p4run.toInt()+1).toString()
                    pball= (t1p4balls.toInt()+1).toString()

                    myRef.child(matchid).child("team1").child("players").child("3").child("batting").child("R").setValue(prun)
                    myRef.child(matchid).child("team1").child("players").child("3").child("batting").child("B").setValue(pball)
                }
                else if(player1_check.text.toString().equals(t1p5name)){
                    prun= (t1p5run.toInt()+1).toString()
                    pball= (t1p5balls.toInt()+1).toString()

                    myRef.child(matchid).child("team1").child("players").child("4").child("batting").child("R").setValue(prun)
                    myRef.child(matchid).child("team1").child("players").child("4").child("batting").child("B").setValue(pball)
                }
                else if(player1_check.text.toString().equals(t1p6name)){
                    prun= (t1p6run.toInt()+1).toString()
                    pball= (t1p6balls.toInt()+1).toString()

                    myRef.child(matchid).child("team1").child("players").child("5").child("batting").child("R").setValue(prun)
                    myRef.child(matchid).child("team1").child("players").child("5").child("batting").child("B").setValue(pball)
                }
                else if(player1_check.text.toString().equals(t1p7name)){
                    prun= (t1p7run.toInt()+1).toString()
                    pball= (t1p7balls.toInt()+1).toString()

                    myRef.child(matchid).child("team1").child("players").child("6").child("batting").child("R").setValue(prun)
                    myRef.child(matchid).child("team1").child("players").child("6").child("batting").child("B").setValue(pball)
                }
                else if(player1_check.text.toString().equals(t1p8name)){
                    prun= (t1p8run.toInt()+1).toString()
                    pball= (t1p8balls.toInt()+1).toString()

                    myRef.child(matchid).child("team1").child("players").child("7").child("batting").child("R").setValue(prun)
                    myRef.child(matchid).child("team1").child("players").child("7").child("batting").child("B").setValue(pball)
                }
                else if(player1_check.text.toString().equals(t1p9name)){
                    prun= (t1p9run.toInt()+1).toString()
                    pball= (t1p9balls.toInt()+1).toString()

                    myRef.child(matchid).child("team1").child("players").child("8").child("batting").child("R").setValue(prun)
                    myRef.child(matchid).child("team1").child("players").child("8").child("batting").child("B").setValue(pball)
                }
                else if(player1_check.text.toString().equals(t1p10name)){
                    prun= (t1p10run.toInt()+1).toString()
                    pball= (t1p10balls.toInt()+1).toString()

                    myRef.child(matchid).child("team1").child("players").child("9").child("batting").child("R").setValue(prun)
                    myRef.child(matchid).child("team1").child("players").child("9").child("batting").child("B").setValue(pball)
                }
                else if(player1_check.text.toString().equals(t1p11name)){
                    prun= (t1p11run.toInt()+1).toString()
                    pball= (t1p11balls.toInt()+1).toString()

                    myRef.child(matchid).child("team1").child("players").child("10").child("batting").child("R").setValue(prun)
                    myRef.child(matchid).child("team1").child("players").child("10").child("batting").child("B").setValue(pball)
                }
                else if(player1_check.text.toString().equals(t1p12name)){
                    prun= (t1p12run.toInt()+1).toString()
                    pball= (t1p12balls.toInt()+1).toString()

                    myRef.child(matchid).child("team1").child("players").child("11").child("batting").child("R").setValue(prun)
                    myRef.child(matchid).child("team1").child("players").child("11").child("batting").child("B").setValue(pball)
                }

                if(player1_check.text.toString().equals(t2p1name)){
                    prun= (t2p1run.toInt()+1).toString()
                    pball= (t2p1balls.toInt()+1).toString()

                    myRef.child(matchid).child("team2").child("players").child("0").child("batting").child("R").setValue(prun)
                    myRef.child(matchid).child("team2").child("players").child("0").child("batting").child("B").setValue(pball)
                }
                else if(player1_check.text.toString().equals(t2p2name)){
                    prun= (t2p2run.toInt()+1).toString()
                    pball= (t2p2balls.toInt()+1).toString()

                    myRef.child(matchid).child("team2").child("players").child("1").child("batting").child("R").setValue(prun)
                    myRef.child(matchid).child("team2").child("players").child("1").child("batting").child("B").setValue(pball)
                }
                else if(player1_check.text.toString().equals(t2p3name)){
                    prun= (t2p3run.toInt()+1).toString()
                    pball= (t2p3balls.toInt()+1).toString()

                    myRef.child(matchid).child("team2").child("players").child("2").child("batting").child("R").setValue(prun)
                    myRef.child(matchid).child("team2").child("players").child("2").child("batting").child("B").setValue(pball)
                }
                else if(player1_check.text.toString().equals(t2p4name)){
                    prun= (t2p4run.toInt()+1).toString()
                    pball= (t2p4balls.toInt()+1).toString()

                    myRef.child(matchid).child("team2").child("players").child("3").child("batting").child("R").setValue(prun)
                    myRef.child(matchid).child("team2").child("players").child("3").child("batting").child("B").setValue(pball)
                }
                else if(player1_check.text.toString().equals(t2p5name)){
                    prun= (t2p5run.toInt()+1).toString()
                    pball= (t2p5balls.toInt()+1).toString()

                    myRef.child(matchid).child("team2").child("players").child("4").child("batting").child("R").setValue(prun)
                    myRef.child(matchid).child("team2").child("players").child("4").child("batting").child("B").setValue(pball)
                }
                else if(player1_check.text.toString().equals(t2p6name)){
                    prun= (t2p6run.toInt()+1).toString()
                    pball= (t2p6balls.toInt()+1).toString()

                    myRef.child(matchid).child("team2").child("players").child("5").child("batting").child("R").setValue(prun)
                    myRef.child(matchid).child("team2").child("players").child("5").child("batting").child("B").setValue(pball)
                }
                else if(player1_check.text.toString().equals(t2p7name)){
                    prun= (t2p7run.toInt()+1).toString()
                    pball= (t2p7balls.toInt()+1).toString()

                    myRef.child(matchid).child("team2").child("players").child("6").child("batting").child("R").setValue(prun)
                    myRef.child(matchid).child("team2").child("players").child("6").child("batting").child("B").setValue(pball)
                }
                else if(player1_check.text.toString().equals(t2p8name)){
                    prun= (t2p8run.toInt()+1).toString()
                    pball= (t2p8balls.toInt()+1).toString()

                    myRef.child(matchid).child("team2").child("players").child("7").child("batting").child("R").setValue(prun)
                    myRef.child(matchid).child("team2").child("players").child("7").child("batting").child("B").setValue(pball)
                }
                else if(player1_check.text.toString().equals(t2p9name)){
                    prun= (t2p9run.toInt()+1).toString()
                    pball= (t2p9balls.toInt()+1).toString()

                    myRef.child(matchid).child("team2").child("players").child("8").child("batting").child("R").setValue(prun)
                    myRef.child(matchid).child("team2").child("players").child("8").child("batting").child("B").setValue(pball)
                }
                else if(player1_check.text.toString().equals(t2p10name)){
                    prun= (t2p10run.toInt()+1).toString()
                    pball= (t2p10balls.toInt()+1).toString()

                    myRef.child(matchid).child("team2").child("players").child("9").child("batting").child("R").setValue(prun)
                    myRef.child(matchid).child("team2").child("players").child("9").child("batting").child("B").setValue(pball)
                }
                else if(player1_check.text.toString().equals(t2p11name)){
                    prun= (t2p11run.toInt()+1).toString()
                    pball= (t2p11balls.toInt()+1).toString()

                    myRef.child(matchid).child("team2").child("players").child("10").child("batting").child("R").setValue(prun)
                    myRef.child(matchid).child("team2").child("players").child("10").child("batting").child("B").setValue(pball)
                }
                else if(player1_check.text.toString().equals(t2p12name)){
                    prun= (t2p12run.toInt()+1).toString()
                    pball= (t2p12balls.toInt()+1).toString()

                    myRef.child(matchid).child("team2").child("players").child("11").child("batting").child("R").setValue(prun)
                    myRef.child(matchid).child("team2").child("players").child("11").child("batting").child("B").setValue(pball)
                }

                if(bowler1_check.text.toString().equals(t1p1name)){
                    bowlerover= (t1b1over.toInt()+1).toString()
                    bowlerrun= (t1b1run.toInt()+1).toString()

                    myRef.child(matchid).child("team1").child("players").child("0").child("bowling").child("R").setValue(bowlerrun)
                    myRef.child(matchid).child("team1").child("players").child("0").child("bowling").child("O").setValue(bowlerover)
                }
                else if(bowler1_check.text.toString().equals(t1p2name)){
                    bowlerover= (t1b2over.toInt()+1).toString()
                    bowlerrun= (t1b2run.toInt()+1).toString()

                    myRef.child(matchid).child("team1").child("players").child("1").child("bowling").child("R").setValue(bowlerrun)
                    myRef.child(matchid).child("team1").child("players").child("1").child("bowling").child("O").setValue(bowlerover)
                }
                else if(bowler1_check.text.toString().equals(t1p3name)){
                    bowlerover= (t1b3over.toInt()+1).toString()
                    bowlerrun= (t1b3run.toInt()+1).toString()

                    myRef.child(matchid).child("team1").child("players").child("2").child("bowling").child("R").setValue(bowlerrun)
                    myRef.child(matchid).child("team1").child("players").child("2").child("bowling").child("O").setValue(bowlerover)
                }
                else if(bowler1_check.text.toString().equals(t1p4name)){
                    bowlerover= (t1b4over.toInt()+1).toString()
                    bowlerrun= (t1b4run.toInt()+1).toString()

                    myRef.child(matchid).child("team1").child("players").child("3").child("bowling").child("R").setValue(bowlerrun)
                    myRef.child(matchid).child("team1").child("players").child("3").child("bowling").child("O").setValue(bowlerover)
                }
                else if(bowler1_check.text.toString().equals(t1p5name)){
                    bowlerover= (t1b5over.toInt()+1).toString()
                    bowlerrun= (t1b5run.toInt()+1).toString()

                    myRef.child(matchid).child("team1").child("players").child("4").child("bowling").child("R").setValue(bowlerrun)
                    myRef.child(matchid).child("team1").child("players").child("4").child("bowling").child("O").setValue(bowlerover)
                }
                else if(bowler1_check.text.toString().equals(t1p6name)){
                    bowlerover= (t1b6over.toInt()+1).toString()
                    bowlerrun= (t1b6run.toInt()+1).toString()

                    myRef.child(matchid).child("team1").child("players").child("5").child("bowling").child("R").setValue(bowlerrun)
                    myRef.child(matchid).child("team1").child("players").child("5").child("bowling").child("O").setValue(bowlerover)
                }
                else if(bowler1_check.text.toString().equals(t1p7name)){
                    bowlerover= (t1b7over.toInt()+1).toString()
                    bowlerrun= (t1b7run.toInt()+1).toString()

                    myRef.child(matchid).child("team1").child("players").child("6").child("bowling").child("R").setValue(bowlerrun)
                    myRef.child(matchid).child("team1").child("players").child("6").child("bowling").child("O").setValue(bowlerover)
                }
                else if(bowler1_check.text.toString().equals(t1p8name)){
                    bowlerover= (t1b8over.toInt()+1).toString()
                    bowlerrun= (t1b8run.toInt()+1).toString()

                    myRef.child(matchid).child("team1").child("players").child("7").child("bowling").child("R").setValue(bowlerrun)
                    myRef.child(matchid).child("team1").child("players").child("7").child("bowling").child("O").setValue(bowlerover)
                }
                else if(bowler1_check.text.toString().equals(t1p9name)){
                    bowlerover= (t1b9over.toInt()+1).toString()
                    bowlerrun= (t1b9run.toInt()+1).toString()

                    myRef.child(matchid).child("team1").child("players").child("8").child("bowling").child("R").setValue(bowlerrun)
                    myRef.child(matchid).child("team1").child("players").child("8").child("bowling").child("O").setValue(bowlerover)
                }
                else if(bowler1_check.text.toString().equals(t1p10name)){
                    bowlerover= (t1b10over.toInt()+1).toString()
                    bowlerrun= (t1b10run.toInt()+1).toString()

                    myRef.child(matchid).child("team1").child("players").child("9").child("bowling").child("R").setValue(bowlerrun)
                    myRef.child(matchid).child("team1").child("players").child("9").child("bowling").child("O").setValue(bowlerover)
                }
                else if(bowler1_check.text.toString().equals(t1p11name)){
                    bowlerover= (t1b11over.toInt()+1).toString()
                    bowlerrun= (t1b11run.toInt()+1).toString()

                    myRef.child(matchid).child("team1").child("players").child("10").child("bowling").child("R").setValue(bowlerrun)
                    myRef.child(matchid).child("team1").child("players").child("10").child("bowling").child("O").setValue(bowlerover)
                }
                else if(bowler1_check.text.toString().equals(t1p12name)){
                    bowlerover= (t1b12over.toInt()+1).toString()
                    bowlerrun= (t1b12run.toInt()+1).toString()

                    myRef.child(matchid).child("team1").child("players").child("11").child("bowling").child("R").setValue(bowlerrun)
                    myRef.child(matchid).child("team1").child("players").child("11").child("bowling").child("O").setValue(bowlerover)
                }

                if(bowler1_check.text.toString().equals(t2p1name)){
                    bowlerover= (t2b1over.toInt()+1).toString()
                    bowlerrun= (t2b1run.toInt()+1).toString()

                    myRef.child(matchid).child("team2").child("players").child("0").child("bowling").child("R").setValue(bowlerrun)
                    myRef.child(matchid).child("team2").child("players").child("0").child("bowling").child("O").setValue(bowlerover)
                }
                else if(bowler1_check.text.toString().equals(t2p2name)){
                    bowlerover= (t2b2over.toInt()+1).toString()
                    bowlerrun= (t2b2run.toInt()+1).toString()

                    myRef.child(matchid).child("team2").child("players").child("1").child("bowling").child("R").setValue(bowlerrun)
                    myRef.child(matchid).child("team2").child("players").child("1").child("bowling").child("O").setValue(bowlerover)
                }
                else if(bowler1_check.text.toString().equals(t2p3name)){
                    bowlerover= (t2b3over.toInt()+1).toString()
                    bowlerrun= (t2b3run.toInt()+1).toString()

                    myRef.child(matchid).child("team2").child("players").child("2").child("bowling").child("R").setValue(bowlerrun)
                    myRef.child(matchid).child("team2").child("players").child("2").child("bowling").child("O").setValue(bowlerover)
                }
                else if(bowler1_check.text.toString().equals(t2p4name)){
                    bowlerover= (t2b4over.toInt()+1).toString()
                    bowlerrun= (t2b4run.toInt()+1).toString()

                    myRef.child(matchid).child("team2").child("players").child("3").child("bowling").child("R").setValue(bowlerrun)
                    myRef.child(matchid).child("team2").child("players").child("3").child("bowling").child("O").setValue(bowlerover)
                }
                else if(bowler1_check.text.toString().equals(t2p5name)){
                    bowlerover= (t2b5over.toInt()+1).toString()
                    bowlerrun= (t2b5run.toInt()+1).toString()

                    myRef.child(matchid).child("team2").child("players").child("4").child("bowling").child("R").setValue(bowlerrun)
                    myRef.child(matchid).child("team2").child("players").child("4").child("bowling").child("O").setValue(bowlerover)
                }
                else if(bowler1_check.text.toString().equals(t2p6name)){
                    bowlerover= (t2b6over.toInt()+1).toString()
                    bowlerrun= (t2b6run.toInt()+1).toString()

                    myRef.child(matchid).child("team2").child("players").child("5").child("bowling").child("R").setValue(bowlerrun)
                    myRef.child(matchid).child("team2").child("players").child("5").child("bowling").child("O").setValue(bowlerover)
                }
                else if(bowler1_check.text.toString().equals(t2p7name)){
                    bowlerover= (t2b7over.toInt()+1).toString()
                    bowlerrun= (t2b7run.toInt()+1).toString()

                    myRef.child(matchid).child("team2").child("players").child("6").child("bowling").child("R").setValue(bowlerrun)
                    myRef.child(matchid).child("team2").child("players").child("6").child("bowling").child("O").setValue(bowlerover)
                }
                else if(bowler1_check.text.toString().equals(t2p8name)){
                    bowlerover= (t2b8over.toInt()+1).toString()
                    bowlerrun= (t2b8run.toInt()+1).toString()

                    myRef.child(matchid).child("team2").child("players").child("7").child("bowling").child("R").setValue(bowlerrun)
                    myRef.child(matchid).child("team2").child("players").child("7").child("bowling").child("O").setValue(bowlerover)
                }
                else if(bowler1_check.text.toString().equals(t2p9name)){
                    bowlerover= (t2b9over.toInt()+1).toString()
                    bowlerrun= (t2b9run.toInt()+1).toString()

                    myRef.child(matchid).child("team2").child("players").child("8").child("bowling").child("R").setValue(bowlerrun)
                    myRef.child(matchid).child("team2").child("players").child("8").child("bowling").child("O").setValue(bowlerover)
                }
                else if(bowler1_check.text.toString().equals(t2p10name)){
                    bowlerover= (t2b10over.toInt()+1).toString()
                    bowlerrun= (t2b10run.toInt()+1).toString()

                    myRef.child(matchid).child("team2").child("players").child("9").child("bowling").child("R").setValue(bowlerrun)
                    myRef.child(matchid).child("team2").child("players").child("9").child("bowling").child("O").setValue(bowlerover)
                }
                else if(bowler1_check.text.toString().equals(t2p11name)){
                    bowlerover= (t2b11over.toInt()+1).toString()
                    bowlerrun= (t2b11run.toInt()+1).toString()

                    myRef.child(matchid).child("team2").child("players").child("10").child("bowling").child("R").setValue(bowlerrun)
                    myRef.child(matchid).child("team2").child("players").child("10").child("bowling").child("O").setValue(bowlerover)
                }
                else if(bowler1_check.text.toString().equals(t2p12name)){
                    bowlerover= (t2b12over.toInt()+1).toString()
                    bowlerrun= (t2b12run.toInt()+1).toString()

                    myRef.child(matchid).child("team2").child("players").child("11").child("bowling").child("R").setValue(bowlerrun)
                    myRef.child(matchid).child("team2").child("players").child("11").child("bowling").child("O").setValue(bowlerover)
                }

                //countballs=(remainingballs.toInt()+1).toString()

                Log.d("bharti11", "Value b1 is: $prun")

                *//*myRef.child(matchid).child("Batsman").child("b1").child("R").setValue(prun)
                myRef.child(matchid).child("Batsman").child("b1").child("B").setValue(pball)
                myRef.child(matchid).child("Bowling").child("bowler1").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("Bowling").child("bowler1").child("O").setValue(bowlerover)
*//*
                if(choosebattingteam.equals(t1name)){
                    myRef.child(matchid).child("team1").child("run").setValue(team1run)
                   myRef.child(matchid).child("team1").child("over").setValue(countover)

               }else{
                   myRef.child(matchid).child("team2").child("run").setValue(team2run)
                   myRef.child(matchid).child("team2").child("over").setValue(countover)

               }

                Toast.makeText(this,"player1 run"+" "+prun,Toast.LENGTH_SHORT).show()

            }
            else if(player1_check.isChecked && bowler2_check.isChecked  ){
               *//* prun= (b1run.toInt()+1).toString()
                pball= (b1ball.toInt()+1).toString()
                bowlerover= (bowler2over.toInt()+1).toString()
                bowlerrun= (bowler2run.toInt()+1).toString()*//*
                team1run=(t1run.toInt()+1).toString()
                team2run=(t2run.toInt()+1).toString()

                Log.d("bharti11", "Value b1 is: $prun")
                if(player1_check.text.toString().equals(t1p1name)){
                    prun= (t1p1run.toInt()+1).toString()
                    pball= (t1p1balls.toInt()+1).toString()

                    myRef.child(matchid).child("team1").child("players").child("0").child("batting").child("R").setValue(prun)
                    myRef.child(matchid).child("team1").child("players").child("0").child("batting").child("B").setValue(pball)
                }
                else if(player1_check.text.toString().equals(t1p2name)){
                    prun= (t1p2run.toInt()+1).toString()
                    pball= (t1p2balls.toInt()+1).toString()

                    myRef.child(matchid).child("team1").child("players").child("1").child("batting").child("R").setValue(prun)
                    myRef.child(matchid).child("team1").child("players").child("1").child("batting").child("B").setValue(pball)
                }
                else if(player1_check.text.toString().equals(t1p3name)){
                    prun= (t1p3run.toInt()+1).toString()
                    pball= (t1p3balls.toInt()+1).toString()

                    myRef.child(matchid).child("team1").child("players").child("2").child("batting").child("R").setValue(prun)
                    myRef.child(matchid).child("team1").child("players").child("2").child("batting").child("B").setValue(pball)
                }
                else if(player1_check.text.toString().equals(t1p4name)){
                    prun= (t1p4run.toInt()+1).toString()
                    pball= (t1p4balls.toInt()+1).toString()

                    myRef.child(matchid).child("team1").child("players").child("3").child("batting").child("R").setValue(prun)
                    myRef.child(matchid).child("team1").child("players").child("3").child("batting").child("B").setValue(pball)
                }
                else if(player1_check.text.toString().equals(t1p5name)){
                    prun= (t1p5run.toInt()+1).toString()
                    pball= (t1p5balls.toInt()+1).toString()

                    myRef.child(matchid).child("team1").child("players").child("4").child("batting").child("R").setValue(prun)
                    myRef.child(matchid).child("team1").child("players").child("4").child("batting").child("B").setValue(pball)
                }
                else if(player1_check.text.toString().equals(t1p6name)){
                    prun= (t1p6run.toInt()+1).toString()
                    pball= (t1p6balls.toInt()+1).toString()

                    myRef.child(matchid).child("team1").child("players").child("5").child("batting").child("R").setValue(prun)
                    myRef.child(matchid).child("team1").child("players").child("5").child("batting").child("B").setValue(pball)
                }
                else if(player1_check.text.toString().equals(t1p7name)){
                    prun= (t1p7run.toInt()+1).toString()
                    pball= (t1p7balls.toInt()+1).toString()

                    myRef.child(matchid).child("team1").child("players").child("6").child("batting").child("R").setValue(prun)
                    myRef.child(matchid).child("team1").child("players").child("6").child("batting").child("B").setValue(pball)
                }
                else if(player1_check.text.toString().equals(t1p8name)){
                    prun= (t1p8run.toInt()+1).toString()
                    pball= (t1p8balls.toInt()+1).toString()

                    myRef.child(matchid).child("team1").child("players").child("7").child("batting").child("R").setValue(prun)
                    myRef.child(matchid).child("team1").child("players").child("7").child("batting").child("B").setValue(pball)
                }
                else if(player1_check.text.toString().equals(t1p9name)){
                    prun= (t1p9run.toInt()+1).toString()
                    pball= (t1p9balls.toInt()+1).toString()

                    myRef.child(matchid).child("team1").child("players").child("8").child("batting").child("R").setValue(prun)
                    myRef.child(matchid).child("team1").child("players").child("8").child("batting").child("B").setValue(pball)
                }
                else if(player1_check.text.toString().equals(t1p10name)){
                    prun= (t1p10run.toInt()+1).toString()
                    pball= (t1p10balls.toInt()+1).toString()

                    myRef.child(matchid).child("team1").child("players").child("9").child("batting").child("R").setValue(prun)
                    myRef.child(matchid).child("team1").child("players").child("9").child("batting").child("B").setValue(pball)
                }
                else if(player1_check.text.toString().equals(t1p11name)){
                    prun= (t1p11run.toInt()+1).toString()
                    pball= (t1p11balls.toInt()+1).toString()

                    myRef.child(matchid).child("team1").child("players").child("10").child("batting").child("R").setValue(prun)
                    myRef.child(matchid).child("team1").child("players").child("10").child("batting").child("B").setValue(pball)
                }
                else if(player1_check.text.toString().equals(t1p12name)){
                    prun= (t1p12run.toInt()+1).toString()
                    pball= (t1p12balls.toInt()+1).toString()

                    myRef.child(matchid).child("team1").child("players").child("11").child("batting").child("R").setValue(prun)
                    myRef.child(matchid).child("team1").child("players").child("11").child("batting").child("B").setValue(pball)
                }

                if(player1_check.text.toString().equals(t2p1name)){
                    prun= (t2p1run.toInt()+1).toString()
                    pball= (t2p1balls.toInt()+1).toString()

                    myRef.child(matchid).child("team2").child("players").child("0").child("batting").child("R").setValue(prun)
                    myRef.child(matchid).child("team2").child("players").child("0").child("batting").child("B").setValue(pball)
                }
                else if(player1_check.text.toString().equals(t2p2name)){
                    prun= (t2p2run.toInt()+1).toString()
                    pball= (t2p2balls.toInt()+1).toString()

                    myRef.child(matchid).child("team2").child("players").child("1").child("batting").child("R").setValue(prun)
                    myRef.child(matchid).child("team2").child("players").child("1").child("batting").child("B").setValue(pball)
                }
                else if(player1_check.text.toString().equals(t2p3name)){
                    prun= (t2p3run.toInt()+1).toString()
                    pball= (t2p3balls.toInt()+1).toString()

                    myRef.child(matchid).child("team2").child("players").child("2").child("batting").child("R").setValue(prun)
                    myRef.child(matchid).child("team2").child("players").child("2").child("batting").child("B").setValue(pball)
                }
                else if(player1_check.text.toString().equals(t2p4name)){
                    prun= (t2p4run.toInt()+1).toString()
                    pball= (t2p4balls.toInt()+1).toString()

                    myRef.child(matchid).child("team2").child("players").child("3").child("batting").child("R").setValue(prun)
                    myRef.child(matchid).child("team2").child("players").child("3").child("batting").child("B").setValue(pball)
                }
                else if(player1_check.text.toString().equals(t2p5name)){
                    prun= (t2p5run.toInt()+1).toString()
                    pball= (t2p5balls.toInt()+1).toString()

                    myRef.child(matchid).child("team2").child("players").child("4").child("batting").child("R").setValue(prun)
                    myRef.child(matchid).child("team2").child("players").child("4").child("batting").child("B").setValue(pball)
                }
                else if(player1_check.text.toString().equals(t2p6name)){
                    prun= (t2p6run.toInt()+1).toString()
                    pball= (t2p6balls.toInt()+1).toString()

                    myRef.child(matchid).child("team2").child("players").child("5").child("batting").child("R").setValue(prun)
                    myRef.child(matchid).child("team2").child("players").child("5").child("batting").child("B").setValue(pball)
                }
                else if(player1_check.text.toString().equals(t2p7name)){
                    prun= (t2p7run.toInt()+1).toString()
                    pball= (t2p7balls.toInt()+1).toString()

                    myRef.child(matchid).child("team2").child("players").child("6").child("batting").child("R").setValue(prun)
                    myRef.child(matchid).child("team2").child("players").child("6").child("batting").child("B").setValue(pball)
                }
                else if(player1_check.text.toString().equals(t2p8name)){
                    prun= (t2p8run.toInt()+1).toString()
                    pball= (t2p8balls.toInt()+1).toString()

                    myRef.child(matchid).child("team2").child("players").child("7").child("batting").child("R").setValue(prun)
                    myRef.child(matchid).child("team2").child("players").child("7").child("batting").child("B").setValue(pball)
                }
                else if(player1_check.text.toString().equals(t2p9name)){
                    prun= (t2p9run.toInt()+1).toString()
                    pball= (t2p9balls.toInt()+1).toString()

                    myRef.child(matchid).child("team2").child("players").child("8").child("batting").child("R").setValue(prun)
                    myRef.child(matchid).child("team2").child("players").child("8").child("batting").child("B").setValue(pball)
                }
                else if(player1_check.text.toString().equals(t2p10name)){
                    prun= (t2p10run.toInt()+1).toString()
                    pball= (t2p10balls.toInt()+1).toString()

                    myRef.child(matchid).child("team2").child("players").child("9").child("batting").child("R").setValue(prun)
                    myRef.child(matchid).child("team2").child("players").child("9").child("batting").child("B").setValue(pball)
                }
                else if(player1_check.text.toString().equals(t2p11name)){
                    prun= (t2p11run.toInt()+1).toString()
                    pball= (t2p11balls.toInt()+1).toString()

                    myRef.child(matchid).child("team2").child("players").child("10").child("batting").child("R").setValue(prun)
                    myRef.child(matchid).child("team2").child("players").child("10").child("batting").child("B").setValue(pball)
                }
                else if(player1_check.text.toString().equals(t2p12name)){
                    prun= (t2p12run.toInt()+1).toString()
                    pball= (t2p12balls.toInt()+1).toString()

                    myRef.child(matchid).child("team2").child("players").child("11").child("batting").child("R").setValue(prun)
                    myRef.child(matchid).child("team2").child("players").child("11").child("batting").child("B").setValue(pball)
                }

                if(bowler1_check.text.toString().equals(t1p1name)){
                    bowlerover= (t1b1over.toInt()+1).toString()
                    bowlerrun= (t1b1run.toInt()+1).toString()

                    myRef.child(matchid).child("team1").child("players").child("0").child("bowling").child("R").setValue(bowlerrun)
                    myRef.child(matchid).child("team1").child("players").child("0").child("bowling").child("O").setValue(bowlerover)
                }
                else if(bowler1_check.text.toString().equals(t1p2name)){
                    bowlerover= (t1b2over.toInt()+1).toString()
                    bowlerrun= (t1b2run.toInt()+1).toString()

                    myRef.child(matchid).child("team1").child("players").child("1").child("bowling").child("R").setValue(bowlerrun)
                    myRef.child(matchid).child("team1").child("players").child("1").child("bowling").child("O").setValue(bowlerover)
                }
                else if(bowler1_check.text.toString().equals(t1p3name)){
                    bowlerover= (t1b3over.toInt()+1).toString()
                    bowlerrun= (t1b3run.toInt()+1).toString()

                    myRef.child(matchid).child("team1").child("players").child("2").child("bowling").child("R").setValue(bowlerrun)
                    myRef.child(matchid).child("team1").child("players").child("2").child("bowling").child("O").setValue(bowlerover)
                }
                else if(bowler1_check.text.toString().equals(t1p4name)){
                    bowlerover= (t1b4over.toInt()+1).toString()
                    bowlerrun= (t1b4run.toInt()+1).toString()

                    myRef.child(matchid).child("team1").child("players").child("3").child("bowling").child("R").setValue(bowlerrun)
                    myRef.child(matchid).child("team1").child("players").child("3").child("bowling").child("O").setValue(bowlerover)
                }
                else if(bowler1_check.text.toString().equals(t1p5name)){
                    bowlerover= (t1b5over.toInt()+1).toString()
                    bowlerrun= (t1b5run.toInt()+1).toString()

                    myRef.child(matchid).child("team1").child("players").child("4").child("bowling").child("R").setValue(bowlerrun)
                    myRef.child(matchid).child("team1").child("players").child("4").child("bowling").child("O").setValue(bowlerover)
                }
                else if(bowler1_check.text.toString().equals(t1p6name)){
                    bowlerover= (t1b6over.toInt()+1).toString()
                    bowlerrun= (t1b6run.toInt()+1).toString()

                    myRef.child(matchid).child("team1").child("players").child("5").child("bowling").child("R").setValue(bowlerrun)
                    myRef.child(matchid).child("team1").child("players").child("5").child("bowling").child("O").setValue(bowlerover)
                }
                else if(bowler1_check.text.toString().equals(t1p7name)){
                    bowlerover= (t1b7over.toInt()+1).toString()
                    bowlerrun= (t1b7run.toInt()+1).toString()

                    myRef.child(matchid).child("team1").child("players").child("6").child("bowling").child("R").setValue(bowlerrun)
                    myRef.child(matchid).child("team1").child("players").child("6").child("bowling").child("O").setValue(bowlerover)
                }
                else if(bowler1_check.text.toString().equals(t1p8name)){
                    bowlerover= (t1b8over.toInt()+1).toString()
                    bowlerrun= (t1b8run.toInt()+1).toString()

                    myRef.child(matchid).child("team1").child("players").child("7").child("bowling").child("R").setValue(bowlerrun)
                    myRef.child(matchid).child("team1").child("players").child("7").child("bowling").child("O").setValue(bowlerover)
                }
                else if(bowler1_check.text.toString().equals(t1p9name)){
                    bowlerover= (t1b9over.toInt()+1).toString()
                    bowlerrun= (t1b9run.toInt()+1).toString()

                    myRef.child(matchid).child("team1").child("players").child("8").child("bowling").child("R").setValue(bowlerrun)
                    myRef.child(matchid).child("team1").child("players").child("8").child("bowling").child("O").setValue(bowlerover)
                }
                else if(bowler1_check.text.toString().equals(t1p10name)){
                    bowlerover= (t1b10over.toInt()+1).toString()
                    bowlerrun= (t1b10run.toInt()+1).toString()

                    myRef.child(matchid).child("team1").child("players").child("9").child("bowling").child("R").setValue(bowlerrun)
                    myRef.child(matchid).child("team1").child("players").child("9").child("bowling").child("O").setValue(bowlerover)
                }
                else if(bowler1_check.text.toString().equals(t1p11name)){
                    bowlerover= (t1b11over.toInt()+1).toString()
                    bowlerrun= (t1b11run.toInt()+1).toString()

                    myRef.child(matchid).child("team1").child("players").child("10").child("bowling").child("R").setValue(bowlerrun)
                    myRef.child(matchid).child("team1").child("players").child("10").child("bowling").child("O").setValue(bowlerover)
                }
                else if(bowler1_check.text.toString().equals(t1p12name)){
                    bowlerover= (t1b12over.toInt()+1).toString()
                    bowlerrun= (t1b12run.toInt()+1).toString()

                    myRef.child(matchid).child("team1").child("players").child("11").child("bowling").child("R").setValue(bowlerrun)
                    myRef.child(matchid).child("team1").child("players").child("11").child("bowling").child("O").setValue(bowlerover)
                }

                if(bowler1_check.text.toString().equals(t2p1name)){
                    bowlerover= (t2b1over.toInt()+1).toString()
                    bowlerrun= (t2b1run.toInt()+1).toString()

                    myRef.child(matchid).child("team2").child("players").child("0").child("bowling").child("R").setValue(bowlerrun)
                    myRef.child(matchid).child("team2").child("players").child("0").child("bowling").child("O").setValue(bowlerover)
                }
                else if(bowler1_check.text.toString().equals(t2p2name)){
                    bowlerover= (t2b2over.toInt()+1).toString()
                    bowlerrun= (t2b2run.toInt()+1).toString()

                    myRef.child(matchid).child("team2").child("players").child("1").child("bowling").child("R").setValue(bowlerrun)
                    myRef.child(matchid).child("team2").child("players").child("1").child("bowling").child("O").setValue(bowlerover)
                }
                else if(bowler1_check.text.toString().equals(t2p3name)){
                    bowlerover= (t2b3over.toInt()+1).toString()
                    bowlerrun= (t2b3run.toInt()+1).toString()

                    myRef.child(matchid).child("team2").child("players").child("2").child("bowling").child("R").setValue(bowlerrun)
                    myRef.child(matchid).child("team2").child("players").child("2").child("bowling").child("O").setValue(bowlerover)
                }
                else if(bowler1_check.text.toString().equals(t2p4name)){
                    bowlerover= (t2b4over.toInt()+1).toString()
                    bowlerrun= (t2b4run.toInt()+1).toString()

                    myRef.child(matchid).child("team2").child("players").child("3").child("bowling").child("R").setValue(bowlerrun)
                    myRef.child(matchid).child("team2").child("players").child("3").child("bowling").child("O").setValue(bowlerover)
                }
                else if(bowler1_check.text.toString().equals(t2p5name)){
                    bowlerover= (t2b5over.toInt()+1).toString()
                    bowlerrun= (t2b5run.toInt()+1).toString()

                    myRef.child(matchid).child("team2").child("players").child("4").child("bowling").child("R").setValue(bowlerrun)
                    myRef.child(matchid).child("team2").child("players").child("4").child("bowling").child("O").setValue(bowlerover)
                }
                else if(bowler1_check.text.toString().equals(t2p6name)){
                    bowlerover= (t2b6over.toInt()+1).toString()
                    bowlerrun= (t2b6run.toInt()+1).toString()

                    myRef.child(matchid).child("team2").child("players").child("5").child("bowling").child("R").setValue(bowlerrun)
                    myRef.child(matchid).child("team2").child("players").child("5").child("bowling").child("O").setValue(bowlerover)
                }
                else if(bowler1_check.text.toString().equals(t2p7name)){
                    bowlerover= (t2b7over.toInt()+1).toString()
                    bowlerrun= (t2b7run.toInt()+1).toString()

                    myRef.child(matchid).child("team2").child("players").child("6").child("bowling").child("R").setValue(bowlerrun)
                    myRef.child(matchid).child("team2").child("players").child("6").child("bowling").child("O").setValue(bowlerover)
                }
                else if(bowler1_check.text.toString().equals(t2p8name)){
                    bowlerover= (t2b8over.toInt()+1).toString()
                    bowlerrun= (t2b8run.toInt()+1).toString()

                    myRef.child(matchid).child("team2").child("players").child("7").child("bowling").child("R").setValue(bowlerrun)
                    myRef.child(matchid).child("team2").child("players").child("7").child("bowling").child("O").setValue(bowlerover)
                }
                else if(bowler1_check.text.toString().equals(t2p9name)){
                    bowlerover= (t2b9over.toInt()+1).toString()
                    bowlerrun= (t2b9run.toInt()+1).toString()

                    myRef.child(matchid).child("team2").child("players").child("8").child("bowling").child("R").setValue(bowlerrun)
                    myRef.child(matchid).child("team2").child("players").child("8").child("bowling").child("O").setValue(bowlerover)
                }
                else if(bowler1_check.text.toString().equals(t2p10name)){
                    bowlerover= (t2b10over.toInt()+1).toString()
                    bowlerrun= (t2b10run.toInt()+1).toString()

                    myRef.child(matchid).child("team2").child("players").child("9").child("bowling").child("R").setValue(bowlerrun)
                    myRef.child(matchid).child("team2").child("players").child("9").child("bowling").child("O").setValue(bowlerover)
                }
                else if(bowler1_check.text.toString().equals(t2p11name)){
                    bowlerover= (t2b11over.toInt()+1).toString()
                    bowlerrun= (t2b11run.toInt()+1).toString()

                    myRef.child(matchid).child("team2").child("players").child("10").child("bowling").child("R").setValue(bowlerrun)
                    myRef.child(matchid).child("team2").child("players").child("10").child("bowling").child("O").setValue(bowlerover)
                }
                else if(bowler1_check.text.toString().equals(t2p12name)){
                    bowlerover= (t2b12over.toInt()+1).toString()
                    bowlerrun= (t2b12run.toInt()+1).toString()

                    myRef.child(matchid).child("team2").child("players").child("11").child("bowling").child("R").setValue(bowlerrun)
                    myRef.child(matchid).child("team2").child("players").child("11").child("bowling").child("O").setValue(bowlerover)
                }

                *//*myRef.child(matchid).child("Batsman").child("b1").child("R").setValue(prun)
                myRef.child(matchid).child("Batsman").child("b1").child("B").setValue(pball)
                myRef.child(matchid).child("Bowling").child("bowler2").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("Bowling").child("bowler2").child("O").setValue(bowlerover)
               *//*
                if(choosebattingteam.equals(t1name)){
                    myRef.child(matchid).child("team1").child("run").setValue(team1run)
                    myRef.child(matchid).child("team1").child("over").setValue(countover)


                }else{
                    myRef.child(matchid).child("team2").child("run").setValue(team2run)
                    myRef.child(matchid).child("team2").child("over").setValue(countover)

                }
                Toast.makeText(this,"player1 run"+" "+prun,Toast.LENGTH_SHORT).show()

        }
            else if(player2_check.isChecked && bowler1_check.isChecked){
                *//*prun= (b2run.toInt()+1).toString()
                pball= (b2ball.toInt()+1).toString()
                bowlerover= (bowler1over.toInt()+1).toString()
                bowlerrun= (bowler1run.toInt()+1).toString()*//*
                team1run=(t1run.toInt()+1).toString()
                team2run=(t2run.toInt()+1).toString()

                Log.d("bharti11", "Value b2 is: $prun")

                if(player2_check.text.toString().equals(t1p1name)){
                    prun= (t1p1run.toInt()+1).toString()
                    pball= (t1p1balls.toInt()+1).toString()

                    myRef.child(matchid).child("team1").child("players").child("0").child("batting").child("R").setValue(prun)
                    myRef.child(matchid).child("team1").child("players").child("0").child("batting").child("B").setValue(pball)
                }
                else if(player2_check.text.toString().equals(t1p2name)){
                    prun= (t1p2run.toInt()+1).toString()
                    pball= (t1p2balls.toInt()+1).toString()

                    myRef.child(matchid).child("team1").child("players").child("1").child("batting").child("R").setValue(prun)
                    myRef.child(matchid).child("team1").child("players").child("1").child("batting").child("B").setValue(pball)
                }
                else if(player2_check.text.toString().equals(t1p3name)){
                    prun= (t1p3run.toInt()+1).toString()
                    pball= (t1p3balls.toInt()+1).toString()

                    myRef.child(matchid).child("team1").child("players").child("2").child("batting").child("R").setValue(prun)
                    myRef.child(matchid).child("team1").child("players").child("2").child("batting").child("B").setValue(pball)
                }
                else if(player2_check.text.toString().equals(t1p4name)){
                    prun= (t1p4run.toInt()+1).toString()
                    pball= (t1p4balls.toInt()+1).toString()

                    myRef.child(matchid).child("team1").child("players").child("3").child("batting").child("R").setValue(prun)
                    myRef.child(matchid).child("team1").child("players").child("3").child("batting").child("B").setValue(pball)
                }
                else if(player2_check.text.toString().equals(t1p5name)){
                    prun= (t1p5run.toInt()+1).toString()
                    pball= (t1p5balls.toInt()+1).toString()

                    myRef.child(matchid).child("team1").child("players").child("4").child("batting").child("R").setValue(prun)
                    myRef.child(matchid).child("team1").child("players").child("4").child("batting").child("B").setValue(pball)
                }
                else if(player2_check.text.toString().equals(t1p6name)){
                    prun= (t1p6run.toInt()+1).toString()
                    pball= (t1p6balls.toInt()+1).toString()

                    myRef.child(matchid).child("team1").child("players").child("5").child("batting").child("R").setValue(prun)
                    myRef.child(matchid).child("team1").child("players").child("5").child("batting").child("B").setValue(pball)
                }
                else if(player2_check.text.toString().equals(t1p7name)){
                    prun= (t1p7run.toInt()+1).toString()
                    pball= (t1p7balls.toInt()+1).toString()

                    myRef.child(matchid).child("team1").child("players").child("6").child("batting").child("R").setValue(prun)
                    myRef.child(matchid).child("team1").child("players").child("6").child("batting").child("B").setValue(pball)
                }
                else if(player2_check.text.toString().equals(t1p8name)){
                    prun= (t1p8run.toInt()+1).toString()
                    pball= (t1p8balls.toInt()+1).toString()

                    myRef.child(matchid).child("team1").child("players").child("7").child("batting").child("R").setValue(prun)
                    myRef.child(matchid).child("team1").child("players").child("7").child("batting").child("B").setValue(pball)
                }
                else if(player2_check.text.toString().equals(t1p9name)){
                    prun= (t1p9run.toInt()+1).toString()
                    pball= (t1p9balls.toInt()+1).toString()

                    myRef.child(matchid).child("team1").child("players").child("8").child("batting").child("R").setValue(prun)
                    myRef.child(matchid).child("team1").child("players").child("8").child("batting").child("B").setValue(pball)
                }
                else if(player2_check.text.toString().equals(t1p10name)){
                    prun= (t1p10run.toInt()+1).toString()
                    pball= (t1p10balls.toInt()+1).toString()

                    myRef.child(matchid).child("team1").child("players").child("9").child("batting").child("R").setValue(prun)
                    myRef.child(matchid).child("team1").child("players").child("9").child("batting").child("B").setValue(pball)
                }
                else if(player2_check.text.toString().equals(t1p11name)){
                    prun= (t1p11run.toInt()+1).toString()
                    pball= (t1p11balls.toInt()+1).toString()

                    myRef.child(matchid).child("team1").child("players").child("10").child("batting").child("R").setValue(prun)
                    myRef.child(matchid).child("team1").child("players").child("10").child("batting").child("B").setValue(pball)
                }
                else if(player2_check.text.toString().equals(t1p12name)){
                    prun= (t1p12run.toInt()+1).toString()
                    pball= (t1p12balls.toInt()+1).toString()

                    myRef.child(matchid).child("team1").child("players").child("11").child("batting").child("R").setValue(prun)
                    myRef.child(matchid).child("team1").child("players").child("11").child("batting").child("B").setValue(pball)
                }

                if(player2_check.text.toString().equals(t2p1name)){
                    prun= (t2p1run.toInt()+1).toString()
                    pball= (t2p1balls.toInt()+1).toString()

                    myRef.child(matchid).child("team2").child("players").child("0").child("batting").child("R").setValue(prun)
                    myRef.child(matchid).child("team2").child("players").child("0").child("batting").child("B").setValue(pball)
                }
                else if(player2_check.text.toString().equals(t2p2name)){
                    prun= (t2p2run.toInt()+1).toString()
                    pball= (t2p2balls.toInt()+1).toString()

                    myRef.child(matchid).child("team2").child("players").child("1").child("batting").child("R").setValue(prun)
                    myRef.child(matchid).child("team2").child("players").child("1").child("batting").child("B").setValue(pball)
                }
                else if(player2_check.text.toString().equals(t2p3name)){
                    prun= (t2p3run.toInt()+1).toString()
                    pball= (t2p3balls.toInt()+1).toString()

                    myRef.child(matchid).child("team2").child("players").child("2").child("batting").child("R").setValue(prun)
                    myRef.child(matchid).child("team2").child("players").child("2").child("batting").child("B").setValue(pball)
                }
                else if(player2_check.text.toString().equals(t2p4name)){
                    prun= (t2p4run.toInt()+1).toString()
                    pball= (t2p4balls.toInt()+1).toString()

                    myRef.child(matchid).child("team2").child("players").child("3").child("batting").child("R").setValue(prun)
                    myRef.child(matchid).child("team2").child("players").child("3").child("batting").child("B").setValue(pball)
                }
                else if(player2_check.text.toString().equals(t2p5name)){
                    prun= (t2p5run.toInt()+1).toString()
                    pball= (t2p5balls.toInt()+1).toString()

                    myRef.child(matchid).child("team2").child("players").child("4").child("batting").child("R").setValue(prun)
                    myRef.child(matchid).child("team2").child("players").child("4").child("batting").child("B").setValue(pball)
                }
                else if(player2_check.text.toString().equals(t2p6name)){
                    prun= (t2p6run.toInt()+1).toString()
                    pball= (t2p6balls.toInt()+1).toString()

                    myRef.child(matchid).child("team2").child("players").child("5").child("batting").child("R").setValue(prun)
                    myRef.child(matchid).child("team2").child("players").child("5").child("batting").child("B").setValue(pball)
                }
                else if(player2_check.text.toString().equals(t2p7name)){
                    prun= (t2p7run.toInt()+1).toString()
                    pball= (t2p7balls.toInt()+1).toString()

                    myRef.child(matchid).child("team2").child("players").child("6").child("batting").child("R").setValue(prun)
                    myRef.child(matchid).child("team2").child("players").child("6").child("batting").child("B").setValue(pball)
                }
                else if(player2_check.text.toString().equals(t2p8name)){
                    prun= (t2p8run.toInt()+1).toString()
                    pball= (t2p8balls.toInt()+1).toString()

                    myRef.child(matchid).child("team2").child("players").child("7").child("batting").child("R").setValue(prun)
                    myRef.child(matchid).child("team2").child("players").child("7").child("batting").child("B").setValue(pball)
                }
                else if(player2_check.text.toString().equals(t2p9name)){
                    prun= (t2p9run.toInt()+1).toString()
                    pball= (t2p9balls.toInt()+1).toString()

                    myRef.child(matchid).child("team2").child("players").child("8").child("batting").child("R").setValue(prun)
                    myRef.child(matchid).child("team2").child("players").child("8").child("batting").child("B").setValue(pball)
                }
                else if(player2_check.text.toString().equals(t2p10name)){
                    prun= (t2p10run.toInt()+1).toString()
                    pball= (t2p10balls.toInt()+1).toString()

                    myRef.child(matchid).child("team2").child("players").child("9").child("batting").child("R").setValue(prun)
                    myRef.child(matchid).child("team2").child("players").child("9").child("batting").child("B").setValue(pball)
                }
                else if(player2_check.text.toString().equals(t2p11name)){
                    prun= (t2p11run.toInt()+1).toString()
                    pball= (t2p11balls.toInt()+1).toString()

                    myRef.child(matchid).child("team2").child("players").child("10").child("batting").child("R").setValue(prun)
                    myRef.child(matchid).child("team2").child("players").child("10").child("batting").child("B").setValue(pball)
                }
                else if(player2_check.text.toString().equals(t2p12name)){
                    prun= (t2p12run.toInt()+1).toString()
                    pball= (t2p12balls.toInt()+1).toString()

                    myRef.child(matchid).child("team2").child("players").child("11").child("batting").child("R").setValue(prun)
                    myRef.child(matchid).child("team2").child("players").child("11").child("batting").child("B").setValue(pball)
                }

                if(bowler1_check.text.toString().equals(t1p1name)){
                    bowlerover= (t1b1over.toInt()+1).toString()
                    bowlerrun= (t1b1run.toInt()+1).toString()

                    myRef.child(matchid).child("team1").child("players").child("0").child("bowling").child("R").setValue(bowlerrun)
                    myRef.child(matchid).child("team1").child("players").child("0").child("bowling").child("O").setValue(bowlerover)
                }
                else if(bowler1_check.text.toString().equals(t1p2name)){
                    bowlerover= (t1b2over.toInt()+1).toString()
                    bowlerrun= (t1b2run.toInt()+1).toString()

                    myRef.child(matchid).child("team1").child("players").child("1").child("bowling").child("R").setValue(bowlerrun)
                    myRef.child(matchid).child("team1").child("players").child("1").child("bowling").child("O").setValue(bowlerover)
                }
                else if(bowler1_check.text.toString().equals(t1p3name)){
                    bowlerover= (t1b3over.toInt()+1).toString()
                    bowlerrun= (t1b3run.toInt()+1).toString()

                    myRef.child(matchid).child("team1").child("players").child("2").child("bowling").child("R").setValue(bowlerrun)
                    myRef.child(matchid).child("team1").child("players").child("2").child("bowling").child("O").setValue(bowlerover)
                }
                else if(bowler1_check.text.toString().equals(t1p4name)){
                    bowlerover= (t1b4over.toInt()+1).toString()
                    bowlerrun= (t1b4run.toInt()+1).toString()

                    myRef.child(matchid).child("team1").child("players").child("3").child("bowling").child("R").setValue(bowlerrun)
                    myRef.child(matchid).child("team1").child("players").child("3").child("bowling").child("O").setValue(bowlerover)
                }
                else if(bowler1_check.text.toString().equals(t1p5name)){
                    bowlerover= (t1b5over.toInt()+1).toString()
                    bowlerrun= (t1b5run.toInt()+1).toString()

                    myRef.child(matchid).child("team1").child("players").child("4").child("bowling").child("R").setValue(bowlerrun)
                    myRef.child(matchid).child("team1").child("players").child("4").child("bowling").child("O").setValue(bowlerover)
                }
                else if(bowler1_check.text.toString().equals(t1p6name)){
                    bowlerover= (t1b6over.toInt()+1).toString()
                    bowlerrun= (t1b6run.toInt()+1).toString()

                    myRef.child(matchid).child("team1").child("players").child("5").child("bowling").child("R").setValue(bowlerrun)
                    myRef.child(matchid).child("team1").child("players").child("5").child("bowling").child("O").setValue(bowlerover)
                }
                else if(bowler1_check.text.toString().equals(t1p7name)){
                    bowlerover= (t1b7over.toInt()+1).toString()
                    bowlerrun= (t1b7run.toInt()+1).toString()

                    myRef.child(matchid).child("team1").child("players").child("6").child("bowling").child("R").setValue(bowlerrun)
                    myRef.child(matchid).child("team1").child("players").child("6").child("bowling").child("O").setValue(bowlerover)
                }
                else if(bowler1_check.text.toString().equals(t1p8name)){
                    bowlerover= (t1b8over.toInt()+1).toString()
                    bowlerrun= (t1b8run.toInt()+1).toString()

                    myRef.child(matchid).child("team1").child("players").child("7").child("bowling").child("R").setValue(bowlerrun)
                    myRef.child(matchid).child("team1").child("players").child("7").child("bowling").child("O").setValue(bowlerover)
                }
                else if(bowler1_check.text.toString().equals(t1p9name)){
                    bowlerover= (t1b9over.toInt()+1).toString()
                    bowlerrun= (t1b9run.toInt()+1).toString()

                    myRef.child(matchid).child("team1").child("players").child("8").child("bowling").child("R").setValue(bowlerrun)
                    myRef.child(matchid).child("team1").child("players").child("8").child("bowling").child("O").setValue(bowlerover)
                }
                else if(bowler1_check.text.toString().equals(t1p10name)){
                    bowlerover= (t1b10over.toInt()+1).toString()
                    bowlerrun= (t1b10run.toInt()+1).toString()

                    myRef.child(matchid).child("team1").child("players").child("9").child("bowling").child("R").setValue(bowlerrun)
                    myRef.child(matchid).child("team1").child("players").child("9").child("bowling").child("O").setValue(bowlerover)
                }
                else if(bowler1_check.text.toString().equals(t1p11name)){
                    bowlerover= (t1b11over.toInt()+1).toString()
                    bowlerrun= (t1b11run.toInt()+1).toString()

                    myRef.child(matchid).child("team1").child("players").child("10").child("bowling").child("R").setValue(bowlerrun)
                    myRef.child(matchid).child("team1").child("players").child("10").child("bowling").child("O").setValue(bowlerover)
                }
                else if(bowler1_check.text.toString().equals(t1p12name)){
                    bowlerover= (t1b12over.toInt()+1).toString()
                    bowlerrun= (t1b12run.toInt()+1).toString()

                    myRef.child(matchid).child("team1").child("players").child("11").child("bowling").child("R").setValue(bowlerrun)
                    myRef.child(matchid).child("team1").child("players").child("11").child("bowling").child("O").setValue(bowlerover)
                }

                if(bowler1_check.text.toString().equals(t2p1name)){
                    bowlerover= (t2b1over.toInt()+1).toString()
                    bowlerrun= (t2b1run.toInt()+1).toString()

                    myRef.child(matchid).child("team2").child("players").child("0").child("bowling").child("R").setValue(bowlerrun)
                    myRef.child(matchid).child("team2").child("players").child("0").child("bowling").child("O").setValue(bowlerover)
                }
                else if(bowler1_check.text.toString().equals(t2p2name)){
                    bowlerover= (t2b2over.toInt()+1).toString()
                    bowlerrun= (t2b2run.toInt()+1).toString()

                    myRef.child(matchid).child("team2").child("players").child("1").child("bowling").child("R").setValue(bowlerrun)
                    myRef.child(matchid).child("team2").child("players").child("1").child("bowling").child("O").setValue(bowlerover)
                }
                else if(bowler1_check.text.toString().equals(t2p3name)){
                    bowlerover= (t2b3over.toInt()+1).toString()
                    bowlerrun= (t2b3run.toInt()+1).toString()

                    myRef.child(matchid).child("team2").child("players").child("2").child("bowling").child("R").setValue(bowlerrun)
                    myRef.child(matchid).child("team2").child("players").child("2").child("bowling").child("O").setValue(bowlerover)
                }
                else if(bowler1_check.text.toString().equals(t2p4name)){
                    bowlerover= (t2b4over.toInt()+1).toString()
                    bowlerrun= (t2b4run.toInt()+1).toString()

                    myRef.child(matchid).child("team2").child("players").child("3").child("bowling").child("R").setValue(bowlerrun)
                    myRef.child(matchid).child("team2").child("players").child("3").child("bowling").child("O").setValue(bowlerover)
                }
                else if(bowler1_check.text.toString().equals(t2p5name)){
                    bowlerover= (t2b5over.toInt()+1).toString()
                    bowlerrun= (t2b5run.toInt()+1).toString()

                    myRef.child(matchid).child("team2").child("players").child("4").child("bowling").child("R").setValue(bowlerrun)
                    myRef.child(matchid).child("team2").child("players").child("4").child("bowling").child("O").setValue(bowlerover)
                }
                else if(bowler1_check.text.toString().equals(t2p6name)){
                    bowlerover= (t2b6over.toInt()+1).toString()
                    bowlerrun= (t2b6run.toInt()+1).toString()

                    myRef.child(matchid).child("team2").child("players").child("5").child("bowling").child("R").setValue(bowlerrun)
                    myRef.child(matchid).child("team2").child("players").child("5").child("bowling").child("O").setValue(bowlerover)
                }
                else if(bowler1_check.text.toString().equals(t2p7name)){
                    bowlerover= (t2b7over.toInt()+1).toString()
                    bowlerrun= (t2b7run.toInt()+1).toString()

                    myRef.child(matchid).child("team2").child("players").child("6").child("bowling").child("R").setValue(bowlerrun)
                    myRef.child(matchid).child("team2").child("players").child("6").child("bowling").child("O").setValue(bowlerover)
                }
                else if(bowler1_check.text.toString().equals(t2p8name)){
                    bowlerover= (t2b8over.toInt()+1).toString()
                    bowlerrun= (t2b8run.toInt()+1).toString()

                    myRef.child(matchid).child("team2").child("players").child("7").child("bowling").child("R").setValue(bowlerrun)
                    myRef.child(matchid).child("team2").child("players").child("7").child("bowling").child("O").setValue(bowlerover)
                }
                else if(bowler1_check.text.toString().equals(t2p9name)){
                    bowlerover= (t2b9over.toInt()+1).toString()
                    bowlerrun= (t2b9run.toInt()+1).toString()

                    myRef.child(matchid).child("team2").child("players").child("8").child("bowling").child("R").setValue(bowlerrun)
                    myRef.child(matchid).child("team2").child("players").child("8").child("bowling").child("O").setValue(bowlerover)
                }
                else if(bowler1_check.text.toString().equals(t2p10name)){
                    bowlerover= (t2b10over.toInt()+1).toString()
                    bowlerrun= (t2b10run.toInt()+1).toString()

                    myRef.child(matchid).child("team2").child("players").child("9").child("bowling").child("R").setValue(bowlerrun)
                    myRef.child(matchid).child("team2").child("players").child("9").child("bowling").child("O").setValue(bowlerover)
                }
                else if(bowler1_check.text.toString().equals(t2p11name)){
                    bowlerover= (t2b11over.toInt()+1).toString()
                    bowlerrun= (t2b11run.toInt()+1).toString()

                    myRef.child(matchid).child("team2").child("players").child("10").child("bowling").child("R").setValue(bowlerrun)
                    myRef.child(matchid).child("team2").child("players").child("10").child("bowling").child("O").setValue(bowlerover)
                }
                else if(bowler1_check.text.toString().equals(t2p12name)){
                    bowlerover= (t2b12over.toInt()+1).toString()
                    bowlerrun= (t2b12run.toInt()+1).toString()

                    myRef.child(matchid).child("team2").child("players").child("11").child("bowling").child("R").setValue(bowlerrun)
                    myRef.child(matchid).child("team2").child("players").child("11").child("bowling").child("O").setValue(bowlerover)
                }

               *//* myRef.child(matchid).child("Batsman").child("b2").child("R").setValue(prun)
                myRef.child(matchid).child("Batsman").child("b2").child("B").setValue(pball)
                myRef.child(matchid).child("Bowling").child("bowler1").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("Bowling").child("bowler1").child("O").setValue(bowlerover)
               *//*
                if(choosebattingteam.equals(t1name)){
                    myRef.child(matchid).child("team1").child("run").setValue(team1run)
                    myRef.child(matchid).child("team1").child("over").setValue(countover)
                      if(inning.equals("2")){
                          myRef.child(matchid).child("remainingballs").setValue(ballsremaining)

                      }
                }else{
                    myRef.child(matchid).child("team2").child("run").setValue(team2run)
                    myRef.child(matchid).child("team2").child("over").setValue(countover)
                    if(inning.equals("2")){
                        myRef.child(matchid).child("remainingballs").setValue(ballsremaining)

                    }
                }
                Toast.makeText(this,"player2 run"+" "+prun,Toast.LENGTH_SHORT).show()

            }else if(player2_check.isChecked && bowler2_check.isChecked  ){
               *//* prun= (b2run.toInt()+1).toString()
                pball= (b2ball.toInt()+1).toString()
                bowlerover= (bowler2over.toInt()+1).toString()
                bowlerrun= (bowler2run.toInt()+1).toString()*//*
                team1run=(t1run.toInt()+1).toString()
                team2run=(t2run.toInt()+1).toString()

                Log.d("bharti11", "Value b2 is: $prun")

                if(player2_check.text.toString().equals(t1p1name)){
                    prun= (t1p1run.toInt()+1).toString()
                    pball= (t1p1balls.toInt()+1).toString()

                    myRef.child(matchid).child("team1").child("players").child("0").child("batting").child("R").setValue(prun)
                    myRef.child(matchid).child("team1").child("players").child("0").child("batting").child("B").setValue(pball)
                }
                else if(player2_check.text.toString().equals(t1p2name)){
                    prun= (t1p2run.toInt()+1).toString()
                    pball= (t1p2balls.toInt()+1).toString()

                    myRef.child(matchid).child("team1").child("players").child("1").child("batting").child("R").setValue(prun)
                    myRef.child(matchid).child("team1").child("players").child("1").child("batting").child("B").setValue(pball)
                }
                else if(player2_check.text.toString().equals(t1p3name)){
                    prun= (t1p3run.toInt()+1).toString()
                    pball= (t1p3balls.toInt()+1).toString()

                    myRef.child(matchid).child("team1").child("players").child("2").child("batting").child("R").setValue(prun)
                    myRef.child(matchid).child("team1").child("players").child("2").child("batting").child("B").setValue(pball)
                }
                else if(player2_check.text.toString().equals(t1p4name)){
                    prun= (t1p4run.toInt()+1).toString()
                    pball= (t1p4balls.toInt()+1).toString()

                    myRef.child(matchid).child("team1").child("players").child("3").child("batting").child("R").setValue(prun)
                    myRef.child(matchid).child("team1").child("players").child("3").child("batting").child("B").setValue(pball)
                }
                else if(player2_check.text.toString().equals(t1p5name)){
                    prun= (t1p5run.toInt()+1).toString()
                    pball= (t1p5balls.toInt()+1).toString()

                    myRef.child(matchid).child("team1").child("players").child("4").child("batting").child("R").setValue(prun)
                    myRef.child(matchid).child("team1").child("players").child("4").child("batting").child("B").setValue(pball)
                }
                else if(player2_check.text.toString().equals(t1p6name)){
                    prun= (t1p6run.toInt()+1).toString()
                    pball= (t1p6balls.toInt()+1).toString()

                    myRef.child(matchid).child("team1").child("players").child("5").child("batting").child("R").setValue(prun)
                    myRef.child(matchid).child("team1").child("players").child("5").child("batting").child("B").setValue(pball)
                }
                else if(player2_check.text.toString().equals(t1p7name)){
                    prun= (t1p7run.toInt()+1).toString()
                    pball= (t1p7balls.toInt()+1).toString()

                    myRef.child(matchid).child("team1").child("players").child("6").child("batting").child("R").setValue(prun)
                    myRef.child(matchid).child("team1").child("players").child("6").child("batting").child("B").setValue(pball)
                }
                else if(player2_check.text.toString().equals(t1p8name)){
                    prun= (t1p8run.toInt()+1).toString()
                    pball= (t1p8balls.toInt()+1).toString()

                    myRef.child(matchid).child("team1").child("players").child("7").child("batting").child("R").setValue(prun)
                    myRef.child(matchid).child("team1").child("players").child("7").child("batting").child("B").setValue(pball)
                }
                else if(player2_check.text.toString().equals(t1p9name)){
                    prun= (t1p9run.toInt()+1).toString()
                    pball= (t1p9balls.toInt()+1).toString()

                    myRef.child(matchid).child("team1").child("players").child("8").child("batting").child("R").setValue(prun)
                    myRef.child(matchid).child("team1").child("players").child("8").child("batting").child("B").setValue(pball)
                }
                else if(player2_check.text.toString().equals(t1p10name)){
                    prun= (t1p10run.toInt()+1).toString()
                    pball= (t1p10balls.toInt()+1).toString()

                    myRef.child(matchid).child("team1").child("players").child("9").child("batting").child("R").setValue(prun)
                    myRef.child(matchid).child("team1").child("players").child("9").child("batting").child("B").setValue(pball)
                }
                else if(player2_check.text.toString().equals(t1p11name)){
                    prun= (t1p11run.toInt()+1).toString()
                    pball= (t1p11balls.toInt()+1).toString()

                    myRef.child(matchid).child("team1").child("players").child("10").child("batting").child("R").setValue(prun)
                    myRef.child(matchid).child("team1").child("players").child("10").child("batting").child("B").setValue(pball)
                }
                else if(player2_check.text.toString().equals(t1p12name)){
                    prun= (t1p12run.toInt()+1).toString()
                    pball= (t1p12balls.toInt()+1).toString()

                    myRef.child(matchid).child("team1").child("players").child("11").child("batting").child("R").setValue(prun)
                    myRef.child(matchid).child("team1").child("players").child("11").child("batting").child("B").setValue(pball)
                }

                if(player2_check.text.toString().equals(t2p1name)){
                    prun= (t2p1run.toInt()+1).toString()
                    pball= (t2p1balls.toInt()+1).toString()

                    myRef.child(matchid).child("team2").child("players").child("0").child("batting").child("R").setValue(prun)
                    myRef.child(matchid).child("team2").child("players").child("0").child("batting").child("B").setValue(pball)
                }
                else if(player2_check.text.toString().equals(t2p2name)){
                    prun= (t2p2run.toInt()+1).toString()
                    pball= (t2p2balls.toInt()+1).toString()

                    myRef.child(matchid).child("team2").child("players").child("1").child("batting").child("R").setValue(prun)
                    myRef.child(matchid).child("team2").child("players").child("1").child("batting").child("B").setValue(pball)
                }
                else if(player2_check.text.toString().equals(t2p3name)){
                    prun= (t2p3run.toInt()+1).toString()
                    pball= (t2p3balls.toInt()+1).toString()

                    myRef.child(matchid).child("team2").child("players").child("2").child("batting").child("R").setValue(prun)
                    myRef.child(matchid).child("team2").child("players").child("2").child("batting").child("B").setValue(pball)
                }
                else if(player2_check.text.toString().equals(t2p4name)){
                    prun= (t2p4run.toInt()+1).toString()
                    pball= (t2p4balls.toInt()+1).toString()

                    myRef.child(matchid).child("team2").child("players").child("3").child("batting").child("R").setValue(prun)
                    myRef.child(matchid).child("team2").child("players").child("3").child("batting").child("B").setValue(pball)
                }
                else if(player2_check.text.toString().equals(t2p5name)){
                    prun= (t2p5run.toInt()+1).toString()
                    pball= (t2p5balls.toInt()+1).toString()

                    myRef.child(matchid).child("team2").child("players").child("4").child("batting").child("R").setValue(prun)
                    myRef.child(matchid).child("team2").child("players").child("4").child("batting").child("B").setValue(pball)
                }
                else if(player2_check.text.toString().equals(t2p6name)){
                    prun= (t2p6run.toInt()+1).toString()
                    pball= (t2p6balls.toInt()+1).toString()

                    myRef.child(matchid).child("team2").child("players").child("5").child("batting").child("R").setValue(prun)
                    myRef.child(matchid).child("team2").child("players").child("5").child("batting").child("B").setValue(pball)
                }
                else if(player2_check.text.toString().equals(t2p7name)){
                    prun= (t2p7run.toInt()+1).toString()
                    pball= (t2p7balls.toInt()+1).toString()

                    myRef.child(matchid).child("team2").child("players").child("6").child("batting").child("R").setValue(prun)
                    myRef.child(matchid).child("team2").child("players").child("6").child("batting").child("B").setValue(pball)
                }
                else if(player2_check.text.toString().equals(t2p8name)){
                    prun= (t2p8run.toInt()+1).toString()
                    pball= (t2p8balls.toInt()+1).toString()

                    myRef.child(matchid).child("team2").child("players").child("7").child("batting").child("R").setValue(prun)
                    myRef.child(matchid).child("team2").child("players").child("7").child("batting").child("B").setValue(pball)
                }
                else if(player2_check.text.toString().equals(t2p9name)){
                    prun= (t2p9run.toInt()+1).toString()
                    pball= (t2p9balls.toInt()+1).toString()

                    myRef.child(matchid).child("team2").child("players").child("8").child("batting").child("R").setValue(prun)
                    myRef.child(matchid).child("team2").child("players").child("8").child("batting").child("B").setValue(pball)
                }
                else if(player2_check.text.toString().equals(t2p10name)){
                    prun= (t2p10run.toInt()+1).toString()
                    pball= (t2p10balls.toInt()+1).toString()

                    myRef.child(matchid).child("team2").child("players").child("9").child("batting").child("R").setValue(prun)
                    myRef.child(matchid).child("team2").child("players").child("9").child("batting").child("B").setValue(pball)
                }
                else if(player2_check.text.toString().equals(t2p11name)){
                    prun= (t2p11run.toInt()+1).toString()
                    pball= (t2p11balls.toInt()+1).toString()

                    myRef.child(matchid).child("team2").child("players").child("10").child("batting").child("R").setValue(prun)
                    myRef.child(matchid).child("team2").child("players").child("10").child("batting").child("B").setValue(pball)
                }
                else if(player2_check.text.toString().equals(t2p12name)){
                    prun= (t2p12run.toInt()+1).toString()
                    pball= (t2p12balls.toInt()+1).toString()

                    myRef.child(matchid).child("team2").child("players").child("11").child("batting").child("R").setValue(prun)
                    myRef.child(matchid).child("team2").child("players").child("11").child("batting").child("B").setValue(pball)
                }

                if(bowler2_check.text.toString().equals(t1p1name)){
                    bowlerover= (t1b1over.toInt()+1).toString()
                    bowlerrun= (t1b1run.toInt()+1).toString()

                    myRef.child(matchid).child("team1").child("players").child("0").child("bowling").child("R").setValue(bowlerrun)
                    myRef.child(matchid).child("team1").child("players").child("0").child("bowling").child("O").setValue(bowlerover)
                }
                else if(bowler2_check.text.toString().equals(t1p2name)){
                    bowlerover= (t1b2over.toInt()+1).toString()
                    bowlerrun= (t1b2run.toInt()+1).toString()

                    myRef.child(matchid).child("team1").child("players").child("1").child("bowling").child("R").setValue(bowlerrun)
                    myRef.child(matchid).child("team1").child("players").child("1").child("bowling").child("O").setValue(bowlerover)
                }
                else if(bowler2_check.text.toString().equals(t1p3name)){
                    bowlerover= (t1b3over.toInt()+1).toString()
                    bowlerrun= (t1b3run.toInt()+1).toString()

                    myRef.child(matchid).child("team1").child("players").child("2").child("bowling").child("R").setValue(bowlerrun)
                    myRef.child(matchid).child("team1").child("players").child("2").child("bowling").child("O").setValue(bowlerover)
                }
                else if(bowler2_check.text.toString().equals(t1p4name)){
                    bowlerover= (t1b4over.toInt()+1).toString()
                    bowlerrun= (t1b4run.toInt()+1).toString()

                    myRef.child(matchid).child("team1").child("players").child("3").child("bowling").child("R").setValue(bowlerrun)
                    myRef.child(matchid).child("team1").child("players").child("3").child("bowling").child("O").setValue(bowlerover)
                }
                else if(bowler2_check.text.toString().equals(t1p5name)){
                    bowlerover= (t1b5over.toInt()+1).toString()
                    bowlerrun= (t1b5run.toInt()+1).toString()

                    myRef.child(matchid).child("team1").child("players").child("4").child("bowling").child("R").setValue(bowlerrun)
                    myRef.child(matchid).child("team1").child("players").child("4").child("bowling").child("O").setValue(bowlerover)
                }
                else if(bowler2_check.text.toString().equals(t1p6name)){
                    bowlerover= (t1b6over.toInt()+1).toString()
                    bowlerrun= (t1b6run.toInt()+1).toString()

                    myRef.child(matchid).child("team1").child("players").child("5").child("bowling").child("R").setValue(bowlerrun)
                    myRef.child(matchid).child("team1").child("players").child("5").child("bowling").child("O").setValue(bowlerover)
                }
                else if(bowler2_check.text.toString().equals(t1p7name)){
                    bowlerover= (t1b7over.toInt()+1).toString()
                    bowlerrun= (t1b7run.toInt()+1).toString()

                    myRef.child(matchid).child("team1").child("players").child("6").child("bowling").child("R").setValue(bowlerrun)
                    myRef.child(matchid).child("team1").child("players").child("6").child("bowling").child("O").setValue(bowlerover)
                }
                else if(bowler2_check.text.toString().equals(t1p8name)){
                    bowlerover= (t1b8over.toInt()+1).toString()
                    bowlerrun= (t1b8run.toInt()+1).toString()

                    myRef.child(matchid).child("team1").child("players").child("7").child("bowling").child("R").setValue(bowlerrun)
                    myRef.child(matchid).child("team1").child("players").child("7").child("bowling").child("O").setValue(bowlerover)
                }
                else if(bowler2_check.text.toString().equals(t1p9name)){
                    bowlerover= (t1b9over.toInt()+1).toString()
                    bowlerrun= (t1b9run.toInt()+1).toString()

                    myRef.child(matchid).child("team1").child("players").child("8").child("bowling").child("R").setValue(bowlerrun)
                    myRef.child(matchid).child("team1").child("players").child("8").child("bowling").child("O").setValue(bowlerover)
                }
                else if(bowler2_check.text.toString().equals(t1p10name)){
                    bowlerover= (t1b10over.toInt()+1).toString()
                    bowlerrun= (t1b10run.toInt()+1).toString()

                    myRef.child(matchid).child("team1").child("players").child("9").child("bowling").child("R").setValue(bowlerrun)
                    myRef.child(matchid).child("team1").child("players").child("9").child("bowling").child("O").setValue(bowlerover)
                }
                else if(bowler2_check.text.toString().equals(t1p11name)){
                    bowlerover= (t1b11over.toInt()+1).toString()
                    bowlerrun= (t1b11run.toInt()+1).toString()

                    myRef.child(matchid).child("team1").child("players").child("10").child("bowling").child("R").setValue(bowlerrun)
                    myRef.child(matchid).child("team1").child("players").child("10").child("bowling").child("O").setValue(bowlerover)
                }
                else if(bowler2_check.text.toString().equals(t1p12name)){
                    bowlerover= (t1b12over.toInt()+1).toString()
                    bowlerrun= (t1b12run.toInt()+1).toString()

                    myRef.child(matchid).child("team1").child("players").child("11").child("bowling").child("R").setValue(bowlerrun)
                    myRef.child(matchid).child("team1").child("players").child("11").child("bowling").child("O").setValue(bowlerover)
                }

                if(bowler2_check.text.toString().equals(t2p1name)){
                    bowlerover= (t2b1over.toInt()+1).toString()
                    bowlerrun= (t2b1run.toInt()+1).toString()

                    myRef.child(matchid).child("team2").child("players").child("0").child("bowling").child("R").setValue(bowlerrun)
                    myRef.child(matchid).child("team2").child("players").child("0").child("bowling").child("O").setValue(bowlerover)
                }
                else if(bowler2_check.text.toString().equals(t2p2name)){
                    bowlerover= (t2b2over.toInt()+1).toString()
                    bowlerrun= (t2b2run.toInt()+1).toString()

                    myRef.child(matchid).child("team2").child("players").child("1").child("bowling").child("R").setValue(bowlerrun)
                    myRef.child(matchid).child("team2").child("players").child("1").child("bowling").child("O").setValue(bowlerover)
                }
                else if(bowler2_check.text.toString().equals(t2p3name)){
                    bowlerover= (t2b3over.toInt()+1).toString()
                    bowlerrun= (t2b3run.toInt()+1).toString()

                    myRef.child(matchid).child("team2").child("players").child("2").child("bowling").child("R").setValue(bowlerrun)
                    myRef.child(matchid).child("team2").child("players").child("2").child("bowling").child("O").setValue(bowlerover)
                }
                else if(bowler2_check.text.toString().equals(t2p4name)){
                    bowlerover= (t2b4over.toInt()+1).toString()
                    bowlerrun= (t2b4run.toInt()+1).toString()

                    myRef.child(matchid).child("team2").child("players").child("3").child("bowling").child("R").setValue(bowlerrun)
                    myRef.child(matchid).child("team2").child("players").child("3").child("bowling").child("O").setValue(bowlerover)
                }
                else if(bowler2_check.text.toString().equals(t2p5name)){
                    bowlerover= (t2b5over.toInt()+1).toString()
                    bowlerrun= (t2b5run.toInt()+1).toString()

                    myRef.child(matchid).child("team2").child("players").child("4").child("bowling").child("R").setValue(bowlerrun)
                    myRef.child(matchid).child("team2").child("players").child("4").child("bowling").child("O").setValue(bowlerover)
                }
                else if(bowler2_check.text.toString().equals(t2p6name)){
                    bowlerover= (t2b6over.toInt()+1).toString()
                    bowlerrun= (t2b6run.toInt()+1).toString()

                    myRef.child(matchid).child("team2").child("players").child("5").child("bowling").child("R").setValue(bowlerrun)
                    myRef.child(matchid).child("team2").child("players").child("5").child("bowling").child("O").setValue(bowlerover)
                }
                else if(bowler2_check.text.toString().equals(t2p7name)){
                    bowlerover= (t2b7over.toInt()+1).toString()
                    bowlerrun= (t2b7run.toInt()+1).toString()

                    myRef.child(matchid).child("team2").child("players").child("6").child("bowling").child("R").setValue(bowlerrun)
                    myRef.child(matchid).child("team2").child("players").child("6").child("bowling").child("O").setValue(bowlerover)
                }
                else if(bowler2_check.text.toString().equals(t2p8name)){
                    bowlerover= (t2b8over.toInt()+1).toString()
                    bowlerrun= (t2b8run.toInt()+1).toString()

                    myRef.child(matchid).child("team2").child("players").child("7").child("bowling").child("R").setValue(bowlerrun)
                    myRef.child(matchid).child("team2").child("players").child("7").child("bowling").child("O").setValue(bowlerover)
                }
                else if(bowler2_check.text.toString().equals(t2p9name)){
                    bowlerover= (t2b9over.toInt()+1).toString()
                    bowlerrun= (t2b9run.toInt()+1).toString()

                    myRef.child(matchid).child("team2").child("players").child("8").child("bowling").child("R").setValue(bowlerrun)
                    myRef.child(matchid).child("team2").child("players").child("8").child("bowling").child("O").setValue(bowlerover)
                }
                else if(bowler2_check.text.toString().equals(t2p10name)){
                    bowlerover= (t2b10over.toInt()+1).toString()
                    bowlerrun= (t2b10run.toInt()+1).toString()

                    myRef.child(matchid).child("team2").child("players").child("9").child("bowling").child("R").setValue(bowlerrun)
                    myRef.child(matchid).child("team2").child("players").child("9").child("bowling").child("O").setValue(bowlerover)
                }
                else if(bowler2_check.text.toString().equals(t2p11name)){
                    bowlerover= (t2b11over.toInt()+1).toString()
                    bowlerrun= (t2b11run.toInt()+1).toString()

                    myRef.child(matchid).child("team2").child("players").child("10").child("bowling").child("R").setValue(bowlerrun)
                    myRef.child(matchid).child("team2").child("players").child("10").child("bowling").child("O").setValue(bowlerover)
                }
                else if(bowler2_check.text.toString().equals(t2p12name)){
                    bowlerover= (t2b12over.toInt()+1).toString()
                    bowlerrun= (t2b12run.toInt()+1).toString()

                    myRef.child(matchid).child("team2").child("players").child("11").child("bowling").child("R").setValue(bowlerrun)
                    myRef.child(matchid).child("team2").child("players").child("11").child("bowling").child("O").setValue(bowlerover)
                }


                *//* myRef.child(matchid).child("Batsman").child("b2").child("R").setValue(prun)
                 myRef.child(matchid).child("Batsman").child("b2").child("B").setValue(pball)
                 myRef.child(matchid).child("Bowling").child("bowler2").child("R").setValue(bowlerrun)
                 myRef.child(matchid).child("Bowling").child("bowler2").child("O").setValue(bowlerover)
               *//*

                if(choosebattingteam.equals(t1name)){
                    myRef.child(matchid).child("team1").child("run").setValue(team1run)
                    myRef.child(matchid).child("team1").child("over").setValue(countover)

                }else{
                    myRef.child(matchid).child("team2").child("run").setValue(team2run)
                    myRef.child(matchid).child("team2").child("over").setValue(countover)

                }
                Toast.makeText(this,"player2 run"+" "+prun,Toast.LENGTH_SHORT).show()

            }


                myRef.child(matchid).child("balls").setValue(ballsremaining)

*/



        }

        run2_check.setOnClickListener {
            countRun(2,1,1)
           /* ballsremaining=(remainingballs.toInt()-1).toString()
            countballs= Integer.parseInt(ballsremaining)
            if(matchType.equals("T20")){
                minuscountballs=120-countballs
            }
            else if(matchType.equals("ODI")){
                minuscountballs=300-countballs
            }

            countover=overCalculate(minuscountballs)

            if(player1_check.isChecked && bowler1_check.isChecked  ){
                prun= (b1run.toInt()+2).toString()
                pball= (b1ball.toInt()+1).toString()
                bowlerover= (bowler1over.toInt()+1).toString()
                bowlerrun= (bowler1run.toInt()+2).toString()
                team1run=(t1run.toInt()+2).toString()
                team2run=(t2run.toInt()+2).toString()



                Log.d("bharti11", "Value b1 is: $prun")

                myRef.child(matchid).child("Batsman").child("b1").child("R").setValue(prun)
                myRef.child(matchid).child("Batsman").child("b1").child("B").setValue(pball)
                myRef.child(matchid).child("Bowling").child("bowler1").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("Bowling").child("bowler1").child("O").setValue(bowlerover)


                if(choosebattingteam.equals(t1name)){
                    myRef.child(matchid).child("team1").child("run").setValue(team1run)
                    myRef.child(matchid).child("team1").child("over").setValue(countover)

                }else{
                    myRef.child(matchid).child("team2").child("run").setValue(team2run)
                    myRef.child(matchid).child("team2").child("over").setValue(countover)

                }
                Toast.makeText(this,"player1 run"+" "+prun,Toast.LENGTH_SHORT).show()

            }
            else if(player1_check.isChecked && bowler2_check.isChecked  ){
                prun= (b1run.toInt()+2).toString()
                pball= (b1ball.toInt()+1).toString()
                bowlerover= (bowler2over.toInt()+1).toString()
                bowlerrun= (bowler2run.toInt()+2).toString()
                team1run=(t1run.toInt()+2).toString()
                team2run=(t2run.toInt()+2).toString()

                Log.d("bharti11", "Value b1 is: $prun")

                myRef.child(matchid).child("Batsman").child("b1").child("R").setValue(prun)
                myRef.child(matchid).child("Batsman").child("b1").child("B").setValue(pball)
                myRef.child(matchid).child("Bowling").child("bowler2").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("Bowling").child("bowler2").child("O").setValue(bowlerover)
                if(choosebattingteam.equals(t1name)){
                    myRef.child(matchid).child("team1").child("run").setValue(team1run)
                    myRef.child(matchid).child("team1").child("over").setValue(countover)

                }else{
                    myRef.child(matchid).child("team2").child("run").setValue(team2run)
                    myRef.child(matchid).child("team2").child("over").setValue(countover)

                }
                Toast.makeText(this,"player1 run"+" "+prun,Toast.LENGTH_SHORT).show()

            }
            else if(player2_check.isChecked && bowler1_check.isChecked ){
                prun= (b2run.toInt()+2).toString()
                pball= (b2ball.toInt()+1).toString()
                bowlerover= (bowler1over.toInt()+1).toString()
                bowlerrun= (bowler1run.toInt()+2).toString()
                team1run=(t1run.toInt()+2).toString()
                team2run=(t2run.toInt()+2).toString()

                Log.d("bharti11", "Value b2 is: $prun")

                myRef.child(matchid).child("Batsman").child("b2").child("R").setValue(prun)
                myRef.child(matchid).child("Batsman").child("b2").child("B").setValue(pball)
                myRef.child(matchid).child("Bowling").child("bowler1").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("Bowling").child("bowler1").child("O").setValue(bowlerover)
                if(choosebattingteam.equals(t1name)){
                    myRef.child(matchid).child("team1").child("run").setValue(team1run)
                    myRef.child(matchid).child("team1").child("over").setValue(countover)

                }else{
                    myRef.child(matchid).child("team2").child("run").setValue(team2run)
                    myRef.child(matchid).child("team2").child("over").setValue(countover)

                }
                Toast.makeText(this,"player2 run"+" "+prun,Toast.LENGTH_SHORT).show()

            }else if(player2_check.isChecked && bowler2_check.isChecked  ){
                prun= (b2run.toInt()+2).toString()
                pball= (b2ball.toInt()+1).toString()
                bowlerover= (bowler2over.toInt()+1).toString()
                bowlerrun= (bowler2run.toInt()+2).toString()
                team1run=(t1run.toInt()+2).toString()
                team2run=(t2run.toInt()+2).toString()

                Log.d("bharti11", "Value b2 is: $prun")

                myRef.child(matchid).child("Batsman").child("b2").child("R").setValue(prun)
                myRef.child(matchid).child("Batsman").child("b2").child("B").setValue(pball)
                myRef.child(matchid).child("Bowling").child("bowler2").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("Bowling").child("bowler2").child("O").setValue(bowlerover)
                if(choosebattingteam.equals(t1name)){
                    myRef.child(matchid).child("team1").child("run").setValue(team1run)
                    myRef.child(matchid).child("team1").child("over").setValue(countover)

                }else{
                    myRef.child(matchid).child("team2").child("run").setValue(team2run)
                    myRef.child(matchid).child("team2").child("over").setValue(countover)

                }
                Toast.makeText(this,"player2 run"+" "+prun,Toast.LENGTH_SHORT).show()

            }
            *//*if(inning.equals("2")){

                myRef.child(matchid).child("balls").setValue(ballsremaining)


            }*//*
            myRef.child(matchid).child("balls").setValue(ballsremaining)

*/


        }

        run3_check.setOnClickListener {
            countRun(3,1,1)
            /*ballsremaining=(remainingballs.toInt()-1).toString()
            countballs= Integer.parseInt(ballsremaining)
            if(matchType.equals("T20")){
                minuscountballs=120-countballs
            }
            else if(matchType.equals("ODI")){
                minuscountballs=300-countballs
            }
            else if(matchType.equals("Test")){
                minuscountballs=540-countballs
            }
            countover=overCalculate(minuscountballs)

            if(player1_check.isChecked && bowler1_check.isChecked  ){
                prun= (b1run.toInt()+3).toString()
                pball= (b1ball.toInt()+1).toString()
                bowlerover= (bowler1over.toInt()+1).toString()
                bowlerrun= (bowler1run.toInt()+3).toString()
                team1run=(t1run.toInt()+3).toString()
                team2run=(t2run.toInt()+3).toString()


                Log.d("bharti11", "Value b1 is: $prun")

                myRef.child(matchid).child("Batsman").child("b1").child("R").setValue(prun)
                myRef.child(matchid).child("Batsman").child("b1").child("B").setValue(pball)
                myRef.child(matchid).child("Bowling").child("bowler1").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("Bowling").child("bowler1").child("O").setValue(bowlerover)
                if(choosebattingteam.equals(t1name)){
                    myRef.child(matchid).child("team1").child("run").setValue(team1run)
                    myRef.child(matchid).child("team1").child("over").setValue(countover)

                }else{
                    myRef.child(matchid).child("team2").child("run").setValue(team2run)
                    myRef.child(matchid).child("team2").child("over").setValue(countover)

                }
                Toast.makeText(this,"player1 run"+" "+prun,Toast.LENGTH_SHORT).show()

            }
            else if(player1_check.isChecked && bowler2_check.isChecked  ){
                prun= (b1run.toInt()+3).toString()
                pball= (b1ball.toInt()+1).toString()
                bowlerover= (bowler2over.toInt()+1).toString()
                bowlerrun= (bowler2run.toInt()+3).toString()
                team1run=(t1run.toInt()+3).toString()
                team2run=(t2run.toInt()+3).toString()

                Log.d("bharti11", "Value b1 is: $prun")

                myRef.child(matchid).child("Batsman").child("b1").child("R").setValue(prun)
                myRef.child(matchid).child("Batsman").child("b1").child("B").setValue(pball)
                myRef.child(matchid).child("Bowling").child("bowler2").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("Bowling").child("bowler2").child("O").setValue(bowlerover)
                if(choosebattingteam.equals(t1name)){
                    myRef.child(matchid).child("team1").child("run").setValue(team1run)
                    myRef.child(matchid).child("team1").child("over").setValue(countover)

                }else{
                    myRef.child(matchid).child("team2").child("run").setValue(team2run)
                    myRef.child(matchid).child("team2").child("over").setValue(countover)

                }
                Toast.makeText(this,"player1 run"+" "+prun,Toast.LENGTH_SHORT).show()

            }
            else if(player2_check.isChecked && bowler1_check.isChecked){
                prun= (b2run.toInt()+3).toString()
                pball= (b2ball.toInt()+1).toString()
                bowlerover= (bowler1over.toInt()+1).toString()
                bowlerrun= (bowler1run.toInt()+3).toString()
                team1run=(t1run.toInt()+3).toString()
                team2run=(t2run.toInt()+3).toString()

                Log.d("bharti11", "Value b2 is: $prun")

                myRef.child(matchid).child("Batsman").child("b2").child("R").setValue(prun)
                myRef.child(matchid).child("Batsman").child("b2").child("B").setValue(pball)
                myRef.child(matchid).child("Bowling").child("bowler1").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("Bowling").child("bowler1").child("O").setValue(bowlerover)
                if(choosebattingteam.equals(t1name)){
                    myRef.child(matchid).child("team1").child("run").setValue(team1run)
                    myRef.child(matchid).child("team1").child("over").setValue(countover)

                }else{
                    myRef.child(matchid).child("team2").child("run").setValue(team2run)
                    myRef.child(matchid).child("team2").child("over").setValue(countover)

                }
                Toast.makeText(this,"player2 run"+" "+prun,Toast.LENGTH_SHORT).show()

            }else if(player2_check.isChecked && bowler2_check.isChecked ){
                prun= (b2run.toInt()+3).toString()
                pball= (b2ball.toInt()+1).toString()
                bowlerover= (bowler2over.toInt()+1).toString()
                bowlerrun= (bowler2run.toInt()+3).toString()
                team1run=(t1run.toInt()+3).toString()
                team2run=(t2run.toInt()+3).toString()

                Log.d("bharti11", "Value b2 is: $prun")

                myRef.child(matchid).child("Batsman").child("b2").child("R").setValue(prun)
                myRef.child(matchid).child("Batsman").child("b2").child("B").setValue(pball)
                myRef.child(matchid).child("Bowling").child("bowler2").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("Bowling").child("bowler2").child("O").setValue(bowlerover)
                if(choosebattingteam.equals(t1name)){
                    myRef.child(matchid).child("team1").child("run").setValue(team1run)
                    myRef.child(matchid).child("team1").child("over").setValue(countover)

                }else{
                    myRef.child(matchid).child("team2").child("run").setValue(team2run)
                    myRef.child(matchid).child("team2").child("over").setValue(countover)

                }
                Toast.makeText(this,"player2 run"+" "+prun,Toast.LENGTH_SHORT).show()

            }

                myRef.child(matchid).child("balls").setValue(ballsremaining)




*/
        }

        run4_check.setOnClickListener {
            countRun(4,1,4)

            /*ballsremaining=(remainingballs.toInt()-1).toString()
            countball= Integer.parseInt(ballsremaining)
            if(matchType.equals("T20")){
                minuscountballs=120-countball
            }
            else if(matchType.equals("ODI")){
                minuscountballs=300-countball
            }
            else if(matchType.equals("Test")){
                minuscountballs=540-countball
            }
            countover=overCalculate(minuscountballs)
            if(player1_check.isChecked && bowler1_check.isChecked  ){
                prun= (b1run.toInt()+4).toString()
                pball= (b1ball.toInt()+1).toString()
                bowlerover= (bowler1over.toInt()+1).toString()
                bowlerrun= (bowler1run.toInt()+4).toString()
                batsman4runcount= (b14s.toInt()+1).toString()
                team1run=(t1run.toInt()+4).toString()
                team2run=(t2run.toInt()+4).toString()


                Log.d("bharti11", "Value b1 is: $prun")

                myRef.child(matchid).child("Batsman").child("b1").child("R").setValue(prun)
                myRef.child(matchid).child("Batsman").child("b1").child("B").setValue(pball)
                myRef.child(matchid).child("Bowling").child("bowler1").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("Bowling").child("bowler1").child("O").setValue(bowlerover)
                myRef.child(matchid).child("Batsman").child("b1").child("4s").setValue(batsman4runcount)
                if(choosebattingteam.equals(t1name)){
                    myRef.child(matchid).child("team1").child("run").setValue(team1run)
                    myRef.child(matchid).child("team1").child("over").setValue(countover)

                }else{
                    myRef.child(matchid).child("team2").child("run").setValue(team2run)
                    myRef.child(matchid).child("team2").child("over").setValue(countover)

                }
                Toast.makeText(this,"player1 run"+" "+prun,Toast.LENGTH_SHORT).show()

            }
            else if(player1_check.isChecked && bowler2_check.isChecked  ){
                prun= (b1run.toInt()+4).toString()
                pball= (b1ball.toInt()+1).toString()
                bowlerover= (bowler2over.toInt()+1).toString()
                bowlerrun= (bowler2run.toInt()+4).toString()
                batsman4runcount= (b14s.toInt()+1).toString()
                team1run=(t1run.toInt()+4).toString()
                team2run=(t2run.toInt()+4).toString()

                Log.d("bharti11", "Value b1 is: $prun")

                myRef.child(matchid).child("Batsman").child("b1").child("R").setValue(prun)
                myRef.child(matchid).child("Batsman").child("b1").child("B").setValue(pball)
                myRef.child(matchid).child("Bowling").child("bowler2").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("Bowling").child("bowler2").child("O").setValue(bowlerover)
                myRef.child(matchid).child("Batsman").child("b1").child("4s").setValue(batsman4runcount)
                if(choosebattingteam.equals(t1name)){
                    myRef.child(matchid).child("team1").child("run").setValue(team1run)
                    myRef.child(matchid).child("team1").child("over").setValue(countover)

                }else{
                    myRef.child(matchid).child("team2").child("run").setValue(team2run)
                    myRef.child(matchid).child("team2").child("over").setValue(countover)

                }
                Toast.makeText(this,"player1 run"+" "+prun,Toast.LENGTH_SHORT).show()

            }
            else if(player2_check.isChecked && bowler1_check.isChecked ){
                prun= (b2run.toInt()+4).toString()
                pball= (b2ball.toInt()+1).toString()
                bowlerover= (bowler1over.toInt()+1).toString()
                bowlerrun= (bowler1run.toInt()+4).toString()
                batsman4runcount= (b24s.toInt()+1).toString()
                team1run=(t1run.toInt()+4).toString()
                team2run=(t2run.toInt()+4).toString()

                Log.d("bharti11", "Value b2 is: $prun")

                myRef.child(matchid).child("Batsman").child("b2").child("R").setValue(prun)
                myRef.child(matchid).child("Batsman").child("b2").child("B").setValue(pball)
                myRef.child(matchid).child("Bowling").child("bowler1").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("Bowling").child("bowler1").child("O").setValue(bowlerover)
                myRef.child(matchid).child("Batsman").child("b2").child("4s").setValue(batsman4runcount)
                if(choosebattingteam.equals(t1name)){
                    myRef.child(matchid).child("team1").child("run").setValue(team1run)
                    myRef.child(matchid).child("team1").child("over").setValue(countover)

                }else{
                    myRef.child(matchid).child("team2").child("run").setValue(team2run)
                    myRef.child(matchid).child("team2").child("over").setValue(countover)

                }
                Toast.makeText(this,"player2 run"+" "+prun,Toast.LENGTH_SHORT).show()

            }else if(player2_check.isChecked && bowler2_check.isChecked  ){
                prun= (b2run.toInt()+4).toString()
                pball= (b2ball.toInt()+1).toString()
                bowlerover= (bowler2over.toInt()+1).toString()
                bowlerrun= (bowler2run.toInt()+4).toString()
                batsman4runcount= (b24s.toInt()+1).toString()
                team1run=(t1run.toInt()+4).toString()
                team2run=(t2run.toInt()+4).toString()

                Log.d("bharti11", "Value b2 is: $prun")

                myRef.child(matchid).child("Batsman").child("b2").child("R").setValue(prun)
                myRef.child(matchid).child("Batsman").child("b2").child("B").setValue(pball)
                myRef.child(matchid).child("Bowling").child("bowler2").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("Bowling").child("bowler2").child("O").setValue(bowlerover)
                myRef.child(matchid).child("Batsman").child("b2").child("4s").setValue(batsman4runcount)
                if(choosebattingteam.equals(t1name)){
                    myRef.child(matchid).child("team1").child("run").setValue(team1run)
                    myRef.child(matchid).child("team1").child("over").setValue(countover)

                }else{
                    myRef.child(matchid).child("team2").child("run").setValue(team2run)
                    myRef.child(matchid).child("team2").child("over").setValue(countover)

                }
                Toast.makeText(this,"player2 run"+" "+prun,Toast.LENGTH_SHORT).show()

            }

                myRef.child(matchid).child("balls").setValue(ballsremaining)


*/



        }

        run5_check.setOnClickListener {
            countRun(6,1,6)

            /* ballsremaining=(remainingballs.toInt()-1).toString()
             countball= Integer.parseInt(ballsremaining)
             if(matchType.equals("T20")){
                 minuscountballs=120-countball
             }
             else if(matchType.equals("ODI")){
                 minuscountballs=300-countball
             }
             else if(matchType.equals("Test")){
                 minuscountballs=540-countball
             }
             countover=overCalculate(minuscountballs)
             if(player1_check.isChecked && bowler1_check.isChecked  ){
                 prun= (b1run.toInt()+6).toString()
                 pball= (b1ball.toInt()+1).toString()
                 bowlerover= (bowler1over.toInt()+1).toString()
                 bowlerrun= (bowler1run.toInt()+6).toString()
                 batsman6runcount= (b16s.toInt()+1).toString()
                 team1run=(t1run.toInt()+6).toString()
                 team2run=(t2run.toInt()+6).toString()

                 Log.d("bharti11", "Value b1 is: $prun")

                 myRef.child(matchid).child("Batsman").child("b1").child("R").setValue(prun)
                 myRef.child(matchid).child("Batsman").child("b1").child("B").setValue(pball)
                 myRef.child(matchid).child("Bowling").child("bowler1").child("R").setValue(bowlerrun)
                 myRef.child(matchid).child("Bowling").child("bowler1").child("O").setValue(bowlerover)
                 myRef.child(matchid).child("Batsman").child("b1").child("6s").setValue(batsman6runcount)
                 if(choosebattingteam.equals(t1name)){
                     myRef.child(matchid).child("team1").child("run").setValue(team1run)
                     myRef.child(matchid).child("team1").child("over").setValue(countover)

                 }else{
                     myRef.child(matchid).child("team2").child("run").setValue(team2run)
                     myRef.child(matchid).child("team2").child("over").setValue(countover)

                 }
                 Toast.makeText(this,"player1 run"+" "+prun,Toast.LENGTH_SHORT).show()

             }
             else if(player1_check.isChecked && bowler2_check.isChecked ){
                 prun= (b1run.toInt()+6).toString()
                 pball= (b1ball.toInt()+1).toString()
                 bowlerover= (bowler2over.toInt()+1).toString()
                 bowlerrun= (bowler2run.toInt()+6).toString()
                 batsman6runcount= (b16s.toInt()+1).toString()
                 team1run=(t1run.toInt()+6).toString()
                 team2run=(t2run.toInt()+6).toString()

                 Log.d("bharti11", "Value b1 is: $prun")

                 myRef.child(matchid).child("Batsman").child("b1").child("R").setValue(prun)
                 myRef.child(matchid).child("Batsman").child("b1").child("B").setValue(pball)
                 myRef.child(matchid).child("Bowling").child("bowler2").child("R").setValue(bowlerrun)
                 myRef.child(matchid).child("Bowling").child("bowler2").child("O").setValue(bowlerover)
                 myRef.child(matchid).child("Batsman").child("b1").child("6s").setValue(batsman6runcount)
                 if(choosebattingteam.equals(t1name)){
                     myRef.child(matchid).child("team1").child("run").setValue(team1run)
                     myRef.child(matchid).child("team1").child("over").setValue(countover)

                 }else{
                     myRef.child(matchid).child("team2").child("run").setValue(team2run)
                     myRef.child(matchid).child("team2").child("over").setValue(countover)

                 }
                 Toast.makeText(this,"player1 run"+" "+prun,Toast.LENGTH_SHORT).show()

             }
             else if(player2_check.isChecked && bowler1_check.isChecked ){
                 prun= (b2run.toInt()+6).toString()
                 pball= (b2ball.toInt()+1).toString()
                 bowlerover= (bowler1over.toInt()+1).toString()
                 bowlerrun= (bowler1run.toInt()+6).toString()
                 batsman6runcount= (b26s.toInt()+1).toString()
                 team1run=(t1run.toInt()+6).toString()
                 team2run=(t2run.toInt()+6).toString()

                 Log.d("bharti11", "Value b2 is: $prun")

                 myRef.child(matchid).child("Batsman").child("b2").child("R").setValue(prun)
                 myRef.child(matchid).child("Batsman").child("b2").child("B").setValue(pball)
                 myRef.child(matchid).child("Bowling").child("bowler1").child("R").setValue(bowlerrun)
                 myRef.child(matchid).child("Bowling").child("bowler1").child("O").setValue(bowlerover)
                 myRef.child(matchid).child("Batsman").child("b2").child("6s").setValue(batsman6runcount)
                 if(choosebattingteam.equals(t1name)){
                     myRef.child(matchid).child("team1").child("run").setValue(team1run)
                     myRef.child(matchid).child("team1").child("over").setValue(countover)

                 }else{
                     myRef.child(matchid).child("team2").child("run").setValue(team2run)
                     myRef.child(matchid).child("team2").child("over").setValue(countover)

                 }
                 Toast.makeText(this,"player2 run"+" "+prun,Toast.LENGTH_SHORT).show()

             }else if(player2_check.isChecked && bowler2_check.isChecked  ){
                 prun= (b2run.toInt()+6).toString()
                 pball= (b2ball.toInt()+1).toString()
                 bowlerover= (bowler2over.toInt()+1).toString()
                 bowlerrun= (bowler2run.toInt()+6).toString()
                 batsman6runcount= (b26s.toInt()+1).toString()
                 team1run=(t1run.toInt()+6).toString()
                 team2run=(t2run.toInt()+6).toString()

                 Log.d("bharti11", "Value b2 is: $prun")

                 myRef.child(matchid).child("Batsman").child("b2").child("R").setValue(prun)
                 myRef.child(matchid).child("Batsman").child("b2").child("B").setValue(pball)
                 myRef.child(matchid).child("Bowling").child("bowler2").child("R").setValue(bowlerrun)
                 myRef.child(matchid).child("Bowling").child("bowler2").child("O").setValue(bowlerover)
                 myRef.child(matchid).child("Batsman").child("b2").child("6s").setValue(batsman6runcount)
                 if(choosebattingteam.equals(t1name)){
                     myRef.child(matchid).child("team1").child("run").setValue(team1run)
                     myRef.child(matchid).child("team1").child("over").setValue(countover)

                 }else{
                     myRef.child(matchid).child("team2").child("run").setValue(team2run)
                     myRef.child(matchid).child("team2").child("over").setValue(countover)

                 }
                 Toast.makeText(this,"player2 run"+" "+prun,Toast.LENGTH_SHORT).show()

             }

                 myRef.child(matchid).child("balls").setValue(ballsremaining)

 */



        }
        brun1_check.setOnClickListener {
            countExtraRun(1,1)
           /* if(bowler1_check.isChecked  ){

                if(bowler1_check.text.toString().equals(t1p1name)){

                    brun= (t1b1run.toInt()+runNumber).toString()

                    myRef.child(matchid).child("team1").child("players").child("0").child("bowling").child("R").setValue(brun)
                }
                else if(bowler1_check.text.toString().equals(t1p2name)){
                    brun= (t1b2run.toInt()+runNumber).toString()

                    myRef.child(matchid).child("team1").child("players").child("1").child("bowling").child("R").setValue(brun)
                }
                else if(bowler1_check.text.toString().equals(t1p3name)){
                    brun= (t1b3run.toInt()+runNumber).toString()

                    myRef.child(matchid).child("team1").child("players").child("2").child("bowling").child("R").setValue(brun)
                }
                else if(bowler1_check.text.toString().equals(t1p4name)){
                    brun= (t1b4run.toInt()+runNumber).toString()

                    myRef.child(matchid).child("team1").child("players").child("3").child("bowling").child("R").setValue(brun)
                }
                else if(bowler1_check.text.toString().equals(t1p5name)){
                    brun= (t1b5run.toInt()+runNumber).toString()

                    myRef.child(matchid).child("team1").child("players").child("4").child("bowling").child("R").setValue(brun)
                }
                else if(bowler1_check.text.toString().equals(t1p6name)){
                    brun= (t1b6run.toInt()+runNumber).toString()

                    myRef.child(matchid).child("team1").child("players").child("5").child("bowling").child("R").setValue(brun)
                }
                else if(bowler1_check.text.toString().equals(t1p7name)){
                    brun= (t1b7run.toInt()+runNumber).toString()

                    myRef.child(matchid).child("team1").child("players").child("6").child("bowling").child("R").setValue(brun)
                }
                else if(bowler1_check.text.toString().equals(t1p8name)){
                    brun= (t1b8run.toInt()+runNumber).toString()

                    myRef.child(matchid).child("team1").child("players").child("7").child("bowling").child("R").setValue(brun)
                }
                else if(bowler1_check.text.toString().equals(t1p9name)){
                    brun= (t1b9run.toInt()+runNumber).toString()

                    myRef.child(matchid).child("team1").child("players").child("8").child("bowling").child("R").setValue(brun)
                }
                else if(bowler1_check.text.toString().equals(t1p10name)){
                    brun= (t1b10run.toInt()+runNumber).toString()

                    myRef.child(matchid).child("team1").child("players").child("9").child("bowling").child("R").setValue(brun)
                }
                else if(bowler1_check.text.toString().equals(t1p11name)){
                    brun= (t1b11run.toInt()+runNumber).toString()

                    myRef.child(matchid).child("team1").child("players").child("10").child("bowling").child("R").setValue(brun)
                }
                else if(bowler1_check.text.toString().equals(t1p12name)){
                    brun= (t1b12run.toInt()+runNumber).toString()

                    myRef.child(matchid).child("team1").child("players").child("11").child("bowling").child("R").setValue(brun)
                }




            }else if(bowler2_check.isChecked  ){
                brun= (bowler2run.toInt()+1).toString()
                Log.d("bharti11", "Value b2 is: $brun")

                myRef.child(matchid).child("Bowling").child("bowler2").child("R").setValue(brun)
                Toast.makeText(this,"bowler2 run"+" "+brun,Toast.LENGTH_SHORT).show()

            }
            team1run=(t1run.toInt()+1).toString()
            team2run=(t2run.toInt()+1).toString()
            if(choosebattingteam.equals(t1name)){


                myRef.child(matchid).child("team1").child("run").setValue(team1run)
                //   myRef.child(matchid).child("team1").child("over").setValue(team1run)

            }else{
                myRef.child(matchid).child("team2").child("run").setValue(team2run)

            }*/



        }
        brun2_check.setOnClickListener {
            countExtraRun(2,1)

           /* if(bowler1_check.isChecked  ){
                brun= (bowler1run.toInt()+2).toString()
                Log.d("bharti11", "Value b1 is: $brun")

                myRef.child(matchid).child("Bowling").child("bowler1").child("R").setValue(brun)
                Toast.makeText(this,"bowler1 run"+" "+brun,Toast.LENGTH_SHORT).show()

            }else if(bowler2_check.isChecked  ){
                brun= (bowler2run.toInt()+2).toString()
                Log.d("bharti11", "Value b2 is: $brun")

                myRef.child(matchid).child("Bowling").child("bowler2").child("R").setValue(brun)
                Toast.makeText(this,"bowler2 run"+" "+brun,Toast.LENGTH_SHORT).show()

            }
            team1run=(t1run.toInt()+2).toString()
            team2run=(t2run.toInt()+2).toString()
            if(choosebattingteam.equals(t1name)){


                myRef.child(matchid).child("team1").child("run").setValue(team1run)
                //   myRef.child(matchid).child("team1").child("over").setValue(team1run)

            }else{
                myRef.child(matchid).child("team2").child("run").setValue(team2run)

            }*/

        }
        brun3_check.setOnClickListener {
            countExtraRun(3,1)

            /*if(bowler1_check.isChecked  ){
                brun= (bowler1run.toInt()+3).toString()
                Log.d("bharti11", "Value b1 is: $brun")

                myRef.child(matchid).child("Bowling").child("bowler1").child("R").setValue(brun)
                Toast.makeText(this,"bowler1 run"+" "+brun,Toast.LENGTH_SHORT).show()

            }else if(bowler2_check.isChecked  ){
                brun= (bowler2run.toInt()+3).toString()
                Log.d("bharti11", "Value b2 is: $brun")

                myRef.child(matchid).child("Bowling").child("bowler2").child("R").setValue(brun)
                Toast.makeText(this,"bowler2 run"+" "+brun,Toast.LENGTH_SHORT).show()

            }
            team1run=(t1run.toInt()+3).toString()
            team2run=(t2run.toInt()+3).toString()
            if(choosebattingteam.equals(t1name)){


                myRef.child(matchid).child("team1").child("run").setValue(team1run)
                //   myRef.child(matchid).child("team1").child("over").setValue(team1run)

            }else{
                myRef.child(matchid).child("team2").child("run").setValue(team2run)

            }*/
        }
        brun4_check.setOnClickListener {
            countExtraRun(4,1)

           /* if(bowler1_check.isChecked  ){
                brun= (bowler1run.toInt()+4).toString()
                Log.d("bharti11", "Value b1 is: $brun")

                myRef.child(matchid).child("Bowling").child("bowler1").child("R").setValue(brun)
                Toast.makeText(this,"bowler1 run"+" "+brun,Toast.LENGTH_SHORT).show()

            }else if(bowler2_check.isChecked  ){
                brun= (bowler2run.toInt()+4).toString()
                Log.d("bharti11", "Value b2 is: $brun")

                myRef.child(matchid).child("Bowling").child("bowler2").child("R").setValue(brun)
                Toast.makeText(this,"bowler2 run"+" "+brun,Toast.LENGTH_SHORT).show()

            }
            team1run=(t1run.toInt()+4).toString()
            team2run=(t2run.toInt()+4).toString()
            if(choosebattingteam.equals(t1name)){


                myRef.child(matchid).child("team1").child("run").setValue(team1run)
                //   myRef.child(matchid).child("team1").child("over").setValue(team1run)

            }else{
                myRef.child(matchid).child("team2").child("run").setValue(team2run)

            }*/


        }
        brun5_check.setOnClickListener {
            countExtraRun(6,1)

           /* if(bowler1_check.isChecked  ){
                brun= (bowler1run.toInt()+6).toString()
                Log.d("bharti11", "Value b1 is: $brun")

                myRef.child(matchid).child("Bowling").child("bowler1").child("R").setValue(brun)
                Toast.makeText(this,"bowler1 run"+" "+brun,Toast.LENGTH_SHORT).show()

            }else if(bowler2_check.isChecked  ){
                brun= (bowler2run.toInt()+6).toString()
                Log.d("bharti11", "Value b2 is: $brun")

                myRef.child(matchid).child("Bowling").child("bowler2").child("R").setValue(brun)
                Toast.makeText(this,"bowler2 run"+" "+brun,Toast.LENGTH_SHORT).show()

            }
            team1run=(t1run.toInt()+6).toString()
            team2run=(t2run.toInt()+6).toString()
            if(choosebattingteam.equals(t1name)){


                myRef.child(matchid).child("team1").child("run").setValue(team1run)
                //   myRef.child(matchid).child("team1").child("over").setValue(team1run)

            }else{
                myRef.child(matchid).child("team2").child("run").setValue(team2run)

            }*/

        }






//for add child object
        /*  DatabaseReference path= database.getReference("matches").child("match4");
        path.child("Batsman").setValue("123");*/

//Log.d("bharti","key"+key);

        // myRef.setValue("Hello, World!");
        myRef.addValueEventListener(object : ValueEventListener {
            @SuppressLint("SetTextI18n")
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                if (arrayList.size > 0) {
                    arrayList.clear()
                }
                for (taskNo in dataSnapshot.children) {
                    // now you in (9223450)
                    keyid = taskNo.key!!
                    val firebaseObj = taskNo.value //class with params set/get methods
                    //   Object replayObj = taskNo.getValue(); //class with params set/get methods
                    if (keyid == matchid) {
                        status = taskNo.child("status").value!!.toString()
                        matchType = taskNo.child("matchType").value!!.toString()
                        val tosswinteam = taskNo.child("tossWiningTeam").value!!.toString()
                        remainingballs = taskNo.child("remainingBalls").value!!.toString()
                        choosebattingteam = taskNo.child("chooseBattingTeam").value!!.toString()
                        batsmanStrike = taskNo.child("batsmanStrike").value!!.toString()
                        bowlerStrike = taskNo.child("bowlerStrike").value!!.toString()
                        batsman1= taskNo.child("batsman1").value!!.toString()
                        batsman2 = taskNo.child("batsman2").value!!.toString()
                        bowler1 = taskNo.child("bowler1").value!!.toString()
                        bowler2 = taskNo.child("bowler2").value!!.toString()
                        bowler1CountBalls = taskNo.child("bowler1CountBalls").value!!.toString()
                        bowler2CountBalls = taskNo.child("bowler2CountBalls").value!!.toString()

                        inning = taskNo.child("inning").value!!.toString()

                        Log.d("bharti11", "Value is: $keyid $tosswinteam $status $remainingballs ${taskNo.key}")
                        // ALTERNATIVE
                        //if(key.equals("match1")) {
                        for (child in taskNo.children) {
                            if (child.key == "team1") {
                                t1over = child.child("over").value!!.toString()
                                t1name = child.child("name").value!!.toString()
                                t1run = child.child("run").value!!.toString()
                                t1viket = child.child("wicket").value!!.toString()

                                t1p1name = child.child("players").child("0").child("name").value!!.toString()
                                t1p1run = child.child("players").child("0").child("batting").child("R").value!!.toString()
                                t1p1balls = child.child("players").child("0").child("batting").child("B").value!!.toString()
                                t1p14s = child.child("players").child("0").child("batting").child("4s").value!!.toString()
                                t1p16s = child.child("players").child("0").child("batting").child("6s").value!!.toString()
                                t1b1M = child.child("players").child("0").child("bowling").child("M").value!!.toString()
                                t1b1over = child.child("players").child("0").child("bowling").child("O").value!!.toString()
                                t1b1run = child.child("players").child("0").child("bowling").child("R").value!!.toString()
                                t1b1W = child.child("players").child("0").child("bowling").child("W").value!!.toString()

                                t1p2name = child.child("players").child("1").child("name").value!!.toString()
                                t1p2run = child.child("players").child("1").child("batting").child("R").value!!.toString()
                                t1p2balls = child.child("players").child("1").child("batting").child("B").value!!.toString()
                                t1p24s = child.child("players").child("1").child("batting").child("4s").value!!.toString()
                                t1p26s = child.child("players").child("1").child("batting").child("6s").value!!.toString()
                                t1b2M = child.child("players").child("1").child("bowling").child("M").value!!.toString()
                                t1b2over = child.child("players").child("1").child("bowling").child("O").value!!.toString()
                                t1b2run = child.child("players").child("1").child("bowling").child("R").value!!.toString()
                                t1b2W = child.child("players").child("1").child("bowling").child("W").value!!.toString()

                                t1p3name = child.child("players").child("2").child("name").value!!.toString()
                                t1p3run = child.child("players").child("2").child("batting").child("R").value!!.toString()
                                t1p3balls = child.child("players").child("2").child("batting").child("B").value!!.toString()
                                t1p34s = child.child("players").child("2").child("batting").child("4s").value!!.toString()
                                t1p36s = child.child("players").child("2").child("batting").child("6s").value!!.toString()
                                t1b3M = child.child("players").child("2").child("bowling").child("M").value!!.toString()
                                t1b3over = child.child("players").child("2").child("bowling").child("O").value!!.toString()
                                t1b3run = child.child("players").child("2").child("bowling").child("R").value!!.toString()
                                t1b3W = child.child("players").child("2").child("bowling").child("W").value!!.toString()

                                t1p4name = child.child("players").child("3").child("name").value!!.toString()
                                t1p4run = child.child("players").child("3").child("batting").child("R").value!!.toString()
                                t1p4balls = child.child("players").child("3").child("batting").child("B").value!!.toString()
                                t1p44s = child.child("players").child("3").child("batting").child("4s").value!!.toString()
                                t1p46s = child.child("players").child("3").child("batting").child("6s").value!!.toString()
                                t1b4M = child.child("players").child("3").child("bowling").child("M").value!!.toString()
                                t1b4over = child.child("players").child("3").child("bowling").child("O").value!!.toString()
                                t1b4run = child.child("players").child("3").child("bowling").child("R").value!!.toString()
                                t1b4W = child.child("players").child("3").child("bowling").child("W").value!!.toString()

                                t1p5name = child.child("players").child("4").child("name").value!!.toString()
                                t1p5run = child.child("players").child("4").child("batting").child("R").value!!.toString()
                                t1p5balls = child.child("players").child("4").child("batting").child("B").value!!.toString()
                                t1p54s = child.child("players").child("4").child("batting").child("4s").value!!.toString()
                                t1p56s = child.child("players").child("4").child("batting").child("6s").value!!.toString()
                                t1b5M = child.child("players").child("4").child("bowling").child("M").value!!.toString()
                                t1b5over = child.child("players").child("4").child("bowling").child("O").value!!.toString()
                                t1b5run = child.child("players").child("4").child("bowling").child("R").value!!.toString()
                                t1b5W = child.child("players").child("4").child("bowling").child("W").value!!.toString()

                                t1p6name = child.child("players").child("5").child("name").value!!.toString()
                                t1p6run = child.child("players").child("5").child("batting").child("R").value!!.toString()
                                t1p6balls = child.child("players").child("5").child("batting").child("B").value!!.toString()
                                t1p64s = child.child("players").child("5").child("batting").child("4s").value!!.toString()
                                t1p66s = child.child("players").child("5").child("batting").child("6s").value!!.toString()
                                t1b6M = child.child("players").child("5").child("bowling").child("M").value!!.toString()
                                t1b6over = child.child("players").child("5").child("bowling").child("O").value!!.toString()
                                t1b6run = child.child("players").child("5").child("bowling").child("R").value!!.toString()
                                t1b6W = child.child("players").child("5").child("bowling").child("W").value!!.toString()

                                t1p7name = child.child("players").child("6").child("name").value!!.toString()
                                t1p7run = child.child("players").child("6").child("batting").child("R").value!!.toString()
                                t1p7balls = child.child("players").child("6").child("batting").child("B").value!!.toString()
                                t1p74s = child.child("players").child("6").child("batting").child("4s").value!!.toString()
                                t1p76s = child.child("players").child("6").child("batting").child("6s").value!!.toString()
                                t1b7M = child.child("players").child("6").child("bowling").child("M").value!!.toString()
                                t1b7over = child.child("players").child("6").child("bowling").child("O").value!!.toString()
                                t1b7run = child.child("players").child("6").child("bowling").child("R").value!!.toString()
                                t1b7W = child.child("players").child("6").child("bowling").child("W").value!!.toString()

                                t1p8name = child.child("players").child("7").child("name").value!!.toString()
                                t1p8run = child.child("players").child("7").child("batting").child("R").value!!.toString()
                                t1p8balls = child.child("players").child("7").child("batting").child("B").value!!.toString()
                                t1p84s = child.child("players").child("7").child("batting").child("4s").value!!.toString()
                                t1p86s = child.child("players").child("7").child("batting").child("6s").value!!.toString()
                                t1b8M = child.child("players").child("7").child("bowling").child("M").value!!.toString()
                                t1b8over = child.child("players").child("7").child("bowling").child("O").value!!.toString()
                                t1b8run = child.child("players").child("7").child("bowling").child("R").value!!.toString()
                                t1b8W = child.child("players").child("7").child("bowling").child("W").value!!.toString()

                                t1p9name = child.child("players").child("8").child("name").value!!.toString()
                                t1p9run = child.child("players").child("8").child("batting").child("R").value!!.toString()
                                t1p9balls = child.child("players").child("8").child("batting").child("B").value!!.toString()
                                t1p94s = child.child("players").child("8").child("batting").child("4s").value!!.toString()
                                t1p96s = child.child("players").child("8").child("batting").child("6s").value!!.toString()
                                t1b9M = child.child("players").child("8").child("bowling").child("M").value!!.toString()
                                t1b9over = child.child("players").child("8").child("bowling").child("O").value!!.toString()
                                t1b9run = child.child("players").child("8").child("bowling").child("R").value!!.toString()
                                t1b9W = child.child("players").child("8").child("bowling").child("W").value!!.toString()

                                t1p10name = child.child("players").child("9").child("name").value!!.toString()
                                t1p10run = child.child("players").child("9").child("batting").child("R").value!!.toString()
                                t1p10balls = child.child("players").child("9").child("batting").child("B").value!!.toString()
                                t1p104s = child.child("players").child("9").child("batting").child("4s").value!!.toString()
                                t1p106s = child.child("players").child("9").child("batting").child("6s").value!!.toString()
                                t1b10M = child.child("players").child("9").child("bowling").child("M").value!!.toString()
                                t1b10over = child.child("players").child("9").child("bowling").child("O").value!!.toString()
                                t1b10run = child.child("players").child("9").child("bowling").child("R").value!!.toString()
                                t1b10W = child.child("players").child("9").child("bowling").child("W").value!!.toString()

                                t1p11name = child.child("players").child("10").child("name").value!!.toString()
                                t1p11run = child.child("players").child("10").child("batting").child("R").value!!.toString()
                                t1p11balls = child.child("players").child("10").child("batting").child("B").value!!.toString()
                                t1p114s = child.child("players").child("10").child("batting").child("4s").value!!.toString()
                                t1p116s = child.child("players").child("10").child("batting").child("6s").value!!.toString()
                                t1b11M = child.child("players").child("10").child("bowling").child("M").value!!.toString()
                                t1b11over = child.child("players").child("10").child("bowling").child("O").value!!.toString()
                                t1b11run = child.child("players").child("10").child("bowling").child("R").value!!.toString()
                                t1b11W = child.child("players").child("10").child("bowling").child("W").value!!.toString()

                                t1p12name = child.child("players").child("11").child("name").value!!.toString()
                                t1p12run = child.child("players").child("11").child("batting").child("R").value!!.toString()
                                t1p12balls = child.child("players").child("11").child("batting").child("B").value!!.toString()
                                t1p124s = child.child("players").child("11").child("batting").child("4s").value!!.toString()
                                t1p126s = child.child("players").child("11").child("batting").child("6s").value!!.toString()
                                t1b12M = child.child("players").child("11").child("bowling").child("M").value!!.toString()
                                t1b12over = child.child("players").child("11").child("bowling").child("O").value!!.toString()
                                t1b12run = child.child("players").child("11").child("bowling").child("R").value!!.toString()
                                t1b12W = child.child("players").child("11").child("bowling").child("W").value!!.toString()


                                Log.d("bharti", "Child t1 Value is: $t1over $t1name $t1run $t1viket")

                            } else if (child.key == "team2") {
                                t2over = child.child("over").value!!.toString()
                                t2name = child.child("name").value!!.toString()

                                t2run = child.child("run").value!!.toString()
                                t2viket = child.child("wicket").value!!.toString()


                                t2p1name = child.child("players").child("0").child("name").value!!.toString()
                                t2p1run = child.child("players").child("0").child("batting").child("R").value!!.toString()
                                t2p1balls = child.child("players").child("0").child("batting").child("B").value!!.toString()
                                t2p14s = child.child("players").child("0").child("batting").child("4s").value!!.toString()
                                t2p16s = child.child("players").child("0").child("batting").child("6s").value!!.toString()
                                t2b1M = child.child("players").child("0").child("bowling").child("M").value!!.toString()
                                t2b1over = child.child("players").child("0").child("bowling").child("O").value!!.toString()
                                t2b1run = child.child("players").child("0").child("bowling").child("R").value!!.toString()
                                t2b1W = child.child("players").child("0").child("bowling").child("W").value!!.toString()

                                t2p2name = child.child("players").child("1").child("name").value!!.toString()
                                t2p2run = child.child("players").child("1").child("batting").child("R").value!!.toString()
                                t2p2balls = child.child("players").child("1").child("batting").child("B").value!!.toString()
                                t2p24s = child.child("players").child("1").child("batting").child("4s").value!!.toString()
                                t2p26s = child.child("players").child("1").child("batting").child("6s").value!!.toString()
                                t2b2M = child.child("players").child("1").child("bowling").child("M").value!!.toString()
                                t2b2over = child.child("players").child("1").child("bowling").child("O").value!!.toString()
                                t2b2run = child.child("players").child("1").child("bowling").child("R").value!!.toString()
                                t2b2W = child.child("players").child("1").child("bowling").child("W").value!!.toString()

                                t2p3name = child.child("players").child("2").child("name").value!!.toString()
                                t2p3run = child.child("players").child("2").child("batting").child("R").value!!.toString()
                                t2p3balls = child.child("players").child("2").child("batting").child("B").value!!.toString()
                                t2p34s = child.child("players").child("2").child("batting").child("4s").value!!.toString()
                                t2p36s = child.child("players").child("2").child("batting").child("6s").value!!.toString()
                                t2b3M = child.child("players").child("2").child("bowling").child("M").value!!.toString()
                                t2b3over = child.child("players").child("2").child("bowling").child("O").value!!.toString()
                                t2b3run = child.child("players").child("2").child("bowling").child("R").value!!.toString()
                                t2b3W = child.child("players").child("2").child("bowling").child("W").value!!.toString()

                                t2p4name = child.child("players").child("3").child("name").value!!.toString()
                                t2p4run = child.child("players").child("3").child("batting").child("R").value!!.toString()
                                t2p4balls = child.child("players").child("3").child("batting").child("B").value!!.toString()
                                t2p44s = child.child("players").child("3").child("batting").child("4s").value!!.toString()
                                t2p46s = child.child("players").child("3").child("batting").child("6s").value!!.toString()
                                t2b4M = child.child("players").child("3").child("bowling").child("M").value!!.toString()
                                t2b4over = child.child("players").child("3").child("bowling").child("O").value!!.toString()
                                t2b4run = child.child("players").child("3").child("bowling").child("R").value!!.toString()
                                t2b4W = child.child("players").child("3").child("bowling").child("W").value!!.toString()

                                t2p5name = child.child("players").child("4").child("name").value!!.toString()
                                t2p5run = child.child("players").child("4").child("batting").child("R").value!!.toString()
                                t2p5balls = child.child("players").child("4").child("batting").child("B").value!!.toString()
                                t2p54s = child.child("players").child("4").child("batting").child("4s").value!!.toString()
                                t2p56s = child.child("players").child("4").child("batting").child("6s").value!!.toString()
                                t2b5M = child.child("players").child("4").child("bowling").child("M").value!!.toString()
                                t2b5over = child.child("players").child("4").child("bowling").child("O").value!!.toString()
                                t2b5run = child.child("players").child("4").child("bowling").child("R").value!!.toString()
                                t2b5W = child.child("players").child("4").child("bowling").child("W").value!!.toString()

                                t2p6name = child.child("players").child("5").child("name").value!!.toString()
                                t2p6run = child.child("players").child("5").child("batting").child("R").value!!.toString()
                                t2p6balls = child.child("players").child("5").child("batting").child("B").value!!.toString()
                                t2p64s = child.child("players").child("5").child("batting").child("4s").value!!.toString()
                                t2p66s = child.child("players").child("5").child("batting").child("6s").value!!.toString()
                                t2b6M = child.child("players").child("5").child("bowling").child("M").value!!.toString()
                                t2b6over = child.child("players").child("5").child("bowling").child("O").value!!.toString()
                                t2b6run = child.child("players").child("5").child("bowling").child("R").value!!.toString()
                                t2b6W = child.child("players").child("5").child("bowling").child("W").value!!.toString()

                                t2p7name = child.child("players").child("6").child("name").value!!.toString()
                                t2p7run = child.child("players").child("6").child("batting").child("R").value!!.toString()
                                t2p7balls = child.child("players").child("6").child("batting").child("B").value!!.toString()
                                t2p74s = child.child("players").child("6").child("batting").child("4s").value!!.toString()
                                t2p76s = child.child("players").child("6").child("batting").child("6s").value!!.toString()
                                t2b7M = child.child("players").child("6").child("bowling").child("M").value!!.toString()
                                t2b7over = child.child("players").child("6").child("bowling").child("O").value!!.toString()
                                t2b7run = child.child("players").child("6").child("bowling").child("R").value!!.toString()
                                t2b7W = child.child("players").child("6").child("bowling").child("W").value!!.toString()

                                t2p8name = child.child("players").child("7").child("name").value!!.toString()
                                t2p8run = child.child("players").child("7").child("batting").child("R").value!!.toString()
                                t2p8balls = child.child("players").child("7").child("batting").child("B").value!!.toString()
                                t2p84s = child.child("players").child("7").child("batting").child("4s").value!!.toString()
                                t2p86s = child.child("players").child("7").child("batting").child("6s").value!!.toString()
                                t2b8M = child.child("players").child("7").child("bowling").child("M").value!!.toString()
                                t2b8over = child.child("players").child("7").child("bowling").child("O").value!!.toString()
                                t2b8run = child.child("players").child("7").child("bowling").child("R").value!!.toString()
                                t2b8W = child.child("players").child("7").child("bowling").child("W").value!!.toString()

                                t2p9name = child.child("players").child("8").child("name").value!!.toString()
                                t2p9run = child.child("players").child("8").child("batting").child("R").value!!.toString()
                                t2p9balls = child.child("players").child("8").child("batting").child("B").value!!.toString()
                                t2p94s = child.child("players").child("8").child("batting").child("4s").value!!.toString()
                                t2p96s = child.child("players").child("8").child("batting").child("6s").value!!.toString()
                                t2b9M = child.child("players").child("8").child("bowling").child("M").value!!.toString()
                                t2b9over = child.child("players").child("8").child("bowling").child("O").value!!.toString()
                                t2b9run = child.child("players").child("8").child("bowling").child("R").value!!.toString()
                                t2b9W = child.child("players").child("8").child("bowling").child("W").value!!.toString()

                                t2p10name = child.child("players").child("9").child("name").value!!.toString()
                                t2p10run = child.child("players").child("9").child("batting").child("R").value!!.toString()
                                t2p10balls = child.child("players").child("9").child("batting").child("B").value!!.toString()
                                t2p104s = child.child("players").child("9").child("batting").child("4s").value!!.toString()
                                t2p106s = child.child("players").child("9").child("batting").child("6s").value!!.toString()
                                t2b10M = child.child("players").child("9").child("bowling").child("M").value!!.toString()
                                t2b10over = child.child("players").child("9").child("bowling").child("O").value!!.toString()
                                t2b10run = child.child("players").child("9").child("bowling").child("R").value!!.toString()
                                t2b10W = child.child("players").child("9").child("bowling").child("W").value!!.toString()

                                t2p11name = child.child("players").child("10").child("name").value!!.toString()
                                t2p11run = child.child("players").child("10").child("batting").child("R").value!!.toString()
                                t2p11balls = child.child("players").child("10").child("batting").child("B").value!!.toString()
                                t2p114s = child.child("players").child("10").child("batting").child("4s").value!!.toString()
                                t2p116s = child.child("players").child("10").child("batting").child("6s").value!!.toString()
                                t2b11M = child.child("players").child("10").child("bowling").child("M").value!!.toString()
                                t2b11over = child.child("players").child("10").child("bowling").child("O").value!!.toString()
                                t2b11run = child.child("players").child("10").child("bowling").child("R").value!!.toString()
                                t2b11W = child.child("players").child("10").child("bowling").child("W").value!!.toString()

                                t2p12name = child.child("players").child("11").child("name").value!!.toString()
                                t2p12run = child.child("players").child("11").child("batting").child("R").value!!.toString()
                                t2p12balls = child.child("players").child("11").child("batting").child("B").value!!.toString()
                                t2p124s = child.child("players").child("11").child("batting").child("4s").value!!.toString()
                                t2p126s = child.child("players").child("11").child("batting").child("6s").value!!.toString()
                                t2b12M = child.child("players").child("11").child("bowling").child("M").value!!.toString()
                                t2b12over = child.child("players").child("11").child("bowling").child("O").value!!.toString()
                                t2b12run = child.child("players").child("11").child("bowling").child("R").value!!.toString()
                                t2b12W = child.child("players").child("11").child("bowling").child("W").value!!.toString()

                                Log.d("bharti", "Child t2 Value is: $t2over $t2name $t2run $t2viket")

                            }


                            // }
                        }
                    }

                    if(batsmanStrike.equals("Player1")){
                        player1_check.isChecked=true
                    }else if(batsmanStrike.equals("Player2")){
                        player2_check.isChecked=true
                    }
                    /*else if(batsmanStrike.equals("")){
                        player2_check.isChecked=false
                        player1_check.isChecked=false
                    }
*/
                    if(bowlerStrike.equals("Bowler1")){
                        bowler1_check.isChecked=true
                    }else if(bowlerStrike.equals("Bowler2")){
                        bowler2_check.isChecked=true
                    }
                   /* else if(bowlerStrike.equals("")){
                        bowler1_check.isChecked=false
                        bowler2_check.isChecked=false
                    }*/
                    if(choosebattingteam.equals(t1name)){
                        if(batsman1.equals(t1p1name)){
                            player1_check.setText(t1p1name)
                        }
                       else if(batsman1.equals(t1p2name)){
                            player1_check.setText(t1p2name)
                        }
                        else if(batsman1.equals(t1p3name)){
                            player1_check.setText(t1p3name)
                        }
                        else if(batsman1.equals(t1p4name)){
                            player1_check.setText(t1p4name)
                        }
                        else if(batsman1.equals(t1p5name)){
                            player1_check.setText(t1p5name)
                        }
                        else if(batsman1.equals(t1p6name)){
                            player1_check.setText(t1p6name)
                        }
                        else if(batsman1.equals(t1p7name)){
                            player1_check.setText(t1p7name)
                        }
                        else if(batsman1.equals(t1p8name)){
                            player1_check.setText(t1p8name)
                        }
                        else if(batsman1.equals(t1p9name)){
                            player1_check.setText(t1p9name)
                        }
                        else if(batsman1.equals(t1p10name)){
                            player1_check.setText(t1p10name)
                        }
                        else if(batsman1.equals(t1p11name)){
                            player1_check.setText(t1p11name)
                        }
                        else if(batsman1.equals(t1p12name)){
                            player1_check.setText(t1p12name)
                        }

                        if(batsman2.equals(t1p1name)){
                            player2_check.setText(t1p1name)
                        }
                        else if(batsman2.equals(t1p2name)){
                            player2_check.setText(t1p2name)
                        }
                        else if(batsman2.equals(t1p3name)){
                            player2_check.setText(t1p3name)
                        }
                        else if(batsman2.equals(t1p4name)){
                            player2_check.setText(t1p4name)
                        }
                        else if(batsman2.equals(t1p5name)){
                            player2_check.setText(t1p5name)
                        }
                        else if(batsman2.equals(t1p6name)){
                            player2_check.setText(t1p6name)
                        }
                        else if(batsman2.equals(t1p7name)){
                            player2_check.setText(t1p7name)
                        }
                        else if(batsman2.equals(t1p8name)){
                            player2_check.setText(t1p8name)
                        }
                        else if(batsman2.equals(t1p9name)){
                            player2_check.setText(t1p9name)
                        }
                        else if(batsman2.equals(t1p10name)){
                            player2_check.setText(t1p10name)
                        }
                        else if(batsman2.equals(t1p11name)){
                            player2_check.setText(t1p11name)
                        }
                        else if(batsman2.equals(t1p12name)){
                            player2_check.setText(t1p12name)
                        }

                    }else{
                        if(bowler1.equals(t1p1name)){
                            bowler1_check.setText(t1p1name)
                        }
                        else if(bowler1.equals(t1p2name)){
                            bowler1_check.setText(t1p2name)
                        }
                        else if(bowler1.equals(t1p3name)){
                            bowler1_check.setText(t1p3name)
                        }
                        else if(bowler1.equals(t1p4name)){
                            bowler1_check.setText(t1p4name)
                        }
                        else if(bowler1.equals(t1p5name)){
                            bowler1_check.setText(t1p5name)
                        }
                        else if(bowler1.equals(t1p6name)){
                            bowler1_check.setText(t1p6name)
                        }
                        else if(bowler1.equals(t1p7name)){
                            bowler1_check.setText(t1p7name)
                        }
                        else if(bowler1.equals(t1p8name)){
                            bowler1_check.setText(t1p8name)
                        }
                        else if(bowler1.equals(t1p9name)){
                            bowler1_check.setText(t1p9name)
                        }
                        else if(bowler1.equals(t1p10name)){
                            bowler1_check.setText(t1p10name)
                        }
                        else if(bowler1.equals(t1p11name)){
                            bowler1_check.setText(t1p11name)
                        }
                        else if(bowler1.equals(t1p12name)){
                            bowler1_check.setText(t1p12name)
                        }

                        if(bowler2.equals(t1p1name)){
                            bowler2_check.setText(t1p1name)
                        }
                        else if(bowler2.equals(t1p2name)){
                            bowler2_check.setText(t1p2name)
                        }
                        else if(bowler2.equals(t1p3name)){
                            bowler2_check.setText(t1p3name)
                        }
                        else if(bowler2.equals(t1p4name)){
                            bowler2_check.setText(t1p4name)
                        }
                        else if(bowler2.equals(t1p5name)){
                            bowler2_check.setText(t1p5name)
                        }
                        else if(bowler2.equals(t1p6name)){
                            bowler2_check.setText(t1p6name)
                        }
                        else if(bowler2.equals(t1p7name)){
                            bowler2_check.setText(t1p7name)
                        }
                        else if(bowler2.equals(t1p8name)){
                            bowler2_check.setText(t1p8name)
                        }
                        else if(bowler2.equals(t1p9name)){
                            bowler2_check.setText(t1p9name)
                        }
                        else if(bowler2.equals(t1p10name)){
                            bowler2_check.setText(t1p10name)
                        }
                        else if(bowler2.equals(t1p11name)){
                            bowler2_check.setText(t1p11name)
                        }
                        else if(bowler2.equals(t1p12name)){
                            bowler2_check.setText(t1p12name)
                        }
                    }

                    if(choosebattingteam.equals(t2name)){
                        if(batsman1.equals(t2p1name)){
                            player1_check.setText(t2p1name)
                        }
                        else if(batsman1.equals(t2p2name)){
                            player1_check.setText(t2p2name)
                        }
                        else if(batsman1.equals(t2p3name)){
                            player1_check.setText(t2p3name)
                        }
                        else if(batsman1.equals(t2p4name)){
                            player1_check.setText(t2p4name)
                        }
                        else if(batsman1.equals(t2p5name)){
                            player1_check.setText(t2p5name)
                        }
                        else if(batsman1.equals(t2p6name)){
                            player1_check.setText(t2p6name)
                        }
                        else if(batsman1.equals(t2p7name)){
                            player1_check.setText(t2p7name)
                        }
                        else if(batsman1.equals(t2p8name)){
                            player1_check.setText(t2p8name)
                        }
                        else if(batsman1.equals(t2p9name)){
                            player1_check.setText(t2p9name)
                        }
                        else if(batsman1.equals(t2p10name)){
                            player1_check.setText(t2p10name)
                        }
                        else if(batsman1.equals(t2p11name)){
                            player1_check.setText(t2p11name)
                        }
                        else if(batsman1.equals(t2p12name)){
                            player1_check.setText(t2p12name)
                        }

                        if(batsman2.equals(t2p1name)){
                            player2_check.setText(t2p1name)
                        }
                        else if(batsman2.equals(t2p2name)){
                            player2_check.setText(t2p2name)
                        }
                        else if(batsman2.equals(t2p3name)){
                            player2_check.setText(t2p3name)
                        }
                        else if(batsman2.equals(t2p4name)){
                            player2_check.setText(t2p4name)
                        }
                        else if(batsman2.equals(t2p5name)){
                            player2_check.setText(t2p5name)
                        }
                        else if(batsman2.equals(t2p6name)){
                            player2_check.setText(t2p6name)
                        }
                        else if(batsman2.equals(t2p7name)){
                            player2_check.setText(t2p7name)
                        }
                        else if(batsman2.equals(t2p8name)){
                            player2_check.setText(t2p8name)
                        }
                        else if(batsman2.equals(t2p9name)){
                            player2_check.setText(t2p9name)
                        }
                        else if(batsman2.equals(t2p10name)){
                            player2_check.setText(t2p10name)
                        }
                        else if(batsman2.equals(t2p11name)){
                            player2_check.setText(t2p11name)
                        }
                        else if(batsman2.equals(t2p12name)){
                            player2_check.setText(t2p12name)
                        }

                    }else{
                        if(bowler1.equals(t2p1name)){
                            bowler1_check.setText(t2p1name)
                        }
                        else if(bowler1.equals(t2p2name)){
                            bowler1_check.setText(t2p2name)
                        }
                        else if(bowler1.equals(t2p3name)){
                            bowler1_check.setText(t2p3name)
                        }
                        else if(bowler1.equals(t2p4name)){
                            bowler1_check.setText(t2p4name)
                        }
                        else if(bowler1.equals(t2p5name)){
                            bowler1_check.setText(t2p5name)
                        }
                        else if(bowler1.equals(t2p6name)){
                            bowler1_check.setText(t2p6name)
                        }
                        else if(bowler1.equals(t2p7name)){
                            bowler1_check.setText(t2p7name)
                        }
                        else if(bowler1.equals(t2p8name)){
                            bowler1_check.setText(t2p8name)
                        }
                        else if(bowler1.equals(t2p9name)){
                            bowler1_check.setText(t2p9name)
                        }
                        else if(bowler1.equals(t2p10name)){
                            bowler1_check.setText(t2p10name)
                        }
                        else if(bowler1.equals(t2p11name)){
                            bowler1_check.setText(t2p11name)
                        }
                        else if(bowler1.equals(t2p12name)){
                            bowler1_check.setText(t2p12name)
                        }

                        if(bowler2.equals(t2p1name)){
                            bowler2_check.setText(t2p1name)
                        }
                        else if(bowler2.equals(t2p2name)){
                            bowler2_check.setText(t2p2name)
                        }
                        else if(bowler2.equals(t2p3name)){
                            bowler2_check.setText(t2p3name)
                        }
                        else if(bowler2.equals(t2p4name)){
                            bowler2_check.setText(t2p4name)
                        }
                        else if(bowler2.equals(t2p5name)){
                            bowler2_check.setText(t2p5name)
                        }
                        else if(bowler2.equals(t2p6name)){
                            bowler2_check.setText(t2p6name)
                        }
                        else if(bowler2.equals(t2p7name)){
                            bowler2_check.setText(t2p7name)
                        }
                        else if(bowler2.equals(t2p8name)){
                            bowler2_check.setText(t2p8name)
                        }
                        else if(bowler2.equals(t2p9name)){
                            bowler2_check.setText(t2p9name)
                        }
                        else if(bowler2.equals(t2p10name)){
                            bowler2_check.setText(t2p10name)
                        }
                        else if(bowler2.equals(t2p11name)){
                            bowler2_check.setText(t2p11name)
                        }
                        else if(bowler2.equals(t2p12name)){
                            bowler2_check.setText(t2p12name)
                        }
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

    fun overCalculate(numberOfBalls: Int): Double {
       // val numberOfBalls = 34
        val round = Math.round((numberOfBalls / 6).toFloat()).toString()
        val mod = (numberOfBalls % 6).toString()
        val numberOfOvers = java.lang.Double.valueOf("$round.$mod")
        println(numberOfOvers)
        return numberOfOvers
    }

    fun countRun(runNumber:Int,countballs:Int,countfourandSix:Int){
        ballsremaining=(remainingballs.toInt()-1).toString()
        /*bowler1over= (bowler1CountBalls.toInt()+countballs).toString()
        bowler2over= (bowler1CountBalls.toInt()+countballs).toString()
*/

        countball= Integer.parseInt(ballsremaining)
        if(matchType.equals("T20")){
            minuscountballs=120-countball
        }
        else if(matchType.equals("ODI")){
            minuscountballs=300-countball
        }

        countover=overCalculate(minuscountballs)
        team1run=(t1run.toInt()+runNumber).toString()
        team2run=(t2run.toInt()+runNumber).toString()

        /*countover=
                java.lang.Double.valueOf(Math.round(java.lang.Double.valueOf(java.lang.Double.parseDouble(t1run) / (balls as Double / 6.0)).toDouble() * 100.0).toDouble() / 100.0)
                    .toFloat()*/


        if(player1_check.isChecked && bowler1_check.isChecked ){
            /* prun= (b1run.toInt()+runNumber).toString()
             pball= (b1ball.toInt()+runNumber).toString()*/
            /* bowlerover= (bowler1over.toInt()+countballs).toString()
             bowlerrun= (bowler1run.toInt()+runNumber).toString()*/

            if(player1_check.text.toString().equals(t1p1name)){
                prun= (t1p1run.toInt()+runNumber).toString()
                pball= (t1p1balls.toInt()+countballs).toString()





                myRef.child(matchid).child("team1").child("players").child("0").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team1").child("players").child("0").child("batting").child("B").setValue(pball)
                count4And6(countfourandSix,t1p14s,t1p16s,"0","team1")

            }
            else if(player1_check.text.toString().equals(t1p2name)){
                prun= (t1p2run.toInt()+runNumber).toString()
                pball= (t1p2balls.toInt()+countballs).toString()

                myRef.child(matchid).child("team1").child("players").child("1").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team1").child("players").child("1").child("batting").child("B").setValue(pball)
                count4And6(countfourandSix,t1p24s,t1p26s,"1","team1")


            }
            else if(player1_check.text.toString().equals(t1p3name)){
                prun= (t1p3run.toInt()+runNumber).toString()
                pball= (t1p3balls.toInt()+countballs).toString()

                myRef.child(matchid).child("team1").child("players").child("2").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team1").child("players").child("2").child("batting").child("B").setValue(pball)
                count4And6(countfourandSix,t1p34s,t1p36s,"2","team1")

            }

            else if(player1_check.text.toString().equals(t1p4name)){
                prun= (t1p4run.toInt()+runNumber).toString()
                pball= (t1p4balls.toInt()+countballs).toString()

                myRef.child(matchid).child("team1").child("players").child("3").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team1").child("players").child("3").child("batting").child("B").setValue(pball)
                count4And6(countfourandSix,t1p44s,t1p46s,"3","team1")


            }
            else if(player1_check.text.toString().equals(t1p5name)){
                prun= (t1p5run.toInt()+runNumber).toString()
                pball= (t1p5balls.toInt()+countballs).toString()

                myRef.child(matchid).child("team1").child("players").child("4").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team1").child("players").child("4").child("batting").child("B").setValue(pball)
                count4And6(countfourandSix,t1p54s,t1p56s,"4","team1")

            }
            else if(player1_check.text.toString().equals(t1p6name)){
                prun= (t1p6run.toInt()+runNumber).toString()
                pball= (t1p6balls.toInt()+countballs).toString()

                myRef.child(matchid).child("team1").child("players").child("5").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team1").child("players").child("5").child("batting").child("B").setValue(pball)
                count4And6(countfourandSix,t1p64s,t1p66s,"5","team1")

            }
            else if(player1_check.text.toString().equals(t1p7name)){
                prun= (t1p7run.toInt()+runNumber).toString()
                pball= (t1p7balls.toInt()+countballs).toString()

                myRef.child(matchid).child("team1").child("players").child("6").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team1").child("players").child("6").child("batting").child("B").setValue(pball)
                count4And6(countfourandSix,t1p74s,t1p76s,"6","team1")

            }
            else if(player1_check.text.toString().equals(t1p8name)){
                prun= (t1p8run.toInt()+runNumber).toString()
                pball= (t1p8balls.toInt()+countballs).toString()

                myRef.child(matchid).child("team1").child("players").child("7").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team1").child("players").child("7").child("batting").child("B").setValue(pball)
                count4And6(countfourandSix,t1p84s,t1p86s,"7","team1")

            }
            else if(player1_check.text.toString().equals(t1p9name)){
                prun= (t1p9run.toInt()+runNumber).toString()
                pball= (t1p9balls.toInt()+countballs).toString()

                myRef.child(matchid).child("team1").child("players").child("8").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team1").child("players").child("8").child("batting").child("B").setValue(pball)
                count4And6(countfourandSix,t1p94s,t1p96s,"8","team1")

            }
            else if(player1_check.text.toString().equals(t1p10name)){
                prun= (t1p10run.toInt()+runNumber).toString()
                pball= (t1p10balls.toInt()+countballs).toString()

                myRef.child(matchid).child("team1").child("players").child("9").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team1").child("players").child("9").child("batting").child("B").setValue(pball)
                count4And6(countfourandSix,t1p104s,t1p106s,"9","team1")

            }
            else if(player1_check.text.toString().equals(t1p11name)){
                prun= (t1p11run.toInt()+runNumber).toString()
                pball= (t1p11balls.toInt()+countballs).toString()

                myRef.child(matchid).child("team1").child("players").child("10").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team1").child("players").child("10").child("batting").child("B").setValue(pball)
                count4And6(countfourandSix,t1p114s,t1p116s,"10","team1")

            }
            else if(player1_check.text.toString().equals(t1p12name)){
                prun= (t1p12run.toInt()+runNumber).toString()
                pball= (t1p12balls.toInt()+countballs).toString()

                myRef.child(matchid).child("team1").child("players").child("11").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team1").child("players").child("11").child("batting").child("B").setValue(pball)
                count4And6(countfourandSix,t1p124s,t1p126s,"11","team1")

            }

            if(player1_check.text.toString().equals(t2p1name)){
                prun= (t2p1run.toInt()+runNumber).toString()
                pball= (t2p1balls.toInt()+countballs).toString()

                myRef.child(matchid).child("team2").child("players").child("0").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team2").child("players").child("0").child("batting").child("B").setValue(pball)
                count4And6(countfourandSix,t2p14s,t2p16s,"0","team2")

            }
            else if(player1_check.text.toString().equals(t2p2name)){
                prun= (t2p2run.toInt()+runNumber).toString()
                pball= (t2p2balls.toInt()+countballs).toString()

                myRef.child(matchid).child("team2").child("players").child("1").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team2").child("players").child("1").child("batting").child("B").setValue(pball)
                count4And6(countfourandSix,t2p24s,t2p26s,"1","team2")

            }
            else if(player1_check.text.toString().equals(t2p3name)){
                prun= (t2p3run.toInt()+runNumber).toString()
                pball= (t2p3balls.toInt()+countballs).toString()

                myRef.child(matchid).child("team2").child("players").child("2").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team2").child("players").child("2").child("batting").child("B").setValue(pball)
                count4And6(countfourandSix,t2p34s,t2p36s,"2","team2")

            }
            else if(player1_check.text.toString().equals(t2p4name)){
                prun= (t2p4run.toInt()+runNumber).toString()
                pball= (t2p4balls.toInt()+countballs).toString()

                myRef.child(matchid).child("team2").child("players").child("3").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team2").child("players").child("3").child("batting").child("B").setValue(pball)
                count4And6(countfourandSix,t2p44s,t2p46s,"3","team2")

            }
            else if(player1_check.text.toString().equals(t2p5name)){
                prun= (t2p5run.toInt()+runNumber).toString()
                pball= (t2p5balls.toInt()+countballs).toString()

                myRef.child(matchid).child("team2").child("players").child("4").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team2").child("players").child("4").child("batting").child("B").setValue(pball)
                count4And6(countfourandSix,t2p54s,t2p56s,"4","team2")

            }
            else if(player1_check.text.toString().equals(t2p6name)){
                prun= (t2p6run.toInt()+runNumber).toString()
                pball= (t2p6balls.toInt()+countballs).toString()

                myRef.child(matchid).child("team2").child("players").child("5").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team2").child("players").child("5").child("batting").child("B").setValue(pball)
                count4And6(countfourandSix,t2p64s,t2p66s,"5","team2")

            }
            else if(player1_check.text.toString().equals(t2p7name)){
                prun= (t2p7run.toInt()+runNumber).toString()
                pball= (t2p7balls.toInt()+countballs).toString()

                myRef.child(matchid).child("team2").child("players").child("6").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team2").child("players").child("6").child("batting").child("B").setValue(pball)
                count4And6(countfourandSix,t2p74s,t2p76s,"6","team2")

            }
            else if(player1_check.text.toString().equals(t2p8name)){
                prun= (t2p8run.toInt()+runNumber).toString()
                pball= (t2p8balls.toInt()+countballs).toString()

                myRef.child(matchid).child("team2").child("players").child("7").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team2").child("players").child("7").child("batting").child("B").setValue(pball)
                count4And6(countfourandSix,t2p84s,t2p86s,"7","team2")

            }
            else if(player1_check.text.toString().equals(t2p9name)){
                prun= (t2p9run.toInt()+runNumber).toString()
                pball= (t2p9balls.toInt()+countballs).toString()

                myRef.child(matchid).child("team2").child("players").child("8").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team2").child("players").child("8").child("batting").child("B").setValue(pball)
                count4And6(countfourandSix,t2p94s,t2p96s,"8","team2")

            }
            else if(player1_check.text.toString().equals(t2p10name)){
                prun= (t2p10run.toInt()+runNumber).toString()
                pball= (t2p10balls.toInt()+countballs).toString()

                myRef.child(matchid).child("team2").child("players").child("9").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team2").child("players").child("9").child("batting").child("B").setValue(pball)
                count4And6(countfourandSix,t2p104s,t2p106s,"9","team2")

            }
            else if(player1_check.text.toString().equals(t2p11name)){
                prun= (t2p11run.toInt()+runNumber).toString()
                pball= (t2p11balls.toInt()+countballs).toString()

                myRef.child(matchid).child("team2").child("players").child("10").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team2").child("players").child("10").child("batting").child("B").setValue(pball)
                count4And6(countfourandSix,t2p114s,t2p116s,"10","team2")

            }
            else if(player1_check.text.toString().equals(t2p12name)){
                prun= (t2p12run.toInt()+runNumber).toString()
                pball= (t2p12balls.toInt()+countballs).toString()

                myRef.child(matchid).child("team2").child("players").child("11").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team2").child("players").child("11").child("batting").child("B").setValue(pball)

                count4And6(countfourandSix,t2p124s,t2p126s,"11","team2")

            }

            if(bowler1_check.text.toString().equals(t1p1name)){

                bowler1over= (bowler1CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler1CountBalls").setValue(bowler1over)

                bcountover=overCalculate(bowler1over.toInt())

                bowlerrun= (t1b1run.toInt()+runNumber).toString()

                myRef.child(matchid).child("team1").child("players").child("0").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team1").child("players").child("0").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler1_check.text.toString().equals(t1p2name)){
                bowler1over= (bowler1CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler1CountBalls").setValue(bowler1over)

                bcountover=overCalculate(bowler1over.toInt())
                bowlerrun= (t1b2run.toInt()+runNumber).toString()

                myRef.child(matchid).child("team1").child("players").child("1").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team1").child("players").child("1").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler1_check.text.toString().equals(t1p3name)){
                bowler1over= (bowler1CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler1CountBalls").setValue(bowler1over)

                bcountover=overCalculate(bowler1over.toInt())
                bowlerrun= (t1b3run.toInt()+runNumber).toString()

                myRef.child(matchid).child("team1").child("players").child("2").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team1").child("players").child("2").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler1_check.text.toString().equals(t1p4name)){
                bowler1over= (bowler1CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler1CountBalls").setValue(bowler1over)

                bcountover=overCalculate(bowler1over.toInt())
                bowlerrun= (t1b4run.toInt()+runNumber).toString()

                myRef.child(matchid).child("team1").child("players").child("3").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team1").child("players").child("3").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler1_check.text.toString().equals(t1p5name)){
                bowler1over= (bowler1CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler1CountBalls").setValue(bowler1over)

                bcountover=overCalculate(bowler1over.toInt())
                bowlerrun= (t1b5run.toInt()+runNumber).toString()

                myRef.child(matchid).child("team1").child("players").child("4").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team1").child("players").child("4").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler1_check.text.toString().equals(t1p6name)){
                bowler1over= (bowler1CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler1CountBalls").setValue(bowler1over)

                bcountover=overCalculate(bowler1over.toInt())
                bowlerrun= (t1b6run.toInt()+runNumber).toString()

                myRef.child(matchid).child("team1").child("players").child("5").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team1").child("players").child("5").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler1_check.text.toString().equals(t1p7name)){
                bowler1over= (bowler1CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler1CountBalls").setValue(bowler1over)

                bcountover=overCalculate(bowler1over.toInt())
                bowlerrun= (t1b7run.toInt()+runNumber).toString()

                myRef.child(matchid).child("team1").child("players").child("6").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team1").child("players").child("6").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler1_check.text.toString().equals(t1p8name)){
                bowler1over= (bowler1CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler1CountBalls").setValue(bowler1over)

                bcountover=overCalculate(bowler1over.toInt())
                bowlerrun= (t1b8run.toInt()+runNumber).toString()

                myRef.child(matchid).child("team1").child("players").child("7").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team1").child("players").child("7").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler1_check.text.toString().equals(t1p9name)){
                bowler1over= (bowler1CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler1CountBalls").setValue(bowler1over)

                bcountover=overCalculate(bowler1over.toInt())
                bowlerrun= (t1b9run.toInt()+runNumber).toString()

                myRef.child(matchid).child("team1").child("players").child("8").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team1").child("players").child("8").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler1_check.text.toString().equals(t1p10name)){
                bowler1over= (bowler1CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler1CountBalls").setValue(bowler1over)

                bcountover=overCalculate(bowler1over.toInt())
                bowlerrun= (t1b10run.toInt()+runNumber).toString()

                myRef.child(matchid).child("team1").child("players").child("9").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team1").child("players").child("9").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler1_check.text.toString().equals(t1p11name)){
                bowler1over= (bowler1CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler1CountBalls").setValue(bowler1over)

                bcountover=overCalculate(bowler1over.toInt())
                bowlerrun= (t1b11run.toInt()+runNumber).toString()

                myRef.child(matchid).child("team1").child("players").child("10").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team1").child("players").child("10").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler1_check.text.toString().equals(t1p12name)){
                bowler1over= (bowler1CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler1CountBalls").setValue(bowler1over)

                bcountover=overCalculate(bowler1over.toInt())
                bowlerrun= (t1b12run.toInt()+runNumber).toString()

                myRef.child(matchid).child("team1").child("players").child("11").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team1").child("players").child("11").child("bowling").child("O").setValue(bcountover)
            }

            if(bowler1_check.text.toString().equals(t2p1name)){
                bowler1over= (bowler1CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler1CountBalls").setValue(bowler1over)

                bcountover=overCalculate(bowler1over.toInt())
                bowlerrun= (t2b1run.toInt()+runNumber).toString()

                myRef.child(matchid).child("team2").child("players").child("0").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team2").child("players").child("0").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler1_check.text.toString().equals(t2p2name)){
                bowler1over= (bowler1CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler1CountBalls").setValue(bowler1over)

                bcountover=overCalculate(bowler1over.toInt())
                bowlerrun= (t2b2run.toInt()+runNumber).toString()

                myRef.child(matchid).child("team2").child("players").child("1").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team2").child("players").child("1").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler1_check.text.toString().equals(t2p3name)){
                bowler1over= (bowler1CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler1CountBalls").setValue(bowler1over)

                bcountover=overCalculate(bowler1over.toInt())
                bowlerrun= (t2b3run.toInt()+runNumber).toString()

                myRef.child(matchid).child("team2").child("players").child("2").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team2").child("players").child("2").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler1_check.text.toString().equals(t2p4name)){
                bowler1over= (bowler1CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler1CountBalls").setValue(bowler1over)

                bcountover=overCalculate(bowler1over.toInt())
                bowlerrun= (t2b4run.toInt()+runNumber).toString()

                myRef.child(matchid).child("team2").child("players").child("3").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team2").child("players").child("3").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler1_check.text.toString().equals(t2p5name)){
                bowler1over= (bowler1CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler1CountBalls").setValue(bowler1over)

                bcountover=overCalculate(bowler1over.toInt())
                bowlerrun= (t2b5run.toInt()+runNumber).toString()

                myRef.child(matchid).child("team2").child("players").child("4").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team2").child("players").child("4").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler1_check.text.toString().equals(t2p6name)){
                bowler1over= (bowler1CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler1CountBalls").setValue(bowler1over)

                bcountover=overCalculate(bowler1over.toInt())
                bowlerrun= (t2b6run.toInt()+runNumber).toString()

                myRef.child(matchid).child("team2").child("players").child("5").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team2").child("players").child("5").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler1_check.text.toString().equals(t2p7name)){
                bowler1over= (bowler1CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler1CountBalls").setValue(bowler1over)

                bcountover=overCalculate(bowler1over.toInt())
                bowlerrun= (t2b7run.toInt()+runNumber).toString()

                myRef.child(matchid).child("team2").child("players").child("6").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team2").child("players").child("6").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler1_check.text.toString().equals(t2p8name)){
                bowler1over= (bowler1CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler1CountBalls").setValue(bowler1over)

                bcountover=overCalculate(bowler1over.toInt())
                bowlerrun= (t2b8run.toInt()+runNumber).toString()

                myRef.child(matchid).child("team2").child("players").child("7").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team2").child("players").child("7").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler1_check.text.toString().equals(t2p9name)){
                bowler1over= (bowler1CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler1CountBalls").setValue(bowler1over)

                bcountover=overCalculate(bowler1over.toInt())
                bowlerrun= (t2b9run.toInt()+runNumber).toString()

                myRef.child(matchid).child("team2").child("players").child("8").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team2").child("players").child("8").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler1_check.text.toString().equals(t2p10name)){
                bowler1over= (bowler1CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler1CountBalls").setValue(bowler1over)

                bcountover=overCalculate(bowler1over.toInt())
                bowlerrun= (t2b10run.toInt()+runNumber).toString()

                myRef.child(matchid).child("team2").child("players").child("9").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team2").child("players").child("9").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler1_check.text.toString().equals(t2p11name)){
                bowler1over= (bowler1CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler1CountBalls").setValue(bowler1over)

                bcountover=overCalculate(bowler1over.toInt())
                bowlerrun= (t2b11run.toInt()+runNumber).toString()

                myRef.child(matchid).child("team2").child("players").child("10").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team2").child("players").child("10").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler1_check.text.toString().equals(t2p12name)){
                bowler1over= (bowler1CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler1CountBalls").setValue(bowler1over)

                bcountover=overCalculate(bowler1over.toInt())
                bowlerrun= (t2b12run.toInt()+runNumber).toString()

                myRef.child(matchid).child("team2").child("players").child("11").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team2").child("players").child("11").child("bowling").child("O").setValue(bcountover)
            }

            //countballs=(remainingballs.toInt()+countballs).toString()

            Log.d("bharti11", "Value b1 is: $prun")

            /*myRef.child(matchid).child("Batsman").child("b1").child("R").setValue(prun)
            myRef.child(matchid).child("Batsman").child("b1").child("B").setValue(pball)
            myRef.child(matchid).child("Bowling").child("bowler1").child("R").setValue(bowlerrun)
            myRef.child(matchid).child("Bowling").child("bowler1").child("O").setValue(bowlerover)
*/
           /* if(choosebattingteam.equals(t1name)){
                myRef.child(matchid).child("team1").child("run").setValue(team1run)
                myRef.child(matchid).child("team1").child("over").setValue(countover)

            }else{
                myRef.child(matchid).child("team2").child("run").setValue(team2run)
                myRef.child(matchid).child("team2").child("over").setValue(countover)

            }
*/
            Toast.makeText(this,"player1 run"+" "+prun,Toast.LENGTH_SHORT).show()

        }
        else if(player1_check.isChecked && bowler2_check.isChecked  ){
            /* prun= (b1run.toInt()+runNumber).toString()
             pball= (b1ball.toInt()+runNumber).toString()
             bowlerover= (bowler2over.toInt()+countballs).toString()
             bowlerrun= (bowler2run.toInt()+runNumber).toString()*/
           /* team1run=(t1run.toInt()+runNumber).toString()
            team2run=(t2run.toInt()+runNumber).toString()*/

            Log.d("bharti11", "Value b1 is: $prun")
            if(player1_check.text.toString().equals(t1p1name)){
                prun= (t1p1run.toInt()+runNumber).toString()
                pball= (t1p1balls.toInt()+countballs).toString()

                myRef.child(matchid).child("team1").child("players").child("0").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team1").child("players").child("0").child("batting").child("B").setValue(pball)
                count4And6(countfourandSix,t1p14s,t1p16s,"0","team1")

            }
            else if(player1_check.text.toString().equals(t1p2name)){
                prun= (t1p2run.toInt()+runNumber).toString()
                pball= (t1p2balls.toInt()+countballs).toString()

                myRef.child(matchid).child("team1").child("players").child("1").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team1").child("players").child("1").child("batting").child("B").setValue(pball)
                count4And6(countfourandSix,t1p24s,t1p26s,"1","team1")

            }
            else if(player1_check.text.toString().equals(t1p3name)){
                prun= (t1p3run.toInt()+runNumber).toString()
                pball= (t1p3balls.toInt()+countballs).toString()

                myRef.child(matchid).child("team1").child("players").child("2").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team1").child("players").child("2").child("batting").child("B").setValue(pball)
                count4And6(countfourandSix,t1p34s,t1p36s,"2","team1")

            }
            else if(player1_check.text.toString().equals(t1p4name)){
                prun= (t1p4run.toInt()+runNumber).toString()
                pball= (t1p4balls.toInt()+countballs).toString()

                myRef.child(matchid).child("team1").child("players").child("3").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team1").child("players").child("3").child("batting").child("B").setValue(pball)
                count4And6(countfourandSix,t1p44s,t1p46s,"3","team1")

            }
            else if(player1_check.text.toString().equals(t1p5name)){
                prun= (t1p5run.toInt()+runNumber).toString()
                pball= (t1p5balls.toInt()+countballs).toString()

                myRef.child(matchid).child("team1").child("players").child("4").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team1").child("players").child("4").child("batting").child("B").setValue(pball)
                count4And6(countfourandSix,t1p54s,t1p56s,"4","team1")

            }
            else if(player1_check.text.toString().equals(t1p6name)){
                prun= (t1p6run.toInt()+runNumber).toString()
                pball= (t1p6balls.toInt()+countballs).toString()

                myRef.child(matchid).child("team1").child("players").child("5").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team1").child("players").child("5").child("batting").child("B").setValue(pball)
                count4And6(countfourandSix,t1p64s,t1p66s,"5","team1")

            }
            else if(player1_check.text.toString().equals(t1p7name)){
                prun= (t1p7run.toInt()+runNumber).toString()
                pball= (t1p7balls.toInt()+countballs).toString()

                myRef.child(matchid).child("team1").child("players").child("6").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team1").child("players").child("6").child("batting").child("B").setValue(pball)
                count4And6(countfourandSix,t1p74s,t1p76s,"6","team1")

            }
            else if(player1_check.text.toString().equals(t1p8name)){
                prun= (t1p8run.toInt()+runNumber).toString()
                pball= (t1p8balls.toInt()+countballs).toString()

                myRef.child(matchid).child("team1").child("players").child("7").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team1").child("players").child("7").child("batting").child("B").setValue(pball)
                count4And6(countfourandSix,t1p84s,t1p86s,"7","team1")

            }
            else if(player1_check.text.toString().equals(t1p9name)){
                prun= (t1p9run.toInt()+runNumber).toString()
                pball= (t1p9balls.toInt()+countballs).toString()

                myRef.child(matchid).child("team1").child("players").child("8").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team1").child("players").child("8").child("batting").child("B").setValue(pball)
                count4And6(countfourandSix,t1p94s,t1p96s,"8","team1")

            }
            else if(player1_check.text.toString().equals(t1p10name)){
                prun= (t1p10run.toInt()+runNumber).toString()
                pball= (t1p10balls.toInt()+countballs).toString()

                myRef.child(matchid).child("team1").child("players").child("9").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team1").child("players").child("9").child("batting").child("B").setValue(pball)
                count4And6(countfourandSix,t1p104s,t1p106s,"9","team1")

            }
            else if(player1_check.text.toString().equals(t1p11name)){
                prun= (t1p11run.toInt()+runNumber).toString()
                pball= (t1p11balls.toInt()+countballs).toString()

                myRef.child(matchid).child("team1").child("players").child("10").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team1").child("players").child("10").child("batting").child("B").setValue(pball)
                count4And6(countfourandSix,t1p114s,t1p116s,"10","team1")

            }
            else if(player1_check.text.toString().equals(t1p12name)){
                prun= (t1p12run.toInt()+runNumber).toString()
                pball= (t1p12balls.toInt()+countballs).toString()

                myRef.child(matchid).child("team1").child("players").child("11").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team1").child("players").child("11").child("batting").child("B").setValue(pball)
                count4And6(countfourandSix,t1p124s,t1p126s,"11","team1")

            }

            if(player1_check.text.toString().equals(t2p1name)){
                prun= (t2p1run.toInt()+runNumber).toString()
                pball= (t2p1balls.toInt()+countballs).toString()

                myRef.child(matchid).child("team2").child("players").child("0").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team2").child("players").child("0").child("batting").child("B").setValue(pball)
                count4And6(countfourandSix,t2p14s,t2p16s,"0","team2")

            }
            else if(player1_check.text.toString().equals(t2p2name)){
                prun= (t2p2run.toInt()+runNumber).toString()
                pball= (t2p2balls.toInt()+countballs).toString()

                myRef.child(matchid).child("team2").child("players").child("1").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team2").child("players").child("1").child("batting").child("B").setValue(pball)
                count4And6(countfourandSix,t2p24s,t2p26s,"1","team2")

            }
            else if(player1_check.text.toString().equals(t2p3name)){
                prun= (t2p3run.toInt()+runNumber).toString()
                pball= (t2p3balls.toInt()+countballs).toString()

                myRef.child(matchid).child("team2").child("players").child("2").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team2").child("players").child("2").child("batting").child("B").setValue(pball)
                count4And6(countfourandSix,t2p34s,t2p36s,"2","team2")

            }
            else if(player1_check.text.toString().equals(t2p4name)){
                prun= (t2p4run.toInt()+runNumber).toString()
                pball= (t2p4balls.toInt()+countballs).toString()

                myRef.child(matchid).child("team2").child("players").child("3").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team2").child("players").child("3").child("batting").child("B").setValue(pball)
                count4And6(countfourandSix,t2p44s,t2p46s,"3","team2")

            }
            else if(player1_check.text.toString().equals(t2p5name)){
                prun= (t2p5run.toInt()+runNumber).toString()
                pball= (t2p5balls.toInt()+countballs).toString()

                myRef.child(matchid).child("team2").child("players").child("4").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team2").child("players").child("4").child("batting").child("B").setValue(pball)
                count4And6(countfourandSix,t2p54s,t2p56s,"4","team2")

            }
            else if(player1_check.text.toString().equals(t2p6name)){
                prun= (t2p6run.toInt()+runNumber).toString()
                pball= (t2p6balls.toInt()+countballs).toString()

                myRef.child(matchid).child("team2").child("players").child("5").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team2").child("players").child("5").child("batting").child("B").setValue(pball)

                count4And6(countfourandSix,t2p64s,t2p66s,"5","team2")

            }
            else if(player1_check.text.toString().equals(t2p7name)){
                prun= (t2p7run.toInt()+runNumber).toString()
                pball= (t2p7balls.toInt()+countballs).toString()

                myRef.child(matchid).child("team2").child("players").child("6").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team2").child("players").child("6").child("batting").child("B").setValue(pball)
                count4And6(countfourandSix,t2p74s,t2p76s,"6","team2")

            }
            else if(player1_check.text.toString().equals(t2p8name)){
                prun= (t2p8run.toInt()+runNumber).toString()
                pball= (t2p8balls.toInt()+countballs).toString()

                myRef.child(matchid).child("team2").child("players").child("7").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team2").child("players").child("7").child("batting").child("B").setValue(pball)
                count4And6(countfourandSix,t2p84s,t2p86s,"7","team2")

            }
            else if(player1_check.text.toString().equals(t2p9name)){
                prun= (t2p9run.toInt()+runNumber).toString()
                pball= (t2p9balls.toInt()+countballs).toString()

                myRef.child(matchid).child("team2").child("players").child("8").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team2").child("players").child("8").child("batting").child("B").setValue(pball)
                count4And6(countfourandSix,t2p94s,t2p96s,"8","team2")

            }
            else if(player1_check.text.toString().equals(t2p10name)){
                prun= (t2p10run.toInt()+runNumber).toString()
                pball= (t2p10balls.toInt()+countballs).toString()

                myRef.child(matchid).child("team2").child("players").child("9").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team2").child("players").child("9").child("batting").child("B").setValue(pball)
                count4And6(countfourandSix,t2p104s,t2p106s,"9","team2")

            }
            else if(player1_check.text.toString().equals(t2p11name)){
                prun= (t2p11run.toInt()+runNumber).toString()
                pball= (t2p11balls.toInt()+countballs).toString()

                myRef.child(matchid).child("team2").child("players").child("10").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team2").child("players").child("10").child("batting").child("B").setValue(pball)
                count4And6(countfourandSix,t2p114s,t2p116s,"10","team2")

            }
            else if(player1_check.text.toString().equals(t2p12name)){
                prun= (t2p12run.toInt()+runNumber).toString()
                pball= (t2p12balls.toInt()+countballs).toString()

                myRef.child(matchid).child("team2").child("players").child("11").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team2").child("players").child("11").child("batting").child("B").setValue(pball)
                count4And6(countfourandSix,t2p124s,t2p126s,"11","team2")

            }

            if(bowler2_check.text.toString().equals(t1p1name)){
                bowler2over= (bowler2CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler2CountBalls").setValue(bowler2over)

                bcountover=overCalculate(bowler2over.toInt())
                bowlerrun= (t1b1run.toInt()+runNumber).toString()

                myRef.child(matchid).child("team1").child("players").child("0").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team1").child("players").child("0").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler2_check.text.toString().equals(t1p2name)){
                bowler2over= (bowler2CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler2CountBalls").setValue(bowler2over)

                bcountover=overCalculate(bowler2over.toInt())
                bowlerrun= (t1b2run.toInt()+runNumber).toString()

                myRef.child(matchid).child("team1").child("players").child("1").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team1").child("players").child("1").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler2_check.text.toString().equals(t1p3name)){
                bowler2over= (bowler2CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler2CountBalls").setValue(bowler2over)

                bcountover=overCalculate(bowler2over.toInt())
                bowlerrun= (t1b3run.toInt()+runNumber).toString()

                myRef.child(matchid).child("team1").child("players").child("2").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team1").child("players").child("2").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler2_check.text.toString().equals(t1p4name)){
                bowler2over= (bowler2CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler2CountBalls").setValue(bowler2over)

                bcountover=overCalculate(bowler2over.toInt())
                bowlerrun= (t1b4run.toInt()+runNumber).toString()

                myRef.child(matchid).child("team1").child("players").child("3").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team1").child("players").child("3").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler2_check.text.toString().equals(t1p5name)){
                bowler2over= (bowler2CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler2CountBalls").setValue(bowler2over)

                bcountover=overCalculate(bowler2over.toInt())
                bowlerrun= (t1b5run.toInt()+runNumber).toString()

                myRef.child(matchid).child("team1").child("players").child("4").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team1").child("players").child("4").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler2_check.text.toString().equals(t1p6name)){
                bowler2over= (bowler2CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler2CountBalls").setValue(bowler2over)

                bcountover=overCalculate(bowler2over.toInt())
                bowlerrun= (t1b6run.toInt()+runNumber).toString()

                myRef.child(matchid).child("team1").child("players").child("5").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team1").child("players").child("5").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler2_check.text.toString().equals(t1p7name)){
                bowler2over= (bowler2CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler2CountBalls").setValue(bowler2over)

                bcountover=overCalculate(bowler2over.toInt())
                bowlerrun= (t1b7run.toInt()+runNumber).toString()

                myRef.child(matchid).child("team1").child("players").child("6").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team1").child("players").child("6").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler2_check.text.toString().equals(t1p8name)){
                bowler2over= (bowler2CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler2CountBalls").setValue(bowler2over)

                bcountover=overCalculate(bowler2over.toInt())
                bowlerrun= (t1b8run.toInt()+runNumber).toString()

                myRef.child(matchid).child("team1").child("players").child("7").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team1").child("players").child("7").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler2_check.text.toString().equals(t1p9name)){
                bowler2over= (bowler2CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler2CountBalls").setValue(bowler2over)

                bcountover=overCalculate(bowler2over.toInt())
                bowlerrun= (t1b9run.toInt()+runNumber).toString()

                myRef.child(matchid).child("team1").child("players").child("8").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team1").child("players").child("8").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler2_check.text.toString().equals(t1p10name)){
                bowler2over= (bowler2CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler2CountBalls").setValue(bowler2over)

                bcountover=overCalculate(bowler2over.toInt())
                bowlerrun= (t1b10run.toInt()+runNumber).toString()

                myRef.child(matchid).child("team1").child("players").child("9").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team1").child("players").child("9").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler2_check.text.toString().equals(t1p11name)){
                bowler2over= (bowler2CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler2CountBalls").setValue(bowler2over)

                bcountover=overCalculate(bowler2over.toInt())
                bowlerrun= (t1b11run.toInt()+runNumber).toString()

                myRef.child(matchid).child("team1").child("players").child("10").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team1").child("players").child("10").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler2_check.text.toString().equals(t1p12name)){
                bowler2over= (bowler2CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler2CountBalls").setValue(bowler2over)

                bcountover=overCalculate(bowler2over.toInt())
                bowlerrun= (t1b12run.toInt()+runNumber).toString()

                myRef.child(matchid).child("team1").child("players").child("11").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team1").child("players").child("11").child("bowling").child("O").setValue(bcountover)
            }

            if(bowler2_check.text.toString().equals(t2p1name)){
                bowler2over= (bowler2CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler2CountBalls").setValue(bowler2over)

                bcountover=overCalculate(bowler2over.toInt())
                bowlerrun= (t2b1run.toInt()+runNumber).toString()

                myRef.child(matchid).child("team2").child("players").child("0").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team2").child("players").child("0").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler2_check.text.toString().equals(t2p2name)){
                bowler2over= (bowler2CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler2CountBalls").setValue(bowler2over)

                bcountover=overCalculate(bowler2over.toInt())
                bowlerrun= (t2b2run.toInt()+runNumber).toString()

                myRef.child(matchid).child("team2").child("players").child("1").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team2").child("players").child("1").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler2_check.text.toString().equals(t2p3name)){
                bowler2over= (bowler2CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler2CountBalls").setValue(bowler2over)

                bcountover=overCalculate(bowler2over.toInt())
                bowlerrun= (t2b3run.toInt()+runNumber).toString()

                myRef.child(matchid).child("team2").child("players").child("2").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team2").child("players").child("2").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler2_check.text.toString().equals(t2p4name)){
                bowler2over= (bowler2CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler2CountBalls").setValue(bowler2over)

                bcountover=overCalculate(bowler2over.toInt())
                bowlerrun= (t2b4run.toInt()+runNumber).toString()

                myRef.child(matchid).child("team2").child("players").child("3").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team2").child("players").child("3").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler2_check.text.toString().equals(t2p5name)){
                bowler2over= (bowler2CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler2CountBalls").setValue(bowler2over)

                bcountover=overCalculate(bowler2over.toInt())
                bowlerrun= (t2b5run.toInt()+runNumber).toString()

                myRef.child(matchid).child("team2").child("players").child("4").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team2").child("players").child("4").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler2_check.text.toString().equals(t2p6name)){
                bowler2over= (bowler2CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler2CountBalls").setValue(bowler2over)

                bcountover=overCalculate(bowler2over.toInt())
                bowlerrun= (t2b6run.toInt()+runNumber).toString()

                myRef.child(matchid).child("team2").child("players").child("5").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team2").child("players").child("5").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler2_check.text.toString().equals(t2p7name)){
                bowler2over= (bowler2CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler2CountBalls").setValue(bowler2over)

                bcountover=overCalculate(bowler2over.toInt())
                bowlerrun= (t2b7run.toInt()+runNumber).toString()

                myRef.child(matchid).child("team2").child("players").child("6").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team2").child("players").child("6").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler2_check.text.toString().equals(t2p8name)){
                bowler2over= (bowler2CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler2CountBalls").setValue(bowler2over)

                bcountover=overCalculate(bowler2over.toInt())
                bowlerrun= (t2b8run.toInt()+runNumber).toString()

                myRef.child(matchid).child("team2").child("players").child("7").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team2").child("players").child("7").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler2_check.text.toString().equals(t2p9name)){
                bowler2over= (bowler2CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler2CountBalls").setValue(bowler2over)

                bcountover=overCalculate(bowler2over.toInt())
                bowlerrun= (t2b9run.toInt()+runNumber).toString()

                myRef.child(matchid).child("team2").child("players").child("8").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team2").child("players").child("8").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler2_check.text.toString().equals(t2p10name)){
                bowler2over= (bowler2CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler2CountBalls").setValue(bowler2over)

                bcountover=overCalculate(bowler2over.toInt())
                bowlerrun= (t2b10run.toInt()+runNumber).toString()

                myRef.child(matchid).child("team2").child("players").child("9").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team2").child("players").child("9").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler2_check.text.toString().equals(t2p11name)){
                bowler2over= (bowler2CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler2CountBalls").setValue(bowler2over)

                bcountover=overCalculate(bowler2over.toInt())
                bowlerrun= (t2b11run.toInt()+runNumber).toString()

                myRef.child(matchid).child("team2").child("players").child("10").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team2").child("players").child("10").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler2_check.text.toString().equals(t2p12name)){
                bowler2over= (bowler2CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler2CountBalls").setValue(bowler2over)

                bcountover=overCalculate(bowler2over.toInt())
                bowlerrun= (t2b12run.toInt()+runNumber).toString()

                myRef.child(matchid).child("team2").child("players").child("11").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team2").child("players").child("11").child("bowling").child("O").setValue(bcountover)
            }

            /*myRef.child(matchid).child("Batsman").child("b1").child("R").setValue(prun)
            myRef.child(matchid).child("Batsman").child("b1").child("B").setValue(pball)
            myRef.child(matchid).child("Bowling").child("bowler2").child("R").setValue(bowlerrun)
            myRef.child(matchid).child("Bowling").child("bowler2").child("O").setValue(bowlerover)
           */
            /*if(choosebattingteam.equals(t1name)){
                myRef.child(matchid).child("team1").child("run").setValue(team1run)
                myRef.child(matchid).child("team1").child("over").setValue(countover)


            }else{
                myRef.child(matchid).child("team2").child("run").setValue(team2run)
                myRef.child(matchid).child("team2").child("over").setValue(countover)

            }*/
            Toast.makeText(this,"player1 run"+" "+prun,Toast.LENGTH_SHORT).show()

        }
        else if(player2_check.isChecked && bowler1_check.isChecked){
            /*prun= (b2run.toInt()+runNumber).toString()
            pball= (b2ball.toInt()+runNumber).toString()
            bowlerover= (bowler1over.toInt()+countballs).toString()
            bowlerrun= (bowler1run.toInt()+runNumber).toString()*/
           /* team1run=(t1run.toInt()+runNumber).toString()
            team2run=(t2run.toInt()+runNumber).toString()*/

            Log.d("bharti11", "Value b2 is: $prun")

            if(player2_check.text.toString().equals(t1p1name)){
                prun= (t1p1run.toInt()+runNumber).toString()
                pball= (t1p1balls.toInt()+countballs).toString()

                myRef.child(matchid).child("team1").child("players").child("0").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team1").child("players").child("0").child("batting").child("B").setValue(pball)
                count4And6(countfourandSix,t1p14s,t1p16s,"0","team1")

            }
            else if(player2_check.text.toString().equals(t1p2name)){
                prun= (t1p2run.toInt()+runNumber).toString()
                pball= (t1p2balls.toInt()+countballs).toString()

                myRef.child(matchid).child("team1").child("players").child("1").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team1").child("players").child("1").child("batting").child("B").setValue(pball)
                count4And6(countfourandSix,t1p24s,t1p26s,"1","team1")

            }
            else if(player2_check.text.toString().equals(t1p3name)){
                prun= (t1p3run.toInt()+runNumber).toString()
                pball= (t1p3balls.toInt()+countballs).toString()

                myRef.child(matchid).child("team1").child("players").child("2").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team1").child("players").child("2").child("batting").child("B").setValue(pball)
                count4And6(countfourandSix,t1p34s,t1p36s,"2","team1")

            }
            else if(player2_check.text.toString().equals(t1p4name)){
                prun= (t1p4run.toInt()+runNumber).toString()
                pball= (t1p4balls.toInt()+countballs).toString()

                myRef.child(matchid).child("team1").child("players").child("3").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team1").child("players").child("3").child("batting").child("B").setValue(pball)
                count4And6(countfourandSix,t1p44s,t1p46s,"3","team1")

            }
            else if(player2_check.text.toString().equals(t1p5name)){
                prun= (t1p5run.toInt()+runNumber).toString()
                pball= (t1p5balls.toInt()+countballs).toString()

                myRef.child(matchid).child("team1").child("players").child("4").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team1").child("players").child("4").child("batting").child("B").setValue(pball)
                count4And6(countfourandSix,t1p54s,t1p56s,"4","team1")

            }
            else if(player2_check.text.toString().equals(t1p6name)){
                prun= (t1p6run.toInt()+runNumber).toString()
                pball= (t1p6balls.toInt()+countballs).toString()

                myRef.child(matchid).child("team1").child("players").child("5").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team1").child("players").child("5").child("batting").child("B").setValue(pball)
                count4And6(countfourandSix,t1p64s,t1p66s,"5","team1")

            }
            else if(player2_check.text.toString().equals(t1p7name)){
                prun= (t1p7run.toInt()+runNumber).toString()
                pball= (t1p7balls.toInt()+countballs).toString()

                myRef.child(matchid).child("team1").child("players").child("6").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team1").child("players").child("6").child("batting").child("B").setValue(pball)
                count4And6(countfourandSix,t1p74s,t1p76s,"6","team1")

            }
            else if(player2_check.text.toString().equals(t1p8name)){
                prun= (t1p8run.toInt()+runNumber).toString()
                pball= (t1p8balls.toInt()+countballs).toString()

                myRef.child(matchid).child("team1").child("players").child("7").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team1").child("players").child("7").child("batting").child("B").setValue(pball)
                count4And6(countfourandSix,t1p84s,t1p86s,"7","team1")

            }
            else if(player2_check.text.toString().equals(t1p9name)){
                prun= (t1p9run.toInt()+runNumber).toString()
                pball= (t1p9balls.toInt()+countballs).toString()

                myRef.child(matchid).child("team1").child("players").child("8").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team1").child("players").child("8").child("batting").child("B").setValue(pball)
                count4And6(countfourandSix,t1p94s,t1p96s,"8","team1")

            }
            else if(player2_check.text.toString().equals(t1p10name)){
                prun= (t1p10run.toInt()+runNumber).toString()
                pball= (t1p10balls.toInt()+countballs).toString()

                myRef.child(matchid).child("team1").child("players").child("9").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team1").child("players").child("9").child("batting").child("B").setValue(pball)
                count4And6(countfourandSix,t1p104s,t1p106s,"9","team1")

            }
            else if(player2_check.text.toString().equals(t1p11name)){
                prun= (t1p11run.toInt()+runNumber).toString()
                pball= (t1p11balls.toInt()+countballs).toString()

                myRef.child(matchid).child("team1").child("players").child("10").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team1").child("players").child("10").child("batting").child("B").setValue(pball)
                count4And6(countfourandSix,t1p114s,t1p116s,"10","team1")

            }
            else if(player2_check.text.toString().equals(t1p12name)){
                prun= (t1p12run.toInt()+runNumber).toString()
                pball= (t1p12balls.toInt()+countballs).toString()

                myRef.child(matchid).child("team1").child("players").child("11").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team1").child("players").child("11").child("batting").child("B").setValue(pball)
                count4And6(countfourandSix,t1p124s,t1p126s,"11","team1")

            }

            if(player2_check.text.toString().equals(t2p1name)){
                prun= (t2p1run.toInt()+runNumber).toString()
                pball= (t2p1balls.toInt()+countballs).toString()

                myRef.child(matchid).child("team2").child("players").child("0").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team2").child("players").child("0").child("batting").child("B").setValue(pball)
                count4And6(countfourandSix,t2p14s,t2p16s,"0","team2")

            }
            else if(player2_check.text.toString().equals(t2p2name)){
                prun= (t2p2run.toInt()+runNumber).toString()
                pball= (t2p2balls.toInt()+countballs).toString()

                myRef.child(matchid).child("team2").child("players").child("1").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team2").child("players").child("1").child("batting").child("B").setValue(pball)
                count4And6(countfourandSix,t2p24s,t2p26s,"1","team2")

            }
            else if(player2_check.text.toString().equals(t2p3name)){
                prun= (t2p3run.toInt()+runNumber).toString()
                pball= (t2p3balls.toInt()+countballs).toString()

                myRef.child(matchid).child("team2").child("players").child("2").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team2").child("players").child("2").child("batting").child("B").setValue(pball)
                count4And6(countfourandSix,t2p34s,t2p36s,"2","team2")

            }
            else if(player2_check.text.toString().equals(t2p4name)){
                prun= (t2p4run.toInt()+runNumber).toString()
                pball= (t2p4balls.toInt()+countballs).toString()

                myRef.child(matchid).child("team2").child("players").child("3").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team2").child("players").child("3").child("batting").child("B").setValue(pball)
                count4And6(countfourandSix,t2p44s,t2p46s,"3","team2")

            }
            else if(player2_check.text.toString().equals(t2p5name)){
                prun= (t2p5run.toInt()+runNumber).toString()
                pball= (t2p5balls.toInt()+countballs).toString()

                myRef.child(matchid).child("team2").child("players").child("4").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team2").child("players").child("4").child("batting").child("B").setValue(pball)
                count4And6(countfourandSix,t2p54s,t2p56s,"4","team2")

            }
            else if(player2_check.text.toString().equals(t2p6name)){
                prun= (t2p6run.toInt()+runNumber).toString()
                pball= (t2p6balls.toInt()+countballs).toString()

                myRef.child(matchid).child("team2").child("players").child("5").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team2").child("players").child("5").child("batting").child("B").setValue(pball)
                count4And6(countfourandSix,t2p64s,t2p66s,"5","team2")

            }
            else if(player2_check.text.toString().equals(t2p7name)){
                prun= (t2p7run.toInt()+runNumber).toString()
                pball= (t2p7balls.toInt()+countballs).toString()

                myRef.child(matchid).child("team2").child("players").child("6").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team2").child("players").child("6").child("batting").child("B").setValue(pball)
                count4And6(countfourandSix,t2p74s,t2p76s,"6","team2")

            }
            else if(player2_check.text.toString().equals(t2p8name)){
                prun= (t2p8run.toInt()+runNumber).toString()
                pball= (t2p8balls.toInt()+countballs).toString()

                myRef.child(matchid).child("team2").child("players").child("7").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team2").child("players").child("7").child("batting").child("B").setValue(pball)
                count4And6(countfourandSix,t2p84s,t2p86s,"7","team2")

            }
            else if(player2_check.text.toString().equals(t2p9name)){
                prun= (t2p9run.toInt()+runNumber).toString()
                pball= (t2p9balls.toInt()+countballs).toString()

                myRef.child(matchid).child("team2").child("players").child("8").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team2").child("players").child("8").child("batting").child("B").setValue(pball)
                count4And6(countfourandSix,t2p94s,t2p96s,"8","team2")

            }
            else if(player2_check.text.toString().equals(t2p10name)){
                prun= (t2p10run.toInt()+runNumber).toString()
                pball= (t2p10balls.toInt()+countballs).toString()

                myRef.child(matchid).child("team2").child("players").child("9").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team2").child("players").child("9").child("batting").child("B").setValue(pball)
                count4And6(countfourandSix,t2p104s,t2p106s,"9","team2")

            }
            else if(player2_check.text.toString().equals(t2p11name)){
                prun= (t2p11run.toInt()+runNumber).toString()
                pball= (t2p11balls.toInt()+countballs).toString()

                myRef.child(matchid).child("team2").child("players").child("10").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team2").child("players").child("10").child("batting").child("B").setValue(pball)
                count4And6(countfourandSix,t2p114s,t2p116s,"10","team2")

            }
            else if(player2_check.text.toString().equals(t2p12name)){
                prun= (t2p12run.toInt()+runNumber).toString()
                pball= (t2p12balls.toInt()+countballs).toString()

                myRef.child(matchid).child("team2").child("players").child("11").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team2").child("players").child("11").child("batting").child("B").setValue(pball)
                count4And6(countfourandSix,t2p124s,t2p126s,"11","team2")

            }

            if(bowler1_check.text.toString().equals(t1p1name)){
                bowler1over= (bowler1CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler1CountBalls").setValue(bowler1over)

                bcountover=overCalculate(bowler1over.toInt())
                bowlerrun= (t1b1run.toInt()+runNumber).toString()

                myRef.child(matchid).child("team1").child("players").child("0").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team1").child("players").child("0").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler1_check.text.toString().equals(t1p2name)){
                bowler1over= (bowler1CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler1CountBalls").setValue(bowler1over)

                bcountover=overCalculate(bowler1over.toInt())
                bowlerrun= (t1b2run.toInt()+runNumber).toString()

                myRef.child(matchid).child("team1").child("players").child("1").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team1").child("players").child("1").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler1_check.text.toString().equals(t1p3name)){
                bowler1over= (bowler1CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler1CountBalls").setValue(bowler1over)

                bcountover=overCalculate(bowler1over.toInt())
                bowlerrun= (t1b3run.toInt()+runNumber).toString()

                myRef.child(matchid).child("team1").child("players").child("2").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team1").child("players").child("2").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler1_check.text.toString().equals(t1p4name)){
                bowler1over= (bowler1CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler1CountBalls").setValue(bowler1over)

                bcountover=overCalculate(bowler1over.toInt())
                bowlerrun= (t1b4run.toInt()+runNumber).toString()

                myRef.child(matchid).child("team1").child("players").child("3").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team1").child("players").child("3").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler1_check.text.toString().equals(t1p5name)){
                bowler1over= (bowler1CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler1CountBalls").setValue(bowler1over)

                bcountover=overCalculate(bowler1over.toInt())
                bowlerrun= (t1b5run.toInt()+runNumber).toString()

                myRef.child(matchid).child("team1").child("players").child("4").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team1").child("players").child("4").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler1_check.text.toString().equals(t1p6name)){
                bowler1over= (bowler1CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler1CountBalls").setValue(bowler1over)

                bcountover=overCalculate(bowler1over.toInt())
                bowlerrun= (t1b6run.toInt()+runNumber).toString()

                myRef.child(matchid).child("team1").child("players").child("5").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team1").child("players").child("5").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler1_check.text.toString().equals(t1p7name)){
                bowler1over= (bowler1CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler1CountBalls").setValue(bowler1over)

                bcountover=overCalculate(bowler1over.toInt())
                bowlerrun= (t1b7run.toInt()+runNumber).toString()

                myRef.child(matchid).child("team1").child("players").child("6").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team1").child("players").child("6").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler1_check.text.toString().equals(t1p8name)){
                bowler1over= (bowler1CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler1CountBalls").setValue(bowler1over)

                bcountover=overCalculate(bowler1over.toInt())
                bowlerrun= (t1b8run.toInt()+runNumber).toString()

                myRef.child(matchid).child("team1").child("players").child("7").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team1").child("players").child("7").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler1_check.text.toString().equals(t1p9name)){
                bowler1over= (bowler1CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler1CountBalls").setValue(bowler1over)

                bcountover=overCalculate(bowler1over.toInt())
                bowlerrun= (t1b9run.toInt()+runNumber).toString()

                myRef.child(matchid).child("team1").child("players").child("8").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team1").child("players").child("8").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler1_check.text.toString().equals(t1p10name)){
                bowler1over= (bowler1CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler1CountBalls").setValue(bowler1over)

                bcountover=overCalculate(bowler1over.toInt())
                bowlerrun= (t1b10run.toInt()+runNumber).toString()

                myRef.child(matchid).child("team1").child("players").child("9").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team1").child("players").child("9").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler1_check.text.toString().equals(t1p11name)){
                bowler1over= (bowler1CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler1CountBalls").setValue(bowler1over)

                bcountover=overCalculate(bowler1over.toInt())
                bowlerrun= (t1b11run.toInt()+runNumber).toString()

                myRef.child(matchid).child("team1").child("players").child("10").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team1").child("players").child("10").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler1_check.text.toString().equals(t1p12name)){
                bowler1over= (bowler1CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler1CountBalls").setValue(bowler1over)

                bcountover=overCalculate(bowler1over.toInt())
                bowlerrun= (t1b12run.toInt()+runNumber).toString()

                myRef.child(matchid).child("team1").child("players").child("11").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team1").child("players").child("11").child("bowling").child("O").setValue(bcountover)
            }

            if(bowler1_check.text.toString().equals(t2p1name)){
                bowler1over= (bowler1CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler1CountBalls").setValue(bowler1over)

                bcountover=overCalculate(bowler1over.toInt())
                bowlerrun= (t2b1run.toInt()+runNumber).toString()

                myRef.child(matchid).child("team2").child("players").child("0").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team2").child("players").child("0").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler1_check.text.toString().equals(t2p2name)){
                bowler1over= (bowler1CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler1CountBalls").setValue(bowler1over)

                bcountover=overCalculate(bowler1over.toInt())
                bowlerrun= (t2b2run.toInt()+runNumber).toString()

                myRef.child(matchid).child("team2").child("players").child("1").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team2").child("players").child("1").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler1_check.text.toString().equals(t2p3name)){
                bowler1over= (bowler1CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler1CountBalls").setValue(bowler1over)

                bcountover=overCalculate(bowler1over.toInt())
                bowlerrun= (t2b3run.toInt()+runNumber).toString()

                myRef.child(matchid).child("team2").child("players").child("2").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team2").child("players").child("2").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler1_check.text.toString().equals(t2p4name)){
                bowler1over= (bowler1CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler1CountBalls").setValue(bowler1over)

                bcountover=overCalculate(bowler1over.toInt())
                bowlerrun= (t2b4run.toInt()+runNumber).toString()

                myRef.child(matchid).child("team2").child("players").child("3").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team2").child("players").child("3").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler1_check.text.toString().equals(t2p5name)){
                bowler1over= (bowler1CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler1CountBalls").setValue(bowler1over)

                bcountover=overCalculate(bowler1over.toInt())
                bowlerrun= (t2b5run.toInt()+runNumber).toString()

                myRef.child(matchid).child("team2").child("players").child("4").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team2").child("players").child("4").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler1_check.text.toString().equals(t2p6name)){
                bowler1over= (bowler1CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler1CountBalls").setValue(bowler1over)

                bcountover=overCalculate(bowler1over.toInt())
                bowlerrun= (t2b6run.toInt()+runNumber).toString()

                myRef.child(matchid).child("team2").child("players").child("5").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team2").child("players").child("5").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler1_check.text.toString().equals(t2p7name)){
                bowler1over= (bowler1CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler1CountBalls").setValue(bowler1over)

                bcountover=overCalculate(bowler1over.toInt())
                bowlerrun= (t2b7run.toInt()+runNumber).toString()

                myRef.child(matchid).child("team2").child("players").child("6").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team2").child("players").child("6").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler1_check.text.toString().equals(t2p8name)){
                bowler1over= (bowler1CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler1CountBalls").setValue(bowler1over)

                bcountover=overCalculate(bowler1over.toInt())
                bowlerrun= (t2b8run.toInt()+runNumber).toString()

                myRef.child(matchid).child("team2").child("players").child("7").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team2").child("players").child("7").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler1_check.text.toString().equals(t2p9name)){
                bowler1over= (bowler1CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler1CountBalls").setValue(bowler1over)

                bcountover=overCalculate(bowler1over.toInt())
                bowlerrun= (t2b9run.toInt()+runNumber).toString()

                myRef.child(matchid).child("team2").child("players").child("8").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team2").child("players").child("8").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler1_check.text.toString().equals(t2p10name)){
                bowler1over= (bowler1CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler1CountBalls").setValue(bowler1over)

                bcountover=overCalculate(bowler1over.toInt())
                bowlerrun= (t2b10run.toInt()+runNumber).toString()

                myRef.child(matchid).child("team2").child("players").child("9").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team2").child("players").child("9").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler1_check.text.toString().equals(t2p11name)){
                bowler1over= (bowler1CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler1CountBalls").setValue(bowler1over)

                bcountover=overCalculate(bowler1over.toInt())
                bowlerrun= (t2b11run.toInt()+runNumber).toString()

                myRef.child(matchid).child("team2").child("players").child("10").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team2").child("players").child("10").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler1_check.text.toString().equals(t2p12name)){
                bowler1over= (bowler1CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler1CountBalls").setValue(bowler1over)

                bcountover=overCalculate(bowler1over.toInt())
                bowlerrun= (t2b12run.toInt()+runNumber).toString()

                myRef.child(matchid).child("team2").child("players").child("11").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team2").child("players").child("11").child("bowling").child("O").setValue(bcountover)
            }

            /* myRef.child(matchid).child("Batsman").child("b2").child("R").setValue(prun)
             myRef.child(matchid).child("Batsman").child("b2").child("B").setValue(pball)
             myRef.child(matchid).child("Bowling").child("bowler1").child("R").setValue(bowlerrun)
             myRef.child(matchid).child("Bowling").child("bowler1").child("O").setValue(bowlerover)
            */
           /* if(choosebattingteam.equals(t1name)){
                myRef.child(matchid).child("team1").child("run").setValue(team1run)
                myRef.child(matchid).child("team1").child("over").setValue(countover)
                if(inning.equals("2")){
                    myRef.child(matchid).child("remainingballs").setValue(ballsremaining)

                }
            }else{
                myRef.child(matchid).child("team2").child("run").setValue(team2run)
                myRef.child(matchid).child("team2").child("over").setValue(countover)
                if(inning.equals("2")){
                    myRef.child(matchid).child("remainingballs").setValue(ballsremaining)

                }
            }*/
            Toast.makeText(this,"player2 run"+" "+prun,Toast.LENGTH_SHORT).show()

        }else if(player2_check.isChecked && bowler2_check.isChecked  ){
            /* prun= (b2run.toInt()+runNumber).toString()
             pball= (b2ball.toInt()+runNumber).toString()
             bowlerover= (bowler2over.toInt()+countballs).toString()
             bowlerrun= (bowler2run.toInt()+runNumber).toString()*/
          /*  team1run=(t1run.toInt()+runNumber).toString()
            team2run=(t2run.toInt()+runNumber).toString()
*/
            Log.d("bharti11", "Value b2 is: $prun")

            if(player2_check.text.toString().equals(t1p1name)){
                prun= (t1p1run.toInt()+runNumber).toString()
                pball= (t1p1balls.toInt()+countballs).toString()

                myRef.child(matchid).child("team1").child("players").child("0").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team1").child("players").child("0").child("batting").child("B").setValue(pball)
                count4And6(countfourandSix,t1p14s,t1p16s,"0","team1")

            }
            else if(player2_check.text.toString().equals(t1p2name)){
                prun= (t1p2run.toInt()+runNumber).toString()
                pball= (t1p2balls.toInt()+countballs).toString()

                myRef.child(matchid).child("team1").child("players").child("1").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team1").child("players").child("1").child("batting").child("B").setValue(pball)
                count4And6(countfourandSix,t1p24s,t1p26s,"1","team1")

            }
            else if(player2_check.text.toString().equals(t1p3name)){
                prun= (t1p3run.toInt()+runNumber).toString()
                pball= (t1p3balls.toInt()+countballs).toString()

                myRef.child(matchid).child("team1").child("players").child("2").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team1").child("players").child("2").child("batting").child("B").setValue(pball)
                count4And6(countfourandSix,t1p34s,t1p36s,"2","team1")

            }
            else if(player2_check.text.toString().equals(t1p4name)){
                prun= (t1p4run.toInt()+runNumber).toString()
                pball= (t1p4balls.toInt()+countballs).toString()

                myRef.child(matchid).child("team1").child("players").child("3").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team1").child("players").child("3").child("batting").child("B").setValue(pball)
                count4And6(countfourandSix,t1p44s,t1p46s,"3","team1")

            }
            else if(player2_check.text.toString().equals(t1p5name)){
                prun= (t1p5run.toInt()+runNumber).toString()
                pball= (t1p5balls.toInt()+countballs).toString()

                myRef.child(matchid).child("team1").child("players").child("4").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team1").child("players").child("4").child("batting").child("B").setValue(pball)
                count4And6(countfourandSix,t1p54s,t1p56s,"4","team1")

            }
            else if(player2_check.text.toString().equals(t1p6name)){
                prun= (t1p6run.toInt()+runNumber).toString()
                pball= (t1p6balls.toInt()+countballs).toString()

                myRef.child(matchid).child("team1").child("players").child("5").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team1").child("players").child("5").child("batting").child("B").setValue(pball)
                count4And6(countfourandSix,t1p64s,t1p66s,"5","team1")

            }
            else if(player2_check.text.toString().equals(t1p7name)){
                prun= (t1p7run.toInt()+runNumber).toString()
                pball= (t1p7balls.toInt()+countballs).toString()

                myRef.child(matchid).child("team1").child("players").child("6").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team1").child("players").child("6").child("batting").child("B").setValue(pball)
                count4And6(countfourandSix,t1p74s,t1p76s,"6","team1")

            }
            else if(player2_check.text.toString().equals(t1p8name)){
                prun= (t1p8run.toInt()+runNumber).toString()
                pball= (t1p8balls.toInt()+countballs).toString()

                myRef.child(matchid).child("team1").child("players").child("7").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team1").child("players").child("7").child("batting").child("B").setValue(pball)
                count4And6(countfourandSix,t1p84s,t1p86s,"7","team1")

            }
            else if(player2_check.text.toString().equals(t1p9name)){
                prun= (t1p9run.toInt()+runNumber).toString()
                pball= (t1p9balls.toInt()+countballs).toString()

                myRef.child(matchid).child("team1").child("players").child("8").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team1").child("players").child("8").child("batting").child("B").setValue(pball)
                count4And6(countfourandSix,t1p94s,t1p96s,"8","team1")

            }
            else if(player2_check.text.toString().equals(t1p10name)){
                prun= (t1p10run.toInt()+runNumber).toString()
                pball= (t1p10balls.toInt()+countballs).toString()

                myRef.child(matchid).child("team1").child("players").child("9").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team1").child("players").child("9").child("batting").child("B").setValue(pball)
                count4And6(countfourandSix,t1p104s,t1p106s,"9","team1")

            }
            else if(player2_check.text.toString().equals(t1p11name)){
                prun= (t1p11run.toInt()+runNumber).toString()
                pball= (t1p11balls.toInt()+countballs).toString()

                myRef.child(matchid).child("team1").child("players").child("10").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team1").child("players").child("10").child("batting").child("B").setValue(pball)
                count4And6(countfourandSix,t1p114s,t1p116s,"10","team1")

            }
            else if(player2_check.text.toString().equals(t1p12name)){
                prun= (t1p12run.toInt()+runNumber).toString()
                pball= (t1p12balls.toInt()+countballs).toString()

                myRef.child(matchid).child("team1").child("players").child("11").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team1").child("players").child("11").child("batting").child("B").setValue(pball)
                count4And6(countfourandSix,t1p124s,t1p126s,"11","team1")

            }

            if(player2_check.text.toString().equals(t2p1name)){
                prun= (t2p1run.toInt()+runNumber).toString()
                pball= (t2p1balls.toInt()+countballs).toString()

                myRef.child(matchid).child("team2").child("players").child("0").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team2").child("players").child("0").child("batting").child("B").setValue(pball)
                count4And6(countfourandSix,t2p14s,t2p16s,"0","team2")

            }
            else if(player2_check.text.toString().equals(t2p2name)){
                prun= (t2p2run.toInt()+runNumber).toString()
                pball= (t2p2balls.toInt()+countballs).toString()

                myRef.child(matchid).child("team2").child("players").child("1").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team2").child("players").child("1").child("batting").child("B").setValue(pball)
                count4And6(countfourandSix,t2p24s,t2p26s,"1","team2")

            }
            else if(player2_check.text.toString().equals(t2p3name)){
                prun= (t2p3run.toInt()+runNumber).toString()
                pball= (t2p3balls.toInt()+countballs).toString()

                myRef.child(matchid).child("team2").child("players").child("2").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team2").child("players").child("2").child("batting").child("B").setValue(pball)
                count4And6(countfourandSix,t2p34s,t2p36s,"2","team2")

            }
            else if(player2_check.text.toString().equals(t2p4name)){
                prun= (t2p4run.toInt()+runNumber).toString()
                pball= (t2p4balls.toInt()+countballs).toString()

                myRef.child(matchid).child("team2").child("players").child("3").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team2").child("players").child("3").child("batting").child("B").setValue(pball)
                count4And6(countfourandSix,t2p44s,t2p46s,"3","team2")

            }
            else if(player2_check.text.toString().equals(t2p5name)){
                prun= (t2p5run.toInt()+runNumber).toString()
                pball= (t2p5balls.toInt()+countballs).toString()

                myRef.child(matchid).child("team2").child("players").child("4").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team2").child("players").child("4").child("batting").child("B").setValue(pball)
                count4And6(countfourandSix,t2p54s,t2p56s,"4","team2")

            }
            else if(player2_check.text.toString().equals(t2p6name)){
                prun= (t2p6run.toInt()+runNumber).toString()
                pball= (t2p6balls.toInt()+countballs).toString()

                myRef.child(matchid).child("team2").child("players").child("5").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team2").child("players").child("5").child("batting").child("B").setValue(pball)
                count4And6(countfourandSix,t2p64s,t2p66s,"5","team2")

            }
            else if(player2_check.text.toString().equals(t2p7name)){
                prun= (t2p7run.toInt()+runNumber).toString()
                pball= (t2p7balls.toInt()+countballs).toString()

                myRef.child(matchid).child("team2").child("players").child("6").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team2").child("players").child("6").child("batting").child("B").setValue(pball)
                count4And6(countfourandSix,t2p74s,t2p76s,"6","team2")

            }
            else if(player2_check.text.toString().equals(t2p8name)){
                prun= (t2p8run.toInt()+runNumber).toString()
                pball= (t2p8balls.toInt()+countballs).toString()

                myRef.child(matchid).child("team2").child("players").child("7").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team2").child("players").child("7").child("batting").child("B").setValue(pball)
                count4And6(countfourandSix,t2p84s,t2p86s,"7","team2")

            }
            else if(player2_check.text.toString().equals(t2p9name)){
                prun= (t2p9run.toInt()+runNumber).toString()
                pball= (t2p9balls.toInt()+countballs).toString()

                myRef.child(matchid).child("team2").child("players").child("8").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team2").child("players").child("8").child("batting").child("B").setValue(pball)
                count4And6(countfourandSix,t2p94s,t2p96s,"8","team2")

            }
            else if(player2_check.text.toString().equals(t2p10name)){
                prun= (t2p10run.toInt()+runNumber).toString()
                pball= (t2p10balls.toInt()+countballs).toString()

                myRef.child(matchid).child("team2").child("players").child("9").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team2").child("players").child("9").child("batting").child("B").setValue(pball)
                count4And6(countfourandSix,t2p104s,t2p106s,"9","team2")

            }
            else if(player2_check.text.toString().equals(t2p11name)){
                prun= (t2p11run.toInt()+runNumber).toString()
                pball= (t2p11balls.toInt()+countballs).toString()

                myRef.child(matchid).child("team2").child("players").child("10").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team2").child("players").child("10").child("batting").child("B").setValue(pball)
                count4And6(countfourandSix,t2p114s,t2p116s,"10","team2")

            }
            else if(player2_check.text.toString().equals(t2p12name)){
                prun= (t2p12run.toInt()+runNumber).toString()
                pball= (t2p12balls.toInt()+countballs).toString()

                myRef.child(matchid).child("team2").child("players").child("11").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team2").child("players").child("11").child("batting").child("B").setValue(pball)
                count4And6(countfourandSix,t2p124s,t2p126s,"11","team2")

            }

            if(bowler2_check.text.toString().equals(t1p1name)){
                bowler2over= (bowler2CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler2CountBalls").setValue(bowler2over)

                bcountover=overCalculate(bowler2over.toInt())
                bowlerrun= (t1b1run.toInt()+runNumber).toString()

                myRef.child(matchid).child("team1").child("players").child("0").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team1").child("players").child("0").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler2_check.text.toString().equals(t1p2name)){
                bowler2over= (bowler2CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler2CountBalls").setValue(bowler2over)

                bcountover=overCalculate(bowler2over.toInt())
                bowlerrun= (t1b2run.toInt()+runNumber).toString()

                myRef.child(matchid).child("team1").child("players").child("1").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team1").child("players").child("1").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler2_check.text.toString().equals(t1p3name)){
                bowler2over= (bowler2CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler2CountBalls").setValue(bowler2over)

                bcountover=overCalculate(bowler2over.toInt())
                bowlerrun= (t1b3run.toInt()+runNumber).toString()

                myRef.child(matchid).child("team1").child("players").child("2").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team1").child("players").child("2").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler2_check.text.toString().equals(t1p4name)){
                bowler2over= (bowler2CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler2CountBalls").setValue(bowler2over)

                bcountover=overCalculate(bowler2over.toInt())
                bowlerrun= (t1b4run.toInt()+runNumber).toString()

                myRef.child(matchid).child("team1").child("players").child("3").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team1").child("players").child("3").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler2_check.text.toString().equals(t1p5name)){
                bowler2over= (bowler2CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler2CountBalls").setValue(bowler2over)

                bcountover=overCalculate(bowler2over.toInt())
                bowlerrun= (t1b5run.toInt()+runNumber).toString()

                myRef.child(matchid).child("team1").child("players").child("4").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team1").child("players").child("4").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler2_check.text.toString().equals(t1p6name)){
                bowler2over= (bowler2CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler2CountBalls").setValue(bowler2over)

                bcountover=overCalculate(bowler2over.toInt())
                bowlerrun= (t1b6run.toInt()+runNumber).toString()

                myRef.child(matchid).child("team1").child("players").child("5").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team1").child("players").child("5").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler2_check.text.toString().equals(t1p7name)){
                bowler2over= (bowler2CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler2CountBalls").setValue(bowler2over)

                bcountover=overCalculate(bowler2over.toInt())
                bowlerrun= (t1b7run.toInt()+runNumber).toString()

                myRef.child(matchid).child("team1").child("players").child("6").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team1").child("players").child("6").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler2_check.text.toString().equals(t1p8name)){
                bowler2over= (bowler2CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler2CountBalls").setValue(bowler2over)

                bcountover=overCalculate(bowler2over.toInt())
                bowlerrun= (t1b8run.toInt()+runNumber).toString()

                myRef.child(matchid).child("team1").child("players").child("7").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team1").child("players").child("7").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler2_check.text.toString().equals(t1p9name)){
                bowler2over= (bowler2CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler2CountBalls").setValue(bowler2over)

                bcountover=overCalculate(bowler2over.toInt())
                bowlerrun= (t1b9run.toInt()+runNumber).toString()

                myRef.child(matchid).child("team1").child("players").child("8").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team1").child("players").child("8").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler2_check.text.toString().equals(t1p10name)){
                bowler2over= (bowler2CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler2CountBalls").setValue(bowler2over)

                bcountover=overCalculate(bowler2over.toInt())
                bowlerrun= (t1b10run.toInt()+runNumber).toString()

                myRef.child(matchid).child("team1").child("players").child("9").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team1").child("players").child("9").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler2_check.text.toString().equals(t1p11name)){
                bowler2over= (bowler2CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler2CountBalls").setValue(bowler2over)

                bcountover=overCalculate(bowler2over.toInt())
                bowlerrun= (t1b11run.toInt()+runNumber).toString()

                myRef.child(matchid).child("team1").child("players").child("10").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team1").child("players").child("10").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler2_check.text.toString().equals(t1p12name)){
                bowler2over= (bowler2CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler2CountBalls").setValue(bowler2over)

                bcountover=overCalculate(bowler2over.toInt())
                bowlerrun= (t1b12run.toInt()+runNumber).toString()

                myRef.child(matchid).child("team1").child("players").child("11").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team1").child("players").child("11").child("bowling").child("O").setValue(bcountover)
            }

            if(bowler2_check.text.toString().equals(t2p1name)){
                bowler2over= (bowler2CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler2CountBalls").setValue(bowler2over)

                bcountover=overCalculate(bowler2over.toInt())
                bowlerrun= (t2b1run.toInt()+runNumber).toString()

                myRef.child(matchid).child("team2").child("players").child("0").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team2").child("players").child("0").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler2_check.text.toString().equals(t2p2name)){
                bowler2over= (bowler2CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler2CountBalls").setValue(bowler2over)

                bcountover=overCalculate(bowler2over.toInt())
                bowlerrun= (t2b2run.toInt()+runNumber).toString()

                myRef.child(matchid).child("team2").child("players").child("1").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team2").child("players").child("1").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler2_check.text.toString().equals(t2p3name)){
                bowler2over= (bowler2CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler2CountBalls").setValue(bowler2over)

                bcountover=overCalculate(bowler2over.toInt())
                bowlerrun= (t2b3run.toInt()+runNumber).toString()

                myRef.child(matchid).child("team2").child("players").child("2").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team2").child("players").child("2").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler2_check.text.toString().equals(t2p4name)){
                bowler2over= (bowler2CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler2CountBalls").setValue(bowler2over)

                bcountover=overCalculate(bowler2over.toInt())
                bowlerrun= (t2b4run.toInt()+runNumber).toString()

                myRef.child(matchid).child("team2").child("players").child("3").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team2").child("players").child("3").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler2_check.text.toString().equals(t2p5name)){
                bowler2over= (bowler2CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler2CountBalls").setValue(bowler2over)

                bcountover=overCalculate(bowler2over.toInt())
                bowlerrun= (t2b5run.toInt()+runNumber).toString()

                myRef.child(matchid).child("team2").child("players").child("4").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team2").child("players").child("4").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler2_check.text.toString().equals(t2p6name)){
                bowler2over= (bowler2CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler2CountBalls").setValue(bowler2over)

                bcountover=overCalculate(bowler2over.toInt())
                bowlerrun= (t2b6run.toInt()+runNumber).toString()

                myRef.child(matchid).child("team2").child("players").child("5").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team2").child("players").child("5").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler2_check.text.toString().equals(t2p7name)){
                bowler2over= (bowler2CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler2CountBalls").setValue(bowler2over)

                bcountover=overCalculate(bowler2over.toInt())
                bowlerrun= (t2b7run.toInt()+runNumber).toString()

                myRef.child(matchid).child("team2").child("players").child("6").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team2").child("players").child("6").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler2_check.text.toString().equals(t2p8name)){
                bowler2over= (bowler2CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler2CountBalls").setValue(bowler2over)

                bcountover=overCalculate(bowler2over.toInt())
                bowlerrun= (t2b8run.toInt()+runNumber).toString()

                myRef.child(matchid).child("team2").child("players").child("7").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team2").child("players").child("7").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler2_check.text.toString().equals(t2p9name)){
                bowler2over= (bowler2CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler2CountBalls").setValue(bowler2over)

                bcountover=overCalculate(bowler2over.toInt())
                bowlerrun= (t2b9run.toInt()+runNumber).toString()

                myRef.child(matchid).child("team2").child("players").child("8").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team2").child("players").child("8").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler2_check.text.toString().equals(t2p10name)){
                bowler2over= (bowler2CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler2CountBalls").setValue(bowler2over)

                bcountover=overCalculate(bowler2over.toInt())
                bowlerrun= (t2b10run.toInt()+runNumber).toString()

                myRef.child(matchid).child("team2").child("players").child("9").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team2").child("players").child("9").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler2_check.text.toString().equals(t2p11name)){
                bowler2over= (bowler2CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler2CountBalls").setValue(bowler2over)

                bcountover=overCalculate(bowler2over.toInt())
                bowlerrun= (t2b11run.toInt()+runNumber).toString()

                myRef.child(matchid).child("team2").child("players").child("10").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team2").child("players").child("10").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler2_check.text.toString().equals(t2p12name)){
                bowler2over= (bowler2CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler2CountBalls").setValue(bowler2over)

                bcountover=overCalculate(bowler2over.toInt())
                bowlerrun= (t2b12run.toInt()+runNumber).toString()

                myRef.child(matchid).child("team2").child("players").child("11").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team2").child("players").child("11").child("bowling").child("O").setValue(bcountover)
            }




           /* if(choosebattingteam.equals(t1name)){
                myRef.child(matchid).child("team1").child("run").setValue(team1run)
                myRef.child(matchid).child("team1").child("over").setValue(countover)

            }else{
                myRef.child(matchid).child("team2").child("run").setValue(team2run)
                myRef.child(matchid).child("team2").child("over").setValue(countover)

            }*/
            Toast.makeText(this,"player2 run"+" "+prun,Toast.LENGTH_SHORT).show()

        }


        if(choosebattingteam.equals(t1name)){
            myRef.child(matchid).child("team1").child("run").setValue(team1run)
            myRef.child(matchid).child("team1").child("over").setValue(countover)
          //  if(inning.equals("2")){
                myRef.child(matchid).child("remainingBalls").setValue(ballsremaining)

            //}
        }else{
            myRef.child(matchid).child("team2").child("run").setValue(team2run)
            myRef.child(matchid).child("team2").child("over").setValue(countover)
           // if(inning.equals("2")){
                myRef.child(matchid).child("remainingBalls").setValue(ballsremaining)

           // }
        }

    }

    fun count4And6(num4and6:Int,player4:String,player6: String,playerid:String,pteamid:String){
        if(num4and6.equals(4)){
            batsman4runcount= (player4.toInt()+1).toString()
            myRef.child(matchid).child(pteamid).child("players").child(playerid).child("batting").child("4s").setValue(batsman4runcount)
            Toast.makeText(this,"player2 run 4"+" "+batsman4runcount,Toast.LENGTH_SHORT).show()


        }else if(num4and6.equals(6)){
            batsman6runcount= (player6.toInt()+1).toString()
            myRef.child(matchid).child(pteamid).child("players").child(playerid).child("batting").child("6s").setValue(batsman6runcount)
            Toast.makeText(this,"player2 run 6"+" "+batsman6runcount,Toast.LENGTH_SHORT).show()


        }
    }

    fun countExtraRun(runNumber: Int,wideball:Int){
        if(bowler1_check.isChecked  ){

            if(bowler1_check.text.toString().equals(t1p1name)){

                brun= (t1b1run.toInt()+runNumber).toString()
                bwideBall= (t1b1W.toInt()+wideball).toString()
                myRef.child(matchid).child("team1").child("players").child("0").child("bowling").child("W").setValue(bwideBall)

                myRef.child(matchid).child("team1").child("players").child("0").child("bowling").child("R").setValue(brun)
            }
            else if(bowler1_check.text.toString().equals(t1p2name)){
                brun= (t1b2run.toInt()+runNumber).toString()
                bwideBall= (t1b2W.toInt()+wideball).toString()
                myRef.child(matchid).child("team1").child("players").child("1").child("bowling").child("W").setValue(bwideBall)

                myRef.child(matchid).child("team1").child("players").child("1").child("bowling").child("R").setValue(brun)
            }
            else if(bowler1_check.text.toString().equals(t1p3name)){
                brun= (t1b3run.toInt()+runNumber).toString()
                bwideBall= (t1b3W.toInt()+wideball).toString()
                myRef.child(matchid).child("team1").child("players").child("2").child("bowling").child("W").setValue(bwideBall)

                myRef.child(matchid).child("team1").child("players").child("2").child("bowling").child("R").setValue(brun)
            }
            else if(bowler1_check.text.toString().equals(t1p4name)){
                brun= (t1b4run.toInt()+runNumber).toString()
                bwideBall= (t1b4W.toInt()+wideball).toString()
                myRef.child(matchid).child("team1").child("players").child("3").child("bowling").child("W").setValue(bwideBall)

                myRef.child(matchid).child("team1").child("players").child("3").child("bowling").child("R").setValue(brun)
            }
            else if(bowler1_check.text.toString().equals(t1p5name)){
                brun= (t1b5run.toInt()+runNumber).toString()
                bwideBall= (t1b5W.toInt()+wideball).toString()
                myRef.child(matchid).child("team1").child("players").child("4").child("bowling").child("W").setValue(bwideBall)

                myRef.child(matchid).child("team1").child("players").child("4").child("bowling").child("R").setValue(brun)
            }
            else if(bowler1_check.text.toString().equals(t1p6name)){
                brun= (t1b6run.toInt()+runNumber).toString()
                bwideBall= (t1b6W.toInt()+wideball).toString()
                myRef.child(matchid).child("team1").child("players").child("5").child("bowling").child("W").setValue(bwideBall)

                myRef.child(matchid).child("team1").child("players").child("5").child("bowling").child("R").setValue(brun)
            }
            else if(bowler1_check.text.toString().equals(t1p7name)){
                brun= (t1b7run.toInt()+runNumber).toString()
                bwideBall= (t1b7W.toInt()+wideball).toString()
                myRef.child(matchid).child("team1").child("players").child("6").child("bowling").child("W").setValue(bwideBall)

                myRef.child(matchid).child("team1").child("players").child("6").child("bowling").child("R").setValue(brun)
            }
            else if(bowler1_check.text.toString().equals(t1p8name)){
                brun= (t1b8run.toInt()+runNumber).toString()
                bwideBall= (t1b8W.toInt()+wideball).toString()
                myRef.child(matchid).child("team1").child("players").child("7").child("bowling").child("W").setValue(bwideBall)

                myRef.child(matchid).child("team1").child("players").child("7").child("bowling").child("R").setValue(brun)
            }
            else if(bowler1_check.text.toString().equals(t1p9name)){
                brun= (t1b9run.toInt()+runNumber).toString()
                bwideBall= (t1b9W.toInt()+wideball).toString()
                myRef.child(matchid).child("team1").child("players").child("8").child("bowling").child("W").setValue(bwideBall)

                myRef.child(matchid).child("team1").child("players").child("8").child("bowling").child("R").setValue(brun)
            }
            else if(bowler1_check.text.toString().equals(t1p10name)){
                brun= (t1b10run.toInt()+runNumber).toString()
                bwideBall= (t1b10W.toInt()+wideball).toString()
                myRef.child(matchid).child("team1").child("players").child("9").child("bowling").child("W").setValue(bwideBall)

                myRef.child(matchid).child("team1").child("players").child("9").child("bowling").child("R").setValue(brun)
            }
            else if(bowler1_check.text.toString().equals(t1p11name)){
                brun= (t1b11run.toInt()+runNumber).toString()
                bwideBall= (t1b11W.toInt()+wideball).toString()
                myRef.child(matchid).child("team1").child("players").child("10").child("bowling").child("W").setValue(bwideBall)

                myRef.child(matchid).child("team1").child("players").child("10").child("bowling").child("R").setValue(brun)
            }
            else if(bowler1_check.text.toString().equals(t1p12name)){
                brun= (t1b12run.toInt()+runNumber).toString()
                bwideBall= (t1b12W.toInt()+wideball).toString()
                myRef.child(matchid).child("team1").child("players").child("11").child("bowling").child("W").setValue(bwideBall)

                myRef.child(matchid).child("team1").child("players").child("11").child("bowling").child("R").setValue(brun)
            }

            if(bowler1_check.text.toString().equals(t2p1name)){

                brun= (t2b1run.toInt()+runNumber).toString()
                bwideBall= (t2b1W.toInt()+wideball).toString()
                myRef.child(matchid).child("team2").child("players").child("0").child("bowling").child("W").setValue(bwideBall)

                myRef.child(matchid).child("team2").child("players").child("0").child("bowling").child("R").setValue(brun)
            }
            else if(bowler1_check.text.toString().equals(t2p2name)){
                brun= (t2b2run.toInt()+runNumber).toString()
                bwideBall= (t2b2W.toInt()+wideball).toString()
                myRef.child(matchid).child("team2").child("players").child("1").child("bowling").child("W").setValue(bwideBall)

                myRef.child(matchid).child("team2").child("players").child("1").child("bowling").child("R").setValue(brun)
            }
            else if(bowler1_check.text.toString().equals(t2p3name)){
                brun= (t2b3run.toInt()+runNumber).toString()
                bwideBall= (t2b3W.toInt()+wideball).toString()
                myRef.child(matchid).child("team2").child("players").child("2").child("bowling").child("W").setValue(bwideBall)

                myRef.child(matchid).child("team2").child("players").child("2").child("bowling").child("R").setValue(brun)
            }
            else if(bowler1_check.text.toString().equals(t2p4name)){
                brun= (t2b4run.toInt()+runNumber).toString()
                bwideBall= (t2b4W.toInt()+wideball).toString()
                myRef.child(matchid).child("team2").child("players").child("3").child("bowling").child("W").setValue(bwideBall)

                myRef.child(matchid).child("team2").child("players").child("3").child("bowling").child("R").setValue(brun)
            }
            else if(bowler1_check.text.toString().equals(t2p5name)){
                brun= (t2b5run.toInt()+runNumber).toString()
                bwideBall= (t2b5W.toInt()+wideball).toString()
                myRef.child(matchid).child("team2").child("players").child("4").child("bowling").child("W").setValue(bwideBall)

                myRef.child(matchid).child("team2").child("players").child("4").child("bowling").child("R").setValue(brun)
            }
            else if(bowler1_check.text.toString().equals(t2p6name)){
                brun= (t2b6run.toInt()+runNumber).toString()
                bwideBall= (t2b6W.toInt()+wideball).toString()
                myRef.child(matchid).child("team2").child("players").child("5").child("bowling").child("W").setValue(bwideBall)

                myRef.child(matchid).child("team2").child("players").child("5").child("bowling").child("R").setValue(brun)
            }
            else if(bowler1_check.text.toString().equals(t2p7name)){
                brun= (t2b7run.toInt()+runNumber).toString()
                bwideBall= (t2b7W.toInt()+wideball).toString()
                myRef.child(matchid).child("team2").child("players").child("6").child("bowling").child("W").setValue(bwideBall)

                myRef.child(matchid).child("team2").child("players").child("6").child("bowling").child("R").setValue(brun)
            }
            else if(bowler1_check.text.toString().equals(t2p8name)){
                brun= (t2b8run.toInt()+runNumber).toString()
                bwideBall= (t2b8W.toInt()+wideball).toString()
                myRef.child(matchid).child("team2").child("players").child("7").child("bowling").child("W").setValue(bwideBall)

                myRef.child(matchid).child("team2").child("players").child("7").child("bowling").child("R").setValue(brun)
            }
            else if(bowler1_check.text.toString().equals(t2p9name)){
                brun= (t2b9run.toInt()+runNumber).toString()
                bwideBall= (t2b9W.toInt()+wideball).toString()
                myRef.child(matchid).child("team2").child("players").child("8").child("bowling").child("W").setValue(bwideBall)

                myRef.child(matchid).child("team2").child("players").child("8").child("bowling").child("R").setValue(brun)
            }
            else if(bowler1_check.text.toString().equals(t2p10name)){
                brun= (t2b10run.toInt()+runNumber).toString()
                bwideBall= (t2b10W.toInt()+wideball).toString()
                myRef.child(matchid).child("team2").child("players").child("9").child("bowling").child("W").setValue(bwideBall)

                myRef.child(matchid).child("team2").child("players").child("9").child("bowling").child("R").setValue(brun)
            }
            else if(bowler1_check.text.toString().equals(t2p11name)){
                brun= (t2b11run.toInt()+runNumber).toString()
                bwideBall= (t2b11W.toInt()+wideball).toString()
                myRef.child(matchid).child("team2").child("players").child("10").child("bowling").child("W").setValue(bwideBall)

                myRef.child(matchid).child("team2").child("players").child("10").child("bowling").child("R").setValue(brun)
            }
            else if(bowler1_check.text.toString().equals(t2p12name)){
                brun= (t2b12run.toInt()+runNumber).toString()
                bwideBall= (t2b12W.toInt()+wideball).toString()
                myRef.child(matchid).child("team2").child("players").child("11").child("bowling").child("W").setValue(bwideBall)

                myRef.child(matchid).child("team2").child("players").child("11").child("bowling").child("R").setValue(brun)
            }



        }else if(bowler2_check.isChecked  ){
            if(bowler2_check.text.toString().equals(t1p1name)){

                brun= (t1b1run.toInt()+runNumber).toString()
                bwideBall= (t1b1W.toInt()+wideball).toString()
                myRef.child(matchid).child("team1").child("players").child("0").child("bowling").child("W").setValue(bwideBall)

                myRef.child(matchid).child("team1").child("players").child("0").child("bowling").child("R").setValue(brun)
            }
            else if(bowler2_check.text.toString().equals(t1p2name)){
                brun= (t1b2run.toInt()+runNumber).toString()
                bwideBall= (t1b2W.toInt()+wideball).toString()
                myRef.child(matchid).child("team1").child("players").child("1").child("bowling").child("W").setValue(bwideBall)

                myRef.child(matchid).child("team1").child("players").child("1").child("bowling").child("R").setValue(brun)
            }
            else if(bowler2_check.text.toString().equals(t1p3name)){
                brun= (t1b3run.toInt()+runNumber).toString()
                bwideBall= (t1b3W.toInt()+wideball).toString()
                myRef.child(matchid).child("team1").child("players").child("2").child("bowling").child("W").setValue(bwideBall)

                myRef.child(matchid).child("team1").child("players").child("2").child("bowling").child("R").setValue(brun)
            }
            else if(bowler2_check.text.toString().equals(t1p4name)){
                brun= (t1b4run.toInt()+runNumber).toString()
                bwideBall= (t1b4W.toInt()+wideball).toString()
                myRef.child(matchid).child("team1").child("players").child("3").child("bowling").child("W").setValue(bwideBall)

                myRef.child(matchid).child("team1").child("players").child("3").child("bowling").child("R").setValue(brun)
            }
            else if(bowler2_check.text.toString().equals(t1p5name)){
                brun= (t1b5run.toInt()+runNumber).toString()
                bwideBall= (t1b5W.toInt()+wideball).toString()
                myRef.child(matchid).child("team1").child("players").child("4").child("bowling").child("W").setValue(bwideBall)

                myRef.child(matchid).child("team1").child("players").child("4").child("bowling").child("R").setValue(brun)
            }
            else if(bowler2_check.text.toString().equals(t1p6name)){
                brun= (t1b6run.toInt()+runNumber).toString()
                bwideBall= (t1b6W.toInt()+wideball).toString()
                myRef.child(matchid).child("team1").child("players").child("5").child("bowling").child("W").setValue(bwideBall)

                myRef.child(matchid).child("team1").child("players").child("5").child("bowling").child("R").setValue(brun)
            }
            else if(bowler2_check.text.toString().equals(t1p7name)){
                brun= (t1b7run.toInt()+runNumber).toString()
                bwideBall= (t1b7W.toInt()+wideball).toString()
                myRef.child(matchid).child("team1").child("players").child("6").child("bowling").child("W").setValue(bwideBall)

                myRef.child(matchid).child("team1").child("players").child("6").child("bowling").child("R").setValue(brun)
            }
            else if(bowler2_check.text.toString().equals(t1p8name)){
                brun= (t1b8run.toInt()+runNumber).toString()
                bwideBall= (t1b8W.toInt()+wideball).toString()
                myRef.child(matchid).child("team1").child("players").child("7").child("bowling").child("W").setValue(bwideBall)

                myRef.child(matchid).child("team1").child("players").child("7").child("bowling").child("R").setValue(brun)
            }
            else if(bowler2_check.text.toString().equals(t1p9name)){
                brun= (t1b9run.toInt()+runNumber).toString()
                bwideBall= (t1b9W.toInt()+wideball).toString()
                myRef.child(matchid).child("team1").child("players").child("8").child("bowling").child("W").setValue(bwideBall)

                myRef.child(matchid).child("team1").child("players").child("8").child("bowling").child("R").setValue(brun)
            }
            else if(bowler2_check.text.toString().equals(t1p10name)){
                brun= (t1b10run.toInt()+runNumber).toString()
                bwideBall= (t1b10W.toInt()+wideball).toString()
                myRef.child(matchid).child("team1").child("players").child("9").child("bowling").child("W").setValue(bwideBall)

                myRef.child(matchid).child("team1").child("players").child("9").child("bowling").child("R").setValue(brun)
            }
            else if(bowler2_check.text.toString().equals(t1p11name)){
                brun= (t1b11run.toInt()+runNumber).toString()
                bwideBall= (t1b11W.toInt()+wideball).toString()
                myRef.child(matchid).child("team1").child("players").child("10").child("bowling").child("W").setValue(bwideBall)

                myRef.child(matchid).child("team1").child("players").child("10").child("bowling").child("R").setValue(brun)
            }
            else if(bowler2_check.text.toString().equals(t1p12name)){
                brun= (t1b12run.toInt()+runNumber).toString()
                bwideBall= (t1b12W.toInt()+wideball).toString()
                myRef.child(matchid).child("team1").child("players").child("11").child("bowling").child("W").setValue(bwideBall)

                myRef.child(matchid).child("team1").child("players").child("11").child("bowling").child("R").setValue(brun)
            }

            if(bowler2_check.text.toString().equals(t2p1name)){

                brun= (t2b1run.toInt()+runNumber).toString()
                bwideBall= (t2b1W.toInt()+wideball).toString()
                myRef.child(matchid).child("team2").child("players").child("0").child("bowling").child("W").setValue(bwideBall)

                myRef.child(matchid).child("team2").child("players").child("0").child("bowling").child("R").setValue(brun)
            }
            else if(bowler2_check.text.toString().equals(t2p2name)){
                brun= (t2b2run.toInt()+runNumber).toString()
                bwideBall= (t2b2W.toInt()+wideball).toString()
                myRef.child(matchid).child("team2").child("players").child("1").child("bowling").child("W").setValue(bwideBall)

                myRef.child(matchid).child("team2").child("players").child("1").child("bowling").child("R").setValue(brun)
            }
            else if(bowler2_check.text.toString().equals(t2p3name)){
                brun= (t2b3run.toInt()+runNumber).toString()
                bwideBall= (t2b3W.toInt()+wideball).toString()
                myRef.child(matchid).child("team2").child("players").child("2").child("bowling").child("W").setValue(bwideBall)

                myRef.child(matchid).child("team2").child("players").child("2").child("bowling").child("R").setValue(brun)
            }
            else if(bowler2_check.text.toString().equals(t2p4name)){
                brun= (t2b4run.toInt()+runNumber).toString()
                bwideBall= (t2b4W.toInt()+wideball).toString()
                myRef.child(matchid).child("team2").child("players").child("3").child("bowling").child("W").setValue(bwideBall)

                myRef.child(matchid).child("team2").child("players").child("3").child("bowling").child("R").setValue(brun)
            }
            else if(bowler2_check.text.toString().equals(t2p5name)){
                brun= (t2b5run.toInt()+runNumber).toString()
                bwideBall= (t2b5W.toInt()+wideball).toString()
                myRef.child(matchid).child("team2").child("players").child("4").child("bowling").child("W").setValue(bwideBall)

                myRef.child(matchid).child("team2").child("players").child("4").child("bowling").child("R").setValue(brun)
            }
            else if(bowler2_check.text.toString().equals(t2p6name)){
                brun= (t2b6run.toInt()+runNumber).toString()
                bwideBall= (t2b6W.toInt()+wideball).toString()
                myRef.child(matchid).child("team2").child("players").child("5").child("bowling").child("W").setValue(bwideBall)

                myRef.child(matchid).child("team2").child("players").child("5").child("bowling").child("R").setValue(brun)
            }
            else if(bowler2_check.text.toString().equals(t2p7name)){
                brun= (t2b7run.toInt()+runNumber).toString()
                bwideBall= (t2b7W.toInt()+wideball).toString()
                myRef.child(matchid).child("team2").child("players").child("6").child("bowling").child("W").setValue(bwideBall)

                myRef.child(matchid).child("team2").child("players").child("6").child("bowling").child("R").setValue(brun)
            }
            else if(bowler2_check.text.toString().equals(t2p8name)){
                brun= (t2b8run.toInt()+runNumber).toString()
                bwideBall= (t2b8W.toInt()+wideball).toString()
                myRef.child(matchid).child("team2").child("players").child("7").child("bowling").child("W").setValue(bwideBall)

                myRef.child(matchid).child("team2").child("players").child("7").child("bowling").child("R").setValue(brun)
            }
            else if(bowler2_check.text.toString().equals(t2p9name)){
                brun= (t2b9run.toInt()+runNumber).toString()
                bwideBall= (t2b9W.toInt()+wideball).toString()
                myRef.child(matchid).child("team2").child("players").child("8").child("bowling").child("W").setValue(bwideBall)

                myRef.child(matchid).child("team2").child("players").child("8").child("bowling").child("R").setValue(brun)
            }
            else if(bowler2_check.text.toString().equals(t2p10name)){
                brun= (t2b10run.toInt()+runNumber).toString()
                bwideBall= (t2b10W.toInt()+wideball).toString()
                myRef.child(matchid).child("team2").child("players").child("9").child("bowling").child("W").setValue(bwideBall)

                myRef.child(matchid).child("team2").child("players").child("9").child("bowling").child("R").setValue(brun)
            }
            else if(bowler2_check.text.toString().equals(t2p11name)){
                brun= (t2b11run.toInt()+runNumber).toString()
                bwideBall= (t2b11W.toInt()+wideball).toString()
                myRef.child(matchid).child("team2").child("players").child("10").child("bowling").child("W").setValue(bwideBall)

                myRef.child(matchid).child("team2").child("players").child("10").child("bowling").child("R").setValue(brun)
            }
            else if(bowler2_check.text.toString().equals(t2p12name)){
                brun= (t2b12run.toInt()+runNumber).toString()
                bwideBall= (t2b12W.toInt()+wideball).toString()
                myRef.child(matchid).child("team2").child("players").child("11").child("bowling").child("W").setValue(bwideBall)

                myRef.child(matchid).child("team2").child("players").child("11").child("bowling").child("R").setValue(brun)
            }

        }

        team1run=(t1run.toInt()+1).toString()
        team2run=(t2run.toInt()+1).toString()
        if(choosebattingteam.equals(t1name)){


            myRef.child(matchid).child("team1").child("run").setValue(team1run)
            //   myRef.child(matchid).child("team2").child("over").setValue(team2run)

        }else{
            myRef.child(matchid).child("team2").child("run").setValue(team2run)

        }
    }
     fun batsmanalertDialog(item: Int,productsearch:Array<String>,pfilled:String):String {
        // setup the alert builder

        val builder = AlertDialog.Builder(this)
        builder.setTitle("Choose Player")
         var name:String=""

        // add a radio button list
       /* val productsearch = arrayOf(
            ".com",
            ".com.au",
            ".com.br",
            ".cz",
            ".fr",
            ".de",
            ".it",
            ".co.jp",
            ".nl",
            ".es",
            ".ch",
            ".co.uk",
            ".at",
            ".be",
            ".ca",
            ".dk",
            ".co.in",
            ".com.mx",
            ".no",
            ".pl",
            ".ru",
            ".se",
            ".com.tr"
        )
*/
        builder.setSingleChoiceItems(productsearch, -1) { dialog, which ->
            // user checked an item
            Log.v("Switch State=5", "" + productsearch[which])
             pname=productsearch[which]

            //Toast.makeText(getApplicationContext(),"Group Name = "+which+""+productsearch[which], Toast.LENGTH_SHORT).show();

        }
         builder.setPositiveButton("Ok") { dialog, which ->

             //Toast.makeText(getApplicationContext(),"Group Name = "+which+""+productsearch[which], Toast.LENGTH_SHORT).show();
             //player1_check.setText(pname)
             myRef.child(matchid).child(pfilled).setValue(pname)
             if(choosebattingteam.equals(t1name))
             {
                 var wicketCount=(t1viket.toInt()+1).toString()
                 myRef.child(matchid).child("team1").child("wicket").setValue(wicketCount)
             }else{
                 var wicketCount=(t2viket.toInt()+1).toString()
                 myRef.child(matchid).child("team2").child("wicket").setValue(wicketCount)
             }
             dialog.dismiss()
         }

        // add OK and Cancel buttons
        /*  builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            // user clicked OK
        }
    });*/

        builder.setNegativeButton("Cancel", null)

        // create and show the alert dialog
        val dialog = builder.create()
        dialog.show()
         return pname
    }
    fun bowleralertDialog(item: Int,productsearch:Array<String>,pfilled:String):String {
        // setup the alert builder

        val builder = AlertDialog.Builder(this)
        builder.setTitle("Choose Bowler")
        var name:String=""

        // add a radio button list
        /* val productsearch = arrayOf(
             ".com",
             ".com.au",
             ".com.br",
             ".cz",
             ".fr",
             ".de",
             ".it",
             ".co.jp",
             ".nl",
             ".es",
             ".ch",
             ".co.uk",
             ".at",
             ".be",
             ".ca",
             ".dk",
             ".co.in",
             ".com.mx",
             ".no",
             ".pl",
             ".ru",
             ".se",
             ".com.tr"
         )
 */
        builder.setSingleChoiceItems(productsearch, -1) { dialog, which ->
            // user checked an item
            Log.v("Switch State=5", "" + productsearch[which])
            pname=productsearch[which]

            //Toast.makeText(getApplicationContext(),"Group Name = "+which+""+productsearch[which], Toast.LENGTH_SHORT).show();

        }
        builder.setPositiveButton("Ok") { dialog, which ->

            //Toast.makeText(getApplicationContext(),"Group Name = "+which+""+productsearch[which], Toast.LENGTH_SHORT).show();
            //player1_check.setText(pname)
            myRef.child(matchid).child(pfilled).setValue(pname)
            if(pfilled.equals("bowler1")){
                myRef.child(matchid).child("bowler1CountBalls").setValue("0")

            }else{
                myRef.child(matchid).child("bowler2CountBalls").setValue("0")

            }

            dialog.dismiss()
        }

        // add OK and Cancel buttons
        /*  builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            // user clicked OK
        }
    });*/

        builder.setNegativeButton("Cancel", null)

        // create and show the alert dialog
        val dialog = builder.create()
        dialog.show()
        return pname
    }



    fun noRun(runNumber:Int,countballs:Int,countfourandSix:Int){
        ballsremaining=(remainingballs.toInt()-1).toString()
        /*bowler1over= (bowler1CountBalls.toInt()+countballs).toString()
        bowler2over= (bowler1CountBalls.toInt()+countballs).toString()
*/

        countball= Integer.parseInt(ballsremaining)
        if(matchType.equals("T20")){
            minuscountballs=120-countball
        }
        else if(matchType.equals("ODI")){
            minuscountballs=300-countball
        }

        countover=overCalculate(minuscountballs)
      //  team1run=(t1run.toInt()+runNumber).toString()
      //  team2run=(t2run.toInt()+runNumber).toString()

        /*countover=
                java.lang.Double.valueOf(Math.round(java.lang.Double.valueOf(java.lang.Double.parseDouble(t1run) / (balls as Double / 6.0)).toDouble() * 100.0).toDouble() / 100.0)
                    .toFloat()*/


        if(player1_check.isChecked && bowler1_check.isChecked ){
            /* //prun= (b1run.toInt()+runNumber).toString()
             pball= (b1ball.toInt()+runNumber).toString()*/
            /* bowlerover= (bowler1over.toInt()+countballs).toString()
             //bowlerrun= (bowler1run.toInt()+runNumber).toString()*/

            if(player1_check.text.toString().equals(t1p1name)){
               // //prun= (t1p1run.toInt()+runNumber).toString()
                pball= (t1p1balls.toInt()+countballs).toString()





               // myRef.child(matchid).child("team1").child("players").child("0").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team1").child("players").child("0").child("batting").child("B").setValue(pball)
               // //count4And6(countfourandSix,t1p14s,t1p16s,"0","team1")

            }
            else if(player1_check.text.toString().equals(t1p2name)){
               // //prun= (t1p2run.toInt()+runNumber).toString()
                pball= (t1p2balls.toInt()+countballs).toString()

               // myRef.child(matchid).child("team1").child("players").child("1").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team1").child("players").child("1").child("batting").child("B").setValue(pball)
               // //count4And6(countfourandSix,t1p24s,t1p26s,"1","team1")


            }
            else if(player1_check.text.toString().equals(t1p3name)){
              //  //prun= (t1p3run.toInt()+runNumber).toString()
                pball= (t1p3balls.toInt()+countballs).toString()

               // myRef.child(matchid).child("team1").child("players").child("2").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team1").child("players").child("2").child("batting").child("B").setValue(pball)
               // //count4And6(countfourandSix,t1p34s,t1p36s,"2","team1")

            }

            else if(player1_check.text.toString().equals(t1p4name)){
               // //prun= (t1p4run.toInt()+runNumber).toString()
                pball= (t1p4balls.toInt()+countballs).toString()

              //  myRef.child(matchid).child("team1").child("players").child("3").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team1").child("players").child("3").child("batting").child("B").setValue(pball)
                //count4And6(countfourandSix,t1p44s,t1p46s,"3","team1")


            }
            else if(player1_check.text.toString().equals(t1p5name)){
                //prun= (t1p5run.toInt()+runNumber).toString()
                pball= (t1p5balls.toInt()+countballs).toString()

              //  myRef.child(matchid).child("team1").child("players").child("4").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team1").child("players").child("4").child("batting").child("B").setValue(pball)
                //count4And6(countfourandSix,t1p54s,t1p56s,"4","team1")

            }
            else if(player1_check.text.toString().equals(t1p6name)){
                //prun= (t1p6run.toInt()+runNumber).toString()
                pball= (t1p6balls.toInt()+countballs).toString()

             //   myRef.child(matchid).child("team1").child("players").child("5").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team1").child("players").child("5").child("batting").child("B").setValue(pball)
                //count4And6(countfourandSix,t1p64s,t1p66s,"5","team1")

            }
            else if(player1_check.text.toString().equals(t1p7name)){
                //prun= (t1p7run.toInt()+runNumber).toString()
                pball= (t1p7balls.toInt()+countballs).toString()

              //  myRef.child(matchid).child("team1").child("players").child("6").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team1").child("players").child("6").child("batting").child("B").setValue(pball)
                //count4And6(countfourandSix,t1p74s,t1p76s,"6","team1")

            }
            else if(player1_check.text.toString().equals(t1p8name)){
                //prun= (t1p8run.toInt()+runNumber).toString()
                pball= (t1p8balls.toInt()+countballs).toString()

               // myRef.child(matchid).child("team1").child("players").child("7").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team1").child("players").child("7").child("batting").child("B").setValue(pball)
                //count4And6(countfourandSix,t1p84s,t1p86s,"7","team1")

            }
            else if(player1_check.text.toString().equals(t1p9name)){
                //prun= (t1p9run.toInt()+runNumber).toString()
                pball= (t1p9balls.toInt()+countballs).toString()

              //  myRef.child(matchid).child("team1").child("players").child("8").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team1").child("players").child("8").child("batting").child("B").setValue(pball)
                //count4And6(countfourandSix,t1p94s,t1p96s,"8","team1")

            }
            else if(player1_check.text.toString().equals(t1p10name)){
                //prun= (t1p10run.toInt()+runNumber).toString()
                pball= (t1p10balls.toInt()+countballs).toString()

              //  myRef.child(matchid).child("team1").child("players").child("9").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team1").child("players").child("9").child("batting").child("B").setValue(pball)
                //count4And6(countfourandSix,t1p104s,t1p106s,"9","team1")

            }
            else if(player1_check.text.toString().equals(t1p11name)){
                //prun= (t1p11run.toInt()+runNumber).toString()
                pball= (t1p11balls.toInt()+countballs).toString()

             //   myRef.child(matchid).child("team1").child("players").child("10").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team1").child("players").child("10").child("batting").child("B").setValue(pball)
                //count4And6(countfourandSix,t1p114s,t1p116s,"10","team1")

            }
            else if(player1_check.text.toString().equals(t1p12name)){
                //prun= (t1p12run.toInt()+runNumber).toString()
                pball= (t1p12balls.toInt()+countballs).toString()

             //   myRef.child(matchid).child("team1").child("players").child("11").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team1").child("players").child("11").child("batting").child("B").setValue(pball)
                //count4And6(countfourandSix,t1p124s,t1p126s,"11","team1")

            }

            if(player1_check.text.toString().equals(t2p1name)){
                //prun= (t2p1run.toInt()+runNumber).toString()
                pball= (t2p1balls.toInt()+countballs).toString()

              //  myRef.child(matchid).child("team2").child("players").child("0").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team2").child("players").child("0").child("batting").child("B").setValue(pball)
                //count4And6(countfourandSix,t2p14s,t2p16s,"0","team2")

            }
            else if(player1_check.text.toString().equals(t2p2name)){
                //prun= (t2p2run.toInt()+runNumber).toString()
                pball= (t2p2balls.toInt()+countballs).toString()

            //    myRef.child(matchid).child("team2").child("players").child("1").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team2").child("players").child("1").child("batting").child("B").setValue(pball)
                //count4And6(countfourandSix,t2p24s,t2p26s,"1","team2")

            }
            else if(player1_check.text.toString().equals(t2p3name)){
                //prun= (t2p3run.toInt()+runNumber).toString()
                pball= (t2p3balls.toInt()+countballs).toString()

             //   myRef.child(matchid).child("team2").child("players").child("2").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team2").child("players").child("2").child("batting").child("B").setValue(pball)
                //count4And6(countfourandSix,t2p34s,t2p36s,"2","team2")

            }
            else if(player1_check.text.toString().equals(t2p4name)){
                //prun= (t2p4run.toInt()+runNumber).toString()
                pball= (t2p4balls.toInt()+countballs).toString()

              //  myRef.child(matchid).child("team2").child("players").child("3").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team2").child("players").child("3").child("batting").child("B").setValue(pball)
                //count4And6(countfourandSix,t2p44s,t2p46s,"3","team2")

            }
            else if(player1_check.text.toString().equals(t2p5name)){
                //prun= (t2p5run.toInt()+runNumber).toString()
                pball= (t2p5balls.toInt()+countballs).toString()

              //  myRef.child(matchid).child("team2").child("players").child("4").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team2").child("players").child("4").child("batting").child("B").setValue(pball)
                //count4And6(countfourandSix,t2p54s,t2p56s,"4","team2")

            }
            else if(player1_check.text.toString().equals(t2p6name)){
                //prun= (t2p6run.toInt()+runNumber).toString()
                pball= (t2p6balls.toInt()+countballs).toString()

               // myRef.child(matchid).child("team2").child("players").child("5").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team2").child("players").child("5").child("batting").child("B").setValue(pball)
                //count4And6(countfourandSix,t2p64s,t2p66s,"5","team2")

            }
            else if(player1_check.text.toString().equals(t2p7name)){
                //prun= (t2p7run.toInt()+runNumber).toString()
                pball= (t2p7balls.toInt()+countballs).toString()

             //   myRef.child(matchid).child("team2").child("players").child("6").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team2").child("players").child("6").child("batting").child("B").setValue(pball)
                //count4And6(countfourandSix,t2p74s,t2p76s,"6","team2")

            }
            else if(player1_check.text.toString().equals(t2p8name)){
                //prun= (t2p8run.toInt()+runNumber).toString()
                pball= (t2p8balls.toInt()+countballs).toString()

             //   myRef.child(matchid).child("team2").child("players").child("7").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team2").child("players").child("7").child("batting").child("B").setValue(pball)
                //count4And6(countfourandSix,t2p84s,t2p86s,"7","team2")

            }
            else if(player1_check.text.toString().equals(t2p9name)){
                //prun= (t2p9run.toInt()+runNumber).toString()
                pball= (t2p9balls.toInt()+countballs).toString()

            //    myRef.child(matchid).child("team2").child("players").child("8").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team2").child("players").child("8").child("batting").child("B").setValue(pball)
                //count4And6(countfourandSix,t2p94s,t2p96s,"8","team2")

            }
            else if(player1_check.text.toString().equals(t2p10name)){
                //prun= (t2p10run.toInt()+runNumber).toString()
                pball= (t2p10balls.toInt()+countballs).toString()

            //    myRef.child(matchid).child("team2").child("players").child("9").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team2").child("players").child("9").child("batting").child("B").setValue(pball)
                //count4And6(countfourandSix,t2p104s,t2p106s,"9","team2")

            }
            else if(player1_check.text.toString().equals(t2p11name)){
                //prun= (t2p11run.toInt()+runNumber).toString()
                pball= (t2p11balls.toInt()+countballs).toString()

             //   myRef.child(matchid).child("team2").child("players").child("10").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team2").child("players").child("10").child("batting").child("B").setValue(pball)
                //count4And6(countfourandSix,t2p114s,t2p116s,"10","team2")

            }
            else if(player1_check.text.toString().equals(t2p12name)){
                //prun= (t2p12run.toInt()+runNumber).toString()
                pball= (t2p12balls.toInt()+countballs).toString()

              //  myRef.child(matchid).child("team2").child("players").child("11").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team2").child("players").child("11").child("batting").child("B").setValue(pball)

                //count4And6(countfourandSix,t2p124s,t2p126s,"11","team2")

            }

            if(bowler1_check.text.toString().equals(t1p1name)){

                bowler1over= (bowler1CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler1CountBalls").setValue(bowler1over)

                bcountover=overCalculate(bowler1over.toInt())

                //bowlerrun= (t1b1run.toInt()+runNumber).toString()

             //   myRef.child(matchid).child("team1").child("players").child("0").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team1").child("players").child("0").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler1_check.text.toString().equals(t1p2name)){
                bowler1over= (bowler1CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler1CountBalls").setValue(bowler1over)

                bcountover=overCalculate(bowler1over.toInt())
                //bowlerrun= (t1b2run.toInt()+runNumber).toString()

             //   myRef.child(matchid).child("team1").child("players").child("1").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team1").child("players").child("1").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler1_check.text.toString().equals(t1p3name)){
                bowler1over= (bowler1CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler1CountBalls").setValue(bowler1over)

                bcountover=overCalculate(bowler1over.toInt())
                //bowlerrun= (t1b3run.toInt()+runNumber).toString()

             //   myRef.child(matchid).child("team1").child("players").child("2").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team1").child("players").child("2").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler1_check.text.toString().equals(t1p4name)){
                bowler1over= (bowler1CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler1CountBalls").setValue(bowler1over)

                bcountover=overCalculate(bowler1over.toInt())
                //bowlerrun= (t1b4run.toInt()+runNumber).toString()

              //  myRef.child(matchid).child("team1").child("players").child("3").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team1").child("players").child("3").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler1_check.text.toString().equals(t1p5name)){
                bowler1over= (bowler1CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler1CountBalls").setValue(bowler1over)

                bcountover=overCalculate(bowler1over.toInt())
                //bowlerrun= (t1b5run.toInt()+runNumber).toString()

              //  myRef.child(matchid).child("team1").child("players").child("4").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team1").child("players").child("4").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler1_check.text.toString().equals(t1p6name)){
                bowler1over= (bowler1CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler1CountBalls").setValue(bowler1over)

                bcountover=overCalculate(bowler1over.toInt())
                //bowlerrun= (t1b6run.toInt()+runNumber).toString()

              //  myRef.child(matchid).child("team1").child("players").child("5").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team1").child("players").child("5").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler1_check.text.toString().equals(t1p7name)){
                bowler1over= (bowler1CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler1CountBalls").setValue(bowler1over)

                bcountover=overCalculate(bowler1over.toInt())
                //bowlerrun= (t1b7run.toInt()+runNumber).toString()

              //  myRef.child(matchid).child("team1").child("players").child("6").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team1").child("players").child("6").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler1_check.text.toString().equals(t1p8name)){
                bowler1over= (bowler1CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler1CountBalls").setValue(bowler1over)

                bcountover=overCalculate(bowler1over.toInt())
                //bowlerrun= (t1b8run.toInt()+runNumber).toString()

              //  myRef.child(matchid).child("team1").child("players").child("7").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team1").child("players").child("7").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler1_check.text.toString().equals(t1p9name)){
                bowler1over= (bowler1CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler1CountBalls").setValue(bowler1over)

                bcountover=overCalculate(bowler1over.toInt())
                //bowlerrun= (t1b9run.toInt()+runNumber).toString()

             //   myRef.child(matchid).child("team1").child("players").child("8").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team1").child("players").child("8").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler1_check.text.toString().equals(t1p10name)){
                bowler1over= (bowler1CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler1CountBalls").setValue(bowler1over)

                bcountover=overCalculate(bowler1over.toInt())
                //bowlerrun= (t1b10run.toInt()+runNumber).toString()

            //    myRef.child(matchid).child("team1").child("players").child("9").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team1").child("players").child("9").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler1_check.text.toString().equals(t1p11name)){
                bowler1over= (bowler1CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler1CountBalls").setValue(bowler1over)

                bcountover=overCalculate(bowler1over.toInt())
                //bowlerrun= (t1b11run.toInt()+runNumber).toString()

             //   myRef.child(matchid).child("team1").child("players").child("10").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team1").child("players").child("10").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler1_check.text.toString().equals(t1p12name)){
                bowler1over= (bowler1CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler1CountBalls").setValue(bowler1over)

                bcountover=overCalculate(bowler1over.toInt())
                //bowlerrun= (t1b12run.toInt()+runNumber).toString()

              //  myRef.child(matchid).child("team1").child("players").child("11").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team1").child("players").child("11").child("bowling").child("O").setValue(bcountover)
            }

            if(bowler1_check.text.toString().equals(t2p1name)){
                bowler1over= (bowler1CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler1CountBalls").setValue(bowler1over)

                bcountover=overCalculate(bowler1over.toInt())
                //bowlerrun= (t2b1run.toInt()+runNumber).toString()

              //  myRef.child(matchid).child("team2").child("players").child("0").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team2").child("players").child("0").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler1_check.text.toString().equals(t2p2name)){
                bowler1over= (bowler1CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler1CountBalls").setValue(bowler1over)

                bcountover=overCalculate(bowler1over.toInt())
                //bowlerrun= (t2b2run.toInt()+runNumber).toString()

             //   myRef.child(matchid).child("team2").child("players").child("1").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team2").child("players").child("1").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler1_check.text.toString().equals(t2p3name)){
                bowler1over= (bowler1CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler1CountBalls").setValue(bowler1over)

                bcountover=overCalculate(bowler1over.toInt())
                //bowlerrun= (t2b3run.toInt()+runNumber).toString()

             //   myRef.child(matchid).child("team2").child("players").child("2").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team2").child("players").child("2").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler1_check.text.toString().equals(t2p4name)){
                bowler1over= (bowler1CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler1CountBalls").setValue(bowler1over)

                bcountover=overCalculate(bowler1over.toInt())
                //bowlerrun= (t2b4run.toInt()+runNumber).toString()

             //   myRef.child(matchid).child("team2").child("players").child("3").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team2").child("players").child("3").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler1_check.text.toString().equals(t2p5name)){
                bowler1over= (bowler1CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler1CountBalls").setValue(bowler1over)

                bcountover=overCalculate(bowler1over.toInt())
                //bowlerrun= (t2b5run.toInt()+runNumber).toString()

              //  myRef.child(matchid).child("team2").child("players").child("4").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team2").child("players").child("4").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler1_check.text.toString().equals(t2p6name)){
                bowler1over= (bowler1CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler1CountBalls").setValue(bowler1over)

                bcountover=overCalculate(bowler1over.toInt())
                //bowlerrun= (t2b6run.toInt()+runNumber).toString()

              //  myRef.child(matchid).child("team2").child("players").child("5").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team2").child("players").child("5").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler1_check.text.toString().equals(t2p7name)){
                bowler1over= (bowler1CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler1CountBalls").setValue(bowler1over)

                bcountover=overCalculate(bowler1over.toInt())
                //bowlerrun= (t2b7run.toInt()+runNumber).toString()

             //   myRef.child(matchid).child("team2").child("players").child("6").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team2").child("players").child("6").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler1_check.text.toString().equals(t2p8name)){
                bowler1over= (bowler1CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler1CountBalls").setValue(bowler1over)

                bcountover=overCalculate(bowler1over.toInt())
                //bowlerrun= (t2b8run.toInt()+runNumber).toString()

               // myRef.child(matchid).child("team2").child("players").child("7").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team2").child("players").child("7").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler1_check.text.toString().equals(t2p9name)){
                bowler1over= (bowler1CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler1CountBalls").setValue(bowler1over)

                bcountover=overCalculate(bowler1over.toInt())
                //bowlerrun= (t2b9run.toInt()+runNumber).toString()

               // myRef.child(matchid).child("team2").child("players").child("8").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team2").child("players").child("8").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler1_check.text.toString().equals(t2p10name)){
                bowler1over= (bowler1CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler1CountBalls").setValue(bowler1over)

                bcountover=overCalculate(bowler1over.toInt())
                //bowlerrun= (t2b10run.toInt()+runNumber).toString()

              //  myRef.child(matchid).child("team2").child("players").child("9").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team2").child("players").child("9").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler1_check.text.toString().equals(t2p11name)){
                bowler1over= (bowler1CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler1CountBalls").setValue(bowler1over)

                bcountover=overCalculate(bowler1over.toInt())
                //bowlerrun= (t2b11run.toInt()+runNumber).toString()

               // myRef.child(matchid).child("team2").child("players").child("10").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team2").child("players").child("10").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler1_check.text.toString().equals(t2p12name)){
                bowler1over= (bowler1CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler1CountBalls").setValue(bowler1over)

                bcountover=overCalculate(bowler1over.toInt())
                //bowlerrun= (t2b12run.toInt()+runNumber).toString()

               // myRef.child(matchid).child("team2").child("players").child("11").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team2").child("players").child("11").child("bowling").child("O").setValue(bcountover)
            }

            //countballs=(remainingballs.toInt()+countballs).toString()

            Log.d("bharti11", "Value b1 is: $prun")

            /*myRef.child(matchid).child("Batsman").child("b1").child("R").setValue(prun)
            myRef.child(matchid).child("Batsman").child("b1").child("B").setValue(pball)
            myRef.child(matchid).child("Bowling").child("bowler1").child("R").setValue(bowlerrun)
            myRef.child(matchid).child("Bowling").child("bowler1").child("O").setValue(bowlerover)
*/
            /* if(choosebattingteam.equals(t1name)){
                 myRef.child(matchid).child("team1").child("run").setValue(team1run)
                 myRef.child(matchid).child("team1").child("over").setValue(countover)
 
             }else{
                 myRef.child(matchid).child("team2").child("run").setValue(team2run)
                 myRef.child(matchid).child("team2").child("over").setValue(countover)
 
             }
 */
            Toast.makeText(this,"player1 run"+" "+prun,Toast.LENGTH_SHORT).show()

        }
        else if(player1_check.isChecked && bowler2_check.isChecked  ){
            /* //prun= (b1run.toInt()+runNumber).toString()
             pball= (b1ball.toInt()+runNumber).toString()
             bowlerover= (bowler2over.toInt()+countballs).toString()
             //bowlerrun= (bowler2run.toInt()+runNumber).toString()*/
            /* team1run=(t1run.toInt()+runNumber).toString()
             team2run=(t2run.toInt()+runNumber).toString()*/

            Log.d("bharti11", "Value b1 is: $prun")
            if(player1_check.text.toString().equals(t1p1name)){
                //prun= (t1p1run.toInt()+runNumber).toString()
                pball= (t1p1balls.toInt()+countballs).toString()

               // myRef.child(matchid).child("team1").child("players").child("0").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team1").child("players").child("0").child("batting").child("B").setValue(pball)
                //count4And6(countfourandSix,t1p14s,t1p16s,"0","team1")

            }
            else if(player1_check.text.toString().equals(t1p2name)){
                //prun= (t1p2run.toInt()+runNumber).toString()
                pball= (t1p2balls.toInt()+countballs).toString()

               // myRef.child(matchid).child("team1").child("players").child("1").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team1").child("players").child("1").child("batting").child("B").setValue(pball)
                //count4And6(countfourandSix,t1p24s,t1p26s,"1","team1")

            }
            else if(player1_check.text.toString().equals(t1p3name)){
                //prun= (t1p3run.toInt()+runNumber).toString()
                pball= (t1p3balls.toInt()+countballs).toString()

               // myRef.child(matchid).child("team1").child("players").child("2").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team1").child("players").child("2").child("batting").child("B").setValue(pball)
                //count4And6(countfourandSix,t1p34s,t1p36s,"2","team1")

            }
            else if(player1_check.text.toString().equals(t1p4name)){
                //prun= (t1p4run.toInt()+runNumber).toString()
                pball= (t1p4balls.toInt()+countballs).toString()

              //  myRef.child(matchid).child("team1").child("players").child("3").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team1").child("players").child("3").child("batting").child("B").setValue(pball)
                //count4And6(countfourandSix,t1p44s,t1p46s,"3","team1")

            }
            else if(player1_check.text.toString().equals(t1p5name)){
                //prun= (t1p5run.toInt()+runNumber).toString()
                pball= (t1p5balls.toInt()+countballs).toString()

             //   myRef.child(matchid).child("team1").child("players").child("4").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team1").child("players").child("4").child("batting").child("B").setValue(pball)
                //count4And6(countfourandSix,t1p54s,t1p56s,"4","team1")

            }
            else if(player1_check.text.toString().equals(t1p6name)){
                //prun= (t1p6run.toInt()+runNumber).toString()
                pball= (t1p6balls.toInt()+countballs).toString()

              //  myRef.child(matchid).child("team1").child("players").child("5").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team1").child("players").child("5").child("batting").child("B").setValue(pball)
                //count4And6(countfourandSix,t1p64s,t1p66s,"5","team1")

            }
            else if(player1_check.text.toString().equals(t1p7name)){
                //prun= (t1p7run.toInt()+runNumber).toString()
                pball= (t1p7balls.toInt()+countballs).toString()

              //  myRef.child(matchid).child("team1").child("players").child("6").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team1").child("players").child("6").child("batting").child("B").setValue(pball)
                //count4And6(countfourandSix,t1p74s,t1p76s,"6","team1")

            }
            else if(player1_check.text.toString().equals(t1p8name)){
                //prun= (t1p8run.toInt()+runNumber).toString()
                pball= (t1p8balls.toInt()+countballs).toString()

              //  myRef.child(matchid).child("team1").child("players").child("7").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team1").child("players").child("7").child("batting").child("B").setValue(pball)
                //count4And6(countfourandSix,t1p84s,t1p86s,"7","team1")

            }
            else if(player1_check.text.toString().equals(t1p9name)){
                //prun= (t1p9run.toInt()+runNumber).toString()
                pball= (t1p9balls.toInt()+countballs).toString()

              //  myRef.child(matchid).child("team1").child("players").child("8").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team1").child("players").child("8").child("batting").child("B").setValue(pball)
                //count4And6(countfourandSix,t1p94s,t1p96s,"8","team1")

            }
            else if(player1_check.text.toString().equals(t1p10name)){
                //prun= (t1p10run.toInt()+runNumber).toString()
                pball= (t1p10balls.toInt()+countballs).toString()

              //  myRef.child(matchid).child("team1").child("players").child("9").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team1").child("players").child("9").child("batting").child("B").setValue(pball)
                //count4And6(countfourandSix,t1p104s,t1p106s,"9","team1")

            }
            else if(player1_check.text.toString().equals(t1p11name)){
                //prun= (t1p11run.toInt()+runNumber).toString()
                pball= (t1p11balls.toInt()+countballs).toString()

              //  myRef.child(matchid).child("team1").child("players").child("10").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team1").child("players").child("10").child("batting").child("B").setValue(pball)
                //count4And6(countfourandSix,t1p114s,t1p116s,"10","team1")

            }
            else if(player1_check.text.toString().equals(t1p12name)){
                //prun= (t1p12run.toInt()+runNumber).toString()
                pball= (t1p12balls.toInt()+countballs).toString()

               // myRef.child(matchid).child("team1").child("players").child("11").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team1").child("players").child("11").child("batting").child("B").setValue(pball)
                //count4And6(countfourandSix,t1p124s,t1p126s,"11","team1")

            }

            if(player1_check.text.toString().equals(t2p1name)){
                //prun= (t2p1run.toInt()+runNumber).toString()
                pball= (t2p1balls.toInt()+countballs).toString()

               // myRef.child(matchid).child("team2").child("players").child("0").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team2").child("players").child("0").child("batting").child("B").setValue(pball)
                //count4And6(countfourandSix,t2p14s,t2p16s,"0","team2")

            }
            else if(player1_check.text.toString().equals(t2p2name)){
                //prun= (t2p2run.toInt()+runNumber).toString()
                pball= (t2p2balls.toInt()+countballs).toString()

               // myRef.child(matchid).child("team2").child("players").child("1").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team2").child("players").child("1").child("batting").child("B").setValue(pball)
                //count4And6(countfourandSix,t2p24s,t2p26s,"1","team2")

            }
            else if(player1_check.text.toString().equals(t2p3name)){
                //prun= (t2p3run.toInt()+runNumber).toString()
                pball= (t2p3balls.toInt()+countballs).toString()

               // myRef.child(matchid).child("team2").child("players").child("2").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team2").child("players").child("2").child("batting").child("B").setValue(pball)
                //count4And6(countfourandSix,t2p34s,t2p36s,"2","team2")

            }
            else if(player1_check.text.toString().equals(t2p4name)){
                //prun= (t2p4run.toInt()+runNumber).toString()
                pball= (t2p4balls.toInt()+countballs).toString()

               // myRef.child(matchid).child("team2").child("players").child("3").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team2").child("players").child("3").child("batting").child("B").setValue(pball)
                //count4And6(countfourandSix,t2p44s,t2p46s,"3","team2")

            }
            else if(player1_check.text.toString().equals(t2p5name)){
                //prun= (t2p5run.toInt()+runNumber).toString()
                pball= (t2p5balls.toInt()+countballs).toString()

               // myRef.child(matchid).child("team2").child("players").child("4").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team2").child("players").child("4").child("batting").child("B").setValue(pball)
                //count4And6(countfourandSix,t2p54s,t2p56s,"4","team2")

            }
            else if(player1_check.text.toString().equals(t2p6name)){
                //prun= (t2p6run.toInt()+runNumber).toString()
                pball= (t2p6balls.toInt()+countballs).toString()

               // myRef.child(matchid).child("team2").child("players").child("5").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team2").child("players").child("5").child("batting").child("B").setValue(pball)

                //count4And6(countfourandSix,t2p64s,t2p66s,"5","team2")

            }
            else if(player1_check.text.toString().equals(t2p7name)){
                //prun= (t2p7run.toInt()+runNumber).toString()
                pball= (t2p7balls.toInt()+countballs).toString()

               // myRef.child(matchid).child("team2").child("players").child("6").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team2").child("players").child("6").child("batting").child("B").setValue(pball)
                //count4And6(countfourandSix,t2p74s,t2p76s,"6","team2")

            }
            else if(player1_check.text.toString().equals(t2p8name)){
                //prun= (t2p8run.toInt()+runNumber).toString()
                pball= (t2p8balls.toInt()+countballs).toString()

              //  myRef.child(matchid).child("team2").child("players").child("7").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team2").child("players").child("7").child("batting").child("B").setValue(pball)
                //count4And6(countfourandSix,t2p84s,t2p86s,"7","team2")

            }
            else if(player1_check.text.toString().equals(t2p9name)){
                //prun= (t2p9run.toInt()+runNumber).toString()
                pball= (t2p9balls.toInt()+countballs).toString()

               // myRef.child(matchid).child("team2").child("players").child("8").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team2").child("players").child("8").child("batting").child("B").setValue(pball)
                //count4And6(countfourandSix,t2p94s,t2p96s,"8","team2")

            }
            else if(player1_check.text.toString().equals(t2p10name)){
                //prun= (t2p10run.toInt()+runNumber).toString()
                pball= (t2p10balls.toInt()+countballs).toString()

                //myRef.child(matchid).child("team2").child("players").child("9").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team2").child("players").child("9").child("batting").child("B").setValue(pball)
                //count4And6(countfourandSix,t2p104s,t2p106s,"9","team2")

            }
            else if(player1_check.text.toString().equals(t2p11name)){
                //prun= (t2p11run.toInt()+runNumber).toString()
                pball= (t2p11balls.toInt()+countballs).toString()

               // myRef.child(matchid).child("team2").child("players").child("10").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team2").child("players").child("10").child("batting").child("B").setValue(pball)
                //count4And6(countfourandSix,t2p114s,t2p116s,"10","team2")

            }
            else if(player1_check.text.toString().equals(t2p12name)){
                //prun= (t2p12run.toInt()+runNumber).toString()
                pball= (t2p12balls.toInt()+countballs).toString()

               // myRef.child(matchid).child("team2").child("players").child("11").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team2").child("players").child("11").child("batting").child("B").setValue(pball)
                //count4And6(countfourandSix,t2p124s,t2p126s,"11","team2")

            }

            if(bowler2_check.text.toString().equals(t1p1name)){
                bowler2over= (bowler2CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler2CountBalls").setValue(bowler2over)

                bcountover=overCalculate(bowler2over.toInt())
                //bowlerrun= (t1b1run.toInt()+runNumber).toString()

               // myRef.child(matchid).child("team1").child("players").child("0").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team1").child("players").child("0").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler2_check.text.toString().equals(t1p2name)){
                bowler2over= (bowler2CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler2CountBalls").setValue(bowler2over)

                bcountover=overCalculate(bowler2over.toInt())
                //bowlerrun= (t1b2run.toInt()+runNumber).toString()

               // myRef.child(matchid).child("team1").child("players").child("1").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team1").child("players").child("1").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler2_check.text.toString().equals(t1p3name)){
                bowler2over= (bowler2CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler2CountBalls").setValue(bowler2over)

                bcountover=overCalculate(bowler2over.toInt())
                //bowlerrun= (t1b3run.toInt()+runNumber).toString()

                //myRef.child(matchid).child("team1").child("players").child("2").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team1").child("players").child("2").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler2_check.text.toString().equals(t1p4name)){
                bowler2over= (bowler2CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler2CountBalls").setValue(bowler2over)

                bcountover=overCalculate(bowler2over.toInt())
                //bowlerrun= (t1b4run.toInt()+runNumber).toString()

                //myRef.child(matchid).child("team1").child("players").child("3").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team1").child("players").child("3").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler2_check.text.toString().equals(t1p5name)){
                bowler2over= (bowler2CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler2CountBalls").setValue(bowler2over)

                bcountover=overCalculate(bowler2over.toInt())
                //bowlerrun= (t1b5run.toInt()+runNumber).toString()

               // myRef.child(matchid).child("team1").child("players").child("4").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team1").child("players").child("4").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler2_check.text.toString().equals(t1p6name)){
                bowler2over= (bowler2CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler2CountBalls").setValue(bowler2over)

                bcountover=overCalculate(bowler2over.toInt())
                //bowlerrun= (t1b6run.toInt()+runNumber).toString()

                //myRef.child(matchid).child("team1").child("players").child("5").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team1").child("players").child("5").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler2_check.text.toString().equals(t1p7name)){
                bowler2over= (bowler2CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler2CountBalls").setValue(bowler2over)

                bcountover=overCalculate(bowler2over.toInt())
                //bowlerrun= (t1b7run.toInt()+runNumber).toString()

                //myRef.child(matchid).child("team1").child("players").child("6").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team1").child("players").child("6").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler2_check.text.toString().equals(t1p8name)){
                bowler2over= (bowler2CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler2CountBalls").setValue(bowler2over)

                bcountover=overCalculate(bowler2over.toInt())
                //bowlerrun= (t1b8run.toInt()+runNumber).toString()

                //myRef.child(matchid).child("team1").child("players").child("7").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team1").child("players").child("7").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler2_check.text.toString().equals(t1p9name)){
                bowler2over= (bowler2CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler2CountBalls").setValue(bowler2over)

                bcountover=overCalculate(bowler2over.toInt())
                //bowlerrun= (t1b9run.toInt()+runNumber).toString()

               // myRef.child(matchid).child("team1").child("players").child("8").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team1").child("players").child("8").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler2_check.text.toString().equals(t1p10name)){
                bowler2over= (bowler2CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler2CountBalls").setValue(bowler2over)

                bcountover=overCalculate(bowler2over.toInt())
                //bowlerrun= (t1b10run.toInt()+runNumber).toString()

               // myRef.child(matchid).child("team1").child("players").child("9").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team1").child("players").child("9").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler2_check.text.toString().equals(t1p11name)){
                bowler2over= (bowler2CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler2CountBalls").setValue(bowler2over)

                bcountover=overCalculate(bowler2over.toInt())
                //bowlerrun= (t1b11run.toInt()+runNumber).toString()

                //myRef.child(matchid).child("team1").child("players").child("10").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team1").child("players").child("10").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler2_check.text.toString().equals(t1p12name)){
                bowler2over= (bowler2CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler2CountBalls").setValue(bowler2over)

                bcountover=overCalculate(bowler2over.toInt())
                //bowlerrun= (t1b12run.toInt()+runNumber).toString()

               // myRef.child(matchid).child("team1").child("players").child("11").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team1").child("players").child("11").child("bowling").child("O").setValue(bcountover)
            }

            if(bowler2_check.text.toString().equals(t2p1name)){
                bowler2over= (bowler2CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler2CountBalls").setValue(bowler2over)

                bcountover=overCalculate(bowler2over.toInt())
                //bowlerrun= (t2b1run.toInt()+runNumber).toString()

               // myRef.child(matchid).child("team2").child("players").child("0").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team2").child("players").child("0").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler2_check.text.toString().equals(t2p2name)){
                bowler2over= (bowler2CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler2CountBalls").setValue(bowler2over)

                bcountover=overCalculate(bowler2over.toInt())
                //bowlerrun= (t2b2run.toInt()+runNumber).toString()

                //myRef.child(matchid).child("team2").child("players").child("1").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team2").child("players").child("1").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler2_check.text.toString().equals(t2p3name)){
                bowler2over= (bowler2CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler2CountBalls").setValue(bowler2over)

                bcountover=overCalculate(bowler2over.toInt())
                //bowlerrun= (t2b3run.toInt()+runNumber).toString()

                //myRef.child(matchid).child("team2").child("players").child("2").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team2").child("players").child("2").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler2_check.text.toString().equals(t2p4name)){
                bowler2over= (bowler2CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler2CountBalls").setValue(bowler2over)

                bcountover=overCalculate(bowler2over.toInt())
                //bowlerrun= (t2b4run.toInt()+runNumber).toString()

                //myRef.child(matchid).child("team2").child("players").child("3").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team2").child("players").child("3").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler2_check.text.toString().equals(t2p5name)){
                bowler2over= (bowler2CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler2CountBalls").setValue(bowler2over)

                bcountover=overCalculate(bowler2over.toInt())
                //bowlerrun= (t2b5run.toInt()+runNumber).toString()

                //myRef.child(matchid).child("team2").child("players").child("4").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team2").child("players").child("4").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler2_check.text.toString().equals(t2p6name)){
                bowler2over= (bowler2CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler2CountBalls").setValue(bowler2over)

                bcountover=overCalculate(bowler2over.toInt())
                //bowlerrun= (t2b6run.toInt()+runNumber).toString()

                //myRef.child(matchid).child("team2").child("players").child("5").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team2").child("players").child("5").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler2_check.text.toString().equals(t2p7name)){
                bowler2over= (bowler2CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler2CountBalls").setValue(bowler2over)

                bcountover=overCalculate(bowler2over.toInt())
                //bowlerrun= (t2b7run.toInt()+runNumber).toString()

              //  myRef.child(matchid).child("team2").child("players").child("6").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team2").child("players").child("6").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler2_check.text.toString().equals(t2p8name)){
                bowler2over= (bowler2CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler2CountBalls").setValue(bowler2over)

                bcountover=overCalculate(bowler2over.toInt())
                //bowlerrun= (t2b8run.toInt()+runNumber).toString()

              //  myRef.child(matchid).child("team2").child("players").child("7").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team2").child("players").child("7").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler2_check.text.toString().equals(t2p9name)){
                bowler2over= (bowler2CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler2CountBalls").setValue(bowler2over)

                bcountover=overCalculate(bowler2over.toInt())
                //bowlerrun= (t2b9run.toInt()+runNumber).toString()

               // myRef.child(matchid).child("team2").child("players").child("8").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team2").child("players").child("8").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler2_check.text.toString().equals(t2p10name)){
                bowler2over= (bowler2CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler2CountBalls").setValue(bowler2over)

                bcountover=overCalculate(bowler2over.toInt())
                //bowlerrun= (t2b10run.toInt()+runNumber).toString()

               // myRef.child(matchid).child("team2").child("players").child("9").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team2").child("players").child("9").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler2_check.text.toString().equals(t2p11name)){
                bowler2over= (bowler2CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler2CountBalls").setValue(bowler2over)

                bcountover=overCalculate(bowler2over.toInt())
                //bowlerrun= (t2b11run.toInt()+runNumber).toString()

                //myRef.child(matchid).child("team2").child("players").child("10").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team2").child("players").child("10").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler2_check.text.toString().equals(t2p12name)){
                bowler2over= (bowler2CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler2CountBalls").setValue(bowler2over)

                bcountover=overCalculate(bowler2over.toInt())
                //bowlerrun= (t2b12run.toInt()+runNumber).toString()

               // myRef.child(matchid).child("team2").child("players").child("11").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team2").child("players").child("11").child("bowling").child("O").setValue(bcountover)
            }

            /*myRef.child(matchid).child("Batsman").child("b1").child("R").setValue(prun)
            myRef.child(matchid).child("Batsman").child("b1").child("B").setValue(pball)
            myRef.child(matchid).child("Bowling").child("bowler2").child("R").setValue(bowlerrun)
            myRef.child(matchid).child("Bowling").child("bowler2").child("O").setValue(bowlerover)
           */
            /*if(choosebattingteam.equals(t1name)){
                myRef.child(matchid).child("team1").child("run").setValue(team1run)
                myRef.child(matchid).child("team1").child("over").setValue(countover)


            }else{
                myRef.child(matchid).child("team2").child("run").setValue(team2run)
                myRef.child(matchid).child("team2").child("over").setValue(countover)

            }*/
            Toast.makeText(this,"player1 run"+" "+prun,Toast.LENGTH_SHORT).show()

        }
        else if(player2_check.isChecked && bowler1_check.isChecked){
            /*//prun= (b2run.toInt()+runNumber).toString()
            pball= (b2ball.toInt()+runNumber).toString()
            bowlerover= (bowler1over.toInt()+countballs).toString()
            //bowlerrun= (bowler1run.toInt()+runNumber).toString()*/
            /* team1run=(t1run.toInt()+runNumber).toString()
             team2run=(t2run.toInt()+runNumber).toString()*/

            Log.d("bharti11", "Value b2 is: $prun")

            if(player2_check.text.toString().equals(t1p1name)){
                //prun= (t1p1run.toInt()+runNumber).toString()
                pball= (t1p1balls.toInt()+countballs).toString()

              //  myRef.child(matchid).child("team1").child("players").child("0").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team1").child("players").child("0").child("batting").child("B").setValue(pball)
                //count4And6(countfourandSix,t1p14s,t1p16s,"0","team1")

            }
            else if(player2_check.text.toString().equals(t1p2name)){
                //prun= (t1p2run.toInt()+runNumber).toString()
                pball= (t1p2balls.toInt()+countballs).toString()

              //  myRef.child(matchid).child("team1").child("players").child("1").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team1").child("players").child("1").child("batting").child("B").setValue(pball)
                //count4And6(countfourandSix,t1p24s,t1p26s,"1","team1")

            }
            else if(player2_check.text.toString().equals(t1p3name)){
                //prun= (t1p3run.toInt()+runNumber).toString()
                pball= (t1p3balls.toInt()+countballs).toString()

                //myRef.child(matchid).child("team1").child("players").child("2").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team1").child("players").child("2").child("batting").child("B").setValue(pball)
                //count4And6(countfourandSix,t1p34s,t1p36s,"2","team1")

            }
            else if(player2_check.text.toString().equals(t1p4name)){
                //prun= (t1p4run.toInt()+runNumber).toString()
                pball= (t1p4balls.toInt()+countballs).toString()

               // myRef.child(matchid).child("team1").child("players").child("3").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team1").child("players").child("3").child("batting").child("B").setValue(pball)
                //count4And6(countfourandSix,t1p44s,t1p46s,"3","team1")

            }
            else if(player2_check.text.toString().equals(t1p5name)){
                //prun= (t1p5run.toInt()+runNumber).toString()
                pball= (t1p5balls.toInt()+countballs).toString()

               // myRef.child(matchid).child("team1").child("players").child("4").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team1").child("players").child("4").child("batting").child("B").setValue(pball)
                //count4And6(countfourandSix,t1p54s,t1p56s,"4","team1")

            }
            else if(player2_check.text.toString().equals(t1p6name)){
                //prun= (t1p6run.toInt()+runNumber).toString()
                pball= (t1p6balls.toInt()+countballs).toString()

               // myRef.child(matchid).child("team1").child("players").child("5").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team1").child("players").child("5").child("batting").child("B").setValue(pball)
                //count4And6(countfourandSix,t1p64s,t1p66s,"5","team1")

            }
            else if(player2_check.text.toString().equals(t1p7name)){
                //prun= (t1p7run.toInt()+runNumber).toString()
                pball= (t1p7balls.toInt()+countballs).toString()

              //  myRef.child(matchid).child("team1").child("players").child("6").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team1").child("players").child("6").child("batting").child("B").setValue(pball)
                //count4And6(countfourandSix,t1p74s,t1p76s,"6","team1")

            }
            else if(player2_check.text.toString().equals(t1p8name)){
                //prun= (t1p8run.toInt()+runNumber).toString()
                pball= (t1p8balls.toInt()+countballs).toString()

               // myRef.child(matchid).child("team1").child("players").child("7").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team1").child("players").child("7").child("batting").child("B").setValue(pball)
                //count4And6(countfourandSix,t1p84s,t1p86s,"7","team1")

            }
            else if(player2_check.text.toString().equals(t1p9name)){
                //prun= (t1p9run.toInt()+runNumber).toString()
                pball= (t1p9balls.toInt()+countballs).toString()

               // myRef.child(matchid).child("team1").child("players").child("8").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team1").child("players").child("8").child("batting").child("B").setValue(pball)
                //count4And6(countfourandSix,t1p94s,t1p96s,"8","team1")

            }
            else if(player2_check.text.toString().equals(t1p10name)){
                //prun= (t1p10run.toInt()+runNumber).toString()
                pball= (t1p10balls.toInt()+countballs).toString()

                //myRef.child(matchid).child("team1").child("players").child("9").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team1").child("players").child("9").child("batting").child("B").setValue(pball)
                //count4And6(countfourandSix,t1p104s,t1p106s,"9","team1")

            }
            else if(player2_check.text.toString().equals(t1p11name)){
                //prun= (t1p11run.toInt()+runNumber).toString()
                pball= (t1p11balls.toInt()+countballs).toString()

               // myRef.child(matchid).child("team1").child("players").child("10").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team1").child("players").child("10").child("batting").child("B").setValue(pball)
                //count4And6(countfourandSix,t1p114s,t1p116s,"10","team1")

            }
            else if(player2_check.text.toString().equals(t1p12name)){
                //prun= (t1p12run.toInt()+runNumber).toString()
                pball= (t1p12balls.toInt()+countballs).toString()

               // myRef.child(matchid).child("team1").child("players").child("11").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team1").child("players").child("11").child("batting").child("B").setValue(pball)
                //count4And6(countfourandSix,t1p124s,t1p126s,"11","team1")

            }

            if(player2_check.text.toString().equals(t2p1name)){
                //prun= (t2p1run.toInt()+runNumber).toString()
                pball= (t2p1balls.toInt()+countballs).toString()

               // myRef.child(matchid).child("team2").child("players").child("0").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team2").child("players").child("0").child("batting").child("B").setValue(pball)
                //count4And6(countfourandSix,t2p14s,t2p16s,"0","team2")

            }
            else if(player2_check.text.toString().equals(t2p2name)){
                //prun= (t2p2run.toInt()+runNumber).toString()
                pball= (t2p2balls.toInt()+countballs).toString()

               // myRef.child(matchid).child("team2").child("players").child("1").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team2").child("players").child("1").child("batting").child("B").setValue(pball)
                //count4And6(countfourandSix,t2p24s,t2p26s,"1","team2")

            }
            else if(player2_check.text.toString().equals(t2p3name)){
                //prun= (t2p3run.toInt()+runNumber).toString()
                pball= (t2p3balls.toInt()+countballs).toString()

               // myRef.child(matchid).child("team2").child("players").child("2").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team2").child("players").child("2").child("batting").child("B").setValue(pball)
                //count4And6(countfourandSix,t2p34s,t2p36s,"2","team2")

            }
            else if(player2_check.text.toString().equals(t2p4name)){
                //prun= (t2p4run.toInt()+runNumber).toString()
                pball= (t2p4balls.toInt()+countballs).toString()

               // myRef.child(matchid).child("team2").child("players").child("3").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team2").child("players").child("3").child("batting").child("B").setValue(pball)
                //count4And6(countfourandSix,t2p44s,t2p46s,"3","team2")

            }
            else if(player2_check.text.toString().equals(t2p5name)){
                //prun= (t2p5run.toInt()+runNumber).toString()
                pball= (t2p5balls.toInt()+countballs).toString()

                //myRef.child(matchid).child("team2").child("players").child("4").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team2").child("players").child("4").child("batting").child("B").setValue(pball)
                //count4And6(countfourandSix,t2p54s,t2p56s,"4","team2")

            }
            else if(player2_check.text.toString().equals(t2p6name)){
                //prun= (t2p6run.toInt()+runNumber).toString()
                pball= (t2p6balls.toInt()+countballs).toString()

                //myRef.child(matchid).child("team2").child("players").child("5").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team2").child("players").child("5").child("batting").child("B").setValue(pball)
                //count4And6(countfourandSix,t2p64s,t2p66s,"5","team2")

            }
            else if(player2_check.text.toString().equals(t2p7name)){
                //prun= (t2p7run.toInt()+runNumber).toString()
                pball= (t2p7balls.toInt()+countballs).toString()

               // myRef.child(matchid).child("team2").child("players").child("6").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team2").child("players").child("6").child("batting").child("B").setValue(pball)
                //count4And6(countfourandSix,t2p74s,t2p76s,"6","team2")

            }
            else if(player2_check.text.toString().equals(t2p8name)){
                //prun= (t2p8run.toInt()+runNumber).toString()
                pball= (t2p8balls.toInt()+countballs).toString()

               // myRef.child(matchid).child("team2").child("players").child("7").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team2").child("players").child("7").child("batting").child("B").setValue(pball)
                //count4And6(countfourandSix,t2p84s,t2p86s,"7","team2")

            }
            else if(player2_check.text.toString().equals(t2p9name)){
                //prun= (t2p9run.toInt()+runNumber).toString()
                pball= (t2p9balls.toInt()+countballs).toString()

               // myRef.child(matchid).child("team2").child("players").child("8").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team2").child("players").child("8").child("batting").child("B").setValue(pball)
                //count4And6(countfourandSix,t2p94s,t2p96s,"8","team2")

            }
            else if(player2_check.text.toString().equals(t2p10name)){
                //prun= (t2p10run.toInt()+runNumber).toString()
                pball= (t2p10balls.toInt()+countballs).toString()

               // myRef.child(matchid).child("team2").child("players").child("9").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team2").child("players").child("9").child("batting").child("B").setValue(pball)
                //count4And6(countfourandSix,t2p104s,t2p106s,"9","team2")

            }
            else if(player2_check.text.toString().equals(t2p11name)){
                //prun= (t2p11run.toInt()+runNumber).toString()
                pball= (t2p11balls.toInt()+countballs).toString()

               // myRef.child(matchid).child("team2").child("players").child("10").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team2").child("players").child("10").child("batting").child("B").setValue(pball)
                //count4And6(countfourandSix,t2p114s,t2p116s,"10","team2")

            }
            else if(player2_check.text.toString().equals(t2p12name)){
                //prun= (t2p12run.toInt()+runNumber).toString()
                pball= (t2p12balls.toInt()+countballs).toString()

               // myRef.child(matchid).child("team2").child("players").child("11").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team2").child("players").child("11").child("batting").child("B").setValue(pball)
                //count4And6(countfourandSix,t2p124s,t2p126s,"11","team2")

            }

            if(bowler1_check.text.toString().equals(t1p1name)){
                bowler1over= (bowler1CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler1CountBalls").setValue(bowler1over)

                bcountover=overCalculate(bowler1over.toInt())
                //bowlerrun= (t1b1run.toInt()+runNumber).toString()

               // myRef.child(matchid).child("team1").child("players").child("0").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team1").child("players").child("0").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler1_check.text.toString().equals(t1p2name)){
                bowler1over= (bowler1CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler1CountBalls").setValue(bowler1over)

                bcountover=overCalculate(bowler1over.toInt())
                //bowlerrun= (t1b2run.toInt()+runNumber).toString()

                //myRef.child(matchid).child("team1").child("players").child("1").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team1").child("players").child("1").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler1_check.text.toString().equals(t1p3name)){
                bowler1over= (bowler1CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler1CountBalls").setValue(bowler1over)

                bcountover=overCalculate(bowler1over.toInt())
                //bowlerrun= (t1b3run.toInt()+runNumber).toString()

                //myRef.child(matchid).child("team1").child("players").child("2").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team1").child("players").child("2").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler1_check.text.toString().equals(t1p4name)){
                bowler1over= (bowler1CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler1CountBalls").setValue(bowler1over)

                bcountover=overCalculate(bowler1over.toInt())
                //bowlerrun= (t1b4run.toInt()+runNumber).toString()

               // myRef.child(matchid).child("team1").child("players").child("3").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team1").child("players").child("3").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler1_check.text.toString().equals(t1p5name)){
                bowler1over= (bowler1CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler1CountBalls").setValue(bowler1over)

                bcountover=overCalculate(bowler1over.toInt())
                //bowlerrun= (t1b5run.toInt()+runNumber).toString()

              //  myRef.child(matchid).child("team1").child("players").child("4").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team1").child("players").child("4").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler1_check.text.toString().equals(t1p6name)){
                bowler1over= (bowler1CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler1CountBalls").setValue(bowler1over)

                bcountover=overCalculate(bowler1over.toInt())
                //bowlerrun= (t1b6run.toInt()+runNumber).toString()

               // myRef.child(matchid).child("team1").child("players").child("5").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team1").child("players").child("5").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler1_check.text.toString().equals(t1p7name)){
                bowler1over= (bowler1CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler1CountBalls").setValue(bowler1over)

                bcountover=overCalculate(bowler1over.toInt())
                //bowlerrun= (t1b7run.toInt()+runNumber).toString()

                //myRef.child(matchid).child("team1").child("players").child("6").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team1").child("players").child("6").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler1_check.text.toString().equals(t1p8name)){
                bowler1over= (bowler1CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler1CountBalls").setValue(bowler1over)

                bcountover=overCalculate(bowler1over.toInt())
                //bowlerrun= (t1b8run.toInt()+runNumber).toString()

                //myRef.child(matchid).child("team1").child("players").child("7").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team1").child("players").child("7").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler1_check.text.toString().equals(t1p9name)){
                bowler1over= (bowler1CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler1CountBalls").setValue(bowler1over)

                bcountover=overCalculate(bowler1over.toInt())
                //bowlerrun= (t1b9run.toInt()+runNumber).toString()

               // myRef.child(matchid).child("team1").child("players").child("8").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team1").child("players").child("8").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler1_check.text.toString().equals(t1p10name)){
                bowler1over= (bowler1CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler1CountBalls").setValue(bowler1over)

                bcountover=overCalculate(bowler1over.toInt())
                //bowlerrun= (t1b10run.toInt()+runNumber).toString()

               // myRef.child(matchid).child("team1").child("players").child("9").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team1").child("players").child("9").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler1_check.text.toString().equals(t1p11name)){
                bowler1over= (bowler1CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler1CountBalls").setValue(bowler1over)

                bcountover=overCalculate(bowler1over.toInt())
                //bowlerrun= (t1b11run.toInt()+runNumber).toString()

                //myRef.child(matchid).child("team1").child("players").child("10").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team1").child("players").child("10").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler1_check.text.toString().equals(t1p12name)){
                bowler1over= (bowler1CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler1CountBalls").setValue(bowler1over)

                bcountover=overCalculate(bowler1over.toInt())
                //bowlerrun= (t1b12run.toInt()+runNumber).toString()

                //myRef.child(matchid).child("team1").child("players").child("11").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team1").child("players").child("11").child("bowling").child("O").setValue(bcountover)
            }

            if(bowler1_check.text.toString().equals(t2p1name)){
                bowler1over= (bowler1CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler1CountBalls").setValue(bowler1over)

                bcountover=overCalculate(bowler1over.toInt())
                //bowlerrun= (t2b1run.toInt()+runNumber).toString()

               // myRef.child(matchid).child("team2").child("players").child("0").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team2").child("players").child("0").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler1_check.text.toString().equals(t2p2name)){
                bowler1over= (bowler1CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler1CountBalls").setValue(bowler1over)

                bcountover=overCalculate(bowler1over.toInt())
                //bowlerrun= (t2b2run.toInt()+runNumber).toString()

               // myRef.child(matchid).child("team2").child("players").child("1").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team2").child("players").child("1").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler1_check.text.toString().equals(t2p3name)){
                bowler1over= (bowler1CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler1CountBalls").setValue(bowler1over)

                bcountover=overCalculate(bowler1over.toInt())
                //bowlerrun= (t2b3run.toInt()+runNumber).toString()

                //myRef.child(matchid).child("team2").child("players").child("2").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team2").child("players").child("2").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler1_check.text.toString().equals(t2p4name)){
                bowler1over= (bowler1CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler1CountBalls").setValue(bowler1over)

                bcountover=overCalculate(bowler1over.toInt())
                //bowlerrun= (t2b4run.toInt()+runNumber).toString()

               // myRef.child(matchid).child("team2").child("players").child("3").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team2").child("players").child("3").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler1_check.text.toString().equals(t2p5name)){
                bowler1over= (bowler1CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler1CountBalls").setValue(bowler1over)

                bcountover=overCalculate(bowler1over.toInt())
                //bowlerrun= (t2b5run.toInt()+runNumber).toString()

               // myRef.child(matchid).child("team2").child("players").child("4").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team2").child("players").child("4").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler1_check.text.toString().equals(t2p6name)){
                bowler1over= (bowler1CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler1CountBalls").setValue(bowler1over)

                bcountover=overCalculate(bowler1over.toInt())
                //bowlerrun= (t2b6run.toInt()+runNumber).toString()

               // myRef.child(matchid).child("team2").child("players").child("5").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team2").child("players").child("5").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler1_check.text.toString().equals(t2p7name)){
                bowler1over= (bowler1CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler1CountBalls").setValue(bowler1over)

                bcountover=overCalculate(bowler1over.toInt())
                //bowlerrun= (t2b7run.toInt()+runNumber).toString()

                //myRef.child(matchid).child("team2").child("players").child("6").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team2").child("players").child("6").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler1_check.text.toString().equals(t2p8name)){
                bowler1over= (bowler1CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler1CountBalls").setValue(bowler1over)

                bcountover=overCalculate(bowler1over.toInt())
                //bowlerrun= (t2b8run.toInt()+runNumber).toString()

                //myRef.child(matchid).child("team2").child("players").child("7").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team2").child("players").child("7").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler1_check.text.toString().equals(t2p9name)){
                bowler1over= (bowler1CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler1CountBalls").setValue(bowler1over)

                bcountover=overCalculate(bowler1over.toInt())
                //bowlerrun= (t2b9run.toInt()+runNumber).toString()

               // myRef.child(matchid).child("team2").child("players").child("8").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team2").child("players").child("8").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler1_check.text.toString().equals(t2p10name)){
                bowler1over= (bowler1CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler1CountBalls").setValue(bowler1over)

                bcountover=overCalculate(bowler1over.toInt())
                //bowlerrun= (t2b10run.toInt()+runNumber).toString()

               // myRef.child(matchid).child("team2").child("players").child("9").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team2").child("players").child("9").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler1_check.text.toString().equals(t2p11name)){
                bowler1over= (bowler1CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler1CountBalls").setValue(bowler1over)

                bcountover=overCalculate(bowler1over.toInt())
                //bowlerrun= (t2b11run.toInt()+runNumber).toString()

               // myRef.child(matchid).child("team2").child("players").child("10").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team2").child("players").child("10").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler1_check.text.toString().equals(t2p12name)){
                bowler1over= (bowler1CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler1CountBalls").setValue(bowler1over)

                bcountover=overCalculate(bowler1over.toInt())
                //bowlerrun= (t2b12run.toInt()+runNumber).toString()

               // myRef.child(matchid).child("team2").child("players").child("11").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team2").child("players").child("11").child("bowling").child("O").setValue(bcountover)
            }

            /* myRef.child(matchid).child("Batsman").child("b2").child("R").setValue(prun)
             myRef.child(matchid).child("Batsman").child("b2").child("B").setValue(pball)
             myRef.child(matchid).child("Bowling").child("bowler1").child("R").setValue(bowlerrun)
             myRef.child(matchid).child("Bowling").child("bowler1").child("O").setValue(bowlerover)
            */
            /* if(choosebattingteam.equals(t1name)){
                 myRef.child(matchid).child("team1").child("run").setValue(team1run)
                 myRef.child(matchid).child("team1").child("over").setValue(countover)
                 if(inning.equals("2")){
                     myRef.child(matchid).child("remainingballs").setValue(ballsremaining)
 
                 }
             }else{
                 myRef.child(matchid).child("team2").child("run").setValue(team2run)
                 myRef.child(matchid).child("team2").child("over").setValue(countover)
                 if(inning.equals("2")){
                     myRef.child(matchid).child("remainingballs").setValue(ballsremaining)
 
                 }
             }*/
            Toast.makeText(this,"player2 run"+" "+prun,Toast.LENGTH_SHORT).show()

        }else if(player2_check.isChecked && bowler2_check.isChecked  ){
            /* //prun= (b2run.toInt()+runNumber).toString()
             pball= (b2ball.toInt()+runNumber).toString()
             bowlerover= (bowler2over.toInt()+countballs).toString()
             //bowlerrun= (bowler2run.toInt()+runNumber).toString()*/
            /*  team1run=(t1run.toInt()+runNumber).toString()
              team2run=(t2run.toInt()+runNumber).toString()
  */
            Log.d("bharti11", "Value b2 is: $prun")

            if(player2_check.text.toString().equals(t1p1name)){
                //prun= (t1p1run.toInt()+runNumber).toString()
                pball= (t1p1balls.toInt()+countballs).toString()

               // myRef.child(matchid).child("team1").child("players").child("0").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team1").child("players").child("0").child("batting").child("B").setValue(pball)
                //count4And6(countfourandSix,t1p14s,t1p16s,"0","team1")

            }
            else if(player2_check.text.toString().equals(t1p2name)){
                //prun= (t1p2run.toInt()+runNumber).toString()
                pball= (t1p2balls.toInt()+countballs).toString()

               // myRef.child(matchid).child("team1").child("players").child("1").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team1").child("players").child("1").child("batting").child("B").setValue(pball)
                //count4And6(countfourandSix,t1p24s,t1p26s,"1","team1")

            }
            else if(player2_check.text.toString().equals(t1p3name)){
                //prun= (t1p3run.toInt()+runNumber).toString()
                pball= (t1p3balls.toInt()+countballs).toString()

               // myRef.child(matchid).child("team1").child("players").child("2").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team1").child("players").child("2").child("batting").child("B").setValue(pball)
                //count4And6(countfourandSix,t1p34s,t1p36s,"2","team1")

            }
            else if(player2_check.text.toString().equals(t1p4name)){
                //prun= (t1p4run.toInt()+runNumber).toString()
                pball= (t1p4balls.toInt()+countballs).toString()

               // myRef.child(matchid).child("team1").child("players").child("3").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team1").child("players").child("3").child("batting").child("B").setValue(pball)
                //count4And6(countfourandSix,t1p44s,t1p46s,"3","team1")

            }
            else if(player2_check.text.toString().equals(t1p5name)){
                //prun= (t1p5run.toInt()+runNumber).toString()
                pball= (t1p5balls.toInt()+countballs).toString()

               // myRef.child(matchid).child("team1").child("players").child("4").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team1").child("players").child("4").child("batting").child("B").setValue(pball)
                //count4And6(countfourandSix,t1p54s,t1p56s,"4","team1")

            }
            else if(player2_check.text.toString().equals(t1p6name)){
                //prun= (t1p6run.toInt()+runNumber).toString()
                pball= (t1p6balls.toInt()+countballs).toString()

               // myRef.child(matchid).child("team1").child("players").child("5").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team1").child("players").child("5").child("batting").child("B").setValue(pball)
                //count4And6(countfourandSix,t1p64s,t1p66s,"5","team1")

            }
            else if(player2_check.text.toString().equals(t1p7name)){
                //prun= (t1p7run.toInt()+runNumber).toString()
                pball= (t1p7balls.toInt()+countballs).toString()

                //myRef.child(matchid).child("team1").child("players").child("6").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team1").child("players").child("6").child("batting").child("B").setValue(pball)
                //count4And6(countfourandSix,t1p74s,t1p76s,"6","team1")

            }
            else if(player2_check.text.toString().equals(t1p8name)){
                //prun= (t1p8run.toInt()+runNumber).toString()
                pball= (t1p8balls.toInt()+countballs).toString()

                //myRef.child(matchid).child("team1").child("players").child("7").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team1").child("players").child("7").child("batting").child("B").setValue(pball)
                //count4And6(countfourandSix,t1p84s,t1p86s,"7","team1")

            }
            else if(player2_check.text.toString().equals(t1p9name)){
                //prun= (t1p9run.toInt()+runNumber).toString()
                pball= (t1p9balls.toInt()+countballs).toString()

               // myRef.child(matchid).child("team1").child("players").child("8").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team1").child("players").child("8").child("batting").child("B").setValue(pball)
                //count4And6(countfourandSix,t1p94s,t1p96s,"8","team1")

            }
            else if(player2_check.text.toString().equals(t1p10name)){
                //prun= (t1p10run.toInt()+runNumber).toString()
                pball= (t1p10balls.toInt()+countballs).toString()

               // myRef.child(matchid).child("team1").child("players").child("9").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team1").child("players").child("9").child("batting").child("B").setValue(pball)
                //count4And6(countfourandSix,t1p104s,t1p106s,"9","team1")

            }
            else if(player2_check.text.toString().equals(t1p11name)){
                //prun= (t1p11run.toInt()+runNumber).toString()
                pball= (t1p11balls.toInt()+countballs).toString()

               // myRef.child(matchid).child("team1").child("players").child("10").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team1").child("players").child("10").child("batting").child("B").setValue(pball)
                //count4And6(countfourandSix,t1p114s,t1p116s,"10","team1")

            }
            else if(player2_check.text.toString().equals(t1p12name)){
                //prun= (t1p12run.toInt()+runNumber).toString()
                pball= (t1p12balls.toInt()+countballs).toString()

                //myRef.child(matchid).child("team1").child("players").child("11").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team1").child("players").child("11").child("batting").child("B").setValue(pball)
                //count4And6(countfourandSix,t1p124s,t1p126s,"11","team1")

            }

            if(player2_check.text.toString().equals(t2p1name)){
                //prun= (t2p1run.toInt()+runNumber).toString()
                pball= (t2p1balls.toInt()+countballs).toString()

               // myRef.child(matchid).child("team2").child("players").child("0").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team2").child("players").child("0").child("batting").child("B").setValue(pball)
                //count4And6(countfourandSix,t2p14s,t2p16s,"0","team2")

            }
            else if(player2_check.text.toString().equals(t2p2name)){
                //prun= (t2p2run.toInt()+runNumber).toString()
                pball= (t2p2balls.toInt()+countballs).toString()

               // myRef.child(matchid).child("team2").child("players").child("1").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team2").child("players").child("1").child("batting").child("B").setValue(pball)
                //count4And6(countfourandSix,t2p24s,t2p26s,"1","team2")

            }
            else if(player2_check.text.toString().equals(t2p3name)){
                //prun= (t2p3run.toInt()+runNumber).toString()
                pball= (t2p3balls.toInt()+countballs).toString()

               // myRef.child(matchid).child("team2").child("players").child("2").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team2").child("players").child("2").child("batting").child("B").setValue(pball)
                //count4And6(countfourandSix,t2p34s,t2p36s,"2","team2")

            }
            else if(player2_check.text.toString().equals(t2p4name)){
                //prun= (t2p4run.toInt()+runNumber).toString()
                pball= (t2p4balls.toInt()+countballs).toString()

               // myRef.child(matchid).child("team2").child("players").child("3").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team2").child("players").child("3").child("batting").child("B").setValue(pball)
                //count4And6(countfourandSix,t2p44s,t2p46s,"3","team2")

            }
            else if(player2_check.text.toString().equals(t2p5name)){
                //prun= (t2p5run.toInt()+runNumber).toString()
                pball= (t2p5balls.toInt()+countballs).toString()

               // myRef.child(matchid).child("team2").child("players").child("4").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team2").child("players").child("4").child("batting").child("B").setValue(pball)
                //count4And6(countfourandSix,t2p54s,t2p56s,"4","team2")

            }
            else if(player2_check.text.toString().equals(t2p6name)){
                //prun= (t2p6run.toInt()+runNumber).toString()
                pball= (t2p6balls.toInt()+countballs).toString()

               // myRef.child(matchid).child("team2").child("players").child("5").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team2").child("players").child("5").child("batting").child("B").setValue(pball)
                //count4And6(countfourandSix,t2p64s,t2p66s,"5","team2")

            }
            else if(player2_check.text.toString().equals(t2p7name)){
                //prun= (t2p7run.toInt()+runNumber).toString()
                pball= (t2p7balls.toInt()+countballs).toString()

               // myRef.child(matchid).child("team2").child("players").child("6").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team2").child("players").child("6").child("batting").child("B").setValue(pball)
                //count4And6(countfourandSix,t2p74s,t2p76s,"6","team2")

            }
            else if(player2_check.text.toString().equals(t2p8name)){
                //prun= (t2p8run.toInt()+runNumber).toString()
                pball= (t2p8balls.toInt()+countballs).toString()

               // myRef.child(matchid).child("team2").child("players").child("7").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team2").child("players").child("7").child("batting").child("B").setValue(pball)
                //count4And6(countfourandSix,t2p84s,t2p86s,"7","team2")

            }
            else if(player2_check.text.toString().equals(t2p9name)){
                //prun= (t2p9run.toInt()+runNumber).toString()
                pball= (t2p9balls.toInt()+countballs).toString()

               // myRef.child(matchid).child("team2").child("players").child("8").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team2").child("players").child("8").child("batting").child("B").setValue(pball)
                //count4And6(countfourandSix,t2p94s,t2p96s,"8","team2")

            }
            else if(player2_check.text.toString().equals(t2p10name)){
                //prun= (t2p10run.toInt()+runNumber).toString()
                pball= (t2p10balls.toInt()+countballs).toString()

               // myRef.child(matchid).child("team2").child("players").child("9").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team2").child("players").child("9").child("batting").child("B").setValue(pball)
                //count4And6(countfourandSix,t2p104s,t2p106s,"9","team2")

            }
            else if(player2_check.text.toString().equals(t2p11name)){
                //prun= (t2p11run.toInt()+runNumber).toString()
                pball= (t2p11balls.toInt()+countballs).toString()

               // myRef.child(matchid).child("team2").child("players").child("10").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team2").child("players").child("10").child("batting").child("B").setValue(pball)
                //count4And6(countfourandSix,t2p114s,t2p116s,"10","team2")

            }
            else if(player2_check.text.toString().equals(t2p12name)){
                //prun= (t2p12run.toInt()+runNumber).toString()
                pball= (t2p12balls.toInt()+countballs).toString()

               // myRef.child(matchid).child("team2").child("players").child("11").child("batting").child("R").setValue(prun)
                myRef.child(matchid).child("team2").child("players").child("11").child("batting").child("B").setValue(pball)
                //count4And6(countfourandSix,t2p124s,t2p126s,"11","team2")

            }

            if(bowler2_check.text.toString().equals(t1p1name)){
                bowler2over= (bowler2CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler2CountBalls").setValue(bowler2over)

                bcountover=overCalculate(bowler2over.toInt())
                //bowlerrun= (t1b1run.toInt()+runNumber).toString()

               // myRef.child(matchid).child("team1").child("players").child("0").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team1").child("players").child("0").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler2_check.text.toString().equals(t1p2name)){
                bowler2over= (bowler2CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler2CountBalls").setValue(bowler2over)

                bcountover=overCalculate(bowler2over.toInt())
                //bowlerrun= (t1b2run.toInt()+runNumber).toString()

               // myRef.child(matchid).child("team1").child("players").child("1").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team1").child("players").child("1").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler2_check.text.toString().equals(t1p3name)){
                bowler2over= (bowler2CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler2CountBalls").setValue(bowler2over)

                bcountover=overCalculate(bowler2over.toInt())
                //bowlerrun= (t1b3run.toInt()+runNumber).toString()

               // myRef.child(matchid).child("team1").child("players").child("2").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team1").child("players").child("2").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler2_check.text.toString().equals(t1p4name)){
                bowler2over= (bowler2CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler2CountBalls").setValue(bowler2over)

                bcountover=overCalculate(bowler2over.toInt())
                //bowlerrun= (t1b4run.toInt()+runNumber).toString()

               // myRef.child(matchid).child("team1").child("players").child("3").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team1").child("players").child("3").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler2_check.text.toString().equals(t1p5name)){
                bowler2over= (bowler2CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler2CountBalls").setValue(bowler2over)

                bcountover=overCalculate(bowler2over.toInt())
                //bowlerrun= (t1b5run.toInt()+runNumber).toString()

               // myRef.child(matchid).child("team1").child("players").child("4").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team1").child("players").child("4").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler2_check.text.toString().equals(t1p6name)){
                bowler2over= (bowler2CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler2CountBalls").setValue(bowler2over)

                bcountover=overCalculate(bowler2over.toInt())
                //bowlerrun= (t1b6run.toInt()+runNumber).toString()

               // myRef.child(matchid).child("team1").child("players").child("5").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team1").child("players").child("5").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler2_check.text.toString().equals(t1p7name)){
                bowler2over= (bowler2CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler2CountBalls").setValue(bowler2over)

                bcountover=overCalculate(bowler2over.toInt())
                //bowlerrun= (t1b7run.toInt()+runNumber).toString()

               // myRef.child(matchid).child("team1").child("players").child("6").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team1").child("players").child("6").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler2_check.text.toString().equals(t1p8name)){
                bowler2over= (bowler2CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler2CountBalls").setValue(bowler2over)

                bcountover=overCalculate(bowler2over.toInt())
                //bowlerrun= (t1b8run.toInt()+runNumber).toString()

              //  myRef.child(matchid).child("team1").child("players").child("7").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team1").child("players").child("7").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler2_check.text.toString().equals(t1p9name)){
                bowler2over= (bowler2CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler2CountBalls").setValue(bowler2over)

                bcountover=overCalculate(bowler2over.toInt())
                //bowlerrun= (t1b9run.toInt()+runNumber).toString()

              //  myRef.child(matchid).child("team1").child("players").child("8").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team1").child("players").child("8").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler2_check.text.toString().equals(t1p10name)){
                bowler2over= (bowler2CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler2CountBalls").setValue(bowler2over)

                bcountover=overCalculate(bowler2over.toInt())
                //bowlerrun= (t1b10run.toInt()+runNumber).toString()

                //myRef.child(matchid).child("team1").child("players").child("9").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team1").child("players").child("9").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler2_check.text.toString().equals(t1p11name)){
                bowler2over= (bowler2CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler2CountBalls").setValue(bowler2over)

                bcountover=overCalculate(bowler2over.toInt())
                //bowlerrun= (t1b11run.toInt()+runNumber).toString()

                //myRef.child(matchid).child("team1").child("players").child("10").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team1").child("players").child("10").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler2_check.text.toString().equals(t1p12name)){
                bowler2over= (bowler2CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler2CountBalls").setValue(bowler2over)

                bcountover=overCalculate(bowler2over.toInt())
                //bowlerrun= (t1b12run.toInt()+runNumber).toString()

                //myRef.child(matchid).child("team1").child("players").child("11").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team1").child("players").child("11").child("bowling").child("O").setValue(bcountover)
            }

            if(bowler2_check.text.toString().equals(t2p1name)){
                bowler2over= (bowler2CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler2CountBalls").setValue(bowler2over)

                bcountover=overCalculate(bowler2over.toInt())
                //bowlerrun= (t2b1run.toInt()+runNumber).toString()

               // myRef.child(matchid).child("team2").child("players").child("0").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team2").child("players").child("0").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler2_check.text.toString().equals(t2p2name)){
                bowler2over= (bowler2CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler2CountBalls").setValue(bowler2over)

                bcountover=overCalculate(bowler2over.toInt())
                //bowlerrun= (t2b2run.toInt()+runNumber).toString()

               // myRef.child(matchid).child("team2").child("players").child("1").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team2").child("players").child("1").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler2_check.text.toString().equals(t2p3name)){
                bowler2over= (bowler2CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler2CountBalls").setValue(bowler2over)

                bcountover=overCalculate(bowler2over.toInt())
                //bowlerrun= (t2b3run.toInt()+runNumber).toString()

               // myRef.child(matchid).child("team2").child("players").child("2").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team2").child("players").child("2").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler2_check.text.toString().equals(t2p4name)){
                bowler2over= (bowler2CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler2CountBalls").setValue(bowler2over)

                bcountover=overCalculate(bowler2over.toInt())
                //bowlerrun= (t2b4run.toInt()+runNumber).toString()

               // myRef.child(matchid).child("team2").child("players").child("3").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team2").child("players").child("3").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler2_check.text.toString().equals(t2p5name)){
                bowler2over= (bowler2CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler2CountBalls").setValue(bowler2over)

                bcountover=overCalculate(bowler2over.toInt())
                //bowlerrun= (t2b5run.toInt()+runNumber).toString()

                //myRef.child(matchid).child("team2").child("players").child("4").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team2").child("players").child("4").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler2_check.text.toString().equals(t2p6name)){
                bowler2over= (bowler2CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler2CountBalls").setValue(bowler2over)

                bcountover=overCalculate(bowler2over.toInt())
                //bowlerrun= (t2b6run.toInt()+runNumber).toString()

              //  myRef.child(matchid).child("team2").child("players").child("5").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team2").child("players").child("5").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler2_check.text.toString().equals(t2p7name)){
                bowler2over= (bowler2CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler2CountBalls").setValue(bowler2over)

                bcountover=overCalculate(bowler2over.toInt())
                //bowlerrun= (t2b7run.toInt()+runNumber).toString()

               // myRef.child(matchid).child("team2").child("players").child("6").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team2").child("players").child("6").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler2_check.text.toString().equals(t2p8name)){
                bowler2over= (bowler2CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler2CountBalls").setValue(bowler2over)

                bcountover=overCalculate(bowler2over.toInt())
                //bowlerrun= (t2b8run.toInt()+runNumber).toString()

               // myRef.child(matchid).child("team2").child("players").child("7").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team2").child("players").child("7").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler2_check.text.toString().equals(t2p9name)){
                bowler2over= (bowler2CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler2CountBalls").setValue(bowler2over)

                bcountover=overCalculate(bowler2over.toInt())
                //bowlerrun= (t2b9run.toInt()+runNumber).toString()

               // myRef.child(matchid).child("team2").child("players").child("8").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team2").child("players").child("8").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler2_check.text.toString().equals(t2p10name)){
                bowler2over= (bowler2CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler2CountBalls").setValue(bowler2over)

                bcountover=overCalculate(bowler2over.toInt())
                //bowlerrun= (t2b10run.toInt()+runNumber).toString()

                //myRef.child(matchid).child("team2").child("players").child("9").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team2").child("players").child("9").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler2_check.text.toString().equals(t2p11name)){
                bowler2over= (bowler2CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler2CountBalls").setValue(bowler2over)

                bcountover=overCalculate(bowler2over.toInt())
                //bowlerrun= (t2b11run.toInt()+runNumber).toString()

               // myRef.child(matchid).child("team2").child("players").child("10").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team2").child("players").child("10").child("bowling").child("O").setValue(bcountover)
            }
            else if(bowler2_check.text.toString().equals(t2p12name)){
                bowler2over= (bowler2CountBalls.toInt()+countballs).toString()
                myRef.child(matchid).child("bowler2CountBalls").setValue(bowler2over)

                bcountover=overCalculate(bowler2over.toInt())
                //bowlerrun= (t2b12run.toInt()+runNumber).toString()

                //myRef.child(matchid).child("team2").child("players").child("11").child("bowling").child("R").setValue(bowlerrun)
                myRef.child(matchid).child("team2").child("players").child("11").child("bowling").child("O").setValue(bcountover)
            }




            /* if(choosebattingteam.equals(t1name)){
                 myRef.child(matchid).child("team1").child("run").setValue(team1run)
                 myRef.child(matchid).child("team1").child("over").setValue(countover)
 
             }else{
                 myRef.child(matchid).child("team2").child("run").setValue(team2run)
                 myRef.child(matchid).child("team2").child("over").setValue(countover)
 
             }*/
            Toast.makeText(this,"player2 run"+" "+prun,Toast.LENGTH_SHORT).show()

        }


        if(choosebattingteam.equals(t1name)){
           // myRef.child(matchid).child("team1").child("run").setValue(team1run)
            myRef.child(matchid).child("team1").child("over").setValue(countover)
            //  if(inning.equals("2")){
            myRef.child(matchid).child("remainingBalls").setValue(ballsremaining)

            //}
        }else{
          //  myRef.child(matchid).child("team2").child("run").setValue(team2run)
            myRef.child(matchid).child("team2").child("over").setValue(countover)
            // if(inning.equals("2")){
            myRef.child(matchid).child("remainingBalls").setValue(ballsremaining)

            // }
        }

    }


    fun onRadioButtonClicked(view: View) {
        // Is the button now checked?
        val checked = (view as RadioButton).isChecked

        // Check which radio button was clicked
        when (view.getId()) {
            R.id.player1_check -> if (checked) {
                var pstrike = "Player1"
                myRef.child(matchid).child("batsmanStrike").setValue(pstrike)
                Toast.makeText(this, "Player1", Toast.LENGTH_SHORT).show()

            }
            R.id.player2_check-> if (checked){
                var pstrike = "Player2"
                myRef.child(matchid).child("batsmanStrike").setValue(pstrike)
                Toast.makeText(this, "Player2", Toast.LENGTH_SHORT).show()

            }
        }
    }



}