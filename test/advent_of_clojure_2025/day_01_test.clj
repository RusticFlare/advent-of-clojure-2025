(ns advent-of-clojure-2025.day-01-test
  (:require [clojure.test :refer [deftest testing is]]
            [advent-of-clojure-2025.day-01 :refer [part-1 part-2]]
            [clojure.java.io :refer [resource]]))

(deftest part1
  (let [expected 3]
    (is (= expected (part-1 (slurp (resource "day-01-example.txt")))))))

(deftest part2
  (let [expected 6]
    (is (= expected (part-2 (slurp (resource "day-01-example.txt")))))))
