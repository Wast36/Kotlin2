import java.util.*

fun calculateCommission (cardType: String = "VK Pay", previousTransfers: Double = 0.0, transferAmount: Double): Double
{
    return when (cardType.lowercase(Locale.getDefault()))
    {
        "mastercard", "maestro" ->
        {
            if (previousTransfers + transferAmount <= 75000) 0.0
            else (transferAmount * 0.006).coerceAtLeast(20.0)
        }
        "vk pay" -> 0.0
        "мир" , "visa" -> (transferAmount * 0.0075).coerceAtLeast(35.0) // Комиссия для карт "Мир" и "Visa"
        else -> -1.0

    }
}

fun main()
{
    val amount = 86000.0
    val cardType = "vk pay"
    val previousTransfers = 0.0

    val commission = calculateCommission(cardType, previousTransfers, amount)
    println("Комиссия за перевод: $commission рублей")
}
