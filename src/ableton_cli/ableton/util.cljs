(ns ableton-cli.ableton.util
  (:require-macros [cljs.core.async.macros :refer [go go-loop]])
  (:require [cljs.core.async :refer [put! chan >! <! close!]]))

(defn get-prop [api path prop cb]
  (-> api
      (.get #js{:path path
                :property prop})
      (.once "value" #(cb %))))

(defn observe-prop [api path prop cb]
  (-> api
      (.observe #js{:path path
                    :property prop})
      (.on "value" #(cb %))))

(defn get-count [api path prop cb]
  (-> api
      (.count #js{:path path
                  :property prop})
      (.once "value" #(cb %))))
