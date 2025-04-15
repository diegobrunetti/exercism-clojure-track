(ns dnd-character)

(def initial-hp 10)

(defn score-modifier
  "Calculates a score's modifier"
  [score]
  (int (Math/floor (/ (- score initial-hp) 2))))

(defn roll-dice []
  (+ 1 (rand-int 6)))

(defn rand-ability
  "Generates a random ability"
  []
  (let [dice-rolls (for [_ (range 1 5)] (roll-dice))]
    (reduce + (take 3 (sort > dice-rolls)))))

(def abilities [:strength :dexterity :constitution :intelligence :wisdom :charisma])

(defn rand-character
  "Generates a random character"
  []
  (let [character (zipmap abilities (repeatedly 6 rand-ability))]
    (assoc character :hitpoints (+ initial-hp (score-modifier (:constitution character))))))