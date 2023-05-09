package com.example.fitbit_part2

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [DrinkDashFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DrinkDashFragment : Fragment() {

    private var param1: String? = null
    private var param2: String? = null

    private var drinkSet = listOf<Drink>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_drink_dash, container, false)

        val averageNum=view.findViewById<TextView>(R.id.avNum)
        val minimumNum=view.findViewById<TextView>(R.id.minNum)
        val maximumNum=view.findViewById<TextView>(R.id.maxNum)
        val add2= view.findViewById<Button>(R.id.addButton2)

        GlobalScope.launch(Dispatchers.IO){

            val drinkSet = db.drinkDao().getAll()
            val av=findAverage(drinkSet)
            val min=findMinimum(drinkSet)
            val max= findMaximum(drinkSet)
            averageNum.text = av.toString()
            minimumNum.text = min.toString()
            maximumNum.text = max.toString()

            Log.v("FINAL average", av.toString())
            Log.v("FINAL minimum", min.toString())
            Log.v("FINAL maximum", max.toString())





        }







        add2.setOnClickListener(){
            val intent3= Intent(context, DetailActivity :: class.java)

            this.startActivity(intent3)

        }
        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment DrinkDashFragment.
         */

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            DrinkDashFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
        fun findAverage(dList: List<Drink>):Double{
            var avTotal: Double
            val rep=dList.size
            dList[0].literNum.toString()
            var total=0
            for(x in dList.indices){
                Log.v("RUN",x.toString())
                var num = dList[x].literNum.toString().toInt()
                total=total + num

            }
            avTotal= (total/dList.size).toDouble()
            Log.v("TOTAL",total.toString())
            Log.v("divide by",dList.size.toString())
            return avTotal

        }
        fun findMinimum(dList: List<Drink>): Int{
            var mini=dList[0].literNum.toString().toInt()
            for(x in 0.. dList.size-2) {

                var num2 = dList[x+1].literNum.toString().toInt()
                if (mini>num2){
                    mini=num2
                }
            }
            return mini
        }
        fun findMaximum(dList: List<Drink>):Int{
            var maxi=dList[0].literNum.toString().toInt()
            for(x in 0.. dList.size-2) {

                var num2 = dList[x+1].literNum.toString().toInt()
                if (maxi<num2){
                    maxi=num2
                    Log.v("MaxChange",maxi.toString())
                }
                Log.v("MaxCheck",maxi.toString())
            }
            return maxi
        }
    }
}