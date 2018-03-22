package xyz.fabiano.montyhall

import java.util.*

class Scenario(val doors: MutableList<Door> = MutableList(3, { _ -> Door()})) {

    var chosenDoor = doors[randomChoiceNumber()]

    init {
        doors[randomChoiceNumber()].putACar()
    }

    fun openADoorWithoutACar() {
        doors
            .filter { it !== chosenDoor }
            .filter { !it.hasCar }
            .shuffled()[0]
            .open()
        doors.removeIf { it.openned }
    }

    fun changeTheChosenDoor() {
        chosenDoor = doors.filter { it !== chosenDoor }.shuffled()[0]
    }

    fun hasWinned() : Boolean {
        return chosenDoor === doorWithCar()
    }

    private fun doorWithCar(): Door? {
        return doors.find { d -> d.hasCar }
    }

    private fun randomChoiceNumber(): Int {
        return Random().nextInt(3)
    }
}