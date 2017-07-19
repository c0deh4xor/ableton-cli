(ns ableton-cli.blessed
  [:require [cljs.nodejs :as nodejs]])

(def blessed (nodejs/require "blessed"))

(defn init []
  (.screen blessed #js{:autoPadding true
                       :smartCSR true
                       :title "Ableton CLI"}))

(defn box [params]
  (.box blessed (js-obj params)))

(defn key- [screen keys fun]
  (doto screen (.key (apply array keys) fun)))
