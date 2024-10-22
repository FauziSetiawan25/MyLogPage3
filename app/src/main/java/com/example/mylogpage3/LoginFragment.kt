package com.example.mylogpage3

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
class LoginFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_login, container, false)
        val btn : Button? = view?.findViewById(R.id.submit)

        val sharedPreferences = requireActivity().getSharedPreferences("UserData", Context.MODE_PRIVATE)
        val name = sharedPreferences.getString("name", null)
        val email = sharedPreferences.getString("email", null)
        val password = sharedPreferences.getString("password", null)

        btn?.setOnClickListener {
            val emailL : EditText? = view.findViewById(R.id.email)
            val emailInput = emailL?.text.toString()

            val pwL : EditText? = view.findViewById(R.id.password)
            val pwInput = pwL?.text.toString()

            if (emailInput != "" && pwInput != ""){
                if (email == emailInput && password == pwInput){
                    val intentToSecondActivity = Intent(requireContext(), SecondActivity::class.java)
                    intentToSecondActivity.putExtra("name",name)
                    startActivity(intentToSecondActivity)
                }else{
                    Toast.makeText(requireContext(), "Wrong email or password", Toast.LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(requireContext(), "Please fill in all data to login", Toast.LENGTH_SHORT).show()
            }
        }
        return view
    }
}