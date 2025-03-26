(ns space-age)

(def orbital-period-in-earth-days {:mercury (/ 1.0 0.2408467)
                                   :venus (/ 1.0 0.61519726)
                                   :earth 1.0
                                   :mars (/ 1.0 1.8808158)
                                   :jupiter (/ 1.0 11.862615)
                                   :saturn (/ 1.0 29.447498)
                                   :uranus (/ 1.0 84.016846)
                                   :neptune (/ 1.0 164.79132)})

(def earth-year-in-seconds 31557600)

(defn space-age [planet seconds]
  (let [earth-years (/ seconds earth-year-in-seconds)]
    (* earth-years (planet orbital-period-in-earth-days))))

(defn on-mercury
  "Returns someone's age on Mercury based on the given age in seconds"
  [seconds]
  (space-age :mercury seconds))

(defn on-venus
  "Returns someone's age on Venus based on the given age in seconds"
  [seconds]
  (space-age :venus seconds))

(defn on-earth
  "Returns someone's age on Earth based on the given age in seconds"
  [seconds]
  (space-age :earth seconds))

(defn on-mars
  "Returns someone's age on Mars based on the given age in seconds"
  [seconds]
  (space-age :mars seconds))

(defn on-jupiter
  "Returns someone's age on Jupiter based on the given age in seconds"
  [seconds]
  (space-age :jupiter seconds))

(defn on-saturn
  "Returns someone's age on Saturn based on the given age in seconds"
  [seconds]
  (space-age :saturn seconds))

(defn on-uranus
  "Returns someone's age on Uranus based on the given age in seconds"
  [seconds]
  (space-age :uranus seconds))

(defn on-neptune
  "Returns someone's age on Neptune based on the given age in seconds"
  [seconds]
  (space-age :neptune seconds))
