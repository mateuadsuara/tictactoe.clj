(defproject tictactoe "0.1.0-SNAPSHOT"
  :description "a tictactoe implementation"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.7.0-RC2"]]
  :profiles {:dev {:dependencies [[speclj "3.3.1"]]}}
  :plugins [[speclj "3.3.1"]]
  :test-paths ["spec"]
  :target-path "target/%s"
  :main ^:skip-aot tictactoe.main)
