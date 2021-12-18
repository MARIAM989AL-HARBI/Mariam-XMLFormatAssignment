package com.example.mariam_xmlformatassignment

import org.xmlpull.v1.XmlPullParser
import org.xmlpull.v1.XmlPullParserException
import org.xmlpull.v1.XmlPullParserFactory
import java.io.IOException
import java.io.InputStream

class MyXmlPullParserHandler {
    private val students = ArrayList<Student>() // Arrylist
    private var text = ""
    private var id = 0
    private var name = ""
    private var grade = 0f // mark

    fun parse(inputStream: InputStream): ArrayList<Student>{ // fun parse >>one p>>inputStream
        try{                                                  //rtunen arraylist student
            val factory = XmlPullParserFactory.newInstance()
            val parser = factory.newPullParser()
            parser.setInput(inputStream, null) // setinput..stream
            var eventType = parser.eventType

            while(eventType != XmlPullParser.END_DOCUMENT){ // while loop
                val tagName = parser.name
                when(eventType){
                    XmlPullParser.TEXT -> text = parser.text
                    XmlPullParser.END_TAG -> when {
                        tagName.equals("id", true) -> id = text.toInt()
                        tagName.equals("name", true) -> name = text
                        tagName.equals("grade", true) -> {
                            grade = text.toFloat()
                            students.add(Student(id, name, grade))
                        }
                        else -> {}
                    }
                    else -> {}
                }
                eventType = parser.next()
            }
        }catch(e: XmlPullParserException){   // here excption
            e.printStackTrace()
        }catch(e: IOException){
            e.printStackTrace()
        }
        return students    // return list
    }
}

