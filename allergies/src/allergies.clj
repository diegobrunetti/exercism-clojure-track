(ns allergies)

(defn allergies
  "Returns all allergens associated with the score"
  [score]
  (cond-> []
    (bit-test score 0) (conj :eggs)
    (bit-test score 1) (conj :peanuts)
    (bit-test score 2) (conj :shellfish)
    (bit-test score 3) (conj :strawberries)
    (bit-test score 4) (conj :tomatoes)
    (bit-test score 5) (conj :chocolate)
    (bit-test score 6) (conj :pollen)
    (bit-test score 7) (conj :cats)))

(defn allergic-to?
  "Returns true if the score indicates an allergy to the allergen; otherwise, returns false"
  [score allergen]
  (contains? (set (allergies score)) allergen))