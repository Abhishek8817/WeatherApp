package com.web.weather.db

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

class MigrationHelper : Migration(1,2) {

    override fun migrate(database: SupportSQLiteDatabase) {

        val TABLE_NAME_TEMP = "weather_table_new"
        val TABLE_NAME = "weather_table"

//        //1. Create the new table
//        database.execSQL(
//            "CREATE TABLE $TABLE_NAME_TEMP (wt_id TEXT ," +
//                    "wt_name TEXT ," +
//                    "wt_dt INTEGER ," +
//                    "wt_cod INTEGER ," +
//                    "PRIMARY KEY(wt_name))");
//        //2.Copy the data
//        database.execSQL(
//            "INSERT INTO $TABLE_NAME_TEMP (wt_id, wt_name) SELECT wt_id, wt_name FROM $TABLE_NAME");


        database.execSQL("""
                CREATE TABLE weather_table_new (
                    wt_name TEXT PRIMARY KEY NOT NULL,
                    wt_id INTEGER,
                    wt_dt INTEGER,
                    wt_cod INTEGER
                )
                """.trimIndent())

        database.execSQL("""
                INSERT INTO weather_table_new (wt_name, wt_id)
                SELECT wt_name, wt_id FROM weather_table
                """.trimIndent())


        // 3. Remove the old table
        database.execSQL("DROP TABLE $TABLE_NAME")

        // 4. Change the table name to the correct one
        database.execSQL("ALTER TABLE $TABLE_NAME_TEMP RENAME TO $TABLE_NAME")
    }

}