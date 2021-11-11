package com.example.jazzbargame.fragment

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.jazzbargame.DEFINES
import com.example.jazzbargame.R
import com.example.jazzbargame.activity.SplashActivity
import com.example.jazzbargame.adapter.BarAdapter
import com.example.jazzbargame.entity.BarInfoEntity
import com.example.jazzbargame.model.BarModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.zip.DeflaterInputStream
import javax.security.auth.DestroyFailedException

class BarSelectFragment : Fragment() {

    private lateinit var listView : RecyclerView
    private lateinit var homeButton : Button
    private lateinit var addLayout : LinearLayout

    private lateinit var rAdapter : BarAdapter
    private lateinit var rList : ArrayList<BarModel>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_bar_select, container, false)

        listView = view.findViewById(R.id.fragment_bar_select_list)
        homeButton = view.findViewById(R.id.fragment_bar_select_button)
        addLayout = view.findViewById(R.id.fragment_bar_select_add)

        rAdapter = BarAdapter()

        rList = arrayListOf()
        loadSelectList()

        rAdapter.setList(rList)
        listView.layoutManager = LinearLayoutManager(requireContext())
        listView.adapter = rAdapter

        return view
    }

    private fun loadSelectList() {
        CoroutineScope(Dispatchers.Main).launch {
            var list : List<BarInfoEntity> = arrayListOf()
            withContext(CoroutineScope(Dispatchers.IO).coroutineContext) {
                list = DEFINES.barInfoDatabase!!.BarInfoDao().findAll()
            }
            // Get into IO coroutine?
            for (i in 0 until list.size) {
                rList.add(
                    BarModel(
                        list[i].barId, list[i].barImage, list[i].barName, list[i].profit, list[i].goal,
                        list[i].date,
                    )
                )
            }
            rAdapter.setList(rList)

            if (rList.size < 1) {
                addLayout.visibility = View.VISIBLE
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        homeButton.setOnClickListener {
            val intent = Intent(requireActivity(), SplashActivity::class.java)
            startActivity(intent)
//            showpopup(DEFINES.PUP.HOME)
        }

        rAdapter.setItemClickListener(object : BarAdapter.OnItemClickListener {
            override fun onClick(view: View, position: Int) {
                DEFINES.selectedBar = BarInfoEntity(
                    rList[position].modelBarId, rList[position].modelBarImage,
                    rList[position].modelBarName, rList[position].modelProfit,
                    rList[position].modelGoal, rList[position].modelDate
                )
                val intent = Intent(requireContext(), SplashActivity::class.java)
                startActivity(intent)
            }
        })

        addLayout.setOnClickListener {
            val transaction = requireActivity().supportFragmentManager.beginTransaction()
            transaction.add(R.id.register_frame, BarSettingFragment())
            transaction.addToBackStack(null)
            transaction.commit()
//            showpopup(DEFINES.PUP.BAR)
        }
    }

    private fun showpopup(text : String) {
        val view = LayoutInflater.from(requireContext()).inflate(R.layout.alert_dialog, null)
        val textView : TextView = view.findViewById(R.id.alert_text)
        textView.text = text

        val alertDialog = AlertDialog.Builder(requireContext())
            .setTitle(DEFINES.PUP.TITLE)
            .setPositiveButton("Yes") { dialog, which ->
                when (text) {
                    DEFINES.PUP.BAR -> {
                        val transaction = requireActivity().supportFragmentManager.beginTransaction()
                        transaction.add(R.id.register_frame, BarSettingFragment())
                        transaction.addToBackStack(null)
                        transaction.commit()
                    }
                    DEFINES.PUP.HOME -> {
                        val intent = Intent(requireActivity(), SplashActivity::class.java)
                        startActivity(intent)
                    }
                }
            }
            .setNegativeButton("No", null)
            .create()
        alertDialog.setView(view)
        alertDialog.show()
    }

}