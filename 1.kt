fun main()
{
    val secondsAgo = 123
    println(agoToText(secondsAgo))
}

fun agoToText(seconds: Int): String
{
    if (seconds in 0..60)
    {
        return "был(а) только что"
    }
    else if (seconds in 61..60 * 60)
    {
        val minutes = seconds / 60
        return "был(а) ${formatMinutes(minutes)} назад"
    }
    else if (seconds in (60 * 60 + 1)..(24 * 60 * 60))
    {
        val hours = seconds / (60 * 60)
        return "был(а) ${formatHours(hours)} назад"
    }
    else if (seconds in (24 * 60 * 60 + 1)..(2 * 24 * 60 * 60))
    {
        return "был(а) вчера"
    }
    else if (seconds in (2 * 24 * 60 * 60 + 1)..(3 * 24 * 60 * 60))
    {
        return "был(а) позавчера"
    }
    else
    {
        return "был(а) давно"
    }
}

fun formatMinutes(minutes: Int): String
{
    val lastDigit = minutes % 10
    val lastTwoDigits = minutes % 100

    if (lastTwoDigits in 11..14)
    {
        return "$minutes минут"
    }
    else if (lastDigit == 1)
    {
        return "$minutes минуту"
    }
    else if (lastDigit in 2..4)
    {
        return "$minutes минуты"
    }
    else
    {
        return "$minutes минут"
    }
}

fun formatHours(hours: Int): String
{
    val lastDigit = hours % 10
    val lastTwoDigits = hours % 100

    if (lastTwoDigits in 11..14)
    {
        return "$hours часов"
    }
    else if (lastDigit == 1)
    {
        return "$hours час"
    }
    else if (lastDigit in 2..4)
    {
        return "$hours часа"
    }
    else
    {
        return "$hours часов"
    }
}