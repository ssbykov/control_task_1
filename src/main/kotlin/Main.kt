fun main() {
    println("Проверка секунд")
    for (i in (0..60)) {

        println("$i: ${agoToText(i)}")
    }
    println("проверка минут")
    for (i in (1..60)) {

        println("$i: ${agoToText(i * 60 + 1)}")

    }
    println("проверка часов")
    for (i in (1..24)) {

        println(agoToText(i * 60 * 60 + 1))
    }
    println(agoToText(24 * 60 * 60 + 1))
    println(agoToText(72 * 60 * 60 - 1))
    println(agoToText(72 * 60 * 60 + 1))
}

fun agoToText(seconds: Int) = when (seconds) {
        in (0..60) -> "только что"
        in (61..60 * 60) -> "${agoToMinutes(seconds / 60)} назад"
        in (60 * 60 + 1..24 * 60 * 60) -> "${agoToHours(seconds / (60 * 60))} назад"
        in (24 * 60 * 60 + 1..48 * 60 * 60) -> "вчера"
        in (48 * 60 * 60 + 1..72 * 60 * 60) -> "позавчера"
        else -> "давно"
}

fun agoToMinutes(minutes: Int) = when {
    minutes % 10 == 1 && minutes != 11 -> "$minutes минуту"
    minutes % 10 in (2..4) && minutes !in (12..14) -> "$minutes минуты"
    else -> "$minutes минут"
}


fun agoToHours(hours: Int) = when {
    hours % 10 == 1 && hours != 11 -> "$hours час"
    hours % 10 in (2..4) && hours !in (12..14) -> "$hours часа"
    else -> "$hours часов"
}
