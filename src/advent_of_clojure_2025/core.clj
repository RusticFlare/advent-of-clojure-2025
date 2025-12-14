(ns advent-of-clojure-2025.core
  (:require [clojure.java.io :refer [resource]]
            [advent-of-clojure-2025.day-01]
            [advent-of-clojure-2025.day-02]
            [advent-of-clojure-2025.day-03]))

(defn read-input
  [day]
  (slurp (resource day)))

(defn -main
  "Used to dispatch tasks from the command line.

  lein run d01.p1"
  [part]
  (case part
    "d01.p1" (println (advent-of-clojure-2025.day-01/part-1 (read-input "day-01.txt")))
    "d01.p2" (println (advent-of-clojure-2025.day-01/part-2 (read-input "day-01.txt")))
    "d02.p1" (println (advent-of-clojure-2025.day-02/part-1 (read-input "day-02.txt")))
    "d02.p2" (println (advent-of-clojure-2025.day-02/part-2 (read-input "day-02.txt")))
    "d03.p1" (println (advent-of-clojure-2025.day-03/part-1 (read-input "day-03.txt")))
    "d03.p2" (println (advent-of-clojure-2025.day-03/part-2 (read-input "day-03.txt")))
    (println "not found")))
