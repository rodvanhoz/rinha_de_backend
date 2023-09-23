(defproject rinha_backend_clojure "0.1.0-SNAPSHOT"
  :description "Rinha de Backends - Versão CLojure"
  :url "http://example.com/FIXME"
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [compojure "1.6.1"]
                 [ring/ring-defaults "0.3.2"]
                 [ring-cors "0.1.13"]
                 [toucan "1.15.1"]
                 [environ "1.1.0"]
                 [org.postgresql/postgresql "42.1.4"]
                 [metosin/ring-http-response "0.9.0"]]
  :plugins [[lein-ring "0.12.5"]]
  :ring {:handler rinha-backend-clojure.handler/app}
         :port 8080
  :profiles
  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring/ring-mock "0.3.2"]
                        [ring/ring-json "0.4.0"]]
         :enviroment                     "dev"
         :database-user                  "postgres"
         :database-password              "Geforce560ti"
         :database-name                  "rinha_backend"
         :database-host                  "192.168.15.13"
         :database-port                  "5432"}})
