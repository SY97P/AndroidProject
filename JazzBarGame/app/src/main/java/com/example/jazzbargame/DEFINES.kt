package com.example.jazzbargame

import com.example.jazzbargame.Database.BarInfoDatabase
import com.example.jazzbargame.entity.BarInfoEntity
import com.example.jazzbargame.model.CustomerModel

object DEFINES {

    var entityId : Int = 0

    var barInfoDatabase : BarInfoDatabase? = null

    var selectedBar : BarInfoEntity? = null

    // int range for Random Selection
    val range_01 = (0..1)
    val range_name = (0..9)
    val range_money = (100..1000)

    // Candidates of Name
    val NAME_CANDI : ArrayList<String> = arrayListOf(
            "Glenn Miller", "Duke Elington", "Cutie Williams",
            "Sellonius Monk", "Jaco Pastorius", "Louis Armstrong",
            "Sam Hamington", "Jac Willy", "Abriahn Lincorn", "Jake Sully"
    )

    // Candidates of Gender
    val GENDER_CANDI : ArrayList<String> = arrayListOf("Male", "Female")

    // Candidates of Image Resource
    val IMAGE_CANDI : ArrayList<Int> = arrayListOf(
        R.drawable.icon_male,
        R.drawable.icon_female
    )

    object PUP {
        val TITLE : String = "Your Choice is needed, Host"

        val GOAL_TEXT : String = "오늘 목표치를 달성했습니다.\n영업을 종료할까요?"
        val INIT : String = "처음 오셨군요.\n새로운 바를 생성하러 갈까요?"
        val START : String = "게임을 시작합시다!!"
        val REGIST : String = "소유한 재즈바를 관리하러 가시려구요?"
        val HOME : String = "홈 화면으로 돌아가시겠어요?"
        val BAR : String = "클릭한 재즈바를 선택하시겠어요?"
    }
}