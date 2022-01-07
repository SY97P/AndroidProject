package com.example.recreationmanager

/**
 * @param priority 체크한 라디오 버튼 id(int)가 들어감
 */
data class VoteData (
    val voteTitle : String,
    val priority : Int,
    val startTime : String,
    val endTime : String
        ){
}