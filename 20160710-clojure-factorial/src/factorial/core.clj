(ns factorial.core)

(defn factorial
  "Calculates the factorial of a number."
  [n]
  (if (= 0 n)
    1
    (* n (factorial (- n 1)))))
