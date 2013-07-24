(ns p1.core-test
  (:require [clojure.test :refer :all]
            [p1.core :refer :all]
            [p1.data :refer [a k]]))

(deftest test-part_sum? []
  (testing "core/part-sum?"
    (is (= true (part-sum? a k))))) 
