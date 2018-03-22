package xyz.fabiano.montyhall

class Door(var hasCar: Boolean = false, var openned: Boolean = false) {
    fun putACar() {
        hasCar = true
    }

    fun open() : Boolean {
        openned = true
        return hasCar
    }
}