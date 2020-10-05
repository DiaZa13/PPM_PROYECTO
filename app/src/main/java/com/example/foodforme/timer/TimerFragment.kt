package com.example.foodforme.timer

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.os.SystemClock
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.databinding.DataBindingUtil
import com.example.foodforme.R
import com.example.foodforme.data.User
import com.example.foodforme.databinding.TimerFragmentBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.timer_fragment.*
import java.time.LocalDateTime


class TimerFragment : Fragment() {

    private lateinit var viewModel: TimerViewModel
    private lateinit var binding: TimerFragmentBinding
    private var database: FirebaseDatabase = FirebaseDatabase.getInstance()
    private var users = database.getReference("users/" + FirebaseAuth.getInstance().currentUser!!.uid)

    @RequiresApi(Build.VERSION_CODES.O)
    @SuppressLint("SetTextI18n")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.timer_fragment, container, false)
        var stopTime: Long = 0
        var totalTime: Double = 0.0
        var litros: String = ""
        var pauseTime: Long = 0
        var isRunning: Boolean = false
        binding.btnStart.setOnClickListener {
            totalTime = 0.0
            chronometer.base = SystemClock.elapsedRealtime()+stopTime
            chronometer.start()
            btnStart.visibility = View.GONE
            btnPause.visibility = View.VISIBLE
            btnStop.visibility = View.VISIBLE
            isRunning = true
            lbAmount.text = "L"
        }
        binding.btnPause.setOnClickListener{
            stopTime = chronometer.base-SystemClock.elapsedRealtime()
            chronometer.stop()
            btnPause.visibility = View.GONE
            btnStart.visibility = View.VISIBLE
            pauseTime = (SystemClock.elapsedRealtime()-chronometer.base)/1000
            totalTime = ((SystemClock.elapsedRealtime()-chronometer.base)/1000)*0.2
            litros = (totalTime).toString() + "L"
            lbAmount.text = litros
            isRunning = false
        }
        binding.btnStop.setOnClickListener{
            chronometer.base = SystemClock.elapsedRealtime()+stopTime
            litros = if (!isRunning){
                totalTime = ((SystemClock.elapsedRealtime()-chronometer.base)/1000)*0.2
                (totalTime).toString() + "L"
            } else {
                totalTime = ((SystemClock.elapsedRealtime()-chronometer.base)/1000 + pauseTime)*0.2
                (totalTime).toString() + "L"
            }
            chronometer.base = SystemClock.elapsedRealtime()
            stopTime = 0
            chronometer.stop()
            btnStart.visibility = View.VISIBLE
            btnPause.visibility = View.VISIBLE
            lbAmount.text = litros
            val user =
                User(FirebaseAuth.getInstance().uid!!, LocalDateTime.now(), totalTime)
            users!!.push()!!.setValue(user)
        }

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val application = requireNotNull(this.activity).application
    }


}