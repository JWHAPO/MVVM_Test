package test.jw.mvvm.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import java.util.*

/**
 * MVVM_Test
 * Class: User
 * Created by JEONGWOOKIM on 2019-02-11.
 * Description:
 */
@Entity(tableName = "tauser")
class User: Observable(){

    @PrimaryKey(autoGenerate = true)
    var id: Long = 0L

    @ColumnInfo(name = "first_name")
    var firstName: String = ""
    set(value) {
        field = value
        setChangedAndNotify("firstName")
    }

    @ColumnInfo(name = "last_name")
    var lastName: String = ""
    set(value) {
        field = value
        setChangedAndNotify("lastName")
    }

    @ColumnInfo(name = "age")
    var age: Int = 0
    set(value) {
        field = value
        setChangedAndNotify("age")
    }

    @ColumnInfo(name = "gender")
    var gender: String = ""
    set(value) {
        field = value
        setChangedAndNotify("gender")
    }


    private fun setChangedAndNotify(field: Any){
        setChanged()
        notifyObservers(field)
    }
}
