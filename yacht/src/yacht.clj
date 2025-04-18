(ns yacht)

(defn- matches-pattern? [pattern dice]
  (= pattern (set (vals (frequencies dice)))))

(defn- calc-score [dice vals]
  (reduce + (filter (set vals) dice)))

(defn- score-full-house [dice]
  (if (matches-pattern? #{3 2} dice)
    (calc-score dice (distinct dice))
    0))

(defn- score-four-of-a-kind [dice]
  (if (or (matches-pattern? #{4 1} dice)
          (matches-pattern? #{5} dice))
    (let [repeated-face (->> (frequencies dice)
                             (filter #(>= (val %) 4))
                             (map key)
                             (first))]
      (* 4 repeated-face))
    0))

(defn- score-little-straight [dice]
  (if (= #{1 2 3 4 5} (set dice)) 30 0))

(defn- score-big-straight [dice]
  (if (= #{2 3 4 5 6} (set dice)) 30 0))

(defn- score-yatch [dice]
  (if (= 1 (count (distinct dice))) 50 0))

(defn score
  "Given five dice and a category, it calculates the score of the dice for that category"
  [dice category]
  (let [calc (partial calc-score dice)]
    (case category
      "ones"            (calc [1])
      "twos"            (calc [2])
      "threes"          (calc [3])
      "fours"           (calc [4])
      "fives"           (calc [5])
      "sixes"           (calc [6])
      "full house"      (score-full-house dice)
      "four of a kind"  (score-four-of-a-kind dice)
      "little straight" (score-little-straight dice)
      "big straight"    (score-big-straight dice)
      "choice"          (calc dice)
      "yacht"           (score-yatch dice)
      0)))