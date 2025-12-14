(ns advent-of-clojure-2025.day-02
  (:require [clojure.string :as str]))

(defn inclusive-range [[start end]]
  (range start (inc end)))

(defn to-range [input]
  (let [values (->>
                (str/split input #"-")
                (map ^[String] Long/parseLong))]
    (inclusive-range values)))

(defn duplicateSequence? [id]
  (re-matches #"(.+)\1" (Long/toString id)))

(defn repeatingSequence? [id]
  (re-matches #"(.+)\1+" (Long/toString id)))

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
