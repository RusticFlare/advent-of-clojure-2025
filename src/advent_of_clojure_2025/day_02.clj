(ns advent-of-clojure-2025.day-02
  (:require [clojure.string :as str]))

(defn to-range [input]
  (let [values (->>
                (str/split input #"-")
                (map ^[String] Long/parseLong))]
    (range (nth values 0) (inc (nth values 1)))))

(defn duplicateSequence? [id]
  (re-matches #"^(.+)\1$" (Long/toString id)))

(defn repeatingSequence? [id]
  (re-matches #"^(.+)\1+$" (Long/toString id)))

(defn part-1 [input]
  (->>
   (str/split input #",")
   (map to-range)
   (flatten)
   (filter duplicateSequence?)
   (reduce +)))

(defn part-2 [input]
  (->>
   (str/split input #",")
   (map to-range)
   (flatten)
   (filter repeatingSequence?)
   (reduce +)))
