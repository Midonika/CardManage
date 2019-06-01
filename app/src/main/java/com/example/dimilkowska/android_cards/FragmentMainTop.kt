package com.example.dimilkowska.android_cards


import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

class FragmentMainTop : Fragment() {

    internal var buttonOne: Button? = null
    internal var buttonThree: Button? = null


    internal var mListener: ButtonPressListener? = null


    interface ButtonPressListener {
        fun onButtonPressed(button: Int)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_main_top, container, false)

        buttonOne = view.findViewById(R.id.button_one)
        buttonThree = view.findViewById(R.id.button_three)

        buttonOne!!.setOnClickListener{
            mListener!!.onButtonPressed(1)
        }

        buttonThree!!.setOnClickListener{
            mListener!!.onButtonPressed(3)
        }

        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        if (context is ButtonPressListener)
            mListener = context
        else
            throw ClassCastException("$context must implement ButtonPressListener interface")

    }
}
