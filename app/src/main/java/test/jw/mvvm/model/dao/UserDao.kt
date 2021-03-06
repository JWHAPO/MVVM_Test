package test.jw.mvvm.model.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import android.arch.persistence.room.Query
import io.reactivex.Observable
import io.reactivex.Single
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
    fun getAll(): Single<List<User>>

    @Query("SELECT * FROM TAUSER WHERE id = :id")
    fun getUserById(id: Long):Single<User>

    @Insert(onConflict = REPLACE)
    fun insert(user: User)

    @Query("DELETE FROM TAUSER")
    fun deleteAll()
}