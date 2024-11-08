package com.example.a394hw.data

import android.content.Context
import com.example.a394hw.R
import com.example.a394hw.model.Game


class DataSource(val context: Context) {
    fun getGameTitleList(): Array<String>{
        return context.resources.getStringArray(R.array.title_array)
    }
    fun getGameDeveloperList(): Array<String>{
        return context.resources.getStringArray(R.array.developer_array)
    }
    fun getGameDescriptionList(): Array<String>{
        return context.resources.getStringArray(R.array.description_array)
    }

    fun loadGames(): List<Game>{
        val titleList = getGameTitleList()
        val developerList = getGameDeveloperList()
        val descriptionList  = getGameDescriptionList()

        val games = mutableListOf<Game>()
        for (i in titleList.indices){
            games.add(Game(titleList[i], developer = developerList[i], description = descriptionList[i]))
        }
        return games
    }
}