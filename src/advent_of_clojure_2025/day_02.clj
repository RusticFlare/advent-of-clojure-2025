(ns advent-of-clojure-2025.day-02
  (:require [clojure.string :as str]))

(defn to-range [input]
  (let [values (->>
                (str/split input #"-")
                (map ^[String] Long/parseLong))]
    (range (nth values 0) (inc (nth values 1)))))

(defn invalid? [id]
  (let [id-text (Long/toString id)
        id-text-len (count id-text)
        half-id-text-len (/ id-text-len 2)]
    (and (even? id-text-len) (= (take half-id-text-len id-text) (take-last half-id-text-len id-text)))))

(defn part-1 [input]
  (->>
   (str/split input #",")
   (map to-range)
   (flatten)
   (filter invalid?)
   (reduce +)))

(defn part-2 [input]
  input)
