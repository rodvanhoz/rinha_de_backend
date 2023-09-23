(ns rinha-backend-clojure.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [ring.middleware.json :refer [wrap-json-response wrap-json-body]]
            [ring.middleware.cors :refer [wrap-cors]]
            [ring.middleware.keyword-params :refer [wrap-keyword-params]]
            [ring.middleware.params :refer [wrap-params]]
            [ring.middleware.multipart-params :refer [wrap-multipart-params]]
            [ring.util.http-response :refer [ok bad-request unauthorized not-found created no-content conflict]]))

(defroutes app-routes
  (context "/api" []
    (GET "/" [] "Hello World")
    (POST "/pessoas" [] (created))
    (GET "/pessoas/:id" [] (ok))
    (GET "/pessoas" [] (ok))
    (GET "/contagem-pessoas" [] (ok {:body "100"}))))

(def app
(-> app-routes
    (wrap-defaults site-defaults)
    (wrap-keyword-params)
    (wrap-cors :access-control-allow-origin #"http://localhost:4200" :access-control-allow-methods [:get :put :post :delete])
    (wrap-json-response)
    (wrap-json-body {:keywords? true})
    (wrap-multipart-params)
    (wrap-params)))
