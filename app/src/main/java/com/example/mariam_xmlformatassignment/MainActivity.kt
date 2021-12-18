package com.example.mariam_xmlformatassignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.io.IOException

class MainActivity : AppCompatActivity() {
    private lateinit var rvMain: RecyclerView
    private lateinit var rvAdapter: StudentAdapter
    private lateinit var students: List<Student>
////////////////////////////////////////////////م
    override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    students = listOf()
    rvMain = findViewById(R.id.rvMain)
    rvAdapter = StudentAdapter(students)
    rvMain.adapter = rvAdapter
    rvMain.layoutManager = LinearLayoutManager(this)

    parseXML()
}
////////////////////////////////////////////////////////////
    private fun parseXML(){  // fun parseXMl
        try{
            val parser = MyXmlPullParserHandler()  // ملف
            val iStream = assets.open("student_details.xml") // open file
            students = parser.parse(iStream)
            rvAdapter.update(students)
        }catch(e: IOException){ // anyExeption
            println("ISSUE: $e")
        }
    }
}
/////////////////////////////////////////////////////////////


