package com.example.myapplication


import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.*

class FilterDialog : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_filter_page)

    }
/*
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val popupView = inflater.inflate(R.layout.activity_filter_page, container, false)
        mContext = popupView.getContext()

        dialog.window!!.requestFeature(Window.FEATURE_NO_TITLE)
        dialog.window!!.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN
        )
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.setCanceledOnTouchOutside(false)

        return popupView
    }*/

}
