package com.nwar.individual.get_terra.customView

import android.content.Context
import android.graphics.Color
import android.graphics.PorterDuff
import android.support.v4.content.ContextCompat
import android.util.AttributeSet
import android.view.MotionEvent
import android.widget.Button
import com.nwar.individual.get_terra.R

class CustomButton (mContext: Context, attr : AttributeSet?) : Button(mContext,attr){
    constructor(context: Context) : this(context,null)
    var mTextColor = Color.BLACK
    var mBackgroundColor = Color.WHITE
    var drawable = ContextCompat.getDrawable(mContext,R.drawable.style_circle_main)

    fun setOnColor(textColor : Int, backColor : Int) : CustomButton{
        mTextColor = textColor
        mBackgroundColor = backColor
        drawable?.setColorFilter(backColor, PorterDuff.Mode.SRC_ATOP)
        setBackground(drawable)
        setTextColor(textColor)
        return this
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when(event?.action){
            MotionEvent.ACTION_DOWN -> {
                setBackgroundResource(R.drawable.style_circle_main)
                drawable?.setColorFilter(mTextColor, PorterDuff.Mode.SRC_ATOP)
                setBackground(drawable)
                setTextColor(mBackgroundColor)
            }
            MotionEvent.ACTION_OUTSIDE, MotionEvent.ACTION_CANCEL, MotionEvent.ACTION_UP -> {
                drawable?.setColorFilter(mBackgroundColor, PorterDuff.Mode.SRC_ATOP)
                setBackground(drawable)
                setTextColor(mTextColor)
            }
        }
        return super.onTouchEvent(event)
    }
}