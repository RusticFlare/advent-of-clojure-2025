(ns advent-of-clojure-2025.day-03
  (:require [clojure.string :as str]))

(defn subsequence
  ([s start]
   (->> s
        (drop start)))
  ([s start end]
   (->> s
        (drop start)
        (take (- end start)))))

(defn max-by [f coll]
  (reduce #(if (> (f %2) (f %1)) %2 %1) coll))

(defn joltage [input]
  (let [batteries (->>
                   input
                   (map #(^[char int] Character/digit % 10)))
        indexed-batteries (->>
                           batteries
                           (map-indexed vector))
        [first-index first] (->>
                             (subsequence indexed-batteries 0 (dec (count indexed-batteries)))
                             (max-by second))
        second (->>
                (subsequence batteries (inc first-index))
                (apply max))]
    (+ (* first 10) second)))

(defn part-1 [input]
  (->>
   (str/split-lines input)
   (map joltage)
   (reduce +)))

(defn part-2 [input]
  input)
