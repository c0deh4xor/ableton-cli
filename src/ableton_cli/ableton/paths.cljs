(ns ableton-cli.ableton.paths)

(defn track [i]
  (str "live_set tracks " i))

(defn clip-slot [i j]
  (str "live_set tracks " i " clip_slots " j))

(defn clip [i j]
  (str "live_set tracks " i " clip_slots " j " clip"))
