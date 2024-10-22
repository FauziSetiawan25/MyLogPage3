package com.example.mylogpage3

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.viewpager2.widget.ViewPager2
class SignUpFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_sign_up, container, false)
        val btn : Button? = view?.findViewById(R.id.submit)

        btn?.setOnClickListener {
            val nameL : EditText? = view.findViewById(R.id.fullname)
            val name = nameL?.text.toString()

            val emailL : EditText? = view.findViewById(R.id.email)
            val email = emailL?.text.toString()

            val pwL : EditText? = view.findViewById(R.id.password)
            val pw = pwL?.text.toString()

            if (name != "" && email != "" && pw != ""){

                val sharedPreferences = requireActivity().getSharedPreferences("UserData", Context.MODE_PRIVATE)
                val editor = sharedPreferences.edit()
                editor.putString("name", name)
                editor.putString("email", email)
                editor.putString("password", pw)
                editor.apply()

                Toast.makeText(requireContext(), "Successful registration please login", Toast.LENGTH_SHORT).show()
                val viewPager: ViewPager2 = requireActivity().findViewById(R.id.viewPager)
                viewPager.currentItem = 0
            }else{
                Toast.makeText(requireContext(), "Please fill in all data to register", Toast.LENGTH_SHORT).show()
            }
        }
        return view
    }
}