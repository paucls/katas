class AccountService(
        private val console: Console,
        private val calendar: Calendar
) {

    private lateinit var transactions: Transactions

    constructor(console: Console, calendar: Calendar, transactions: Transactions) : this(console, calendar) {
        this.transactions = transactions
    }

    fun deposit(amount: Int) {
        transactions.register(
                Transaction(date = calendar.currentDate(), amount = amount, balance = amount)
        )
    }

    fun withdraw(amount: Int) {
        transactions.register(
                Transaction(
                        date = calendar.currentDate(),
                        amount = -amount,
                        balance = transactions.lastBalance() - amount)
        )
    }

    fun printStatement() {
    }
}