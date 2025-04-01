(ns resistor-color)

(def colors ["black" "brown" "red" "orange" "yellow" "green" "blue" "violet" "grey" "white"])
(def resistance-values (zipmap colors (range 0 10)))

(defn color-code
  "Returns the numerical value associated with the given color"
  [color]
  (resistance-values color))
