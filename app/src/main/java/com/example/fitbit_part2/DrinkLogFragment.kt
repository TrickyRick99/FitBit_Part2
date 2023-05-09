package com.example.fitbit_part2

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [DrinkLogFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DrinkLogFragment : Fragment() {

    private var param1: String? = null
    private var param2: String? = null
    private lateinit var drinkRecycler: RecyclerView

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
        val view= inflater.inflate(R.layout.fragment_drink_log, container, false)
        val context= view.context
        val add= view.findViewById<Button>(R.id.addButton)
        drinkRecycler=view.findViewById(R.id.drinkRec)



        GlobalScope.launch(Dispatchers.IO){

            val drinkSet = db.drinkDao().getAll()


            adapt(drinkSet,drinkRecycler)






        }
        drinkRecycler.layoutManager = LinearLayoutManager(context)












        add.setOnClickListener(){
            val intent1= Intent(context, DetailActivity :: class.java)

            this.startActivity(intent1)

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
         * @return A new instance of fragment DrinkLogFragment.
         */

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            DrinkLogFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
        fun adapt(dSet:List<Drink>, rec:RecyclerView){
            val adapter = DrinkAdapter(dSet)
            rec.adapter = adapter
        }
    }
}