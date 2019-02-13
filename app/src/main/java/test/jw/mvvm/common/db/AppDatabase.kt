package test.jw.mvvm.common.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import test.jw.mvvm.model.User
import test.jw.mvvm.model.dao.UserDao

/**
 * MVVM_Test
 * Class: AppDatabase
 * Created by JEONGWOOKIM on 2019-02-13.
 * Description:
 */

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class AppDatabase:RoomDatabase(){

    abstract fun userDao(): UserDao

    companion object {
        var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase?{

            if(INSTANCE == null){
                synchronized(AppDatabase::class){
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                            AppDatabase::class.java, "mvvmtest")
                            .fallbackToDestructiveMigration()
                            .build()
                }
            }

            return INSTANCE
        }
        fun destroyInstance(){
            INSTANCE = null
        }
    }
}