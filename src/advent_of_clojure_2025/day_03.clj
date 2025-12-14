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

(defn joltage [input]
  (let [batteries (->>
                   input
                   (map #(^[char int] Character/digit % 10)))
        indexed-batteries (->>
                           batteries
                           (map-indexed vector))
        [index first] (->>
                       (subsequence indexed-batteries 0 (dec (count indexed-batteries)))
                       (reduce #(if (> (second %2) (second %1)) %2 %1)))
        second (->>
                (subsequence batteries (inc index))
                (apply max))]
    (Integer/parseInt (str first second))))

(defn part-1 [input]
  (->>
   (str/split-lines input)
   (map joltage)
   (reduce +)))

(defn part-2 [input]
  input)
