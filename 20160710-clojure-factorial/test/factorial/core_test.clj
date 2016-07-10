(ns factorial.core-test
  (:require [clojure.test :refer :all]
            [factorial.core :refer :all]))

(deftest factorial-of-1
  (testing "factorial of 1 is 1"
    (is (= 1 (factorial 1)))))
