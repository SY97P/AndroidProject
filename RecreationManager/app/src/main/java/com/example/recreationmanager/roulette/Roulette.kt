package com.example.recreationmanager.roulette

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View
import android.view.animation.Animation
import android.view.animation.RotateAnimation
import com.google.android.material.snackbar.Snackbar
import java.lang.Exception
import java.lang.Math.cos
import java.lang.Math.sin

@SuppressLint("ResourceAsColor")
class Roulette @JvmOverloads constructor(
    context : Context,
    attrs : AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val strokePaint = Paint()
    private val fillPaint = Paint()
    private val textPaint = Paint()

    // default size : 6
    private var rouletteSize = 7
    private var rouletteDataList = listOf<String>(
        "훈", "태", "인", "녕", "경", "택", "세"
    )

    private lateinit var canvas: Canvas

    init {
        strokePaint.apply {
            color = Color.WHITE
            style = Paint.Style.STROKE
            strokeWidth = 25f
            isAntiAlias = true
        }
        fillPaint.apply {
            style = Paint.Style.FILL
            isAntiAlias = true
        }
        textPaint.apply {
            color = Color.parseColor("#064663")
            strokeWidth = 10f
            textSize = 60f
            textAlign = Paint.Align.CENTER
        }
    }

    // AnimationListener를 만들지 않고 새로이 만드는 이유
    // 단순 시작/종료 타이밍을 알려고 하는 것이 아니라, 애니메이션 종료 후 결과를 리턴받기 위함.
    interface RotateListener {
        fun onRotateStart()
        fun onRatateEnd(result : String)
    }

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        try {
            this.canvas = canvas!!
        } catch (e :Exception) {
            e.printStackTrace()
        }

        val rectLeft = left.toFloat() + paddingLeft
        val rectRight = right.toFloat() - paddingRight
        val rectTop = height / 2f - rectRight / 2f + paddingTop - paddingRight / 2f
        val rectBottom = height / 2f + rectRight / 2f - paddingBottom + paddingRight / 2f

        val rectF = RectF(rectLeft, rectTop, rectRight, rectBottom)

        drawRoulette(canvas, rectF)
    }

    private fun drawRoulette(canvas: Canvas?, rectF: RectF) {
        canvas?.drawArc(rectF, 0f, 360f, true, strokePaint)

        val widthCenter = rectF.centerX()
        val heightCenter = rectF.centerY()
        canvas?.drawArc(RectF(widthCenter-5f, heightCenter + 5f, widthCenter + 5f, heightCenter - 5f), 0f, 360f, true, strokePaint)
        if (rouletteSize in 2..8) {
            val sweepAngle = 360f / rouletteSize.toFloat()
            val centerX = (rectF.right + rectF.left) / 2
            val centerY = (rectF.top + rectF.bottom) / 2
            val radius = (rectF.right - rectF.left) / 2 * 0.7
            val colors = listOf<String>("#fe4a49", "#2ab7ca", "#fed766", "#e6e6ea", "#f6abb6", "#005b96", "#7bc043", "#f37735")

            for (i in 0 until  rouletteSize) {
                fillPaint.color = Color.parseColor(colors[i])

                val startAngle = if (i == 0) 0f else sweepAngle * i
                canvas?.drawArc(rectF, startAngle, sweepAngle, true, fillPaint)

                val medianAngle = (startAngle + sweepAngle / 2f) * Math.PI / 180f
                val x = (centerX + (radius * cos(medianAngle))).toFloat()
                val y = (centerY + (radius * sin(medianAngle))).toFloat()

                val text = if (i > rouletteDataList.size - 1) "추가" else rouletteDataList[i]
                canvas?.drawText(text, x, y, textPaint)
            }
        } else throw RuntimeException("size out of roulette")
    }

    fun rotateRoulette(toDegrees : Float, duration : Long, rotateListener : RotateListener) {
        val animListener = object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation?) {
                rotateListener?.onRotateStart()
            }

            override fun onAnimationEnd(animation: Animation?) {
                rotateListener?.onRatateEnd(getRouletteRotateResult(toDegrees))
            }

            override fun onAnimationRepeat(animation: Animation?) { }
        }
        val rotateAnim = RotateAnimation(
            0f, toDegrees,
            Animation.RELATIVE_TO_SELF, 0.5f,
            Animation.RELATIVE_TO_SELF, 0.5f
        )
        rotateAnim.duration = duration
        rotateAnim.fillAfter = true
        rotateAnim.setAnimationListener(animListener)

        startAnimation(rotateAnim)
    }

    /**
     * 1. 안드로이드에서 룰렛을 그릴 때 12시 방향에 270'가 오게 됨.
     * 1-1. 360'는 제자리이므로 360'를 나눈 나머지로 각도 계산
     * 1-2. 나머지 각도가 270 이하면 (270 - 나머지 각도)가 결과각도
     * 1-3. 나머지 각도가 270 이상이면 (360 - 나머지 각도 + 270)가 결과각도
     * 2. 룰렛 사이즈에 따라 한 칸의 각도가 달라짐. (360 / 사이즈) = 룰렛 한 칸의 각도
     * 3. 룰렛 사이즈만큼 for 문을 돌려 (1 ~ 룰렛사이즈) 결과 각도에 해당하는 칸의 데이터 리턴
     * 3-1. 결과각도가 한 칸의 각도보다 작으면 해당 인덱스의 데이터 리턴
     * 3-2. 한 칸의 각도는 해당 칸의 각도 중 큰 값
     */
    private fun getRouletteRotateResult(degrees : Float) : String {
        val moveDegrees = degrees % 360
        val resultAngle = if (moveDegrees > 270) 360 - moveDegrees + 270 else 270 - moveDegrees
        for (i in 0 until rouletteSize) {
            if (resultAngle < (360 / rouletteSize) * i) {
                if (i >= rouletteDataList.size) {
                    return "empty"
                }
                return rouletteDataList[i-1]
            }
        }
        return ""
    }

    fun addRoulette() {
        rouletteSize++
        if (rouletteSize > 8) {
            Snackbar.make(this@Roulette, "최대 8개", Snackbar.LENGTH_LONG)
                .setAction("noMore", null).show()
            rouletteSize = 8
        } else {
            invalidate()
        }
    }

    fun removeRoulette() {
        rouletteSize--
        if (rouletteSize < 2) {
            Snackbar.make(this@Roulette, "최소 2개", Snackbar.LENGTH_LONG)
                .setAction("noLess", null).show()
            rouletteSize = 2
        } else {
            invalidate()
        }
    }
}