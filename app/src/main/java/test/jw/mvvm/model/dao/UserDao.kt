package test.jw.mvvm.model.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import android.arch.persistence.room.Query
import test.jw.mvvm.model.User

/**
 * MVVM_Test
 * Class: UserDao
 * Created by JEONGWOOKIM on 2019-02-13.
 * Description:
 */

@Dao
interface UserDao{
    @Query("SELECT * FROM TAUSER")
    fun getAll(): List<User>

    @Insert(onConflict = REPLACE)
    fun insert(car: User)

    @Query("DELETE FROM TAUSER")
    fun deleteAll()
}