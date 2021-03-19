package com.web.weather.db

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

class MigrationHelper : Migration(1,2) {

    override fun migrate(database: SupportSQLiteDatabase) {

        val TABLE_NAME_TEMP = "weather_table_new"
        val TABLE_NAME = "weather_table"

        database.execSQL("""
                CREATE TABLE weather_table_new (
                    wt_name TEXT PRIMARY KEY NOT NULL,
                    wt_id INTEGER,
                    wt_dt INTEGER,
                    wt_cod INTEGER,
                    lon REAL,
                    lat REAL,
                    wt_visibility INTEGER,
                    weather TEXT,
                    temp REAL,
                    tempMin REAL,
                    humidity INTEGER,
                    pressure INTEGER,
                    tempMax REAL,
                    cd_all INTEGER,
                    country TEXT,
                    sunrise INTEGER,
                    sunset INTEGER,
                    sys_id INTEGER,
                    type INTEGER,
                    message REAL,
                    deg  INTEGER,
                    speed REAL,
                    wt_base TEXT
                )
                """.trimIndent())

        database.execSQL("""
                INSERT INTO weather_table_new (wt_name ,
                    wt_id,
                    wt_dt,
                    wt_cod,
                    lon,
                    lat,
                    wt_visibility,
                    weather,
                    temp,
                    tempMin,
                    humidity,
                    pressure,
                    tempMax,
                    cd_all,
                    country,
                    sunrise,
                    sunset,
                    sys_id,
                    type,
                    message,
                    deg,
                    speed)
                SELECT  wt_name,
                    wt_id,
                    wt_dt,
                    wt_cod,
                    lon,
                    lat,
                    wt_visibility,
                    weather,
                    temp,
                    tempMin,
                    humidity,
                    pressure,
                    tempMax,
                    cd_all,
                    country,
                    sunrise,
                    sunset,
                    sys_id,
                    type,
                    message,
                    deg,
                    speed FROM weather_table
                """.trimIndent())


        // 3. Remove the old table
        database.execSQL("DROP TABLE $TABLE_NAME")

        // 4. Change the table name to the correct one
        database.execSQL("ALTER TABLE $TABLE_NAME_TEMP RENAME TO $TABLE_NAME")
    }

}