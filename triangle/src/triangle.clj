(ns triangle)

(defn triangle? [a b c]
  (let [all-positive (every? pos? [a b c])
        has-valid-lenghts (and
                           (>= (+ a b) c)
                           (>= (+ a c) b)
                           (>= (+ b c) a))]
    (and all-positive has-valid-lenghts)))

(defn equilateral?
  "Returns true if the triangle with sides a, b, and c is equilateral; otherwise, returns false"
  [a b c]
  (and
   (== a b c)
   (triangle? a b c)))

(defn isosceles?
  "Returns true if the triangle with sides a, b, and c is isosceles; otherwise, returns false"
  [a b c]
  (if (triangle? a b c)
    (or
     (== a b)
     (== a c)
     (== b c))
    false))

(defn scalene?
  "Returns true if the triangle with sides a, b, and c is scalene; otherwise, returns false"
  [a b c]
  (if (triangle? a b c)
    (distinct? a b c)
    false))
