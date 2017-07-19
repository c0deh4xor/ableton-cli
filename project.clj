(defproject ableton-cli "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}

  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/clojurescript "1.9.671"
                  :scope "provided"]]


  :plugins [[lein-environ "1.0.2"]
            [lein-cljsbuild "1.1.5"]]

  :min-lein-version "2.5.0"

  :clean-targets ^{:protect false} ["target"]

  :source-paths ["src"]

  :cljsbuild
  {:builds {:min
            {:source-paths ["src"]
             :compiler
             {:output-to "target/out/ableton-cli.js"
              :target :nodejs
              :optimizations :advanced
              :pretty-print  false}}
            :dev
            {:source-paths ["src"]
             :figwheel true
             :compiler
             {:main ableton-cli.core
              :output-to "target/out/ableton-cli.js"
              :output-dir "target/out"
              :source-map true
              :optimizations :none
              :target :nodejs
              :pretty-print  true}}
            }
   }


  :figwheel {}


  :profiles {:dev {:repl-options {:nrepl-middleware [cemerick.piggieback/wrap-cljs-repl]}

                   :dependencies [[prone "1.1.4"]
                                  [figwheel-sidecar "0.5.11"]
                                  [org.clojure/tools.nrepl "0.2.13"]
                                  [com.cemerick/piggieback "0.2.2"]]

                   :plugins [[lein-figwheel "0.5.11"]]
                   :env {:dev true}}})
