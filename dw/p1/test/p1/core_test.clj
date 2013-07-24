(ns p1.core-test
  (:require [clojure.test :refer :all]
            [p1.core :refer :all]))

(deftest test-part_sum? []
  (testing "core/part-sum?"
    (let
      [a [1 10 49 3 8 13 7 23 60 -500 42 599 45 -23 1 10 49 3  8 13]
       k 444]
      (is (= true (part-sum? [1, 10, 49, 3, 8, 13, 7, 23, 60, -500, 42, 599, 45, -23, 1, 10, 49, 3 , 8,13] 444)))))) 
