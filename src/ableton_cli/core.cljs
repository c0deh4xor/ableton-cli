(ns ableton-cli.core
  (:require [cljs.nodejs :as nodejs]
            [ableton-cli.ableton.core :as ableton]
            [ableton-cli.blessed :as blessed]))

(nodejs/enable-util-print!)
(println "Bello from the Node!")

(defonce screen (blessed/init))
(defonce state (atom {:track-offset 0
                      :scene-offset 0}))

;; Bindings
(-> screen
    (blessed/key- ["p"] #(println @state))
    (blessed/key- ["escape" "q" "C-c"] #(.exit js/process 0)))

(ableton/get-grid state)

(defn -main []
  nil)

(set! *main-cli-fn* -main)

