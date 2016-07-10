(ns factorial.core-test
  (:require [clojure.test :refer :all]
            [factorial.core :refer :all]))

(deftest factorial-test
  (testing "factorial of 0"
    (is (= 1 (factorial 0))))
  (testing "factorial of 1"
    (is (= 1 (factorial 1))))
  (testing "factorial of 2"
    (is (= 2 (factorial 2)))))