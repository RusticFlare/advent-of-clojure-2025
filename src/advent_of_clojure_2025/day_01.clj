(ns advent-of-clojure-2025.day-01
  (:require [clojure.string :as str]))

(defn flip [f]
  (fn [& args]
    (apply f (reverse args))))

(defprotocol Instruction
  (nextPosition [instruction previousPosition])
  (nextRange [instruction previousRange]))

(defrecord Left [amount]
  Instruction
  (nextPosition [_ previousPosition] (mod (- previousPosition amount) 100))
  (nextRange [_ previousRange] (take amount (iterate dec (dec (last previousRange))))))

(defrecord Right [amount]
  Instruction
  (nextPosition [_ previousPosition] (mod (+ previousPosition amount) 100))
  (nextRange [_ previousRange] (take amount (iterate inc (inc (last previousRange))))))

(defn to-instruction
  [input]
  (case (get input 0)
    \L (Left. (Integer/parseInt (subs input 1)))
    \R (Right. (Integer/parseInt (subs input 1)))))

(defn part-1
  "Day 01 Part 1"
  [input]
  (->>
   (str/split-lines input)
   (map to-instruction)
   (reductions (flip nextPosition) 50)
   (filter zero?)
   (count)))

(defn part-2
  "Day 01 Part 2"
  [input]
  (->>
   (str/split-lines input)
   (map to-instruction)
   (reductions (flip nextRange) (range 50 51))
   (flatten)
   (map #(mod % 100))
   (filter zero?)
   (count)))
