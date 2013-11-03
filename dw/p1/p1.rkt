#!/usr/bin/env racket
#lang racket
(require test-engine/racket-tests)

(define (part-sum? a k)
  (let ([n (length a)])
    (define (part-sum? index sum)
      (cond
        [(= index n) (= sum k)]
        [(part-sum? (+ index 1) sum) true]
        [(part-sum? (+ index 1) (+ sum (list-ref a index))) true] 
        [true false]))
    (part-sum? 0 0)))

(check-expect (part-sum? '(1 10 49 3 8 13 7 23 60 -500 42 599 45 -23 1 10 49 3 8 13) 444) true)
(test)
