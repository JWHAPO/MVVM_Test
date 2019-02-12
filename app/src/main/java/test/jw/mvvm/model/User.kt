package test.jw.mvvm.model

import java.util.*

/**
 * MVVM_Test
 * Class: User
 * Created by JEONGWOOKIM on 2019-02-11.
 * Description:
 */
class User: Observable(){
    var firstName: String = ""
    set(value) {
        field = value
        setChangedAndNotify("firstName")
    }

    var lastName: String = ""
    set(value) {
        field = value
        setChangedAndNotify("lastName")
    }

    var age: Int = 0
    set(value) {
        field = value
        setChangedAndNotify("age")
    }

    var female: Boolean = false
    set(value) {
        field = value
        setChangedAndNotify("female")
    }


    private fun setChangedAndNotify(field: Any){
        setChanged()
        notifyObservers(field)
    }
}
