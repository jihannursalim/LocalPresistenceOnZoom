package com.example.localpresistenceonzoom.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.dataStore
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import java.util.prefs.Preferences

class UserManager (private val context : Context) {

    private val Context.dataStore by preferencesDataStore(name = "userpref")

    private val NAME = stringPreferencesKey("user_name")
    private val AGE = intPreferencesKey("user_age")

    //Simpan Data
    suspend fun saveData(nama : String, umur : Int){
        context.dataStore.edit{
            it[NAME] = nama
            it[AGE] = umur
        }
    }


}