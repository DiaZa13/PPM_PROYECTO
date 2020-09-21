package com.example.foodforme.timer

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.SystemClock
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.foodforme.R
import com.example.foodforme.databinding.TimerFragmentBinding
import com.google.firebase.database.DatabaseReference
import kotlinx.android.synthetic.main.timer_fragment.*


class TimerFragment : Fragment() {

    private lateinit var viewModel: TimerViewModel
    private lateinit var binding: TimerFragmentBinding
    private lateinit var database: DatabaseReference


    @SuppressLint("SetTextI18n")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.timer_fragment, container, false)
        var stopTime: Long = 0
        var totalTime: Long = 0
        btnStart.setOnClickListener {
            totalTime = 0
            chronometer.base = SystemClock.elapsedRealtime()+stopTime
            chronometer.start()
            btnStart.visibility = View.GONE
            btnPause.visibility = View.VISIBLE
            btnStop.visibility = View.VISIBLE
            lbAmount.text = (totalTime* 0.2).toString() + "L"
        }
        btnPause.setOnClickListener{
            stopTime = chronometer.base-SystemClock.elapsedRealtime()
            totalTime = chronometer.base-SystemClock.elapsedRealtime()
            chronometer.stop()
            btnPause.visibility = View.GONE
            btnStart.visibility = View.VISIBLE
            lbAmount.text = (totalTime* 0.2).toString() + "L"
        }
        btnStop.setOnClickListener{
            totalTime = chronometer.base-SystemClock.elapsedRealtime()
            chronometer.base = SystemClock.elapsedRealtime()
            stopTime = 0
            chronometer.stop()
            btnStart.visibility = View.VISIBLE
            btnPause.visibility = View.VISIBLE
            lbAmount.text = (totalTime* 0.2).toString() + "L"
        }



        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val application = requireNotNull(this.activity).application
    }


}