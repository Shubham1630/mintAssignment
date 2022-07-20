package com.srp.assignment.utils

import android.content.Context
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.TypeToken
import com.google.gson.Gson
import com.srp.assignment.model.comments.CommentsItem
import com.srp.assignment.model.okHttpIssues.SquareIssuesDataClassItem
import java.lang.reflect.Type

class SharedPreferences {


    companion object {
        fun saveIssuesList(context: Context, arrayList: List<Any>) {
            val sharedPreference =
                context.getSharedPreferences("PREFERENCE_NAME", Context.MODE_PRIVATE)
            val gson = Gson()
            val json = gson.toJson(arrayList)
            val editor = sharedPreference.edit()
            editor.putString(Constants.SHARED_PREFERENCE_KEY_ISSUES, json)
            editor.commit()


        }

        fun getIssuesList(context: Context): ArrayList<SquareIssuesDataClassItem> {
            val arrayList: ArrayList<SquareIssuesDataClassItem> =
                ArrayList<SquareIssuesDataClassItem>()


            val sharedPreference =
                context.getSharedPreferences("PREFERENCE_NAME", Context.MODE_PRIVATE)
            val json: String? =
                sharedPreference.getString(Constants.SHARED_PREFERENCE_KEY_ISSUES, "")
            val gson = Gson()
            val type: Type =
                object : TypeToken<java.util.ArrayList<SquareIssuesDataClassItem?>?>() {}.getType()

            return if (json != null && json.isNotEmpty()) {
                gson.fromJson(json, type)
            } else {
                arrayList
            }


        }


        fun saveCommentList(context: Context, arrayList: List<Any>, comment: String) {
            val sharedPreference =
                context.getSharedPreferences("PREFERENCE_NAME", Context.MODE_PRIVATE)
            val gson = Gson()
            val json = gson.toJson(arrayList)
            val editor = sharedPreference.edit()
            editor.putString(comment, json)
            editor.commit()
        }


        fun getCommentList(context: Context, comment: String): ArrayList<CommentsItem> {
            val arrayList: ArrayList<CommentsItem> =
                ArrayList<CommentsItem>()
            val sharedPreference =
                context.getSharedPreferences("PREFERENCE_NAME", Context.MODE_PRIVATE)
            val json: String? = sharedPreference.getString(comment, "")
            val gson = Gson()
            val type: Type =
                object : TypeToken<java.util.ArrayList<CommentsItem?>?>() {}.getType()

            return if (json != null && json.isNotEmpty()) {
                gson.fromJson(json, type)
            } else {
                arrayList
            }
        }


    }


}