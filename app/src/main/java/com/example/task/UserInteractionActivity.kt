package com.example.task

import android.content.DialogInterface
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar

class UserInteractionActivity : AppCompatActivity() {

    lateinit var buttonAlert : Button
    lateinit var buttonSnack : Button
    lateinit var buttonToast : Button
    lateinit var  main: ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_user_interaction)

        main = findViewById(R.id.main)
        buttonAlert = findViewById(R.id.btnAlert)
        buttonSnack = findViewById(R.id.btnSnack)
        buttonToast = findViewById(R.id.btnToast)

        buttonToast.setOnClickListener{
            Toast.makeText(this@UserInteractionActivity, "Invalid Login", Toast.LENGTH_LONG).show()
        }

        buttonSnack.setOnClickListener{
            Snackbar.make(main, "Unable to login", Snackbar.LENGTH_LONG).setAction("OK", {}).show()
        }

        buttonAlert.setOnClickListener {
            val alert = AlertDialog.Builder(this@UserInteractionActivity)
            alert.setTitle("Warning")
                .setMessage("are you sure")
                .setIcon(R.drawable.abc)
                .setPositiveButton("Yes",
                    DialogInterface.OnClickListener
                    { dialogInterface, i ->
                        //logic
                    })
                .setNegativeButton("No",
                    DialogInterface.OnClickListener
                    { dialogInterface, i ->
                        dialogInterface.dismiss()
                    })
            alert.create().show()
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}