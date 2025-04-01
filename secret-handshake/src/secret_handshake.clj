(ns secret-handshake)

(defn commands [number]
  (cond-> []
    (bit-test number 0) (conj "wink")
    (bit-test number 1) (conj "double blink")
    (bit-test number 2) (conj "close your eyes")
    (bit-test number 3) (conj "jump")
    (bit-test number 4) reverse))
