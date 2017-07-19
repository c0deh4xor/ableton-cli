(ns ableton-cli.ableton.core
  (:require-macros [cljs.core.async.macros :refer [go go-loop]])
  (:require [cljs.nodejs :as nodejs]
            [cljs.core.async :refer [put! chan <! >! timeout close!]]
            [ableton-cli.ableton.paths :as paths]
            [ableton-cli.ableton.util :refer [get-prop get-count]]))

(def max4node (nodejs/require "max4node"))

(defonce max-api (let [api (new max4node)]
                   (.bind api)
                   api))

(defn name-setter [state x]
  #(swap! state assoc-in [:tracks x :name] %))

(defn color-setter [state x y]
  #(swap! state assoc-in [:tracks x :clips y :color] %))

(defn get-grid [state]
  "this takes in the state of the application and
   populates the 'grid' prop with the grid"
  (let [dmn (:track-offset @state)
        rng (:scene-offset @state)]
    (for [x (range (+ 6 dmn))]
      (do
       (get-prop max-api (paths/track x) "name" (name-setter state x))
       (for [y (range (+ 6 rng))]
         (get-prop max-api (paths/clip x y) "color" (color-setter state x y)))))))
