# Theatre Company Refactoring Kata

Imagine a company of theatrical players who go out to various events performing plays. Typically, a customer will 
request a few plays and the company charges them based on the size of the audience and the kind of play they perform. 
There are currently two kinds of plays that the company performs: tragedies and comedies. As well as providing a bill 
for the performance, the company gives its customers "volume credits" which they can use for discounts on future 
performances—think of it as a customer loyalty mechanism.

The performers store data about their plays in a simple JSON file that looks something like this:

plays.json
```
  {
    "hamlet": {"name": "Hamlet", "type": "tragedy"},
    "as-like": {"name": "As You Like It", "type": "comedy"},
    "othello": {"name": "Othello", "type": "tragedy"}
  }
```
  
The data for their bills also comes in a JSON file:

invoices.json
```
  [
    {
      "customer": "BigCo",
      "performances": [
        {
          "playID": "hamlet",
          "audience": 55
        },
        {
          "playID": "as-like",
          "audience": 35
        },
        {
          "playID": "othello",
          "audience": 40
        }
      ]
    }
  ]
```

The code that prints the bill is this simple function:

```
  function statement (invoice, plays) {
    ...
  }
```
  
Running that code on the test data files above results in the following output:

```
  Statement for BigCo
    Hamlet: $650.00 (55 seats)
    As You Like It: $580.00 (35 seats)
    Othello: $500.00 (40 seats)
  Amount owed is $1,730.00
  You earned 47 credits
```

## Acknowlegements

This kata is based in the first code example in Martin Fowler's book "Refactoring, 2nd Edition".
