package com.example.jazzbargame.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import com.example.jazzbargame.DEFINES
import com.example.jazzbargame.R
import com.example.jazzbargame.entity.BarInfoEntity
import com.example.jazzbargame.model.BarModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.w3c.dom.Text

class BarSettingFragment : Fragment() {

    private lateinit var imageView : ImageView
    private lateinit var nameText : EditText
    private lateinit var gainText : EditText
    private lateinit var goalText : EditText
    private lateinit var dateText : EditText
    private lateinit var registerButton : Button

    private var imageAnswer : Int = R.drawable.icon_in
    private var nameAnswer : String = "Sepp's"
    private var gainAnswer : String = "0"
    private var goalAnswer : String = "3500"
    private var dateAnswer : String = "2021-11-10"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_bar_setting, container, false)

        imageView = view.findViewById(R.id.bar_setting_image)
        nameText = view.findViewById(R.id.bar_setting_editName)
        gainText = view.findViewById(R.id.bar_setting_editProfit)
        goalText = view.findViewById(R.id.bar_setting_editGoal)
        dateText = view.findViewById(R.id.bar_setting_editDate)
        registerButton = view.findViewById(R.id.bar_setting_button)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        imageView.setOnClickListener {
            imageAnswer = R.drawable.icon_bar
            imageView.setImageResource(R.drawable.icon_bar)
            imageView.setColorFilter(R.color.level_4)
        }

        registerButton.setOnClickListener {
            nameAnswer = nameText.text.toString()
            goalAnswer = goalText.text.toString()

            DEFINES.selectedBar =
                BarInfoEntity(
                    barId = DEFINES.entityId,
                    barImage = imageAnswer,
                    barName = nameAnswer,
                    profit = gainAnswer,
                    goal = goalAnswer,
                    date = dateAnswer
                )
            DEFINES.entityId++

            CoroutineScope(Dispatchers.Main).launch {
                withContext(CoroutineScope(Dispatchers.IO).coroutineContext) {
                    DEFINES.barInfoDatabase!!.BarInfoDao().insert(DEFINES.selectedBar!!)
                }
            }

            val transaction = requireActivity().supportFragmentManager.beginTransaction().run {
                replace(R.id.register_frame, BarSelectFragment())
                addToBackStack(null)
                commit()
            }
        }
    }
}