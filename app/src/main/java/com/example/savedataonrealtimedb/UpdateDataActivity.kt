package com.example.savedataonrealtimedb

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.Toast
import com.example.savedataonrealtimedb.adapter.MatchAdapter
import com.example.savedataonrealtimedb.dto.DataModal
import com.example.savedataonrealtimedb.util.RecyclerItemClickListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import java.util.*
import android.app.ProgressDialog
import com.example.savedataonrealtimedb.util.AppConstants
import kotlinx.android.synthetic.main.single_match_layout.view.*


class UpdateDataActivity :AppCompatActivity() {
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

    var keyid:String=""

    var needruntowin:String=""
    private lateinit var recyclerView: RecyclerView
    lateinit var adapter: MatchAdapter
    lateinit var viewPager: ViewPager
    var currentPage=0
    var needrun=""
    var run:Int=0
    var balls:Int=0
    lateinit var dialog:ProgressDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.match_layout)

        val database = FirebaseDatabase.getInstance()
        val myRef = database.getReference("matches")
        arrayList= ArrayList<DataModal>()
        recyclerView=findViewById(R.id.recycler_view)
         dialog = ProgressDialog(this@UpdateDataActivity)
        dialog.setMessage("Loading..")
        dialog.show()

         if(AppConstants.checkInternetConnection(this)){
               }else{
             dialog.dismiss()
             Toast.makeText(this@UpdateDataActivity,"Please check your internet connection.",Toast.LENGTH_LONG).show()
               }

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.itemAnimator = DefaultItemAnimator()
        adapter = MatchAdapter(arrayList, this@UpdateDataActivity)
        recyclerView.adapter=adapter






        recyclerView.addOnItemTouchListener(
            RecyclerItemClickListener(this, RecyclerItemClickListener.OnItemClickListener { view, position ->
                var matchid=arrayList.get(position).key
               /* val intent= Intent(this,UpdateBattingTeamActivity::class.java)
                intent.putExtra("KEY",matchid)
                startActivity(intent)*/
               /* var delete=view.delete_bt
                delete.setOnClickListener {
                    myRef.child(matchid).removeValue()

                }*/

            })
        )

//for add child object
        /*  DatabaseReference path= database.getReference("matches").child("match4");
        path.child("Batsman").setValue("123");*/

//Log.d("bharti","key"+key);

        // myRef.setValue("Hello, World!");
        myRef.addValueEventListener(object : ValueEventListener {
            @SuppressLint("SetTextI18n")
            override fun onDataChange(dataSnapshot: DataSnapshot) {


                dialog.dismiss()
                if (arrayList.size > 0) {
                    arrayList.clear()
                }
                for (taskNo in dataSnapshot.children) {
                    // now you in (9223450)
                    keyid = taskNo.key!!
                    val firebaseObj = taskNo.value //class with params set/get methods
                    //   Object replayObj = taskNo.getValue(); //class with params set/get methods


                    // ALTERNATIVE
                    //if(key.equals("match1")) {
                    for (child in taskNo.children) {
                        if (child.key == "team1") {
                         //   t1over = child.child("over").value!!.toString()
                           child.child("name").value?.let {
                                t1name = child.child("name").value.toString()
                            }
                          //  t1run = child.child("run").value!!.toString()
                          //  t1viket = child.child("wicket").value!!.toString()
                           // t1flag = child.child("flag").value!!.toString()



                        } else if (child.key == "team2") {
                           // t2over = child.child("over").value!!.toString()
                            child.child("name").value?.let {
                                t2name = child.child("name").value.toString()
                            }
                           // t2run = child.child("run").value!!.toString()
                           // t2viket = child.child("wicket").value!!.toString()
                         //   t2flag = child.child("flag").value!!.toString()


                        } /*else if (child.key == "Batsman") {
                            val b1name = child.child("b1").child("name").value!!.toString()
                            val b1run = child.child("b1").child("R").value!!.toString()
                            val b1ball = child.child("b1").child("B").value!!.toString()
                            val b14s = child.child("b1").child("4s").value!!.toString()
                            val b16s = child.child("b1").child("6s").value!!.toString()
                            val b1sr = child.child("b1").child("SR").value!!.toString()

                            Log.d("bharti", "subChild b1 Value is: $b1name $b1run $b1ball $b14s $b16s $b1sr")

                            val b2name = child.child("b2").child("name").value!!.toString()
                            val b2run = child.child("b2").child("R").value!!.toString()
                            val b2ball = child.child("b2").child("B").value!!.toString()
                            val b24s = child.child("b2").child("4s").value!!.toString()
                            val b26s = child.child("b2").child("6s").value!!.toString()
                            val b2sr = child.child("b2").child("SR").value!!.toString()

                            Log.d("bharti", "subChild b2 Value is: $b2name $b2run $b2ball $b24s $b26s $b2sr")

                        } else if (child.key == "Bowling") {
                            val bowler1name = child.child("bowler1").child("name").value!!.toString()
                            val bowler1run = child.child("bowler1").child("O").value!!.toString()
                            val bowler1ball = child.child("bowler1").child("M").value!!.toString()
                            val bowler14s = child.child("bowler1").child("R").value!!.toString()
                            val bowler16s = child.child("bowler1").child("W").value!!.toString()
                            val bowler1sr = child.child("bowler1").child("ER").value!!.toString()

                            Log.d("bharti", "subChild bowler1 Value is: $bowler1name $bowler1run $bowler1ball $bowler14s $bowler16s $bowler1sr")

                            val bowler2name = child.child("bowler2").child("name").value!!.toString()
                            val bowler2run = child.child("bowler2").child("O").value!!.toString()
                            val bowler2ball = child.child("bowler2").child("M").value!!.toString()
                            val bowler24s = child.child("bowler2").child("R").value!!.toString()
                            val bowler26s = child.child("bowler2").child("W").value!!.toString()
                            val bowler2sr = child.child("bowler2").child("ER").value!!.toString()

                            Log.d("bharti", "subChild bowler2 Value is: $bowler2name $bowler2run $bowler2ball $bowler24s $bowler26s $bowler2sr")

                        }
*/

                        // }
                    }


                    arrayList.add(DataModal(keyid,status, needrun, t1name,t1run,t1over,t1viket,t2name,t2run,t2over,t2viket,t1flag,t2flag,inning))

                    adapter.notifyDataSetChanged()

                }



                //Log.d("bharti", "Value is: " + value.tosswinteam);
            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                Log.w("bharti", "Failed to read value.", error.toException())
               dialog.dismiss()
               Toast.makeText(this@UpdateDataActivity,"Failed to read value.",Toast.LENGTH_LONG).show()
            }
        })


    }


}