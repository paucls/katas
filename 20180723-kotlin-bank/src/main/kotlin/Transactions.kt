interface Transactions {
    fun register(transaction: Transaction)
    fun lastBalance(): Int
}
