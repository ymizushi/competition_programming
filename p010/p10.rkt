#!/usr/bin/env racket
#lang racket
(require test-engine/racket-tests)

(define (prime? n)
  (cond 
    [(not (integer? n)) (begin (print "n must be integer!") false)]
    [(= n 1) false]
    [(= n 2) true]
    [else 
      (let loop ([cnt 2])
        (if (<= cnt (round (sqrt n)))
          (if (= (remainder n cnt) 0)
            false
            (loop (add1 cnt)))
          true))]))
(check-expect (prime? 1) false)
(check-expect (prime? 2) true)
(check-expect (prime? 3) true)
(check-expect (prime? 19) true)

(define (sum-prime-list n)
   (let loop ([i 1] [sum 0])
     (if (< i n)
       (if (prime? i)
         (loop (add1 i) (+ i sum))
         (loop (add1 i) sum))
       sum)))

(check-expect (sum-prime-list 10) 17)
(check-expect (sum-prime-list 2000000) 142913828922)

(test)
