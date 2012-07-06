(defproject bacnet-scan "1.0.0"
  :description "Small application to scan a BACnet network. Results
  are exported in an HTML file, ready to be sent to a webserver for
  further analysis."
  :dependencies [[org.clojure/clojure "1.3.0"]
                 [org.clojars.jarpiain/bacnet4j "1.2.0"]
                 [org.clojars.jarpiain/sero-utils "1.0.0"]
                 [clj-time "0.4.2"]
                 [hiccup "1.0.0-beta1"]
                 [seesaw "1.4.0"]
                 [org.clojure/data.codec "0.1.0"]
                 [org.clojars.frozenlock/gzip64 "1.0.0"]
                 [overtone/at-at "1.0.0"]]
  :main bacnet-scan.gui)
