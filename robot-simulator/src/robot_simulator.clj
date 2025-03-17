(ns robot-simulator)

(def turns-map {:west  {:right :north, :left :south}
                :east  {:right :south, :left :north}
                :north {:right :east, :left :west}
                :south {:right :west, :left :east}})

(defn turn [robot-state turn-to]
  (assoc robot-state, :bearing ((turns-map (robot-state :bearing)) turn-to)))

(defn advance [robot-state]
  (let [bearing (robot-state :bearing)]
    (case bearing
      :west  (update-in robot-state [:coordinates :x] dec)
      :east  (update-in robot-state [:coordinates :x] inc)
      :north (update-in robot-state [:coordinates :y] inc)
      :south (update-in robot-state [:coordinates :y] dec))))

(defn command [robot-state instruction]
  (case instruction
    \R (turn robot-state :right)
    \L (turn robot-state :left)
    \A (advance robot-state)))

(defn robot
  "Creates a robot at the given coordinates, facing the given direction."
  [coordinates direction]
  {:bearing direction, :coordinates coordinates})

(defn simulate
  "Simulates the robot's movements based on the given instructions
  and updates its state."
  [instructions robot-state]
  (reduce command robot-state instructions))
