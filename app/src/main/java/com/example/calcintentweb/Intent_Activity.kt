package com.example.calcintentweb

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat


class Intent_Activity : AppCompatActivity() {
    lateinit var btnsms:Button
    lateinit var btncall:Button
    lateinit var btncamera:Button
    lateinit var btnshare:Button
    lateinit var btnmpesa:Button
    lateinit var btndial:Button
    lateinit var btnemail:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent)
        btnsms=findViewById(R.id.Btn_SMS)
        btncall=findViewById(R.id.Btn_Call)
        btncamera=findViewById(R.id.Btn_Camera)
        btnshare=findViewById(R.id.Btn_Share)
        btnmpesa=findViewById(R.id.Btn_Mpesa)
        btndial=findViewById(R.id.Btn_Dial)
        btnemail=findViewById(R.id.Btn_Email)


        btnsms.setOnClickListener {
            val uri = Uri.parse("sms to :0745678923")
            val intent = Intent(Intent.ACTION_SENDTO, uri)
            intent.putExtra("Hello", "How is todays weather")
            startActivity(intent)

        }
        btncall.setOnClickListener {
            val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "+254961316966"))
            if (ContextCompat.checkSelfPermission(
                    this@Intent_Activity,
                    android.Manifest.permission.CALL_PHONE
                ) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(
                    this@Intent_Activity,
                    arrayOf(android.Manifest.permission.CALL_PHONE), 1)
            } else {
                startActivity(intent)
            }
        }
        btncamera.setOnClickListener {
            val takepic=Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(takepic,1)

        }
        btnshare.setOnClickListener {
            val shareIntent = Intent(Intent.ACTION_SEND)
            shareIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            shareIntent.type = "text/plain"
            shareIntent.putExtra(Intent.EXTRA_TEXT, "Hey, download this app!")
            startActivity(shareIntent)

        }
        btnmpesa.setOnClickListener {
            val simToolKitLaunchIntent =
                applicationContext.packageManager.getLaunchIntentForPackage("com.android.stk")
            simToolKitLaunchIntent?.let { startActivity(it) }


        }
        btndial.setOnClickListener {
            val number="+254996563654"
            val intent=Intent(Intent.ACTION_DIAL,Uri.fromParts("tel",number,null))
            startActivity(intent)

            
        }
        btnemail.setOnClickListener {
            val emailintent=Intent(Intent.ACTION_SENDTO,Uri.fromParts("mail to ","pavanbhudiya@gmail.com",null))
            emailintent.putExtra(Intent.EXTRA_SUBJECT, "Subject")
            emailintent.putExtra(Intent.EXTRA_TEXT, "Body")
            startActivity(Intent.createChooser(emailintent, "Send email..."))

        }


    }
}