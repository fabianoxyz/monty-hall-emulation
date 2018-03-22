package xyz.fabiano.montyhall

fun main(args: Array<String>) {

    simulate(changingTheDoor = false)
    simulate(changingTheDoor = true)

}

const val SIMULATION_TIMES = 100_000

fun simulate(changingTheDoor: Boolean = true) {
    var timesWinned = 0
    (0..SIMULATION_TIMES).forEach {
        val scenario = Scenario()
        scenario.openADoorWithoutACar()
        if(changingTheDoor) {
            scenario.changeTheChosenDoor()
        }
        if(scenario.hasWinned()) timesWinned++
    }

    println("Had winned ${timesWinned * 100 / SIMULATION_TIMES}% of the times by ${if(changingTheDoor) "" else "not "}changing the door.")
}