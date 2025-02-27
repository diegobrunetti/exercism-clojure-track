(ns bird-watcher)

(def last-week [0, 2, 5, 3, 7, 8, 4])

(defn today [birds] (peek birds))

(defn last-index [birds]
  (dec (count birds)))

(defn inc-bird [birds]
  (update birds (last-index birds) inc))

(defn day-without-birds? [birds]
  (not (every? pos? birds)))

(defn n-days-count [birds n]
  (reduce + (take n birds)))

(defn busy-days [birds]
  (->> birds
       (filter (fn [bird-count] (>= bird-count 5)))
       (count)))

(defn odd-week? [birds]
  (= birds [1 0 1 0 1 0 1]))
