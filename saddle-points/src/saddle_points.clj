(ns saddle-points)

(defn- find-saddle-points [matrix]
  (let [row-max (mapv (partial apply max) matrix)
        col-min (apply mapv min matrix)]
    (for [i (range (count matrix))
          j (range (count (first matrix)))
          :when (= (get-in matrix [i j])
                   (get row-max i)
                   (get col-min j))]
      [(inc i) (inc j)])))

(defn saddle-points
  "Returns the saddle points of a matrix"
  [matrix]
  (if (empty? matrix)
    #{}
    (set (find-saddle-points matrix))))
