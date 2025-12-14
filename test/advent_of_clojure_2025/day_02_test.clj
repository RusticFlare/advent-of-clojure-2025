(ns advent-of-clojure-2025.day-02-test
  (:require [clojure.test :refer [deftest is]]
            [advent-of-clojure-2025.day-02 :refer [part-1 part-2]]
            [clojure.java.io :refer [resource]]))

(deftest part1
  (let [expected 1227775554]
    (is (= expected (part-1 (slurp (resource "day-02-example.txt")))))))

(deftest part2
  (let [expected 4174379265]
    (is (= expected (part-2 (slurp (resource "day-02-example.txt")))))))
