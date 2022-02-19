package com.example.adv160419003exweek2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_main.*

/**
 * A simple [Fragment] subclass.
 * Use the [MainFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MainFragment : Fragment() {
    private var a = 0
    private var b = 0
    private var ans = 0
    private var skor = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        skor = 0
        generateQuestion()
        buttonSubmit.setOnClickListener {
            // Ambil nama player
            val myAnswer = editAnswer.text.toString()
            // Dapatkan action yang ingin dijalankan
            if (myAnswer.isNotEmpty()) {
                if (ans == myAnswer.toInt()) {
                    skor++
                    generateQuestion()
                } else {
                    val action = MainFragmentDirections.actionMainFragmentToResultFragment(skor)
                    // Jalankan action tersebut
                    Navigation.findNavController(it).navigate(action)
                }
            }
        }
    }

    fun generateQuestion(){
        editAnswer.text?.clear()
        a = (0..99).random()
        b = (0..99).random()
        textQuestion.text = "$a + $b"
        ans = a + b
    }
}