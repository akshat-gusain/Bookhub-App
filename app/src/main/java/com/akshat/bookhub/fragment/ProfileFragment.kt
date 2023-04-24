package com.akshat.bookhub.fragment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Button
import com.akshat.bookhub.R

class ProfileFragment : Fragment() {
    lateinit var btnLinked : Button


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_profile, container, false)

        btnLinked = view.findViewById(R.id.btnLinkedIn)
        btnLinked.setOnClickListener {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/akshat-gusain-746313260"))
            startActivity(browserIntent)
        }

        return view
    }


    }
