package com.eneszeydan.hipointernshipcase.viewmodels

import android.content.Context
import android.content.res.AssetManager
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.eneszeydan.hipointernshipcase.models.Hipo
import com.eneszeydan.hipointernshipcase.models.HipoResponse
import com.eneszeydan.hipointernshipcase.models.Members
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.File
import java.io.FileWriter
import java.io.IOException
import java.io.PrintWriter

class HomepageFragmentViewModel : ViewModel() {
    //I use livedata so the UI can react to changes in the data
    lateinit var response: HipoResponse
    var membersList = MutableLiveData<List<Members>>()

    init {
        membersList = getMembers()
    }

    private fun getMembers(): MutableLiveData<List<Members>> {
        return membersList
    }

    fun getAllMembers(context: Context) {
        //I used this method to read members from the json file, it uses bufferedReader() to read the json file
        //and then uses Gson to convert it into a HipoResponse object
        lateinit var jsonString: String
        try {
            jsonString = context.assets.open("hipo.json")
                .bufferedReader()
                .use { it.readText() }
        } catch (ioe: IOException) {
            Log.e("Exception", ioe.localizedMessage)
        }

        val type = object : TypeToken<HipoResponse>() {}.type
        val gson = Gson()
        response = gson.fromJson(jsonString, type)
        membersList.value = response.members
    }

    fun addNewMember() {
        //Adding the new member (me) into the livedata's value, it shows up in the UI automatically
        val newMemberHipo = Hipo("Android Intern", 0)
        val newMember = Members("Enes Zeydan", 22, "Mersin", "eneszeydan13", newMemberHipo)
        membersList.value = membersList.value?.plus(newMember)
        val newResponse = response
        newResponse.members = membersList.value as ArrayList<Members>
    }

    fun searchMembers(keyword: String): ArrayList<Members> {
        val result = ArrayList<Members>()
        //Searching for member names in the livedata, using lowercase() method to get better results
        for (m in membersList.value!!) {
            if (m.name?.lowercase()!!.contains(keyword)) {
                result.add(m)
            }
        }
        return result

    }


}