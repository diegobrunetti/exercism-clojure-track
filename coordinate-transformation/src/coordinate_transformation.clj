(ns coordinate-transformation)

(defn translate2d
  "Returns a function making use of a closure to
   perform a repeatable 2d translation of a coordinate pair."
  [dx dy]
  (fn [x y] [(+ x dx) (+ y dy)]))

(defn scale2d
  "Returns a function making use of a closure to
   perform a repeatable 2d scale of a coordinate pair."
  [sx sy]
  (fn [x y] [(* x sx) (* y sy)]))

(defn compose-transform
  "Create a composition function that returns a function that 
   combines two functions to perform a repeatable transformation."
  [f g]
  (fn [x y] (apply g (f x y))))

(defn memoize-transform
  "Returns a function that memoizes the last result.
   If the arguments are the same as the last call,
   the memoized result is returned."
  [f]
  (let [cached-x (atom 0)
        cached-y (atom 0)
        cached-result (atom 0)]
    (fn [x y]
      (if (and
           (= x @cached-x)
           (= y @cached-y))
        @cached-result
        (do
          (reset! cached-x x)
          (reset! cached-y y)
          (swap! cached-result (fn [_] (f x y))))))))
