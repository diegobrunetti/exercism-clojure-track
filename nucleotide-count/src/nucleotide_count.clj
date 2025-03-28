(ns nucleotide-count)

(defn count-of-nucleotide-in-strand [nucleotide strand]
  {:pre [(contains? #{\A \T \G \C} nucleotide)]}
  (count (filter #(= nucleotide %) strand)))

(defn nucleotide-counts [strand]
  {\A (count-of-nucleotide-in-strand \A strand)
   \C (count-of-nucleotide-in-strand \C strand)
   \G (count-of-nucleotide-in-strand \G strand)
   \T (count-of-nucleotide-in-strand \T strand)})

;; YES, I know that the frequencies() function exists!