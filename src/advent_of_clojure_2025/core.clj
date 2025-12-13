(ns advent-of-clojure-2025.core
  (:require [advent-of-clojure-2025.day-01]))

(defn read-input
  [day]
  (slurp (clojure.java.io/resource day)))

(defn -main
  "Used to dispatch tasks from the command line.

  lein run d01.p1"
  [part]
  (case part
    "d01.p1" (println (advent-of-clojure-2025.day-01/part-1 (read-input "day-01.txt")))
    "d01.p2" (println (advent-of-clojure-2025.day-01/part-2 (read-input "day-01.txt")))
    (println "not found")))
