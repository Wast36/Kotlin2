fun calculateCommission
    (cardType: String = "VK Pay",
    previousTransfers: Double = 0.0,
    transferAmount: Double): Double
{
    return when (cardType)
    {
        "MasterCard", "Maestro" ->
            {
            if (previousTransfers + transferAmount <= 75000) 0.0
            else (transferAmount * 0.006).coerceAtLeast(20.0)
        }
        "VK Pay" -> 0.0
        else  -> (transferAmount * 0.0075).coerceAtLeast(35.0) // Комиссия для карт "Мир" и "Visa"

    }
}

fun main()
{
    val amount = 76000.0
    val cardType = "Visa"
    val previousTransfers = 0.0

    val commission = calculateCommission(cardType, previousTransfers, amount)
    println("Комиссия за перевод: $commission рублей")
}