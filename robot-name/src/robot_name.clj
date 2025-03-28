(ns robot-name)

(def unique-names (atom #{}))

(defn random-between [min max]
  (shuffle (range (int min) (inc (int max)))))

(defn two-letters []
  (map char (take 2 (random-between \A \Z))))

(defn three-digits []
  (take 3 (random-between 0 9)))

(defn create-random-name []
  (let [new-name (apply str (flatten [(two-letters) (three-digits)]))]
    (if (contains? @unique-names new-name)
      (recur)
      (do
        (swap! unique-names conj new-name)
        new-name))))

(defn robot []
  (atom {:name (create-random-name)}))

(defn robot-name [robot]
  (:name @robot))

(defn reset-name [robot]
  (reset! robot {:name (create-random-name)}))
